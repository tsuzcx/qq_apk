package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class l
  extends s
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorageSync";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("key");
    if (bk.bl(paramJSONObject)) {
      return h("fail", null);
    }
    JsApiRemoveStorageTask localJsApiRemoveStorageTask = new JsApiRemoveStorageTask();
    localJsApiRemoveStorageTask.appId = paramc.getAppId();
    localJsApiRemoveStorageTask.key = paramJSONObject;
    AppBrandMainProcessService.b(localJsApiRemoveStorageTask);
    return h("ok", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.l
 * JD-Core Version:    0.7.0.1
 */