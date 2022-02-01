package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class w$11$4
  implements Runnable
{
  w$11$4(w.11 param11, com.tencent.mm.plugin.appbrand.jsapi.ag.c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(316777);
    Object localObject = this.qwe;
    com.tencent.mm.plugin.appbrand.service.c localc = this.qwd.qvY.ccO();
    String str = this.qwf;
    HashMap localHashMap;
    if (localc != null)
    {
      Log.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, passThroughInfo:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.ag.c)localObject).szc, localc.getAppId(), Integer.valueOf(localc.hashCode()), str });
      localHashMap = new HashMap(1);
      localHashMap.put("state", ((com.tencent.mm.plugin.appbrand.jsapi.ag.c)localObject).szc);
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("passThroughInfo", new JSONObject(str));
      localHashMap.put("appContactInfo", localJSONObject);
      new c.a((byte)0).h(localc).K(localHashMap).cpV();
      if (com.tencent.mm.plugin.appbrand.jsapi.ag.c.sza == this.qwe)
      {
        localObject = w.r(this.qwd.qvY);
        if ((!((v)localObject).qvt.getAndSet(true)) && (((v)localObject).qvs.get())) {
          ((v)localObject).qvu.run();
        }
      }
      AppMethodBeat.o(316777);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, put passThroughInfo get Exception:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.jsapi.ag.c)localObject).szc, localc.getAppId(), Integer.valueOf(localc.hashCode()), localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.11.4
 * JD-Core Version:    0.7.0.1
 */