package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appusage.z;
import com.tencent.mm.plugin.appbrand.appusage.z.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = -1;
    int k = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(43788);
    if ((bv.fpT()) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)) {}
    for (int j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//enable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.bfi();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.bfj();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//appbrand_monkey_bringtofront".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramArrayOfString = paramArrayOfString[1].trim();; paramArrayOfString = "")
      {
        paramArrayOfString = com.tencent.mm.plugin.appbrand.task.f.Vr(paramArrayOfString);
        if (paramArrayOfString != null)
        {
          paramString = new com.tencent.mm.plugin.appbrand.api.f();
          paramString.appId = ((String)paramArrayOfString.first);
          paramString.hSZ = ((Integer)paramArrayOfString.second).intValue();
          paramString.scene = 1030;
          ((p)g.ab(p.class)).a(paramContext, paramString);
        }
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//appbrand_monkey_test_skip_appbrand_process_suicide".equals(paramArrayOfString[0]))
    {
      if ((paramArrayOfString.length > 1) && (bu.getInt(paramArrayOfString[1].trim(), 1) <= 0)) {}
      for (;;)
      {
        DebuggerShell.fY(bool1);
        AppMethodBeat.o(43788);
        return true;
        bool1 = true;
      }
    }
    if ("//appbrand_predownload_trigger".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramContext = paramArrayOfString[1].trim();; paramContext = "")
      {
        ((s)g.ab(s.class)).Mr(paramContext);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.c.bGY();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.xg(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.xg(0);
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
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").removeValueForKey("xweb_video_preload_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xj(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xj(0);
      }
    }
    if ("//xweb_video_ps".equals(paramArrayOfString[0]))
    {
      i = bu.aSB(paramArrayOfString[1]);
      if (i < 0) {
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").removeValueForKey("xweb_video_weishi_ps_command_value");
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").encode("xweb_video_weishi_ps_command_value", i);
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
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").removeValueForKey("xweb_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xk(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xk(0);
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
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").removeValueForKey("xweb_hls_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xl(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xl(0);
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
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").removeValueForKey("xweb_video_proxy_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xm(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xm(0);
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
        com.tencent.mm.sdk.platformtools.ay.aRW("xweb_abtest_command").removeValueForKey("xweb_video_hls_proxy_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xn(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.xn(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.c.bGL();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.xf(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.xf(0);
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
        com.tencent.mm.plugin.appbrand.ad.b.aYq();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.rO(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.rO(0);
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
        com.tencent.mm.plugin.appbrand.ad.b.aYs();
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.rP(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.b.rP(0);
      }
    }
    if ("//localwxalibrary".equals(paramArrayOfString[0]))
    {
      paramContext = com.tencent.mm.sdk.platformtools.ay.aRW("__appbrand_comm_lib__prefs");
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
        paramContext = z.a.jSW;
        z.bdd();
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        paramContext = z.a.jSX;
        z.bdd();
      }
    }
    if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      ((com.tencent.mm.plugin.appbrand.service.t)g.ab(com.tencent.mm.plugin.appbrand.service.t.class)).bdg();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//wagame".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.plugin.appbrand.game.a.t.a(paramContext, paramArrayOfString);
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
      if (!paramString.equals("force_modularizing")) {
        break;
      }
      i = 24;
      break;
      if (!paramString.equals("disable_develop_lib")) {
        break;
      }
      i = 25;
      break;
      if (!paramString.equals("preload-js")) {
        break;
      }
      i = 26;
      break;
      if (!paramString.equals("preload-flutter")) {
        break;
      }
      i = 27;
      break;
      if (!paramString.equals("disable_preload")) {
        break;
      }
      i = 28;
      break;
      if (!paramString.equals("enable_pre_loading_rainbow")) {
        break;
      }
      i = 29;
      break;
      if (!paramString.equals("disable_pre_loading_rainbow")) {
        break;
      }
      i = 30;
      break;
      if (!paramString.equals("disable_pre_loading")) {
        break;
      }
      i = 31;
      break;
      if (!paramString.equals("enable_pre_loading")) {
        break;
      }
      i = 32;
      break;
      if (!paramString.equals("lazy_code_pkg_launch")) {
        break;
      }
      i = 33;
      break;
      if (!paramString.equals("pre_load_launch")) {
        break;
      }
      i = 34;
      break;
      if (!paramString.equals("pre_load_level")) {
        break;
      }
      i = 35;
      break;
      if (!paramString.equals("enter_pre_load_downgrade_env")) {
        break;
      }
      i = 36;
      break;
      if (!paramString.equals("exit_pre_load_downgrade_env")) {
        break;
      }
      i = 37;
      break;
      if (!paramString.equals("insert_pdd_enc_1170_app")) {
        break;
      }
      i = 38;
      break;
      if (!paramString.equals("insert_pdd_ori_1170_app")) {
        break;
      }
      i = 39;
      break;
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43784);
          long l = bu.fpO();
          ae.i("[ZIP]", "unzip JNI %d, cost %d", new Object[] { Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(bu.fpO() - l) });
          AppMethodBeat.o(43784);
        }
      }, "TestZipJNI");
      continue;
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43785);
          long l = bu.fpO();
          int i = -1;
          try
          {
            int j = n.a(new ZipInputStream(o.ai(new com.tencent.mm.vfs.k("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
            i = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.e("[ZIP]", "unzip Java ex=%s", new Object[] { localException });
            }
          }
          ae.i("[ZIP]", "unzip Java %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(bu.fpO() - l) });
          AppMethodBeat.o(43785);
        }
      }, "TestZipJava");
      continue;
      k.aWh();
      continue;
      au.fL(true);
      continue;
      paramContext = com.tencent.mm.plugin.appbrand.app.j.aZu();
      paramArrayOfString = new bd();
      paramArrayOfString.field_appId = "@LibraryAppId";
      paramArrayOfString.field_debugType = 999;
      paramArrayOfString.field_version = 1;
      paramContext.jLL.delete(paramArrayOfString, bd.jLv);
      i = com.tencent.mm.plugin.appbrand.appcache.ay.VERSION;
      as.baD();
      continue;
      com.tencent.mm.plugin.appbrand.app.j.aZu().aW("@LibraryAppId", 0);
      i = com.tencent.mm.plugin.appbrand.appcache.ay.VERSION;
      as.baD();
      continue;
      if (paramArrayOfString.length > 2) {}
      for (paramContext = paramArrayOfString[2].trim();; paramContext = null)
      {
        i = k;
        if (paramArrayOfString.length > 3) {
          i = bu.getInt(paramArrayOfString[3].trim(), 0);
        }
        if (TextUtils.isEmpty(paramContext)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.app.j.aZu().aW(paramContext, i);
        break;
      }
      com.tencent.mm.sdk.g.b.c(n.c.baa(), "WxaPkgCleanupByCMD");
      continue;
      ae.i("PluginCodePruneLRULogic", "pluginCode lru cleanup!");
      paramContext = new AtomicBoolean();
      try
      {
        com.tencent.mm.plugin.appbrand.appcache.ak.b(4194304L, new ak.a()
        {
          public final boolean aWa()
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
      ae.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "checkdemoclean deleteAll!");
      com.tencent.mm.plugin.appbrand.app.j.aZp().bdi();
      continue;
      com.tencent.mm.plugin.appbrand.config.v.Oq(paramArrayOfString[2]);
      continue;
      bool1 = bool2;
      if (bu.getInt(paramArrayOfString[2].trim(), 0) > 0) {
        bool1 = true;
      }
      g.ajR().ajA().set(am.a.IPP, Boolean.valueOf(bool1));
      continue;
      com.tencent.mm.plugin.appbrand.config.v.Op(paramArrayOfString[2]);
      continue;
      x.Ot(paramArrayOfString[2]);
      continue;
      com.tencent.mm.plugin.appbrand.appusage.v.sd(Math.max(0, bu.getInt(paramArrayOfString[2], 0)));
      continue;
      com.tencent.mm.br.d.Q(com.tencent.mm.sdk.platformtools.ak.getContext(), "appbrand", ".ui.AppBrandGuideUI");
      continue;
      g.ajR().ajA().set(am.a.IPO, Boolean.FALSE);
      continue;
      paramContext = paramArrayOfString[2];
      try
      {
        paramArrayOfString = new WxaAttributes.WxaVersionInfo();
        paramArrayOfString.aDD = 1000;
        paramArrayOfString.kdn = "fake";
        com.tencent.mm.plugin.appbrand.app.j.aZu().a(paramContext, paramArrayOfString);
      }
      catch (Exception paramContext) {}
      continue;
      paramContext = new bd();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 24;
      paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
      com.tencent.mm.plugin.appbrand.app.j.aZu().f(paramContext);
      continue;
      paramContext = new bd();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
      com.tencent.mm.plugin.appbrand.app.j.aZu().f(paramContext);
      continue;
      paramContext = new bd();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_debugType = 0;
      com.tencent.mm.plugin.appbrand.app.j.aZu().a(paramContext);
      continue;
      paramContext = com.tencent.mm.plugin.appbrand.app.j.aZu();
      paramArrayOfString = paramContext.a("wx4ffb369b6881ee5e", 0, new String[] { "version" });
      if (paramArrayOfString != null)
      {
        paramContext.a(paramArrayOfString);
        continue;
        new u(bu.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
        continue;
        com.tencent.mm.plugin.appbrand.appcache.ay.baO();
        Toast.makeText(com.tencent.mm.sdk.platformtools.ak.getContext(), "MockLib已清除，重启微信生效", 1).show();
        continue;
        if (paramArrayOfString.length >= 3)
        {
          bool1 = bool3;
          if (paramArrayOfString[2].equalsIgnoreCase("false")) {}
        }
        else
        {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.launching.bi.lPL = bool1;
        continue;
        if (paramArrayOfString.length >= 3)
        {
          com.tencent.mm.plugin.appbrand.appcache.ay.fM(paramArrayOfString[2].trim().contentEquals("1"));
          continue;
          paramContext = com.tencent.mm.plugin.m.a.c.c.vPc;
          com.tencent.mm.plugin.m.a.c.c.on(paramArrayOfString[2].equals("1"));
          continue;
          paramContext = com.tencent.mm.plugin.m.a.c.c.vPc;
          com.tencent.mm.plugin.m.a.c.c.oo(paramArrayOfString[2].equals("1"));
          continue;
          if (paramArrayOfString.length >= 3)
          {
            com.tencent.mm.plugin.appbrand.task.preload.d.hC(paramArrayOfString[2].trim().contentEquals("1"));
          }
          else
          {
            com.tencent.mm.ui.base.t.cn(com.tencent.mm.sdk.platformtools.ak.getContext(), " 预载已禁用，即将重启微信...");
            com.tencent.mm.plugin.appbrand.task.preload.d.hC(true);
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43787);
                com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                Object localObject = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/appbrand/AppBrandCommand$4", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                System.exit(((Integer)locala.mt(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/AppBrandCommand$4", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                AppMethodBeat.o(43787);
              }
            }, 2000L);
            continue;
            com.tencent.mm.ui.base.t.cn(com.tencent.mm.sdk.platformtools.ak.getContext(), "已开启");
            paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
            com.tencent.mm.plugin.appbrand.app.d.LD().putBoolean("enable_pre_loading_rainbow", true);
            continue;
            com.tencent.mm.ui.base.t.cn(com.tencent.mm.sdk.platformtools.ak.getContext(), "已关闭");
            paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
            com.tencent.mm.plugin.appbrand.app.d.LD().putBoolean("enable_pre_loading_rainbow", false);
            continue;
            paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
            com.tencent.mm.plugin.appbrand.app.d.LD().putBoolean("enable_pre_loading", false);
            continue;
            paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
            com.tencent.mm.plugin.appbrand.app.d.LD().putBoolean("enable_pre_loading", true);
            continue;
            if (paramArrayOfString.length >= 3)
            {
              paramArrayOfString = paramArrayOfString[2];
              if (o.fB(paramArrayOfString))
              {
                paramString = MD5JNI.getMD5Wrap(paramArrayOfString);
                if (!TextUtils.isEmpty(paramString))
                {
                  com.tencent.mm.plugin.appbrand.app.j.aZu().a("wx5b3f21610c440402", 1, null, paramString, 0L, 0L);
                  com.tencent.mm.plugin.appbrand.app.j.aZu().e("wx5b3f21610c440402", 1, 0, paramArrayOfString);
                  paramArrayOfString = new com.tencent.mm.plugin.appbrand.api.f();
                  paramArrayOfString.appId = "wx5b3f21610c440402";
                  paramArrayOfString.hSZ = 1;
                  paramArrayOfString.scene = 1001;
                  ((p)g.ab(p.class)).a(paramContext, paramArrayOfString);
                  continue;
                  if (paramArrayOfString.length == 3)
                  {
                    new h();
                    h.cj("", paramArrayOfString[2]);
                    continue;
                    paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
                    com.tencent.mm.plugin.appbrand.app.d.LD().putInt("pre_load_level", Integer.valueOf(paramArrayOfString[2]).intValue());
                    continue;
                    paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
                    com.tencent.mm.plugin.appbrand.app.d.LD().putBoolean("is_pre_load_downgrade_env", true);
                    continue;
                    paramContext = com.tencent.mm.plugin.appbrand.app.d.jGw;
                    com.tencent.mm.plugin.appbrand.app.d.LD().putBoolean("is_pre_load_downgrade_env", false);
                    continue;
                    paramContext = new bd();
                    paramContext.field_appId = new ad("wx32540bd863b27570", "__APP__", 4).toString();
                    paramContext.field_version = 1170;
                    paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                    paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                    paramContext.field_pkgPath = "/sdcard/enc.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.j.aZu().b(paramContext);
                    continue;
                    paramContext = new bd();
                    paramContext.field_appId = new ad("wx32540bd863b27570", "__APP__", 4).toString();
                    paramContext.field_version = 1170;
                    paramContext.field_versionMd5 = "cf3f65adde418a69001fe285a37ad2ce";
                    paramContext.field_NewMd5 = "b1d11357e7ae7ca9139f6a9641da26b0";
                    paramContext.field_pkgPath = "/sdcard/origin.wxapkg";
                    com.tencent.mm.plugin.appbrand.app.j.aZu().b(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b
 * JD-Core Version:    0.7.0.1
 */