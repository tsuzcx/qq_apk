package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "extraInfo", "Lorg/json/JSONObject;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "dispatch", "", "receiver", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "putExtraInfo", "value", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  @Deprecated
  public static final a.a pkJ;
  public long endTime;
  private String name;
  private final JSONObject pkI;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(162176);
    pkJ = new a.a((byte)0);
    AppMethodBeat.o(162176);
  }
  
  public a()
  {
    AppMethodBeat.i(162175);
    this.name = "";
    this.pkI = new JSONObject();
    AppMethodBeat.o(162175);
  }
  
  public final void q(v paramv)
  {
    AppMethodBeat.i(162174);
    p.k(paramv, "receiver");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", this.name);
    localJSONObject.put("startTime", this.startTime);
    localJSONObject.put("endTime", this.endTime);
    localJSONObject.put("extraInfo", this.pkI);
    Log.i("MicroMsg.AppBrand.EventOnNewPerformanceMetric", "dispatch ".concat(String.valueOf(localJSONObject)));
    paramv.ct("onNewPerformanceMetric", localJSONObject.toString());
    AppMethodBeat.o(162174);
  }
  
  public final void q(String paramString, Object paramObject)
  {
    AppMethodBeat.i(162173);
    p.k(paramString, "name");
    p.k(paramObject, "value");
    this.pkI.put(paramString, paramObject);
    AppMethodBeat.o(162173);
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(162172);
    p.k(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(162172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.a
 * JD-Core Version:    0.7.0.1
 */