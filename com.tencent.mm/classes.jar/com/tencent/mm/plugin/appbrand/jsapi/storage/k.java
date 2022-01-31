package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public class k
  extends a
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("key");
    if (bk.bl(paramJSONObject))
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    JsApiRemoveStorageTask localJsApiRemoveStorageTask = new JsApiRemoveStorageTask();
    localJsApiRemoveStorageTask.appId = o(paramc);
    localJsApiRemoveStorageTask.key = paramJSONObject;
    AppBrandMainProcessService.a(localJsApiRemoveStorageTask);
    paramc.C(paramInt, h("ok", null));
  }
  
  protected String o(c paramc)
  {
    return paramc.getAppId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.k
 * JD-Core Version:    0.7.0.1
 */