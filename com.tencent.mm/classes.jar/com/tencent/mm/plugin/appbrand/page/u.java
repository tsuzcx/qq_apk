package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.k;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic;", "", "()V", "TAG", "", "mCanTrim", "", "canTrimThisPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "canTrimThisPageWrapped", "getTrimPages", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageTrimLogic$RuntimeTrimmedPages;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onPageReload", "", "setCanTrim", "can", "RuntimeTrimmedPages", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static boolean ixd;
  public static final u ixe;
  
  static
  {
    AppMethodBeat.i(102480);
    ixe = new u();
    ixd = true;
    AppMethodBeat.o(102480);
  }
  
  private static u.a G(i parami)
  {
    AppMethodBeat.i(102479);
    u.a locala = (u.a)parami.V(u.a.class);
    if (locala == null)
    {
      locala = new u.a(parami);
      parami.a((k)locala);
    }
    for (parami = locala;; parami = locala)
    {
      AppMethodBeat.o(102479);
      return parami;
    }
  }
  
  public static final void e(v paramv)
  {
    AppMethodBeat.i(102477);
    j.q(paramv, "page");
    if (paramv.getRuntime() == null)
    {
      AppMethodBeat.o(102477);
      return;
    }
    try
    {
      i locali = paramv.getRuntime();
      j.p(locali, "page.runtime");
      G(locali).remove(paramv);
      AppMethodBeat.o(102477);
      return;
    }
    catch (Exception paramv)
    {
      d.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload ".concat(String.valueOf(paramv)));
      AppMethodBeat.o(102477);
    }
  }
  
  public static final void eC(boolean paramBoolean)
  {
    ixd = paramBoolean;
  }
  
  public static final boolean f(v paramv)
  {
    AppMethodBeat.i(102478);
    j.q(paramv, "page");
    try
    {
      if (!ixd) {
        break label306;
      }
      localObject = (CharSequence)paramv.getURL();
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
        d.w("Luggage.AppBrandPageTrimLogic[wxa_reload]", "canTrimThisPage ".concat(String.valueOf(localException)));
        boolean bool = false;
        continue;
        int i = 1;
        continue;
        bool = false;
      }
    }
    if (i == 0)
    {
      localObject = paramv.getRuntime();
      if ((localObject != null) && (!((i)localObject).isResumed()))
      {
        localObject = paramv.getRuntime();
        if (localObject == null) {
          j.ebi();
        }
        bool = ((i)localObject).atC();
        if (bool) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = paramv.getRuntime();
        j.p(localObject, "page.runtime");
        G((i)localObject).add(paramv);
        d.i("Luggage.AppBrandPageTrimLogic[wxa_reload]", "page trimmed, appId[" + paramv.getAppId() + "] path[" + paramv.getURL() + ']');
      }
      AppMethodBeat.o(102478);
      return bool;
      i = 0;
      break;
      localObject = paramv.aJj();
      if ((localObject == null) || (((o)localObject).isInBackground() != true)) {
        break label338;
      }
      if ((!(paramv.aJj() instanceof h)) && (paramv.getRuntime() != null))
      {
        localObject = paramv.getRuntime();
        j.p(localObject, "page.runtime");
        if ((((i)localObject).atj() != null) && (paramv.aJj() != null))
        {
          localObject = paramv.aJj();
          if (localObject == null) {
            j.ebi();
          }
          i = ((o)localObject).aIT();
          localObject = paramv.getRuntime();
          j.p(localObject, "page.runtime");
          localObject = ((i)localObject).atj();
          j.p(localObject, "page.runtime.pageContainer");
          int j = ((r)localObject).getPageCount();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */