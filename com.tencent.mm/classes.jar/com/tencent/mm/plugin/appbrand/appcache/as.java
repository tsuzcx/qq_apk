package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ad;

public final class as
{
  private static a jHh;
  private static ICommLibReader jHi = null;
  
  public static void a(a parama)
  {
    jHh = parama;
  }
  
  public static ICommLibReader bag()
  {
    AppMethodBeat.i(184407);
    try
    {
      ICommLibReader localICommLibReader = jHi;
      ad.i("MicroMsg.AppBrand.WxaCommLibPreloadSessionInMM", "getCurrentAcceptedCommLibReader [%s], stacktrace=%s", new Object[] { localICommLibReader, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(184407);
      return localICommLibReader;
    }
    finally
    {
      AppMethodBeat.o(184407);
    }
  }
  
  static void c(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(90567);
    try
    {
      jHi = paramICommLibReader;
      if (jHh != null) {
        jHh.b(paramICommLibReader);
      }
      AppMethodBeat.o(90567);
      return;
    }
    finally
    {
      AppMethodBeat.o(90567);
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(ICommLibReader paramICommLibReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */