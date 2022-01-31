package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class i<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 168;
  public static final String NAME = "setClipboardData";
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126418);
    paramJSONObject = paramJSONObject.optString("data");
    if (bo.isNullOrNil(paramJSONObject))
    {
      paramCONTEXT.h(paramInt, j("fail", null));
      AppMethodBeat.o(126418);
      return;
    }
    ab.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[] { paramJSONObject });
    ClipboardManager localClipboardManager = (ClipboardManager)paramCONTEXT.getContext().getSystemService("clipboard");
    if (localClipboardManager == null)
    {
      ab.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramCONTEXT.h(paramInt, j("fail", null));
      AppMethodBeat.o(126418);
      return;
    }
    localClipboardManager.setPrimaryClip(ClipData.newPlainText("text", paramJSONObject));
    paramCONTEXT.h(paramInt, j("ok", null));
    c(paramCONTEXT, paramJSONObject);
    AppMethodBeat.o(126418);
  }
  
  public void c(CONTEXT paramCONTEXT, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.i
 * JD-Core Version:    0.7.0.1
 */