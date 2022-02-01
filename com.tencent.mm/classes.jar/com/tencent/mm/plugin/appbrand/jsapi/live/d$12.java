package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import org.json.JSONException;
import org.json.JSONObject;

final class d$12
  implements TXLivePusher.OnBGMNotify
{
  d$12(d paramd, int paramInt, h paramh) {}
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(145875);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", new Object[] { Integer.valueOf(paramInt) });
    d.b localb = new d.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("livePusherId", this.rJm);
      this.rJh.a(localb.ZR(localJSONObject.toString()), null);
      AppMethodBeat.o(145875);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(145874);
    d.c localc = new d.c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      localJSONObject.put("livePusherId", this.rJm);
      this.rJh.a(localc.ZR(localJSONObject.toString()), null);
      AppMethodBeat.o(145874);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(145873);
    Log.i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
    d.d locald = new d.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.rJm);
      this.rJh.a(locald.ZR(localJSONObject.toString()), null);
      AppMethodBeat.o(145873);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d.12
 * JD-Core Version:    0.7.0.1
 */