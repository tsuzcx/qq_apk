package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public int nkT;
  public JSONArray nkU;
  public String nkV;
  public String taskId;
  
  public a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151799);
    this.taskId = paramString1;
    this.nkT = paramInt;
    try
    {
      this.nkU = c.QD(paramString2);
      label27:
      this.nkV = paramString3;
      AppMethodBeat.o(151799);
      return;
    }
    catch (Exception paramString1)
    {
      break label27;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(151800);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("postId", this.taskId);
      localJSONObject.put("state", this.nkT);
      localJSONObject.put("localIds", this.nkU);
      localJSONObject.put("extra", this.nkV);
      label57:
      AppMethodBeat.o(151800);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a
 * JD-Core Version:    0.7.0.1
 */