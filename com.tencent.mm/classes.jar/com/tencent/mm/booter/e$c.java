package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ToolsProfile.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.ah;
import java.util.Locale;

public class e$c
  implements MMReceivers.a
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19878);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(19878);
      return;
    }
    String str1 = paramIntent.getStringExtra("tools_process_action_code_key");
    ac.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = ".concat(String.valueOf(str1)));
    if (bs.isNullOrNil(str1))
    {
      AppMethodBeat.o(19878);
      return;
    }
    boolean bool;
    if (str1.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS"))
    {
      ac.eUR();
      bool = ToolsProfile.a.isLocked();
      ac.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        Process.killProcess(Process.myPid());
      }
      AppMethodBeat.o(19878);
      return;
    }
    if (str1.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES"))
    {
      str1 = paramIntent.getStringExtra("tools_language");
      ac.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", new Object[] { str1 });
      paramIntent = ab.aKK(str1);
      if ("language_default".equalsIgnoreCase(str1))
      {
        if (Build.VERSION.SDK_INT < 24) {
          break label214;
        }
        paramIntent = ab.Grx;
        Locale.setDefault(paramIntent);
      }
      for (;;)
      {
        ab.a(paramContext.getApplicationContext(), paramIntent);
        ai.h(b.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), str1));
        AppMethodBeat.o(19878);
        return;
        label214:
        paramIntent = Locale.getDefault();
      }
    }
    if (str1.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
      try
      {
        ah.clearAllWebViewCache(paramContext.getApplicationContext(), true);
        AppMethodBeat.o(19878);
        return;
      }
      catch (Exception paramContext)
      {
        ac.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + paramContext.getMessage());
        AppMethodBeat.o(19878);
        return;
      }
    }
    if (!str1.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX"))
    {
      if (str1.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE"))
      {
        bool = paramIntent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true);
        ac.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
        ah.clearAllWebViewCache(paramContext.getApplicationContext(), bool);
        AppMethodBeat.o(19878);
        return;
      }
      if (str1.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS"))
      {
        ac.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
        AppMethodBeat.o(19878);
        return;
      }
      if (str1.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING"))
      {
        ac.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
        AppMethodBeat.o(19878);
        return;
      }
      if (str1.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE"))
      {
        paramContext = paramIntent.getStringExtra("file_path");
        str1 = paramIntent.getStringExtra("file_ext");
        String str2 = paramIntent.getStringExtra("file_name");
        int i = paramIntent.getIntExtra("sence", 0);
        if ((System.currentTimeMillis() - v.DhG >= 1000L) && (!bs.isNullOrNil(paramContext)))
        {
          v.DhG = System.currentTimeMillis();
          paramIntent = new Intent();
          paramIntent.setClassName(ai.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
          paramIntent.putExtra("file_path", paramContext);
          paramIntent.putExtra("file_ext", str1);
          paramIntent.putExtra("file_name", str2);
          paramIntent.putExtra("sence", i);
          paramIntent.addFlags(268435456);
          paramContext = ai.getContext();
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/pluginsdk/model/TBSFileBrowseHelper", "loadByMiniQB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramIntent.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/pluginsdk/model/TBSFileBrowseHelper", "loadByMiniQB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
    AppMethodBeat.o(19878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.e.c
 * JD-Core Version:    0.7.0.1
 */