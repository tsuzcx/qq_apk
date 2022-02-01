package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class l<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 168;
  public static final String NAME = "setClipboardData";
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137673);
    paramJSONObject = paramJSONObject.optString("data");
    if (bt.isNullOrNil(paramJSONObject))
    {
      paramCONTEXT.h(paramInt, e("fail", null));
      AppMethodBeat.o(137673);
      return;
    }
    ad.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[] { paramJSONObject });
    ClipboardManager localClipboardManager = (ClipboardManager)paramCONTEXT.getContext().getSystemService("clipboard");
    if (localClipboardManager == null)
    {
      ad.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramCONTEXT.h(paramInt, e("fail", null));
      AppMethodBeat.o(137673);
      return;
    }
    localClipboardManager.setPrimaryClip(ClipData.newPlainText("text", paramJSONObject));
    paramCONTEXT.h(paramInt, e("ok", null));
    c(paramCONTEXT, paramJSONObject);
    AppMethodBeat.o(137673);
  }
  
  public void c(CONTEXT paramCONTEXT, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.l
 * JD-Core Version:    0.7.0.1
 */