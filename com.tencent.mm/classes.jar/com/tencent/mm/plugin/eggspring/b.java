package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.dpc;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlinx.coroutines.k;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"sendCgi", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgi", "Lcom/tencent/mm/modelbase/Cgi;", "(Lcom/tencent/mm/modelbase/Cgi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-eggspring_release"})
public final class b
{
  public static final <Response extends dpc> Object a(com.tencent.mm.ak.c<Response> paramc, d<? super Response> paramd)
  {
    AppMethodBeat.i(194554);
    kotlinx.coroutines.l locall = new kotlinx.coroutines.l(kotlin.d.a.b.e(paramd));
    k localk = (k)locall;
    com.tencent.mm.vending.e.c localc = new com.tencent.mm.vending.e.c();
    paramc.aYI().a((com.tencent.mm.vending.e.b)localc).g((com.tencent.mm.vending.c.a)new a(localk));
    localk.W((kotlin.g.a.b)new b.b(localc));
    paramc = locall.getResult();
    if (paramc == kotlin.d.a.a.SXO) {
      p.h(paramd, "frame");
    }
    AppMethodBeat.o(194554);
    return paramc;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(k paramk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b
 * JD-Core Version:    0.7.0.1
 */