package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorageAdapterUtils;", "", "()V", "__insertOrUpdate", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "record", "__update", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn
{
  public static final bn qHG;
  
  static
  {
    AppMethodBeat.i(320160);
    qHG = new bn();
    AppMethodBeat.o(320160);
  }
  
  public static final boolean a(u<? extends g> paramu, g paramg)
  {
    AppMethodBeat.i(320153);
    s.u(paramu, "<this>");
    s.u(paramg, "record");
    boolean bool;
    if ((paramu instanceof bm))
    {
      bool = ((bm)paramu).d((bh)paramg);
      AppMethodBeat.o(320153);
      return bool;
    }
    if ((paramu instanceof bg))
    {
      bool = ((bg)paramu).b((bi)paramg);
      AppMethodBeat.o(320153);
      return bool;
    }
    AppMethodBeat.o(320153);
    return false;
  }
  
  public static final boolean b(u<? extends g> paramu, g paramg)
  {
    AppMethodBeat.i(320157);
    s.u(paramu, "<this>");
    s.u(paramg, "record");
    boolean bool;
    if ((paramu instanceof bm))
    {
      bool = ((bm)paramu).g((bh)paramg);
      AppMethodBeat.o(320157);
      return bool;
    }
    if ((paramu instanceof bg))
    {
      bool = ((bg)paramu).c((bi)paramg);
      AppMethodBeat.o(320157);
      return bool;
    }
    AppMethodBeat.o(320157);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bn
 * JD-Core Version:    0.7.0.1
 */