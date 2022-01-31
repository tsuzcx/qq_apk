package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.y;
import org.json.JSONObject;

public final class f
  extends b
{
  private static final int CTRL_INDEX = 255;
  public static final String NAME = "removeImageView";
  
  protected final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    parame.agW().mh(paramInt);
    return super.b(parame, paramInt, paramView, paramJSONObject);
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.f
 * JD-Core Version:    0.7.0.1
 */