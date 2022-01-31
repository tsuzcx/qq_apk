package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

final class k$1
  implements ap.a
{
  k$1(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(126570);
    try
    {
      int i = this.idV.idQ.getCurrPosMs();
      int j = Math.abs(i - this.idV.idT);
      if (j < 250)
      {
        AppMethodBeat.o(126570);
        return true;
      }
      JSONObject localJSONObject = this.idV.aFD();
      this.idV.idT = i;
      localJSONObject.put("position", new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue());
      localJSONObject.put("duration", this.idV.idQ.getDuration());
      this.idV.a(new k.l((byte)0), localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[] { localJSONException });
      }
    }
    AppMethodBeat.o(126570);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.k.1
 * JD-Core Version:    0.7.0.1
 */