package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/jsapi/JsApiRecordOperateUserData;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "Lcom/tencent/luggage/container/LuggageComponent;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends bv<a>
{
  public static final a Ivb;
  
  static
  {
    AppMethodBeat.i(277172);
    Ivb = new a((byte)0);
    AppMethodBeat.o(277172);
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277183);
    paramContext = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (paramContext == null)
    {
      s.checkNotNull(parama);
      parama.j("fail", null);
      AppMethodBeat.o(277183);
      return;
    }
    Log.i("MicroMsg.JsApiRecordOperateUserData", s.X("data: ", paramContext));
    paramContext = paramContext.optString("datalist");
    if (paramContext != null) {
      com.tencent.luggage.sdk.h.c.a((JSONArray)new f(paramContext), (kotlin.g.a.b)b.Ivc);
    }
    s.checkNotNull(parama);
    parama.j(null, null);
    AppMethodBeat.o(277183);
  }
  
  public final void b(com.tencent.luggage.d.b<a>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "recordOperateUserData";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/jsapi/JsApiRecordOperateUserData$Companion;", "", "()V", "TAG", "", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/json/InnerJSONObjectImpl;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<d, ah>
  {
    public static final b Ivc;
    
    static
    {
      AppMethodBeat.i(277148);
      Ivc = new b();
      AppMethodBeat.o(277148);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ak
 * JD-Core Version:    0.7.0.1
 */