package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public int Iyq;
  public JSONArray Iyr;
  public int Iys;
  public long createTime;
  public String taskId;
  public String vBh;
  
  public b(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(40943);
    this.taskId = paramString1;
    this.Iyq = paramInt1;
    try
    {
      this.Iyr = c.aHp(paramString2);
      label27:
      this.vBh = paramString3;
      this.createTime = paramLong;
      this.Iys = paramInt2;
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
      localJSONObject.put("state", this.Iyq);
      localJSONObject.put("localIds", this.Iyr);
      localJSONObject.put("extra", this.vBh);
      localJSONObject.put("createTime", this.createTime);
      localJSONObject.put("mixState", this.Iys);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.b
 * JD-Core Version:    0.7.0.1
 */