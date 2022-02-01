package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c;
import com.tencent.mm.plugin.appbrand.jsapi.aa.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
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
      parame = ((com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.widget.b.b.class)).dI(localContext);
    }
    paramJSONObject = parame;
    if (parame == null)
    {
      ae.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.b.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    parame = new CoverViewContainer(localContext, paramJSONObject.getView());
    AppMethodBeat.o(137523);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137525);
    ae.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.b.a locala = (com.tencent.mm.plugin.appbrand.widget.b.a)((CoverViewContainer)paramView).ax(com.tencent.mm.plugin.appbrand.widget.b.a.class);
    if (locala == null)
    {
      ae.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
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
    com.tencent.mm.plugin.appbrand.jsapi.aa.b.a(locala.getView(), paramJSONObject);
    final z.b localb = parame.fF(paramJSONObject.optBoolean("independent", false)).H(paramInt, true);
    localb.k("data", str2);
    localb.k("sendTo", str1);
    localb.k("transEvt", Boolean.valueOf(bool1));
    localb.k("clickable", Boolean.valueOf(bool2));
    boolean bool5 = paramJSONObject.optBoolean("independent", false);
    bool1 = false;
    if (bool5)
    {
      i = paramJSONObject.optInt("parentId", 0);
      if (i != 0) {
        bool1 = parame.fF(bool5).sM(i);
      }
    }
    for (int i = parame.fF(bool5).sN(i);; i = -1)
    {
      ae.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      if ((bool5) && ((bool1) || (bool4)))
      {
        ae.i("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
        if (bool2)
        {
          ((CoverViewContainer)paramView).dP(paramInt, i);
          ((CoverViewContainer)paramView).setIsInterceptEvent(true);
          ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(137521);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              ae.i("MicroMsg.JsApiInsertImageView", "onClick");
              paramAnonymousView = new e.a((byte)0);
              localObject = new HashMap();
              ((Map)localObject).put("data", localb.getString("data", ""));
              paramAnonymousView.I((Map)localObject);
              if ("webview".equals(localb.getString("sendTo", null))) {
                parame.a(paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137521);
                return;
                parame.b(paramAnonymousView);
              }
            }
          });
        }
        ((CoverViewContainer)paramView).setDragEventCallback(new CoverViewContainer.a()
        {
          public final void a(String paramAnonymousString1, String paramAnonymousString2, JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
          {
            AppMethodBeat.i(197225);
            g.b localb = new g.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", paramAnonymousString2);
            localHashMap.put("stage", paramAnonymousString1);
            localHashMap.put("drag", paramAnonymousJSONObject1);
            localHashMap.put("target", paramAnonymousJSONObject2);
            localb.I(localHashMap);
            ae.i("MicroMsg.JsApiInsertImageView", "callback stage:%s, drag:%s, data:%s, target:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject1, paramAnonymousString2, paramAnonymousJSONObject2 });
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              parame.a(localb);
              AppMethodBeat.o(197225);
              return;
            }
            parame.b(localb);
            AppMethodBeat.o(197225);
          }
        });
      }
      for (;;)
      {
        ae.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
        if ((!bool2) && (bool3) && (!bool4))
        {
          paramView.setDuplicateParentStateEnabled(true);
          locala.getView().setDuplicateParentStateEnabled(true);
          locala.getView().setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(197227);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
              boolean bool = "webview".equals(localb.getString("sendTo", null));
              b.a(parame, paramInt, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(197227);
              return true;
            }
          });
        }
        AppMethodBeat.o(137525);
        return;
        ae.i("MicroMsg.JsApiInsertImageView", "targetView setOnClickListener");
        locala.getView().setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(197226);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if (!localb.Bs("clickable"))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(197226);
              return;
            }
            paramAnonymousView = new e.a((byte)0);
            localObject = new HashMap();
            ((Map)localObject).put("data", localb.getString("data", ""));
            paramAnonymousView.I((Map)localObject);
            paramAnonymousView.h(parame);
            if ("webview".equals(localb.getString("sendTo", null))) {
              parame.a(paramAnonymousView);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(197226);
              return;
              parame.b(paramAnonymousView);
            }
          }
        });
        locala.getView().setClickable(bool2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e
 * JD-Core Version:    0.7.0.1
 */