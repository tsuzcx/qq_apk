package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.protocal.c.clw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class ap$d
  implements ap.c
{
  public final void q(Map<String, String> paramMap)
  {
    if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null) {
      return;
    }
    int i = bk.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
    String str1 = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
    String str2 = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
    int j = bk.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
    if ((bk.bl(str2)) || (bk.bl(str1)) || (i <= 0))
    {
      y.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str2, str1, Integer.valueOf(i) });
      return;
    }
    y.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(j) });
    paramMap = new clw();
    paramMap.version = i;
    paramMap.bIW = str1;
    paramMap.url = str2;
    paramMap.tBf = j;
    ad.a(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.d
 * JD-Core Version:    0.7.0.1
 */