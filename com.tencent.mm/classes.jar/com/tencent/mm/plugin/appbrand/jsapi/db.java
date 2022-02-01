package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.d;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "PREFIX", "", "getPREFIX$annotations", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getPREFIX", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)Ljava/lang/String;", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class db
  extends c<f>
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  public static final a rBj;
  
  static
  {
    AppMethodBeat.i(325465);
    rBj = new a((byte)0);
    AppMethodBeat.o(325465);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139845);
    s.u(paramf, "service");
    s.u(paramJSONObject, "data");
    String str = paramJSONObject.optString("message");
    paramJSONObject = (CharSequence)str;
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(139845);
      return;
    }
    paramJSONObject = "";
    if ((paramf instanceof y)) {
      paramJSONObject = "Service{appId:" + ((y)paramf).getAppId() + ",id:" + ((y)paramf).getComponentId() + '}';
    }
    for (;;)
    {
      paramJSONObject = s.X(paramJSONObject, " print:");
      d.a((Reader)new StringReader(str), (b)new b(paramJSONObject));
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(139845);
      return;
      if ((paramf instanceof ad)) {
        paramJSONObject = "Page{appId:" + ((ad)paramf).getAppId() + ",id:" + ((ad)paramf).getComponentId() + '}';
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "line", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<String, ah>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.db
 * JD-Core Version:    0.7.0.1
 */