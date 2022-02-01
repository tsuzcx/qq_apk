package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<com.tencent.mm.plugin.appbrand.p>
{
  public static final a mlk;
  
  static
  {
    AppMethodBeat.i(223827);
    mlk = new a((byte)0);
    AppMethodBeat.o(223827);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.p paramp, int paramInt)
  {
    AppMethodBeat.i(223826);
    Object localObject = paramp.aXy();
    d.g.b.p.g(localObject, "runtime.pageContainer");
    localObject = ((u)localObject).getCurrentPage();
    if (localObject != null)
    {
      g localg1 = ((q)localObject).a(i.mly);
      if (localg1 != null)
      {
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
        String str = paramp.getAppId();
        long l = System.currentTimeMillis();
        paramp = paramp.aXy();
        d.g.b.p.g(paramp, "runtime.pageContainer");
        paramp = paramp.getCurrentPage();
        if (paramp != null)
        {
          localObject = paramp.getCurrentUrl();
          paramp = (com.tencent.mm.plugin.appbrand.p)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramp = "";
        }
        if (paramInt == 1) {}
        for (localObject = localg1.mlt;; localObject = "")
        {
          localg.f(19169, new Object[] { str, Long.valueOf(l), paramp, Integer.valueOf(paramInt), localObject });
          AppMethodBeat.o(223826);
          return;
        }
      }
    }
    AppMethodBeat.o(223826);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC$Companion;", "", "()V", "REPORT_EVENT_CLICK_LEAVE_BUTTON", "", "REPORT_EVENT_CLICK_STAY_BUTTON", "REPORT_EVENT_SHOW_DIALOG", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */