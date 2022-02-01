package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.ah.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class q
  extends d
{
  private static final int CTRL_INDEX = 447;
  public static final String NAME = "updateScrollView";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137545);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137545);
    return i;
  }
  
  public final boolean c(final h paramh, final int paramInt, View paramView, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137546);
    Log.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof WxaScrollView))
    {
      Log.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137546);
      return false;
    }
    WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.getBoolean("needScrollEvent")) {
        localWxaScrollView.setOnScrollChangedListener(new t()
        {
          public final void p(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(137544);
            if (!(paramAnonymousView instanceof WxaScrollView))
            {
              AppMethodBeat.o(137544);
              return;
            }
            Object localObject = paramh.ic(paramJSONObject.optBoolean("independent", false)).ac(paramInt, false);
            if (localObject == null)
            {
              AppMethodBeat.o(137544);
              return;
            }
            localObject = ((ad.b)localObject).getString("data", null);
            if (localObject == null)
            {
              AppMethodBeat.o(137544);
              return;
            }
            paramAnonymousView = ((WxaScrollView)paramAnonymousView).getTargetView();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", localObject);
            localHashMap.put("scrollLeft", Integer.valueOf(i.DB(paramAnonymousInt1)));
            localHashMap.put("scrollTop", Integer.valueOf(i.DB(paramAnonymousInt2)));
            localHashMap.put("scrollWidth", Integer.valueOf(i.DB(paramAnonymousView.getWidth())));
            localHashMap.put("scrollHeight", Integer.valueOf(i.DB(paramAnonymousView.getHeight())));
            paramAnonymousView = new s().L(localHashMap);
            paramh.a(paramAnonymousView, null);
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
          Log.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollHorizontal(bool);
        }
        if (paramJSONObject.has("scrollY"))
        {
          bool = paramJSONObject.optBoolean("scrollY", true);
          Log.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollVertical(bool);
        }
        if (paramJSONObject.has("scrollTop"))
        {
          int i = i.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
          Log.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(i) });
          localWxaScrollView.scrollTo(localWxaScrollView.getScrollX(), i);
        }
        boolean bool = super.c(paramh, paramInt, paramView, paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.q
 * JD-Core Version:    0.7.0.1
 */