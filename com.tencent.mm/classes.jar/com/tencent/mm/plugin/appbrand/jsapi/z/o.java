package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class o<CONTEXT extends f>
  extends d<CONTEXT>
{
  public static final int CTRL_INDEX = 168;
  public static final String NAME = "setClipboardData";
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137673);
    paramJSONObject = paramJSONObject.optString("data");
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramCONTEXT.i(paramInt, h("fail", null));
      AppMethodBeat.o(137673);
      return;
    }
    Log.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[] { paramJSONObject });
    ClipboardHelper.setText(paramCONTEXT.getContext(), "text", paramJSONObject);
    paramCONTEXT.i(paramInt, h("ok", null));
    c(paramCONTEXT, paramJSONObject);
    AppMethodBeat.o(137673);
  }
  
  public void c(CONTEXT paramCONTEXT, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.o
 * JD-Core Version:    0.7.0.1
 */