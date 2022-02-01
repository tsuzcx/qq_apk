package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.b;
import com.tencent.mm.plugin.appbrand.jsapi.z.b.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class p$9$4
  implements Runnable
{
  p$9$4(p.9 param9, b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(224341);
    b localb = this.jPk;
    c localc = this.jCN.jCE.aXz();
    String str = this.jPl;
    if (localc == null)
    {
      AppMethodBeat.o(224341);
      return;
    }
    ae.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d", new Object[] { localb.loR, localc.getAppId(), Integer.valueOf(localc.hashCode()) });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("state", localb.loR);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("passThroughInfo", new JSONObject(str));
      localHashMap.put("appContactInfo", localJSONObject);
      new b.a((byte)0).g(localc).H(localHashMap).bja();
      AppMethodBeat.o(224341);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, put passThroughInfo get Exception:%s", new Object[] { localb.loR, localc.getAppId(), Integer.valueOf(localc.hashCode()), localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.9.4
 * JD-Core Version:    0.7.0.1
 */