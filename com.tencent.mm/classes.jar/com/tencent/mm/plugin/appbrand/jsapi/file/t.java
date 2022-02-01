package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
  extends a
{
  private static final int CTRL_INDEX = 115;
  private static final String NAME = "getSavedFileList";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128881);
    e.jQn.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128880);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(128880);
          return;
        }
        Object localObject = paramc.Ee().aRh();
        JSONArray localJSONArray = new JSONArray();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            p.a locala = (p.a)((Iterator)localObject).next();
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("filePath", locala.getFileName());
              localJSONObject.put("size", locala.aRb());
              localJSONObject.put("createTime", TimeUnit.MILLISECONDS.toSeconds(locala.lastModified()));
              localJSONArray.put(localJSONObject);
            }
            catch (Exception localException) {}
          }
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("fileList", localJSONArray);
        paramc.h(paramInt, t.this.k("ok", (Map)localObject));
        AppMethodBeat.o(128880);
      }
    });
    AppMethodBeat.o(128881);
  }
  
  public final boolean aXA()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.t
 * JD-Core Version:    0.7.0.1
 */