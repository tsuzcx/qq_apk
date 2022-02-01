package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageAdapterUtils;", "", "()V", "__insertOrUpdate", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "record", "__update", "data-storage_release"})
public final class bn
{
  public static final bn nHR;
  
  static
  {
    AppMethodBeat.i(232419);
    nHR = new bn();
    AppMethodBeat.o(232419);
  }
  
  public static final boolean a(s<? extends g> params, g paramg)
  {
    AppMethodBeat.i(232415);
    p.k(params, "$this$__insertOrUpdate");
    p.k(paramg, "record");
    boolean bool;
    if ((params instanceof bm))
    {
      bool = ((bm)params).d((bh)paramg);
      AppMethodBeat.o(232415);
      return bool;
    }
    if ((params instanceof bg))
    {
      bool = ((bg)params).b((bi)paramg);
      AppMethodBeat.o(232415);
      return bool;
    }
    AppMethodBeat.o(232415);
    return false;
  }
  
  public static final boolean b(s<? extends g> params, g paramg)
  {
    AppMethodBeat.i(232416);
    p.k(params, "$this$__update");
    p.k(paramg, "record");
    boolean bool;
    if ((params instanceof bm))
    {
      bool = ((bm)params).g((bh)paramg);
      AppMethodBeat.o(232416);
      return bool;
    }
    if ((params instanceof bg))
    {
      bool = ((bg)params).c((bi)paramg);
      AppMethodBeat.o(232416);
      return bool;
    }
    AppMethodBeat.o(232416);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bn
 * JD-Core Version:    0.7.0.1
 */