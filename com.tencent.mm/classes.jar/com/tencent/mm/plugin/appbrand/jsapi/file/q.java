package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q
  extends a
{
  private static final int CTRL_INDEX = 115;
  private static final String NAME = "getSavedFileList";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = paramc.Zl().acI();
    paramJSONObject = new JSONArray();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        k.a locala = (k.a)((Iterator)localObject).next();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("filePath", locala.getFileName());
          localJSONObject.put("size", locala.acG());
          localJSONObject.put("createTime", TimeUnit.MILLISECONDS.toSeconds(locala.lastModified()));
          paramJSONObject.put(localJSONObject);
        }
        catch (Exception localException) {}
      }
    }
    localObject = new HashMap(1);
    ((Map)localObject).put("fileList", paramJSONObject);
    paramc.C(paramInt, h("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.q
 * JD-Core Version:    0.7.0.1
 */