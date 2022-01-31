package com.tencent.mm.lib.riskscanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.d.a.c;
import com.tencent.mm.sdk.platformtools.y;

public class RiskScannerReqBufferProvider
  extends ContentProvider
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider");
  
  private Bundle bo(Context paramContext)
  {
    Bundle[] arrayOfBundle = new Bundle[1];
    arrayOfBundle[0] = null;
    try
    {
      a.EM();
      c.a(paramContext, new RiskScannerReqBufferProvider.1(this, arrayOfBundle));
      return arrayOfBundle[0];
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        a.c(paramContext);
      }
    }
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ("prepareReqBuffer".equals(paramString1))
    {
      y.i("MicroMsg.RiskScannerReqBufferProvider", "invoke method: %s, with arg: %s, extras: %s", new Object[] { paramString1, paramString2, paramBundle });
      return bo(getContext());
    }
    y.w("MicroMsg.RiskScannerReqBufferProvider", "unknown method: %s", new Object[] { paramString1 });
    return new Bundle[] { null }[0];
  }
  
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
    y.i("MicroMsg.RiskScannerReqBufferProvider", "onCreate called.");
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider
 * JD-Core Version:    0.7.0.1
 */