package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class bc$d
  implements bc.c
{
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(195622);
    if (paramMap.get(".sysmsg.AppPublicLibraryNotify") == null)
    {
      AppMethodBeat.o(195622);
      return;
    }
    int i = bt.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
    paramString = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.MD5");
    String str = (String)paramMap.get(".sysmsg.AppPublicLibraryNotify.URL");
    int j = bt.getInt((String)paramMap.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
    if ((bt.isNullOrNil(str)) || (bt.isNullOrNil(paramString)) || (i <= 0))
    {
      ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[] { str, paramString, Integer.valueOf(i) });
      AppMethodBeat.o(195622);
      return;
    }
    ad.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[] { Integer.valueOf(i), paramString, str, Integer.valueOf(j) });
    paramMap = new dud();
    paramMap.version = i;
    paramMap.md5 = paramString;
    paramMap.url = str;
    paramMap.DZz = j;
    as.a(paramMap);
    AppMethodBeat.o(195622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc.d
 * JD-Core Version:    0.7.0.1
 */