package com.tencent.mm.plugin.game.luggage.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class u
  extends br<g>
{
  private static boolean au(Context paramContext, String paramString)
  {
    AppMethodBeat.i(211610);
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
            AppMethodBeat.o(211610);
            return true;
          }
        }
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      ad.e("MicroMsg.JsApiOpenGameTabHome", "err: %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(211610);
    }
    return false;
  }
  
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(211609);
    ad.i("MicroMsg.JsApiOpenGameTabHome", "invokeInMM");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (paramString == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(211609);
      return;
    }
    if ((au(paramContext, "com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI")) || (au(paramContext, "com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI")))
    {
      parama.f("exist_tab", null);
      AppMethodBeat.o(211609);
      return;
    }
    paramString = paramString.optString("tabKey");
    ad.i("MicroMsg.JsApiOpenGameTabHome", "tabKey:[%s]", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("from_find_more_friend", false);
    localIntent.putExtra("game_report_from_scene", 5);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("has_game_life_chat_msg", false);
    localIntent.putExtra("default_game_tab_key", paramString);
    localIntent.putExtra("disable_game_tab_home_swipe", true);
    d.b(paramContext, "game", ".ui.GameCenterUI", localIntent);
    parama.f(null, null);
    AppMethodBeat.o(211609);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openGameTabHome";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.u
 * JD-Core Version:    0.7.0.1
 */