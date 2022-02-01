package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class q
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  public static final int CTRL_INDEX = 38;
  public static final String NAME = "openLocation";
  
  public static Intent ab(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(267609);
    Log.i("MicroMsg.JsApiOpenLocation", "data:%s", new Object[] { paramJSONObject });
    try
    {
      float f1 = Util.getFloat(paramJSONObject.optString("latitude"), 0.0F);
      float f2 = Util.getFloat(paramJSONObject.optString("longitude"), 0.0F);
      String str1 = h.anj(paramJSONObject.optString("name"));
      String str2 = h.anj(paramJSONObject.optString("address"));
      try
      {
        i = Util.getInt(paramJSONObject.optString("scale"), 0);
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("map_view_type", 10);
        paramJSONObject.putExtra("kwebmap_slat", f1);
        paramJSONObject.putExtra("kwebmap_lng", f2);
        if (i > 0) {
          paramJSONObject.putExtra("kwebmap_scale", i);
        }
        paramJSONObject.putExtra("kPoiName", str1);
        paramJSONObject.putExtra("Kwebmap_locaion", str2);
        AppMethodBeat.o(267609);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(267609);
    }
  }
  
  public void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46385);
    paramJSONObject = ab(paramJSONObject);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46385);
      return;
    }
    Context localContext = parame.getContext();
    if (localContext == null)
    {
      parame.j(paramInt, h("fail:internal error invalid android context", null));
      AppMethodBeat.o(46385);
      return;
    }
    com.tencent.mm.by.c.b(localContext, "location", ".ui.RedirectUI", paramJSONObject);
    parame.j(paramInt, h("ok", null));
    AppMethodBeat.o(46385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.q
 * JD-Core Version:    0.7.0.1
 */