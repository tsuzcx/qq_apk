package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends d
{
  private static final int CTRL_INDEX = 447;
  public static final String NAME = "updateScrollView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137545);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137545);
    return i;
  }
  
  public final boolean c(final e parame, final int paramInt, View paramView, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137546);
    ad.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof WxaScrollView))
    {
      ad.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137546);
      return false;
    }
    WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.getBoolean("needScrollEvent")) {
        localWxaScrollView.setOnScrollChangedListener(new q()
        {
          public final void p(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(137544);
            if (!(paramAnonymousView instanceof WxaScrollView))
            {
              AppMethodBeat.o(137544);
              return;
            }
            Object localObject = parame.fG(paramJSONObject.optBoolean("independent", false)).H(paramInt, false);
            if (localObject == null)
            {
              AppMethodBeat.o(137544);
              return;
            }
            localObject = ((y.b)localObject).getString("data", null);
            if (localObject == null)
            {
              AppMethodBeat.o(137544);
              return;
            }
            paramAnonymousView = ((WxaScrollView)paramAnonymousView).getTargetView();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", localObject);
            localHashMap.put("scrollLeft", Integer.valueOf(g.vI(paramAnonymousInt1)));
            localHashMap.put("scrollTop", Integer.valueOf(g.vI(paramAnonymousInt2)));
            localHashMap.put("scrollWidth", Integer.valueOf(g.vI(paramAnonymousView.getWidth())));
            localHashMap.put("scrollHeight", Integer.valueOf(g.vI(paramAnonymousView.getHeight())));
            paramAnonymousView = new p().B(localHashMap);
            parame.b(paramAnonymousView);
            AppMethodBeat.o(137544);
          }
        });
      }
      for (;;)
      {
        label104:
        paramJSONObject.optInt("scrollLeft", 0);
        if (paramJSONObject.has("scrollX"))
        {
          bool = paramJSONObject.optBoolean("scrollX", true);
          ad.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollHorizontal(bool);
        }
        if (paramJSONObject.has("scrollY"))
        {
          bool = paramJSONObject.optBoolean("scrollY", true);
          ad.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollVertical(bool);
        }
        if (paramJSONObject.has("scrollTop"))
        {
          int i = g.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
          ad.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(i) });
          localWxaScrollView.scrollTo(localWxaScrollView.getScrollX(), i);
        }
        boolean bool = super.c(parame, paramInt, paramView, paramJSONObject);
        AppMethodBeat.o(137546);
        return bool;
        localWxaScrollView.setOnScrollChangedListener(null);
      }
    }
    catch (JSONException localJSONException)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.n
 * JD-Core Version:    0.7.0.1
 */