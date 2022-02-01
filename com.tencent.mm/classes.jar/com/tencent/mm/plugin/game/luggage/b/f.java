package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/jsapi/JsApiChatRoomAtMember;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "Lcom/tencent/luggage/container/LuggageComponent;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends bv<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277134);
    Object localObject = c.ZL(paramString);
    if (localObject == null)
    {
      s.checkNotNull(parama);
      parama.j("invalid_params", null);
      AppMethodBeat.o(277134);
      return;
    }
    paramContext = ((JSONObject)localObject).optString("chatRoomName");
    paramString = ((JSONObject)localObject).optString("userName");
    localObject = ((JSONObject)localObject).optString("nickName");
    if ((Util.isNullOrNil(paramContext)) || (Util.isNullOrNil(paramString)) || (Util.isNullOrNil((String)localObject)))
    {
      s.checkNotNull(parama);
      parama.j("invalid_params", null);
      AppMethodBeat.o(277134);
      return;
    }
    ((com.tencent.mm.plugin.game.chatroom.a.a)h.az(com.tencent.mm.plugin.game.chatroom.a.a.class)).callAtFunction(paramContext, paramString, (String)localObject);
    s.checkNotNull(parama);
    parama.j(null, null);
    AppMethodBeat.o(277134);
  }
  
  public final void b(b<com.tencent.luggage.d.a>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "chatRoomAtMember";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */