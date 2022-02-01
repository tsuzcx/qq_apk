package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah.c;
import com.tencent.mm.plugin.appbrand.jsapi.ah.f;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertImageView";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137524);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137524);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137523);
    Context localContext = paramh.getContext();
    paramh = null;
    if (com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.widget.c.b.class) != null) {
      paramh = ((com.tencent.mm.plugin.appbrand.widget.c.b)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.widget.c.b.class)).eX(localContext);
    }
    paramJSONObject = paramh;
    if (paramh == null)
    {
      Log.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.c.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    paramh = new CoverViewContainer(localContext, paramJSONObject.getView());
    AppMethodBeat.o(137523);
    return paramh;
  }
  
  public final void a(final h paramh, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137525);
    Log.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.c.a locala = (com.tencent.mm.plugin.appbrand.widget.c.a)((CoverViewContainer)paramView).aT(com.tencent.mm.plugin.appbrand.widget.c.a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137525);
      return;
    }
    boolean bool3 = paramJSONObject.optBoolean("clickable");
    boolean bool4 = paramJSONObject.optBoolean("gesture");
    boolean bool5 = paramJSONObject.optBoolean("draggable", false);
    boolean bool1 = paramJSONObject.optBoolean("transEvt");
    String str1 = paramJSONObject.optString("sendTo", "appservice");
    String str2 = paramJSONObject.optString("data", "");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("style");
    final ad.b localb = paramh.ic(paramJSONObject.optBoolean("independent", false)).ac(paramInt, true);
    localb.q("data", str2);
    localb.q("sendTo", str1);
    localb.q("transEvt", Boolean.valueOf(bool1));
    localb.q("clickable", Boolean.valueOf(bool3));
    locala.setKeyValueSet(localb);
    f.b(paramView, localJSONObject);
    c.a(paramh, paramInt, locala, paramJSONObject, new b(paramInt, localb, paramh));
    com.tencent.mm.plugin.appbrand.jsapi.ah.b.a(locala.getView(), paramJSONObject);
    boolean bool6 = paramJSONObject.optBoolean("independent", false);
    bool1 = false;
    boolean bool2 = false;
    int i = -1;
    int j = i;
    if (bool6)
    {
      j = paramJSONObject.optInt("parentId", 0);
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = paramh.ic(bool6).Ap(j);
        i = paramh.ic(bool6).Aq(j);
      }
      localb.aY("sendTo", "appservice");
      j = i;
    }
    Log.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1) });
    if ((bool6) && ((bool1) || (bool5)))
    {
      Log.i("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
      if (bool3)
      {
        ((CoverViewContainer)paramView).ft(paramInt, j);
        ((CoverViewContainer)paramView).setIsInterceptEvent(true);
        ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(137521);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            Log.i("MicroMsg.JsApiInsertImageView", "onClick");
            paramAnonymousView = new g.a((byte)0);
            localObject = new HashMap();
            ((Map)localObject).put("data", localb.getString("data", ""));
            paramAnonymousView.L((Map)localObject);
            if ("webview".equals(localb.getString("sendTo", null))) {
              paramh.a(paramAnonymousView);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(137521);
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
          AppMethodBeat.i(327301);
          i.b localb = new i.b();
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", paramAnonymousString2);
          localHashMap.put("stage", paramAnonymousString1);
          localHashMap.put("drag", paramAnonymousJSONObject1);
          localHashMap.put("target", paramAnonymousJSONObject2);
          localb.L(localHashMap);
          Log.i("MicroMsg.JsApiInsertImageView", "callback stage:%s, drag:%s, data:%s, target:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject1, paramAnonymousString2, paramAnonymousJSONObject2 });
          if ("webview".equals(localb.getString("sendTo", null)))
          {
            paramh.a(localb);
            AppMethodBeat.o(327301);
            return;
          }
          paramh.a(localb, null);
          AppMethodBeat.o(327301);
        }
      });
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) });
      if ((!bool3) && (bool4) && (!bool5))
      {
        paramView.setDuplicateParentStateEnabled(true);
        locala.getView().setDuplicateParentStateEnabled(true);
        locala.getView().setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(327296);
            boolean bool = "webview".equals(localb.getString("sendTo", null));
            d.a(paramh, paramInt, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
            AppMethodBeat.o(327296);
            return true;
          }
        });
      }
      AppMethodBeat.o(137525);
      return;
      Log.i("MicroMsg.JsApiInsertImageView", "targetView setOnClickListener");
      locala.getView().setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(327299);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (!localb.Jp("clickable"))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(327299);
            return;
          }
          paramAnonymousView = new g.a((byte)0);
          localObject = new HashMap();
          ((Map)localObject).put("data", localb.getString("data", ""));
          paramAnonymousView.L((Map)localObject);
          paramAnonymousView.i(paramh);
          if ("webview".equals(localb.getString("sendTo", null))) {
            paramh.a(paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(327299);
            return;
            paramh.a(paramAnonymousView, null);
          }
        }
      });
      locala.getView().setClickable(bool3);
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 256;
    private static final String NAME = "onImageViewClick";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.g
 * JD-Core Version:    0.7.0.1
 */