package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.vending.g.d.a;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"})
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  @Deprecated
  public static final f.a hRN;
  private JsApiChooseVideo hRM;
  
  static
  {
    AppMethodBeat.i(143827);
    hRN = new f.a((byte)0);
    AppMethodBeat.o(143827);
  }
  
  public f()
  {
    AppMethodBeat.i(143826);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVs, 1) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.hRM = new JsApiChooseVideo();
      }
      AppMethodBeat.o(143826);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(143825);
    if (paramc == null) {
      j.ebi();
    }
    if (paramJSONObject == null) {
      j.ebi();
    }
    if (this.hRM != null)
    {
      localObject = this.hRM;
      if (localObject == null) {
        j.ebi();
      }
      ((JsApiChooseVideo)localObject).a(paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(143825);
      return;
    }
    boolean bool2 = paramJSONObject.optBoolean("compressed", true);
    Object localObject = m.d.hSN;
    j.q(paramJSONObject, "json");
    localObject = m.b.hSE;
    localObject = new StringBuilder();
    String str = m.d.hSK.name();
    if (str == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(143825);
      throw paramc;
    }
    str = str.toLowerCase();
    j.p(str, "(this as java.lang.String).toLowerCase()");
    localObject = ((StringBuilder)localObject).append(str).append(", ");
    str = m.d.hSL.name();
    if (str == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(143825);
      throw paramc;
    }
    str = str.toLowerCase();
    j.p(str, "(this as java.lang.String).toLowerCase()");
    int i = m.b.b.a(paramJSONObject, "sourceType", str, (m.b[])m.d.values());
    localObject = m.a.hSD;
    j.q(paramJSONObject, "json");
    localObject = m.b.hSE;
    localObject = m.a.hSB.name();
    if (localObject == null)
    {
      paramc = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(143825);
      throw paramc;
    }
    localObject = ((String)localObject).toLowerCase();
    j.p(localObject, "(this as java.lang.String).toLowerCase()");
    int j = m.b.b.a(paramJSONObject, "camera", (String)localObject, (m.b[])m.a.values());
    int k = m.c.hSH.bsY;
    int m = paramJSONObject.optInt("maxDuration", 60);
    if (m <= 0)
    {
      paramc.h(paramInt, BL("fail invalid maxDuration"));
      AppMethodBeat.o(143825);
      return;
    }
    e.eX(false);
    if (!bool2) {}
    for (;;)
    {
      paramJSONObject = new c(paramc, i, j, k, bool1, m);
      paramJSONObject = com.tencent.mm.cm.g.dTg().b((com.tencent.mm.vending.c.a)new c.e(paramJSONObject)).b((com.tencent.mm.vending.c.a)new c.f(paramJSONObject));
      j.p(paramJSONObject, "pipelineExt()\n          …ANCELED\n                }");
      paramJSONObject.g((com.tencent.mm.vending.c.a)new f.b(this, paramc, paramInt, bool2)).a((d.a)new f.c(this, paramc, paramInt));
      AppMethodBeat.o(143825);
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f
 * JD-Core Version:    0.7.0.1
 */