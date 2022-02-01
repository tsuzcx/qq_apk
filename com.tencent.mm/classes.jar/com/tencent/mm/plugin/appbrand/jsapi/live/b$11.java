package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import org.json.JSONException;
import org.json.JSONObject;

final class b$11
  implements TXLivePusher.OnBGMNotify
{
  b$11(b paramb, int paramInt, e parame) {}
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(145875);
    ae.i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", new Object[] { Integer.valueOf(paramInt) });
    b.b localb = new b.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("livePusherId", this.kFw);
      this.kFs.b(localb.PQ(localJSONObject.toString()));
      AppMethodBeat.o(145875);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(145874);
    b.c localc = new b.c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      localJSONObject.put("livePusherId", this.kFw);
      this.kFs.b(localc.PQ(localJSONObject.toString()));
      AppMethodBeat.o(145874);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(145873);
    ae.i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
    b.d locald = new b.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.kFw);
      this.kFs.b(locald.PQ(localJSONObject.toString()));
      AppMethodBeat.o(145873);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.11
 * JD-Core Version:    0.7.0.1
 */