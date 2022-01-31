package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d$b$f
{
  public String description;
  public String fwa;
  public String iconUrl;
  
  public static List<f> d(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(11277);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(11277);
      return localLinkedList;
    }
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
        localf.fwa = localJSONObject.optString("description_key");
        localLinkedList.add(localf);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ab.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bo.l(paramJSONArray) });
      AppMethodBeat.o(11277);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.d.b.f
 * JD-Core Version:    0.7.0.1
 */