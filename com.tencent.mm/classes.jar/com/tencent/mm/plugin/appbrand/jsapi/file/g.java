package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

abstract class g
  implements i
{
  com.tencent.mm.plugin.appbrand.jsapi.o oRL;
  
  static {}
  
  protected String Z(JSONObject paramJSONObject)
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
  
  public final i.a a(e parame, com.tencent.mm.plugin.appbrand.m.o paramo, JSONObject paramJSONObject)
  {
    String str = Z(paramJSONObject);
    if (Util.isNullOrNil(str)) {
      return new i.a("fail invalid path", new Object[0]);
    }
    if (!parame.a(this.oRL.getName(), paramo)) {
      return new i.a("fail:interrupted", new Object[0]);
    }
    return a(parame, str, paramJSONObject);
  }
  
  abstract i.a a(e parame, String paramString, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g
 * JD-Core Version:    0.7.0.1
 */