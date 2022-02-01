package com.tencent.mm.plugin.appbrand.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class a
{
  public static long jCJ;
  public static long jCK;
  public static final String jCL;
  public static boolean jCM;
  
  static
  {
    AppMethodBeat.i(153191);
    e locale = e.X(aj.getContext().getCacheDir());
    if (locale == null) {
      jCL = "";
    }
    for (;;)
    {
      jCM = false;
      AppMethodBeat.o(153191);
      return;
      locale = new e(locale, "appbrand");
      try
      {
        locale.mkdirs();
        label50:
        jCL = q.B(new e(locale, "use_isolate_bootstep.cfg").fOK());
      }
      catch (Throwable localThrowable)
      {
        break label50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.a
 * JD-Core Version:    0.7.0.1
 */