package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.vending.g.c.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "run", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.networking.b<bua>
{
  public static final a lRt;
  private final boolean jsn;
  private final btz lRs;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(50807);
    lRt = new a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(btz parambtz, boolean paramBoolean)
  {
    super(parambtz.ikm, parambtz.Hhh);
    AppMethodBeat.i(50806);
    this.lRs = parambtz;
    this.jsn = paramBoolean;
    parambtz = new b.a();
    parambtz.oS(1122);
    parambtz.DN("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    parambtz.c((com.tencent.mm.bw.a)this.lRs);
    parambtz.d((com.tencent.mm.bw.a)new bua());
    parambtz = parambtz.aDS();
    p.g(parambtz, "rrb.buildInstance()");
    this.rr = parambtz;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  public final f<a.a<bua>> aET()
  {
    AppMethodBeat.i(50805);
    Object localObject = new com.tencent.mm.plugin.appbrand.launching.a.a();
    com.tencent.mm.bw.a locala = this.rr.aEU();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject).a((btz)locala, this.jsn, (com.tencent.mm.ak.a)this);
    locala = this.rr.aEU();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((btz)locala);
    locala = this.rr.aEU();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((btz)locala);
    if (localObject == null) {
      localObject = super.aET();
    }
    for (;;)
    {
      AppMethodBeat.o(50805);
      return localObject;
    }
  }
  
  public final f<a.a<bua>> beN()
  {
    AppMethodBeat.i(223591);
    if (!com.tencent.mm.plugin.appbrand.networking.a.ej(this.lRs.ikm, this.lRs.Hhh))
    {
      f localf = g.c((c.a)new b(this));
      AppMethodBeat.o(223591);
      return localf;
    }
    AppMethodBeat.o(223591);
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "isSync", "", "createRequestForCmdPreLaunch", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret>
    implements c.a<_Var>
  {
    b(d paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */