package com.tencent.mm.plugin.appbrand.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class a
{
  public static long jFH;
  public static long jFI;
  public static final String jFJ;
  public static boolean jFK;
  
  static
  {
    AppMethodBeat.i(153191);
    k localk = k.W(ak.getContext().getCacheDir());
    if (localk == null) {
      jFJ = "";
    }
    for (;;)
    {
      jFK = false;
      AppMethodBeat.o(153191);
      return;
      localk = new k(localk, "appbrand");
      try
      {
        localk.mkdirs();
        label50:
        jFJ = w.B(new k(localk, "use_isolate_bootstep.cfg").fTh());
      }
      catch (Throwable localThrowable)
      {
        break label50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.a
 * JD-Core Version:    0.7.0.1
 */