package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.protocal.c.cdl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

final class ap$a
  implements ap.c
{
  public final void q(Map<String, String> paramMap)
  {
    if (paramMap.get(".sysmsg.mmbizwxaconfig") == null) {
      return;
    }
    int i = bk.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.command"), -1);
    int j = bk.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.type"), 0);
    String str = (String)paramMap.get(".sysmsg.mmbizwxaconfig.appid");
    int k = bk.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
    y.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), str, Integer.valueOf(k) });
    paramMap = new LinkedList();
    cdl localcdl = new cdl();
    localcdl.version = k;
    localcdl.type = j;
    paramMap.add(localcdl);
    n.a(str, paramMap, false);
    n.a(str, j, i, new ap.a.1(this, str, j), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.a
 * JD-Core Version:    0.7.0.1
 */