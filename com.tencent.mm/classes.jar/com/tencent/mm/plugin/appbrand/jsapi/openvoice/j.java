package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.a.a;
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
    AppMethodBeat.i(277571);
    if (paramJSONObject == null)
    {
      paramc.j(paramInt, h("fail:data is null or nil", null));
      AppMethodBeat.o(277571);
      return;
    }
    String str = paramc.getAppId();
    Log.i(TAG, "hy: appId:" + str + ", data:" + paramJSONObject.toString());
    try
    {
      if ("play".equalsIgnoreCase(paramJSONObject.getString("type")))
      {
        paramJSONObject = q.tRM;
        if (paramJSONObject.mRoomType == 1) {
          i = 0;
        }
        int j = a.a.phonering;
        if ((paramJSONObject.tRS != null) && (j > 0)) {
          paramJSONObject.tRS.M(j, i, true);
        }
        paramJSONObject.mainHandler.sendEmptyMessage(272);
      }
      for (;;)
      {
        paramc.j(paramInt, h("ok", null));
        AppMethodBeat.o(277571);
        return;
        Log.i(TAG, "operate: stop ring");
        q.tRM.stopRing();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.j(paramInt, h("fail: param error!", null));
      AppMethodBeat.o(277571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.j
 * JD-Core Version:    0.7.0.1
 */