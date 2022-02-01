package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  private static final int CTRL_INDEX = 446;
  public static final String NAME = "insertScrollView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137529);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137529);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137528);
    parame = new WxaScrollView(parame.getContext());
    AppMethodBeat.o(137528);
    return parame;
  }
  
  public final void a(final e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137530);
    ac.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    final WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    boolean bool1 = paramJSONObject.optBoolean("needScrollEvent");
    String str = paramJSONObject.optString("data", "");
    com.tencent.mm.plugin.appbrand.jsapi.w.f.b(paramView, paramJSONObject.optJSONObject("style"));
    final boolean bool2 = paramJSONObject.optBoolean("independent", false);
    parame.fC(bool2).H(paramInt, true).l("data", str);
    if (bool1) {
      localWxaScrollView.setOnScrollChangedListener(new q()
      {
        public final void p(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(137526);
          if (!(paramAnonymousView instanceof WxaScrollView))
          {
            AppMethodBeat.o(137526);
            return;
          }
          Object localObject = parame.fC(bool2).H(paramInt, false);
          if (localObject == null)
          {
            AppMethodBeat.o(137526);
            return;
          }
          localObject = ((y.b)localObject).getString("data", null);
          if (localObject == null)
          {
            AppMethodBeat.o(137526);
            return;
          }
          paramAnonymousView = ((WxaScrollView)paramAnonymousView).getTargetView();
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", localObject);
          localHashMap.put("scrollLeft", Integer.valueOf(g.vd(paramAnonymousInt1)));
          localHashMap.put("scrollTop", Integer.valueOf(g.vd(paramAnonymousInt2)));
          localHashMap.put("scrollWidth", Integer.valueOf(g.vd(paramAnonymousView.getWidth())));
          localHashMap.put("scrollHeight", Integer.valueOf(g.vd(paramAnonymousView.getHeight())));
          paramAnonymousView = new p().B(localHashMap);
          parame.b(paramAnonymousView);
          AppMethodBeat.o(137526);
        }
      });
    }
    paramJSONObject.optInt("scrollLeft", 0);
    if (paramJSONObject.has("scrollX"))
    {
      bool1 = paramJSONObject.optBoolean("scrollX", true);
      ac.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool1) });
      localWxaScrollView.setScrollHorizontal(bool1);
    }
    if (paramJSONObject.has("scrollY"))
    {
      bool1 = paramJSONObject.optBoolean("scrollY", true);
      ac.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool1) });
      localWxaScrollView.setScrollVertical(bool1);
    }
    if (paramJSONObject.has("scrollTop"))
    {
      paramInt = g.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
      ac.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(paramInt) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.f
 * JD-Core Version:    0.7.0.1
 */