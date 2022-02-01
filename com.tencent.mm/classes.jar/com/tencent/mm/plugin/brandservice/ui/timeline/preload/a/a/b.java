package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiSavePageData;", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "plugin-brandservice_release"})
public final class b<T extends a>
  extends br<T>
{
  public static final a sQf;
  
  static
  {
    AppMethodBeat.i(260065);
    sQf = new a((byte)0);
    AppMethodBeat.o(260065);
  }
  
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(com.tencent.luggage.d.b<T>.a paramb)
  {
    AppMethodBeat.i(260058);
    if (paramb == null)
    {
      AppMethodBeat.o(260058);
      return;
    }
    Log.d("MicroMsg.GamePrefetchJsApiSavePageData", "[game-web-prefetch] savePageData invokeInOwn");
    Object localObject1 = paramb.NN();
    String str = ((JSONObject)localObject1).optString("pageUrl");
    p.j(str, "url");
    if (((CharSequence)str).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramb.dr("pageUrl is empty");
      AppMethodBeat.o(260058);
      return;
    }
    if (((CharSequence)com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.getHost(str)).length() == 0) {}
    for (i = 1; i != 0; i = 0)
    {
      paramb.dr("host invalid");
      AppMethodBeat.o(260058);
      return;
    }
    Object localObject3 = ((JSONObject)localObject1).optString("content");
    p.j(localObject3, "content");
    if (((CharSequence)localObject3).length() == 0) {}
    for (i = 1; i != 0; i = 0)
    {
      paramb.dr("content is empty");
      AppMethodBeat.o(260058);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apK(str);
    Object localObject4 = com.tencent.mm.plugin.ax.c.PwQ;
    localObject4 = com.tencent.mm.plugin.ax.c.gPW();
    Object localObject5 = s.sNX;
    localObject2 = new s.d(str, (String)localObject2, (com.tencent.mm.plugin.ax.b)localObject4, s.cCy(), null, null, null, null, false, 496);
    localObject4 = ((s.d)localObject2).sOm;
    if (localObject4 == null) {
      p.iCn();
    }
    localObject4 = u.n(((com.tencent.mm.plugin.ax.b)localObject4).biA(((s.d)localObject2).cCK()).getPath(), true);
    localObject5 = ((String)localObject3).getBytes(d.UTF_8);
    p.j(localObject5, "(this as java.lang.String).getBytes(charset)");
    i = u.H((String)localObject4, (byte[])localObject5);
    Log.i("MicroMsg.GamePrefetchJsApiSavePageData", "[game-web-prefetch] savePageData content: " + ((String)localObject3).length() + ", targetPath: " + (String)localObject4 + ", webId: " + ((s.d)localObject2).sOl + ", bizId: " + ((s.d)localObject2).cCK() + ", url: " + str + ", ret: " + i);
    if (i != 0)
    {
      paramb.dr("save page data error");
      AppMethodBeat.o(260058);
      return;
    }
    localObject1 = ((JSONObject)localObject1).optString("headers");
    p.j(localObject1, "headers");
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.v("MicroMsg.GamePrefetchJsApiSavePageData", "[game-web-prefetch] savePageData saveHeaders: ".concat(String.valueOf(localObject1)));
        localObject3 = new JSONObject((String)localObject1);
        localObject1 = Integer.valueOf(((JSONObject)localObject3).optInt("x-wx-max-cache", -1));
        if (((Number)localObject1).intValue() <= 0) {
          break label582;
        }
        i = 1;
        label450:
        if (i == 0) {
          break label587;
        }
        label454:
        if (localObject1 != null)
        {
          i = ((Number)localObject1).intValue();
          ((Map)((s.d)localObject2).cCO()).put("x-wx-max-cache", j.listOf(String.valueOf(i)));
        }
        localObject1 = Integer.valueOf(((JSONObject)localObject3).optInt("max-age", -1));
        if (((Number)localObject1).intValue() <= 0) {
          break label592;
        }
        i = 1;
        label514:
        if (i == 0) {
          break label597;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        ((Map)((s.d)localObject2).cCO()).put("max-age", j.listOf(String.valueOf(i)));
      }
      ((s.d)localObject2).a(s.e.sOw, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.getHost(str));
      paramb.NT();
      AppMethodBeat.o(260058);
      return;
      i = 0;
      break;
      label582:
      i = 0;
      break label450;
      label587:
      localObject1 = null;
      break label454;
      label592:
      i = 0;
      break label514;
      label597:
      localObject1 = null;
    }
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "savePageData";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiSavePageData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.b
 * JD-Core Version:    0.7.0.1
 */