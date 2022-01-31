package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 169;
  public static final String NAME = "getClipboardData";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = (ClipboardManager)paramc.getContext().getSystemService("clipboard");
    if (paramJSONObject == null)
    {
      y.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramc.C(paramInt, h("fail", null));
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
    y.d("MicroMsg.JsApiGetClipboardData", "stevyang retData %s", new Object[] { paramJSONObject });
    localObject1 = new HashMap();
    ((Map)localObject1).put("data", paramJSONObject);
    paramc.C(paramInt, h("ok", (Map)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.b
 * JD-Core Version:    0.7.0.1
 */