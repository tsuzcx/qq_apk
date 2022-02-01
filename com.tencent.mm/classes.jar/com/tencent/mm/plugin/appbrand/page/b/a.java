package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<q>
{
  public static final a nvI;
  
  static
  {
    AppMethodBeat.i(229252);
    nvI = new a((byte)0);
    AppMethodBeat.o(229252);
  }
  
  private static void a(q paramq, int paramInt)
  {
    AppMethodBeat.i(229251);
    Object localObject = paramq.bsD();
    p.g(localObject, "runtime.pageContainer");
    localObject = ((x)localObject).getCurrentPage();
    if (localObject != null)
    {
      g localg = ((t)localObject).a(i.nvW);
      if (localg != null)
      {
        h localh = h.CyF;
        String str = paramq.getAppId();
        long l = System.currentTimeMillis();
        paramq = paramq.bsD();
        p.g(paramq, "runtime.pageContainer");
        paramq = paramq.getCurrentPage();
        if (paramq != null)
        {
          localObject = paramq.getCurrentUrl();
          paramq = (q)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramq = "";
        }
        if (paramInt == 1) {}
        for (localObject = localg.nvR;; localObject = "")
        {
          localh.a(19169, new Object[] { str, Long.valueOf(l), paramq, Integer.valueOf(paramInt), localObject });
          AppMethodBeat.o(229251);
          return;
        }
      }
    }
    AppMethodBeat.o(229251);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC$Companion;", "", "()V", "REPORT_EVENT_CLICK_LEAVE_BUTTON", "", "REPORT_EVENT_CLICK_STAY_BUTTON", "REPORT_EVENT_SHOW_DIALOG", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */