package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.ai.a;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bf.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appusage.v;
import com.tencent.mm.plugin.appbrand.appusage.z;
import com.tencent.mm.plugin.appbrand.appusage.z.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = -1;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(43788);
    if ((bu.eGT()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {}
    for (int j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//enable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.aUa();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.aUb();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//appbrand_monkey_bringtofront".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramArrayOfString = paramArrayOfString[1].trim();; paramArrayOfString = "")
      {
        paramArrayOfString = com.tencent.mm.plugin.appbrand.task.f.MR(paramArrayOfString);
        if (paramArrayOfString != null)
        {
          paramString = new com.tencent.mm.plugin.appbrand.a.f();
          paramString.appId = ((String)paramArrayOfString.first);
          paramString.gXn = ((Integer)paramArrayOfString.second).intValue();
          paramString.scene = 1030;
          ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramContext, paramString);
        }
        AppMethodBeat.o(43788);
        return true;
      }
    }
    if ("//appbrand_predownload_trigger".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramContext = paramArrayOfString[1].trim();; paramContext = "")
      {
        ((q)g.ab(q.class)).Eu(paramContext);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.c.bvb();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.vF(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.vF(0);
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
        ax.aFC("xweb_abtest_command").removeValueForKey("xweb_video_preload_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vH(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vH(0);
      }
    }
    if ("//xweb_video_ps".equals(paramArrayOfString[0]))
    {
      i = bt.aGh(paramArrayOfString[1]);
      if (i < 0) {
        ax.aFC("xweb_abtest_command").removeValueForKey("xweb_video_weishi_ps_command_value");
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        ax.aFC("xweb_abtest_command").encode("xweb_video_weishi_ps_command_value", i);
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
        ax.aFC("xweb_abtest_command").removeValueForKey("xweb_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vI(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vI(0);
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
        ax.aFC("xweb_abtest_command").removeValueForKey("xweb_hls_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vJ(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vJ(0);
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
        ax.aFC("xweb_abtest_command").removeValueForKey("xweb_video_proxy_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vK(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vK(0);
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
        ax.aFC("xweb_abtest_command").removeValueForKey("xweb_video_hls_proxy_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vL(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.video.b.vL(0);
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
        com.tencent.mm.plugin.appbrand.xweb_ext.c.buP();
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.vE(1);
        continue;
        com.tencent.mm.plugin.appbrand.xweb_ext.c.vE(0);
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
        com.tencent.mm.plugin.appbrand.ad.a.aNU();
        continue;
        com.tencent.mm.plugin.appbrand.ad.a.qx(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.a.qx(0);
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
        com.tencent.mm.plugin.appbrand.ad.a.aNW();
        continue;
        com.tencent.mm.plugin.appbrand.ad.a.qy(1);
        continue;
        com.tencent.mm.plugin.appbrand.ad.a.qy(0);
      }
    }
    if ("//localwxalibrary".equals(paramArrayOfString[0]))
    {
      paramContext = ax.aFC("__appbrand_comm_lib__prefs");
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
        paramContext = z.a.iVu;
        z.aSd();
      }
      for (;;)
      {
        AppMethodBeat.o(43788);
        return true;
        paramContext = z.a.iVv;
        z.aSd();
      }
    }
    if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      ((r)g.ab(r.class)).aSg();
      AppMethodBeat.o(43788);
      return true;
    }
    if ("//wagame".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.plugin.appbrand.game.a.n.a(paramContext, paramArrayOfString);
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
      if (!paramString.equals("deletebetalib")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("deletelib")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("deletepkg")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("pkgcleanup")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("pluginlruclean")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("deletecontact")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("historycount")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("resetsyncversion")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("sync")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("starmax")) {
        break;
      }
      i = 11;
      break;
      if (!paramString.equals("guide")) {
        break;
      }
      i = 12;
      break;
      if (!paramString.equals("clearguide")) {
        break;
      }
      i = 13;
      break;
      if (!paramString.equals("releasepkghighversion")) {
        break;
      }
      i = 14;
      break;
      if (!paramString.equals("incremental_insert_24")) {
        break;
      }
      i = 15;
      break;
      if (!paramString.equals("incremental_insert_28")) {
        break;
      }
      i = 16;
      break;
      if (!paramString.equals("incremental_delete_28")) {
        break;
      }
      i = 17;
      break;
      if (!paramString.equals("incremental_delete_latest")) {
        break;
      }
      i = 18;
      break;
      if (!paramString.equals("incremental_lib")) {
        break;
      }
      i = 19;
      break;
      if (!paramString.equals("clear_mocklib")) {
        break;
      }
      i = 20;
      break;
      if (!paramString.equals("force_modularizing")) {
        break;
      }
      i = 21;
      break;
      if (!paramString.equals("disable_develop_lib")) {
        break;
      }
      i = 22;
      break;
      if (!paramString.equals("preload-js")) {
        break;
      }
      i = 23;
      break;
      if (!paramString.equals("preload-flutter")) {
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
      if (!paramString.equals("enter_pre_load_downgrade_env")) {
        break;
      }
      i = 33;
      break;
      if (!paramString.equals("exit_pre_load_downgrade_env")) {
        break;
      }
      i = 34;
      break;
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43784);
          long l = bt.eGO();
          ad.i("[ZIP]", "unzip JNI %d, cost %d", new Object[] { Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(bt.eGO() - l) });
          AppMethodBeat.o(43784);
        }
      }, "TestZipJNI");
      continue;
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43785);
          long l = bt.eGO();
          int i = -1;
          try
          {
            int j = m.a(new ZipInputStream(i.ah(new com.tencent.mm.vfs.e("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
            i = j;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.e("[ZIP]", "unzip Java ex=%s", new Object[] { localException });
            }
          }
          ad.i("[ZIP]", "unzip Java %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(bt.eGO() - l) });
          AppMethodBeat.o(43785);
        }
      }, "TestZipJava");
      continue;
      paramContext = j.aOK();
      paramArrayOfString = new bb();
      paramArrayOfString.field_appId = "@LibraryAppId";
      paramArrayOfString.field_debugType = 999;
      paramArrayOfString.field_version = 1;
      paramContext.iOF.delete(paramArrayOfString, bb.iOp);
      i = aw.VERSION;
      com.tencent.mm.plugin.appbrand.appcache.aq.aPP();
      continue;
      j.aOK().aN("@LibraryAppId", 0);
      i = aw.VERSION;
      com.tencent.mm.plugin.appbrand.appcache.aq.aPP();
      continue;
      if (paramArrayOfString.length > 2)
      {
        paramContext = paramArrayOfString[2].trim();
        label3203:
        if (paramArrayOfString.length <= 3) {
          break label3246;
        }
      }
      label3246:
      for (i = bt.getInt(paramArrayOfString[3].trim(), 0); !TextUtils.isEmpty(paramContext); i = 0)
      {
        j.aOK().aN(paramContext, i);
        break;
        paramContext = null;
        break label3203;
      }
      com.tencent.mm.sdk.g.b.c(n.c.aPq(), "WxaPkgCleanupByCMD");
      continue;
      ad.i("PluginCodePruneLRULogic", "pluginCode lru cleanup!");
      paramContext = new AtomicBoolean();
      try
      {
        ai.b(4194304L, new ai.a()
        {
          public final boolean aLy()
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
      u.Gl(paramArrayOfString[2]);
      continue;
      if (bt.getInt(paramArrayOfString[2].trim(), 0) > 0) {
        bool1 = true;
      }
      g.afB().afk().set(ae.a.Flk, Boolean.valueOf(bool1));
      continue;
      u.Gk(paramArrayOfString[2]);
      continue;
      w.Go(paramArrayOfString[2]);
      continue;
      v.qN(Math.max(0, bt.getInt(paramArrayOfString[2], 0)));
      continue;
      com.tencent.mm.bs.d.O(aj.getContext(), "appbrand", ".ui.AppBrandGuideUI");
      continue;
      g.afB().afk().set(ae.a.Flj, Boolean.FALSE);
      continue;
      paramContext = paramArrayOfString[2];
      try
      {
        paramArrayOfString = new WxaAttributes.WxaVersionInfo();
        paramArrayOfString.aAS = 1000;
        paramArrayOfString.jfy = "fake";
        j.aOK().a(paramContext, paramArrayOfString);
      }
      catch (Exception paramContext) {}
      continue;
      paramContext = new bb();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 24;
      paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
      paramContext.field_versionState = 0;
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
      j.aOK().f(paramContext);
      continue;
      paramContext = new bb();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
      paramContext.field_versionState = 0;
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
      j.aOK().f(paramContext);
      continue;
      paramContext = new bb();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_debugType = 0;
      j.aOK().a(paramContext);
      continue;
      paramContext = j.aOK();
      paramArrayOfString = paramContext.a("wx4ffb369b6881ee5e", 0, new String[] { "version" });
      if (paramArrayOfString != null)
      {
        paramContext.a(paramArrayOfString);
        continue;
        new com.tencent.mm.plugin.appbrand.appcache.t(bt.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
        continue;
        aw.aQa();
        Toast.makeText(aj.getContext(), "MockLib已清除，重启微信生效", 1).show();
        continue;
        if (paramArrayOfString.length >= 3)
        {
          bool1 = bool2;
          if (paramArrayOfString[2].equalsIgnoreCase("false")) {}
        }
        else
        {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.launching.bf.kMw = bool1;
        continue;
        if (paramArrayOfString.length >= 3)
        {
          aw.fn(paramArrayOfString[2].trim().contentEquals("1"));
          continue;
          paramContext = com.tencent.mm.plugin.m.a.c.c.tsc;
          com.tencent.mm.plugin.m.a.c.c.mV(paramArrayOfString[2].equals("1"));
          continue;
          paramContext = com.tencent.mm.plugin.m.a.c.c.tsc;
          com.tencent.mm.plugin.m.a.c.c.mW(paramArrayOfString[2].equals("1"));
          continue;
          if (paramArrayOfString.length >= 3)
          {
            com.tencent.mm.plugin.appbrand.task.preload.d.gX(paramArrayOfString[2].trim().contentEquals("1"));
          }
          else
          {
            com.tencent.mm.ui.base.t.cg(aj.getContext(), " 预载已禁用，即将重启微信...");
            com.tencent.mm.plugin.appbrand.task.preload.d.gX(true);
            com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(43787);
                System.exit(0);
                AppMethodBeat.o(43787);
              }
            }, 2000L);
            continue;
            com.tencent.mm.ui.base.t.cg(aj.getContext(), "已开启");
            paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
            com.tencent.mm.plugin.appbrand.app.d.Km().putBoolean("enable_pre_loading_rainbow", true);
            continue;
            com.tencent.mm.ui.base.t.cg(aj.getContext(), "已关闭");
            paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
            com.tencent.mm.plugin.appbrand.app.d.Km().putBoolean("enable_pre_loading_rainbow", false);
            continue;
            paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
            com.tencent.mm.plugin.appbrand.app.d.Km().putBoolean("enable_pre_loading", false);
            continue;
            paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
            com.tencent.mm.plugin.appbrand.app.d.Km().putBoolean("enable_pre_loading", true);
            continue;
            if (paramArrayOfString.length >= 3)
            {
              paramArrayOfString = paramArrayOfString[2];
              if (i.eK(paramArrayOfString))
              {
                paramString = MD5JNI.getMD5Wrap(paramArrayOfString);
                if (!TextUtils.isEmpty(paramString))
                {
                  j.aOK().a("wx5b3f21610c440402", 1, null, paramString, 0L, 0L);
                  j.aOK().d("wx5b3f21610c440402", 1, 0, paramArrayOfString);
                  paramArrayOfString = new com.tencent.mm.plugin.appbrand.a.f();
                  paramArrayOfString.appId = "wx5b3f21610c440402";
                  paramArrayOfString.gXn = 1;
                  paramArrayOfString.scene = 1001;
                  ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramContext, paramArrayOfString);
                  continue;
                  if (paramArrayOfString.length == 3)
                  {
                    new com.tencent.mm.plugin.appbrand.appcache.b.b.h();
                    com.tencent.mm.plugin.appbrand.appcache.b.b.h.bX("", paramArrayOfString[2]);
                    continue;
                    paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
                    com.tencent.mm.plugin.appbrand.app.d.Km().putInt("pre_load_level", Integer.valueOf(paramArrayOfString[2]).intValue());
                    continue;
                    paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
                    com.tencent.mm.plugin.appbrand.app.d.Km().putBoolean("is_pre_load_downgrade_env", true);
                    continue;
                    paramContext = com.tencent.mm.plugin.appbrand.app.d.iJD;
                    com.tencent.mm.plugin.appbrand.app.d.Km().putBoolean("is_pre_load_downgrade_env", false);
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