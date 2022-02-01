package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class ck
{
  public static void a(i parami, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147149);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "{}";
    }
    ad.d("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", new Object[] { paramString1, Integer.valueOf(str.length()), Integer.valueOf(0) });
    parami.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", new Object[] { paramString1, str }), new ValueCallback() {});
    AppMethodBeat.o(147149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ck
 * JD-Core Version:    0.7.0.1
 */