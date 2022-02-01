package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.appstorage.w.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
  extends c
{
  private static final int CTRL_INDEX = 115;
  private static final String NAME = "getSavedFileList";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128881);
    e.rXi.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128880);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(128880);
          return;
        }
        Object localObject = paramf.getFileSystem().cil();
        JSONArray localJSONArray = new JSONArray();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            w.a locala = (w.a)((Iterator)localObject).next();
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("filePath", locala.getFileName());
              localJSONObject.put("size", locala.cia());
              localJSONObject.put("createTime", TimeUnit.MILLISECONDS.toSeconds(locala.lastModified()));
              localJSONArray.put(localJSONObject);
            }
            catch (Exception localException) {}
          }
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("fileList", localJSONArray);
        paramf.callback(paramInt, t.this.m("ok", (Map)localObject));
        AppMethodBeat.o(128880);
      }
    });
    AppMethodBeat.o(128881);
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.t
 * JD-Core Version:    0.7.0.1
 */