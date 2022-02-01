package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class u<CONTEXT extends f>
  extends c<CONTEXT>
{
  public static final int CTRL_INDEX = 168;
  public static final String NAME = "setClipboardData";
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137673);
    paramJSONObject = paramJSONObject.optString("data");
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramCONTEXT.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(137673);
      return;
    }
    Log.i("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[] { paramJSONObject });
    try
    {
      ClipboardHelper.setText(paramCONTEXT.getContext(), "text", paramJSONObject);
      paramCONTEXT.callback(paramInt, ZP("ok"));
      c(paramCONTEXT, paramJSONObject);
      AppMethodBeat.o(137673);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiSetClipboardData", "setPrimaryClip get exception:%s", new Object[] { paramJSONObject });
      paramCONTEXT.callback(paramInt, ZP("fail:internal error"));
      AppMethodBeat.o(137673);
    }
  }
  
  public void c(CONTEXT paramCONTEXT, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.u
 * JD-Core Version:    0.7.0.1
 */