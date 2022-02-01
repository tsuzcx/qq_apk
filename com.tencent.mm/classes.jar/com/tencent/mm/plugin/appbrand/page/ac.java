package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac twV;
  private static boolean twW;
  
  static
  {
    AppMethodBeat.i(147973);
    twV = new ac();
    twW = true;
    AppMethodBeat.o(147973);
  }
  
  private static a au(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147972);
    a locala = (a)paramAppBrandRuntime.aO(a.class);
    if (locala == null)
    {
      locala = new a(paramAppBrandRuntime);
      paramAppBrandRuntime.a((com.tencent.mm.plugin.appbrand.jsapi.n)locala);
    }
    for (paramAppBrandRuntime = locala;; paramAppBrandRuntime = locala)
    {
      AppMethodBeat.o(147972);
      return paramAppBrandRuntime;
    }
  }
  
  public static final void kp(boolean paramBoolean)
  {
    twW = paramBoolean;
  }
  
  public static final void l(ad paramad)
  {
    AppMethodBeat.i(147970);
    s.u(paramad, "page");
    if (paramad.getRuntime() == null)
    {
      AppMethodBeat.o(147970);
      return;
    }
    try
    {
      AppBrandRuntime localAppBrandRuntime = paramad.getRuntime();
      s.s(localAppBrandRuntime, "page.runtime");
      au(localAppBrandRuntime).remove(paramad);
      AppMethodBeat.o(147970);
      return;
    }
    catch (Exception paramad)
    {
      Log.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", s.X("onPageReload ", paramad));
      AppMethodBeat.o(147970);
    }
  }
  
  public static final boolean m(ad paramad)
  {
    AppMethodBeat.i(147971);
    s.u(paramad, "page");
    try
    {
      if (!twW) {
        break label278;
      }
      localObject = (CharSequence)paramad.cgR();
      if (localObject == null) {
        break label300;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label160;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label63:
        Log.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", s.X("canTrimThisPage ", localException));
        label160:
        label170:
        boolean bool = false;
        label278:
        continue;
        int i = 1;
        continue;
        i = 0;
      }
    }
    if (i == 0)
    {
      localObject = paramad.getRuntime();
      if ((localObject != null) && (!((AppBrandRuntime)localObject).mResumed))
      {
        i = 1;
        if (i == 0) {
          break label170;
        }
        localObject = paramad.getRuntime();
        s.checkNotNull(localObject);
        bool = ((AppBrandRuntime)localObject).T(null);
        if (!bool) {
          break label170;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = paramad.getRuntime();
        s.s(localObject, "page.runtime");
        au((AppBrandRuntime)localObject).add(paramad);
        Log.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramad.getAppId() + "] path[" + paramad.cgR() + ']');
      }
      AppMethodBeat.o(147971);
      return bool;
      i = 0;
      break;
      i = 0;
      break label63;
      localObject = paramad.txk;
      if ((localObject == null) || (((u)localObject).tuT != true)) {
        break label305;
      }
      i = 1;
      if ((i != 0) && (!(paramad.txk instanceof n)) && (paramad.getRuntime() != null) && (paramad.getRuntime().getPageContainer() != null) && (paramad.txk != null))
      {
        localObject = paramad.txk;
        s.checkNotNull(localObject);
        if (((u)localObject).qsj == null) {}
        for (i = -1;; i = ((u)localObject).qsj.m((u)localObject))
        {
          if (i >= paramad.getRuntime().getPageContainer().getPageCount() - 5) {
            break label278;
          }
          bool = true;
          break;
        }
      }
      bool = false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "Lkotlin/collections/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends HashSet<ad>
    implements com.tencent.mm.plugin.appbrand.jsapi.n
  {
    public a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(147966);
      paramAppBrandRuntime = paramAppBrandRuntime.qsB;
      if (paramAppBrandRuntime != null) {
        paramAppBrandRuntime.a(new ac.a..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(147966);
    }
    
    private static final void a(a parama, String paramString, b paramb)
    {
      AppMethodBeat.i(324888);
      s.u(parama, "this$0");
      if (paramb == b.qKz) {
        parama.clear();
      }
      AppMethodBeat.o(324888);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */