package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class r
{
  public static boolean avv()
  {
    AppMethodBeat.i(129363);
    if (!g.RG())
    {
      AppMethodBeat.o(129363);
      return false;
    }
    AppMethodBeat.o(129363);
    return true;
  }
  
  public static boolean avw()
  {
    AppMethodBeat.i(129364);
    if (!g.RG())
    {
      AppMethodBeat.o(129364);
      return false;
    }
    AppMethodBeat.o(129364);
    return true;
  }
  
  public static boolean avx()
  {
    AppMethodBeat.i(129365);
    if (!g.RG())
    {
      AppMethodBeat.o(129365);
      return false;
    }
    AppMethodBeat.o(129365);
    return true;
  }
  
  public static boolean avy()
  {
    AppMethodBeat.i(129366);
    if (!g.RG())
    {
      AppMethodBeat.o(129366);
      return false;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100399");
    if (f.IS_FLAVOR_RED) {}
    for (boolean bool = true; (localc.isValid()) && (bo.getInt((String)localc.dvN().get("isUseNewPackageLogic"), 0) > 0); bool = false)
    {
      AppMethodBeat.o(129366);
      return true;
    }
    AppMethodBeat.o(129366);
    return bool;
  }
  
  public static boolean avz()
  {
    AppMethodBeat.i(129367);
    boolean bool = ((a)g.E(a.class)).a(a.a.lTA, false);
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.PkgABTest", "openSplitCodeLib exp:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(129367);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.r
 * JD-Core Version:    0.7.0.1
 */