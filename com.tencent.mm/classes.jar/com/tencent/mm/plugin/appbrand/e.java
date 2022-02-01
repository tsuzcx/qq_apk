package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.am.a;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bm.b;
import com.tencent.mm.plugin.appbrand.appcache.o.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.j;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.aj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;
import kotlin.ah;

public final class e
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = -1;
    boolean bool = false;
    int k = 0;
    AppMethodBeat.i(43788);
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (int j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//enable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.clw();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.clx();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//appbrand_monkey_bringtofront".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramArrayOfString = paramArrayOfString[1].trim();; paramArrayOfString = "")
      {
        if (com.tencent.mm.plugin.appbrand.task.i.cJV().fA(paramArrayOfString)) {
          com.tencent.mm.plugin.appbrand.task.i.cJV().a(paramArrayOfString, -1, new kotlin.g.a.b() {});
        }
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//appbrand_monkey_test_skip_appbrand_process_suicide".equals(paramArrayOfString[0]))
    {
      if ((paramArrayOfString.length > 1) && (Util.getInt(paramArrayOfString[1].trim(), 1) <= 0)) {}
      for (bool = false;; bool = true)
      {
        DebuggerShell.iJ(bool);
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//appbrand_predownload_trigger".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramContext = paramArrayOfString[1].trim();; paramContext = "")
      {
        ((com.tencent.mm.plugin.appbrand.service.y)h.ax(com.tencent.mm.plugin.appbrand.service.y.class)).bL(paramContext, 0);
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//xweb_live".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.cTr();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.ES(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.ES(0);
      }
    }
    if ("//xweb_video_preload".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_preload_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DE(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DE(0);
      }
    }
    if ("//xweb_video_ps".equals(paramArrayOfString[0]))
    {
      i = Util.safeParseInt(paramArrayOfString[1]);
      if (i < 0) {
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_weishi_ps_command_value");
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_weishi_ps_command_value", i);
      }
    }
    if ("//xweb_video_player".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        if (!paramContext.equals("sys")) {
          break;
        }
        i = 3;
        break;
        if (!paramContext.equals("exo")) {
          break;
        }
        i = 4;
        break;
        if (!paramContext.equals("thumb")) {
          break;
        }
        i = 5;
        break;
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DF(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DF(0);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DF(3);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DF(4);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DF(5);
      }
    }
    if ("//xweb_video_proxy".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_proxy_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DG(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DG(0);
      }
    }
    if ("//xweb_video_hls_proxy".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_hls_proxy_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DH(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.d.DH(0);
      }
    }
    if ("//xweb_video".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.cTc();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.ER(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.ER(0);
      }
    }
    if ("//showad".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        com.tencent.mm.plugin.appbrand.ad.b.cdN();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.zd(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.zd(0);
      }
    }
    if ("//allshowad".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("false")) {
          break;
        }
        i = 2;
        break;
        com.tencent.mm.plugin.appbrand.ad.b.cdP();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.ze(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.ze(0);
      }
    }
    if ("//deletexnetlibdebugdir".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.vfs.y.ew(com.tencent.mm.wexnet.b.jPJ(), true);
      com.tencent.mm.vfs.y.ew(com.tencent.mm.wexnet.b.jPI(), true);
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//xnetusingdebugso".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length >= 2)
      {
        paramContext = paramArrayOfString[1];
        switch (paramContext.hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("1")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("0")) {
          break;
        }
        i = 1;
        break;
        paramContext = com.tencent.mm.wexnet.d.agWm;
        com.tencent.mm.wexnet.d.On(true);
        continue;
        paramContext = com.tencent.mm.wexnet.d.agWm;
        com.tencent.mm.wexnet.d.On(false);
      }
    }
    if ("//enableweappallhalfscreen".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length >= 2) {
        paramContext = paramArrayOfString[1];
      }
      switch (paramContext.hashCode())
      {
      default: 
        j = -1;
        switch (j)
        {
        default: 
          label1899:
          if (paramArrayOfString.length >= 3) {
            paramContext = paramArrayOfString[2];
          }
          label1924:
          switch (paramContext.hashCode())
          {
          default: 
            label1960:
            j = -1;
            switch (j)
            {
            default: 
              label1963:
              label1988:
              if (paramArrayOfString.length >= 4) {
                paramContext = paramArrayOfString[3];
              }
              switch (paramContext.hashCode())
              {
              default: 
                label2024:
                j = -1;
                switch (j)
                {
                default: 
                  label2027:
                  if (paramArrayOfString.length >= 5)
                  {
                    paramContext = paramArrayOfString[4];
                    switch (paramContext.hashCode())
                    {
                    default: 
                      switch (i)
                      {
                      }
                      break;
                    }
                  }
                  label2088:
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          label2052:
          break;
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("1")) {
          break;
        }
        j = 0;
        break label1899;
        if (!paramContext.equals("0")) {
          break;
        }
        j = 1;
        break label1899;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lu(true);
        break label1924;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lu(false);
        break label1924;
        if (!paramContext.equals("1")) {
          break label1960;
        }
        j = 0;
        break label1963;
        if (!paramContext.equals("0")) {
          break label1960;
        }
        j = 1;
        break label1963;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lv(true);
        break label1988;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lv(false);
        break label1988;
        if (!paramContext.equals("1")) {
          break label2024;
        }
        j = 0;
        break label2027;
        if (!paramContext.equals("0")) {
          break label2024;
        }
        j = 1;
        break label2027;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lw(true);
        break label2052;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lw(false);
        break label2052;
        if (!paramContext.equals("1")) {
          break label2088;
        }
        i = 0;
        break label2088;
        if (!paramContext.equals("0")) {
          break label2088;
        }
        i = 1;
        break label2088;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lx(true);
        continue;
        paramContext = com.tencent.mm.plugin.appbrand.widget.d.b.uDz;
        com.tencent.mm.plugin.appbrand.widget.d.b.lx(false);
      }
    }
    if ("//localwxalibrary".equals(paramArrayOfString[0]))
    {
      paramContext = MultiProcessMMKV.getMMKV("__appbrand_comm_lib__prefs");
      paramArrayOfString = paramArrayOfString[1];
      switch (paramArrayOfString.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramArrayOfString.equals("clear")) {
          break;
        }
        i = 0;
        break;
        if (!paramArrayOfString.equals("true")) {
          break;
        }
        i = 1;
        break;
        if (!paramArrayOfString.equals("false")) {
          break;
        }
        i = 2;
        break;
        paramContext.edit().remove("localwxalibrary").commit();
        continue;
        paramContext.edit().putBoolean("localwxalibrary", true).commit();
        continue;
        paramContext.edit().putBoolean("localwxalibrary", false).commit();
      }
    }
    if ("//getsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].contains("daily"))) {
        com.tencent.mm.plugin.appbrand.appusage.x.a(x.a.qPJ);
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        com.tencent.mm.plugin.appbrand.appusage.x.a(x.a.qPK);
      }
    }
    if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      ((com.tencent.mm.plugin.appbrand.service.z)h.ax(com.tencent.mm.plugin.appbrand.service.z.class)).cjm();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//wagame".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.plugin.appbrand.game.a.z.a(paramContext, paramArrayOfString);
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//enable_appbrand_file_size_statistics_debug".equals(paramArrayOfString[0])) {}
    try
    {
      paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
      com.tencent.mm.plugin.appbrand.app.f.aBP().putBoolean("enable_appbrand_file_size_statistics_debug", paramArrayOfString[1].trim().equals("1"));
      label2680:
      AppMethodBeat.o(43788);
      return true;
      if ("//appbrand_video".equals(paramArrayOfString[0]))
      {
        paramContext = paramArrayOfString[1];
        switch (paramContext.hashCode())
        {
        default: 
          j = -1;
          label2743:
          switch (j)
          {
          }
          break;
        }
        for (;;)
        {
          AppMethodBeat.o(43788);
          return true;
          if (!paramContext.equals("fix_notify_error")) {
            break;
          }
          j = 0;
          break label2743;
          if (!paramContext.equals("lock_cache")) {
            break;
          }
          j = 1;
          break label2743;
          if (!paramContext.equals("cancel_cache")) {
            break;
          }
          j = 2;
          break label2743;
          paramContext = paramArrayOfString[2];
          switch (paramContext.hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              com.tencent.mm.plugin.appbrand.utils.d.ld(true);
              break;
              if (paramContext.equals("true"))
              {
                i = 0;
                continue;
                if (paramContext.equals("false"))
                {
                  i = 1;
                  continue;
                  if (paramContext.equals("clear")) {
                    i = 2;
                  }
                }
              }
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.utils.d.ld(false);
          continue;
          MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("video_fix_notify_error_command_value");
          continue;
          paramContext = paramArrayOfString[2];
          switch (paramContext.hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              com.tencent.mm.plugin.appbrand.utils.d.le(true);
              break;
              if (paramContext.equals("true"))
              {
                i = 0;
                continue;
                if (paramContext.equals("false"))
                {
                  i = 1;
                  continue;
                  if (paramContext.equals("clear")) {
                    i = 2;
                  }
                }
              }
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.utils.d.le(false);
          continue;
          MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("video_lock_cache_command_value");
          continue;
          paramContext = paramArrayOfString[2];
          switch (paramContext.hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              com.tencent.mm.plugin.appbrand.utils.d.lf(true);
              break;
              if (paramContext.equals("true"))
              {
                i = 0;
                continue;
                if (paramContext.equals("false"))
                {
                  i = 1;
                  continue;
                  if (paramContext.equals("clear")) {
                    i = 2;
                  }
                }
              }
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.utils.d.lf(false);
          continue;
          MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("video_cancel_cache_when_play_command_value");
        }
      }
      if ("//appbrand_profile".equals(paramArrayOfString[0]))
      {
        com.tencent.mm.plugin.appbrand.ui.n.t(paramArrayOfString);
        AppMethodBeat.o(43788);
        return true;
      }
      if ("//appbrand_weishi".equals(paramArrayOfString[0]))
      {
        com.tencent.mm.plugin.appbrand.weishi.e.t(paramArrayOfString);
        AppMethodBeat.o(43788);
        return true;
      }
      paramContext = paramArrayOfString[1].toLowerCase();
      switch (paramContext.hashCode())
      {
      default: 
        i = -1;
        label3651:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("jnizip")) {
          break;
        }
        i = 0;
        break label3651;
        if (!paramContext.equals("javazip")) {
          break;
        }
        i = 1;
        break label3651;
        if (!paramContext.equals("trigger_daily_clean")) {
          break;
        }
        i = 2;
        break label3651;
        if (!paramContext.equals("trigger_check_lib_update")) {
          break;
        }
        i = 3;
        break label3651;
        if (!paramContext.equals("deletebetalib")) {
          break;
        }
        i = 4;
        break label3651;
        if (!paramContext.equals("deletelib")) {
          break;
        }
        i = 5;
        break label3651;
        if (!paramContext.equals("deletepkg")) {
          break;
        }
        i = 6;
        break label3651;
        if (!paramContext.equals("pkgcleanup")) {
          break;
        }
        i = 7;
        break label3651;
        if (!paramContext.equals("pluginlruclean")) {
          break;
        }
        i = 8;
        break label3651;
        if (!paramContext.equals("checkdemoclean")) {
          break;
        }
        i = 9;
        break label3651;
        if (!paramContext.equals("prefetchcontact")) {
          break;
        }
        i = 10;
        break label3651;
        if (!paramContext.equals("deletecontact")) {
          break;
        }
        i = 11;
        break label3651;
        if (!paramContext.equals("deletelaunch")) {
          break;
        }
        i = 12;
        break label3651;
        if (!paramContext.equals("deletewxapkgs")) {
          break;
        }
        i = 13;
        break label3651;
        if (!paramContext.equals("deleteplugins")) {
          break;
        }
        i = 14;
        break label3651;
        if (!paramContext.equals("historycount")) {
          break;
        }
        i = 15;
        break label3651;
        if (!paramContext.equals("resetsyncversion")) {
          break;
        }
        i = 16;
        break label3651;
        if (!paramContext.equals("sync")) {
          break;
        }
        i = 17;
        break label3651;
        if (!paramContext.equals("starmax")) {
          break;
        }
        i = 18;
        break label3651;
        if (!paramContext.equals("guide")) {
          break;
        }
        i = 19;
        break label3651;
        if (!paramContext.equals("clearguide")) {
          break;
        }
        i = 20;
        break label3651;
        if (!paramContext.equals("incremental_insert_24")) {
          break;
        }
        i = 21;
        break label3651;
        if (!paramContext.equals("incremental_insert_28")) {
          break;
        }
        i = 22;
        break label3651;
        if (!paramContext.equals("incremental_delete_28")) {
          break;
        }
        i = 23;
        break label3651;
        if (!paramContext.equals("incremental_delete_latest")) {
          break;
        }
        i = 24;
        break label3651;
        if (!paramContext.equals("incremental_lib")) {
          break;
        }
        i = 25;
        break label3651;
        if (!paramContext.equals("clear_mocklib")) {
          break;
        }
        i = 26;
        break label3651;
        if (!paramContext.equals("disable_develop_lib")) {
          break;
        }
        i = 27;
        break label3651;
        if (!paramContext.equals("clear_sync_cmd_seq")) {
          break;
        }
        i = 28;
        break label3651;
        if (!paramContext.equals("disable_preload")) {
          break;
        }
        i = 29;
        break label3651;
        if (!paramContext.equals("enable_pre_loading_rainbow")) {
          break;
        }
        i = 30;
        break label3651;
        if (!paramContext.equals("disable_pre_loading_rainbow")) {
          break;
        }
        i = 31;
        break label3651;
        if (!paramContext.equals("disable_pre_loading")) {
          break;
        }
        i = 32;
        break label3651;
        if (!paramContext.equals("enable_pre_loading")) {
          break;
        }
        i = 33;
        break label3651;
        if (!paramContext.equals("pre_load_launch")) {
          break;
        }
        i = 34;
        break label3651;
        if (!paramContext.equals("pre_load_level")) {
          break;
        }
        i = 35;
        break label3651;
        if (!paramContext.equals("insert_pdd_enc_1170_app")) {
          break;
        }
        i = 36;
        break label3651;
        if (!paramContext.equals("insert_pdd_ori_1170_app")) {
          break;
        }
        i = 37;
        break label3651;
        if (!paramContext.equals("open_material")) {
          break;
        }
        i = 38;
        break label3651;
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(43785);
            long l = Util.nowMilliSecond();
            Log.i("[ZIP]", "unzip JNI %d, cost %d", new Object[] { Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(Util.nowMilliSecond() - l) });
            AppMethodBeat.o(43785);
          }
        }, "TestZipJNI");
        continue;
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(316741);
            long l = Util.nowMilliSecond();
            int i = -1;
            try
            {
              int j = t.a(new ZipInputStream(com.tencent.mm.vfs.y.ao(new com.tencent.mm.vfs.u("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
              i = j;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.e("[ZIP]", "unzip Java ex=%s", new Object[] { localException });
              }
            }
            Log.i("[ZIP]", "unzip Java %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond() - l) });
            AppMethodBeat.o(316741);
          }
        }, "TestZipJava");
        continue;
        o.cbp();
        continue;
        ax.ij(true);
        continue;
        com.tencent.mm.plugin.appbrand.app.n.cfm().bI("@LibraryAppId", 999);
        i = bc.VERSION;
        au.cgv();
        continue;
        com.tencent.mm.plugin.appbrand.app.n.cfm().bI("@LibraryAppId", 0);
        i = bc.VERSION;
        au.cgv();
        continue;
        if (paramArrayOfString.length > 2) {}
        for (paramContext = paramArrayOfString[2].trim();; paramContext = null)
        {
          i = k;
          if (paramArrayOfString.length > 3) {
            i = Util.getInt(paramArrayOfString[3].trim(), 0);
          }
          if (TextUtils.isEmpty(paramContext)) {
            break;
          }
          com.tencent.mm.plugin.appbrand.app.n.cfm().bI(paramContext, i);
          break;
        }
        ThreadPool.post(o.d.cfX(), "WxaPkgCleanupByCMD");
        continue;
        Log.i("PluginCodePruneLRULogic", "pluginCode lru cleanup!");
        paramContext = new AtomicBoolean();
        try
        {
          am.b(4194304L, new am.a()
          {
            public final boolean cbj()
            {
              AppMethodBeat.i(316737);
              boolean bool = paramContext.get();
              AppMethodBeat.o(316737);
              return bool;
            }
          });
        }
        catch (InterruptedException paramContext) {}
        continue;
        Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "checkdemoclean deleteAll!");
        com.tencent.mm.plugin.appbrand.app.n.cfh().cju();
        continue;
        if (paramArrayOfString.length >= 3) {}
        for (paramContext = org.apache.commons.c.i.bLh(paramArrayOfString[2]); !org.apache.commons.c.i.hm(paramContext); paramContext = "")
        {
          com.tencent.mm.plugin.appbrand.launching.b.a.tdl.a(paramContext, new androidx.a.a.c.a() {});
          break;
        }
        ad.XN(paramArrayOfString[2]);
        continue;
        com.tencent.mm.plugin.appbrand.app.n.cfd().db.execSQL("LaunchWxaAppRespTable", "delete from LaunchWxaAppRespTable");
        continue;
        paramContext = com.tencent.mm.plugin.appbrand.app.n.cfm();
        paramArrayOfString = "delete from " + paramContext.qHw.getTableName();
        paramContext.qHv.execSQL(paramContext.qHw.getTableName(), paramArrayOfString);
        com.tencent.mm.plugin.appbrand.task.i.cJV().asi();
        continue;
        paramContext = com.tencent.mm.plugin.appbrand.app.n.cfm();
        paramArrayOfString = String.format(Locale.ENGLISH, "delete from %s where %s like '%%$%s'", new Object[] { paramContext.qHw.getTableName(), "appId", "__PLUGINCODE__" });
        paramContext.qHv.execSQL(paramContext.qHw.getTableName(), paramArrayOfString);
        com.tencent.mm.plugin.appbrand.task.i.cJV().asi();
        continue;
        if (Util.getInt(paramArrayOfString[2].trim(), 0) > 0) {
          bool = true;
        }
        h.baE().ban().set(at.a.acNl, Boolean.valueOf(bool));
        continue;
        ad.XM(paramArrayOfString[2]);
        continue;
        ag.XP(paramArrayOfString[2]);
        continue;
        com.tencent.mm.plugin.appbrand.appusage.u.zw(Math.max(0, Util.getInt(paramArrayOfString[2], 0)));
        continue;
        com.tencent.mm.br.c.ai(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandGuideUI");
        continue;
        h.baE().ban().set(at.a.acNk, Boolean.FALSE);
        continue;
        paramContext = new bh();
        paramContext.field_appId = "wx4ffb369b6881ee5e";
        paramContext.field_version = 24;
        paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
        paramContext.field_debugType = 0;
        paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
        com.tencent.mm.plugin.appbrand.app.n.cfm().h(paramContext);
        continue;
        paramContext = new bh();
        paramContext.field_appId = "wx4ffb369b6881ee5e";
        paramContext.field_version = 28;
        paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
        paramContext.field_debugType = 0;
        paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
        com.tencent.mm.plugin.appbrand.app.n.cfm().h(paramContext);
        continue;
        paramContext = new bh();
        paramContext.field_appId = "wx4ffb369b6881ee5e";
        paramContext.field_version = 28;
        paramContext.field_debugType = 0;
        com.tencent.mm.plugin.appbrand.app.n.cfm().c(paramContext);
        continue;
        paramContext = com.tencent.mm.plugin.appbrand.app.n.cfm();
        paramArrayOfString = paramContext.c("wx4ffb369b6881ee5e", 0, new String[] { "version" });
        if (paramArrayOfString != null)
        {
          paramContext.c(paramArrayOfString);
          continue;
          new com.tencent.mm.plugin.appbrand.appcache.x(Util.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
          continue;
          bc.cgG();
          Toast.makeText(MMApplicationContext.getContext(), "MockLib已清除，重启微信生效", 1).show();
          continue;
          if (paramArrayOfString.length >= 3)
          {
            bc.ik(paramArrayOfString[2].trim().contentEquals("1"));
            continue;
            com.tencent.mm.plugin.appbrand.app.n.aqS().fe("PredownloadCmdSequence$");
            continue;
            if (paramArrayOfString.length >= 3)
            {
              com.tencent.mm.plugin.appbrand.task.preload.e.kQ(paramArrayOfString[2].trim().contentEquals("1"));
            }
            else
            {
              aa.db(MMApplicationContext.getContext(), " 预载已禁用，即将重启微信...");
              com.tencent.mm.plugin.appbrand.task.preload.e.kQ(true);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(316726);
                  com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                  Object localObject = new Object();
                  com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/appbrand/AppBrandCommand$6", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                  System.exit(((Integer)locala.sb(0)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/appbrand/AppBrandCommand$6", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                  AppMethodBeat.o(316726);
                }
              }, 2000L);
              continue;
              aa.db(MMApplicationContext.getContext(), "已开启");
              paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
              com.tencent.mm.plugin.appbrand.app.f.aBP().putBoolean("enable_pre_loading_rainbow", true);
              continue;
              aa.db(MMApplicationContext.getContext(), "已关闭");
              paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
              com.tencent.mm.plugin.appbrand.app.f.aBP().putBoolean("enable_pre_loading_rainbow", false);
              continue;
              paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
              com.tencent.mm.plugin.appbrand.app.f.aBP().putBoolean("enable_pre_loading", false);
              continue;
              paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
              com.tencent.mm.plugin.appbrand.app.f.aBP().putBoolean("enable_pre_loading", true);
              continue;
              if (paramArrayOfString.length == 3)
              {
                new j();
                j.cT("", paramArrayOfString[2]);
                continue;
                paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
                com.tencent.mm.plugin.appbrand.app.f.aBP().putInt("pre_load_level", Integer.valueOf(paramArrayOfString[2]).intValue());
                continue;
                paramContext = new bh();
                paramContext.field_appId = new af("wx32540bd863b27570", "__APP__", 4).toString();
                paramContext.field_version = 1170;
                paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                paramContext.field_pkgPath = "/sdcard/enc.wxapkg";
                com.tencent.mm.plugin.appbrand.app.n.cfm().d(paramContext);
                continue;
                paramContext = new bh();
                paramContext.field_appId = new af("wx32540bd863b27570", "__APP__", 4).toString();
                paramContext.field_version = 1170;
                paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                paramContext.field_pkgPath = "/sdcard/origin.wxapkg";
                com.tencent.mm.plugin.appbrand.app.n.cfm().d(paramContext);
                continue;
                try
                {
                  paramContext = com.tencent.mm.plugin.appbrand.app.f.qBv;
                  com.tencent.mm.plugin.appbrand.app.f.aBP().putBoolean("open_material_fake", "fake".equals(paramArrayOfString[2]));
                }
                catch (Exception paramContext) {}
              }
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      break label2680;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */