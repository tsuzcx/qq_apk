package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/customer_service/JsApiOpenCustomerServiceChat;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "getCurrentPageId", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "onCallback", "service", "errCode", "errMsg", "openCustomerServiceChat", "extInfo", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<y>
{
  private static final int CTRL_INDEX = 1040;
  private static final String NAME = "openCustomerServiceChat";
  public static final a.a rUg;
  
  static
  {
    AppMethodBeat.i(325639);
    rUg = new a.a((byte)0);
    AppMethodBeat.o(325639);
  }
  
  private final void a(y paramy, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(325632);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt2));
    if (paramInt2 != 0)
    {
      if (paramy != null)
      {
        paramy.callback(paramInt1, m(s.X("fail ", paramString), (Map)localHashMap));
        AppMethodBeat.o(325632);
      }
    }
    else if (paramy != null) {
      paramy.callback(paramInt1, m("ok", (Map)localHashMap));
    }
    AppMethodBeat.o(325632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a
 * JD-Core Version:    0.7.0.1
 */