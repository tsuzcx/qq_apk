package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ag
  extends s
{
  private static final int CTRL_INDEX = 97;
  private static final String NAME = "getPublicLibVersion";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    paramJSONObject = (com.tencent.mm.plugin.appbrand.config.i)paramc.D(com.tencent.mm.plugin.appbrand.config.i.class);
    if (paramJSONObject == null) {
      return h("fail", null);
    }
    paramc = new HashMap();
    if (paramJSONObject.fPS.fEM != 0)
    {
      bool1 = true;
      paramc.put("appDebug", Boolean.valueOf(bool1));
      paramc.put("appMd5", bk.pm(paramJSONObject.fPS.bIW));
      paramc.put("appVersion", Integer.valueOf(paramJSONObject.fPS.fEN));
      paramJSONObject = WxaCommLibRuntimeReader.abQ();
      if (paramJSONObject.fEM == 0) {
        break label229;
      }
    }
    label229:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramc.put("libDebug", Boolean.valueOf(bool1));
      paramc.put("libMd5", bk.pm(paramJSONObject.bIW));
      paramc.put("libVersion", Integer.valueOf(paramJSONObject.fEN));
      paramc.put("clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.spa));
      paramc.put("system", "android");
      paramc.put("systemVersion", Integer.valueOf(Build.VERSION.SDK_INT));
      paramc.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ae.getContext())));
      return h("ok", paramc);
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */