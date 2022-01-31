package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends c
{
  private static final int CTRL_INDEX = 447;
  public static final String NAME = "updateScrollView";
  
  public final boolean c(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126318);
    ab.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof WxaScrollView))
    {
      ab.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126318);
      return false;
    }
    WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    com.tencent.mm.plugin.appbrand.jsapi.s.e.b(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.getBoolean("needScrollEvent")) {
        localWxaScrollView.setOnScrollChangedListener(new m()
        {
          public final void q(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(126316);
            if (!(paramAnonymousView instanceof WxaScrollView))
            {
              AppMethodBeat.o(126316);
              return;
            }
            Object localObject = parame.vC().J(paramInt, false);
            if (localObject == null)
            {
              AppMethodBeat.o(126316);
              return;
            }
            localObject = ((v.b)localObject).getString("data", null);
            if (localObject == null)
            {
              AppMethodBeat.o(126316);
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
            AppMethodBeat.o(126316);
          }
        });
      }
      for (;;)
      {
        label102:
        paramJSONObject.optInt("scrollLeft", 0);
        if (paramJSONObject.has("scrollX"))
        {
          bool = paramJSONObject.optBoolean("scrollX", true);
          ab.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollHorizontal(bool);
        }
        if (paramJSONObject.has("scrollY"))
        {
          bool = paramJSONObject.optBoolean("scrollY", true);
          ab.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollVertical(bool);
        }
        if (paramJSONObject.has("scrollTop"))
        {
          int i = g.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
          ab.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(i) });
          localWxaScrollView.scrollTo(localWxaScrollView.getScrollX(), i);
        }
        boolean bool = super.c(parame, paramInt, paramView, paramJSONObject);
        AppMethodBeat.o(126318);
        return bool;
        localWxaScrollView.setOnScrollChangedListener(null);
      }
    }
    catch (JSONException localJSONException)
    {
      break label102;
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126317);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126317);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.j
 * JD-Core Version:    0.7.0.1
 */