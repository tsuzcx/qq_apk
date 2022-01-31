package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class o
  extends s<p>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorageSync";
  
  private String a(p paramp, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("key");
    String str2 = paramJSONObject.optString("data");
    String str3 = paramJSONObject.optString("dataType");
    if (bk.bl(str1)) {
      return h("fail:key is empty", null);
    }
    if (bk.bl(paramp.mAppId)) {
      return h("fail:appID is empty", null);
    }
    int j = paramp.getRuntime().aaa().fQq.fOE;
    int k = str1.length();
    if (str2 == null) {}
    for (int i = 0; i + k > j; i = str2.length()) {
      return h("fail:entry size limit reached", null);
    }
    paramJSONObject = "fail";
    JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
    localJsApiSetStorageTask.appId = paramp.mAppId;
    localJsApiSetStorageTask.B(str1, str2, str3);
    paramp = paramJSONObject;
    if (AppBrandMainProcessService.b(localJsApiSetStorageTask)) {
      paramp = localJsApiSetStorageTask.result;
    }
    return h(paramp, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.o
 * JD-Core Version:    0.7.0.1
 */