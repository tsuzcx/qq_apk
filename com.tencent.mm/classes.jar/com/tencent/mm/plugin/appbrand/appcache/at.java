package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ae;

public final class at
{
  private static a jKh;
  private static ICommLibReader jKi = null;
  
  public static void a(a parama)
  {
    jKh = parama;
  }
  
  public static ICommLibReader baF()
  {
    AppMethodBeat.i(184407);
    try
    {
      ICommLibReader localICommLibReader = jKi;
      ae.i("MicroMsg.AppBrand.WxaCommLibPreloadSessionInMM", "getCurrentAcceptedCommLibReader [%s], stacktrace=%s", new Object[] { localICommLibReader, Log.getStackTraceString(new Throwable()) });
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
      jKi = paramICommLibReader;
      if (jKh != null) {
        jKh.b(paramICommLibReader);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at
 * JD-Core Version:    0.7.0.1
 */