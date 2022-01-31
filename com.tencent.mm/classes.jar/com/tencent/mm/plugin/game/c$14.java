package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.lm;
import com.tencent.mm.h.a.lm.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class c$14
  extends com.tencent.mm.sdk.b.c<lm>
{
  c$14(c paramc)
  {
    this.udX = lm.class.getName().hashCode();
  }
  
  private static boolean a(lm paramlm)
  {
    String str2 = "";
    String str1 = str2;
    Object localObject2 = str2;
    int i;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramlm.bUC.extraInfo);
      str1 = str2;
      localObject2 = str2;
      str2 = localJSONObject.optString("appId");
      str1 = str2;
      localObject2 = str2;
      i = bk.getInt(localJSONObject.optString("ssid"), 0);
      str1 = str2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[] { localJSONException.getMessage() });
        i = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[] { localException.getMessage() });
        i = 0;
        localObject1 = localJSONException;
      }
      localJSONException.setClass(paramlm.bUC.context, GameCenterUI.class);
      if (paramlm.bUC.jumpType != 1) {
        break label194;
      }
      localJSONException.putExtra("jump_find_more_friends", "jump_find_more_friends");
      localJSONException.putExtra("game_report_from_scene", 5);
      paramlm.bUC.context.startActivity(localJSONException);
      b.a(paramlm.bUC.context, 5, 5, 1, 6, i, null);
      return false;
    }
    localObject2 = new Intent();
    switch (paramlm.bUC.bUD)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      Object localObject1;
      label194:
      do
      {
        return false;
        localJSONException.setClass(paramlm.bUC.context, GameLibraryUI.class);
        if (paramlm.bUC.jumpType == 1) {
          localJSONException.putExtra("jump_game_center", "jump_game_center");
        }
        localJSONException.putExtra("game_report_from_scene", 5);
        paramlm.bUC.context.startActivity(localJSONException);
        b.a(paramlm.bUC.context, 5, 5, 1, 6, i, null);
        return false;
      } while (bk.bl(localObject1));
      localJSONException.setClass(paramlm.bUC.context, GameDetailUI.class);
      localJSONException.putExtra("game_app_id", localObject1);
      if (paramlm.bUC.jumpType == 1) {
        localJSONException.putExtra("jump_game_center", "jump_game_center");
      }
      localJSONException.putExtra("game_report_from_scene", 5);
      paramlm.bUC.context.startActivity(localJSONException);
      b.a(paramlm.bUC.context, 5, 5, 1, 6, i, null);
      return false;
    }
    localJSONException.setClass(paramlm.bUC.context, GameMessageUI.class);
    localJSONException.putExtra("game_report_from_scene", 5);
    paramlm.bUC.context.startActivity(localJSONException);
    b.a(paramlm.bUC.context, 5, 5, 1, 6, i, null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.14
 * JD-Core Version:    0.7.0.1
 */