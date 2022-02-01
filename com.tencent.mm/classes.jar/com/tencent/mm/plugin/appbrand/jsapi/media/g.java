package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  @Deprecated
  public static final g.a pbp;
  private JsApiChooseVideo pbo;
  
  static
  {
    AppMethodBeat.i(50564);
    pbp = new g.a((byte)0);
    AppMethodBeat.o(50564);
  }
  
  public g()
  {
    AppMethodBeat.i(50563);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEr, 1) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.pbo = new JsApiChooseVideo();
      }
      AppMethodBeat.o(50563);
      return;
    }
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(50562);
    if (parame == null) {
      p.iCn();
    }
    if (paramJSONObject == null) {
      p.iCn();
    }
    if (this.pbo != null)
    {
      localObject = this.pbo;
      if (localObject == null) {
        p.iCn();
      }
      ((JsApiChooseVideo)localObject).a(parame, paramJSONObject, paramInt);
      AppMethodBeat.o(50562);
      return;
    }
    final boolean bool2 = paramJSONObject.optBoolean("compressed", true);
    Object localObject = q.d.pcw;
    p.k(paramJSONObject, "json");
    localObject = q.b.pcn;
    localObject = new StringBuilder();
    String str = q.d.pct.name();
    if (str == null)
    {
      parame = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw parame;
    }
    str = str.toLowerCase();
    p.j(str, "(this as java.lang.String).toLowerCase()");
    localObject = ((StringBuilder)localObject).append(str).append(", ");
    str = q.d.pcu.name();
    if (str == null)
    {
      parame = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw parame;
    }
    str = str.toLowerCase();
    p.j(str, "(this as java.lang.String).toLowerCase()");
    int i = q.b.b.a(paramJSONObject, "sourceType", str, (q.b[])q.d.values());
    localObject = q.a.pcm;
    p.k(paramJSONObject, "json");
    localObject = q.b.pcn;
    localObject = q.a.pck.name();
    if (localObject == null)
    {
      parame = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw parame;
    }
    localObject = ((String)localObject).toLowerCase();
    p.j(localObject, "(this as java.lang.String).toLowerCase()");
    int j = q.b.b.a(paramJSONObject, "camera", (String)localObject, (q.b[])q.a.values());
    int k = q.c.pcq.cUP;
    int m = paramJSONObject.optInt("maxDuration", 60);
    if (m <= 0)
    {
      parame.j(paramInt, agS("fail invalid maxDuration"));
      AppMethodBeat.o(50562);
      return;
    }
    if (!bool2) {}
    for (;;)
    {
      paramJSONObject = new c(parame, i, j, k, bool1, m);
      paramJSONObject = com.tencent.mm.cw.g.ijP().b((com.tencent.mm.vending.c.a)new c.e(paramJSONObject)).b((com.tencent.mm.vending.c.a)new c.f(paramJSONObject));
      p.j(paramJSONObject, "pipelineExt()\n          …ANCELED\n                }");
      paramJSONObject.g((com.tencent.mm.vending.c.a)new b(this, parame, paramInt, bool2)).a((d.a)new c(this, parame, paramInt));
      AppMethodBeat.o(50562);
      return;
      bool1 = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(g paramg, e parame, int paramInt, boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class c<T>
    implements d.a<Object>
  {
    c(g paramg, e parame, int paramInt) {}
    
    public final void cm(Object paramObject)
    {
      AppMethodBeat.i(50561);
      if ((paramObject instanceof Exception))
      {
        Object localObject = ((Exception)paramObject).getMessage();
        paramObject = localObject;
        if (localObject == null) {
          paramObject = "";
        }
        localObject = parame;
        int i = paramInt;
        g localg = this.pbq;
        if (n.M(paramObject, "fail", false)) {}
        for (;;)
        {
          ((e)localObject).j(i, localg.agS(paramObject));
          AppMethodBeat.o(50561);
          return;
          paramObject = "fail ".concat(String.valueOf(paramObject));
        }
      }
      g.bTf();
      Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + paramObject + ')');
      parame.j(paramInt, this.pbq.agS("fail:internal error"));
      AppMethodBeat.o(50561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g
 * JD-Core Version:    0.7.0.1
 */