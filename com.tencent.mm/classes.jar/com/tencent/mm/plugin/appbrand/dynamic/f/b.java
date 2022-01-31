package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.aa.b.c;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends c
{
  public Map<String, String> fWv;
  public String fWw;
  public int fWx;
  public int fWy;
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
  
  public final JSONObject rB()
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.title);
      localJSONObject.put("path", this.path);
      if (this.fWv == null) {}
      for (Object localObject = new HashMap();; localObject = this.fWv)
      {
        localJSONObject.put("query", new JSONObject((Map)localObject));
        localJSONObject.put("cacheKey", this.fWw);
        localJSONObject.put("width", h.mx(this.fWx));
        localJSONObject.put("height", h.mx(this.fWy));
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.b
 * JD-Core Version:    0.7.0.1
 */