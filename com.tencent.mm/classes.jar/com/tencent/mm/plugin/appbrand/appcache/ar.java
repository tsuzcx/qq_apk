package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ad;

public final class ar
{
  private static a iNc;
  private static ICommLibReader iNd = null;
  
  public static void a(a parama)
  {
    iNc = parama;
  }
  
  public static ICommLibReader aPR()
  {
    AppMethodBeat.i(184407);
    try
    {
      ICommLibReader localICommLibReader = iNd;
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
      iNd = paramICommLibReader;
      if (iNc != null) {
        iNc.b(paramICommLibReader);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ar
 * JD-Core Version:    0.7.0.1
 */