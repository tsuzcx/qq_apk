package com.tencent.mm.plugin.game.luggage;

import com.tencent.luggage.e.c;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class h$3
  extends c
{
  h$3(h paramh) {}
  
  public final String name()
  {
    return "onGetA8KeyUrl";
  }
  
  public final JSONObject pV()
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.kMU.kMT);
      if (this.kMU.kMz) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("set_cookie", i);
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.PreloadGameWebCore", "onGetA8Key, e:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.3
 * JD-Core Version:    0.7.0.1
 */