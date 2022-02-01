package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends d<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  @Deprecated
  public static final a mdx;
  private JsApiChooseVideo mdw;
  
  static
  {
    AppMethodBeat.i(50564);
    mdx = new a((byte)0);
    AppMethodBeat.o(50564);
  }
  
  public g()
  {
    AppMethodBeat.i(50563);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXz, 1) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mdw = new JsApiChooseVideo();
      }
      AppMethodBeat.o(50563);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(50562);
    if (paramf == null) {
      p.hyc();
    }
    if (paramJSONObject == null) {
      p.hyc();
    }
    if (this.mdw != null)
    {
      localObject = this.mdw;
      if (localObject == null) {
        p.hyc();
      }
      ((JsApiChooseVideo)localObject).a(paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(50562);
      return;
    }
    final boolean bool2 = paramJSONObject.optBoolean("compressed", true);
    Object localObject = q.d.meE;
    p.h(paramJSONObject, "json");
    localObject = q.b.mev;
    localObject = new StringBuilder();
    String str = q.d.meB.name();
    if (str == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramf;
    }
    str = str.toLowerCase();
    p.g(str, "(this as java.lang.String).toLowerCase()");
    localObject = ((StringBuilder)localObject).append(str).append(", ");
    str = q.d.meC.name();
    if (str == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramf;
    }
    str = str.toLowerCase();
    p.g(str, "(this as java.lang.String).toLowerCase()");
    int i = q.b.b.a(paramJSONObject, "sourceType", str, (q.b[])q.d.values());
    localObject = q.a.meu;
    p.h(paramJSONObject, "json");
    localObject = q.b.mev;
    localObject = q.a.mes.name();
    if (localObject == null)
    {
      paramf = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramf;
    }
    localObject = ((String)localObject).toLowerCase();
    p.g(localObject, "(this as java.lang.String).toLowerCase()");
    int j = q.b.b.a(paramJSONObject, "camera", (String)localObject, (q.b[])q.a.values());
    int k = q.c.mey.cSx;
    int m = paramJSONObject.optInt("maxDuration", 60);
    if (m <= 0)
    {
      paramf.i(paramInt, Zf("fail invalid maxDuration"));
      AppMethodBeat.o(50562);
      return;
    }
    if (!bool2) {}
    for (;;)
    {
      paramJSONObject = new c(paramf, i, j, k, bool1, m);
      paramJSONObject = com.tencent.mm.co.g.hio().b((com.tencent.mm.vending.c.a)new c.e(paramJSONObject)).b((com.tencent.mm.vending.c.a)new c.f(paramJSONObject));
      p.g(paramJSONObject, "pipelineExt()\n          …ANCELED\n                }");
      paramJSONObject.g((com.tencent.mm.vending.c.a)new b(this, paramf, paramInt, bool2)).a((d.a)new c(this, paramf, paramInt));
      AppMethodBeat.o(50562);
      return;
      bool1 = false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(g paramg, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class c<T>
    implements d.a<Object>
  {
    c(g paramg, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(50561);
      if ((paramObject instanceof Exception))
      {
        Object localObject = ((Exception)paramObject).getMessage();
        paramObject = localObject;
        if (localObject == null) {
          paramObject = "";
        }
        localObject = paramf;
        int i = paramInt;
        g localg = this.mdy;
        if (n.J(paramObject, "fail", false)) {}
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject).i(i, localg.Zf(paramObject));
          AppMethodBeat.o(50561);
          return;
          paramObject = "fail ".concat(String.valueOf(paramObject));
        }
      }
      g.bHx();
      Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + paramObject + ')');
      paramf.i(paramInt, this.mdy.Zf("fail:internal error"));
      AppMethodBeat.o(50561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g
 * JD-Core Version:    0.7.0.1
 */