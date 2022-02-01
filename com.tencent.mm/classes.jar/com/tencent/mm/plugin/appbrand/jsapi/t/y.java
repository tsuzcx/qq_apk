package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackInterception;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/NavigateBackInterceptionConstant;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isEmpty", "", "Lorg/json/JSONArray;", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends c<com.tencent.mm.plugin.appbrand.y>
{
  public static final int CTRL_INDEX = 880;
  public static final String NAME = "setNavigateBackInterception";
  public static final y.a sob;
  
  static
  {
    AppMethodBeat.i(327703);
    sob = new y.a((byte)0);
    AppMethodBeat.o(327703);
  }
  
  private static final void a(u paramu, com.tencent.mm.plugin.appbrand.y paramy, ah.a parama, ArrayList paramArrayList, int paramInt, y paramy1)
  {
    Object localObject1 = null;
    AppMethodBeat.i(327700);
    s.u(parama, "$anyEnable");
    s.u(paramArrayList, "$sceneInfo");
    s.u(paramy1, "this$0");
    if (paramu == null)
    {
      paramu = null;
      localObject2 = (CharSequence)paramu;
      paramu = paramy.getRuntime().getPageContainer().getCurrentPage();
      if (paramu != null) {
        break label82;
      }
    }
    label82:
    for (paramu = null;; paramu = paramu.getCurrentUrl())
    {
      if (TextUtils.equals((CharSequence)localObject2, (CharSequence)paramu)) {
        break label90;
      }
      AppMethodBeat.o(327700);
      return;
      paramu = paramu.getCurrentUrl();
      break;
    }
    label90:
    Object localObject2 = paramy.getRuntime().getPageContainer().getCurrentPage();
    if (localObject2 != null)
    {
      i locali = i.tCX;
      paramu = localObject1;
      if (parama.aiwY) {
        paramu = new g(null, (List)paramArrayList, 1);
      }
      ((u)localObject2).a(locali, paramu);
    }
    paramy.callback(paramInt, paramy1.ZP("ok"));
    AppMethodBeat.o(327700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.y
 * JD-Core Version:    0.7.0.1
 */