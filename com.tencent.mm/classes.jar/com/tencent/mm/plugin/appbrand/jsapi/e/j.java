package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class j
  extends a
{
  public static final int CTRL_INDEX = 38;
  public static final String NAME = "openLocation";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    try
    {
      f1 = bk.getFloat(paramJSONObject.optString("latitude"), 0.0F);
      f2 = bk.getFloat(paramJSONObject.optString("longitude"), 0.0F);
      localObject = com.tencent.mm.plugin.appbrand.v.c.wG(paramJSONObject.optString("name"));
      str = com.tencent.mm.plugin.appbrand.v.c.wG(paramJSONObject.optString("address"));
    }
    catch (Exception paramJSONObject)
    {
      float f1;
      float f2;
      Object localObject;
      String str;
      int j;
      label65:
      paramc.C(paramInt, h("invalid_coordinate", null));
      return;
    }
    try
    {
      j = bk.getInt(paramJSONObject.optString("scale"), 0);
      i = j;
    }
    catch (Exception paramJSONObject)
    {
      break label65;
    }
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("map_view_type", 7);
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
      paramc.C(paramInt, h("fail", null));
      return;
    }
    d.b((Context)localObject, "location", ".ui.RedirectUI", paramJSONObject);
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.j
 * JD-Core Version:    0.7.0.1
 */