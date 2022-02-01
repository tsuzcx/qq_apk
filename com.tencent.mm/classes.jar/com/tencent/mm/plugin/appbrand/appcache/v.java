package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class v
{
  public static boolean bap()
  {
    AppMethodBeat.i(44269);
    if (!g.ajM())
    {
      AppMethodBeat.o(44269);
      return false;
    }
    AppMethodBeat.o(44269);
    return true;
  }
  
  public static boolean baq()
  {
    AppMethodBeat.i(44270);
    if (!g.ajM())
    {
      AppMethodBeat.o(44270);
      return false;
    }
    AppMethodBeat.o(44270);
    return true;
  }
  
  public static boolean bar()
  {
    AppMethodBeat.i(44271);
    if (!g.ajM())
    {
      AppMethodBeat.o(44271);
      return false;
    }
    AppMethodBeat.o(44271);
    return true;
  }
  
  public static boolean bas()
  {
    AppMethodBeat.i(44273);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qzb, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44273);
      return bool;
    }
  }
  
  public static boolean bat()
  {
    AppMethodBeat.i(222127);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qzc, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(222127);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */