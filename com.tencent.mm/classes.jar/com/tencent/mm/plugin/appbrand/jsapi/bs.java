package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class bs
{
  public static String Qy()
  {
    AppMethodBeat.i(91042);
    try
    {
      String str = new JSONObject().put("nativeTime", System.currentTimeMillis()).toString();
      AppMethodBeat.o(91042);
      return str;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", new Object[] { localException });
      AppMethodBeat.o(91042);
    }
    return "{}";
  }
  
  public static void a(i parami, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(91041);
    parami.evaluateJavascript(r(paramString1, paramString2, paramInt), new bs.1());
    AppMethodBeat.o(91041);
  }
  
  public static String r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141793);
    String str = paramString2;
    if (bo.isNullOrNil(paramString2)) {
      str = "{}";
    }
    if (paramInt == 0) {}
    for (paramString2 = "undefined";; paramString2 = String.valueOf(paramInt))
    {
      paramString1 = String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)", new Object[] { paramString1, str, paramString2, Qy() });
      AppMethodBeat.o(141793);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bs
 * JD-Core Version:    0.7.0.1
 */