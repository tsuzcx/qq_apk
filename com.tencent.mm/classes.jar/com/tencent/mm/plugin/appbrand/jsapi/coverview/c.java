package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.widget.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertImageView";
  
  protected final View a(e parame, JSONObject paramJSONObject)
  {
    parame = parame.getContext();
    paramJSONObject = new b(parame);
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    return new CoverViewContainer(parame, paramJSONObject);
  }
  
  protected final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    b localb = (b)((CoverViewContainer)paramView).K(b.class);
    if (localb == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = paramJSONObject.optBoolean("clickable");
      bool2 = paramJSONObject.optBoolean("gesture");
      boolean bool3 = paramJSONObject.optBoolean("transEvt");
      String str1 = paramJSONObject.optString("sendTo", "appservice");
      String str2 = paramJSONObject.optString("data", "");
      d.a(paramView, paramJSONObject.optJSONObject("style"));
      com.tencent.mm.plugin.appbrand.jsapi.s.a.a(parame, localb, paramJSONObject);
      paramView = parame.agW().F(paramInt, true);
      paramView.h("data", str2);
      paramView.h("sendTo", str1);
      paramView.h("transEvt", Boolean.valueOf(bool3));
      paramView.h("clickable", Boolean.valueOf(bool1));
      localb.setOnClickListener(new c.1(this, paramView, parame));
      localb.setClickable(bool1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    } while ((bool1) || (!bool2));
    localb.setOnTouchListener(new c.2(this, paramView, parame));
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c
 * JD-Core Version:    0.7.0.1
 */