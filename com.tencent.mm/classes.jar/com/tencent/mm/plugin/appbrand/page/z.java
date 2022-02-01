package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.HashSet;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class z
{
  private static boolean lCm;
  public static final z lCn;
  
  static
  {
    AppMethodBeat.i(147973);
    lCn = new z();
    lCm = true;
    AppMethodBeat.o(147973);
  }
  
  private static a am(AppBrandRuntime paramAppBrandRuntime)
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
  
  public static final void gW(boolean paramBoolean)
  {
    lCm = paramBoolean;
  }
  
  public static final void i(aa paramaa)
  {
    AppMethodBeat.i(147970);
    d.g.b.k.h(paramaa, "page");
    if (paramaa.getRuntime() == null)
    {
      AppMethodBeat.o(147970);
      return;
    }
    try
    {
      AppBrandRuntime localAppBrandRuntime = paramaa.getRuntime();
      d.g.b.k.g(localAppBrandRuntime, "page.runtime");
      am(localAppBrandRuntime).remove(paramaa);
      AppMethodBeat.o(147970);
      return;
    }
    catch (Exception paramaa)
    {
      ac.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(paramaa)));
      AppMethodBeat.o(147970);
    }
  }
  
  public static final boolean j(aa paramaa)
  {
    AppMethodBeat.i(147971);
    d.g.b.k.h(paramaa, "page");
    try
    {
      if (!lCm) {
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
        ac.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPage ".concat(String.valueOf(localException)));
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
          d.g.b.k.fOy();
        }
        bool = ((AppBrandRuntime)localObject).aSX();
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
        d.g.b.k.g(localObject, "page.runtime");
        am((AppBrandRuntime)localObject).add(paramaa);
        ac.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramaa.getAppId() + "] path[" + paramaa.getURL() + ']');
      }
      AppMethodBeat.o(147971);
      return bool;
      i = 0;
      break;
      localObject = paramaa.bqs();
      if ((localObject == null) || (((r)localObject).isInBackground() != true)) {
        break label338;
      }
      if ((!(paramaa.bqs() instanceof k)) && (paramaa.getRuntime() != null))
      {
        localObject = paramaa.getRuntime();
        d.g.b.k.g(localObject, "page.runtime");
        if ((((AppBrandRuntime)localObject).aSA() != null) && (paramaa.bqs() != null))
        {
          localObject = paramaa.bqs();
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          i = ((r)localObject).bqa();
          localObject = paramaa.getRuntime();
          d.g.b.k.g(localObject, "page.runtime");
          localObject = ((AppBrandRuntime)localObject).aSA();
          d.g.b.k.g(localObject, "page.runtime.pageContainer");
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"})
  static final class a
    extends HashSet<aa>
    implements com.tencent.mm.plugin.appbrand.jsapi.k
  {
    public a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(147966);
      paramAppBrandRuntime = paramAppBrandRuntime.aSC();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.a((c.a)new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(147965);
            if (paramAnonymousb == b.jqX) {
              this.lCo.clear();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */