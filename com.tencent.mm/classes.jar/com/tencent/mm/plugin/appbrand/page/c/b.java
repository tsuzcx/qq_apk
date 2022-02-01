package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.report.service.h;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends c<o>
{
  public static final a lGI;
  
  static
  {
    AppMethodBeat.i(175209);
    lGI = new a((byte)0);
    AppMethodBeat.o(175209);
  }
  
  private static void a(o paramo, int paramInt)
  {
    AppMethodBeat.i(175208);
    Object localObject = paramo.aTT();
    k.g(localObject, "runtime.pageContainer");
    localObject = ((v)localObject).getCurrentPage();
    if (localObject != null)
    {
      e locale = ((r)localObject).getNavigateBackInterceptionInfo();
      if (locale != null)
      {
        h localh = h.wUl;
        String str = paramo.getAppId();
        long l = System.currentTimeMillis();
        paramo = paramo.aTT();
        k.g(paramo, "runtime.pageContainer");
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
        for (localObject = locale.lGN;; localObject = "")
        {
          localh.f(19169, new Object[] { str, Long.valueOf(l), paramo, Integer.valueOf(paramInt), localObject });
          AppMethodBeat.o(175208);
          return;
        }
      }
    }
    AppMethodBeat.o(175208);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageNavigateBackInterceptorWC$Companion;", "", "()V", "REPORT_EVENT_CLICK_LEAVE_BUTTON", "", "REPORT_EVENT_CLICK_STAY_BUTTON", "REPORT_EVENT_SHOW_DIALOG", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.b
 * JD-Core Version:    0.7.0.1
 */