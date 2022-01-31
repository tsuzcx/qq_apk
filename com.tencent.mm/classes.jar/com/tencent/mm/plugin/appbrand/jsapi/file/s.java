package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s
  extends a
{
  private static final int CTRL_INDEX = 115;
  private static final String NAME = "getSavedFileList";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(102789);
    Object localObject = paramc.wX().awJ();
    paramJSONObject = new JSONArray();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        o.a locala = (o.a)((Iterator)localObject).next();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("filePath", locala.getFileName());
          localJSONObject.put("size", locala.awE());
          localJSONObject.put("createTime", TimeUnit.MILLISECONDS.toSeconds(locala.lastModified()));
          paramJSONObject.put(localJSONObject);
        }
        catch (Exception localException) {}
      }
    }
    localObject = new HashMap(1);
    ((Map)localObject).put("fileList", paramJSONObject);
    paramc.h(paramInt, j("ok", (Map)localObject));
    AppMethodBeat.o(102789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.s
 * JD-Core Version:    0.7.0.1
 */