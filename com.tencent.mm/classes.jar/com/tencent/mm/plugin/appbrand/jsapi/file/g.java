package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

abstract class g
  implements i
{
  m krc;
  
  static {}
  
  protected String M(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("filePath", null);
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = paramJSONObject.optString("dirPath", null);
    }
    localObject2 = localObject1;
    if (bs.isNullOrNil((String)localObject1)) {
      localObject2 = paramJSONObject.optString("path", null);
    }
    return localObject2;
  }
  
  abstract i.a a(c paramc, String paramString, JSONObject paramJSONObject);
  
  public final i.a e(c paramc, JSONObject paramJSONObject)
  {
    String str = M(paramJSONObject);
    if (bs.isNullOrNil(str)) {
      return new i.a("fail invalid path", new Object[0]);
    }
    if ((!paramc.aUk()) && (!paramc.isRunning())) {
      return new i.a("fail:interrupted", new Object[0]);
    }
    return a(paramc, str, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g
 * JD-Core Version:    0.7.0.1
 */