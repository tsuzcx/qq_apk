package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class av$b
  implements av.c
{
  private boolean i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(129434);
    ab.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[] { paramString });
    if (paramMap.get(paramString) == null)
    {
      AppMethodBeat.o(129434);
      return false;
    }
    String str1 = (String)paramMap.get(paramString + ".AppID");
    String str2 = (String)paramMap.get(paramString + ".UserName");
    int i = bo.getInt((String)paramMap.get(paramString + ".Type"), 1);
    String str3 = (String)paramMap.get(paramString + ".URL");
    long l1 = bo.getLong((String)paramMap.get(paramString + ".StartTime"), bo.aox());
    long l2 = bo.getLong((String)paramMap.get(paramString + ".EndTime"), 7200L + l1);
    paramString = (String)paramMap.get(paramString + ".MD5");
    boolean bool = g.auM().a(str1, i, str3, paramString, l1, l2);
    ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[] { str1, str2, Integer.valueOf(i), str3, Long.valueOf(l1), Long.valueOf(l2), paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      if (999 == i) {
        break label398;
      }
      s.Ax(str2);
      al.d(new av.b.1(this, str1, i, q.Ar(str1)));
    }
    for (;;)
    {
      g.auK().aL(str2, i);
      AppMethodBeat.o(129434);
      return true;
      label398:
      t.gUT.dF(false);
    }
  }
  
  public final void t(Map<String, String> paramMap)
  {
    AppMethodBeat.i(129433);
    i(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", paramMap);
    int i = 0;
    int j;
    do
    {
      j = i + 1;
      i = j;
    } while (i(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(j)), paramMap));
    AppMethodBeat.o(129433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av.b
 * JD-Core Version:    0.7.0.1
 */