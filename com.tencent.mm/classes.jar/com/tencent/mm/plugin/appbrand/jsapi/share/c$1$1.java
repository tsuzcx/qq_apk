package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(131438);
    ab.i("MicroMsg.JsApiShareAppMessage", "task callback");
    this.hZt.aBk();
    Object localObject = new HashMap();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      if (!bo.es(this.hZt.iah))
      {
        Iterator localIterator = this.hZt.iah.iterator();
        while (localIterator.hasNext())
        {
          ShareInfo localShareInfo = (ShareInfo)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("shareKey", localShareInfo.bCZ);
          localJSONObject.put("shareName", localShareInfo.bCY);
          localJSONArray.put(localJSONObject);
        }
      }
      int i;
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(localJSONException));
      ((Map)localObject).put("shareInfos", localJSONArray);
      this.hZu.hxC.h(this.hZu.bAX, this.hZu.hZs.j("ok", (Map)localObject));
      i = 16;
      localObject = this.bZZ + ":";
      if (this.bZZ.toLowerCase().endsWith("@chatroom")) {
        i = 15;
      }
      c.a(this.hZu.val$appId, this.hZu.hZg, i, (String)localObject, 1, this.val$resultCode);
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(this.hZu.val$appId)) {
        h.qsU.e(16979, new Object[] { this.hZu.val$appId, this.hZu.hZg, Integer.valueOf(0), Integer.valueOf(3) });
      }
      AppMethodBeat.o(131438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.c.1.1
 * JD-Core Version:    0.7.0.1
 */