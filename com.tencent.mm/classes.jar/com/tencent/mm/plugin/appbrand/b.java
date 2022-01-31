package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.ay.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.c.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 2;
    boolean bool1 = false;
    boolean bool2 = false;
    int k = 0;
    AppMethodBeat.i(128927);
    if ((bp.dud()) || (f.IS_FLAVOR_RED) || (f.IS_FLAVOR_PURPLE)) {}
    for (int j = 1; j == 0; j = 0)
    {
      AppMethodBeat.o(128927);
      return true;
    }
    if ("//enable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.ayS();
      AppMethodBeat.o(128927);
      return true;
    }
    if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
    {
      DebuggerShell.ayT();
      AppMethodBeat.o(128927);
      return true;
    }
    if ("//appbrand_predownload_trigger".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString.length > 1) {}
      for (paramContext = paramArrayOfString[1].trim();; paramContext = "")
      {
        ((m)com.tencent.mm.kernel.g.E(m.class)).yN(paramContext);
        AppMethodBeat.o(128927);
        return true;
      }
    }
    if ("//wxafts".equals(paramArrayOfString[0]))
    {
      if (paramArrayOfString[1].contains("delete"))
      {
        paramContext = c.a.iJk;
        paramArrayOfString = com.tencent.mm.plugin.appbrand.p.d.iJl;
        com.tencent.mm.a.e.o(new File(com.tencent.mm.plugin.appbrand.p.d.aLw()));
        ab.i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
        paramContext.prepare();
      }
      AppMethodBeat.o(128927);
      return true;
    }
    if ("//xweb_live".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        i = -1;
        label267:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(128927);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break label267;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break label267;
        if (!paramContext.equals("false")) {
          break;
        }
        break label267;
        com.tencent.mm.plugin.appbrand.w.b.aSz();
        continue;
        com.tencent.mm.plugin.appbrand.w.b.rb(1);
        continue;
        com.tencent.mm.plugin.appbrand.w.b.rb(0);
      }
    }
    if ("//xweb_video_preload".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        i = -1;
        label423:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(128927);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break label423;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break label423;
        if (!paramContext.equals("false")) {
          break;
        }
        break label423;
        as.apq("xweb_abtest_command").removeValueForKey("xweb_video_preload_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.w.a.a.rc(1);
        continue;
        com.tencent.mm.plugin.appbrand.w.a.a.rc(0);
      }
    }
    if ("//xweb_video_player".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        i = -1;
        label583:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(128927);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break label583;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break label583;
        if (!paramContext.equals("false")) {
          break;
        }
        break label583;
        as.apq("xweb_abtest_command").removeValueForKey("xweb_video_player_command_value");
        continue;
        com.tencent.mm.plugin.appbrand.w.a.a.rd(1);
        continue;
        com.tencent.mm.plugin.appbrand.w.a.a.rd(0);
      }
    }
    if ("//xweb_video".equals(paramArrayOfString[0]))
    {
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        i = -1;
        label743:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(128927);
        return true;
        if (!paramContext.equals("clear")) {
          break;
        }
        i = 0;
        break label743;
        if (!paramContext.equals("true")) {
          break;
        }
        i = 1;
        break label743;
        if (!paramContext.equals("false")) {
          break;
        }
        break label743;
        com.tencent.mm.plugin.appbrand.w.b.aSu();
        continue;
        com.tencent.mm.plugin.appbrand.w.b.ra(1);
        continue;
        com.tencent.mm.plugin.appbrand.w.b.ra(0);
      }
    }
    if ("//localwxalibrary".equals(paramArrayOfString[0]))
    {
      paramContext = as.apq("__appbrand_comm_lib__prefs");
      paramArrayOfString = paramArrayOfString[1];
      switch (paramArrayOfString.hashCode())
      {
      default: 
        i = -1;
        label903:
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(128927);
        return true;
        if (!paramArrayOfString.equals("clear")) {
          break;
        }
        i = 0;
        break label903;
        if (!paramArrayOfString.equals("true")) {
          break;
        }
        i = 1;
        break label903;
        if (!paramArrayOfString.equals("false")) {
          break;
        }
        break label903;
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
        paramContext = x.a.hct;
        x.axC();
      }
      for (;;)
      {
        AppMethodBeat.o(128927);
        return true;
        paramContext = x.a.hcu;
        x.axC();
      }
    }
    if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
    {
      ((n)com.tencent.mm.kernel.g.E(n.class)).axG();
      AppMethodBeat.o(128927);
      return true;
    }
    if ("//wagame".equals(paramArrayOfString[0]))
    {
      com.tencent.mm.plugin.appbrand.game.a.g.a(paramContext, paramArrayOfString);
      AppMethodBeat.o(128927);
      return true;
    }
    paramContext = paramArrayOfString[1].toLowerCase();
    i = -1;
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
      AppMethodBeat.o(128927);
      return true;
      if (!paramContext.equals("jnizip")) {
        break;
      }
      i = 0;
      break;
      if (!paramContext.equals("javazip")) {
        break;
      }
      i = 1;
      break;
      if (!paramContext.equals("deletebetalib")) {
        break;
      }
      i = 2;
      break;
      if (!paramContext.equals("deletelib")) {
        break;
      }
      i = 3;
      break;
      if (!paramContext.equals("deletepkg")) {
        break;
      }
      i = 4;
      break;
      if (!paramContext.equals("pkgcleanup")) {
        break;
      }
      i = 5;
      break;
      if (!paramContext.equals("deletecontact")) {
        break;
      }
      i = 6;
      break;
      if (!paramContext.equals("historycount")) {
        break;
      }
      i = 7;
      break;
      if (!paramContext.equals("resetsyncversion")) {
        break;
      }
      i = 8;
      break;
      if (!paramContext.equals("sync")) {
        break;
      }
      i = 9;
      break;
      if (!paramContext.equals("starmax")) {
        break;
      }
      i = 10;
      break;
      if (!paramContext.equals("guide")) {
        break;
      }
      i = 11;
      break;
      if (!paramContext.equals("clearguide")) {
        break;
      }
      i = 12;
      break;
      if (!paramContext.equals("releasepkghighversion")) {
        break;
      }
      i = 13;
      break;
      if (!paramContext.equals("incremental_insert_24")) {
        break;
      }
      i = 14;
      break;
      if (!paramContext.equals("incremental_insert_28")) {
        break;
      }
      i = 15;
      break;
      if (!paramContext.equals("incremental_delete_28")) {
        break;
      }
      i = 16;
      break;
      if (!paramContext.equals("incremental_delete_latest")) {
        break;
      }
      i = 17;
      break;
      if (!paramContext.equals("incremental_lib")) {
        break;
      }
      i = 18;
      break;
      if (!paramContext.equals("clear_mocklib")) {
        break;
      }
      i = 19;
      break;
      if (!paramContext.equals("force_modularizing")) {
        break;
      }
      i = 20;
      break;
      if (!paramContext.equals("disable_develop_lib")) {
        break;
      }
      i = 21;
      break;
      if (!paramContext.equals("disable_preload")) {
        break;
      }
      i = 22;
      break;
      com.tencent.mm.sdk.g.d.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128925);
          long l = bo.aoy();
          ab.i("[ZIP]", "unzip JNI %d, cost %d", new Object[] { Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(bo.aoy() - l) });
          AppMethodBeat.o(128925);
        }
      }, "TestZipJNI");
      continue;
      com.tencent.mm.sdk.g.d.post(new b.2(this), "TestZipJava");
      continue;
      paramContext = com.tencent.mm.plugin.appbrand.app.g.auM();
      paramArrayOfString = new at();
      paramArrayOfString.field_appId = "@LibraryAppId";
      paramArrayOfString.field_debugType = 999;
      paramArrayOfString.field_version = 1;
      paramContext.gWV.delete(paramArrayOfString, at.gWB);
      i = an.VERSION;
      h.pA(2);
      continue;
      com.tencent.mm.plugin.appbrand.app.g.auM().ay("@LibraryAppId", 0);
      i = an.VERSION;
      h.pA(2);
      continue;
      if (paramArrayOfString.length > 2) {}
      for (paramContext = paramArrayOfString[2].trim();; paramContext = null)
      {
        i = k;
        if (paramArrayOfString.length > 3) {
          i = bo.getInt(paramArrayOfString[3].trim(), 0);
        }
        if (TextUtils.isEmpty(paramContext)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.app.g.auM().ay(paramContext, i);
        break;
      }
      com.tencent.mm.sdk.g.d.post(n.c.avp(), "WxaPkgCleanupByCMD");
      continue;
      com.tencent.mm.plugin.appbrand.config.q.Au(paramArrayOfString[2]);
      continue;
      if (bo.getInt(paramArrayOfString[2].trim(), 0) > 0) {
        bool1 = true;
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCO, Boolean.valueOf(bool1));
      continue;
      com.tencent.mm.plugin.appbrand.config.q.At(paramArrayOfString[2]);
      continue;
      s.Ax(paramArrayOfString[2]);
      continue;
      t.nw(Math.max(0, bo.getInt(paramArrayOfString[2], 0)));
      continue;
      com.tencent.mm.bq.d.H(ah.getContext(), "appbrand", ".ui.AppBrandGuideUI");
      continue;
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yCN, Boolean.FALSE);
      continue;
      paramContext = paramArrayOfString[2];
      try
      {
        paramArrayOfString = new WxaAttributes.WxaVersionInfo();
        paramArrayOfString.bDc = 1000;
        paramArrayOfString.hkd = "fake";
        com.tencent.mm.plugin.appbrand.app.g.auM().a(paramContext, paramArrayOfString);
      }
      catch (Exception paramContext) {}
      continue;
      paramContext = new at();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 24;
      paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
      paramContext.field_versionState = 0;
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
      com.tencent.mm.plugin.appbrand.app.g.auM().d(paramContext);
      continue;
      paramContext = new at();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
      paramContext.field_versionState = 0;
      paramContext.field_debugType = 0;
      paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
      com.tencent.mm.plugin.appbrand.app.g.auM().d(paramContext);
      continue;
      paramContext = new at();
      paramContext.field_appId = "wx4ffb369b6881ee5e";
      paramContext.field_version = 28;
      paramContext.field_debugType = 0;
      com.tencent.mm.plugin.appbrand.app.g.auM().a(paramContext);
      continue;
      paramContext = com.tencent.mm.plugin.appbrand.app.g.auM();
      paramArrayOfString = paramContext.a("wx4ffb369b6881ee5e", 0, new String[] { "version" });
      if (paramArrayOfString != null)
      {
        paramContext.a(paramArrayOfString);
        continue;
        new com.tencent.mm.plugin.appbrand.appcache.q(bo.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
        continue;
        an.avK();
        Toast.makeText(ah.getContext(), "MockLib已清除，重启微信生效", 1).show();
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
        com.tencent.mm.plugin.appbrand.launching.aj.imI = bool1;
        continue;
        if (paramArrayOfString.length >= 3)
        {
          an.dK(paramArrayOfString[2].trim().contentEquals("1"));
          continue;
          if (paramArrayOfString.length >= 3) {
            com.tencent.mm.plugin.appbrand.task.a.a.eN(paramArrayOfString[2].trim().contentEquals("1"));
          } else {
            com.tencent.mm.plugin.appbrand.task.a.a.eN(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b
 * JD-Core Version:    0.7.0.1
 */