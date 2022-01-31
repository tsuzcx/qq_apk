package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.ar.b;
import com.tencent.mm.plugin.appbrand.appcache.h.c;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.c.a;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

public final class b
  implements a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int i = -1;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!bl.csf()) && (!com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED)) {}
    label568:
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ("//enable_appbrand_monkey_test".equals(paramArrayOfString[0]))
            {
              DebuggerShell.aew();
              return true;
            }
            if ("//disable_appbrand_monkey_test".equals(paramArrayOfString[0]))
            {
              DebuggerShell.aex();
              return true;
            }
            if (!"//wxafts".equals(paramArrayOfString[0])) {
              break;
            }
          } while (!paramArrayOfString[1].contains("delete"));
          paramContext = c.a.haI;
          paramArrayOfString = com.tencent.mm.plugin.appbrand.q.d.haJ;
          com.tencent.mm.a.e.k(new File(com.tencent.mm.plugin.appbrand.q.d.aoA()));
          y.i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
          paramContext.prepare();
          return true;
          if ("//localwxalibrary".equals(paramArrayOfString[0]))
          {
            paramContext = ae.cqS();
            paramArrayOfString = paramArrayOfString[1];
            switch (paramArrayOfString.hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                return true;
              case 0: 
                paramContext.edit().remove("localwxalibrary").commit();
                return true;
                if (paramArrayOfString.equals("clear"))
                {
                  i = 0;
                  continue;
                  if (paramArrayOfString.equals("true"))
                  {
                    i = 1;
                    continue;
                    if (paramArrayOfString.equals("false")) {
                      i = 2;
                    }
                  }
                }
                break;
              }
            }
            paramContext.edit().putBoolean("localwxalibrary", true).commit();
            return true;
            paramContext.edit().putBoolean("localwxalibrary", false).commit();
            return true;
          }
          if ("//getsearchshowoutwxaapp".equals(paramArrayOfString[0]))
          {
            if ((paramArrayOfString.length > 1) && (paramArrayOfString[1].contains("daily")))
            {
              paramContext = x.a.fJA;
              x.adv();
              return true;
            }
            paramContext = x.a.fJB;
            x.adv();
            return true;
          }
          if ("//callsearchshowoutwxaapp".equals(paramArrayOfString[0]))
          {
            ((com.tencent.mm.plugin.appbrand.r.g)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.g.class)).adz();
            return true;
          }
          paramContext = paramArrayOfString[1].toLowerCase();
          switch (paramContext.hashCode())
          {
          default: 
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              return true;
            case 0: 
              com.tencent.mm.sdk.f.e.post(new b.1(this), "TestZipJNI");
              return true;
              if (!paramContext.equals("jnizip")) {
                break label568;
              }
              i = 0;
              continue;
              if (!paramContext.equals("javazip")) {
                break label568;
              }
              i = 1;
              continue;
              if (!paramContext.equals("deletebetalib")) {
                break label568;
              }
              i = 2;
              continue;
              if (!paramContext.equals("deletelib")) {
                break label568;
              }
              i = 3;
              continue;
              if (!paramContext.equals("pkgcleanup")) {
                break label568;
              }
              i = 4;
              continue;
              if (!paramContext.equals("deletecontact")) {
                break label568;
              }
              i = 5;
              continue;
              if (!paramContext.equals("historycount")) {
                break label568;
              }
              i = 6;
              continue;
              if (!paramContext.equals("resetsyncversion")) {
                break label568;
              }
              i = 7;
              continue;
              if (!paramContext.equals("sync")) {
                break label568;
              }
              i = 8;
              continue;
              if (!paramContext.equals("starmax")) {
                break label568;
              }
              i = 9;
              continue;
              if (!paramContext.equals("guide")) {
                break label568;
              }
              i = 10;
              continue;
              if (!paramContext.equals("clearguide")) {
                break label568;
              }
              i = 11;
              continue;
              if (!paramContext.equals("releasepkghighversion")) {
                break label568;
              }
              i = 12;
              continue;
              if (!paramContext.equals("incremental_insert_24")) {
                break label568;
              }
              i = 13;
              continue;
              if (!paramContext.equals("incremental_insert_28")) {
                break label568;
              }
              i = 14;
              continue;
              if (!paramContext.equals("incremental_delete_28")) {
                break label568;
              }
              i = 15;
              continue;
              if (!paramContext.equals("incremental_delete_latest")) {
                break label568;
              }
              i = 16;
              continue;
              if (!paramContext.equals("incremental_lib")) {
                break label568;
              }
              i = 17;
              continue;
              if (!paramContext.equals("clear_mocklib")) {
                break label568;
              }
              i = 18;
              continue;
              if (!paramContext.equals("force_modularizing")) {
                break label568;
              }
              i = 19;
              continue;
              if (!paramContext.equals("useisolatectxwxalibrary")) {
                break label568;
              }
              i = 20;
            }
          }
          com.tencent.mm.sdk.f.e.post(new b.2(this), "TestZipJava");
          return true;
          paramContext = com.tencent.mm.plugin.appbrand.app.e.abb();
          paramArrayOfString = new an();
          paramArrayOfString.field_appId = "@LibraryAppId";
          paramArrayOfString.field_debugType = 999;
          paramArrayOfString.field_version = 1;
          paramContext.fED.a(paramArrayOfString, an.fEl);
          i = ah.VERSION;
          com.tencent.mm.plugin.appbrand.task.g.mo(2);
          return true;
          com.tencent.mm.plugin.appbrand.app.e.abb().am("@LibraryAppId", 0);
          i = ah.VERSION;
          com.tencent.mm.plugin.appbrand.task.g.mo(2);
          return true;
          com.tencent.mm.sdk.f.e.post(h.c.abx(), "WxaPkgCleanupByCMD");
          return true;
          r.sz(paramArrayOfString[2]);
          return true;
          if (bk.getInt(paramArrayOfString[2].trim(), 0) > 0) {
            bool1 = true;
          }
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usO, Boolean.valueOf(bool1));
          return true;
          r.sy(paramArrayOfString[2]);
          return true;
          s.sD(paramArrayOfString[2]);
          return true;
          t.kA(Math.max(0, bk.getInt(paramArrayOfString[2], 0)));
          return true;
          com.tencent.mm.br.d.x(ae.getContext(), "appbrand", ".ui.AppBrandGuideUI");
          return true;
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usN, Boolean.valueOf(false));
          return true;
          paramContext = paramArrayOfString[2];
          try
          {
            paramArrayOfString = new WxaAttributes.d();
            paramArrayOfString.cau = 1000;
            paramArrayOfString.fRr = "fake";
            com.tencent.mm.plugin.appbrand.app.e.abb().a(paramContext, paramArrayOfString);
            return true;
          }
          catch (Exception paramContext)
          {
            return true;
          }
          paramContext = new an();
          paramContext.field_appId = "wx4ffb369b6881ee5e";
          paramContext.field_version = 24;
          paramContext.field_versionMd5 = "a47b978d23679075cbbed1030f71b7bb";
          paramContext.field_versionState = 0;
          paramContext.field_debugType = 0;
          paramContext.field_pkgPath = "/sdcard/_276854502_24.wxapkg";
          com.tencent.mm.plugin.appbrand.app.e.abb().d(paramContext);
          return true;
          paramContext = new an();
          paramContext.field_appId = "wx4ffb369b6881ee5e";
          paramContext.field_version = 28;
          paramContext.field_versionMd5 = "5713e70880cc2d356905d6189ba37a72";
          paramContext.field_versionState = 0;
          paramContext.field_debugType = 0;
          paramContext.field_pkgPath = "/sdcard/_276854502_28.wxapkg";
          com.tencent.mm.plugin.appbrand.app.e.abb().d(paramContext);
          return true;
          paramContext = new an();
          paramContext.field_appId = "wx4ffb369b6881ee5e";
          paramContext.field_version = 28;
          paramContext.field_debugType = 0;
          com.tencent.mm.plugin.appbrand.app.e.abb().a(paramContext);
          return true;
          paramContext = com.tencent.mm.plugin.appbrand.app.e.abb();
          paramArrayOfString = paramContext.a("wx4ffb369b6881ee5e", 0, new String[] { "version" });
        } while (paramArrayOfString == null);
        paramContext.a(paramArrayOfString);
        return true;
        new k(bk.getInt(paramArrayOfString[2], 78), paramArrayOfString[3]).run();
        return true;
        ah.abT();
        Toast.makeText(ae.getContext(), "MockLib已清除，重启微信生效", 1).show();
        return true;
        if (paramArrayOfString.length >= 3)
        {
          bool1 = bool2;
          if (paramArrayOfString[2].equalsIgnoreCase("false")) {}
        }
        else
        {
          bool1 = true;
        }
        com.tencent.mm.plugin.appbrand.launching.z.gLp = bool1;
        return true;
        paramContext = ae.cqS();
      } while (paramArrayOfString.length <= 2);
      if ("open".equalsIgnoreCase(paramArrayOfString[2]))
      {
        paramContext.edit().putInt("useisolatectxwxalibrary", 1).commit();
        return true;
      }
      if ("close".equalsIgnoreCase(paramArrayOfString[2]))
      {
        paramContext.edit().putInt("useisolatectxwxalibrary", -1).commit();
        return true;
      }
    } while (!"auto".equalsIgnoreCase(paramArrayOfString[2]));
    paramContext.edit().putInt("useisolatectxwxalibrary", 0).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b
 * JD-Core Version:    0.7.0.1
 */