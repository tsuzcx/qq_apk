package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.al.a<btg>
{
  private final String jCN;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.jCN = paramString2;
  }
  
  public final f<a.a<btg>> aED()
  {
    AppMethodBeat.i(50783);
    Object localObject = (CharSequence)this.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = g.c((c.a)new a(this));
      p.g(localObject, "pipelineExt {\n          …          )\n            }");
      AppMethodBeat.o(50783);
      return localObject;
    }
    ad.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.jCN + "] instance[" + hashCode() + ']');
    localObject = new com.tencent.mm.al.b.a();
    btf localbtf = new btf();
    localbtf.GNH = this.username;
    eft localeft = new eft();
    localeft.GQP = this.jCN;
    localbtf.GNz = localeft;
    localbtf.GFK = true;
    localbtf.GFL = true;
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)localbtf);
    ((com.tencent.mm.al.b.a)localObject).oP(1122);
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new btg());
    c(((com.tencent.mm.al.b.a)localObject).aDC());
    localObject = super.aED();
    p.g(localObject, "super.run()");
    AppMethodBeat.o(50783);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret>
    implements c.a<_Var>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.b
 * JD-Core Version:    0.7.0.1
 */