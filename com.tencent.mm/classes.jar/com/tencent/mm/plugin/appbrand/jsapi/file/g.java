package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

abstract class g
  implements i
{
  p lUM;
  
  static {}
  
  protected String V(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("filePath", null);
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = paramJSONObject.optString("dirPath", null);
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = paramJSONObject.optString("path", null);
    }
    return localObject2;
  }
  
  abstract i.a a(f paramf, String paramString, JSONObject paramJSONObject);
  
  public final i.a e(f paramf, JSONObject paramJSONObject)
  {
    String str = V(paramJSONObject);
    if (Util.isNullOrNil(str)) {
      return new i.a("fail invalid path", new Object[0]);
    }
    if ((!paramf.bsV()) && (!paramf.isRunning())) {
      return new i.a("fail:interrupted", new Object[0]);
    }
    return a(paramf, str, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g
 * JD-Core Version:    0.7.0.1
 */