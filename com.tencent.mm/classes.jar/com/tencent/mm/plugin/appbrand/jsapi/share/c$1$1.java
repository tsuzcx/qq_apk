package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, SendAppMessageTask paramSendAppMessageTask, String paramString, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.JsApiShareAppMessage", "task callback");
    this.gBx.ahD();
    Object localObject = new HashMap();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      if (!bk.dk(this.gBx.gBO))
      {
        Iterator localIterator = this.gBx.gBO.iterator();
        while (localIterator.hasNext())
        {
          ShareInfo localShareInfo = (ShareInfo)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("shareKey", localShareInfo.dTX);
          localJSONObject.put("shareName", localShareInfo.dZN);
          localJSONArray.put(localJSONObject);
        }
      }
      int i;
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(localJSONException));
      ((Map)localObject).put("shareInfos", localJSONArray);
      this.gBy.gbW.C(this.gBy.dIS, this.gBy.gBw.h("ok", (Map)localObject));
      i = 16;
      localObject = this.bxX + ":";
      if (this.bxX.toLowerCase().endsWith("@chatroom")) {
        i = 15;
      }
      c.a(this.gBy.val$appId, this.gBy.gBl, i, (String)localObject, 1, this.val$resultCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.c.1.1
 * JD-Core Version:    0.7.0.1
 */