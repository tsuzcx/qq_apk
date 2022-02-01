package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.gjw;
import com.tencent.mm.protocal.protobuf.glb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/data_prefetch/CgiPrefetchLaunchWxaApp;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "username", "", "enterPath", "(Ljava/lang/String;Ljava/lang/String;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<dgu>
{
  private final String qAF;
  private final String username;
  
  public b(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.qAF = paramString2;
  }
  
  private static final b.a a(b paramb)
  {
    AppMethodBeat.i(321091);
    s.u(paramb, "this$0");
    paramb = b.a.a(3, -2, "EMPTY USERNAME", (esc)new dgu(), null, (com.tencent.mm.am.b)paramb);
    AppMethodBeat.o(321091);
    return paramb;
  }
  
  public final f<b.a<dgu>> bFJ()
  {
    AppMethodBeat.i(50783);
    Object localObject1 = (CharSequence)this.username;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = g.c(new b..ExternalSyntheticLambda0(this));
      s.s(localObject1, "{\n            pipelineEx…)\n            }\n        }");
      AppMethodBeat.o(50783);
      return localObject1;
    }
    Log.i("MicroMsg.AppBrand.CgiPrefetchLaunchWxaApp", "run() with username[" + this.username + "] enterPath[" + this.qAF + "] instance[" + hashCode() + ']');
    localObject1 = new c.a();
    Object localObject2 = new dgt();
    ((dgt)localObject2).aaLU = this.username;
    Object localObject3 = new gjw();
    ((gjw)localObject3).aaQW = this.qAF;
    Object localObject4 = ah.aiuX;
    ((dgt)localObject2).aaLM = ((gjw)localObject3);
    ((dgt)localObject2).aaBV = true;
    ((dgt)localObject2).aaBW = true;
    localObject3 = new glb();
    localObject4 = av.cgx();
    if (localObject4 == null) {}
    for (i = -1;; i = ((ICommLibReader)localObject4).cfG())
    {
      ((glb)localObject3).aaQX = i;
      localObject4 = ah.aiuX;
      ((dgt)localObject2).aaLO = ((glb)localObject3);
      localObject3 = new aeo();
      ((aeo)localObject3).ZmB = 1;
      localObject4 = ah.aiuX;
      ((dgt)localObject2).YMR = ((aeo)localObject3);
      localObject3 = ah.aiuX;
      ((c.a)localObject1).otE = ((a)localObject2);
      ((c.a)localObject1).funcId = 1122;
      ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      ((c.a)localObject1).otF = ((a)new dgu());
      localObject1 = ((c.a)localObject1).bEF();
      localObject2 = c.b.b(((c)localObject1).otB);
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50783);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.b((dgt)localObject2);
    localObject2 = c.b.b(((c)localObject1).otB);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LaunchWxaAppRequest");
      AppMethodBeat.o(50783);
      throw ((Throwable)localObject1);
    }
    com.tencent.mm.plugin.appbrand.launching.a.b.c((dgt)localObject2);
    localObject2 = ah.aiuX;
    c((c)localObject1);
    localObject1 = super.bFJ();
    s.s(localObject1, "{\n            Log.i(TAG,…    super.run()\n        }");
    AppMethodBeat.o(50783);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.b
 * JD-Core Version:    0.7.0.1
 */