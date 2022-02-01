package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends b
{
  private static final int CTRL_INDEX = 446;
  public static final String NAME = "insertScrollView";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137529);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137529);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137528);
    paramg = new WxaScrollView(paramg.getContext());
    AppMethodBeat.o(137528);
    return paramg;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.g paramg, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137530);
    Log.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    final WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    boolean bool1 = paramJSONObject.optBoolean("needScrollEvent");
    String str = paramJSONObject.optString("data", "");
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    final boolean bool2 = paramJSONObject.optBoolean("independent", false);
    paramg.hl(bool2).N(paramInt, true).k("data", str);
    if (bool1) {
      localWxaScrollView.setOnScrollChangedListener(new t()
      {
        public final void p(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(137526);
          if (!(paramAnonymousView instanceof WxaScrollView))
          {
            AppMethodBeat.o(137526);
            return;
          }
          Object localObject = paramg.hl(bool2).N(paramInt, false);
          if (localObject == null)
          {
            AppMethodBeat.o(137526);
            return;
          }
          localObject = ((ad.b)localObject).getString("data", null);
          if (localObject == null)
          {
            AppMethodBeat.o(137526);
            return;
          }
          paramAnonymousView = ((WxaScrollView)paramAnonymousView).getTargetView();
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", localObject);
          localHashMap.put("scrollLeft", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dh(paramAnonymousInt1)));
          localHashMap.put("scrollTop", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dh(paramAnonymousInt2)));
          localHashMap.put("scrollWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dh(paramAnonymousView.getWidth())));
          localHashMap.put("scrollHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.Dh(paramAnonymousView.getHeight())));
          paramAnonymousView = new s().E(localHashMap);
          paramg.a(paramAnonymousView, null);
          AppMethodBeat.o(137526);
        }
      });
    }
    paramJSONObject.optInt("scrollLeft", 0);
    if (paramJSONObject.has("scrollX"))
    {
      bool1 = paramJSONObject.optBoolean("scrollX", true);
      Log.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool1) });
      localWxaScrollView.setScrollHorizontal(bool1);
    }
    if (paramJSONObject.has("scrollY"))
    {
      bool1 = paramJSONObject.optBoolean("scrollY", true);
      Log.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool1) });
      localWxaScrollView.setScrollVertical(bool1);
    }
    if (paramJSONObject.has("scrollTop"))
    {
      paramInt = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
      Log.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(paramInt) });
      localWxaScrollView.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137527);
          localWxaScrollView.scrollTo(localWxaScrollView.getScrollX(), paramInt);
          AppMethodBeat.o(137527);
        }
      }, 100L);
    }
    AppMethodBeat.o(137530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.h
 * JD-Core Version:    0.7.0.1
 */