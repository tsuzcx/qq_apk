package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class j
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231630);
    if (paramJSONObject == null)
    {
      this.Ega.aNa("invalid_params");
      AppMethodBeat.o(231630);
      return;
    }
    paramString = MMApplicationContext.getContext();
    if (com.tencent.mm.plugin.game.luggage.b.gp(paramString))
    {
      this.Ega.aNa("exist_tab");
      AppMethodBeat.o(231630);
      return;
    }
    String str = paramJSONObject.optString("tabKey");
    Log.i("LiteAppJsApiOpenGameTabHome", "tabKey:[%s]", new Object[] { str });
    long l1 = paramJSONObject.optLong("sourceid", 0L);
    long l2 = paramJSONObject.optLong("ssid", 0L);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("from_find_more_friend", false);
    paramJSONObject.putExtra("game_report_from_scene", 5);
    paramJSONObject.putExtra("start_time", System.currentTimeMillis());
    paramJSONObject.putExtra("has_game_life_chat_msg", false);
    paramJSONObject.putExtra("default_game_tab_key", str);
    paramJSONObject.putExtra("disable_game_page_swipe", true);
    paramJSONObject.putExtra("game_report_sourceid", l1);
    paramJSONObject.putExtra("game_report_ssid", l2);
    c.b(paramString, "game", ".ui.GameCenterUI", paramJSONObject);
    this.Ega.eLC();
    AppMethodBeat.o(231630);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.j
 * JD-Core Version:    0.7.0.1
 */