package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.luggage.sdk.processes.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.al.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appusage.y.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

public final class e
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = -1;
    boolean bool = false;
    int k = 0;
    AppMethodBeat.i(43788);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (int j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//enable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.bLW();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.bLX();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//appbrand_monkey_bringtofront".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramArrayOfString = paramArrayOfString[1].trim();; paramArrayOfString = "")
      {
        if (i.cjb().w(paramArrayOfString, -1)) {
          i.cjb().a(paramArrayOfString, -1, new kotlin.g.a.b() {});
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
        DebuggerShell.hM(bool);
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//appbrand_predownload_trigger".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramContext = paramArrayOfString[1].trim();; paramContext = "")
      {
        ((com.tencent.mm.plugin.appbrand.service.w)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.w.class)).bu(paramContext, 0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.e.cqK();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.Es(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.Es(0);
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
        com.tencent.mm.plugin.appbrand.utils.c.Dk(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dk(0);
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
        com.tencent.mm.plugin.appbrand.utils.c.Dl(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dl(0);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dl(3);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dl(4);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dl(5);
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
        com.tencent.mm.plugin.appbrand.utils.c.Dm(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dm(0);
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
        com.tencent.mm.plugin.appbrand.utils.c.Dn(1);
        continue;
        com.tencent.mm.plugin.appbrand.utils.c.Dn(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.e.cqv();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.Er(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.e.Er(0);
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
        com.tencent.mm.plugin.appbrand.ad.b.bEC();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.yU(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.yU(0);
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
        com.tencent.mm.plugin.appbrand.ad.b.bEE();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.yV(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.yV(0);
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
          label1735:
          label1760:
          if (paramArrayOfString.length >= 3) {
            paramContext = paramArrayOfString[2];
          }
          switch (paramContext.hashCode())
          {
          default: 
            label1800:
            j = -1;
            switch (j)
            {
            default: 
              label1803:
              label1828:
              if (paramArrayOfString.length >= 4)
              {
                paramContext = paramArrayOfString[3];
                switch (paramContext.hashCode())
                {
                default: 
                  label1868:
                  switch (i)
                  {
                  }
                  break;
                }
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramContext.equals("true")) {
          break;
        }
        j = 0;
        break label1735;
        if (!paramContext.equals("false")) {
          break;
        }
        j = 1;
        break label1735;
        paramContext = com.tencent.mm.plugin.appbrand.widget.c.c.rsW;
        com.tencent.mm.plugin.appbrand.widget.c.c.kk(true);
        break label1760;
        paramContext = com.tencent.mm.plugin.appbrand.widget.c.c.rsW;
        com.tencent.mm.plugin.appbrand.widget.c.c.kk(false);
        break label1760;
        if (!paramContext.equals("true")) {
          break label1800;
        }
        j = 0;
        break label1803;
        if (!paramContext.equals("false")) {
          break label1800;
        }
        j = 1;
        break label1803;
        paramContext = com.tencent.mm.plugin.appbrand.widget.c.c.rsW;
        com.tencent.mm.plugin.appbrand.widget.c.c.kl(true);
        break label1828;
        paramContext = com.tencent.mm.plugin.appbrand.widget.c.c.rsW;
        com.tencent.mm.plugin.appbrand.widget.c.c.kl(false);
        break label1828;
        if (!paramContext.equals("true")) {
          break label1868;
        }
        i = 0;
        break label1868;
        if (!paramContext.equals("false")) {
          break label1868;
        }
        i = 1;
        break label1868;
        paramContext = com.tencent.mm.plugin.appbrand.widget.c.c.rsW;
        com.tencent.mm.plugin.appbrand.widget.c.c.km(true);
        continue;
        paramContext = com.tencent.mm.plugin.appbrand.widget.c.c.rsW;
        com.tencent.mm.plugin.appbrand.widget.c.c.km(false);
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
      if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].contains("daily")))
      {
        paramContext = y.a.nPR;
        com.tencent.mm.plugin.appbrand.appusage.y.bJG();
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        paramContext = y.a.nPS;
        com.tencent.mm.plugin.appbrand.appusage.y.bJG();
      }
    }
    if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      ((com.tencent.mm.plugin.appbrand.service.x)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.x.class)).bJJ();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//wagame".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.plugin.appbrand.game.a.x.a(paramContext, paramArrayOfString);
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//enable_appbrand_file_size_statistics_debug".equals(paramArrayOfString[0])) {}
    try
    {
      com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putBoolean("enable_appbrand_file_size_statistics_debug", paramArrayOfString[1].trim().equals("1"));
      label2407:
      AppMethodBeat.o(43788);
      return true;
      if ("//appbrand_video".equals(paramArrayOfString[0]))
      {
        paramContext = paramArrayOfString[1];
        switch (paramContext.hashCode())
        {
        default: 
          j = -1;
          label2471:
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
          break label2471;
          if (!paramContext.equals("lock_cache")) {
            break;
          }
          j = 1;
          break label2471;
          if (!paramContext.equals("cancel_cache")) {
            break;
          }
          j = 2;
          break label2471;
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
              com.tencent.mm.plugin.appbrand.utils.c.jT(true);
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
          com.tencent.mm.plugin.appbrand.utils.c.jT(false);
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
              com.tencent.mm.plugin.appbrand.utils.c.jU(true);
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
          com.tencent.mm.plugin.appbrand.utils.c.jU(false);
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
              com.tencent.mm.plugin.appbrand.utils.c.jV(true);
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
          com.tencent.mm.plugin.appbrand.utils.c.jV(false);
          continue;
          MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("video_cancel_cache_when_play_command_value");
        }
      }
      paramString = paramArrayOfString[1].toLowerCase();
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
        label3307:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        if (!paramString.equals("jnizip")) {
          break;
        }
        i = 0;
        break label3307;
        if (!paramString.equals("javazip")) {
          break;
        }
        i = 1;
        break label3307;
        if (!paramString.equals("trigger_daily_clean")) {
          break;
        }
        i = 2;
        break label3307;
        if (!paramString.equals("trigger_check_lib_update")) {
          break;
        }
        i = 3;
        break label3307;
        if (!paramString.equals("deletebetalib")) {
          break;
        }
        i = 4;
        break label3307;
        if (!paramString.equals("deletelib")) {
          break;
        }
        i = 5;
        break label3307;
        if (!paramString.equals("deletepkg")) {
          break;
        }
        i = 6;
        break label3307;
        if (!paramString.equals("pkgcleanup")) {
          break;
        }
        i = 7;
        break label3307;
        if (!paramString.equals("pluginlruclean")) {
          break;
        }
        i = 8;
        break label3307;
        if (!paramString.equals("checkdemoclean")) {
          break;
        }
        i = 9;
        break label3307;
        if (!paramString.equals("deletecontact")) {
          break;
        }
        i = 10;
        break label3307;
        if (!paramString.equals("historycount")) {
          break;
        }
        i = 11;
        break label3307;
        if (!paramString.equals("resetsyncversion")) {
          break;
        }
        i = 12;
        break label3307;
        if (!paramString.equals("sync")) {
          break;
        }
        i = 13;
        break label3307;
        if (!paramString.equals("starmax")) {
          break;
        }
        i = 14;
        break label3307;
        if (!paramString.equals("guide")) {
          break;
        }
        i = 15;
        break label3307;
        if (!paramString.equals("clearguide")) {
          break;
        }
        i = 16;
        break label3307;
        if (!paramString.equals("releasepkghighversion")) {
          break;
        }
        i = 17;
        break label3307;
        if (!paramString.equals("incremental_insert_24")) {
          break;
        }
        i = 18;
        break label3307;
        if (!paramString.equals("incremental_insert_28")) {
          break;
        }
        i = 19;
        break label3307;
        if (!paramString.equals("incremental_delete_28")) {
          break;
        }
        i = 20;
        break label3307;
        if (!paramString.equals("incremental_delete_latest")) {
          break;
        }
        i = 21;
        break label3307;
        if (!paramString.equals("incremental_lib")) {
          break;
        }
        i = 22;
        break label3307;
        if (!paramString.equals("clear_mocklib")) {
          break;
        }
        i = 23;
        break label3307;
        if (!paramString.equals("disable_develop_lib")) {
          break;
        }
        i = 24;
        break label3307;
        if (!paramString.equals("disable_preload")) {
          break;
        }
        i = 25;
        break label3307;
        if (!paramString.equals("enable_pre_loading_rainbow")) {
          break;
        }
        i = 26;
        break label3307;
        if (!paramString.equals("disable_pre_loading_rainbow")) {
          break;
        }
        i = 27;
        break label3307;
        if (!paramString.equals("disable_pre_loading")) {
          break;
        }
        i = 28;
        break label3307;
        if (!paramString.equals("enable_pre_loading")) {
          break;
        }
        i = 29;
        break label3307;
        if (!paramString.equals("lazy_code_pkg_launch")) {
          break;
        }
        i = 30;
        break label3307;
        if (!paramString.equals("pre_load_launch")) {
          break;
        }
        i = 31;
        break label3307;
        if (!paramString.equals("pre_load_level")) {
          break;
        }
        i = 32;
        break label3307;
        if (!paramString.equals("insert_pdd_enc_1170_app")) {
          break;
        }
        i = 33;
        break label3307;
        if (!paramString.equals("insert_pdd_ori_1170_app")) {
          break;
        }
        i = 34;
        break label3307;
        if (!paramString.equals("open_material")) {
          break;
        }
        i = 35;
        break label3307;
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
            AppMethodBeat.i(269934);
            long l = Util.nowMilliSecond();
            int i = -1;
            try
            {
              int j = com.tencent.mm.plugin.appbrand.appstorage.o.a(new ZipInputStream(u.al(new q("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
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
            AppMethodBeat.o(269934);
          }
        }, "TestZipJava");
        continue;
        o.bBS();
        continue;
        aw.hs(true);
        continue;
        m.bFP().br("@LibraryAppId", 999);
        i = bb.VERSION;
        at.bGZ();
        continue;
        m.bFP().br("@LibraryAppId", 0);
        i = bb.VERSION;
        at.bGZ();
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
          m.bFP().br(paramContext, i);
          break;
        }
        ThreadPool.post(n.c.bGx(), "WxaPkgCleanupByCMD");
        continue;
        Log.i("PluginCodePruneLRULogic", "pluginCode lru cleanup!");
        paramContext = new AtomicBoolean();
        try
        {
          al.b(4194304L, new al.a()
          {
            public final boolean bBN()
            {
              AppMethodBeat.i(277123);
              boolean bool = paramContext.get();
              AppMethodBeat.o(277123);
              return bool;
            }
          });
        }
        catch (InterruptedException paramContext) {}
        continue;
        Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "checkdemoclean deleteAll!");
        m.bFK().bJQ();
        continue;
        com.tencent.mm.plugin.appbrand.config.y.afm(paramArrayOfString[2]);
        continue;
        if (Util.getInt(paramArrayOfString[2].trim(), 0) > 0) {
          bool = true;
        }
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlQ, Boolean.valueOf(bool));
        continue;
        com.tencent.mm.plugin.appbrand.config.y.afl(paramArrayOfString[2]);
        continue;
        aa.afp(paramArrayOfString[2]);
        continue;
        com.tencent.mm.plugin.appbrand.appusage.v.zj(Math.max(0, Util.getInt(paramArrayOfString[2], 0)));
        continue;
        com.tencent.mm.by.c.ad(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandGuideUI");
        continue;
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlP, Boolean.FALSE);
        continue;
        paramContext = paramArrayOfString[2];
        try
        {
          paramArrayOfString = new WxaAttributes.WxaVersionInfo();
          paramArrayOfString.appVersion = 1000;
          paramArrayOfString.oby = "fake";
          m.bFP().a(paramContext, paramArrayOfString);
        }
        catch (Exception paramContext) {}
        continue;
        paramContext = new bh();
        paramContext.field_appId = "wx4ffb369b6881ee5e";
        paramContext.field_version = 24;
        paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
        paramContext.field_debugType = 0;
        paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
        m.bFP().h(paramContext);
        continue;
        paramContext = new bh();
        paramContext.field_appId = "wx4ffb369b6881ee5e";
        paramContext.field_version = 28;
        paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
        paramContext.field_debugType = 0;
        paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
        m.bFP().h(paramContext);
        continue;
        paramContext = new bh();
        paramContext.field_appId = "wx4ffb369b6881ee5e";
        paramContext.field_version = 28;
        paramContext.field_debugType = 0;
        m.bFP().c(paramContext);
        continue;
        paramContext = m.bFP();
        paramArrayOfString = paramContext.c("wx4ffb369b6881ee5e", 0, new String[] { "version" });
        if (paramArrayOfString != null)
        {
          paramContext.c(paramArrayOfString);
          continue;
          new com.tencent.mm.plugin.appbrand.appcache.v(Util.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
          continue;
          bb.bHj();
          Toast.makeText(MMApplicationContext.getContext(), "MockLib已清除，重启微信生效", 1).show();
          continue;
          if (paramArrayOfString.length >= 3)
          {
            bb.ht(paramArrayOfString[2].trim().contentEquals("1"));
            continue;
            if (paramArrayOfString.length >= 3)
            {
              com.tencent.mm.plugin.appbrand.task.preload.e.jC(paramArrayOfString[2].trim().contentEquals("1"));
            }
            else
            {
              com.tencent.mm.ui.base.w.cR(MMApplicationContext.getContext(), " 预载已禁用，即将重启微信...");
              com.tencent.mm.plugin.appbrand.task.preload.e.jC(true);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(271286);
                  com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                  Object localObject = new Object();
                  com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/appbrand/AppBrandCommand$5", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                  System.exit(((Integer)locala.sf(0)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/appbrand/AppBrandCommand$5", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                  AppMethodBeat.o(271286);
                }
              }, 2000L);
              continue;
              com.tencent.mm.ui.base.w.cR(MMApplicationContext.getContext(), "已开启");
              com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putBoolean("enable_pre_loading_rainbow", true);
              continue;
              com.tencent.mm.ui.base.w.cR(MMApplicationContext.getContext(), "已关闭");
              com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putBoolean("enable_pre_loading_rainbow", false);
              continue;
              com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putBoolean("enable_pre_loading", false);
              continue;
              com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putBoolean("enable_pre_loading", true);
              continue;
              if (paramArrayOfString.length >= 3)
              {
                paramArrayOfString = paramArrayOfString[2];
                if (u.agG(paramArrayOfString))
                {
                  paramString = MD5JNI.getMD5Wrap(paramArrayOfString);
                  if (!TextUtils.isEmpty(paramString))
                  {
                    m.bFP().a("wx5b3f21610c440402", 1, null, paramString, 0L, 0L);
                    m.bFP().f("wx5b3f21610c440402", 1, 0, paramArrayOfString);
                    paramArrayOfString = new g();
                    paramArrayOfString.appId = "wx5b3f21610c440402";
                    paramArrayOfString.cBU = 1;
                    paramArrayOfString.scene = 1001;
                    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(paramContext, paramArrayOfString);
                    continue;
                    if (paramArrayOfString.length == 3)
                    {
                      new com.tencent.mm.plugin.appbrand.appcache.predownload.b.h();
                      com.tencent.mm.plugin.appbrand.appcache.predownload.b.h.cC("", paramArrayOfString[2]);
                      continue;
                      com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putInt("pre_load_level", Integer.valueOf(paramArrayOfString[2]).intValue());
                      continue;
                      paramContext = new bh();
                      paramContext.field_appId = new ae("wx32540bd863b27570", "__APP__", 4).toString();
                      paramContext.field_version = 1170;
                      paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                      paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                      paramContext.field_pkgPath = "/sdcard/enc.wxapkg";
                      m.bFP().d(paramContext);
                      continue;
                      paramContext = new bh();
                      paramContext.field_appId = new ae("wx32540bd863b27570", "__APP__", 4).toString();
                      paramContext.field_version = 1170;
                      paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                      paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                      paramContext.field_pkgPath = "/sdcard/origin.wxapkg";
                      m.bFP().d(paramContext);
                      continue;
                      try
                      {
                        com.tencent.mm.plugin.appbrand.app.f.nCi.aal().putBoolean("open_material_fake", "fake".equals(paramArrayOfString[2]));
                      }
                      catch (Exception paramContext) {}
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      break label2407;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */