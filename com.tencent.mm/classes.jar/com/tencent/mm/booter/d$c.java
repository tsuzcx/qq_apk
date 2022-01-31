package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.mm.app.ToolsProfile.a;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.1;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.s;
import com.tencent.xweb.x5.sdk.d;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$c
  implements MMReceivers.a
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    String str1;
    label179:
    do
    {
      boolean bool;
      String str2;
      do
      {
        do
        {
          do
          {
            return;
            str1 = paramIntent.getStringExtra("tools_process_action_code_key");
            y.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = " + str1);
            if (!str1.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
              break;
            }
            y.cqM();
            bool = ToolsProfile.a.isLocked();
            y.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", new Object[] { Boolean.valueOf(bool) });
          } while (bool);
          Process.killProcess(Process.myPid());
          return;
          if (str1.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES"))
          {
            str1 = paramIntent.getStringExtra("tools_language");
            y.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", new Object[] { str1 });
            paramIntent = x.Zi(str1);
            if ("language_default".equalsIgnoreCase(str1))
            {
              if (Build.VERSION.SDK_INT < 24) {
                break label179;
              }
              paramIntent = x.ueU;
              Locale.setDefault(paramIntent);
            }
            for (;;)
            {
              x.a(paramContext.getApplicationContext(), paramIntent);
              ae.d(a.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), str1));
              return;
              paramIntent = Locale.getDefault();
            }
          }
          if (str1.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
            try
            {
              s.clearAllWebViewCache(paramContext.getApplicationContext(), true);
              return;
            }
            catch (Exception paramContext)
            {
              y.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + paramContext.getMessage());
              return;
            }
          }
        } while (str1.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX"));
        if (str1.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE"))
        {
          bool = paramIntent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true);
          y.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
          s.clearAllWebViewCache(paramContext.getApplicationContext(), bool);
          return;
        }
        if (str1.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS"))
        {
          y.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
          return;
        }
        if (str1.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING"))
        {
          y.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
          return;
        }
        if (!str1.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
          break;
        }
        str1 = paramIntent.getStringExtra("file_path");
        str2 = paramIntent.getStringExtra("file_ext");
      } while ((System.currentTimeMillis() - u.rTR < 1000L) || (bk.bl(str1)));
      u.rTR = System.currentTimeMillis();
      Context localContext = ae.getContext();
      paramContext = "";
      try
      {
        paramIntent = new JSONObject();
        paramIntent.putOpt("path", str1);
        paramIntent.putOpt("ext", str2);
        paramIntent = paramIntent.toString();
        paramContext = paramIntent;
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TBSFileBrowseHelper", paramIntent, "", new Object[0]);
        }
      }
      y.i("MicroMsg.TBSFileBrowseHelper", "openFileByMiniQB, file pathinfo:%s", new Object[] { paramContext });
      d.a(localContext, paramContext, new u.1(str1, str2, localContext));
      return;
      if (str1.equals("com.tencent.mm.intent.ACTION_PRELOAD_SET_SWITCH"))
      {
        bool = paramIntent.getBooleanExtra("tools_param_preload_switch", false);
        ak.bZF().kY(bool);
        return;
      }
    } while (!str1.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH"));
    ak.bZF().cL(paramIntent.getStringExtra("tools_param_preload_url"), paramIntent.getIntExtra("tools_param_preload_search_biz", -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.d.c
 * JD-Core Version:    0.7.0.1
 */