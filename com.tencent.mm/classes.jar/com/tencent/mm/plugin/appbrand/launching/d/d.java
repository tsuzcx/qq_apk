package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.networking.b<dgu>
{
  public static final d.a tdN;
  private final c rr;
  private final dgt tdO;
  private final boolean tdP;
  
  static
  {
    AppMethodBeat.i(50807);
    tdN = new d.a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(dgt paramdgt, boolean paramBoolean)
  {
    super(paramdgt.oOI, paramdgt.aaLU);
    AppMethodBeat.i(50806);
    this.tdO = paramdgt;
    this.tdP = paramBoolean;
    paramdgt = new c.a();
    paramdgt.funcId = 1122;
    paramdgt.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
    paramdgt.otE = ((com.tencent.mm.bx.a)this.tdO);
    paramdgt.otF = ((com.tencent.mm.bx.a)new dgu());
    paramdgt = paramdgt.bEF();
    s.s(paramdgt, "rrb.buildInstance()");
    this.rr = paramdgt;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  private static final b.a a(d paramd)
  {
    AppMethodBeat.i(321053);
    s.u(paramd, "this$0");
    paramd = b.a.a(4, -2, "", null, null, (com.tencent.mm.am.b)paramd);
    AppMethodBeat.o(321053);
    return paramd;
  }
  
  public final f<b.a<dgu>> bFJ()
  {
    AppMethodBeat.i(50805);
    Object localObject1 = new com.tencent.mm.plugin.appbrand.launching.a.a();
    Object localObject2 = c.b.b(this.rr.otB);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject1).a((dgt)localObject2, this.tdP, (com.tencent.mm.am.b)this);
    localObject2 = c.b.b(this.rr.otB);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((dgt)localObject2);
    localObject2 = c.b.b(this.rr.otB);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.c((dgt)localObject2);
    localObject2 = com.tencent.mm.ak.a.oip;
    localObject2 = c.b.b(this.rr.otB);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject1);
    }
    Log.i("MicroMsg.AppBrand.CgiLaunchWxaAppForPreFetch", s.X("run() with request ", com.tencent.mm.ak.a.a((dgt)localObject2)));
    if (localObject1 == null)
    {
      localObject1 = super.bFJ();
      AppMethodBeat.o(50805);
      return localObject1;
    }
    AppMethodBeat.o(50805);
    return localObject1;
  }
  
  public final f<b.a<dgu>> ckO()
  {
    AppMethodBeat.i(321060);
    if (!com.tencent.mm.plugin.appbrand.networking.a.ff(this.tdO.oOI, this.tdO.aaLU))
    {
      f localf = g.c(new d..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(321060);
      return localf;
    }
    AppMethodBeat.o(321060);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */