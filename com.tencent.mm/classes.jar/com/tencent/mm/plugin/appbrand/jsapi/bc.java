package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import org.json.JSONObject;

public final class bc
{
  public static String CG()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
    return new JSONObject(localHashMap).toString();
  }
  
  public static void a(f paramf, String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (bk.bl(paramString2)) {
      str = "{}";
    }
    if (paramInt == 0) {}
    for (paramString2 = "undefined";; paramString2 = String.valueOf(paramInt))
    {
      paramf.evaluateJavascript(String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, str, paramString2, CG() }), new bc.1());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */