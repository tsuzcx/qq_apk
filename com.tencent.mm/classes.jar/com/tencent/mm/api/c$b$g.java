package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c$b$g
{
  public String cJk;
  public String description;
  public String iconUrl;
  
  public static List<g> d(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(116363);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(116363);
      return localLinkedList;
    }
    try
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        g localg = new g();
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        localg.iconUrl = localJSONObject.optString("icon");
        localg.description = localJSONObject.optString("description");
        localg.cJk = localJSONObject.optString("description_key");
        localLinkedList.add(localg);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ad.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bt.m(paramJSONArray) });
      AppMethodBeat.o(116363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.c.b.g
 * JD-Core Version:    0.7.0.1
 */