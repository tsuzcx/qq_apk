package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import org.json.JSONException;
import org.json.JSONObject;

final class b$9
  implements TXLivePusher.OnBGMNotify
{
  b$9(b paramb, int paramInt, e parame) {}
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(96100);
    ab.i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("livePusherId", this.hEO);
      this.hEL.b(locala.BN(localJSONObject.toString()));
      AppMethodBeat.o(96100);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(96099);
    b.b localb = new b.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      localJSONObject.put("livePusherId", this.hEO);
      this.hEL.b(localb.BN(localJSONObject.toString()));
      AppMethodBeat.o(96099);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(96098);
    ab.i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
    b.c localc = new b.c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.hEO);
      this.hEL.b(localc.BN(localJSONObject.toString()));
      AppMethodBeat.o(96098);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.9
 * JD-Core Version:    0.7.0.1
 */