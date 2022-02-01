package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
{
  public static boolean bvE()
  {
    AppMethodBeat.i(44269);
    if (!g.aAc())
    {
      AppMethodBeat.o(44269);
      return false;
    }
    AppMethodBeat.o(44269);
    return true;
  }
  
  public static boolean bvF()
  {
    AppMethodBeat.i(44270);
    if (!g.aAc())
    {
      AppMethodBeat.o(44270);
      return false;
    }
    AppMethodBeat.o(44270);
    return true;
  }
  
  public static boolean bvG()
  {
    AppMethodBeat.i(44273);
    boolean bool = ((b)g.af(b.class)).a(b.a.rRi, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44273);
      return bool;
    }
  }
  
  public static boolean bvH()
  {
    AppMethodBeat.i(226355);
    boolean bool = ((b)g.af(b.class)).a(b.a.rRj, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(226355);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */