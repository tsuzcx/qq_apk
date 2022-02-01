package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends h
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "operateCallTone";
  private static String TAG = "MicroMsg.OpenVoice.JsApiOperateCallTone";
  
  final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(186735);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(186735);
      return;
    }
    String str = paramc.getAppId();
    ac.i(TAG, "hy: appId:" + str + ", data:" + paramJSONObject.toString());
    try
    {
      if ("play".equalsIgnoreCase(paramJSONObject.getString("type")))
      {
        paramJSONObject = p.otZ;
        if (paramJSONObject.ouk == 1) {
          i = 0;
        }
        if (paramJSONObject.oue != null) {
          paramJSONObject.oue.aI(i, true);
        }
        paramJSONObject.hBR.sendEmptyMessage(272);
      }
      for (;;)
      {
        paramc.h(paramInt, e("ok", null));
        AppMethodBeat.o(186735);
        return;
        ac.i(TAG, "operate: stop ring");
        p.otZ.stopRing();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      AppMethodBeat.o(186735);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
 * JD-Core Version:    0.7.0.1
 */