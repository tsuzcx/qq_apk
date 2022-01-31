package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends s
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfoSync";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = new JsApiGetStorageInfoTask();
    paramJSONObject.appId = paramc.getAppId();
    AppBrandMainProcessService.b(paramJSONObject);
    paramc = new HashMap();
    paramc.put("keys", paramJSONObject.gCb);
    paramc.put("currentSize", Integer.valueOf(paramJSONObject.size));
    paramc.put("limitSize", Integer.valueOf(paramJSONObject.limit));
    return h("ok", paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.h
 * JD-Core Version:    0.7.0.1
 */