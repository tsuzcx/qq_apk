package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class y
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(231108);
    Log.i("MicroMsg.JsApiOpenGameTabHome", "invokeInMM");
    Object localObject = com.tencent.mm.plugin.webview.luggage.c.c.agO(paramString);
    if (localObject == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(231108);
      return;
    }
    if (com.tencent.mm.plugin.game.luggage.b.gp(paramContext))
    {
      parama.i("exist_tab", null);
      AppMethodBeat.o(231108);
      return;
    }
    paramString = ((JSONObject)localObject).optString("tabKey");
    Log.i("MicroMsg.JsApiOpenGameTabHome", "tabKey:[%s]", new Object[] { paramString });
    long l1 = ((JSONObject)localObject).optLong("sourceid", 0L);
    long l2 = ((JSONObject)localObject).optLong("ssid", 0L);
    localObject = new Intent();
    ((Intent)localObject).putExtra("from_find_more_friend", false);
    ((Intent)localObject).putExtra("game_report_from_scene", 5);
    ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("default_game_tab_key", paramString);
    ((Intent)localObject).putExtra("disable_game_page_swipe", true);
    ((Intent)localObject).putExtra("game_report_sourceid", l1);
    ((Intent)localObject).putExtra("game_report_ssid", l2);
    com.tencent.mm.by.c.b(paramContext, "game", ".ui.GameCenterUI", (Intent)localObject);
    parama.i(null, null);
    AppMethodBeat.o(231108);
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameTabHome";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.y
 * JD-Core Version:    0.7.0.1
 */