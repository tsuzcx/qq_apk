package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;

public final class at
{
  private static a kMg;
  private static ICommLibReader kMh = null;
  
  public static void a(a parama)
  {
    kMg = parama;
  }
  
  public static ICommLibReader bvT()
  {
    AppMethodBeat.i(184407);
    try
    {
      ICommLibReader localICommLibReader = kMh;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaCommLibPreloadSessionInMM", "getCurrentAcceptedCommLibReader [%s], stacktrace=%s", new Object[] { localICommLibReader, android.util.Log.getStackTraceString(new Throwable()) });
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
      kMh = paramICommLibReader;
      if (kMg != null) {
        kMg.b(paramICommLibReader);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at
 * JD-Core Version:    0.7.0.1
 */