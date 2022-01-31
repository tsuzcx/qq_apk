package com.tencent.mm.openim.a;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c$a
{
  public List<c.b> ePM = new LinkedList();
  public String title = "";
  
  final a g(JSONObject paramJSONObject)
  {
    this.title = paramJSONObject.optString("title", "");
    paramJSONObject = paramJSONObject.optJSONArray("detail");
    if (paramJSONObject == null) {}
    for (;;)
    {
      return this;
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        c.b localb = new c.b();
        List localList = this.ePM;
        localb.bVO = localJSONObject.optString("icon");
        localb.desc = localJSONObject.optString("desc");
        localb.ePN = localJSONObject.optInt("desc_type");
        localb.action = localJSONObject.optInt("action");
        localb.ePO = localJSONObject.optString("action_param");
        localList.add(localb);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.c.a
 * JD-Core Version:    0.7.0.1
 */