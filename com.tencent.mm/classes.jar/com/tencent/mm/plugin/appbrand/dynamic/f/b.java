package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.c;
import com.tencent.mm.plugin.appbrand.af.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends c
{
  public String mgR;
  public String path;
  public Map<String, String> rmP;
  public int rmQ;
  public int rmR;
  public String title;
  
  public b()
  {
    super("onCanvasInsert");
  }
  
  b(int paramInt)
  {
    super("onCanvasInsert", paramInt);
  }
  
  public final JSONObject aZh()
  {
    AppMethodBeat.i(121392);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("path", this.path);
        if (this.rmP != null) {
          continue;
        }
        localObject = new HashMap();
        localJSONObject.put("query", new JSONObject((Map)localObject));
        localJSONObject.put("cacheKey", this.mgR);
        localJSONObject.put("width", i.DB(this.rmQ));
        localJSONObject.put("height", i.DB(this.rmR));
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        continue;
      }
      AppMethodBeat.o(121392);
      return localJSONObject;
      localObject = this.rmP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.b
 * JD-Core Version:    0.7.0.1
 */