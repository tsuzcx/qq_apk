package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g$a
{
  public long endTime;
  public long startTime;
  public int umn;
  public List<String> umo;
  
  public g$a()
  {
    AppMethodBeat.i(195632);
    this.startTime = 0L;
    this.endTime = 0L;
    this.umn = -10;
    this.umo = new ArrayList();
    AppMethodBeat.o(195632);
  }
  
  static a amT(String paramString)
  {
    AppMethodBeat.i(195634);
    locala = new a();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195634);
      return locala;
    }
    try
    {
      paramString = new JSONObject(paramString);
      locala.startTime = paramString.optLong("startTime", 0L);
      locala.endTime = paramString.optLong("endTime", 0L);
      locala.umn = paramString.optInt("basicType", -10);
      paramString = paramString.optJSONArray("msgIdList");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          locala.umo.add(paramString.optString(i));
          i += 1;
        }
      }
      return locala;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(195634);
    }
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(195633);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("startTime", this.startTime);
      ((JSONObject)localObject).put("endTime", this.endTime);
      ((JSONObject)localObject).put("basicType", this.umn);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.umo.iterator();
      while (localIterator.hasNext())
      {
        localJSONArray.put((String)localIterator.next());
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    catch (JSONException localJSONException) {}
    for (;;)
    {
      AppMethodBeat.o(195633);
      return localObject;
      ((JSONObject)localObject).put("msgIdList", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g.a
 * JD-Core Version:    0.7.0.1
 */