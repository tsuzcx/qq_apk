package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class j
  extends a
{
  public static final int CTRL_INDEX = 38;
  public static final String NAME = "openLocation";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(131112);
    try
    {
      f1 = bo.getFloat(paramJSONObject.optString("latitude"), 0.0F);
      f2 = bo.getFloat(paramJSONObject.optString("longitude"), 0.0F);
      localObject = e.Fp(paramJSONObject.optString("name"));
      str = e.Fp(paramJSONObject.optString("address"));
    }
    catch (Exception paramJSONObject)
    {
      float f1;
      float f2;
      Object localObject;
      String str;
      int j;
      label70:
      paramc.h(paramInt, j("invalid_coordinate", null));
      AppMethodBeat.o(131112);
      return;
    }
    try
    {
      j = bo.getInt(paramJSONObject.optString("scale"), 0);
      i = j;
    }
    catch (Exception paramJSONObject)
    {
      break label70;
    }
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("map_view_type", 10);
    paramJSONObject.putExtra("kwebmap_slat", f1);
    paramJSONObject.putExtra("kwebmap_lng", f2);
    if (i > 0) {
      paramJSONObject.putExtra("kwebmap_scale", i);
    }
    paramJSONObject.putExtra("kPoiName", (String)localObject);
    paramJSONObject.putExtra("Kwebmap_locaion", str);
    localObject = paramc.getContext();
    if (localObject == null)
    {
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131112);
      return;
    }
    d.b((Context)localObject, "location", ".ui.RedirectUI", paramJSONObject);
    paramc.h(paramInt, j("ok", null));
    AppMethodBeat.o(131112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.j
 * JD-Core Version:    0.7.0.1
 */