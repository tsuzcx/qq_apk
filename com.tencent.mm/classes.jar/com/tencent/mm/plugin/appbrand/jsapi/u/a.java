package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/perf/EventOnNewPerformanceMetric;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "extraInfo", "Lorg/json/JSONObject;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "dispatch", "", "receiver", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "putExtraInfo", "value", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final a.a spJ;
  public long endTime;
  private String name;
  private final JSONObject spK;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(162176);
    spJ = new a.a((byte)0);
    AppMethodBeat.o(162176);
  }
  
  public a()
  {
    AppMethodBeat.i(162175);
    this.name = "";
    this.spK = new JSONObject();
    AppMethodBeat.o(162175);
  }
  
  public final void q(y paramy)
  {
    AppMethodBeat.i(162174);
    s.u(paramy, "receiver");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", this.name);
    localJSONObject.put("startTime", this.startTime);
    localJSONObject.put("endTime", this.endTime);
    localJSONObject.put("extraInfo", this.spK);
    Log.i("MicroMsg.AppBrand.EventOnNewPerformanceMetric", s.X("dispatch ", localJSONObject));
    paramy.cJ("onNewPerformanceMetric", localJSONObject.toString());
    AppMethodBeat.o(162174);
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(162172);
    s.u(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(162172);
  }
  
  public final void y(String paramString, Object paramObject)
  {
    AppMethodBeat.i(162173);
    s.u(paramString, "name");
    s.u(paramObject, "value");
    this.spK.put(paramString, paramObject);
    AppMethodBeat.o(162173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a
 * JD-Core Version:    0.7.0.1
 */