package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends c<che>
{
  private final String kHw;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.kHw = paramString2;
  }
  
  public final f<com.tencent.mm.ak.c.a<che>> aYI()
  {
    AppMethodBeat.i(50783);
    Object localObject1 = (CharSequence)this.username;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = g.c((com.tencent.mm.vending.g.c.a)new a(this));
      p.g(localObject1, "pipelineExt {\n          …          )\n            }");
      AppMethodBeat.o(50783);
      return localObject1;
    }
    Log.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.kHw + "] instance[" + hashCode() + ']');
    localObject1 = new d.a();
    Object localObject2 = new chd();
    ((chd)localObject2).Mmv = this.username;
    Object localObject3 = new fcc();
    ((fcc)localObject3).MqE = this.kHw;
    ((chd)localObject2).Mmn = ((fcc)localObject3);
    ((chd)localObject2).Mem = true;
    ((chd)localObject2).Men = true;
    localObject3 = new fdb();
    ICommLibReader localICommLibReader = at.bvT();
    if (localICommLibReader != null) {}
    for (i = localICommLibReader.bvd();; i = -1)
    {
      ((fdb)localObject3).MqF = i;
      ((chd)localObject2).Mmp = ((fdb)localObject3);
      ((d.a)localObject1).c((a)localObject2);
      ((d.a)localObject1).sG(1122);
      ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp");
      ((d.a)localObject1).d((a)new che());
      localObject1 = ((d.a)localObject1).aXF();
      p.g(localObject1, "rr");
      localObject2 = ((d)localObject1).aYJ();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50783);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.a((chd)localObject2);
    localObject2 = ((d)localObject1).aYJ();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50783);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((chd)localObject2);
    c((d)localObject1);
    localObject1 = super.aYI();
    p.g(localObject1, "super.run()");
    AppMethodBeat.o(50783);
    return localObject1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.b
 * JD-Core Version:    0.7.0.1
 */