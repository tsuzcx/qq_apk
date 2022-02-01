package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class cc
  extends c
{
  public static final int CTRL_INDEX = 982;
  public static final String NAME = "openWCExDeviceList";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(278609);
    Log.i("MicroMsg.JsApiOpenWCExDeviceList", "invoke JsApiOpenWCExDeviceList!");
    if (parame == null)
    {
      Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:component is null");
      AppMethodBeat.o(278609);
      return;
    }
    if (parame.getContext() == null)
    {
      Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:context is null");
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(278609);
      return;
    }
    paramJSONObject = new Intent();
    com.tencent.mm.by.c.b(parame.getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramJSONObject);
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(278609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cc
 * JD-Core Version:    0.7.0.1
 */