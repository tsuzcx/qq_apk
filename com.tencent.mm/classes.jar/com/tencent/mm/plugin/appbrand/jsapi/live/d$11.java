package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class d$11
  implements ITXLivePushListener
{
  d$11(d paramd, int paramInt, h paramh) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145872);
    d.f localf = new d.f((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("livePusherId", this.rJm);
      localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
          continue;
          this.rJh.a(localf.ZR(localJSONObject1.toString()), null);
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
    Log.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    d.g localg = new d.g((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.getString("EVT_MSG"));
      localJSONObject.put("livePusherId", this.rJm);
      label76:
      this.rJh.a(localg.ZR(localJSONObject.toString()), null);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.d.11
 * JD-Core Version:    0.7.0.1
 */