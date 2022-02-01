package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.ui.af.a;
import com.tencent.mm.plugin.appbrand.ui.af.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class bd
  extends aa<com.tencent.mm.plugin.appbrand.g>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  private static boolean ouW = false;
  
  private String c(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(139841);
    Object localObject2 = dh.k(paramg);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new int[2];
        ((ad)localObject2).cdY().getCapsuleView().getLocationInWindow((int[])localObject1);
        i = ((ad)localObject2).cdY().getCapsuleView().getWidth();
        j = ((ad)localObject2).cdY().getCapsuleView().getHeight();
        k = localObject1[1];
        m = localObject1[0];
        if ((m == 0) || (i == 0))
        {
          Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] left==0, return null", new Object[] { ((ad)localObject2).getAppId() });
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
        if (ouW) {
          l(dh.l(paramg));
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = l(dh.l(paramg));
        }
        if (localObject2 == null) {
          break label236;
        }
        paramg = m("ok", (Map)localObject2);
        AppMethodBeat.o(139841);
        return paramg;
      }
      catch (Exception localException2)
      {
        break label217;
      }
      Object localObject1 = q(new Rect(m, k, m + i, j + k));
      Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] return %s", new Object[] { ((ad)localObject2).getAppId(), localObject1 });
      continue;
      label217:
      Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", new Object[] { localException1 });
      continue;
      label236:
      paramg = h("fail:internal error", null);
      AppMethodBeat.o(139841);
      return paramg;
      localObject1 = null;
    }
  }
  
  public static void hY(boolean paramBoolean)
  {
    ouW = paramBoolean;
  }
  
  private static int k(v paramv)
  {
    AppMethodBeat.i(182224);
    paramv = paramv.nxr.getStatusBar();
    if ((paramv == null) || (8 == paramv.visibility))
    {
      AppMethodBeat.o(182224);
      return 0;
    }
    int i = paramv.height;
    AppMethodBeat.o(182224);
    return i;
  }
  
  private Map<String, Object> l(v paramv)
  {
    AppMethodBeat.i(182225);
    Object localObject2 = j(paramv);
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", new Object[] { paramv.getAppId() });
      AppMethodBeat.o(182225);
      return null;
    }
    int m = k(paramv);
    Object localObject1 = ((af)localObject2).ckx();
    localObject2 = ((af)localObject2).Qg();
    int k = com.tencent.mm.plugin.appbrand.utils.ak.r(paramv)[0];
    int i = ((af.b)localObject1).width;
    int j = ((af.b)localObject1).height;
    m += ((af.a)localObject2).top;
    k -= ((af.a)localObject2).right;
    localObject1 = q(new Rect(k - i, m, k, j + m));
    Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", new Object[] { paramv.getAppId(), localObject1 });
    AppMethodBeat.o(182225);
    return localObject1;
  }
  
  private static Map<String, Object> q(Rect paramRect)
  {
    AppMethodBeat.i(182226);
    paramRect.left = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramRect.left);
    paramRect.top = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramRect.top);
    paramRect.right = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramRect.right);
    paramRect.bottom = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramRect.bottom);
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
  
  protected af j(v paramv)
  {
    AppMethodBeat.i(177248);
    paramv = (af)paramv.K(af.class);
    AppMethodBeat.o(177248);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bd
 * JD-Core Version:    0.7.0.1
 */