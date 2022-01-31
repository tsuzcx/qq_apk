package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import org.json.JSONObject;

public final class b
  extends s
{
  public static final int CTRL_INDEX = 18;
  public static final String NAME = "clearStorageSync";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = new JsApiClearStorageTask();
    paramJSONObject.appId = paramc.getAppId();
    AppBrandMainProcessService.b(paramJSONObject);
    return h("ok", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.b
 * JD-Core Version:    0.7.0.1
 */