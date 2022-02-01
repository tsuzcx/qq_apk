package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bc.c;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    AppMethodBeat.i(186427);
    if (DebuggerShell.baW())
    {
      ac.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", new Object[] { paramString });
      paramString = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      String str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      int i = bs.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      int j = bs.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      String str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      String str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      String str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      String str5 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
      if (i < 0)
      {
        AppMethodBeat.o(186427);
        return;
      }
      if (i != 0)
      {
        if (j.aVC() == null)
        {
          AppMethodBeat.o(186427);
          return;
        }
        if ((bs.isNullOrNil(str3)) || (bs.isNullOrNil(str4)))
        {
          AppMethodBeat.o(186427);
          return;
        }
        if (j.aVC().a(paramString, i, str3, str4, bs.aNx(), bs.aNx() + 432000L)) {
          f.bV(paramString, i);
        }
      }
      ac.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { str1, paramString, Integer.valueOf(i) });
      paramMap = new ut();
      paramMap.dxt.appId = paramString;
      paramMap.dxt.userName = str1;
      paramMap.dxt.dxw = i;
      paramMap.dxt.dxv = str2;
      paramMap.dxt.aBM = j;
      paramMap.dxt.dxx = str3;
      paramMap.dxt.dxy = str4;
      paramMap.dxt.dxz = false;
      paramMap.dxt.scene = 1030;
      paramMap.dxt.dxB.hsc = str5;
      paramMap.dxt.dxD = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44947);
          AppMethodBeat.o(44947);
        }
      };
      a.GpY.l(paramMap);
    }
    AppMethodBeat.o(186427);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d
 * JD-Core Version:    0.7.0.1
 */