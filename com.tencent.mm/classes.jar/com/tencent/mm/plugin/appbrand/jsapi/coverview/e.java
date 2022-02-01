package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.w.c;
import com.tencent.mm.plugin.appbrand.jsapi.w.f;
import com.tencent.mm.sdk.platformtools.ac;
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
      parame = ((com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.widget.b.b.class)).dG(localContext);
    }
    paramJSONObject = parame;
    if (parame == null)
    {
      ac.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.b.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    parame = new CoverViewContainer(localContext, paramJSONObject.getView());
    AppMethodBeat.o(137523);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137525);
    ac.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.b.a locala = (com.tencent.mm.plugin.appbrand.widget.b.a)((CoverViewContainer)paramView).ax(com.tencent.mm.plugin.appbrand.widget.b.a.class);
    if (locala == null)
    {
      ac.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137525);
      return;
    }
    boolean bool2 = paramJSONObject.optBoolean("clickable");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    boolean bool4 = paramJSONObject.optBoolean("draggable", false);
    boolean bool1 = paramJSONObject.optBoolean("transEvt");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    c.a(parame, locala, paramJSONObject);
    com.tencent.mm.plugin.appbrand.jsapi.w.b.a(locala.getView(), paramJSONObject);
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
      ac.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      if ((bool5) && ((bool1) || (bool4)))
      {
        ac.i("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
        if (bool2)
        {
          ((CoverViewContainer)paramView).dN(paramInt, i);
          ((CoverViewContainer)paramView).setIsInterceptEvent(true);
          ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(137521);
              ac.i("MicroMsg.JsApiInsertImageView", "onClick");
              paramAnonymousView = new e.a((byte)0);
              HashMap localHashMap = new HashMap();
              localHashMap.put("data", localb.getString("data", ""));
              paramAnonymousView.B(localHashMap);
              if ("webview".equals(localb.getString("sendTo", null)))
              {
                parame.a(paramAnonymousView);
                AppMethodBeat.o(137521);
                return;
              }
              parame.b(paramAnonymousView);
              AppMethodBeat.o(137521);
            }
          });
        }
        ((CoverViewContainer)paramView).setDragEventCallback(new CoverViewContainer.a()
        {
          public final void b(String paramAnonymousString1, String paramAnonymousString2, JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(206796);
            g.b localb = new g.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", paramAnonymousString2);
            localHashMap.put("stage", paramAnonymousString1);
            localHashMap.put("drag", paramAnonymousJSONObject);
            localb.B(localHashMap);
            ac.i("MicroMsg.JsApiInsertImageView", "callback stage:%s, drag:%s, data:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject, paramAnonymousString2 });
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              parame.a(localb);
              AppMethodBeat.o(206796);
              return;
            }
            parame.b(localb);
            AppMethodBeat.o(206796);
          }
        });
      }
      for (;;)
      {
        ac.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((!bool2) && (bool3) && (!bool4))
        {
          paramView.setDuplicateParentStateEnabled(true);
          locala.getView().setDuplicateParentStateEnabled(true);
          locala.getView().setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(206798);
              boolean bool = "webview".equals(localb.getString("sendTo", null));
              b.a(parame, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
              AppMethodBeat.o(206798);
              return true;
            }
          });
        }
        AppMethodBeat.o(137525);
        return;
        ac.i("MicroMsg.JsApiInsertImageView", "targetView setOnClickListener");
        locala.getView().setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(206797);
            if (!localb.xK("clickable"))
            {
              AppMethodBeat.o(206797);
              return;
            }
            paramAnonymousView = new e.a((byte)0);
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", localb.getString("data", ""));
            paramAnonymousView.B(localHashMap);
            paramAnonymousView.h(parame);
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              parame.a(paramAnonymousView);
              AppMethodBeat.o(206797);
              return;
            }
            parame.b(paramAnonymousView);
            AppMethodBeat.o(206797);
          }
        });
        locala.getView().setClickable(bool2);
      }
    }
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 256;
    private static final String NAME = "onImageViewClick";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e
 * JD-Core Version:    0.7.0.1
 */