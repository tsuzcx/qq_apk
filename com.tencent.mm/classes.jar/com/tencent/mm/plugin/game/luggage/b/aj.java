package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.a;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class aj
  extends bv<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(277174);
    Object localObject = paramb.eiZ.eif;
    if (localObject == null)
    {
      paramb.a("invalid_params", null);
      AppMethodBeat.o(277174);
      return;
    }
    localObject = ((JSONObject)localObject).optString("chatroom_name");
    if (Util.isNullOrNil((String)localObject))
    {
      paramb.a("invalid_params", null);
      AppMethodBeat.o(277174);
      return;
    }
    Log.i("MicroMsg.JsApiQuitGameLifeChatroom", "chatRoomName:%s", new Object[] { localObject });
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.game.ACTION_QUIT_CHAT_ROOM");
    localIntent.putExtra("chatroom_name", (String)localObject);
    MMApplicationContext.getContext().sendBroadcast(localIntent, a.HRS);
    paramb.a("", null);
    ((GameWebPage)paramb.eiY).iR(true);
    AppMethodBeat.o(277174);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "quitGameLifeChatroom";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.aj
 * JD-Core Version:    0.7.0.1
 */