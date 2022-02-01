package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "run", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.networking.b<che>
{
  public static final a mYC;
  private final boolean kqC;
  private final chd mYB;
  private final com.tencent.mm.ak.d rr;
  
  static
  {
    AppMethodBeat.i(50807);
    mYC = new a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(chd paramchd, boolean paramBoolean)
  {
    super(paramchd.jfi, paramchd.Mmv);
    AppMethodBeat.i(50806);
    this.mYB = paramchd;
    this.kqC = paramBoolean;
    paramchd = new com.tencent.mm.ak.d.a();
    paramchd.sG(1122);
    paramchd.MB("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    paramchd.c((com.tencent.mm.bw.a)this.mYB);
    paramchd.d((com.tencent.mm.bw.a)new che());
    paramchd = paramchd.aXF();
    p.g(paramchd, "rrb.buildInstance()");
    this.rr = paramchd;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  public final f<com.tencent.mm.ak.c.a<che>> aYI()
  {
    AppMethodBeat.i(50805);
    Object localObject = new com.tencent.mm.plugin.appbrand.launching.a.a();
    com.tencent.mm.bw.a locala = this.rr.aYJ();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject).a((chd)locala, this.kqC, (c)this);
    locala = this.rr.aYJ();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((chd)locala);
    locala = this.rr.aYJ();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((chd)locala);
    if (localObject == null) {
      localObject = super.aYI();
    }
    for (;;)
    {
      AppMethodBeat.o(50805);
      return localObject;
    }
  }
  
  public final f<com.tencent.mm.ak.c.a<che>> bAe()
  {
    AppMethodBeat.i(228752);
    if (!com.tencent.mm.plugin.appbrand.networking.a.eA(this.mYB.jfi, this.mYB.Mmv))
    {
      f localf = g.c((com.tencent.mm.vending.g.c.a)new b(this));
      AppMethodBeat.o(228752);
      return localf;
    }
    AppMethodBeat.o(228752);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "wxaMaterialInfo", "Lcom/tencent/mm/protocal/protobuf/WxaMaterialInfo;", "isSync", "", "createRequestForCmdPreLaunch", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    b(d paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */