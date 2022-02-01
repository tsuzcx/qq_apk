package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import java.io.Reader;
import java.io.StringReader;
import kotlin.f.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "PREFIX", "", "PREFIX$annotations", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getPREFIX", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)Ljava/lang/String;", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class ct
  extends c<e>
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  public static final a oxK;
  
  static
  {
    AppMethodBeat.i(244243);
    oxK = new a((byte)0);
    AppMethodBeat.o(244243);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139845);
    p.k(parame, "service");
    p.k(paramJSONObject, "data");
    String str = paramJSONObject.optString("message");
    paramJSONObject = (CharSequence)str;
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(139845);
      return;
    }
    paramJSONObject = "";
    if ((parame instanceof v)) {
      paramJSONObject = "Service{appId:" + ((v)parame).getAppId() + ",id:" + ((v)parame).getComponentId() + '}';
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject + " print:";
      d.a((Reader)new StringReader(str), (b)new b(paramJSONObject));
      parame.j(paramInt, agS("ok"));
      AppMethodBeat.o(139845);
      return;
      if ((parame instanceof ad)) {
        paramJSONObject = "Page{appId:" + ((ad)parame).getAppId() + ",id:" + ((ad)parame).getComponentId() + '}';
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "line", "", "invoke"})
  static final class b
    extends q
    implements b<String, x>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ct
 * JD-Core Version:    0.7.0.1
 */