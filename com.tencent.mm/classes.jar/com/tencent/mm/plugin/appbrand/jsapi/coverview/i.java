package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c;
import com.tencent.mm.plugin.appbrand.jsapi.ae.f;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertTextView";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137534);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137534);
    return i;
  }
  
  public final View a(g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137533);
    paramg = paramg.getContext();
    paramg = new CoverViewContainer(paramg, new e(paramg));
    AppMethodBeat.o(137533);
    return paramg;
  }
  
  public final void a(final g paramg, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137535);
    Log.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    e locale = (e)((CoverViewContainer)paramView).aA(e.class);
    if (locale == null)
    {
      Log.w("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
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
    com.tencent.mm.plugin.appbrand.jsapi.ae.b.a(locale, paramJSONObject);
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    final ad.b localb = paramg.hl(paramJSONObject.optBoolean("independent", false)).N(paramInt, true);
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
        bool1 = paramg.hl(bool5).zX(i);
      }
    }
    for (int i = paramg.hl(bool5).zY(i);; i = -1)
    {
      Log.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      if ((bool5) && ((bool1) || (bool4)))
      {
        Log.i("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
        if (bool2)
        {
          ((CoverViewContainer)paramView).ez(paramInt, i);
          ((CoverViewContainer)paramView).setIsInterceptEvent(true);
          ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(137531);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              Log.i("MicroMsg.JsApiInsertTextView", "onClick");
              paramAnonymousView = new i.a((byte)0);
              localObject = new HashMap();
              ((Map)localObject).put("data", localb.getString("data", ""));
              paramAnonymousView.E((Map)localObject);
              if ("webview".equals(localb.getString("sendTo", null))) {
                paramg.a(paramAnonymousView);
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137531);
                return;
                paramg.a(paramAnonymousView, null);
              }
            }
          });
        }
        ((CoverViewContainer)paramView).setDragEventCallback(new CoverViewContainer.a()
        {
          public final void a(String paramAnonymousString1, String paramAnonymousString2, JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
          {
            AppMethodBeat.i(206756);
            i.b localb = new i.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", paramAnonymousString2);
            localHashMap.put("stage", paramAnonymousString1);
            localHashMap.put("drag", paramAnonymousJSONObject1);
            localHashMap.put("target", paramAnonymousJSONObject2);
            localb.E(localHashMap);
            Log.i("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s， target:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject1, paramAnonymousString2, paramAnonymousJSONObject2 });
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              paramg.a(localb);
              AppMethodBeat.o(206756);
              return;
            }
            paramg.a(localb, null);
            AppMethodBeat.o(206756);
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
              AppMethodBeat.i(205603);
              boolean bool = "webview".equals(localb.getString("sendTo", null));
              d.a(paramg, paramInt, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
              AppMethodBeat.o(205603);
              return true;
            }
          });
        }
        AppMethodBeat.o(137535);
        return;
        Log.i("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
        locale.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(205645);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (!localb.Rq("clickable"))
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(205645);
              return;
            }
            Log.i("MicroMsg.JsApiInsertTextView", "onClick");
            paramAnonymousView = new i.a((byte)0);
            localObject = new HashMap();
            ((Map)localObject).put("data", localb.getString("data", ""));
            paramAnonymousView.E((Map)localObject);
            if ("webview".equals(localb.getString("sendTo", null))) {
              paramg.a(paramAnonymousView);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(205645);
              return;
              paramg.a(paramAnonymousView, null);
            }
          }
        });
        locale.setClickable(bool2);
      }
    }
  }
  
  static final class a
    extends az
  {
    private static final int CTRL_INDEX = 256;
    private static final String NAME = "onTextViewClick";
  }
  
  public static final class b
    extends az
  {
    private static final int CTRL_INDEX = 840;
    private static final String NAME = "onTextViewDrag";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.i
 * JD-Core Version:    0.7.0.1
 */