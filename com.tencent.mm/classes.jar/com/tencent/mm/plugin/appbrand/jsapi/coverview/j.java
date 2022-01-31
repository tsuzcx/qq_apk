package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends c
{
  private static final int CTRL_INDEX = 447;
  public static final String NAME = "updateScrollView";
  
  protected final boolean c(final e parame, final int paramInt, View paramView, JSONObject paramJSONObject)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof WxaScrollView))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    WxaScrollView localWxaScrollView = (WxaScrollView)paramView;
    d.a(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.getBoolean("needScrollEvent")) {
        localWxaScrollView.setOnScrollChangedListener(new m()
        {
          public final void i(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            if (!(paramAnonymousView instanceof WxaScrollView)) {}
            Object localObject;
            do
            {
              do
              {
                return;
                localObject = parame.agW().F(paramInt, false);
              } while (localObject == null);
              localObject = ((u.b)localObject).getString("data", null);
            } while (localObject == null);
            paramAnonymousView = ((WxaScrollView)paramAnonymousView).getTargetView();
            HashMap localHashMap = new HashMap();
            localHashMap.put("data", localObject);
            localHashMap.put("scrollLeft", Integer.valueOf(h.mx(paramAnonymousInt1)));
            localHashMap.put("scrollTop", Integer.valueOf(h.mx(paramAnonymousInt2)));
            localHashMap.put("scrollWidth", Integer.valueOf(h.mx(paramAnonymousView.getWidth())));
            localHashMap.put("scrollHeight", Integer.valueOf(h.mx(paramAnonymousView.getHeight())));
            paramAnonymousView = new l().p(localHashMap);
            parame.b(paramAnonymousView);
          }
        });
      }
      for (;;)
      {
        label92:
        paramJSONObject.optInt("scrollLeft", 0);
        boolean bool;
        if (paramJSONObject.has("scrollX"))
        {
          bool = paramJSONObject.optBoolean("scrollX", true);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiUpdateScrollView", "scrollHorizontal:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollHorizontal(bool);
        }
        if (paramJSONObject.has("scrollY"))
        {
          bool = paramJSONObject.optBoolean("scrollY", true);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiUpdateScrollView", "scrollVertical:%b", new Object[] { Boolean.valueOf(bool) });
          localWxaScrollView.setScrollVertical(bool);
        }
        if (paramJSONObject.has("scrollTop"))
        {
          int i = h.a(paramJSONObject, "scrollTop", localWxaScrollView.getScrollY());
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiUpdateScrollView", "scrollTop:%d", new Object[] { Integer.valueOf(i) });
          localWxaScrollView.scrollTo(localWxaScrollView.getScrollX(), i);
        }
        return super.c(parame, paramInt, paramView, paramJSONObject);
        localWxaScrollView.setOnScrollChangedListener(null);
      }
    }
    catch (JSONException localJSONException)
    {
      break label92;
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("viewId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.j
 * JD-Core Version:    0.7.0.1
 */