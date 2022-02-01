package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.be.c;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class e
  implements be.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44949);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((p)g.ab(p.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(44949);
  }
  
  public final void l(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(222248);
    String str1;
    int i;
    int j;
    String str2;
    String str3;
    String str4;
    String str5;
    if (DebuggerShell.bfe())
    {
      ae.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", new Object[] { paramString });
      paramString = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      i = bu.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      j = bu.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      str5 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
      if (i < 0)
      {
        AppMethodBeat.o(222248);
        return;
      }
      if (i != 0)
      {
        if (j.aZu() == null)
        {
          AppMethodBeat.o(222248);
          return;
        }
        if ((!bu.isNullOrNil(str3)) && (!bu.isNullOrNil(str4))) {
          break label367;
        }
        if (i == 1)
        {
          AppMethodBeat.o(222248);
          return;
        }
        if (i != 2) {}
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { str1, paramString, Integer.valueOf(i) });
      paramMap = new vq();
      paramMap.dKT.appId = paramString;
      paramMap.dKT.userName = str1;
      paramMap.dKT.dKW = i;
      paramMap.dKT.dKV = str2;
      paramMap.dKT.aDD = j;
      paramMap.dKT.dKY = str3;
      paramMap.dKT.dKZ = str4;
      paramMap.dKT.dLa = false;
      paramMap.dKT.scene = 1030;
      paramMap.dKT.dLc.hNn = str5;
      paramMap.dKT.dLe = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44947);
          AppMethodBeat.o(44947);
        }
      };
      a.IvT.l(paramMap);
      AppMethodBeat.o(222248);
      return;
      label367:
      if (j.aZu().a(paramString, i, str3, str4, bu.aRi(), bu.aRi() + 432000L)) {
        f.cc(paramString, i);
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