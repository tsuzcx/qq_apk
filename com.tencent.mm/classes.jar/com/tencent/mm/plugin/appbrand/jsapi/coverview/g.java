package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.c;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
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
    boolean bool2 = paramJSONObject.optBoolean("clickable");
    boolean bool1 = paramJSONObject.optBoolean("transEvt");
    boolean bool3 = paramJSONObject.optBoolean("gesture");
    boolean bool4 = paramJSONObject.optBoolean("draggable", false);
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    c.a(locale, paramJSONObject.optJSONObject("label"));
    com.tencent.mm.plugin.appbrand.jsapi.z.b.a(locale, paramJSONObject);
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    final y.b localb = parame.fG(paramJSONObject.optBoolean("independent", false)).H(paramInt, true);
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
        bool1 = parame.fG(bool5).sJ(i);
      }
    }
    for (int i = parame.fG(bool5).sK(i);; i = -1)
    {
      ad.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      if ((bool5) && ((bool1) || (bool4)))
      {
        ad.i("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
        if (bool2)
        {
          ((CoverViewContainer)paramView).dP(paramInt, i);
          ((CoverViewContainer)paramView).setIsInterceptEvent(true);
          ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(137531);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              ad.i("MicroMsg.JsApiInsertTextView", "onClick");
              paramAnonymousView = new g.a((byte)0);
              localObject = new HashMap();
              ((Map)localObject).put("data", localb.getString("data", ""));
              paramAnonymousView.B((Map)localObject);
              if ("webview".equals(localb.getString("sendTo", null))) {
                parame.a(paramAnonymousView);
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137531);
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
            AppMethodBeat.i(195005);
            g.b localb = new g.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", paramAnonymousString2);
            localHashMap.put("stage", paramAnonymousString1);
            localHashMap.put("drag", paramAnonymousJSONObject1);
            localHashMap.put("target", paramAnonymousJSONObject2);
            localb.B(localHashMap);
            ad.i("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s， target:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject1, paramAnonymousString2, paramAnonymousJSONObject2 });
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              parame.a(localb);
              AppMethodBeat.o(195005);
              return;
            }
            parame.b(localb);
            AppMethodBeat.o(195005);
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
              AppMethodBeat.i(195007);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
              boolean bool = "webview".equals(localb.getString("sendTo", null));
              b.a(parame, paramInt, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
              a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(195007);
              return true;
            }
          });
        }
        AppMethodBeat.o(137535);
        return;
        ad.i("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
        locale.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(195006);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if (!localb.AI("clickable"))
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(195006);
              return;
            }
            ad.i("MicroMsg.JsApiInsertTextView", "onClick");
            paramAnonymousView = new g.a((byte)0);
            localObject = new HashMap();
            ((Map)localObject).put("data", localb.getString("data", ""));
            paramAnonymousView.B((Map)localObject);
            if ("webview".equals(localb.getString("sendTo", null))) {
              parame.a(paramAnonymousView);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(195006);
              return;
              parame.b(paramAnonymousView);
            }
          }
        });
        locale.setClickable(bool2);
      }
    }
  }
  
  public static final class b
    extends at
  {
    private static final int CTRL_INDEX = 840;
    private static final String NAME = "onTextViewDrag";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.g
 * JD-Core Version:    0.7.0.1
 */