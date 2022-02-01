package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.fnd;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends c<cqa>
{
  private final String nBq;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.nBq = paramString2;
  }
  
  public final f<com.tencent.mm.an.c.a<cqa>> bhW()
  {
    AppMethodBeat.i(50783);
    Object localObject1 = (CharSequence)this.username;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = g.c((com.tencent.mm.vending.g.c.a)new a(this));
      p.j(localObject1, "pipelineExt {\n          …          )\n            }");
      AppMethodBeat.o(50783);
      return localObject1;
    }
    Log.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.nBq + "] instance[" + hashCode() + ']');
    localObject1 = new d.a();
    Object localObject2 = new cpz();
    ((cpz)localObject2).Txp = this.username;
    Object localObject3 = new fnd();
    ((fnd)localObject3).TBH = this.nBq;
    ((cpz)localObject2).Txh = ((fnd)localObject3);
    ((cpz)localObject2).TnO = true;
    ((cpz)localObject2).TnP = true;
    localObject3 = new foc();
    ICommLibReader localICommLibReader = au.bHb();
    if (localICommLibReader != null) {}
    for (i = localICommLibReader.bGi();; i = -1)
    {
      ((foc)localObject3).TBI = i;
      ((cpz)localObject2).Txj = ((foc)localObject3);
      ((d.a)localObject1).c((a)localObject2);
      ((d.a)localObject1).vD(1122);
      ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
      ((d.a)localObject1).d((a)new cqa());
      localObject1 = ((d.a)localObject1).bgN();
      p.j(localObject1, "rr");
      localObject2 = ((d)localObject1).bhX();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50783);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((cpz)localObject2);
    localObject2 = ((d)localObject1).bhX();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50783);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((cpz)localObject2);
    c((d)localObject1);
    localObject1 = super.bhW();
    p.j(localObject1, "super.run()");
    AppMethodBeat.o(50783);
    return localObject1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.b
 * JD-Core Version:    0.7.0.1
 */