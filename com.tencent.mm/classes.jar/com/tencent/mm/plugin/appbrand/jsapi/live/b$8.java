package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePlayListener;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class b$8
  implements ITXLivePlayListener
{
  b$8(b paramb, int paramInt, e parame) {}
  
  public final void onNetStatus(Bundle paramBundle)
  {
    b.b localb = new b.b((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("livePlayerId", this.gkY);
      localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
          continue;
          this.gkV.b(localb.tM(localJSONObject1.toString()));
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
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    b.c localc = new b.c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramBundle.getString("EVT_MSG"));
      localJSONObject.put("livePlayerId", this.gkY);
      label71:
      this.gkV.b(localc.tM(localJSONObject.toString()));
      return;
    }
    catch (JSONException paramBundle)
    {
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b.8
 * JD-Core Version:    0.7.0.1
 */