package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 169;
  public static final String NAME = "getClipboardData";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126406);
    paramJSONObject = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    if (paramJSONObject == null)
    {
      ab.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(126406);
      return;
    }
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
    paramc.h(paramInt, j("ok", (Map)localObject1));
    AppMethodBeat.o(126406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.c
 * JD-Core Version:    0.7.0.1
 */