package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public long createTime;
  public String taskId;
  public int xAl;
  public JSONArray xAm;
  public String xAn;
  public int xAo;
  
  public b(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(40943);
    this.taskId = paramString1;
    this.xAl = paramInt1;
    try
    {
      this.xAm = c.aAM(paramString2);
      label27:
      this.xAn = paramString3;
      this.createTime = paramLong;
      this.xAo = paramInt2;
      AppMethodBeat.o(40943);
      return;
    }
    catch (Exception paramString1)
    {
      break label27;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(40944);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("postId", this.taskId);
      localJSONObject.put("state", this.xAl);
      localJSONObject.put("localIds", this.xAm);
      localJSONObject.put("extra", this.xAn);
      localJSONObject.put("createTime", this.createTime);
      localJSONObject.put("mixState", this.xAo);
      label79:
      AppMethodBeat.o(40944);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.b
 * JD-Core Version:    0.7.0.1
 */