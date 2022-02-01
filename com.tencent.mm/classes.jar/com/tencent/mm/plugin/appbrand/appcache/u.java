package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
{
  public static boolean aPD()
  {
    AppMethodBeat.i(44269);
    if (!g.afw())
    {
      AppMethodBeat.o(44269);
      return false;
    }
    AppMethodBeat.o(44269);
    return true;
  }
  
  public static boolean aPE()
  {
    AppMethodBeat.i(44270);
    if (!g.afw())
    {
      AppMethodBeat.o(44270);
      return false;
    }
    AppMethodBeat.o(44270);
    return true;
  }
  
  public static boolean aPF()
  {
    AppMethodBeat.i(44271);
    if (!g.afw())
    {
      AppMethodBeat.o(44271);
      return false;
    }
    AppMethodBeat.o(44271);
    return true;
  }
  
  public static boolean aPG()
  {
    AppMethodBeat.i(44273);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pkW, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44273);
      return bool;
    }
  }
  
  public static boolean aPH()
  {
    AppMethodBeat.i(195618);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pkX, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(195618);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */