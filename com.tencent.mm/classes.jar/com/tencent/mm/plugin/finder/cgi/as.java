package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/MegaVideoBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
public final class as
{
  public static final as xco;
  
  static
  {
    AppMethodBeat.i(286185);
    xco = new as();
    AppMethodBeat.o(286185);
  }
  
  public static cvz b(bid parambid)
  {
    AppMethodBeat.i(286183);
    cvz localcvz = new cvz();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localcvz.TET = localf.aHp().getInt(ar.a.VAG, 0);
    if (parambid != null) {
      localcvz.scene = parambid.xkX;
    }
    AppMethodBeat.o(286183);
    return localcvz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */