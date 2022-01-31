package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import org.json.JSONException;
import org.json.JSONObject;

final class k$2
  implements ap.a
{
  k$2(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(126571);
    int i;
    k localk;
    if (this.idV.idQ != null)
    {
      i = this.idV.idQ.getCacheTimeSec();
      int j = this.idV.idQ.getDuration();
      if (j != 0)
      {
        i = (int)(i * 100.0F / j);
        if (i != this.idV.idU)
        {
          this.idV.idU = i;
          localk = this.idV;
        }
      }
    }
    try
    {
      ab.i("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d", new Object[] { Integer.valueOf(i) });
      JSONObject localJSONObject = localk.aFD();
      localJSONObject.put("buffered", i);
      localk.a(new k.i((byte)0), localJSONObject);
      AppMethodBeat.o(126571);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate e=%s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.k.2
 * JD-Core Version:    0.7.0.1
 */