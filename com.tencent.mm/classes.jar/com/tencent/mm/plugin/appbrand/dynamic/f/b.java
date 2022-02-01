package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.c;
import com.tencent.mm.plugin.appbrand.z.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends c
{
  public String cacheKey;
  public Map<String, String> jNr;
  public int jNs;
  public int jNt;
  public String path;
  public String title;
  
  public b()
  {
    super("onCanvasInsert");
  }
  
  b(int paramInt)
  {
    super("onCanvasInsert", paramInt);
  }
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(121392);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("title", this.title);
        localJSONObject.put("path", this.path);
        if (this.jNr != null) {
          continue;
        }
        localObject = new HashMap();
        localJSONObject.put("query", new JSONObject((Map)localObject));
        localJSONObject.put("cacheKey", this.cacheKey);
        localJSONObject.put("width", g.vd(this.jNs));
        localJSONObject.put("height", g.vd(this.jNt));
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        continue;
      }
      AppMethodBeat.o(121392);
      return localJSONObject;
      localObject = this.jNr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.b
 * JD-Core Version:    0.7.0.1
 */