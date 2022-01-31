package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

abstract class d
  implements f
{
  i gqG;
  
  static {}
  
  abstract f.a a(c paramc, String paramString, JSONObject paramJSONObject);
  
  public final f.a b(c paramc, JSONObject paramJSONObject)
  {
    String str = v(paramJSONObject);
    if (bk.bl(str)) {
      return new f.a("fail invalid path", new Object[0]);
    }
    if (!paramc.isRunning()) {
      return new f.a("fail:interrupted", new Object[0]);
    }
    return a(paramc, str, paramJSONObject);
  }
  
  protected String v(JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("filePath", null);
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = paramJSONObject.optString("dirPath", null);
    }
    localObject2 = localObject1;
    if (bk.bl((String)localObject1)) {
      localObject2 = paramJSONObject.optString("path", null);
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.d
 * JD-Core Version:    0.7.0.1
 */