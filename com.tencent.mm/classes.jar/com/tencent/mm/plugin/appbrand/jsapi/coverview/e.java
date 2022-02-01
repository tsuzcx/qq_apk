package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertImageView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137524);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137524);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137523);
    Context localContext = parame.getContext();
    parame = null;
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.widget.b.b.class) != null) {
      parame = ((com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.widget.b.b.class)).dx(localContext);
    }
    paramJSONObject = parame;
    if (parame == null)
    {
      ad.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.b.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    parame = new CoverViewContainer(localContext, paramJSONObject.getView());
    AppMethodBeat.o(137523);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137525);
    ad.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.b.a locala = (com.tencent.mm.plugin.appbrand.widget.b.a)((CoverViewContainer)paramView).ax(com.tencent.mm.plugin.appbrand.widget.b.a.class);
    if (locala == null)
    {
      ad.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137525);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("clickable");
    boolean bool2 = paramJSONObject.optBoolean("gesture");
    boolean bool3 = paramJSONObject.optBoolean("transEvt");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    com.tencent.mm.plugin.appbrand.jsapi.x.e.b(paramView, paramJSONObject.optJSONObject("style"));
    com.tencent.mm.plugin.appbrand.jsapi.x.b.a(parame, locala, paramJSONObject);
    com.tencent.mm.plugin.appbrand.jsapi.x.a.a(locala.getView(), paramJSONObject);
    paramJSONObject = parame.aOg().H(paramInt, true);
    paramJSONObject.m("data", str2);
    paramJSONObject.m("sendTo", str1);
    paramJSONObject.m("transEvt", Boolean.valueOf(bool3));
    paramJSONObject.m("clickable", Boolean.valueOf(bool1));
    locala.getView().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137521);
        if (!paramJSONObject.tE("clickable"))
        {
          AppMethodBeat.o(137521);
          return;
        }
        paramAnonymousView = new e.a((byte)0);
        HashMap localHashMap = new HashMap();
        localHashMap.put("data", paramJSONObject.getString("data", ""));
        paramAnonymousView.C(localHashMap);
        paramAnonymousView.h(parame);
        if ("webview".equals(paramJSONObject.getString("sendTo", null)))
        {
          parame.a(paramAnonymousView);
          AppMethodBeat.o(137521);
          return;
        }
        parame.b(paramAnonymousView);
        AppMethodBeat.o(137521);
      }
    });
    locala.getView().setClickable(bool1);
    ad.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((!bool1) && (bool2))
    {
      paramView.setDuplicateParentStateEnabled(true);
      locala.getView().setDuplicateParentStateEnabled(true);
      locala.getView().setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(137522);
          boolean bool = "webview".equals(paramJSONObject.getString("sendTo", null));
          b.a(parame, paramAnonymousMotionEvent, paramJSONObject.getString("data", ""), bool);
          AppMethodBeat.o(137522);
          return true;
        }
      });
    }
    AppMethodBeat.o(137525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e
 * JD-Core Version:    0.7.0.1
 */