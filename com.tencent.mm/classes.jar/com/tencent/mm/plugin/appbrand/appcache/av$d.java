package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class av$d
  implements av.c
{
  public final void t(Map<String, String> paramMap)
  {
    AppMethodBeat.i(129435);
    if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null)
    {
      AppMethodBeat.o(129435);
      return;
    }
    int i = bo.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
    String str1 = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
    String str2 = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
    int j = bo.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
    if ((bo.isNullOrNil(str2)) || (bo.isNullOrNil(str1)) || (i <= 0))
    {
      ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str2, str1, Integer.valueOf(i) });
      AppMethodBeat.o(129435);
      return;
    }
    ab.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(j) });
    paramMap = new czn();
    paramMap.version = i;
    paramMap.cqq = str1;
    paramMap.url = str2;
    paramMap.xCO = j;
    aj.a(paramMap);
    AppMethodBeat.o(129435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av.d
 * JD-Core Version:    0.7.0.1
 */