package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ap.c;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class c
  implements ap.c, DebuggerShell.a
{
  public final void l(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((d)com.tencent.mm.kernel.g.r(d.class)).a(null, null, str, i, 0, null, paramIntent);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
  
  public final void q(Map<String, String> paramMap)
  {
    String str1;
    String str2;
    int i;
    int j;
    String str3;
    String str4;
    if (DebuggerShell.aeu())
    {
      str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      i = bk.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      j = bk.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      paramMap = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      if (i >= 0) {
        break label107;
      }
    }
    label107:
    do
    {
      return;
      if (i == 0) {
        break;
      }
    } while ((e.abb() == null) || (bk.bl(str4)) || (bk.bl(paramMap)));
    if (e.abb().a(str1, i, str4, paramMap, bk.UX(), bk.UX() + 432000L)) {
      com.tencent.mm.plugin.appbrand.task.g.aZ(str1, i);
    }
    y.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp");
    rc localrc = new rc();
    localrc.caq.appId = str1;
    localrc.caq.userName = str2;
    localrc.caq.cat = i;
    localrc.caq.cas = str3;
    localrc.caq.cau = j;
    localrc.caq.cav = str4;
    localrc.caq.caw = paramMap;
    localrc.caq.cax = false;
    localrc.caq.scene = 1030;
    a.udP.m(localrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.c
 * JD-Core Version:    0.7.0.1
 */