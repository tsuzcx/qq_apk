package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashSet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class y
{
  private static boolean mgg;
  public static final y mgh;
  
  static
  {
    AppMethodBeat.i(147973);
    mgh = new y();
    mgg = true;
    AppMethodBeat.o(147973);
  }
  
  private static a af(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147972);
    a locala = (a)paramAppBrandRuntime.as(a.class);
    if (locala == null)
    {
      locala = new a(paramAppBrandRuntime);
      paramAppBrandRuntime.a((k)locala);
    }
    for (paramAppBrandRuntime = locala;; paramAppBrandRuntime = locala)
    {
      AppMethodBeat.o(147972);
      return paramAppBrandRuntime;
    }
  }
  
  public static final void h(z paramz)
  {
    AppMethodBeat.i(147970);
    p.h(paramz, "page");
    if (paramz.getRuntime() == null)
    {
      AppMethodBeat.o(147970);
      return;
    }
    try
    {
      AppBrandRuntime localAppBrandRuntime = paramz.getRuntime();
      p.g(localAppBrandRuntime, "page.runtime");
      af(localAppBrandRuntime).remove(paramz);
      AppMethodBeat.o(147970);
      return;
    }
    catch (Exception paramz)
    {
      ae.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(paramz)));
      AppMethodBeat.o(147970);
    }
  }
  
  public static final void hg(boolean paramBoolean)
  {
    mgg = paramBoolean;
  }
  
  public static final boolean i(z paramz)
  {
    AppMethodBeat.i(147971);
    p.h(paramz, "page");
    try
    {
      if (!mgg) {
        break label306;
      }
      localObject = (CharSequence)paramz.getURL();
      if (localObject == null) {
        break label333;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label168;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label168:
        label306:
        ae.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPage ".concat(String.valueOf(localException)));
        boolean bool = false;
        continue;
        int i = 1;
        continue;
        bool = false;
      }
    }
    if (i == 0)
    {
      localObject = paramz.getRuntime();
      if ((localObject != null) && (!((AppBrandRuntime)localObject).isResumed()))
      {
        localObject = paramz.getRuntime();
        if (localObject == null) {
          p.gkB();
        }
        bool = ((AppBrandRuntime)localObject).aWM();
        if (bool) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = paramz.getRuntime();
        p.g(localObject, "page.runtime");
        af((AppBrandRuntime)localObject).add(paramz);
        ae.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramz.getAppId() + "] path[" + paramz.getURL() + ']');
      }
      AppMethodBeat.o(147971);
      return bool;
      i = 0;
      break;
      localObject = paramz.bvc();
      if ((localObject == null) || (((q)localObject).isInBackground() != true)) {
        break label338;
      }
      if ((!(paramz.bvc() instanceof j)) && (paramz.getRuntime() != null))
      {
        localObject = paramz.getRuntime();
        p.g(localObject, "page.runtime");
        if ((((AppBrandRuntime)localObject).aWm() != null) && (paramz.bvc() != null))
        {
          localObject = paramz.bvc();
          if (localObject == null) {
            p.gkB();
          }
          i = ((q)localObject).buL();
          localObject = paramz.getRuntime();
          p.g(localObject, "page.runtime");
          localObject = ((AppBrandRuntime)localObject).aWm();
          p.g(localObject, "page.runtime.pageContainer");
          int j = ((t)localObject).getPageCount();
          if (i < j - 5)
          {
            bool = true;
            continue;
          }
        }
      }
      bool = false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"})
  static final class a
    extends HashSet<z>
    implements k
  {
    public a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(147966);
      paramAppBrandRuntime = paramAppBrandRuntime.aWq();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.a((c.a)new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(147965);
            if (paramAnonymousb == b.jOd) {
              this.mgi.clear();
            }
            AppMethodBeat.o(147965);
          }
        });
        AppMethodBeat.o(147966);
        return;
      }
      AppMethodBeat.o(147966);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */