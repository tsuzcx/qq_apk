package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.d;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiSavePageData;", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<T extends a>
  extends bv<T>
{
  public static final a vVu;
  
  static
  {
    AppMethodBeat.i(303148);
    vVu = new a((byte)0);
    AppMethodBeat.o(303148);
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(com.tencent.luggage.d.b<T>.a paramb)
  {
    AppMethodBeat.i(303171);
    if (paramb == null)
    {
      AppMethodBeat.o(303171);
      return;
    }
    Log.d("MicroMsg.GamePrefetchJsApiSavePageData", "[game-web-prefetch] savePageData invokeInOwn");
    Object localObject1 = paramb.eiZ.eif;
    String str = ((JSONObject)localObject1).optString("pageUrl");
    s.s(str, "url");
    if (((CharSequence)str).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramb.a("pageUrl is empty", null);
      AppMethodBeat.o(303171);
      return;
    }
    if (((CharSequence)com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.getHost(str)).length() == 0) {}
    for (i = 1; i != 0; i = 0)
    {
      paramb.a("host invalid", null);
      AppMethodBeat.o(303171);
      return;
    }
    Object localObject3 = ((JSONObject)localObject1).optString("content");
    s.s(localObject3, "content");
    if (((CharSequence)localObject3).length() == 0) {}
    for (i = 1; i != 0; i = 0)
    {
      paramb.a("content is empty", null);
      AppMethodBeat.o(303171);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajl(str);
    Object localObject4 = com.tencent.mm.plugin.az.c.WmU;
    localObject4 = com.tencent.mm.plugin.az.c.ipm();
    Object localObject5 = r.vTf;
    localObject2 = new r.d(str, (String)localObject2, (com.tencent.mm.plugin.az.b)localObject4, r.dfI(), null, null, null, null, false, null, 2032);
    localObject4 = ((r.d)localObject2).vTz;
    s.checkNotNull(localObject4);
    localObject4 = y.n(ah.v(((com.tencent.mm.plugin.az.b)localObject4).bii(((r.d)localObject2).dfT()).mUri), true);
    localObject5 = ((String)localObject3).getBytes(d.UTF_8);
    s.s(localObject5, "(this as java.lang.String).getBytes(charset)");
    i = y.f((String)localObject4, (byte[])localObject5, localObject5.length);
    Log.i("MicroMsg.GamePrefetchJsApiSavePageData", "[game-web-prefetch] savePageData content: " + ((String)localObject3).length() + ", targetPath: " + localObject4 + ", webId: " + ((r.d)localObject2).vTy + ", bizId: " + ((r.d)localObject2).dfT() + ", url: " + str + ", ret: " + i);
    if (i != 0)
    {
      paramb.a("save page data error", null);
      AppMethodBeat.o(303171);
      return;
    }
    localObject1 = ((JSONObject)localObject1).optString("headers");
    s.s(localObject1, "headers");
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.v("MicroMsg.GamePrefetchJsApiSavePageData", s.X("[game-web-prefetch] savePageData saveHeaders: ", localObject1));
        localObject3 = new JSONObject((String)localObject1);
        localObject1 = Integer.valueOf(((JSONObject)localObject3).optInt("x-wx-max-cache", -1));
        if (((Number)localObject1).intValue() <= 0) {
          break label596;
        }
        i = 1;
        label459:
        if (i == 0) {
          break label601;
        }
        label463:
        if (localObject1 != null)
        {
          i = ((Number)localObject1).intValue();
          ((Map)((r.d)localObject2).dgb()).put("x-wx-max-cache", p.listOf(String.valueOf(i)));
        }
        localObject1 = Integer.valueOf(((JSONObject)localObject3).optInt("max-age", -1));
        if (((Number)localObject1).intValue() <= 0) {
          break label606;
        }
        i = 1;
        label524:
        if (i == 0) {
          break label611;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        ((Map)((r.d)localObject2).dgb()).put("max-age", p.listOf(String.valueOf(i)));
      }
      ((r.d)localObject2).a(r.e.vTV, com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.getHost(str));
      paramb.a("", null);
      AppMethodBeat.o(303171);
      return;
      i = 0;
      break;
      label596:
      i = 0;
      break label459;
      label601:
      localObject1 = null;
      break label463;
      label606:
      i = 0;
      break label524;
      label611:
      localObject1 = null;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "savePageData";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiSavePageData$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.c
 * JD-Core Version:    0.7.0.1
 */