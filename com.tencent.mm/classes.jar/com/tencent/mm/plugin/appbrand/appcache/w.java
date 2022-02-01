package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
{
  public static boolean bGM()
  {
    AppMethodBeat.i(44270);
    if (!h.aHB())
    {
      AppMethodBeat.o(44270);
      return false;
    }
    AppMethodBeat.o(44270);
    return true;
  }
  
  public static boolean bGN()
  {
    AppMethodBeat.i(44273);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vxD, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44273);
      return bool;
    }
  }
  
  public static boolean bGO()
  {
    AppMethodBeat.i(269425);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vxE, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(269425);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */