package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.plugin.appbrand.appcache.av.c;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class d
  implements av.c, DebuggerShell.a
{
  public final void B(Intent paramIntent)
  {
    AppMethodBeat.i(129944);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((j)com.tencent.mm.kernel.g.E(j.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(129944);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
  
  public final void t(Map<String, String> paramMap)
  {
    AppMethodBeat.i(129943);
    if (DebuggerShell.ayQ())
    {
      String str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      String str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      int i = bo.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      int j = bo.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      String str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      String str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      String str5 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      String str6 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      String str7 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutCodeLibUrls");
      if (i < 0)
      {
        AppMethodBeat.o(129943);
        return;
      }
      if (i != 0)
      {
        if (com.tencent.mm.plugin.appbrand.app.g.auM() == null)
        {
          AppMethodBeat.o(129943);
          return;
        }
        if ((bo.isNullOrNil(str4)) || (bo.isNullOrNil(str5)))
        {
          AppMethodBeat.o(129943);
          return;
        }
        if (com.tencent.mm.plugin.appbrand.app.g.auM().a(str1, i, str4, str5, bo.aox(), bo.aox() + 432000L)) {
          h.bt(str1, i);
        }
      }
      ab.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { str2, str1, Integer.valueOf(i) });
      so localso = new so();
      localso.cIQ.appId = str1;
      localso.cIQ.userName = str2;
      localso.cIQ.cIT = i;
      localso.cIQ.cIS = str3;
      localso.cIQ.bDc = j;
      localso.cIQ.cIU = str4;
      localso.cIQ.cIV = str5;
      localso.cIQ.cIW = false;
      localso.cIQ.scene = 1030;
      localso.cIQ.cIY.fpV = str6;
      localso.cIQ.cJa = new d.1(this, str1, str7, i, paramMap);
      a.ymk.l(localso);
    }
    AppMethodBeat.o(129943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d
 * JD-Core Version:    0.7.0.1
 */