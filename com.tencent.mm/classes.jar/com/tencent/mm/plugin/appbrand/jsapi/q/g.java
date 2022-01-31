package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class g<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 168;
  public static final String NAME = "setClipboardData";
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("data");
    if (bk.bl(paramJSONObject))
    {
      paramCONTEXT.C(paramInt, h("fail", null));
      return;
    }
    y.d("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[] { paramJSONObject });
    ClipboardManager localClipboardManager = (ClipboardManager)paramCONTEXT.getContext().getSystemService("clipboard");
    if (localClipboardManager == null)
    {
      y.i("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramCONTEXT.C(paramInt, h("fail", null));
      return;
    }
    localClipboardManager.setPrimaryClip(ClipData.newPlainText("text", paramJSONObject));
    paramCONTEXT.C(paramInt, h("ok", null));
    c(paramCONTEXT, paramJSONObject);
  }
  
  public void c(CONTEXT paramCONTEXT, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.g
 * JD-Core Version:    0.7.0.1
 */