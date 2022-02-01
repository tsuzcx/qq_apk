package com.tencent.mm.plugin.gwallet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.b.c;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  private boolean ssA;
  private ArrayList<String> ssB;
  private ArrayList<String> ssC;
  private int ssD;
  private b ssy = null;
  private boolean ssz;
  
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
    AppMethodBeat.i(64567);
    ad.d("MicroMsg.GWalletQueryProvider", "successfully loaded");
    AppMethodBeat.o(64567);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(64568);
    try
    {
      ad.d("MicroMsg.GWalletQueryProvider", "Creating IAB helper.");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        ad.d("MicroMsg.GWalletQueryProvider", "no product id selected or size is 0");
        paramUri = new IllegalArgumentException("no product id selected or size is 0");
        AppMethodBeat.o(64568);
        throw paramUri;
      }
    }
    finally
    {
      AppMethodBeat.o(64568);
    }
    this.mContext = getContext();
    this.ssy = new b(this.mContext);
    this.ssz = true;
    this.ssA = false;
    this.ssC = new ArrayList();
    int j = paramArrayOfString2.length;
    int i = 0;
    while (i < j)
    {
      paramUri = paramArrayOfString2[i];
      this.ssC.add(paramUri);
      i += 1;
    }
    ad.d("MicroMsg.GWalletQueryProvider", "Starting setup.");
    this.ssy.a(new b.a()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64565);
        ad.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
        if (!paramAnonymousc.isSuccess())
        {
          ad.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: ".concat(String.valueOf(paramAnonymousc)));
          GWalletQueryProvider.a(GWalletQueryProvider.this);
          if (GWalletQueryProvider.b(GWalletQueryProvider.this) != null) {
            GWalletQueryProvider.b(GWalletQueryProvider.this).dispose();
          }
          GWalletQueryProvider.c(GWalletQueryProvider.this);
          AppMethodBeat.o(64565);
          return;
        }
        g.afE().a(new aq.a()
        {
          public final boolean aus()
          {
            AppMethodBeat.i(64562);
            GWalletQueryProvider.d(GWalletQueryProvider.this);
            AppMethodBeat.o(64562);
            return true;
          }
          
          public final boolean aut()
          {
            AppMethodBeat.i(64563);
            if (GWalletQueryProvider.b(GWalletQueryProvider.this) != null) {
              GWalletQueryProvider.b(GWalletQueryProvider.this).dispose();
            }
            GWalletQueryProvider.c(GWalletQueryProvider.this);
            AppMethodBeat.o(64563);
            return true;
          }
          
          public final String toString()
          {
            AppMethodBeat.i(64564);
            String str = super.toString() + "|onIabSetupFinished";
            AppMethodBeat.o(64564);
            return str;
          }
        });
        AppMethodBeat.o(64565);
      }
    });
    long l = 0L;
    boolean bool;
    while ((l <= 30000L) && (this.ssz))
    {
      bool = this.ssA;
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
        ad.e("MicroMsg.GWalletQueryProvider", paramUri.toString());
      }
    }
    if (!this.ssz)
    {
      ad.d("MicroMsg.GWalletQueryProvider", "unable to setup");
      paramUri = new MatrixCursor(COLUMNS);
      paramArrayOfString1 = this.ssC.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10234), "", "" });
      }
      AppMethodBeat.o(64568);
      return paramUri;
    }
    if (l > 30000L)
    {
      ad.d("MicroMsg.GWalletQueryProvider", "time's out");
      paramUri = new MatrixCursor(COLUMNS);
      paramArrayOfString1 = this.ssC.iterator();
      while (paramArrayOfString1.hasNext()) {
        paramUri.addRow(new Object[] { Integer.valueOf(0), (String)paramArrayOfString1.next(), "", Integer.valueOf(10235), "", "" });
      }
      AppMethodBeat.o(64568);
      return paramUri;
    }
    ad.d("MicroMsg.GWalletQueryProvider", "successfully queried!");
    paramArrayOfString1 = new MatrixCursor(COLUMNS);
    if (this.ssD == 0)
    {
      i = 0;
      if (this.ssB != null)
      {
        paramString1 = this.ssB.iterator();
        i = 0;
        for (;;)
        {
          if (!paramString1.hasNext()) {
            break label815;
          }
          paramUri = (String)paramString1.next();
          bool = bt.isNullOrNil(paramUri);
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
              this.ssC.remove(paramUri);
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
        ad.d("MicroMsg.GWalletQueryProvider", paramUri.toString());
        break label812;
      }
    }
    label812:
    label815:
    for (;;)
    {
      paramUri = this.ssC.iterator();
      while (paramUri.hasNext())
      {
        paramArrayOfString1.addRow(new Object[] { Integer.valueOf(i), (String)paramUri.next(), "", Integer.valueOf(10233), "", "" });
        i += 1;
        continue;
        paramUri = this.ssC.iterator();
        while (paramUri.hasNext()) {
          paramArrayOfString1.addRow(new Object[] { Integer.valueOf(0), (String)paramUri.next(), "", Integer.valueOf(10236), "", "" });
        }
      }
      AppMethodBeat.o(64568);
      return paramArrayOfString1;
      break;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider
 * JD-Core Version:    0.7.0.1
 */