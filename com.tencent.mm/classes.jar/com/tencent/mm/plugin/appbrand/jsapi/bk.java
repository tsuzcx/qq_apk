package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public class bk
  extends ab<d>
{
  private static final int CTRL_INDEX = 97;
  private static final String NAME = "getPublicLibVersion";
  
  protected Map<String, Object> d(d paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(147134);
    HashMap localHashMap = new HashMap();
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)paramd.av(AppBrandSysConfigLU.class);
    if (localAppBrandSysConfigLU.leE.kNW != 0)
    {
      bool1 = true;
      localHashMap.put("appDebug", Boolean.valueOf(bool1));
      localHashMap.put("appMd5", Util.nullAsNil(localAppBrandSysConfigLU.leE.md5));
      localHashMap.put("appVersion", Integer.valueOf(localAppBrandSysConfigLU.leE.pkgVersion));
      paramd = paramd.bqZ();
      if (paramd != null)
      {
        paramd = (WxaPkgWrappingInfo)paramd.bve();
        if (paramd.kNW == 0) {
          break label213;
        }
      }
    }
    label213:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localHashMap.put("libDebug", Boolean.valueOf(bool1));
      localHashMap.put("libMd5", Util.nullAsNil(paramd.md5));
      localHashMap.put("libVersion", Integer.valueOf(paramd.pkgVersion));
      localHashMap.put("system", "android");
      localHashMap.put("systemVersion", Integer.valueOf(Build.VERSION.SDK_INT));
      AppMethodBeat.o(147134);
      return localHashMap;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bk
 * JD-Core Version:    0.7.0.1
 */