package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.sdk.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Map;

public final class e
  implements bj.c, DebuggerShell.a
{
  private static void a(String paramString1, String paramString2, String paramString3, Runnable paramRunnable)
  {
    AppMethodBeat.i(319683);
    com.tencent.threadpool.h.ahAA.bm(new e.4(paramString1, paramString2, paramString3, paramRunnable));
    AppMethodBeat.o(319683);
  }
  
  public static String du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(319688);
    paramString1 = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString(paramString1 + "-" + paramString2, null);
    AppMethodBeat.o(319688);
    return paramString1;
  }
  
  static String n(u paramu)
  {
    AppMethodBeat.i(319685);
    try
    {
      paramu = WxaPkgWrappingInfo.n(paramu);
      AppMethodBeat.o(319685);
      return paramu;
    }
    catch (IOException paramu)
    {
      AppMethodBeat.o(319685);
    }
    return "";
  }
  
  public final void D(Intent paramIntent)
  {
    AppMethodBeat.i(44949);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(44949);
  }
  
  public final void k(final String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(319692);
    if (DebuggerShell.cls())
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
        AppMethodBeat.o(319692);
        return;
      }
      int k;
      if (!TextUtils.isEmpty(paramString))
      {
        k = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.setEnableDebug"), -1);
        if (k != 1) {
          break label215;
        }
        o.aw(paramString, true);
      }
      while (i != 0) {
        if (n.cfm() == null)
        {
          AppMethodBeat.o(319692);
          return;
          label215:
          if ((k == 0) && (!o.Xr(paramString))) {
            o.aw(paramString, false);
          }
        }
        else
        {
          if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str3))) {
            break label389;
          }
          if (i == 1)
          {
            AppMethodBeat.o(319692);
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
          if ((k.a.vK(i)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            n.cfm().a(paramString, i, str2, str3, 0L, 0L);
          }
          if ((k.a.vK(i)) && (!TextUtils.isEmpty(str4))) {
            ((com.tencent.mm.plugin.appbrand.launching.t)n.ag(com.tencent.mm.plugin.appbrand.launching.t.class)).D(paramString, i, str4);
          }
          this.rdj.appId = paramString;
          this.rdj.username = this.lzC;
          this.rdj.euz = i;
          this.rdj.qAF = str1;
          this.rdj.version = j;
          this.rdj.scene = 1030;
          ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(MMApplicationContext.getContext(), this.rdj);
          AppMethodBeat.o(44947);
        }
      }, 2);
      str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needjs");
      if (TextUtils.isEmpty(str1)) {
        ((b)localObject).asP();
      }
      for (;;)
      {
        paramMap = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needwebviewjs");
        if (!TextUtils.isEmpty(paramMap)) {
          break label446;
        }
        ((b)localObject).asP();
        AppMethodBeat.o(319692);
        return;
        label389:
        if (!n.cfm().a(paramString, i, str2, str3, Util.nowSecond(), Util.nowSecond() + 432000L)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.task.i.cJV().F(paramString, i);
        break;
        a(paramString, "Needjs", str1, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(319700);
            this.qFQ.asP();
            AppMethodBeat.o(319700);
          }
        });
      }
      label446:
      a(paramString, "Needwebviewjs", paramMap, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(319697);
          this.qFQ.asP();
          AppMethodBeat.o(319697);
        }
      });
    }
    AppMethodBeat.o(319692);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.e
 * JD-Core Version:    0.7.0.1
 */