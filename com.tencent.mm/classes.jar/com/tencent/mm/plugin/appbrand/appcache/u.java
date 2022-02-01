package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class u
{
  public static boolean aWv()
  {
    AppMethodBeat.i(44269);
    if (!g.agM())
    {
      AppMethodBeat.o(44269);
      return false;
    }
    AppMethodBeat.o(44269);
    return true;
  }
  
  public static boolean aWw()
  {
    AppMethodBeat.i(44270);
    if (!g.agM())
    {
      AppMethodBeat.o(44270);
      return false;
    }
    AppMethodBeat.o(44270);
    return true;
  }
  
  public static boolean aWx()
  {
    AppMethodBeat.i(44271);
    if (!g.agM())
    {
      AppMethodBeat.o(44271);
      return false;
    }
    AppMethodBeat.o(44271);
    return true;
  }
  
  public static boolean aWy()
  {
    AppMethodBeat.i(44273);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pOn, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.PkgABTest", "openSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(44273);
      return bool;
    }
  }
  
  public static boolean aWz()
  {
    AppMethodBeat.i(186322);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pOo, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.PkgABTest", "openMultiSplitPluginCode exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(186322);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */