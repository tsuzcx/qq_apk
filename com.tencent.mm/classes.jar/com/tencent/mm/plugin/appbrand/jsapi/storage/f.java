package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    long l = System.currentTimeMillis();
    paramJSONObject = paramJSONObject.optString("key");
    if (bk.bl(paramJSONObject))
    {
      paramc.C(paramInt, h("fail:key is empty", null));
      return;
    }
    String str = o(paramc);
    if (bk.bl(str))
    {
      paramc.C(paramInt, h("fail:appID is empty", null));
      return;
    }
    JsApiGetStorageTask localJsApiGetStorageTask = new JsApiGetStorageTask();
    localJsApiGetStorageTask.appId = str;
    localJsApiGetStorageTask.key = paramJSONObject;
    localJsApiGetStorageTask.gfD = new f.1(this, localJsApiGetStorageTask, paramc, paramInt, l);
    localJsApiGetStorageTask.ahC();
    AppBrandMainProcessService.a(localJsApiGetStorageTask);
  }
  
  protected String o(c paramc)
  {
    return paramc.getAppId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f
 * JD-Core Version:    0.7.0.1
 */