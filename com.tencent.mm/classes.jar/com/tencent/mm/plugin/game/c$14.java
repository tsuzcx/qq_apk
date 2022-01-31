package com.tencent.mm.plugin.game;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.mb.a;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

final class c$14
  extends com.tencent.mm.sdk.b.c<mb>
{
  c$14(c paramc)
  {
    AppMethodBeat.i(111157);
    this.__eventId = mb.class.getName().hashCode();
    AppMethodBeat.o(111157);
  }
  
  private static boolean a(mb parammb)
  {
    AppMethodBeat.i(111158);
    String str2 = "";
    String str1 = str2;
    Object localObject2 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject(parammb.cCh.extraInfo);
      str1 = str2;
      localObject2 = str2;
      str2 = localJSONObject.optString("appId");
      str1 = str2;
      localObject2 = str2;
      i = bo.getInt(localJSONObject.optString("ssid"), 0);
      str1 = str2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[] { localJSONException.getMessage() });
        i = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[] { localException.getMessage() });
        int i = 0;
        Object localObject1 = localJSONException;
        continue;
        localJSONException.setClass(parammb.cCh.context, GameCenterUI.class);
        if (parammb.cCh.jumpType == 1) {
          localJSONException.putExtra("jump_find_more_friends", "jump_find_more_friends");
        }
        localJSONException.putExtra("game_report_from_scene", 5);
        parammb.cCh.context.startActivity(localJSONException);
        com.tencent.mm.game.report.c.a(parammb.cCh.context, 5, 5, 1, 6, i, null);
        continue;
        localJSONException.setClass(parammb.cCh.context, GameLibraryUI.class);
        if (parammb.cCh.jumpType == 1) {
          localJSONException.putExtra("jump_game_center", "jump_game_center");
        }
        localJSONException.putExtra("game_report_from_scene", 5);
        parammb.cCh.context.startActivity(localJSONException);
        com.tencent.mm.game.report.c.a(parammb.cCh.context, 5, 5, 1, 6, i, null);
        continue;
        if (!bo.isNullOrNil(localObject1))
        {
          localJSONException.setClass(parammb.cCh.context, GameDetailUI.class);
          localJSONException.putExtra("game_app_id", localObject1);
          if (parammb.cCh.jumpType == 1) {
            localJSONException.putExtra("jump_game_center", "jump_game_center");
          }
          localJSONException.putExtra("game_report_from_scene", 5);
          parammb.cCh.context.startActivity(localJSONException);
          com.tencent.mm.game.report.c.a(parammb.cCh.context, 5, 5, 1, 6, i, null);
          continue;
          localJSONException.setClass(parammb.cCh.context, GameMessageUI.class);
          localJSONException.putExtra("game_report_from_scene", i);
          parammb.cCh.context.startActivity(localJSONException);
          com.tencent.mm.game.report.c.a(parammb.cCh.context, 5, 5, 1, 6, i, null);
        }
      }
    }
    localObject2 = new Intent();
    switch (parammb.cCh.cCi)
    {
    default: 
      AppMethodBeat.o(111158);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.14
 * JD-Core Version:    0.7.0.1
 */