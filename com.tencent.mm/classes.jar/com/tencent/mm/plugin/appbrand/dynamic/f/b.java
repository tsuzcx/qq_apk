package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.c;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends c
{
  public String cacheKey;
  public Map<String, String> kkS;
  public int kkT;
  public int kkU;
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
        if (this.kkS != null) {
          continue;
        }
        localObject = new HashMap();
        localJSONObject.put("query", new JSONObject((Map)localObject));
        localJSONObject.put("cacheKey", this.cacheKey);
        localJSONObject.put("width", g.vN(this.kkT));
        localJSONObject.put("height", g.vN(this.kkU));
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        continue;
      }
      AppMethodBeat.o(121392);
      return localJSONObject;
      localObject = this.kkS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.b
 * JD-Core Version:    0.7.0.1
 */