package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ToolsProfile.a;
import com.tencent.mm.ce.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.b;
import com.tencent.mm.pluginsdk.model.ac;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ao;
import java.util.Locale;

public final class e
{
  public static final class a
    extends e.c
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(19875);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(19875);
        return;
      }
      super.onReceive(paramContext, paramIntent);
      paramContext = paramIntent.getStringExtra("toolsmp_process_action_code_key");
      if ((!Util.isNullOrNil(paramContext)) && (paramContext.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")))
      {
        paramContext = paramIntent.getStringExtra("toolsmp_param_preload_url");
        int i = paramIntent.getIntExtra("toolsmp_param_preload_search_biz", -1);
        boolean bool = paramIntent.getBooleanExtra("toolsmp_param_preload_search_biz_need_reset", false);
        paramIntent = b.Xfl;
        b.m(i, paramContext, bool);
      }
      AppMethodBeat.o(19875);
    }
  }
  
  public static final class b
    implements MMReceivers.a
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(19877);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(19877);
        return;
      }
      Log.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
      com.tencent.xweb.x5.a.e.reset(paramContext);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19876);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(19876);
        }
      }, 5000L);
      AppMethodBeat.o(19877);
    }
  }
  
  public static class c
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
      Log.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = ".concat(String.valueOf(str1)));
      if (Util.isNullOrNil(str1))
      {
        AppMethodBeat.o(19878);
        return;
      }
      boolean bool;
      if (str1.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS"))
      {
        Log.appenderFlushSync();
        bool = ToolsProfile.a.isLocked();
        Log.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          paramIntent = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(paramIntent, paramContext.aYi(), "com/tencent/mm/booter/MMProcessReceivers$ToolsProcessReceiverImpl", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)paramContext.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramIntent, "com/tencent/mm/booter/MMProcessReceivers$ToolsProcessReceiverImpl", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        }
        AppMethodBeat.o(19878);
        return;
      }
      if (str1.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES"))
      {
        str1 = paramIntent.getStringExtra("tools_language");
        if (str1 == null)
        {
          AppMethodBeat.o(19878);
          return;
        }
        Log.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", new Object[] { str1 });
        paramIntent = LocaleUtil.transLanguageToLocale(str1);
        if ("language_default".equalsIgnoreCase(str1))
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label296;
          }
          paramIntent = LocaleUtil.sysDefaultLocale;
          Locale.setDefault(paramIntent);
        }
        for (;;)
        {
          LocaleUtil.updateApplicationResourceLocale(paramContext.getApplicationContext(), paramIntent);
          MMApplicationContext.setResources(d.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), str1));
          ao.updateResourceLocale(paramIntent);
          AppMethodBeat.o(19878);
          return;
          label296:
          paramIntent = Locale.getDefault();
        }
      }
      if (str1.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
        try
        {
          ao.OU(true);
          AppMethodBeat.o(19878);
          return;
        }
        catch (Exception paramContext)
        {
          Log.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + paramContext.getMessage());
          AppMethodBeat.o(19878);
          return;
        }
      }
      if (!str1.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX"))
      {
        if (str1.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE"))
        {
          bool = paramIntent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true);
          Log.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
          ao.OU(bool);
          AppMethodBeat.o(19878);
          return;
        }
        if (str1.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS"))
        {
          Log.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
          AppMethodBeat.o(19878);
          return;
        }
        if (str1.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING"))
        {
          Log.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
          AppMethodBeat.o(19878);
          return;
        }
        if (str1.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE"))
        {
          paramContext = paramIntent.getStringExtra("file_path");
          str1 = paramIntent.getStringExtra("file_ext");
          String str2 = paramIntent.getStringExtra("file_name");
          byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_multi_task_common_info");
          int i = paramIntent.getIntExtra("sence", 0);
          if ((System.currentTimeMillis() - ac.XRQ >= 1000L) && (!Util.isNullOrNil(paramContext)))
          {
            ac.XRQ = System.currentTimeMillis();
            paramIntent = new Intent();
            paramIntent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
            paramIntent.putExtra("file_path", paramContext);
            paramIntent.putExtra("file_ext", str1);
            paramIntent.putExtra("file_name", str2);
            paramIntent.putExtra("sence", i);
            paramIntent.putExtra("key_multi_task_common_info", arrayOfByte);
            paramIntent.addFlags(268435456);
            paramContext = MMApplicationContext.getContext();
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/pluginsdk/model/TBSFileBrowseHelper", "loadByMiniQB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[B)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramContext.startActivity((Intent)paramIntent.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/model/TBSFileBrowseHelper", "loadByMiniQB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[B)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
      AppMethodBeat.o(19878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.e
 * JD-Core Version:    0.7.0.1
 */