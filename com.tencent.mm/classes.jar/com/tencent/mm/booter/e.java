package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ToolsProfile.a;
import com.tencent.mm.cc.b;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

public final class e
{
  public static class c
    implements MMReceivers.a
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(15844);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(15844);
        return;
      }
      Object localObject = paramIntent.getStringExtra("tools_process_action_code_key");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = ".concat(String.valueOf(localObject)));
      boolean bool;
      if (((String)localObject).equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS"))
      {
        com.tencent.mm.sdk.platformtools.ab.dsJ();
        bool = ToolsProfile.a.isLocked();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          Process.killProcess(Process.myPid());
        }
        AppMethodBeat.o(15844);
        return;
      }
      if (((String)localObject).equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES"))
      {
        localObject = paramIntent.getStringExtra("tools_language");
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", new Object[] { localObject });
        paramIntent = aa.apg((String)localObject);
        if ("language_default".equalsIgnoreCase((String)localObject))
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label196;
          }
          paramIntent = aa.ynv;
          Locale.setDefault(paramIntent);
        }
        for (;;)
        {
          aa.a(paramContext.getApplicationContext(), paramIntent);
          ah.h(b.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), (String)localObject));
          AppMethodBeat.o(15844);
          return;
          label196:
          paramIntent = Locale.getDefault();
        }
      }
      if (((String)localObject).equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
        try
        {
          com.tencent.xweb.ab.clearAllWebViewCache(paramContext.getApplicationContext(), true);
          AppMethodBeat.o(15844);
          return;
        }
        catch (Exception paramContext)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + paramContext.getMessage());
          AppMethodBeat.o(15844);
          return;
        }
      }
      if (!((String)localObject).equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX"))
      {
        if (((String)localObject).equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE"))
        {
          bool = paramIntent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.xweb.ab.clearAllWebViewCache(paramContext.getApplicationContext(), bool);
          AppMethodBeat.o(15844);
          return;
        }
        if (((String)localObject).equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS"))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
          AppMethodBeat.o(15844);
          return;
        }
        if (((String)localObject).equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING"))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
          AppMethodBeat.o(15844);
          return;
        }
        if (((String)localObject).equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE"))
        {
          paramContext = paramIntent.getStringExtra("file_path");
          paramIntent = paramIntent.getStringExtra("file_ext");
          if ((System.currentTimeMillis() - t.vKO >= 1000L) && (!bo.isNullOrNil(paramContext)))
          {
            t.vKO = System.currentTimeMillis();
            localObject = new Intent();
            ((Intent)localObject).setClassName(ah.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
            ((Intent)localObject).putExtra("file_path", paramContext);
            ((Intent)localObject).putExtra("file_ext", paramIntent);
            ((Intent)localObject).addFlags(268435456);
            ah.getContext().startActivity((Intent)localObject);
          }
          AppMethodBeat.o(15844);
          return;
        }
        if (((String)localObject).equals("com.tencent.mm.intent.ACTION_PRELOAD_SET_SWITCH"))
        {
          bool = paramIntent.getBooleanExtra("tools_param_preload_switch", false);
          aj.cZB().oh(bool);
          AppMethodBeat.o(15844);
          return;
        }
        if (((String)localObject).equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")) {
          aj.cZB().dK(paramIntent.getStringExtra("tools_param_preload_url"), paramIntent.getIntExtra("tools_param_preload_search_biz", -1));
        }
      }
      AppMethodBeat.o(15844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.e
 * JD-Core Version:    0.7.0.1
 */