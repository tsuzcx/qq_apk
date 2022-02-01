package com.tencent.mm.lib.riskscanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.e.a.c;
import com.tencent.e.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public class RiskScannerReqBufferProvider
  extends ContentProvider
{
  public static final String AUTHORITY;
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(138303);
    AUTHORITY = WeChatAuthorities.AUTHORITIES_LIB_RISHSCANNER_RISKSCANNERREQBUFFERPROVIDER();
    CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    AppMethodBeat.o(138303);
  }
  
  private Bundle cM(Context paramContext)
  {
    AppMethodBeat.i(138302);
    final Bundle[] arrayOfBundle = new Bundle[1];
    arrayOfBundle[0] = null;
    try
    {
      a.aBA();
      c.a(paramContext, new c.a()
      {
        public final void g(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(138299);
          a.qn(paramAnonymousInt);
          Bundle[] arrayOfBundle = arrayOfBundle;
          Bundle localBundle = new Bundle();
          arrayOfBundle[0] = localBundle;
          if ((paramAnonymousInt == 0) && (paramAnonymousArrayOfByte != null))
          {
            localBundle.putInt("errCode", paramAnonymousInt);
            localBundle.putByteArray("reqBufferBase64", paramAnonymousArrayOfByte);
          }
          AppMethodBeat.o(138299);
        }
      });
      paramContext = arrayOfBundle[0];
      AppMethodBeat.o(138302);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        a.f(paramContext);
      }
    }
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(138301);
    if ("prepareReqBuffer".equals(paramString1))
    {
      Log.i("MicroMsg.RiskScannerReqBufferProvider", "invoke method: %s, with arg: %s, extras: %s", new Object[] { paramString1, paramString2, paramBundle });
      paramString1 = cM(getContext());
      AppMethodBeat.o(138301);
      return paramString1;
    }
    Log.w("MicroMsg.RiskScannerReqBufferProvider", "unknown method: %s", new Object[] { paramString1 });
    paramString1 = new Bundle[] { null }[0];
    AppMethodBeat.o(138301);
    return paramString1;
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
    AppMethodBeat.i(138300);
    Log.i("MicroMsg.RiskScannerReqBufferProvider", "onCreate called.");
    AppMethodBeat.o(138300);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider
 * JD-Core Version:    0.7.0.1
 */