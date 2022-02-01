package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class ac
{
  private static boolean qsq;
  public static final ac qsr;
  
  static
  {
    AppMethodBeat.i(147973);
    qsr = new ac();
    qsq = true;
    AppMethodBeat.o(147973);
  }
  
  private static a ag(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147972);
    a locala = (a)paramAppBrandRuntime.av(a.class);
    if (locala == null)
    {
      locala = new a(paramAppBrandRuntime);
      paramAppBrandRuntime.a((m)locala);
    }
    for (paramAppBrandRuntime = locala;; paramAppBrandRuntime = locala)
    {
      AppMethodBeat.o(147972);
      return paramAppBrandRuntime;
    }
  }
  
  public static final void je(boolean paramBoolean)
  {
    qsq = paramBoolean;
  }
  
  public static final void k(ad paramad)
  {
    AppMethodBeat.i(147970);
    p.k(paramad, "page");
    if (paramad.getRuntime() == null)
    {
      AppMethodBeat.o(147970);
      return;
    }
    try
    {
      AppBrandRuntime localAppBrandRuntime = paramad.getRuntime();
      p.j(localAppBrandRuntime, "page.runtime");
      ag(localAppBrandRuntime).remove(paramad);
      AppMethodBeat.o(147970);
      return;
    }
    catch (Exception paramad)
    {
      Log.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(paramad)));
      AppMethodBeat.o(147970);
    }
  }
  
  public static final boolean l(ad paramad)
  {
    AppMethodBeat.i(147971);
    p.k(paramad, "page");
    try
    {
      if (!qsq) {
        break label306;
      }
      localObject = (CharSequence)paramad.btD();
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
      localObject = paramad.getRuntime();
      if ((localObject != null) && (!((AppBrandRuntime)localObject).isResumed()))
      {
        localObject = paramad.getRuntime();
        if (localObject == null) {
          p.iCn();
        }
        bool = ((AppBrandRuntime)localObject).bCy();
        if (bool) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = paramad.getRuntime();
        p.j(localObject, "page.runtime");
        ag((AppBrandRuntime)localObject).add(paramad);
        Log.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramad.getAppId() + "] path[" + paramad.btD() + ']');
      }
      AppMethodBeat.o(147971);
      return bool;
      i = 0;
      break;
      localObject = paramad.cdS();
      if ((localObject == null) || (((u)localObject).isInBackground() != true)) {
        break label338;
      }
      if ((!(paramad.cdS() instanceof n)) && (paramad.getRuntime() != null))
      {
        localObject = paramad.getRuntime();
        p.j(localObject, "page.runtime");
        if ((((AppBrandRuntime)localObject).bBX() != null) && (paramad.cdS() != null))
        {
          localObject = paramad.cdS();
          if (localObject == null) {
            p.iCn();
          }
          i = ((u)localObject).cdB();
          localObject = paramad.getRuntime();
          p.j(localObject, "page.runtime");
          localObject = ((AppBrandRuntime)localObject).bBX();
          p.j(localObject, "page.runtime.pageContainer");
          int j = ((x)localObject).getPageCount();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"})
  static final class a
    extends HashSet<ad>
    implements m
  {
    public a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(147966);
      paramAppBrandRuntime = paramAppBrandRuntime.bCb();
      if (paramAppBrandRuntime != null)
      {
        paramAppBrandRuntime.a((c.a)new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(147965);
            if (paramAnonymousb == b.nKS) {
              this.qss.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */