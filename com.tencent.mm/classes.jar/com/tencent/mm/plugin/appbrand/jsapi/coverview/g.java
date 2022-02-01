package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c;
import com.tencent.mm.plugin.appbrand.jsapi.ae.f;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 253;
  public static final String NAME = "insertImageView";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137524);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137524);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137523);
    Context localContext = paramg.getContext();
    paramg = null;
    if (com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.widget.b.b.class) != null) {
      paramg = ((com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.widget.b.b.class)).ec(localContext);
    }
    paramJSONObject = paramg;
    if (paramg == null)
    {
      Log.e("MicroMsg.JsApiInsertImageView", "view is null, may not support IGifCoverViewFactory.");
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.b.e(localContext);
    }
    paramJSONObject.setScaleType(ImageView.ScaleType.FIT_XY);
    paramg = new CoverViewContainer(localContext, paramJSONObject.getView());
    AppMethodBeat.o(137523);
    return paramg;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.g paramg, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137525);
    Log.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    com.tencent.mm.plugin.appbrand.widget.b.a locala = (com.tencent.mm.plugin.appbrand.widget.b.a)((CoverViewContainer)paramView).aA(com.tencent.mm.plugin.appbrand.widget.b.a.class);
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
    final ad.b localb = paramg.hl(paramJSONObject.optBoolean("independent", false)).N(paramInt, true);
    localb.k("data", str2);
    localb.k("sendTo", str1);
    localb.k("transEvt", Boolean.valueOf(bool1));
    localb.k("clickable", Boolean.valueOf(bool3));
    locala.setKeyValueSet(localb);
    f.b(paramView, localJSONObject);
    c.a(paramg, paramInt, locala, paramJSONObject, new b(paramInt, localb, paramg));
    com.tencent.mm.plugin.appbrand.jsapi.ae.b.a(locala.getView(), paramJSONObject);
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
        bool1 = paramg.hl(bool6).zX(j);
        i = paramg.hl(bool6).zY(j);
      }
      localb.aO("sendTo", "appservice");
      j = i;
    }
    Log.i("MicroMsg.JsApiInsertImageView", "clickable:%b, gesture:%b, draggable:%b， independent:%b, isParentCanDrag:%b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1) });
    if ((bool6) && ((bool1) || (bool5)))
    {
      Log.i("MicroMsg.JsApiInsertImageView", "CoverViewContainer setOnClickListener");
      if (bool3)
      {
        ((CoverViewContainer)paramView).ez(paramInt, j);
        ((CoverViewContainer)paramView).setIsInterceptEvent(true);
        ((CoverViewContainer)paramView).setOnCustomerClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(137521);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            Log.i("MicroMsg.JsApiInsertImageView", "onClick");
            paramAnonymousView = new g.a((byte)0);
            localObject = new HashMap();
            ((Map)localObject).put("data", localb.getString("data", ""));
            paramAnonymousView.E((Map)localObject);
            if ("webview".equals(localb.getString("sendTo", null))) {
              paramg.a(paramAnonymousView);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(137521);
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
          AppMethodBeat.i(206091);
          i.b localb = new i.b();
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", paramAnonymousString2);
          localHashMap.put("stage", paramAnonymousString1);
          localHashMap.put("drag", paramAnonymousJSONObject1);
          localHashMap.put("target", paramAnonymousJSONObject2);
          localb.E(localHashMap);
          Log.i("MicroMsg.JsApiInsertImageView", "callback stage:%s, drag:%s, data:%s, target:%s", new Object[] { paramAnonymousString1, paramAnonymousJSONObject1, paramAnonymousString2, paramAnonymousJSONObject2 });
          if ("webview".equals(localb.getString("sendTo", null)))
          {
            paramg.a(localb);
            AppMethodBeat.o(206091);
            return;
          }
          paramg.a(localb, null);
          AppMethodBeat.o(206091);
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
            AppMethodBeat.i(206604);
            boolean bool = "webview".equals(localb.getString("sendTo", null));
            d.a(paramg, paramInt, paramAnonymousMotionEvent, localb.getString("data", ""), bool);
            AppMethodBeat.o(206604);
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
          AppMethodBeat.i(206184);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (!localb.Rq("clickable"))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(206184);
            return;
          }
          paramAnonymousView = new g.a((byte)0);
          localObject = new HashMap();
          ((Map)localObject).put("data", localb.getString("data", ""));
          paramAnonymousView.E((Map)localObject);
          paramAnonymousView.j(paramg);
          if ("webview".equals(localb.getString("sendTo", null))) {
            paramg.a(paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/coverview/JsApiInsertImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(206184);
            return;
            paramg.a(paramAnonymousView, null);
          }
        }
      });
      locala.getView().setClickable(bool3);
    }
  }
  
  static final class a
    extends az
  {
    private static final int CTRL_INDEX = 256;
    private static final String NAME = "onImageViewClick";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.g
 * JD-Core Version:    0.7.0.1
 */