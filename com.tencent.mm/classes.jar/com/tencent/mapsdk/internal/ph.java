package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONObject;

public class ph
  implements JsonParser
{
  public boolean a;
  public List<pj> b;
  
  private boolean a()
  {
    return this.a;
  }
  
  private List<pj> b()
  {
    return this.b;
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(225448);
    if (paramJSONObject != null) {
      if (paramJSONObject.optInt("enable", 0) != 1) {
        break label58;
      }
    }
    for (;;)
    {
      this.a = bool;
      paramJSONObject = paramJSONObject.optJSONArray("layers");
      if (paramJSONObject != null) {
        this.b = JsonUtils.parseToList(paramJSONObject, pj.class, new Object[0]);
      }
      AppMethodBeat.o(225448);
      return;
      label58:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ph
 * JD-Core Version:    0.7.0.1
 */