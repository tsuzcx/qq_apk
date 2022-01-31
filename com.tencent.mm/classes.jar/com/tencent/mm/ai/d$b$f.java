package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d$b$f
{
  public String description;
  public String efY;
  public String iconUrl;
  
  public static List<f> c(JSONArray paramJSONArray)
  {
    localLinkedList = new LinkedList();
    if (paramJSONArray == null) {}
    for (;;)
    {
      return localLinkedList;
      try
      {
        int j = paramJSONArray.length();
        int i = 0;
        while (i < j)
        {
          f localf = new f();
          JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
          localf.iconUrl = localJSONObject.optString("icon");
          localf.description = localJSONObject.optString("description");
          localf.efY = localJSONObject.optString("description_key");
          localLinkedList.add(localf);
          i += 1;
        }
        return localLinkedList;
      }
      catch (Exception paramJSONArray)
      {
        y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramJSONArray) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.f
 * JD-Core Version:    0.7.0.1
 */