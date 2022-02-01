package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.c.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.al.a<bkx>
{
  private final String iJb;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.iJb = paramString2;
  }
  
  public final f<a.a<bkx>> auK()
  {
    AppMethodBeat.i(50783);
    Object localObject = (CharSequence)this.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = g.c((c.a)new a(this));
      k.g(localObject, "pipelineExt {\n          …          )\n            }");
      AppMethodBeat.o(50783);
      return localObject;
    }
    ad.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.iJb + "] instance[" + hashCode() + ']');
    localObject = new com.tencent.mm.al.b.a();
    bkw localbkw = new bkw();
    localbkw.DII = this.username;
    dty localdty = new dty();
    localdty.DKY = this.iJb;
    localbkw.DIA = localdty;
    localbkw.DAR = true;
    localbkw.DAS = true;
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)localbkw);
    ((com.tencent.mm.al.b.a)localObject).nB(1122);
    ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new bkx());
    c(((com.tencent.mm.al.b.a)localObject).atI());
    localObject = super.auK();
    k.g(localObject, "super.run()");
    AppMethodBeat.o(50783);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret>
    implements c.a<_Var>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.b
 * JD-Core Version:    0.7.0.1
 */