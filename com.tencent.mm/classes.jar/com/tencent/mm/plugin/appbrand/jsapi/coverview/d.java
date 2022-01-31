package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONObject;

public final class d
  extends a
{
  private static final int CTRL_INDEX = 446;
  public static final String NAME = "insertScrollView";
  
  protected final View a(e parame, JSONObject paramJSONObject)
  {
    return new WxaScrollView(parame.getContext());
  }
  
  protected final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    boolean bool = paramJSONObject.optBoolean("needScrollEvent");
    String str = paramJSONObject.optString("data", "");
    com.tencent.mm.plugin.appbrand.jsapi.s.d.a(paramView, paramJSONObject.optJSONObject("style"));
    parame.agW().F(paramInt, true).h("data", str);
    if (bool) {
      localWxaScrollView.setOnScrollChangedListener(new d.1(this, parame, paramInt));
    }
    paramJSONObject.optInt("scrollLeft", 0);
    if (paramJSONObject.has("scrollX"))
    {
      bool = paramJSONObject.optBoolean("scrollX", true);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
      localWxaScrollView.setScrollHorizontal(bool);
    }
    if (paramJSONObject.has("scrollY"))
    {
      bool = paramJSONObject.optBoolean("scrollY", true);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
      localWxaScrollView.setScrollVertical(bool);
    }
    if (paramJSONObject.has("scrollTop"))
    {
      paramInt = h.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(paramInt) });
      localWxaScrollView.postDelayed(new d.2(this, localWxaScrollView, paramInt), 100L);
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.d
 * JD-Core Version:    0.7.0.1
 */