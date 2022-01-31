package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public class n
  extends a
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("key");
    String str2 = paramJSONObject.optString("data");
    paramJSONObject = paramJSONObject.optString("dataType");
    if (bk.bl(str1))
    {
      paramc.C(paramInt, h("fail:key is empty", null));
      return;
    }
    String str3 = o(paramc);
    if (bk.bl(str3))
    {
      paramc.C(paramInt, h("fail:appID is empty", null));
      return;
    }
    int i;
    int k;
    if (!(paramc instanceof p))
    {
      i = 1048576;
      k = str1.length();
      if (str2 != null) {
        break label148;
      }
    }
    label148:
    for (int j = 0;; j = str2.length())
    {
      if (j + k <= i) {
        break label158;
      }
      paramc.C(paramInt, h("fail:entry size limit reached", null));
      return;
      i = ((p)paramc).getRuntime().aaa().fQq.fOE;
      break;
    }
    label158:
    JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
    localJsApiSetStorageTask.appId = str3;
    localJsApiSetStorageTask.B(str1, str2, paramJSONObject);
    localJsApiSetStorageTask.gfD = new n.1(this, paramc, paramInt, localJsApiSetStorageTask);
    localJsApiSetStorageTask.ahC();
    AppBrandMainProcessService.a(localJsApiSetStorageTask);
  }
  
  protected String o(c paramc)
  {
    return paramc.getAppId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n
 * JD-Core Version:    0.7.0.1
 */