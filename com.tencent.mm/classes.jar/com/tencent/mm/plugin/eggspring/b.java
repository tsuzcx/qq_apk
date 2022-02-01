package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.vending.e.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"sendCgi", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgi", "Lcom/tencent/mm/modelbase/Cgi;", "(Lcom/tencent/mm/modelbase/Cgi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-eggspring_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final <Response extends esc> Object b(com.tencent.mm.am.b<Response> paramb, d<? super Response> paramd)
  {
    AppMethodBeat.i(266513);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    p localp = (p)localq;
    c localc = new c();
    paramb.bFJ().a((com.tencent.mm.vending.e.b)localc).g((com.tencent.mm.vending.c.a)new a(localp));
    localp.bg((kotlin.g.a.b)new b(localc));
    paramb = localq.getResult();
    if (paramb == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(266513);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a
  {
    a(p<? super Response> paramp) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    b(c<com.tencent.mm.vending.e.a> paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b
 * JD-Core Version:    0.7.0.1
 */