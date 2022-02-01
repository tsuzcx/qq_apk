package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.rtmp.ITXLivePushListener;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class b$10
  implements ITXLivePushListener
{
  b$10(b paramb, int paramInt, e parame) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145872);
    b.f localf = new b.f((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("livePusherId", this.kCh);
      localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
          continue;
          this.kCd.b(localf.Pi(localJSONObject1.toString()));
        }
      }
    }
    catch (JSONException paramBundle) {}
    for (;;)
    {
      AppMethodBeat.o(145872);
      return;
      localJSONObject1.put("info", localJSONObject2);
    }
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(145871);
    ad.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    b.g localg = new b.g((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.getString("EVT_MSG"));
      localJSONObject.put("livePusherId", this.kCh);
      label76:
      this.kCd.b(localg.Pi(localJSONObject.toString()));
      AppMethodBeat.o(145871);
      return;
    }
    catch (JSONException paramBundle)
    {
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.10
 * JD-Core Version:    0.7.0.1
 */