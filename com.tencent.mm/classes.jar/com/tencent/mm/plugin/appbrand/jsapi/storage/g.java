package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends a
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfo";
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    paramJSONObject = new JsApiGetStorageInfoTask();
    paramJSONObject.appId = o(paramc);
    paramJSONObject.gfD = new Runnable()
    {
      public final void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("keys", paramJSONObject.gCb);
        localHashMap.put("currentSize", Integer.valueOf(paramJSONObject.size));
        localHashMap.put("limitSize", Integer.valueOf(paramJSONObject.limit));
        paramc.C(paramInt, g.this.h("ok", localHashMap));
      }
    };
    paramJSONObject.ahC();
    AppBrandMainProcessService.a(paramJSONObject);
  }
  
  protected String o(c paramc)
  {
    return paramc.getAppId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.g
 * JD-Core Version:    0.7.0.1
 */