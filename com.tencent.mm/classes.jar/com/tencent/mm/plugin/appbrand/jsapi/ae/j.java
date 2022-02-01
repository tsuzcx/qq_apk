package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends c
{
  public static final int CTRL_INDEX = 169;
  public static final String NAME = "getClipboardData";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137660);
    paramJSONObject = (ClipboardManager)MMApplicationContext.getContext().getSystemService("clipboard");
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(137660);
      return;
    }
    try
    {
      Object localObject2 = paramJSONObject.getPrimaryClip();
      Object localObject1 = "";
      paramJSONObject = (JSONObject)localObject1;
      if (localObject2 != null)
      {
        paramJSONObject = (JSONObject)localObject1;
        if (((ClipData)localObject2).getItemCount() > 0)
        {
          localObject2 = ((ClipData)localObject2).getItemAt(0);
          paramJSONObject = (JSONObject)localObject1;
          if (((ClipData.Item)localObject2).getText() != null) {
            paramJSONObject = ((ClipData.Item)localObject2).getText().toString();
          }
        }
      }
      localObject1 = new HashMap();
      ((Map)localObject1).put("data", paramJSONObject);
      paramf.callback(paramInt, m("ok", (Map)localObject1));
      AppMethodBeat.o(137660);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiGetClipboardData", "invoke with appId:%s, but get Exception:%s", new Object[] { paramf.getAppId(), paramJSONObject });
      AppMethodBeat.o(137660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.j
 * JD-Core Version:    0.7.0.1
 */