package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public class w
  extends br<com.tencent.luggage.d.a>
{
  public final void a(final Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(231466);
    Log.i("MicroMsg.JsApiOpenGameLifeChatroom", "invokeInMM");
    paramString = c.agO(paramString);
    if (paramString == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(231466);
      return;
    }
    String str1 = paramString.optString("chatroom_name");
    if (Util.isNullOrNil(str1))
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(231466);
      return;
    }
    String str2 = paramString.optString("chatroom_icon");
    boolean bool1 = paramString.optBoolean("is_auto_join", false);
    long l1 = paramString.optLong("sourceid", 0L);
    long l2 = paramString.optLong("ssid", 0L);
    boolean bool2 = paramString.optBoolean("backToRoomList", false);
    Log.i("MicroMsg.JsApiOpenGameLifeChatroom", "chatRoomName:%s, iconUrl:%s, isAutoJoin:%b, sourceId:%d, ssid:%d, backToRoomList:%b", new Object[] { str1, str2, Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool2) });
    ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(231992);
        if (paramAnonymousInt1 == 3345)
        {
          ((MMActivity)paramContext).mmSetOnActivityResultCallback(null);
          parama.i(null, null);
        }
        AppMethodBeat.o(231992);
      }
    });
    ((com.tencent.mm.plugin.game.chatroom.a.a)h.ag(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoomFromWeb(paramContext, str1, str2, bool1, l2, l1, bool2, 3345);
    AppMethodBeat.o(231466);
  }
  
  public final void b(b.a parama) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameLifeChatroom";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */