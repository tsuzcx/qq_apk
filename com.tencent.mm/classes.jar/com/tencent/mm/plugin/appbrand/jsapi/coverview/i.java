package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateImageView";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    b localb = (b)((CoverViewContainer)paramView).K(b.class);
    if (localb == null)
    {
      y.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    d.a(paramView, paramJSONObject.optJSONObject("style"));
    a.a(parame, localb, paramJSONObject);
    return super.c(parame, paramInt, paramView, paramJSONObject);
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.i
 * JD-Core Version:    0.7.0.1
 */