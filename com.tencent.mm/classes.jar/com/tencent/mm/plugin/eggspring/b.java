package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"sendCgi", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgi", "Lcom/tencent/mm/modelbase/Cgi;", "(Lcom/tencent/mm/modelbase/Cgi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-eggspring_release"})
public final class b
{
  public static final <Response extends dyy> Object a(com.tencent.mm.an.c<Response> paramc, d<? super Response> paramd)
  {
    AppMethodBeat.i(249283);
    n localn = new n(kotlin.d.a.b.k(paramd), 1);
    localn.iQM();
    m localm = (m)localn;
    com.tencent.mm.vending.e.c localc = new com.tencent.mm.vending.e.c();
    paramc.bhW().a((com.tencent.mm.vending.e.b)localc).g((com.tencent.mm.vending.c.a)new b.a(localm));
    localm.am((kotlin.g.a.b)new b(localc));
    paramc = localn.getResult();
    if (paramc == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    AppMethodBeat.o(249283);
    return paramc;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Throwable, x>
  {
    b(com.tencent.mm.vending.e.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b
 * JD-Core Version:    0.7.0.1
 */