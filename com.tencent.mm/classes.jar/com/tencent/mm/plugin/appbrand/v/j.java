package com.tencent.mm.plugin.appbrand.v;

import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public static void b(f paramf, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (bk.bl(paramString2)) {
      str = "{}";
    }
    y.d("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(0) });
    paramf.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", new Object[] { paramString1, str }), new j.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.j
 * JD-Core Version:    0.7.0.1
 */