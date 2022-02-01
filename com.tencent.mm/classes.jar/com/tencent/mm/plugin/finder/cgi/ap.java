package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/MegaVideoBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
public final class ap
{
  public static final ap tuF;
  
  static
  {
    AppMethodBeat.i(242330);
    tuF = new ap();
    AppMethodBeat.o(242330);
  }
  
  public static cnh b(bbn parambbn)
  {
    AppMethodBeat.i(242328);
    cnh localcnh = new cnh();
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    localcnh.MtN = locale.azQ().getInt(ar.a.OlL, 0);
    if (parambbn != null) {
      localcnh.scene = parambbn.tCE;
    }
    AppMethodBeat.o(242328);
    return localcnh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */