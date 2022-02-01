package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bc.c;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class d
  implements bc.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44949);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((n)g.ab(n.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(44949);
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(195706);
    if (DebuggerShell.aTY())
    {
      ad.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", new Object[] { paramString });
      paramString = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      String str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      int i = bt.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      int j = bt.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      String str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      String str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      String str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      String str5 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
      if (i < 0)
      {
        AppMethodBeat.o(195706);
        return;
      }
      if (i != 0)
      {
        if (j.aOK() == null)
        {
          AppMethodBeat.o(195706);
          return;
        }
        if ((bt.isNullOrNil(str3)) || (bt.isNullOrNil(str4)))
        {
          AppMethodBeat.o(195706);
          return;
        }
        if (j.aOK().a(paramString, i, str3, str4, bt.aGK(), bt.aGK() + 432000L)) {
          f.bQ(paramString, i);
        }
      }
      ad.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { str1, paramString, Integer.valueOf(i) });
      paramMap = new uj();
      paramMap.dzH.appId = paramString;
      paramMap.dzH.userName = str1;
      paramMap.dzH.dzK = i;
      paramMap.dzH.dzJ = str2;
      paramMap.dzH.aAS = j;
      paramMap.dzH.dzL = str3;
      paramMap.dzH.dzM = str4;
      paramMap.dzH.dzN = false;
      paramMap.dzH.scene = 1030;
      paramMap.dzH.dzP.gRC = str5;
      paramMap.dzH.dzR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44947);
          AppMethodBeat.o(44947);
        }
      };
      a.ESL.l(paramMap);
    }
    AppMethodBeat.o(195706);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d
 * JD-Core Version:    0.7.0.1
 */