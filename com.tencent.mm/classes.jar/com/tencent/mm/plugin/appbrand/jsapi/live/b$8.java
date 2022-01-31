package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePushListener;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class b$8
  implements ITXLivePushListener
{
  b$8(b paramb, int paramInt, e parame) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(96097);
    b.e locale = new b.e((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("livePusherId", this.hEO);
      localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
          continue;
          this.hEL.b(locale.BN(localJSONObject1.toString()));
        }
      }
    }
    catch (JSONException paramBundle) {}
    for (;;)
    {
      AppMethodBeat.o(96097);
      return;
      localJSONObject1.put("info", localJSONObject2);
    }
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(96096);
    ab.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    b.f localf = new b.f((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.getString("EVT_MSG"));
      localJSONObject.put("livePusherId", this.hEO);
      label76:
      this.hEL.b(localf.BN(localJSONObject.toString()));
      AppMethodBeat.o(96096);
      return;
    }
    catch (JSONException paramBundle)
    {
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.8
 * JD-Core Version:    0.7.0.1
 */