package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertImageView";
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126295);
    Context localContext = parame.getContext();
    parame = null;
    if (com.tencent.luggage.a.e.q(com.tencent.mm.plugin.appbrand.widget.c.b.class) != null) {
      parame = ((com.tencent.mm.plugin.appbrand.widget.c.b)com.tencent.luggage.a.e.q(com.tencent.mm.plugin.appbrand.widget.c.b.class)).cW(localContext);
    }
    paramJSONObject = parame;
    if (parame == null)
    {
      ab.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.c.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    parame = new CoverViewContainer(localContext, paramJSONObject.getView());
    AppMethodBeat.o(126295);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126297);
    ab.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.c.a locala = (com.tencent.mm.plugin.appbrand.widget.c.a)((CoverViewContainer)paramView).aa(com.tencent.mm.plugin.appbrand.widget.c.a.class);
    if (locala == null)
    {
      ab.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126297);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("clickable");
    boolean bool2 = paramJSONObject.optBoolean("gesture");
    boolean bool3 = paramJSONObject.optBoolean("transEvt");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    com.tencent.mm.plugin.appbrand.jsapi.s.e.b(paramView, paramJSONObject.optJSONObject("style"));
    com.tencent.mm.plugin.appbrand.jsapi.s.b.a(parame, locala, paramJSONObject);
    com.tencent.mm.plugin.appbrand.jsapi.s.a.a(locala.getView(), paramJSONObject);
    paramJSONObject = parame.vC().J(paramInt, true);
    paramJSONObject.i("data", str2);
    paramJSONObject.i("sendTo", str1);
    paramJSONObject.i("transEvt", Boolean.valueOf(bool3));
    paramJSONObject.i("clickable", Boolean.valueOf(bool1));
    locala.getView().setOnClickListener(new c.1(this, paramJSONObject, parame));
    locala.getView().setClickable(bool1);
    ab.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) && (bool2))
    {
      paramView.setDuplicateParentStateEnabled(true);
      locala.getView().setDuplicateParentStateEnabled(true);
      locala.getView().setOnTouchListener(new c.2(this, paramJSONObject, parame));
    }
    AppMethodBeat.o(126297);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126296);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126296);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c
 * JD-Core Version:    0.7.0.1
 */