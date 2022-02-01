package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<t>
{
  public static final a.a qxK;
  
  static
  {
    AppMethodBeat.i(268157);
    qxK = new a.a((byte)0);
    AppMethodBeat.o(268157);
  }
  
  private static void a(t paramt, int paramInt)
  {
    AppMethodBeat.i(268156);
    Object localObject = paramt.bDz();
    p.j(localObject, "runtime.pageContainer");
    localObject = ((y)localObject).getCurrentPage();
    if (localObject != null)
    {
      g localg = ((u)localObject).a(i.qxY);
      if (localg != null)
      {
        h localh = h.IzE;
        String str = paramt.getAppId();
        long l = System.currentTimeMillis();
        paramt = paramt.bDz();
        p.j(paramt, "runtime.pageContainer");
        paramt = paramt.getCurrentPage();
        if (paramt != null)
        {
          localObject = paramt.getCurrentUrl();
          paramt = (t)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramt = "";
        }
        if (paramInt == 1) {}
        for (localObject = localg.qxT;; localObject = "")
        {
          localh.a(19169, new Object[] { str, Long.valueOf(l), paramt, Integer.valueOf(paramInt), localObject });
          AppMethodBeat.o(268156);
          return;
        }
      }
    }
    AppMethodBeat.o(268156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */