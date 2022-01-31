package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

abstract class f
  implements h
{
  m hLS;
  
  static {}
  
  protected String D(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("filePath", null);
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2)) {
      localObject1 = paramJSONObject.optString("dirPath", null);
    }
    localObject2 = localObject1;
    if (bo.isNullOrNil((String)localObject1)) {
      localObject2 = paramJSONObject.optString("path", null);
    }
    return localObject2;
  }
  
  abstract h.a a(c paramc, String paramString, JSONObject paramJSONObject);
  
  public final h.a c(c paramc, JSONObject paramJSONObject)
  {
    String str = D(paramJSONObject);
    if (bo.isNullOrNil(str)) {
      return new h.a("fail invalid path", new Object[0]);
    }
    if (!paramc.isRunning()) {
      return new h.a("fail:interrupted", new Object[0]);
    }
    return a(paramc, str, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f
 * JD-Core Version:    0.7.0.1
 */