package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.ak.a<bot>
{
  private final String jjf;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.jjf = paramString2;
  }
  
  public final f<a.a<bot>> aBB()
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
    ac.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.jjf + "] instance[" + hashCode() + ']');
    localObject = new com.tencent.mm.ak.b.a();
    bos localbos = new bos();
    localbos.Fed = this.username;
    dzp localdzp = new dzp();
    localdzp.Fhn = this.jjf;
    localbos.FdV = localdzp;
    localbos.EWn = true;
    localbos.EWo = true;
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)localbos);
    ((com.tencent.mm.ak.b.a)localObject).op(1122);
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new bot());
    c(((com.tencent.mm.ak.b.a)localObject).aAz());
    localObject = super.aBB();
    k.g(localObject, "super.run()");
    AppMethodBeat.o(50783);
    return localObject;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
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