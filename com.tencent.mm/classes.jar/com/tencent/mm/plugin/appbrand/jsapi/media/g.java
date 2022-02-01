package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vfs.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;
import d.z;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"})
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  @Deprecated
  public static final a kUF;
  private JsApiChooseVideo kUE;
  
  static
  {
    AppMethodBeat.i(50564);
    kUF = new a((byte)0);
    AppMethodBeat.o(50564);
  }
  
  public g()
  {
    AppMethodBeat.i(50563);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxm, 1) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.kUE = new JsApiChooseVideo();
      }
      AppMethodBeat.o(50563);
      return;
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(50562);
    if (paramc == null) {
      p.gfZ();
    }
    if (paramJSONObject == null) {
      p.gfZ();
    }
    if (this.kUE != null)
    {
      localObject = this.kUE;
      if (localObject == null) {
        p.gfZ();
      }
      ((JsApiChooseVideo)localObject).a(paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(50562);
      return;
    }
    final boolean bool2 = paramJSONObject.optBoolean("compressed", true);
    Object localObject = q.d.kVJ;
    p.h(paramJSONObject, "json");
    localObject = q.b.kVA;
    localObject = new StringBuilder();
    String str = q.d.kVG.name();
    if (str == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramc;
    }
    str = str.toLowerCase();
    p.g(str, "(this as java.lang.String).toLowerCase()");
    localObject = ((StringBuilder)localObject).append(str).append(", ");
    str = q.d.kVH.name();
    if (str == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramc;
    }
    str = str.toLowerCase();
    p.g(str, "(this as java.lang.String).toLowerCase()");
    int i = q.b.b.a(paramJSONObject, "sourceType", str, (q.b[])q.d.values());
    localObject = q.a.kVz;
    p.h(paramJSONObject, "json");
    localObject = q.b.kVA;
    localObject = q.a.kVx.name();
    if (localObject == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramc;
    }
    localObject = ((String)localObject).toLowerCase();
    p.g(localObject, "(this as java.lang.String).toLowerCase()");
    int j = q.b.b.a(paramJSONObject, "camera", (String)localObject, (q.b[])q.a.values());
    int k = q.c.kVD.dDp;
    int m = paramJSONObject.optInt("maxDuration", 60);
    if (m <= 0)
    {
      paramc.h(paramInt, Pg("fail invalid maxDuration"));
      AppMethodBeat.o(50562);
      return;
    }
    if (!bool2) {}
    for (;;)
    {
      paramJSONObject = new c(paramc, i, j, k, bool1, m);
      paramJSONObject = com.tencent.mm.cn.g.fSm().b((com.tencent.mm.vending.c.a)new c.e(paramJSONObject)).b((com.tencent.mm.vending.c.a)new c.f(paramJSONObject));
      p.g(paramJSONObject, "pipelineExt()\n          …ANCELED\n                }");
      paramJSONObject.g((com.tencent.mm.vending.c.a)new b(this, paramc, paramInt, bool2)).a((d.a)new c(this, paramc, paramInt));
      AppMethodBeat.o(50562);
      return;
      bool1 = false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(g paramg, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class c<T>
    implements d.a<Object>
  {
    c(g paramg, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(50561);
      if ((paramObject instanceof Exception))
      {
        Object localObject = ((Exception)paramObject).getMessage();
        paramObject = localObject;
        if (localObject == null) {
          paramObject = "";
        }
        localObject = paramc;
        int i = paramInt;
        g localg = this.kUG;
        if (n.nz(paramObject, "fail")) {}
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).h(i, localg.Pg(paramObject));
          AppMethodBeat.o(50561);
          return;
          paramObject = "fail ".concat(String.valueOf(paramObject));
        }
      }
      g.blq();
      ad.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + paramObject + ')');
      paramc.h(paramInt, this.kUG.Pg("fail:internal error"));
      AppMethodBeat.o(50561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g
 * JD-Core Version:    0.7.0.1
 */