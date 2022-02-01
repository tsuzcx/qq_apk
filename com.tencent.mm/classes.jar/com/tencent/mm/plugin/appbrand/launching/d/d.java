package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.networking.a<btg>
{
  public static final a lMT;
  private final boolean jpu;
  private final btf lMS;
  private final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(50807);
    lMT = new a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(btf parambtf, boolean paramBoolean)
  {
    super(parambtf.iht, parambtf.GNH);
    AppMethodBeat.i(50806);
    this.lMS = parambtf;
    this.jpu = paramBoolean;
    parambtf = new b.a();
    parambtf.oP(1122);
    parambtf.Dl("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    parambtf.c((com.tencent.mm.bx.a)this.lMS);
    parambtf.d((com.tencent.mm.bx.a)new btg());
    parambtf = parambtf.aDC();
    p.g(parambtf, "rrb.buildInstance()");
    this.rr = parambtf;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  public final f<a.a<btg>> aED()
  {
    AppMethodBeat.i(50805);
    Object localObject = new com.tencent.mm.plugin.appbrand.launching.a.a();
    com.tencent.mm.bx.a locala = this.rr.aEE();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject).a((btf)locala, this.jpu, (com.tencent.mm.al.a)this);
    locala = this.rr.aEE();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((btf)locala);
    locala = this.rr.aEE();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((btf)locala);
    if (localObject == null)
    {
      localObject = super.aED();
      p.g(localObject, "super.run()");
    }
    for (;;)
    {
      AppMethodBeat.o(50805);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "isSync", "", "createRequestForCmdPreLaunch", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */