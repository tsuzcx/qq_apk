package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertTextView";
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126305);
    parame = parame.getContext();
    parame = new CoverViewContainer(parame, new com.tencent.mm.plugin.appbrand.widget.e(parame));
    AppMethodBeat.o(126305);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126307);
    ab.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.e locale = (com.tencent.mm.plugin.appbrand.widget.e)((CoverViewContainer)paramView).aa(com.tencent.mm.plugin.appbrand.widget.e.class);
    if (locale == null)
    {
      ab.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126307);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("clickable");
    boolean bool2 = paramJSONObject.optBoolean("transEvt");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    b.a(locale, paramJSONObject.optJSONObject("label"));
    com.tencent.mm.plugin.appbrand.jsapi.s.a.a(locale, paramJSONObject);
    com.tencent.mm.plugin.appbrand.jsapi.s.e.b(paramView, paramJSONObject.optJSONObject("style"));
    paramJSONObject = parame.vC().J(paramInt, true);
    paramJSONObject.i("data", str2);
    paramJSONObject.i("sendTo", str1);
    paramJSONObject.i("transEvt", Boolean.valueOf(bool2));
    paramJSONObject.i("clickable", Boolean.valueOf(bool1));
    locale.setOnClickListener(new e.1(this, paramJSONObject, parame));
    locale.setClickable(bool1);
    ab.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    if ((!bool1) && (bool3))
    {
      paramView.setDuplicateParentStateEnabled(true);
      locale.setDuplicateParentStateEnabled(true);
      locale.setOnTouchListener(new e.2(this, paramJSONObject, parame));
    }
    AppMethodBeat.o(126307);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126306);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126306);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e
 * JD-Core Version:    0.7.0.1
 */