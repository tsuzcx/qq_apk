package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.c;
import com.tencent.mm.plugin.appbrand.jsapi.w.f;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends a
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137535);
    ac.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.e locale = (com.tencent.mm.plugin.appbrand.widget.e)((CoverViewContainer)paramView).ax(com.tencent.mm.plugin.appbrand.widget.e.class);
    if (locale == null)
    {
      ac.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137535);
      return;
    }
    boolean bool2 = paramJSONObject.optBoolean("clickable");
    boolean bool1 = paramJSONObject.optBoolean("transEvt");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    boolean bool4 = paramJSONObject.optBoolean("draggable", false);
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    c.a(locale, paramJSONObject.optJSONObject("label"));
    com.tencent.mm.plugin.appbrand.jsapi.w.b.a(locale, paramJSONObject);
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    final y.b localb = parame.fC(paramJSONObject.optBoolean("independent", false)).H(paramInt, true);
    localb.l("data", str2);
    localb.l("sendTo", str1);
    localb.l("transEvt", Boolean.valueOf(bool1));
    localb.l("clickable", Boolean.valueOf(bool2));
    boolean bool5 = paramJSONObject.optBoolean("independent", false);
    bool1 = false;
    if (bool5)
    {
      i = paramJSONObject.optInt("parentId", 0);
      if (i != 0) {
        bool1 = parame.fC(bool5).sh(i);
      }
    }
    for (int i = parame.fC(bool5).si(i);; i = -1)
    {
      ac.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      if ((bool5) && ((bool1) || (bool4)))
      {
        ac.i("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
        if (bool2)
        {
          ((CoverViewContainer)paramView).dN(paramInt, i);
          ((CoverViewContainer)paramView).setIsInterceptEvent(true);
          ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(137531);
              ac.i("MicroMsg.JsApiInsertTextView", "onClick");
              paramAnonymousView = new g.a((byte)0);
              HashMap localHashMap = new HashMap();
              localHashMap.put("data", localb.getString("data", ""));
              paramAnonymousView.B(localHashMap);
              if ("webview".equals(localb.getString("sendTo", null)))
              {
                parame.a(paramAnonymousView);
                AppMethodBeat.o(137531);
                return;
              }
              parame.b(paramAnonymousView);
              AppMethodBeat.o(137531);
            }
          });
        }
        ((CoverViewContainer)paramView).setDragEventCallback(new CoverViewContainer.a()
        {
          public final void b(String paramAnonymousString1, String paramAnonymousString2, JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(206799);
            g.b localb = new g.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", paramAnonymousString2);
            localHashMap.put("stage", paramAnonymousString1);
            localHashMap.put("drag", paramAnonymousJSONObject);
            localb.B(localHashMap);
            ac.i("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject, paramAnonymousString2 });
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              parame.a(localb);
              AppMethodBeat.o(206799);
              return;
            }
            parame.b(localb);
            AppMethodBeat.o(206799);
          }
        });
      }
      for (;;)
      {
        if ((!bool2) && (bool3) && (!bool4))
        {
          paramView.setDuplicateParentStateEnabled(true);
          locale.setDuplicateParentStateEnabled(true);
          locale.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(206801);
              boolean bool = "webview".equals(localb.getString("sendTo", null));
              b.a(parame, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
              AppMethodBeat.o(206801);
              return true;
            }
          });
        }
        AppMethodBeat.o(137535);
        return;
        ac.i("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
        locale.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(206800);
            if (!localb.xK("clickable"))
            {
              AppMethodBeat.o(206800);
              return;
            }
            ac.i("MicroMsg.JsApiInsertTextView", "onClick");
            paramAnonymousView = new g.a((byte)0);
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", localb.getString("data", ""));
            paramAnonymousView.B(localHashMap);
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              parame.a(paramAnonymousView);
              AppMethodBeat.o(206800);
              return;
            }
            parame.b(paramAnonymousView);
            AppMethodBeat.o(206800);
          }
        });
        locale.setClickable(bool2);
      }
    }
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 256;
    private static final String NAME = "onTextViewClick";
  }
  
  public static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 840;
    private static final String NAME = "onTextViewDrag";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.g
 * JD-Core Version:    0.7.0.1
 */