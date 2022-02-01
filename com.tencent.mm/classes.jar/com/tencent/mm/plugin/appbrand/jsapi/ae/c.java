package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNew;", "Component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "", "()V", "handleInvoke", "", "", "component", "reqData", "Lorg/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;)Ljava/util/Map;", "type", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)Ljava/util/Map;", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c<Component extends f>
{
  public static final a swp;
  
  static
  {
    AppMethodBeat.i(326046);
    swp = new a((byte)0);
    AppMethodBeat.o(326046);
  }
  
  public Map<String, Object> a(String paramString, Component paramComponent)
  {
    AppMethodBeat.i(326050);
    s.u(paramString, "type");
    s.u(paramComponent, "component");
    AppMethodBeat.o(326050);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNew$Companion;", "", "()V", "PARAM_KEY_TYPE", "", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.c
 * JD-Core Version:    0.7.0.1
 */