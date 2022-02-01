package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
{
  public static boolean aZQ()
  {
    AppMethodBeat.i(44269);
    if (!g.ajx())
    {
      AppMethodBeat.o(44269);
      return false;
    }
    AppMethodBeat.o(44269);
    return true;
  }
  
  public static boolean aZR()
  {
    AppMethodBeat.i(44270);
    if (!g.ajx())
    {
      AppMethodBeat.o(44270);
      return false;
    }
    AppMethodBeat.o(44270);
    return true;
  }
  
  public static boolean aZS()
  {
    AppMethodBeat.i(44271);
    if (!g.ajx())
    {
      AppMethodBeat.o(44271);
      return false;
    }
    AppMethodBeat.o(44271);
    return true;
  }
  
  public static boolean aZT()
  {
    AppMethodBeat.i(44273);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qsm, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44273);
      return bool;
    }
  }
  
  public static boolean aZU()
  {
    AppMethodBeat.i(188010);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qsn, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(188010);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */