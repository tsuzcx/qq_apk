package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.protocal.protobuf.ecj;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "isSync", "", "(Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;Z)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "call", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends c<bot>
{
  public static final a lpA;
  private final boolean iWl;
  private final bos lpz;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(50807);
    lpA = new a((byte)0);
    AppMethodBeat.o(50807);
  }
  
  public d(bos parambos, boolean paramBoolean)
  {
    AppMethodBeat.i(50806);
    this.lpz = parambos;
    this.iWl = paramBoolean;
    parambos = new b.a();
    parambos.op(1122);
    parambos.Am("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    parambos.c((com.tencent.mm.bw.a)this.lpz);
    parambos.d((com.tencent.mm.bw.a)new bot());
    parambos = parambos.aAz();
    k.g(parambos, "rrb.buildInstance()");
    this.rr = parambos;
    c(this.rr);
    AppMethodBeat.o(50806);
  }
  
  public final f<c.a<bot>> aBB()
  {
    AppMethodBeat.i(50805);
    Object localObject = new com.tencent.mm.plugin.appbrand.launching.a.a();
    com.tencent.mm.bw.a locala = this.rr.aBC();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.launching.a.a)localObject).a((bos)locala, this.iWl, (c)this);
    locala = this.rr.aBC();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((bos)locala);
    locala = this.rr.aBC();
    if (locala == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50805);
      throw ((Throwable)localObject);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((bos)locala);
    if (localObject == null)
    {
      localObject = super.aBB();
      k.g(localObject, "super.run()");
    }
    for (;;)
    {
      AppMethodBeat.o(50805);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiLaunchWxaAppForPreFetch;", "userName", "appId", "wxaAppBaseInfo", "Lcom/tencent/mm/protocal/protobuf/WxaAppBaseInfo;", "webLaunch", "Lcom/tencent/mm/protocal/protobuf/WxaWebLaunchInfo;", "appJump", "Lcom/tencent/mm/protocal/protobuf/WxaJumpInfo;", "libVersion", "", "wxaPushMsgInfo", "Lcom/tencent/mm/protocal/protobuf/WxaPushMsgInfo;", "isSync", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static d a(String paramString1, String paramString2, dzp paramdzp, ecj paramecj, ebf paramebf, int paramInt, ebo paramebo, boolean paramBoolean)
    {
      AppMethodBeat.i(187339);
      bos localbos = new bos();
      localbos.FdV = paramdzp;
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        localbos.ETI = i;
        localbos.FdY = paramecj;
        localbos.FdZ = paramebf;
        paramdzp = paramString2;
        if (paramString2 == null) {
          paramdzp = "";
        }
        localbos.hOf = paramdzp;
        localbos.EWn = true;
        paramString2 = new eao();
        paramString2.Fho = paramInt;
        localbos.FdX = paramString2;
        localbos.Fed = paramString1;
        localbos.Fee = paramebo;
        paramString1 = new d(localbos, paramBoolean);
        AppMethodBeat.o(187339);
        return paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.d
 * JD-Core Version:    0.7.0.1
 */