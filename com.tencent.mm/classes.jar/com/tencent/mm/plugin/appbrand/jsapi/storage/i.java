package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends s
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorageSync";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("key");
    if (bk.bl(paramJSONObject)) {
      return h("fail:key is empty", null);
    }
    paramc = paramc.getAppId();
    if (bk.bl(paramc)) {
      return h("fail:appID is empty", null);
    }
    JsApiGetStorageTask localJsApiGetStorageTask = new JsApiGetStorageTask();
    localJsApiGetStorageTask.appId = paramc;
    localJsApiGetStorageTask.key = paramJSONObject;
    AppBrandMainProcessService.b(localJsApiGetStorageTask);
    HashMap localHashMap;
    if (localJsApiGetStorageTask.value == null)
    {
      paramc = "fail:data not found";
      localHashMap = new HashMap();
      if (localJsApiGetStorageTask.value != null) {
        break label142;
      }
      paramJSONObject = "";
      label96:
      localHashMap.put("data", paramJSONObject);
      if (localJsApiGetStorageTask.type != null) {
        break label150;
      }
    }
    label142:
    label150:
    for (paramJSONObject = "";; paramJSONObject = localJsApiGetStorageTask.type)
    {
      localHashMap.put("dataType", paramJSONObject);
      return h(paramc, localHashMap);
      paramc = "ok";
      break;
      paramJSONObject = localJsApiGetStorageTask.value;
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.i
 * JD-Core Version:    0.7.0.1
 */