package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah.c;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertTextView";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137534);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137534);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137533);
    paramh = paramh.getContext();
    paramh = new CoverViewContainer(paramh, new com.tencent.mm.plugin.appbrand.widget.f(paramh));
    AppMethodBeat.o(137533);
    return paramh;
  }
  
  public final void a(final h paramh, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137535);
    Log.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.f localf = (com.tencent.mm.plugin.appbrand.widget.f)((CoverViewContainer)paramView).aT(com.tencent.mm.plugin.appbrand.widget.f.class);
    if (localf == null)
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
    c.a(localf, paramJSONObject.optJSONObject("label"));
    com.tencent.mm.plugin.appbrand.jsapi.ah.b.a(localf, paramJSONObject);
    com.tencent.mm.plugin.appbrand.jsapi.ah.f.b(paramView, paramJSONObject.optJSONObject("style"));
    final ad.b localb = paramh.ic(paramJSONObject.optBoolean("independent", false)).ac(paramInt, true);
    localb.q("data", str2);
    localb.q("sendTo", str1);
    localb.q("transEvt", Boolean.valueOf(bool1));
    localb.q("clickable", Boolean.valueOf(bool2));
    boolean bool5 = paramJSONObject.optBoolean("independent", false);
    bool1 = false;
    if (bool5)
    {
      i = paramJSONObject.optInt("parentId", 0);
      if (i != 0) {
        bool1 = paramh.ic(bool5).Ap(i);
      }
    }
    for (int i = paramh.ic(bool5).Aq(i);; i = -1)
    {
      Log.i("MicroMsg.JsApiInsertTextView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1) });
      if ((bool5) && ((bool1) || (bool4)))
      {
        Log.i("MicroMsg.JsApiInsertTextView", "CoverViewContainer setOnClickListener");
        if (bool2)
        {
          ((CoverViewContainer)paramView).ft(paramInt, i);
          ((CoverViewContainer)paramView).setIsInterceptEvent(true);
          ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(137531);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              Log.i("MicroMsg.JsApiInsertTextView", "onClick");
              paramAnonymousView = new i.a((byte)0);
              localObject = new HashMap();
              ((Map)localObject).put("data", localb.getString("data", ""));
              paramAnonymousView.L((Map)localObject);
              if ("webview".equals(localb.getString("sendTo", null))) {
                paramh.a(paramAnonymousView);
              }
              for (;;)
              {
                a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(137531);
                return;
                paramh.a(paramAnonymousView, null);
              }
            }
          });
        }
        ((CoverViewContainer)paramView).setDragEventCallback(new CoverViewContainer.a()
        {
          public final void a(String paramAnonymousString1, String paramAnonymousString2, JSONObject paramAnonymousJSONObject1, JSONObject paramAnonymousJSONObject2)
          {
            AppMethodBeat.i(327342);
            i.b localb = new i.b();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", paramAnonymousString2);
            localHashMap.put("stage", paramAnonymousString1);
            localHashMap.put("drag", paramAnonymousJSONObject1);
            localHashMap.put("target", paramAnonymousJSONObject2);
            localb.L(localHashMap);
            Log.i("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s， target:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject1, paramAnonymousString2, paramAnonymousJSONObject2 });
            if ("webview".equals(localb.getString("sendTo", null)))
            {
              paramh.a(localb);
              AppMethodBeat.o(327342);
              return;
            }
            paramh.a(localb, null);
            AppMethodBeat.o(327342);
          }
        });
      }
      for (;;)
      {
        if ((!bool2) && (bool3) && (!bool4))
        {
          paramView.setDuplicateParentStateEnabled(true);
          localf.setDuplicateParentStateEnabled(true);
          localf.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(327325);
              boolean bool = "webview".equals(localb.getString("sendTo", null));
              d.a(paramh, paramInt, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
              AppMethodBeat.o(327325);
              return true;
            }
          });
        }
        AppMethodBeat.o(137535);
        return;
        Log.i("MicroMsg.JsApiInsertTextView", "targetView setOnClickListener");
        localf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(327334);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (!localb.Jp("clickable"))
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(327334);
              return;
            }
            Log.i("MicroMsg.JsApiInsertTextView", "onClick");
            paramAnonymousView = new i.a((byte)0);
            localObject = new HashMap();
            ((Map)localObject).put("data", localb.getString("data", ""));
            paramAnonymousView.L((Map)localObject);
            if ("webview".equals(localb.getString("sendTo", null))) {
              paramh.a(paramAnonymousView);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertTextView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(327334);
              return;
              paramh.a(paramAnonymousView, null);
            }
          }
        });
        localf.setClickable(bool2);
      }
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 256;
    private static final String NAME = "onTextViewClick";
  }
  
  public static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 840;
    private static final String NAME = "onTextViewDrag";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.i
 * JD-Core Version:    0.7.0.1
 */