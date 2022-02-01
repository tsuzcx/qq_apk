package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appusage.y.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.task.p;
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
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

public final class b
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
      DebuggerShell.bAB();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.bAC();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//appbrand_monkey_bringtofront".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramArrayOfString = paramArrayOfString[1].trim();; paramArrayOfString = "")
      {
        paramArrayOfString = com.tencent.mm.plugin.appbrand.task.h.bWb().afj(paramArrayOfString);
        if (paramArrayOfString != null)
        {
          paramString = new com.tencent.mm.plugin.appbrand.api.g();
          paramString.appId = ((String)paramArrayOfString.first);
          paramString.iOo = ((Integer)paramArrayOfString.second).intValue();
          paramString.scene = 1030;
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, paramString);
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
        DebuggerShell.gV(bool);
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//appbrand_predownload_trigger".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramContext = paramArrayOfString[1].trim();; paramContext = "")
      {
        ((w)com.tencent.mm.kernel.g.af(w.class)).bb(paramContext, 0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.c.cdy();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.AM(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.AM(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AP(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AP(0);
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
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AQ(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AQ(0);
      }
    }
    if ("//xweb_hls_video_player".equals(paramArrayOfString[0]))
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
        MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_hls_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AR(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AR(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AS(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AS(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AT(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.AT(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.c.cdj();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.AL(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.AL(0);
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
        com.tencent.mm.plugin.appbrand.ad.b.btE();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.vJ(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.vJ(0);
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
        com.tencent.mm.plugin.appbrand.ad.b.btG();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.vK(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.vK(0);
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
        paramContext = y.a.kVE;
        com.tencent.mm.plugin.appbrand.appusage.y.bys();
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        paramContext = y.a.kVF;
        com.tencent.mm.plugin.appbrand.appusage.y.bys();
      }
    }
    if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      ((x)com.tencent.mm.kernel.g.af(x.class)).byv();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//wagame".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.plugin.appbrand.game.a.v.a(paramContext, paramArrayOfString);
      AppMethodBeat.o(43788);
      return true;
    }
    paramString = paramArrayOfString[1].toLowerCase();
    switch (paramString.hashCode())
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
      if (!paramString.equals("jnizip")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("javazip")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("trigger_daily_clean")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("trigger_check_lib_update")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("deletebetalib")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("deletelib")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("deletepkg")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("pkgcleanup")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("pluginlruclean")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("checkdemoclean")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("deletecontact")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("historycount")) {
        break;
      }
      i = 11;
      break;
      if (!paramString.equals("resetsyncversion")) {
        break;
      }
      i = 12;
      break;
      if (!paramString.equals("sync")) {
        break;
      }
      i = 13;
      break;
      if (!paramString.equals("starmax")) {
        break;
      }
      i = 14;
      break;
      if (!paramString.equals("guide")) {
        break;
      }
      i = 15;
      break;
      if (!paramString.equals("clearguide")) {
        break;
      }
      i = 16;
      break;
      if (!paramString.equals("releasepkghighversion")) {
        break;
      }
      i = 17;
      break;
      if (!paramString.equals("incremental_insert_24")) {
        break;
      }
      i = 18;
      break;
      if (!paramString.equals("incremental_insert_28")) {
        break;
      }
      i = 19;
      break;
      if (!paramString.equals("incremental_delete_28")) {
        break;
      }
      i = 20;
      break;
      if (!paramString.equals("incremental_delete_latest")) {
        break;
      }
      i = 21;
      break;
      if (!paramString.equals("incremental_lib")) {
        break;
      }
      i = 22;
      break;
      if (!paramString.equals("clear_mocklib")) {
        break;
      }
      i = 23;
      break;
      if (!paramString.equals("disable_develop_lib")) {
        break;
      }
      i = 24;
      break;
      if (!paramString.equals("disable_preload")) {
        break;
      }
      i = 25;
      break;
      if (!paramString.equals("enable_pre_loading_rainbow")) {
        break;
      }
      i = 26;
      break;
      if (!paramString.equals("disable_pre_loading_rainbow")) {
        break;
      }
      i = 27;
      break;
      if (!paramString.equals("disable_pre_loading")) {
        break;
      }
      i = 28;
      break;
      if (!paramString.equals("enable_pre_loading")) {
        break;
      }
      i = 29;
      break;
      if (!paramString.equals("lazy_code_pkg_launch")) {
        break;
      }
      i = 30;
      break;
      if (!paramString.equals("pre_load_launch")) {
        break;
      }
      i = 31;
      break;
      if (!paramString.equals("pre_load_level")) {
        break;
      }
      i = 32;
      break;
      if (!paramString.equals("insert_pdd_enc_1170_app")) {
        break;
      }
      i = 33;
      break;
      if (!paramString.equals("insert_pdd_ori_1170_app")) {
        break;
      }
      i = 34;
      break;
      if (!paramString.equals("open_material")) {
        break;
      }
      i = 35;
      break;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43784);
          long l = Util.nowMilliSecond();
          Log.i("[ZIP]", "unzip JNI %d, cost %d", new Object[] { Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(Util.nowMilliSecond() - l) });
          AppMethodBeat.o(43784);
        }
      }, "TestZipJNI");
      continue;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43785);
          long l = Util.nowMilliSecond();
          int i = -1;
          try
          {
            int j = com.tencent.mm.plugin.appbrand.appstorage.n.a(new ZipInputStream(s.ao(new o("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
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
          AppMethodBeat.o(43785);
        }
      }, "TestZipJava");
      continue;
      l.brc();
      continue;
      au.gH(true);
      continue;
      paramContext = com.tencent.mm.plugin.appbrand.app.n.buL();
      paramArrayOfString = new bd();
      paramArrayOfString.field_appId = "@LibraryAppId";
      paramArrayOfString.field_debugType = 999;
      paramArrayOfString.field_version = 1;
      paramContext.kNK.delete(paramArrayOfString, bd.kNu);
      i = ay.VERSION;
      as.bvR();
      continue;
      com.tencent.mm.plugin.appbrand.app.n.buL().aZ("@LibraryAppId", 0);
      i = ay.VERSION;
      as.bvR();
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
        com.tencent.mm.plugin.appbrand.app.n.buL().aZ(paramContext, i);
        break;
      }
      ThreadPool.post(n.c.bvr(), "WxaPkgCleanupByCMD");
      continue;
      Log.i("PluginCodePruneLRULogic", "pluginCode lru cleanup!");
      paramContext = new AtomicBoolean();
      try
      {
        ak.b(4194304L, new ak.a()
        {
          public final boolean bqX()
          {
            AppMethodBeat.i(43786);
            boolean bool = paramContext.get();
            AppMethodBeat.o(43786);
            return bool;
          }
        });
      }
      catch (InterruptedException paramContext) {}
      continue;
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "checkdemoclean deleteAll!");
      com.tencent.mm.plugin.appbrand.app.n.buG().byC();
      continue;
      com.tencent.mm.plugin.appbrand.config.y.XA(paramArrayOfString[2]);
      continue;
      if (Util.getInt(paramArrayOfString[2].trim(), 0) > 0) {
        bool = true;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXQ, Boolean.valueOf(bool));
      continue;
      com.tencent.mm.plugin.appbrand.config.y.Xz(paramArrayOfString[2]);
      continue;
      aa.XD(paramArrayOfString[2]);
      continue;
      com.tencent.mm.plugin.appbrand.appusage.v.vY(Math.max(0, Util.getInt(paramArrayOfString[2], 0)));
      continue;
      com.tencent.mm.br.c.V(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandGuideUI");
      continue;
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXP, Boolean.FALSE);
      continue;
      paramContext = paramArrayOfString[2];
      try
      {
        paramArrayOfString = new WxaAttributes.WxaVersionInfo();
        paramArrayOfString.appVersion = 1000;
        paramArrayOfString.lgS = "fake";
        com.tencent.mm.plugin.appbrand.app.n.buL().a(paramContext, paramArrayOfString);
      }
      catch (Exception paramContext) {}
      continue;
      paramContext = new bd();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 24;
      paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
      com.tencent.mm.plugin.appbrand.app.n.buL().f(paramContext);
      continue;
      paramContext = new bd();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
      com.tencent.mm.plugin.appbrand.app.n.buL().f(paramContext);
      continue;
      paramContext = new bd();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_debugType = 0;
      com.tencent.mm.plugin.appbrand.app.n.buL().a(paramContext);
      continue;
      paramContext = com.tencent.mm.plugin.appbrand.app.n.buL();
      paramArrayOfString = paramContext.a("wx4ffb369b6881ee5e", 0, new String[] { "version" });
      if (paramArrayOfString != null)
      {
        paramContext.a(paramArrayOfString);
        continue;
        new com.tencent.mm.plugin.appbrand.appcache.u(Util.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
        continue;
        ay.bwc();
        Toast.makeText(MMApplicationContext.getContext(), "MockLib已清除，重启微信生效", 1).show();
        continue;
        if (paramArrayOfString.length >= 3)
        {
          ay.gI(paramArrayOfString[2].trim().contentEquals("1"));
          continue;
          if (paramArrayOfString.length >= 3)
          {
            com.tencent.mm.plugin.appbrand.task.preload.e.iG(paramArrayOfString[2].trim().contentEquals("1"));
          }
          else
          {
            com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), " 预载已禁用，即将重启微信...");
            com.tencent.mm.plugin.appbrand.task.preload.e.iG(true);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43787);
                com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                Object localObject = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/appbrand/AppBrandCommand$4", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                System.exit(((Integer)locala.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/AppBrandCommand$4", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                AppMethodBeat.o(43787);
              }
            }, 2000L);
            continue;
            com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), "已开启");
            f.kIs.VQ().putBoolean("enable_pre_loading_rainbow", true);
            continue;
            com.tencent.mm.ui.base.u.cG(MMApplicationContext.getContext(), "已关闭");
            f.kIs.VQ().putBoolean("enable_pre_loading_rainbow", false);
            continue;
            f.kIs.VQ().putBoolean("enable_pre_loading", false);
            continue;
            f.kIs.VQ().putBoolean("enable_pre_loading", true);
            continue;
            if (paramArrayOfString.length >= 3)
            {
              paramArrayOfString = paramArrayOfString[2];
              if (s.YS(paramArrayOfString))
              {
                paramString = MD5JNI.getMD5Wrap(paramArrayOfString);
                if (!TextUtils.isEmpty(paramString))
                {
                  com.tencent.mm.plugin.appbrand.app.n.buL().a("wx5b3f21610c440402", 1, null, paramString, 0L, 0L);
                  com.tencent.mm.plugin.appbrand.app.n.buL().e("wx5b3f21610c440402", 1, 0, paramArrayOfString);
                  paramArrayOfString = new com.tencent.mm.plugin.appbrand.api.g();
                  paramArrayOfString.appId = "wx5b3f21610c440402";
                  paramArrayOfString.iOo = 1;
                  paramArrayOfString.scene = 1001;
                  ((r)com.tencent.mm.kernel.g.af(r.class)).a(paramContext, paramArrayOfString);
                  continue;
                  if (paramArrayOfString.length == 3)
                  {
                    new com.tencent.mm.plugin.appbrand.appcache.predownload.b.h();
                    com.tencent.mm.plugin.appbrand.appcache.predownload.b.h.cx("", paramArrayOfString[2]);
                    continue;
                    f.kIs.VQ().putInt("pre_load_level", Integer.valueOf(paramArrayOfString[2]).intValue());
                    continue;
                    paramContext = new bd();
                    paramContext.field_appId = new ad("wx32540bd863b27570", "__APP__", 4).toString();
                    paramContext.field_version = 1170;
                    paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                    paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                    paramContext.field_pkgPath = "/sdcard/enc.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.n.buL().b(paramContext);
                    continue;
                    paramContext = new bd();
                    paramContext.field_appId = new ad("wx32540bd863b27570", "__APP__", 4).toString();
                    paramContext.field_version = 1170;
                    paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                    paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                    paramContext.field_pkgPath = "/sdcard/origin.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.n.buL().b(paramContext);
                    continue;
                    try
                    {
                      f.kIs.VQ().putBoolean("open_material_fake", "fake".equals(paramArrayOfString[2]));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b
 * JD-Core Version:    0.7.0.1
 */