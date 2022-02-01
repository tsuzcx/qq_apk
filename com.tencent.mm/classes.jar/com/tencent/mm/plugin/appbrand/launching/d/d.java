package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.dws;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "call", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends c<bkx>
{
  public static final a kOb;
  private final boolean iwh;
  private final bkw kOa;
  private final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(50807);
    kOb = new a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(bkw parambkw, boolean paramBoolean)
  {
    AppMethodBeat.i(50806);
    this.kOa = parambkw;
    this.iwh = paramBoolean;
    parambkw = new b.a();
    parambkw.nB(1122);
    parambkw.wg("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    parambkw.c((com.tencent.mm.bx.a)this.kOa);
    parambkw.d((com.tencent.mm.bx.a)new bkx());
    parambkw = parambkw.atI();
    k.g(parambkw, "rrb.buildInstance()");
    this.rr = parambkw;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  public final f<c.a<bkx>> auK()
  {
    AppMethodBeat.i(50805);
    Object localObject = new com.tencent.mm.plugin.appbrand.launching.a.a();
    com.tencent.mm.bx.a locala = this.rr.auL();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject).a((bkw)locala, this.iwh, (c)this);
    locala = this.rr.auL();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((bkw)locala);
    locala = this.rr.auL();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((bkw)locala);
    if (localObject == null)
    {
      localObject = super.auK();
      k.g(localObject, "super.run()");
    }
    for (;;)
    {
      AppMethodBeat.o(50805);
      return localObject;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "isSync", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static d a(String paramString1, String paramString2, dty paramdty, dws paramdws, dvo paramdvo, int paramInt, dvx paramdvx, boolean paramBoolean)
    {
      AppMethodBeat.i(196401);
      bkw localbkw = new bkw();
      localbkw.DIA = paramdty;
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        localbkw.Dym = i;
        localbkw.DID = paramdws;
        localbkw.DIE = paramdvo;
        paramdty = paramString2;
        if (paramString2 == null) {
          paramdty = "";
        }
        localbkw.hnC = paramdty;
        localbkw.DAR = true;
        paramString2 = new dux();
        paramString2.DKZ = paramInt;
        localbkw.DIC = paramString2;
        localbkw.DII = paramString1;
        localbkw.DIJ = paramdvx;
        paramString1 = new d(localbkw, paramBoolean);
        AppMethodBeat.o(196401);
        return paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */