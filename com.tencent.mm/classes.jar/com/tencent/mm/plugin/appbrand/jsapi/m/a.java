package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "extraInfo", "Lorg/json/JSONObject;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "dispatch", "", "receiver", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "putExtraInfo", "value", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  @Deprecated
  public static final a kgm;
  public long endTime;
  private final JSONObject kgl;
  private String name;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(162176);
    kgm = new a((byte)0);
    AppMethodBeat.o(162176);
  }
  
  public a()
  {
    AppMethodBeat.i(162175);
    this.name = "";
    this.kgl = new JSONObject();
    AppMethodBeat.o(162175);
  }
  
  public final void c(q paramq)
  {
    AppMethodBeat.i(162174);
    k.h(paramq, "receiver");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", this.name);
    localJSONObject.put("startTime", this.startTime);
    localJSONObject.put("endTime", this.endTime);
    localJSONObject.put("extraInfo", this.kgl);
    ad.i("MicroMsg.AppBrand.EventOnNewPerformanceMetric", "dispatch ".concat(String.valueOf(localJSONObject)));
    paramq.bR("onNewPerformanceMetric", localJSONObject.toString());
    AppMethodBeat.o(162174);
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(162172);
    k.h(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(162172);
  }
  
  public final void t(String paramString, Object paramObject)
  {
    AppMethodBeat.i(162173);
    k.h(paramString, "name");
    k.h(paramObject, "value");
    this.kgl.put(paramString, paramObject);
    AppMethodBeat.o(162173);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */