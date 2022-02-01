package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

abstract class g
  implements i
{
  p rXl;
  
  static {}
  
  public final i.a a(f paramf, o paramo, JSONObject paramJSONObject)
  {
    String str = aj(paramJSONObject);
    if (Util.isNullOrNil(str)) {
      return new i.a("fail invalid path", new Object[0]);
    }
    if (!paramf.a(this.rXl.getName(), paramo)) {
      return new i.a("fail:interrupted", new Object[0]);
    }
    return a(paramf, str, paramJSONObject);
  }
  
  abstract i.a a(f paramf, String paramString, JSONObject paramJSONObject);
  
  protected String aj(JSONObject paramJSONObject)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g
 * JD-Core Version:    0.7.0.1
 */