package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  private static final int CTRL_INDEX = 446;
  public static final String NAME = "insertScrollView";
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126300);
    parame = new WxaScrollView(parame.getContext());
    AppMethodBeat.o(126300);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126302);
    ab.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    boolean bool = paramJSONObject.optBoolean("needScrollEvent");
    String str = paramJSONObject.optString("data", "");
    com.tencent.mm.plugin.appbrand.jsapi.s.e.b(paramView, paramJSONObject.optJSONObject("style"));
    parame.vC().J(paramInt, true).i("data", str);
    if (bool) {
      localWxaScrollView.setOnScrollChangedListener(new m()
      {
        public final void q(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(126298);
          if (!(paramAnonymousView instanceof WxaScrollView))
          {
            AppMethodBeat.o(126298);
            return;
          }
          Object localObject = parame.vC().J(paramInt, false);
          if (localObject == null)
          {
            AppMethodBeat.o(126298);
            return;
          }
          localObject = ((v.b)localObject).getString("data", null);
          if (localObject == null)
          {
            AppMethodBeat.o(126298);
            return;
          }
          paramAnonymousView = ((WxaScrollView)paramAnonymousView).getTargetView();
          HashMap localHashMap = new HashMap();
          localHashMap.put("data", localObject);
          localHashMap.put("scrollLeft", Integer.valueOf(g.pN(paramAnonymousInt1)));
          localHashMap.put("scrollTop", Integer.valueOf(g.pN(paramAnonymousInt2)));
          localHashMap.put("scrollWidth", Integer.valueOf(g.pN(paramAnonymousView.getWidth())));
          localHashMap.put("scrollHeight", Integer.valueOf(g.pN(paramAnonymousView.getHeight())));
          paramAnonymousView = new l().x(localHashMap);
          parame.b(paramAnonymousView);
          AppMethodBeat.o(126298);
        }
      });
    }
    paramJSONObject.optInt("scrollLeft", 0);
    if (paramJSONObject.has("scrollX"))
    {
      bool = paramJSONObject.optBoolean("scrollX", true);
      ab.i("MicroMsg.JsApiInsertScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
      localWxaScrollView.setScrollHorizontal(bool);
    }
    if (paramJSONObject.has("scrollY"))
    {
      bool = paramJSONObject.optBoolean("scrollY", true);
      ab.i("MicroMsg.JsApiInsertScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
      localWxaScrollView.setScrollVertical(bool);
    }
    if (paramJSONObject.has("scrollTop"))
    {
      paramInt = g.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
      ab.i("MicroMsg.JsApiInsertScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(paramInt) });
      localWxaScrollView.postDelayed(new d.2(this, localWxaScrollView, paramInt), 100L);
    }
    AppMethodBeat.o(126302);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126301);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126301);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.d
 * JD-Core Version:    0.7.0.1
 */