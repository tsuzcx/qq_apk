package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.ui.am;
import com.tencent.mm.plugin.appbrand.ui.am.a;
import com.tencent.mm.plugin.appbrand.ui.am.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class bg
  extends ab<g>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  private static boolean rym = false;
  
  private String c(g paramg)
  {
    Object localObject1 = null;
    Map localMap = null;
    AppMethodBeat.i(139841);
    ad localad = dp.j(paramg);
    Object localObject3;
    if (localad != null) {
      localObject3 = localObject1;
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = new int[2];
        localObject3 = localObject1;
        localad.cEC().getCapsuleView().getLocationInWindow(arrayOfInt);
        localObject3 = localObject1;
        i = localad.cEC().getCapsuleView().getWidth();
        localObject3 = localObject1;
        j = localad.cEC().getCapsuleView().getHeight();
        k = arrayOfInt[1];
        m = arrayOfInt[0];
        if ((m != 0) && (i != 0)) {
          continue;
        }
        localObject3 = localObject1;
        Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] left==0, return null", new Object[] { localad.getAppId() });
        localObject1 = localMap;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          if (rym)
          {
            localObject3 = localObject1;
            l(dp.k(paramg));
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        int j;
        int k;
        int m;
        Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", new Object[] { localException });
        localObject2 = localObject3;
        continue;
        paramg = ZP("fail:internal error");
        AppMethodBeat.o(139841);
        return paramg;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = l(dp.k(paramg));
      }
      if (localObject3 != null)
      {
        paramg = m("ok", (Map)localObject3);
        AppMethodBeat.o(139841);
        return paramg;
        localObject3 = localObject1;
        localMap = v(new Rect(m, k, m + i, j + k));
        localObject3 = localObject1;
        Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] return %s", new Object[] { localad.getAppId(), localMap });
        localObject1 = localMap;
      }
      else
      {
        Object localObject2 = null;
      }
    }
  }
  
  public static void iX(boolean paramBoolean)
  {
    rym = paramBoolean;
  }
  
  private Map<String, Object> l(y paramy)
  {
    AppMethodBeat.i(182225);
    Object localObject2 = k(paramy);
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", new Object[] { paramy.getAppId() });
      AppMethodBeat.o(182225);
      return null;
    }
    int n = ((am)localObject2).c(paramy);
    Object localObject1 = ((am)localObject2).cLL();
    localObject2 = ((am)localObject2).aqq();
    int m = com.tencent.mm.plugin.appbrand.utils.aq.n(paramy)[0];
    int j = ((am.b)localObject1).width;
    int k = ((am.b)localObject1).height;
    if (localObject2 == null)
    {
      i = 0;
      n += i;
      if (localObject2 != null) {
        break label179;
      }
    }
    label179:
    for (int i = 0;; i = ((am.a)localObject2).right)
    {
      i = m - i;
      localObject1 = v(new Rect(i - j, n, i, k + n));
      Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", new Object[] { paramy.getAppId(), localObject1 });
      AppMethodBeat.o(182225);
      return localObject1;
      i = ((am.a)localObject2).top;
      break;
    }
  }
  
  private static Map<String, Object> v(Rect paramRect)
  {
    AppMethodBeat.i(182226);
    paramRect.left = i.DA(paramRect.left);
    paramRect.top = i.DA(paramRect.top);
    paramRect.right = i.DA(paramRect.right);
    paramRect.bottom = i.DA(paramRect.bottom);
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("left", Integer.valueOf(paramRect.left));
    localHashMap.put("top", Integer.valueOf(paramRect.top));
    localHashMap.put("right", Integer.valueOf(paramRect.right));
    localHashMap.put("bottom", Integer.valueOf(paramRect.bottom));
    localHashMap.put("width", Integer.valueOf(paramRect.width()));
    localHashMap.put("height", Integer.valueOf(paramRect.height()));
    AppMethodBeat.o(182226);
    return localHashMap;
  }
  
  protected am k(y paramy)
  {
    AppMethodBeat.i(177248);
    paramy = (am)paramy.T(am.class);
    AppMethodBeat.o(177248);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bg
 * JD-Core Version:    0.7.0.1
 */