package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bd.c;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class e
  implements bd.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44949);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((o)g.ab(o.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(44949);
  }
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188123);
    String str1;
    int i;
    int j;
    String str2;
    String str3;
    String str4;
    String str5;
    if (DebuggerShell.bew())
    {
      ad.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", new Object[] { paramString });
      paramString = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      i = bt.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      j = bt.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      str5 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
      if (i < 0)
      {
        AppMethodBeat.o(188123);
        return;
      }
      if (i != 0)
      {
        if (j.aYX() == null)
        {
          AppMethodBeat.o(188123);
          return;
        }
        if ((!bt.isNullOrNil(str3)) && (!bt.isNullOrNil(str4))) {
          break label367;
        }
        if (i == 1)
        {
          AppMethodBeat.o(188123);
          return;
        }
        if (i != 2) {}
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { str1, paramString, Integer.valueOf(i) });
      paramMap = new vm();
      paramMap.dJF.appId = paramString;
      paramMap.dJF.userName = str1;
      paramMap.dJF.dJI = i;
      paramMap.dJF.dJH = str2;
      paramMap.dJF.aDD = j;
      paramMap.dJF.dJJ = str3;
      paramMap.dJF.dJK = str4;
      paramMap.dJF.dJL = false;
      paramMap.dJF.scene = 1030;
      paramMap.dJF.dJN.hKu = str5;
      paramMap.dJF.dJP = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44947);
          AppMethodBeat.o(44947);
        }
      };
      a.IbL.l(paramMap);
      AppMethodBeat.o(188123);
      return;
      label367:
      if (j.aYX().a(paramString, i, str3, str4, bt.aQJ(), bt.aQJ() + 432000L)) {
        f.bY(paramString, i);
      }
    }
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