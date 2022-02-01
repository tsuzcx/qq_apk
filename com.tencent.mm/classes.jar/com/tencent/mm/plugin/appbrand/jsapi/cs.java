package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import java.io.Reader;
import java.io.StringReader;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "PREFIX", "", "PREFIX$annotations", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getPREFIX", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)Ljava/lang/String;", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"})
public final class cs
  extends d<f>
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  public static final a lCk;
  
  static
  {
    AppMethodBeat.i(219676);
    lCk = new a((byte)0);
    AppMethodBeat.o(219676);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139845);
    p.h(paramf, "service");
    p.h(paramJSONObject, "data");
    String str = paramJSONObject.optString("message");
    paramJSONObject = (CharSequence)str;
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(139845);
      return;
    }
    paramJSONObject = "";
    if ((paramf instanceof s)) {
      paramJSONObject = "Service{appId:" + ((s)paramf).getAppId() + ",id:" + ((s)paramf).getComponentId() + '}';
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject + " print:";
      kotlin.f.d.a((Reader)new StringReader(str), (b)new cs.b(paramJSONObject));
      paramf.i(paramInt, Zf("ok"));
      AppMethodBeat.o(139845);
      return;
      if ((paramf instanceof ac)) {
        paramJSONObject = "Page{appId:" + ((ac)paramf).getAppId() + ",id:" + ((ac)paramf).getComponentId() + '}';
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cs
 * JD-Core Version:    0.7.0.1
 */