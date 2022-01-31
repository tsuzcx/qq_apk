package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.widget.f;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertTextView";
  
  protected final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    parame = parame.getContext();
    return new CoverViewContainer(parame, new f(parame));
  }
  
  protected final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    f localf = (f)((CoverViewContainer)paramView).K(f.class);
    if (localf == null) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
    }
    boolean bool1;
    boolean bool3;
    do
    {
      return;
      bool1 = paramJSONObject.optBoolean("clickable");
      boolean bool2 = paramJSONObject.optBoolean("transEvt");
      bool3 = paramJSONObject.optBoolean("gesture");
      String str1 = paramJSONObject.optString("sendTo", "appservice");
      String str2 = paramJSONObject.optString("data", "");
      com.tencent.mm.plugin.appbrand.jsapi.s.a.a(localf, paramJSONObject.optJSONObject("label"));
      d.a(paramView, paramJSONObject.optJSONObject("style"));
      paramView = parame.agW().F(paramInt, true);
      paramView.h("data", str2);
      paramView.h("sendTo", str1);
      paramView.h("transEvt", Boolean.valueOf(bool2));
      paramView.h("clickable", Boolean.valueOf(bool1));
      localf.setOnClickListener(new e.1(this, paramView, parame));
      localf.setClickable(bool1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    } while ((bool1) || (!bool3));
    localf.setOnTouchListener(new e.2(this, paramView, parame));
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e
 * JD-Core Version:    0.7.0.1
 */