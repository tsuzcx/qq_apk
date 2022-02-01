package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashSet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class z
{
  private static boolean mbN;
  public static final z mbO;
  
  static
  {
    AppMethodBeat.i(147973);
    mbO = new z();
    mbN = true;
    AppMethodBeat.o(147973);
  }
  
  private static a ag(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147972);
    a locala = (a)paramAppBrandRuntime.as(a.class);
    if (locala == null)
    {
      locala = new a(paramAppBrandRuntime);
      paramAppBrandRuntime.a((com.tencent.mm.plugin.appbrand.jsapi.k)locala);
    }
    for (paramAppBrandRuntime = locala;; paramAppBrandRuntime = locala)
    {
      AppMethodBeat.o(147972);
      return paramAppBrandRuntime;
    }
  }
  
  public static final void hf(boolean paramBoolean)
  {
    mbN = paramBoolean;
  }
  
  public static final void i(aa paramaa)
  {
    AppMethodBeat.i(147970);
    p.h(paramaa, "page");
    if (paramaa.getRuntime() == null)
    {
      AppMethodBeat.o(147970);
      return;
    }
    try
    {
      AppBrandRuntime localAppBrandRuntime = paramaa.getRuntime();
      p.g(localAppBrandRuntime, "page.runtime");
      ag(localAppBrandRuntime).remove(paramaa);
      AppMethodBeat.o(147970);
      return;
    }
    catch (Exception paramaa)
    {
      ad.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(paramaa)));
      AppMethodBeat.o(147970);
    }
  }
  
  public static final boolean j(aa paramaa)
  {
    AppMethodBeat.i(147971);
    p.h(paramaa, "page");
    try
    {
      if (!mbN) {
        break label306;
      }
      localObject = (CharSequence)paramaa.getURL();
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
        ad.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPage ".concat(String.valueOf(localException)));
        boolean bool = false;
        continue;
        int i = 1;
        continue;
        bool = false;
      }
    }
    if (i == 0)
    {
      localObject = paramaa.getRuntime();
      if ((localObject != null) && (!((AppBrandRuntime)localObject).isResumed()))
      {
        localObject = paramaa.getRuntime();
        if (localObject == null) {
          p.gfZ();
        }
        bool = ((AppBrandRuntime)localObject).aWl();
        if (bool) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = paramaa.getRuntime();
        p.g(localObject, "page.runtime");
        ag((AppBrandRuntime)localObject).add(paramaa);
        ad.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramaa.getAppId() + "] path[" + paramaa.getURL() + ']');
      }
      AppMethodBeat.o(147971);
      return bool;
      i = 0;
      break;
      localObject = paramaa.bur();
      if ((localObject == null) || (((r)localObject).isInBackground() != true)) {
        break label338;
      }
      if ((!(paramaa.bur() instanceof k)) && (paramaa.getRuntime() != null))
      {
        localObject = paramaa.getRuntime();
        p.g(localObject, "page.runtime");
        if ((((AppBrandRuntime)localObject).aVN() != null) && (paramaa.bur() != null))
        {
          localObject = paramaa.bur();
          if (localObject == null) {
            p.gfZ();
          }
          i = ((r)localObject).bua();
          localObject = paramaa.getRuntime();
          p.g(localObject, "page.runtime");
          localObject = ((AppBrandRuntime)localObject).aVN();
          p.g(localObject, "page.runtime.pageContainer");
          int j = ((u)localObject).getPageCount();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"})
  static final class a
    extends HashSet<aa>
    implements com.tencent.mm.plugin.appbrand.jsapi.k
  {
    public a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(147966);
      paramAppBrandRuntime = paramAppBrandRuntime.aVQ();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.a((c.a)new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(147965);
            if (paramAnonymousb == b.jKR) {
              this.mbP.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */