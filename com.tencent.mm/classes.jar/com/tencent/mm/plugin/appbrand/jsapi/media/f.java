package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vfs.e;
import d.g.b.k;
import d.n.n;
import d.v;
import d.y;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  @Deprecated
  public static final a jXJ;
  private JsApiChooseVideo jXI;
  
  static
  {
    AppMethodBeat.i(50564);
    jXJ = new a((byte)0);
    AppMethodBeat.o(50564);
  }
  
  public f()
  {
    AppMethodBeat.i(50563);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poX, 1) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jXI = new JsApiChooseVideo();
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
      k.fvU();
    }
    if (paramJSONObject == null) {
      k.fvU();
    }
    if (this.jXI != null)
    {
      localObject = this.jXI;
      if (localObject == null) {
        k.fvU();
      }
      ((JsApiChooseVideo)localObject).a(paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(50562);
      return;
    }
    final boolean bool2 = paramJSONObject.optBoolean("compressed", true);
    Object localObject = p.d.jYN;
    k.h(paramJSONObject, "json");
    localObject = p.b.jYE;
    localObject = new StringBuilder();
    String str = p.d.jYK.name();
    if (str == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramc;
    }
    str = str.toLowerCase();
    k.g(str, "(this as java.lang.String).toLowerCase()");
    localObject = ((StringBuilder)localObject).append(str).append(", ");
    str = p.d.jYL.name();
    if (str == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramc;
    }
    str = str.toLowerCase();
    k.g(str, "(this as java.lang.String).toLowerCase()");
    int i = p.b.b.a(paramJSONObject, "sourceType", str, (p.b[])p.d.values());
    localObject = p.a.jYD;
    k.h(paramJSONObject, "json");
    localObject = p.b.jYE;
    localObject = p.a.jYB.name();
    if (localObject == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramc;
    }
    localObject = ((String)localObject).toLowerCase();
    k.g(localObject, "(this as java.lang.String).toLowerCase()");
    int j = p.b.b.a(paramJSONObject, "camera", (String)localObject, (p.b[])p.a.values());
    int k = p.c.jYH.dtM;
    int m = paramJSONObject.optInt("maxDuration", 60);
    if (m <= 0)
    {
      paramc.h(paramInt, HI("fail invalid maxDuration"));
      AppMethodBeat.o(50562);
      return;
    }
    if (!bool2) {}
    for (;;)
    {
      paramJSONObject = new c(paramc, i, j, k, bool1, m);
      paramJSONObject = com.tencent.mm.co.g.fkM().b((com.tencent.mm.vending.c.a)new c.e(paramJSONObject)).b((com.tencent.mm.vending.c.a)new c.f(paramJSONObject));
      k.g(paramJSONObject, "pipelineExt()\n          …ANCELED\n                }");
      paramJSONObject.g((com.tencent.mm.vending.c.a)new b(this, paramc, paramInt, bool2)).a((d.a)new c(this, paramc, paramInt));
      AppMethodBeat.o(50562);
      return;
      bool1 = false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(f paramf, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class c<T>
    implements d.a<Object>
  {
    c(f paramf, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
    
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
        f localf = this.jXK;
        if (n.mA(paramObject, "fail")) {}
        for (;;)
        {
          ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).h(i, localf.HI(paramObject));
          AppMethodBeat.o(50561);
          return;
          paramObject = "fail ".concat(String.valueOf(paramObject));
        }
      }
      f.baQ();
      ad.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + paramObject + ')');
      paramc.h(paramInt, this.jXK.HI("fail:internal error"));
      AppMethodBeat.o(50561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f
 * JD-Core Version:    0.7.0.1
 */