package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "run", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.networking.b<cqa>
{
  public static final a pZb;
  private final boolean nip;
  private final cpz pZa;
  private final com.tencent.mm.an.d rr;
  
  static
  {
    AppMethodBeat.i(50807);
    pZb = new a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(cpz paramcpz, boolean paramBoolean)
  {
    super(paramcpz.lVG, paramcpz.Txp);
    AppMethodBeat.i(50806);
    this.pZa = paramcpz;
    this.nip = paramBoolean;
    paramcpz = new com.tencent.mm.an.d.a();
    paramcpz.vD(1122);
    paramcpz.TW("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    paramcpz.c((com.tencent.mm.cd.a)this.pZa);
    paramcpz.d((com.tencent.mm.cd.a)new cqa());
    paramcpz = paramcpz.bgN();
    p.j(paramcpz, "rrb.buildInstance()");
    this.rr = paramcpz;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  public final f<com.tencent.mm.an.c.a<cqa>> bLt()
  {
    AppMethodBeat.i(265500);
    if (!com.tencent.mm.plugin.appbrand.networking.a.eO(this.pZa.lVG, this.pZa.Txp))
    {
      f localf = g.c((com.tencent.mm.vending.g.c.a)new b(this));
      AppMethodBeat.o(265500);
      return localf;
    }
    AppMethodBeat.o(265500);
    return null;
  }
  
  public final f<com.tencent.mm.an.c.a<cqa>> bhW()
  {
    AppMethodBeat.i(50805);
    Object localObject = new com.tencent.mm.plugin.appbrand.launching.a.a();
    com.tencent.mm.cd.a locala = this.rr.bhX();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject).a((cpz)locala, this.nip, (c)this);
    locala = this.rr.bhX();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((cpz)locala);
    locala = this.rr.bhX();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((cpz)locala);
    if (localObject == null) {
      localObject = super.bhW();
    }
    for (;;)
    {
      AppMethodBeat.o(50805);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "wxaMaterialInfo", "Lcom/tencent/mm/protocal/protobuf/WxaMaterialInfo;", "isSync", "", "createRequestForCmdPreLaunch", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    b(d paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */