package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.ag.a;
import com.tencent.mm.plugin.appbrand.ui.ag.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class bg
  extends ab<d>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  private static boolean lzG = false;
  
  private String c(d paramd)
  {
    AppMethodBeat.i(139841);
    Object localObject2 = df.i(paramd);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new int[2];
        ((ac)localObject2).bRi().getCapsuleView().getLocationInWindow((int[])localObject1);
        i = ((ac)localObject2).bRi().getCapsuleView().getWidth();
        j = ((ac)localObject2).bRi().getCapsuleView().getHeight();
        k = localObject1[1];
        m = localObject1[0];
        if ((m == 0) || (i == 0))
        {
          Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] left==0, return null", new Object[] { ((ac)localObject2).getAppId() });
          localObject1 = null;
          if (localObject1 == null) {}
        }
      }
      catch (Exception localException1)
      {
        int i;
        int j;
        int k;
        int m;
        localObject1 = null;
      }
      try
      {
        if (lzG) {
          l(df.j(paramd));
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = l(df.j(paramd));
        }
        if (localObject2 == null) {
          break label236;
        }
        paramd = n("ok", (Map)localObject2);
        AppMethodBeat.o(139841);
        return paramd;
      }
      catch (Exception localException2)
      {
        break label217;
      }
      Object localObject1 = l(new Rect(m, k, m + i, j + k));
      Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] return %s", new Object[] { ((ac)localObject2).getAppId(), localObject1 });
      continue;
      label217:
      Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", new Object[] { localException1 });
      continue;
      label236:
      paramd = h("fail:internal error", null);
      AppMethodBeat.o(139841);
      return paramd;
      localObject1 = null;
    }
  }
  
  public static void hi(boolean paramBoolean)
  {
    lzG = paramBoolean;
  }
  
  private static int k(s params)
  {
    AppMethodBeat.i(182224);
    params = params.kEb.getStatusBar();
    if ((params == null) || (8 == params.visibility))
    {
      AppMethodBeat.o(182224);
      return 0;
    }
    int i = params.height;
    AppMethodBeat.o(182224);
    return i;
  }
  
  private static Map<String, Object> l(Rect paramRect)
  {
    AppMethodBeat.i(182226);
    paramRect.left = g.zB(paramRect.left);
    paramRect.top = g.zB(paramRect.top);
    paramRect.right = g.zB(paramRect.right);
    paramRect.bottom = g.zB(paramRect.bottom);
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
  
  private Map<String, Object> l(s params)
  {
    AppMethodBeat.i(182225);
    Object localObject2 = j(params);
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", new Object[] { params.getAppId() });
      AppMethodBeat.o(182225);
      return null;
    }
    int m = k(params);
    Object localObject1 = ((ag)localObject2).bXN();
    localObject2 = ((ag)localObject2).No();
    int k = com.tencent.mm.plugin.appbrand.utils.ai.n(params)[0];
    int i = ((ag.b)localObject1).width;
    int j = ((ag.b)localObject1).height;
    m += ((ag.a)localObject2).top;
    k -= ((ag.a)localObject2).right;
    localObject1 = l(new Rect(k - i, m, k, j + m));
    Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", new Object[] { params.getAppId(), localObject1 });
    AppMethodBeat.o(182225);
    return localObject1;
  }
  
  protected ag j(s params)
  {
    AppMethodBeat.i(177248);
    params = (ag)params.M(ag.class);
    AppMethodBeat.o(177248);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bg
 * JD-Core Version:    0.7.0.1
 */