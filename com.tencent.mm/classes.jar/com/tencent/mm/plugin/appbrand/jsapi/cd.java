package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class cd
  extends d
{
  public static final int CTRL_INDEX = 982;
  public static final String NAME = "openWCExDeviceList";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(226679);
    Log.i("MicroMsg.JsApiOpenWCExDeviceList", "invoke JsApiOpenWCExDeviceList!");
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:component is null");
      AppMethodBeat.o(226679);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:context is null");
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(226679);
      return;
    }
    paramJSONObject = new Intent();
    c.b(paramf.getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", paramJSONObject);
    paramf.i(paramInt, h("ok", null));
    AppMethodBeat.o(226679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cd
 * JD-Core Version:    0.7.0.1
 */