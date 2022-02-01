package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class ab
{
  private static boolean nqE;
  public static final ab nqF;
  
  static
  {
    AppMethodBeat.i(147973);
    nqF = new ab();
    nqE = true;
    AppMethodBeat.o(147973);
  }
  
  private static a ag(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147972);
    a locala = (a)paramAppBrandRuntime.aw(a.class);
    if (locala == null)
    {
      locala = new a(paramAppBrandRuntime);
      paramAppBrandRuntime.a((n)locala);
    }
    for (paramAppBrandRuntime = locala;; paramAppBrandRuntime = locala)
    {
      AppMethodBeat.o(147972);
      return paramAppBrandRuntime;
    }
  }
  
  public static final void ih(boolean paramBoolean)
  {
    nqE = paramBoolean;
  }
  
  public static final void k(ac paramac)
  {
    AppMethodBeat.i(147970);
    p.h(paramac, "page");
    if (paramac.getRuntime() == null)
    {
      AppMethodBeat.o(147970);
      return;
    }
    try
    {
      AppBrandRuntime localAppBrandRuntime = paramac.getRuntime();
      p.g(localAppBrandRuntime, "page.runtime");
      ag(localAppBrandRuntime).remove(paramac);
      AppMethodBeat.o(147970);
      return;
    }
    catch (Exception paramac)
    {
      Log.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(paramac)));
      AppMethodBeat.o(147970);
    }
  }
  
  public static final boolean l(ac paramac)
  {
    AppMethodBeat.i(147971);
    p.h(paramac, "page");
    try
    {
      if (!nqE) {
        break label306;
      }
      localObject = (CharSequence)paramac.getURL();
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
        Log.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPage ".concat(String.valueOf(localException)));
        boolean bool = false;
        continue;
        int i = 1;
        continue;
        bool = false;
      }
    }
    if (i == 0)
    {
      localObject = paramac.getRuntime();
      if ((localObject != null) && (!((AppBrandRuntime)localObject).isResumed()))
      {
        localObject = paramac.getRuntime();
        if (localObject == null) {
          p.hyc();
        }
        bool = ((AppBrandRuntime)localObject).brJ();
        if (bool) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = paramac.getRuntime();
        p.g(localObject, "page.runtime");
        ag((AppBrandRuntime)localObject).add(paramac);
        Log.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramac.getAppId() + "] path[" + paramac.getURL() + ']');
      }
      AppMethodBeat.o(147971);
      return bool;
      i = 0;
      break;
      localObject = paramac.bRc();
      if ((localObject == null) || (((t)localObject).isInBackground() != true)) {
        break label338;
      }
      if ((!(paramac.bRc() instanceof m)) && (paramac.getRuntime() != null))
      {
        localObject = paramac.getRuntime();
        p.g(localObject, "page.runtime");
        if ((((AppBrandRuntime)localObject).brh() != null) && (paramac.bRc() != null))
        {
          localObject = paramac.bRc();
          if (localObject == null) {
            p.hyc();
          }
          i = ((t)localObject).bQL();
          localObject = paramac.getRuntime();
          p.g(localObject, "page.runtime");
          localObject = ((AppBrandRuntime)localObject).brh();
          p.g(localObject, "page.runtime.pageContainer");
          int j = ((w)localObject).getPageCount();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"})
  static final class a
    extends HashSet<ac>
    implements n
  {
    public a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(147966);
      paramAppBrandRuntime = paramAppBrandRuntime.brl();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.a((c.a)new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(147965);
            if (paramAnonymousb == b.kQK) {
              this.nqG.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab
 * JD-Core Version:    0.7.0.1
 */