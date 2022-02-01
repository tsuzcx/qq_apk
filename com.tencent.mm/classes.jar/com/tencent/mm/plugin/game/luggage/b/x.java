package com.tencent.mm.plugin.game.luggage.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class x
  extends bs<i>
{
  private static boolean aJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(186873);
    try
    {
      paramString = new Intent(paramContext, Class.forName(paramString)).resolveActivity(paramContext.getPackageManager());
      if (paramString != null)
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(10).iterator();
        while (paramContext.hasNext())
        {
          boolean bool = ((ActivityManager.RunningTaskInfo)paramContext.next()).baseActivity.equals(paramString);
          if (bool)
          {
            AppMethodBeat.o(186873);
            return true;
          }
        }
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.e("MicroMsg.JsApiOpenGameTabHome", "err: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(186873);
    }
    return false;
  }
  
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(186872);
    Log.i("MicroMsg.JsApiOpenGameTabHome", "invokeInMM");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramString == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(186872);
      return;
    }
    if ((aJ(paramContext, "com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI")) || (aJ(paramContext, "com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI")))
    {
      parama.i("exist_tab", null);
      AppMethodBeat.o(186872);
      return;
    }
    paramString = paramString.optString("tabKey");
    Log.i("MicroMsg.JsApiOpenGameTabHome", "tabKey:[%s]", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("from_find_more_friend", false);
    localIntent.putExtra("game_report_from_scene", 5);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("has_game_life_chat_msg", false);
    localIntent.putExtra("default_game_tab_key", paramString);
    localIntent.putExtra("disable_game_tab_home_swipe", true);
    c.b(paramContext, "game", ".ui.GameCenterUI", localIntent);
    parama.i(null, null);
    AppMethodBeat.o(186872);
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameTabHome";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.x
 * JD-Core Version:    0.7.0.1
 */