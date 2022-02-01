package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "extraInfo", "Lorg/json/JSONObject;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "dispatch", "", "receiver", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "putExtraInfo", "value", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  @Deprecated
  public static final a kHc;
  public long endTime;
  private final JSONObject kHb;
  private String name;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(162176);
    kHc = new a((byte)0);
    AppMethodBeat.o(162176);
  }
  
  public a()
  {
    AppMethodBeat.i(162175);
    this.name = "";
    this.kHb = new JSONObject();
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
    localJSONObject.put("extraInfo", this.kHb);
    ac.i("MicroMsg.AppBrand.EventOnNewPerformanceMetric", "dispatch ".concat(String.valueOf(localJSONObject)));
    paramq.bZ("onNewPerformanceMetric", localJSONObject.toString());
    AppMethodBeat.o(162174);
  }
  
  public final void s(String paramString, Object paramObject)
  {
    AppMethodBeat.i(162173);
    k.h(paramString, "name");
    k.h(paramObject, "value");
    this.kHb.put(paramString, paramObject);
    AppMethodBeat.o(162173);
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(162172);
    k.h(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(162172);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a
 * JD-Core Version:    0.7.0.1
 */