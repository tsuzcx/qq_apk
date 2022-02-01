package com.tencent.mm.plugin.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class a
{
  public static long iIX;
  public static long iIY;
  public static final String iIZ;
  public static boolean iJa;
  
  static
  {
    AppMethodBeat.i(153191);
    e locale = e.R(aj.getContext().getCacheDir());
    if (locale == null) {
      iIZ = "";
    }
    for (;;)
    {
      iJa = false;
      AppMethodBeat.o(153191);
      return;
      locale = new e(locale, "appbrand");
      try
      {
        locale.mkdirs();
        label50:
        iIZ = q.B(new e(locale, "use_isolate_bootstep.cfg").fhU());
      }
      catch (Throwable localThrowable)
      {
        break label50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */