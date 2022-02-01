package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.sdk.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.Map;

public final class e
  implements bj.c, DebuggerShell.a
{
  private static void a(String paramString1, String paramString2, String paramString3, Runnable paramRunnable)
  {
    AppMethodBeat.i(281535);
    com.tencent.e.h.ZvG.be(new e.4(paramString1, paramString2, paramString3, paramRunnable));
    AppMethodBeat.o(281535);
  }
  
  public static String dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(281537);
    paramString1 = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString(paramString1 + "-" + paramString2, null);
    AppMethodBeat.o(281537);
    return paramString1;
  }
  
  static String n(q paramq)
  {
    AppMethodBeat.i(281536);
    try
    {
      paramq = WxaPkgWrappingInfo.n(paramq);
      AppMethodBeat.o(281536);
      return paramq;
    }
    catch (IOException paramq)
    {
      AppMethodBeat.o(281536);
    }
    return "";
  }
  
  public final void B(Intent paramIntent)
  {
    AppMethodBeat.i(44949);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(44949);
  }
  
  public final void k(final String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(281534);
    if (DebuggerShell.bLS())
    {
      Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", new Object[] { paramString });
      paramString = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      Object localObject = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      final int i = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      final int j = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      final String str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      final String str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      final String str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      final String str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
      if (i < 0)
      {
        AppMethodBeat.o(281534);
        return;
      }
      int k;
      if (!TextUtils.isEmpty(paramString))
      {
        k = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.setEnableDebug"), -1);
        if (k != 1) {
          break label215;
        }
        com.tencent.mm.plugin.appbrand.config.m.ao(paramString, true);
      }
      while (i != 0) {
        if (com.tencent.mm.plugin.appbrand.app.m.bFP() == null)
        {
          AppMethodBeat.o(281534);
          return;
          label215:
          if ((k == 0) && (!com.tencent.mm.plugin.appbrand.config.m.aeP(paramString))) {
            com.tencent.mm.plugin.appbrand.config.m.ao(paramString, false);
          }
        }
        else
        {
          if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str3))) {
            break label389;
          }
          if (i == 1)
          {
            AppMethodBeat.o(281534);
            return;
          }
          if (i != 2) {
            break;
          }
        }
      }
      Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { localObject, paramString, Integer.valueOf(i) });
      localObject = new b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44947);
          if ((j.a.vB(i)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            com.tencent.mm.plugin.appbrand.app.m.bFP().a(paramString, i, str2, str3, 0L, 0L);
          }
          if ((j.a.vB(i)) && (!TextUtils.isEmpty(str4))) {
            ((s)com.tencent.mm.plugin.appbrand.app.m.W(s.class)).B(paramString, i, str4);
          }
          this.ocr.appId = paramString;
          this.ocr.username = this.iXG;
          this.ocr.cBU = i;
          this.ocr.nBq = str1;
          this.ocr.version = j;
          this.ocr.scene = 1030;
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(MMApplicationContext.getContext(), this.ocr);
          AppMethodBeat.o(44947);
        }
      }, 2);
      str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needjs");
      if (TextUtils.isEmpty(str1)) {
        ((b)localObject).Sz();
      }
      for (;;)
      {
        paramMap = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needwebviewjs");
        if (!TextUtils.isEmpty(paramMap)) {
          break label446;
        }
        ((b)localObject).Sz();
        AppMethodBeat.o(281534);
        return;
        label389:
        if (!com.tencent.mm.plugin.appbrand.app.m.bFP().a(paramString, i, str2, str3, Util.nowSecond(), Util.nowSecond() + 432000L)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.task.i.cjb().u(paramString, i);
        break;
        a(paramString, "Needjs", str1, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(272403);
            this.nFX.Sz();
            AppMethodBeat.o(272403);
          }
        });
      }
      label446:
      a(paramString, "Needwebviewjs", paramMap, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(283735);
          this.nFX.Sz();
          AppMethodBeat.o(283735);
        }
      });
    }
    AppMethodBeat.o(281534);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.e
 * JD-Core Version:    0.7.0.1
 */