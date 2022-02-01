package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.c.d;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.ui.z.a;
import com.tencent.mm.plugin.appbrand.ui.z.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public class aw
  extends y<d>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  private static boolean ksn = false;
  
  private String c(d paramd)
  {
    AppMethodBeat.i(139841);
    Object localObject2 = co.i(paramd);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new int[2];
        ((aa)localObject2).bux().getCapsuleView().getLocationInWindow((int[])localObject1);
        i = ((aa)localObject2).bux().getCapsuleView().getWidth();
        j = ((aa)localObject2).bux().getCapsuleView().getHeight();
        k = localObject1[1];
        m = localObject1[0];
        if (m == 0)
        {
          ad.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] left==0, return null", new Object[] { ((aa)localObject2).getAppId() });
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
        if (ksn) {
          j(co.j(paramd));
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = j(co.j(paramd));
        }
        if (localObject2 == null) {
          break label232;
        }
        paramd = m("ok", (Map)localObject2);
        AppMethodBeat.o(139841);
        return paramd;
      }
      catch (Exception localException2)
      {
        break label213;
      }
      Object localObject1 = k(new Rect(m, k, i + m, j + k));
      ad.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] return %s", new Object[] { ((aa)localObject2).getAppId(), localObject1 });
      continue;
      label213:
      ad.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", new Object[] { localException1 });
      continue;
      label232:
      paramd = e("fail:internal error", null);
      AppMethodBeat.o(139841);
      return paramd;
      localObject1 = null;
    }
  }
  
  public static void gn(boolean paramBoolean)
  {
    ksn = paramBoolean;
  }
  
  private static int i(q paramq)
  {
    AppMethodBeat.i(182224);
    paramq = paramq.jzX.getStatusBar();
    if ((paramq == null) || (8 == paramq.visibility))
    {
      AppMethodBeat.o(182224);
      return 0;
    }
    int i = paramq.height;
    AppMethodBeat.o(182224);
    return i;
  }
  
  private Map<String, Object> j(q paramq)
  {
    AppMethodBeat.i(182225);
    Object localObject2 = h(paramq);
    if (localObject2 == null)
    {
      ad.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", new Object[] { paramq.getAppId() });
      AppMethodBeat.o(182225);
      return null;
    }
    int m = i(paramq);
    Object localObject1 = ((z)localObject2).bzN();
    localObject2 = ((z)localObject2).DP();
    int k = com.tencent.mm.plugin.appbrand.utils.af.l(paramq)[0];
    int i = ((z.b)localObject1).width;
    int j = ((z.b)localObject1).height;
    m += ((z.a)localObject2).top;
    k -= ((z.a)localObject2).right;
    localObject1 = k(new Rect(k - i, m, k, j + m));
    ad.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", new Object[] { paramq.getAppId(), localObject1 });
    AppMethodBeat.o(182225);
    return localObject1;
  }
  
  private static Map<String, Object> k(Rect paramRect)
  {
    AppMethodBeat.i(182226);
    paramRect.left = g.vH(paramRect.left);
    paramRect.top = g.vH(paramRect.top);
    paramRect.right = g.vH(paramRect.right);
    paramRect.bottom = g.vH(paramRect.bottom);
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
  
  protected z h(q paramq)
  {
    AppMethodBeat.i(177248);
    paramq = (z)paramq.K(z.class);
    AppMethodBeat.o(177248);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aw
 * JD-Core Version:    0.7.0.1
 */