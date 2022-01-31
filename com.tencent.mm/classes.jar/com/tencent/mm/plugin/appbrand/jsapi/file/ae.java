package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae
  extends a
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(c paramc, File paramFile, String paramString, com.tencent.mm.plugin.appbrand.u.k<String> paramk)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return "fail:file not exists";
    }
    Object localObject2 = paramc.Zl().rv(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != h.fGU) {}
    try
    {
      localObject2 = new com.tencent.mm.plugin.appbrand.u.k();
      paramc = paramc.Zl().a(paramFile, paramString, (com.tencent.mm.plugin.appbrand.u.k)localObject2);
      localObject1 = paramc;
      if (paramk != null)
      {
        paramk.value = ((com.tencent.mm.plugin.appbrand.u.k)localObject2).value;
        localObject1 = paramc;
      }
      switch (1.gqS[localObject1.ordinal()])
      {
      default: 
        return "fail " + ((h)localObject1).name();
      }
    }
    catch (Exception paramc)
    {
      return "fail:writeFile exception: " + paramc.toString();
    }
    return String.format("fail permission denied, open \"%s\"", new Object[] { paramString });
    return String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
    return String.format("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
    return "fail the maximum size of the file storage limit is exceeded";
    return "ok";
  }
  
  static f.a c(c paramc, JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("tempFilePath");
    Object localObject1 = paramJSONObject.optString("filePath");
    if (bk.bl((String)localObject2))
    {
      y.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      return new f.a("fail", new Object[0]);
    }
    localObject2 = paramc.Zl().rx((String)localObject2);
    if ((localObject2 == null) || (!((File)localObject2).exists())) {
      return new f.a("fail tempFilePath file not exist", new Object[0]);
    }
    paramJSONObject = new com.tencent.mm.plugin.appbrand.u.k();
    paramc = a(paramc, (File)localObject2, (String)localObject1, paramJSONObject);
    localObject1 = new HashMap();
    if ("ok".equals(paramc)) {
      ((Map)localObject1).put("savedFilePath", paramJSONObject.value);
    }
    return new f.a(paramc, new Object[0]).t((Map)localObject1);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = c(paramc, paramJSONObject);
    paramc.C(paramInt, h(paramJSONObject.aox, paramJSONObject.values));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ae
 * JD-Core Version:    0.7.0.1
 */