package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.ak.a<bua>
{
  private final String jFL;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.jFL = paramString2;
  }
  
  public final f<a.a<bua>> aET()
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
    ae.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.jFL + "] instance[" + hashCode() + ']');
    localObject = new com.tencent.mm.ak.b.a();
    btz localbtz = new btz();
    localbtz.Hhh = this.username;
    ehk localehk = new ehk();
    localehk.Hkq = this.jFL;
    localbtz.HgZ = localehk;
    localbtz.GZm = true;
    localbtz.GZn = true;
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)localbtz);
    ((com.tencent.mm.ak.b.a)localObject).oS(1122);
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new bua());
    c(((com.tencent.mm.ak.b.a)localObject).aDS());
    localObject = super.aET();
    p.g(localObject, "super.run()");
    AppMethodBeat.o(50783);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
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