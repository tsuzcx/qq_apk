package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class ap$b
  implements ap.c
{
  private boolean g(String paramString, Map<String, String> paramMap)
  {
    y.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[] { paramString });
    if (paramMap.get(paramString) == null) {
      return false;
    }
    String str1 = (String)paramMap.get(paramString + ".AppID");
    String str2 = (String)paramMap.get(paramString + ".UserName");
    int i = bk.getInt((String)paramMap.get(paramString + ".Type"), 1);
    String str3 = (String)paramMap.get(paramString + ".URL");
    long l1 = bk.getLong((String)paramMap.get(paramString + ".StartTime"), bk.UX());
    long l2 = bk.getLong((String)paramMap.get(paramString + ".EndTime"), 7200L + l1);
    paramString = (String)paramMap.get(paramString + ".MD5");
    boolean bool = e.abb().a(str1, i, str3, paramString, l1, l2);
    y.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      if (999 == i) {
        break label389;
      }
      s.sD(str2);
      ai.d(new ap.b.1(this, str1, i, r.sw(str1)));
    }
    for (;;)
    {
      e.aaZ().a(str2, i, false, false, 0, 0, null);
      return true;
      label389:
      n.fCD.cF(false);
    }
  }
  
  public final void q(Map<String, String> paramMap)
  {
    g(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
    int i = 0;
    int j;
    do
    {
      j = i + 1;
      i = j;
    } while (g(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo" + j, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.b
 * JD-Core Version:    0.7.0.1
 */