package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
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
  public int xEF;
  public List<String> xEG;
  
  public g$a()
  {
    AppMethodBeat.i(204151);
    this.startTime = 0L;
    this.endTime = 0L;
    this.xEF = -10;
    this.xEG = new ArrayList();
    AppMethodBeat.o(204151);
  }
  
  static a aAj(String paramString)
  {
    AppMethodBeat.i(204153);
    locala = new a();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(204153);
      return locala;
    }
    try
    {
      paramString = new JSONObject(paramString);
      locala.startTime = paramString.optLong("startTime", 0L);
      locala.endTime = paramString.optLong("endTime", 0L);
      locala.xEF = paramString.optInt("basicType", -10);
      paramString = paramString.optJSONArray("msgIdList");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          locala.xEG.add(paramString.optString(i));
          i += 1;
        }
      }
      return locala;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(204153);
    }
  }
  
  public final String toJson()
  {
    AppMethodBeat.i(204152);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("startTime", this.startTime);
      ((JSONObject)localObject).put("endTime", this.endTime);
      ((JSONObject)localObject).put("basicType", this.xEF);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.xEG.iterator();
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
      AppMethodBeat.o(204152);
      return localObject;
      ((JSONObject)localObject).put("msgIdList", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g.a
 * JD-Core Version:    0.7.0.1
 */