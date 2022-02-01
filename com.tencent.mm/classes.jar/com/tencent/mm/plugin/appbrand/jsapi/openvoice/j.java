package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends i
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "operateCallTone";
  private static String TAG = "MicroMsg.OpenVoice.JsApiOperateCallTone";
  
  final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(188481);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(188481);
      return;
    }
    String str = paramc.getAppId();
    ad.i(TAG, "hy: appId:" + str + ", data:" + paramJSONObject.toString());
    try
    {
      if ("play".equalsIgnoreCase(paramJSONObject.getString("type")))
      {
        paramJSONObject = p.oXv;
        if (paramJSONObject.oXG == 1) {
          i = 0;
        }
        if (paramJSONObject.oXA != null) {
          paramJSONObject.oXA.aO(i, true);
        }
        paramJSONObject.hUx.sendEmptyMessage(272);
      }
      for (;;)
      {
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(188481);
        return;
        ad.i(TAG, "operate: stop ring");
        p.oXv.stopRing();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      AppMethodBeat.o(188481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.j
 * JD-Core Version:    0.7.0.1
 */