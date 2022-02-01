package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLivePlayListener;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class a$8
  implements ITXLivePlayListener
{
  a$8(a parama, int paramInt, e parame) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145854);
    a.c localc = new a.c((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("livePlayerId", this.kCh);
      localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
          continue;
          this.kCd.b(localc.Pi(localJSONObject1.toString()));
        }
      }
    }
    catch (JSONException paramBundle) {}
    for (;;)
    {
      AppMethodBeat.o(145854);
      return;
      localJSONObject1.put("info", localJSONObject2);
    }
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(145853);
    ad.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    a.d locald = new a.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.getString("EVT_MSG"));
      localJSONObject.put("livePlayerId", this.kCh);
      label76:
      this.kCd.b(locald.Pi(localJSONObject.toString()));
      AppMethodBeat.o(145853);
      return;
    }
    catch (JSONException paramBundle)
    {
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.8
 * JD-Core Version:    0.7.0.1
 */