package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GWalletQueryProvider
  extends ContentProvider
{
  public static final String[] yY = { "_id", "product_id", "full_price", "product_state", "price_currency", "price_amount" };
  private final String TAG = "MicroMsg.GWalletQueryProvider";
  private b liL = null;
  private boolean liM;
  private boolean liN;
  private ArrayList<String> liO;
  private ArrayList<String> liP;
  private int liQ;
  private Context mContext = null;
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    y.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      y.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        y.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
        throw new IllegalArgumentException("no product id selected or size is 0");
      }
    }
    finally {}
    this.mContext = getContext();
    this.liL = new b(this.mContext);
    this.liM = true;
    this.liN = false;
    this.liP = new ArrayList();
    int j = paramArrayOfString2.length;
    int i = 0;
    while (i < j)
    {
      paramUri = paramArrayOfString2[i];
      this.liP.add(paramUri);
      i += 1;
    }
    y.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
    this.liL.a(new GWalletQueryProvider.1(this));
    long l = 0L;
    boolean bool;
    while ((l <= 30000L) && (this.liM))
    {
      bool = this.liN;
      if (bool) {
        break;
      }
      try
      {
        Thread.sleep(100L);
        l += 100L;
      }
      catch (InterruptedException paramUri)
      {
        y.e("MicroMsg.GWalletQueryProvider", paramUri.toString());
      }
    }
    if (!this.liM)
    {
      y.d("MicroMsg.GWalletQueryProvider", "unable to setup");
      paramUri = new MatrixCursor(yY);
      paramArrayOfString1 = this.liP.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10234), "", "" });
      }
      return paramUri;
    }
    if (l > 30000L)
    {
      y.d("MicroMsg.GWalletQueryProvider", "time's out");
      paramUri = new MatrixCursor(yY);
      paramArrayOfString1 = this.liP.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10235), "", "" });
      }
      return paramUri;
    }
    y.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
    paramArrayOfString1 = new MatrixCursor(yY);
    if (this.liQ == 0)
    {
      i = 0;
      if (this.liO != null)
      {
        paramString1 = this.liO.iterator();
        i = 0;
        for (;;)
        {
          if (!paramString1.hasNext()) {
            break label786;
          }
          paramUri = (String)paramString1.next();
          bool = bk.bl(paramUri);
          if (bool) {
            break label780;
          }
          try
          {
            localObject = new JSONObject(paramUri);
            paramUri = ((JSONObject)localObject).getString("productId");
            paramArrayOfString2 = ((JSONObject)localObject).getString("price");
            paramString2 = ((JSONObject)localObject).getString("price_currency_code");
            localObject = ((JSONObject)localObject).getString("price_amount_micros");
            j = i + 1;
          }
          catch (JSONException paramUri)
          {
            try
            {
              Object localObject;
              paramArrayOfString1.addRow(new Object[] { Integer.valueOf(i), paramUri, paramArrayOfString2, Integer.valueOf(10232), paramString2, localObject });
              this.liP.remove(paramUri);
              i = j;
            }
            catch (JSONException paramUri)
            {
              for (;;)
              {
                i = j;
              }
            }
            paramUri = paramUri;
          }
        }
        y.d("MicroMsg.GWalletQueryProvider", paramUri.toString());
        break label783;
      }
    }
    label780:
    label783:
    label786:
    for (;;)
    {
      paramUri = this.liP.iterator();
      while (paramUri.hasNext())
      {
        paramArrayOfString1.addRow(new Object[] { Integer.valueOf(i), (String)paramUri.next(), "", Integer.valueOf(10233), "", "" });
        i += 1;
        continue;
        paramUri = this.liP.iterator();
        while (paramUri.hasNext()) {
          paramArrayOfString1.addRow(new Object[] { Integer.valueOf(0), (String)paramUri.next(), "", Integer.valueOf(10236), "", "" });
        }
      }
      return paramArrayOfString1;
      break;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider
 * JD-Core Version:    0.7.0.1
 */