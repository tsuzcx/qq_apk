package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c$a
{
  public List<c.b> gfH;
  public String title;
  
  public c$a()
  {
    AppMethodBeat.i(128605);
    this.title = "";
    this.gfH = new LinkedList();
    AppMethodBeat.o(128605);
  }
  
  final a n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128606);
    this.title = paramJSONObject.optString("title", "");
    paramJSONObject = paramJSONObject.optJSONArray("detail");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(128606);
      return this;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
      c.b localb = new c.b();
      List localList = this.gfH;
      localb.cDz = localJSONObject.optString("icon");
      localb.desc = localJSONObject.optString("desc");
      localb.gfI = localJSONObject.optInt("desc_type");
      localb.action = localJSONObject.optInt("action");
      localb.gfJ = localJSONObject.optString("action_param");
      localList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(128606);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.a.c.a
 * JD-Core Version:    0.7.0.1
 */