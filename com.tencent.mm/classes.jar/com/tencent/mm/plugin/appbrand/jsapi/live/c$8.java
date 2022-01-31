package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePushListener;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class c$8
  implements ITXLivePushListener
{
  c$8(c paramc, int paramInt, e parame) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    c.e locale = new c.e((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("livePusherId", this.gkY);
      localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
          continue;
          this.gkV.b(locale.tM(localJSONObject1.toString()));
        }
      }
    }
    catch (JSONException paramBundle) {}
    for (;;)
    {
      return;
      localJSONObject1.put("info", localJSONObject2);
    }
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiInsertLivePusher.javayhu", "onPushEvent errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    c.f localf = new c.f((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.getString("EVT_MSG"));
      localJSONObject.put("livePusherId", this.gkY);
      label71:
      this.gkV.b(localf.tM(localJSONObject.toString()));
      return;
    }
    catch (JSONException paramBundle)
    {
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.8
 * JD-Core Version:    0.7.0.1
 */