package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "extraInfo", "Lorg/json/JSONObject;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "dispatch", "", "receiver", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "putExtraInfo", "value", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  @Deprecated
  public static final a mmB;
  public long endTime;
  private final JSONObject mmA;
  private String name;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(162176);
    mmB = new a((byte)0);
    AppMethodBeat.o(162176);
  }
  
  public a()
  {
    AppMethodBeat.i(162175);
    this.name = "";
    this.mmA = new JSONObject();
    AppMethodBeat.o(162175);
  }
  
  public final void d(s params)
  {
    AppMethodBeat.i(162174);
    p.h(params, "receiver");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", this.name);
    localJSONObject.put("startTime", this.startTime);
    localJSONObject.put("endTime", this.endTime);
    localJSONObject.put("extraInfo", this.mmA);
    Log.i("MicroMsg.AppBrand.EventOnNewPerformanceMetric", "dispatch ".concat(String.valueOf(localJSONObject)));
    params.co("onNewPerformanceMetric", localJSONObject.toString());
    AppMethodBeat.o(162174);
  }
  
  public final void r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(162173);
    p.h(paramString, "name");
    p.h(paramObject, "value");
    this.mmA.put(paramString, paramObject);
    AppMethodBeat.o(162173);
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(162172);
    p.h(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(162172);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.a
 * JD-Core Version:    0.7.0.1
 */