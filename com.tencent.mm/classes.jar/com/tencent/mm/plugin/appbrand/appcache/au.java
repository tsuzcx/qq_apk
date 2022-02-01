package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;

public final class au
{
  private static a nFZ;
  private static ICommLibReader nGa = null;
  
  public static void a(a parama)
  {
    nFZ = parama;
  }
  
  public static ICommLibReader bHb()
  {
    AppMethodBeat.i(184407);
    try
    {
      ICommLibReader localICommLibReader = nGa;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaCommLibPreloadSessionInMM", "getCurrentAcceptedCommLibReader [%s], stacktrace=%s", new Object[] { localICommLibReader, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(184407);
      return localICommLibReader;
    }
    finally
    {
      AppMethodBeat.o(184407);
    }
  }
  
  static void d(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(90567);
    try
    {
      nGa = paramICommLibReader;
      if (nFZ != null) {
        nFZ.c(paramICommLibReader);
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
    public abstract void c(ICommLibReader paramICommLibReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au
 * JD-Core Version:    0.7.0.1
 */