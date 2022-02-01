package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class o
  extends a<c>
{
  public static final int CTRL_INDEX = 38;
  public static final String NAME = "openLocation";
  
  public static Intent O(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(188408);
    try
    {
      float f1 = bt.getFloat(paramJSONObject.optString("latitude"), 0.0F);
      float f2 = bt.getFloat(paramJSONObject.optString("longitude"), 0.0F);
      String str1 = e.Va(paramJSONObject.optString("name"));
      String str2 = e.Va(paramJSONObject.optString("address"));
      try
      {
        i = bt.getInt(paramJSONObject.optString("scale"), 0);
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("map_view_type", 10);
        paramJSONObject.putExtra("kwebmap_slat", f1);
        paramJSONObject.putExtra("kwebmap_lng", f2);
        if (i > 0) {
          paramJSONObject.putExtra("kwebmap_scale", i);
        }
        paramJSONObject.putExtra("kPoiName", str1);
        paramJSONObject.putExtra("Kwebmap_locaion", str2);
        AppMethodBeat.o(188408);
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
      AppMethodBeat.o(188408);
    }
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46385);
    paramJSONObject = O(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46385);
      return;
    }
    Context localContext = paramc.getContext();
    if (localContext == null)
    {
      paramc.h(paramInt, e("fail:internal error invalid android context", null));
      AppMethodBeat.o(46385);
      return;
    }
    d.b(localContext, "location", ".ui.RedirectUI", paramJSONObject);
    paramc.h(paramInt, e("ok", null));
    AppMethodBeat.o(46385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o
 * JD-Core Version:    0.7.0.1
 */