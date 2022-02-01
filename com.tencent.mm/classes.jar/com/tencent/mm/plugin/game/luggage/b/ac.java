package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class ac
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277176);
    Log.i("MicroMsg.JsApiOpenGameTabHome", "invokeInMM");
    Object localObject = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (localObject == null)
    {
      parama.j("invalid_params", null);
      AppMethodBeat.o(277176);
      return;
    }
    if (com.tencent.mm.plugin.game.luggage.b.fEl())
    {
      parama.j("exist_tab", null);
      AppMethodBeat.o(277176);
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
    com.tencent.mm.br.c.b(paramContext, "game", ".ui.GameCenterUI", (Intent)localObject);
    parama.j(null, null);
    AppMethodBeat.o(277176);
  }
  
  public final void b(com.tencent.luggage.d.b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameTabHome";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ac
 * JD-Core Version:    0.7.0.1
 */