package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

final class j$1
  implements am.a
{
  j$1(j paramj) {}
  
  public final boolean tC()
  {
    try
    {
      int i = this.gER.gEM.getCurrPosMs();
      if (Math.abs(i - this.gER.gEP) < 250) {
        return true;
      }
      JSONObject localJSONObject = this.gER.akU();
      this.gER.gEP = i;
      localJSONObject.put("position", new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue());
      localJSONObject.put("duration", this.gER.gEM.getDuration());
      this.gER.a(new j.k((byte)0), localJSONObject);
      return true;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[] { localJSONException });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j.1
 * JD-Core Version:    0.7.0.1
 */