package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<o>
{
  public static final a mgk;
  
  static
  {
    AppMethodBeat.i(189558);
    mgk = new a((byte)0);
    AppMethodBeat.o(189558);
  }
  
  private static void a(o paramo, int paramInt)
  {
    AppMethodBeat.i(189557);
    Object localObject = paramo.aXd();
    p.g(localObject, "runtime.pageContainer");
    localObject = ((v)localObject).getCurrentPage();
    if (localObject != null)
    {
      f localf = ((r)localObject).a(h.mgz);
      if (localf != null)
      {
        g localg = g.yhR;
        String str = paramo.getAppId();
        long l = System.currentTimeMillis();
        paramo = paramo.aXd();
        p.g(paramo, "runtime.pageContainer");
        paramo = paramo.getCurrentPage();
        if (paramo != null)
        {
          localObject = paramo.getCurrentUrl();
          paramo = (o)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramo = "";
        }
        if (paramInt == 1) {}
        for (localObject = localf.mgu;; localObject = "")
        {
          localg.f(19169, new Object[] { str, Long.valueOf(l), paramo, Integer.valueOf(paramInt), localObject });
          AppMethodBeat.o(189557);
          return;
        }
      }
    }
    AppMethodBeat.o(189557);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC$Companion;", "", "()V", "REPORT_EVENT_CLICK_LEAVE_BUTTON", "", "REPORT_EVENT_CLICK_STAY_BUTTON", "REPORT_EVENT_SHOW_DIALOG", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */