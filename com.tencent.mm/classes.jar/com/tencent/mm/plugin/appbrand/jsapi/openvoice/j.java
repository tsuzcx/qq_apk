package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
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
    AppMethodBeat.i(226940);
    if (paramJSONObject == null)
    {
      paramc.i(paramInt, h("fail:data is null or nil", null));
      AppMethodBeat.o(226940);
      return;
    }
    String str = paramc.getAppId();
    Log.i(TAG, "hy: appId:" + str + ", data:" + paramJSONObject.toString());
    try
    {
      if ("play".equalsIgnoreCase(paramJSONObject.getString("type")))
      {
        paramJSONObject = q.qta;
        if (paramJSONObject.qtm == 1) {
          i = 0;
        }
        if (paramJSONObject.qtg != null) {
          paramJSONObject.qtg.bl(i, true);
        }
        paramJSONObject.mainHandler.sendEmptyMessage(272);
      }
      for (;;)
      {
        paramc.i(paramInt, h("ok", null));
        AppMethodBeat.o(226940);
        return;
        Log.i(TAG, "operate: stop ring");
        q.qta.stopRing();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.i(paramInt, h("fail: param error!", null));
      AppMethodBeat.o(226940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.j
 * JD-Core Version:    0.7.0.1
 */