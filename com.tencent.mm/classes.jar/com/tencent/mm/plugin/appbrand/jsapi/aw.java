package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.aa.a;
import com.tencent.mm.plugin.appbrand.ui.aa.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public class aw
  extends y<d>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  private static boolean kvD = false;
  
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
        ((z)localObject2).bvi().getCapsuleView().getLocationInWindow((int[])localObject1);
        i = ((z)localObject2).bvi().getCapsuleView().getWidth();
        j = ((z)localObject2).bvi().getCapsuleView().getHeight();
        k = localObject1[1];
        m = localObject1[0];
        if ((m == 0) || (i == 0))
        {
          ae.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] left==0, return null", new Object[] { ((z)localObject2).getAppId() });
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
        if (kvD) {
          j(co.j(paramd));
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = j(co.j(paramd));
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
      Object localObject1 = k(new Rect(m, k, m + i, j + k));
      ae.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy with appId[%s] return %s", new Object[] { ((z)localObject2).getAppId(), localObject1 });
      continue;
      label217:
      ae.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectLegacy e=%s", new Object[] { localException1 });
      continue;
      label236:
      paramd = e("fail:internal error", null);
      AppMethodBeat.o(139841);
      return paramd;
      localObject1 = null;
    }
  }
  
  public static void gl(boolean paramBoolean)
  {
    kvD = paramBoolean;
  }
  
  private static int i(r paramr)
  {
    AppMethodBeat.i(182224);
    paramr = paramr.jDa.getStatusBar();
    if ((paramr == null) || (8 == paramr.visibility))
    {
      AppMethodBeat.o(182224);
      return 0;
    }
    int i = paramr.height;
    AppMethodBeat.o(182224);
    return i;
  }
  
  private Map<String, Object> j(r paramr)
  {
    AppMethodBeat.i(182225);
    Object localObject2 = h(paramr);
    if (localObject2 == null)
    {
      ae.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", new Object[] { paramr.getAppId() });
      AppMethodBeat.o(182225);
      return null;
    }
    int m = i(paramr);
    Object localObject1 = ((aa)localObject2).bAI();
    localObject2 = ((aa)localObject2).DS();
    int k = com.tencent.mm.plugin.appbrand.utils.ai.n(paramr)[0];
    int i = ((aa.b)localObject1).width;
    int j = ((aa.b)localObject1).height;
    m += ((aa.a)localObject2).top;
    k -= ((aa.a)localObject2).right;
    localObject1 = k(new Rect(k - i, m, k, j + m));
    ae.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", new Object[] { paramr.getAppId(), localObject1 });
    AppMethodBeat.o(182225);
    return localObject1;
  }
  
  private static Map<String, Object> k(Rect paramRect)
  {
    AppMethodBeat.i(182226);
    paramRect.left = g.vM(paramRect.left);
    paramRect.top = g.vM(paramRect.top);
    paramRect.right = g.vM(paramRect.right);
    paramRect.bottom = g.vM(paramRect.bottom);
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
  
  protected aa h(r paramr)
  {
    AppMethodBeat.i(177248);
    paramr = (aa)paramr.K(aa.class);
    AppMethodBeat.o(177248);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aw
 * JD-Core Version:    0.7.0.1
 */