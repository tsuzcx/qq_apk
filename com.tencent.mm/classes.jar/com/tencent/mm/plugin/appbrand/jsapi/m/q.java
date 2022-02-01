package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class q
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 38;
  public static final String NAME = "openLocation";
  
  public static Intent al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(329232);
    Log.i("MicroMsg.JsApiOpenLocation", "data:%s", new Object[] { paramJSONObject });
    try
    {
      float f1 = Util.getFloat(paramJSONObject.optString("latitude"), 0.0F);
      float f2 = Util.getFloat(paramJSONObject.optString("longitude"), 0.0F);
      String str1 = l.agD(paramJSONObject.optString("name"));
      String str2 = l.agD(paramJSONObject.optString("address"));
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
        AppMethodBeat.o(329232);
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
      AppMethodBeat.o(329232);
    }
  }
  
  public void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46385);
    paramJSONObject = al(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46385);
      return;
    }
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      paramf.callback(paramInt, ZP("fail:internal error invalid android context"));
      AppMethodBeat.o(46385);
      return;
    }
    com.tencent.mm.br.c.b(localContext, "location", ".ui.RedirectUI", paramJSONObject);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(46385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.q
 * JD-Core Version:    0.7.0.1
 */