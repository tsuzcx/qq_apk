package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.luggage.e.c;
import com.tencent.mm.protocal.c.awk;
import org.json.JSONObject;

final class e$1
  extends c
{
  e$1(e parame, awk paramawk) {}
  
  public final String name()
  {
    return "onCustomGameMenuClicked";
  }
  
  public final JSONObject pV()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("itemId", this.kNx.tsZ);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.e.1
 * JD-Core Version:    0.7.0.1
 */