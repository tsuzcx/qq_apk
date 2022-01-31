package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public class ao
  extends u<d>
{
  private static final int CTRL_INDEX = 97;
  private static final String NAME = "getPublicLibVersion";
  
  protected Map<String, Object> b(d paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(101942);
    HashMap localHashMap = new HashMap();
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)paramd.U(AppBrandSysConfigLU.class);
    if (localAppBrandSysConfigLU.hiX.gXe != 0)
    {
      bool1 = true;
      localHashMap.put("appDebug", Boolean.valueOf(bool1));
      localHashMap.put("appMd5", bo.nullAsNil(localAppBrandSysConfigLU.hiX.cqq));
      localHashMap.put("appVersion", Integer.valueOf(localAppBrandSysConfigLU.hiX.gXf));
      paramd = paramd.asY();
      if (paramd != null)
      {
        paramd = paramd.ave();
        if (paramd.gXe == 0) {
          break label210;
        }
      }
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localHashMap.put("libDebug", Boolean.valueOf(bool1));
      localHashMap.put("libMd5", bo.nullAsNil(paramd.cqq));
      localHashMap.put("libVersion", Integer.valueOf(paramd.gXf));
      localHashMap.put("system", "android");
      localHashMap.put("systemVersion", Integer.valueOf(Build.VERSION.SDK_INT));
      AppMethodBeat.o(101942);
      return localHashMap;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */