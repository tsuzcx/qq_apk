package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.b.g;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.b.i;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends c<y>
{
  public static final int CTRL_INDEX = 772;
  public static final String NAME = "setNavigateBackConfirmDialog";
  public static final x.a soa;
  
  static
  {
    AppMethodBeat.i(177324);
    soa = new x.a((byte)0);
    AppMethodBeat.o(177324);
  }
  
  private static final void a(u paramu, y paramy, boolean paramBoolean, int paramInt, x paramx, ah.f paramf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(327701);
    s.u(paramx, "this$0");
    s.u(paramf, "$content");
    Object localObject2;
    if (paramu == null)
    {
      paramu = null;
      localObject2 = (CharSequence)paramu;
      paramu = paramy.getRuntime().getPageContainer().getCurrentPage();
      if (paramu != null) {
        break label77;
      }
    }
    label77:
    for (paramu = null;; paramu = paramu.getCurrentUrl())
    {
      if (TextUtils.equals((CharSequence)localObject2, (CharSequence)paramu)) {
        break label85;
      }
      AppMethodBeat.o(327701);
      return;
      paramu = paramu.getCurrentUrl();
      break;
    }
    label85:
    i locali;
    if (paramBoolean)
    {
      paramu = (List)new ArrayList();
      localObject2 = ((Iterable)p.listOf(new String[] { "scene_actionbar_back", "scene_back_key_pressed", "scene_jsapi_navigate_back" })).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramu.add(new h(paramBoolean, (String)((Iterator)localObject2).next()));
      }
      localObject2 = paramy.getRuntime().getPageContainer().getCurrentPage();
      if (localObject2 != null)
      {
        locali = i.tCY;
        if (paramu != null) {
          break label230;
        }
      }
    }
    for (paramu = localObject1;; paramu = new g((String)paramf, paramu))
    {
      ((u)localObject2).a(locali, paramu);
      paramy.callback(paramInt, paramx.ZP("ok"));
      AppMethodBeat.o(327701);
      return;
      paramu = null;
      break;
      label230:
      paramf = paramf.aqH;
      s.s(paramf, "content");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.x
 * JD-Core Version:    0.7.0.1
 */