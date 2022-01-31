package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GWalletQueryProvider
  extends ContentProvider
{
  public static final String[] COLUMNS = { "_id", "product_id", "full_price", "product_state", "price_currency", "price_amount" };
  private final String TAG = "MicroMsg.GWalletQueryProvider";
  private Context mContext = null;
  private b nGa = null;
  private boolean nGb;
  private boolean nGc;
  private ArrayList<String> nGd;
  private ArrayList<String> nGe;
  private int nGf;
  
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
    AppMethodBeat.i(41671);
    ab.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
    AppMethodBeat.o(41671);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(41672);
    try
    {
      ab.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        ab.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
        paramUri = new IllegalArgumentException("no product id selected or size is 0");
        AppMethodBeat.o(41672);
        throw paramUri;
      }
    }
    finally
    {
      AppMethodBeat.o(41672);
    }
    this.mContext = getContext();
    this.nGa = new b(this.mContext);
    this.nGb = true;
    this.nGc = false;
    this.nGe = new ArrayList();
    int j = paramArrayOfString2.length;
    int i = 0;
    while (i < j)
    {
      paramUri = paramArrayOfString2[i];
      this.nGe.add(paramUri);
      i += 1;
    }
    ab.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
    this.nGa.a(new GWalletQueryProvider.1(this));
    long l = 0L;
    boolean bool;
    while ((l <= 30000L) && (this.nGb))
    {
      bool = this.nGc;
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
        ab.e("MicroMsg.GWalletQueryProvider", paramUri.toString());
      }
    }
    if (!this.nGb)
    {
      ab.d("MicroMsg.GWalletQueryProvider", "unable to setup");
      paramUri = new MatrixCursor(COLUMNS);
      paramArrayOfString1 = this.nGe.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10234), "", "" });
      }
      AppMethodBeat.o(41672);
      return paramUri;
    }
    if (l > 30000L)
    {
      ab.d("MicroMsg.GWalletQueryProvider", "time's out");
      paramUri = new MatrixCursor(COLUMNS);
      paramArrayOfString1 = this.nGe.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10235), "", "" });
      }
      AppMethodBeat.o(41672);
      return paramUri;
    }
    ab.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
    paramArrayOfString1 = new MatrixCursor(COLUMNS);
    if (this.nGf == 0)
    {
      i = 0;
      if (this.nGd != null)
      {
        paramString1 = this.nGd.iterator();
        i = 0;
        for (;;)
        {
          if (!paramString1.hasNext()) {
            break label815;
          }
          paramUri = (String)paramString1.next();
          bool = bo.isNullOrNil(paramUri);
          if (bool) {
            break label812;
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
              this.nGe.remove(paramUri);
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
        ab.d("MicroMsg.GWalletQueryProvider", paramUri.toString());
        break label812;
      }
    }
    label812:
    label815:
    for (;;)
    {
      paramUri = this.nGe.iterator();
      while (paramUri.hasNext())
      {
        paramArrayOfString1.addRow(new Object[] { Integer.valueOf(i), (String)paramUri.next(), "", Integer.valueOf(10233), "", "" });
        i += 1;
        continue;
        paramUri = this.nGe.iterator();
        while (paramUri.hasNext()) {
          paramArrayOfString1.addRow(new Object[] { Integer.valueOf(0), (String)paramUri.next(), "", Integer.valueOf(10236), "", "" });
        }
      }
      AppMethodBeat.o(41672);
      return paramArrayOfString1;
      break;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider
 * JD-Core Version:    0.7.0.1
 */