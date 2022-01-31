package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends aw<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    for (;;)
    {
      int k;
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        int j = paramString.optInt("jumpView");
        k = paramString.optInt("jumpType");
        y.i("MicroMsg.JsApiOpenGameCenter", "jumpView = %d, jumpType = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        localObject = paramString.optJSONObject("extInfo");
        if (localObject != null)
        {
          i = ((JSONObject)localObject).optInt("ssid");
          paramString = new Intent();
          switch (j)
          {
          default: 
            parama.e(null, null);
            return;
          }
        }
      }
      catch (JSONException paramContext)
      {
        y.e("MicroMsg.JsApiOpenGameCenter", "json parse exception");
        parama.e("fail", null);
        return;
      }
      int i = 0;
      continue;
      paramString.setClass(paramContext, GameCenterUI.class);
      if (k == 1) {
        paramString.putExtra("jump_find_more_friends", "jump_find_more_friends");
      }
      paramString.putExtra("game_report_from_scene", 5);
      paramContext.startActivity(paramString);
      b.a(paramContext, 5, 5, 1, 6, 0, null, i, 0, null, null, null);
      continue;
      paramString.setClass(paramContext, GameLibraryUI.class);
      if (k == 1) {
        paramString.putExtra("jump_game_center", "jump_game_center");
      }
      paramString.putExtra("game_report_from_scene", 5);
      paramContext.startActivity(paramString);
      b.a(paramContext, 5, 5, 1, 6, 0, null, i, 0, null, null, null);
      continue;
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("appId");
        if (!bk.bl((String)localObject)) {}
      }
      else
      {
        parama.e("fail", null);
        return;
      }
      paramString.setClass(paramContext, GameDetailUI.class);
      paramString.putExtra("game_app_id", (String)localObject);
      if (k == 1) {
        paramString.putExtra("jump_game_center", "jump_game_center");
      }
      paramString.putExtra("game_report_from_scene", 5);
      paramContext.startActivity(paramString);
      b.a(paramContext, 5, 5, 1, 6, 0, null, i, 0, null, null, null);
      continue;
      paramString.setClass(paramContext, GameMessageUI.class);
      paramString.putExtra("game_report_from_scene", 5);
      paramContext.startActivity(paramString);
      b.a(paramContext, 5, 5, 1, 6, 0, null, i, 0, null, null, null);
    }
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(a<d>.a parama) {}
  
  public final String name()
  {
    return "openGameCenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */