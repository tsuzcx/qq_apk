package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.a.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
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
    AppMethodBeat.i(326337);
    if (paramJSONObject == null)
    {
      paramc.callback(paramInt, ZP("fail:data is null or nil"));
      AppMethodBeat.o(326337);
      return;
    }
    String str = paramc.getAppId();
    Log.i(TAG, "hy: appId:" + str + ", data:" + paramJSONObject.toString());
    try
    {
      if ("play".equalsIgnoreCase(paramJSONObject.getString("type")))
      {
        paramJSONObject = q.wVc;
        if (paramJSONObject.mRoomType == 1) {
          i = 0;
        }
        int j = a.a.phonering;
        if ((paramJSONObject.wVi != null) && (j > 0)) {
          paramJSONObject.wVi.mK(j, i);
        }
        paramJSONObject.mainHandler.sendEmptyMessage(272);
      }
      for (;;)
      {
        paramc.callback(paramInt, ZP("ok"));
        AppMethodBeat.o(326337);
        return;
        Log.i(TAG, "operate: stop ring");
        q.wVc.stopRing();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.callback(paramInt, ZP("fail: param error!"));
      AppMethodBeat.o(326337);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.j
 * JD-Core Version:    0.7.0.1
 */