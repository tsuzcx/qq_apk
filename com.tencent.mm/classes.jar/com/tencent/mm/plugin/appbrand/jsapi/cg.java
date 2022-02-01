package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class cg
  extends c
{
  public static final int CTRL_INDEX = 982;
  public static final String NAME = "openWCExDeviceList";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325532);
    Log.i("MicroMsg.JsApiOpenWCExDeviceList", "invoke JsApiOpenWCExDeviceList!");
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:component is null");
      AppMethodBeat.o(325532);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:context is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(325532);
      return;
    }
    paramJSONObject = new Intent();
    com.tencent.mm.br.c.b(paramf.getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramJSONObject);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(325532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cg
 * JD-Core Version:    0.7.0.1
 */