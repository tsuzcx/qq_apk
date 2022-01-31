package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class n
{
  private static boolean gIv = false;
  
  public static f m(Context paramContext, boolean paramBoolean)
  {
    Object localObject = a.b.dHs;
    localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100377");
    int i;
    if (localObject == null)
    {
      y.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
      i = 0;
      if (i != 1) {
        break label150;
      }
      i = 1;
      label33:
      if ((i == 0) && (!paramBoolean)) {
        break label155;
      }
      paramContext = new a();
    }
    for (;;)
    {
      label49:
      if ((paramContext instanceof p))
      {
        h.nFQ.a(434L, 1L, 1L, false);
        y.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandWebViewBasedJsEngine");
      }
      for (;;)
      {
        h.nFQ.a(434L, 0L, 1L, false);
        return paramContext;
        if (!((c)localObject).isValid())
        {
          y.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
          i = 0;
          break;
        }
        i = bk.getInt((String)((c)localObject).ctr().get("JsRuntime"), 0);
        y.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", new Object[] { Integer.valueOf(i) });
        break;
        label150:
        i = 0;
        break label33;
        label155:
        localObject = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        String str = ((SharedPreferences)localObject).getString("tbs_webview_disable", "0");
        if ((!((SharedPreferences)localObject).getBoolean("switch_x5_jscore", true)) || ("1".equals(str)) || (gIv)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label231;
          }
          paramContext = new p(paramContext);
          break;
        }
        label231:
        localObject = new o(paramContext);
        if (((o)localObject).isValid()) {
          break label358;
        }
        gIv = true;
        ((f)localObject).destroy();
        paramContext = new p(paramContext);
        break label49;
        if ((paramContext instanceof o))
        {
          localObject = h.nFQ;
          if (!((o)paramContext).isValid()) {}
          for (long l = 1L;; l = 2L)
          {
            ((h)localObject).a(434L, l, 1L, false);
            y.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandMessBasedJsEngine probably");
            break;
          }
        }
        if ((paramContext instanceof a))
        {
          h.nFQ.a(434L, 5L, 1L, false);
          y.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
        }
      }
      label358:
      paramContext = (Context)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.n
 * JD-Core Version:    0.7.0.1
 */