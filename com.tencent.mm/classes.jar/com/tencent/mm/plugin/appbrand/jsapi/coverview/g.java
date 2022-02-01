package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertTextView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137534);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137534);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137533);
    parame = parame.getContext();
    parame = new CoverViewContainer(parame, new com.tencent.mm.plugin.appbrand.widget.e(parame));
    AppMethodBeat.o(137533);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137535);
    ad.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.e locale = (com.tencent.mm.plugin.appbrand.widget.e)((CoverViewContainer)paramView).ax(com.tencent.mm.plugin.appbrand.widget.e.class);
    if (locale == null)
    {
      ad.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137535);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("clickable");
    boolean bool2 = paramJSONObject.optBoolean("transEvt");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    com.tencent.mm.plugin.appbrand.jsapi.x.b.a(locale, paramJSONObject.optJSONObject("label"));
    com.tencent.mm.plugin.appbrand.jsapi.x.a.a(locale, paramJSONObject);
    com.tencent.mm.plugin.appbrand.jsapi.x.e.b(paramView, paramJSONObject.optJSONObject("style"));
    paramJSONObject = parame.aOg().H(paramInt, true);
    paramJSONObject.m("data", str2);
    paramJSONObject.m("sendTo", str1);
    paramJSONObject.m("transEvt", Boolean.valueOf(bool2));
    paramJSONObject.m("clickable", Boolean.valueOf(bool1));
    locale.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137531);
        if (!paramJSONObject.tE("clickable"))
        {
          AppMethodBeat.o(137531);
          return;
        }
        paramAnonymousView = new g.a((byte)0);
        HashMap localHashMap = new HashMap();
        localHashMap.put("data", paramJSONObject.getString("data", ""));
        paramAnonymousView.C(localHashMap);
        if ("webview".equals(paramJSONObject.getString("sendTo", null)))
        {
          parame.a(paramAnonymousView);
          AppMethodBeat.o(137531);
          return;
        }
        parame.b(paramAnonymousView);
        AppMethodBeat.o(137531);
      }
    });
    locale.setClickable(bool1);
    ad.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    if ((!bool1) && (bool3))
    {
      paramView.setDuplicateParentStateEnabled(true);
      locale.setDuplicateParentStateEnabled(true);
      locale.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(137532);
          boolean bool = "webview".equals(paramJSONObject.getString("sendTo", null));
          b.a(parame, paramAnonymousMotionEvent, paramJSONObject.getString("data", ""), bool);
          AppMethodBeat.o(137532);
          return true;
        }
      });
    }
    AppMethodBeat.o(137535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.g
 * JD-Core Version:    0.7.0.1
 */