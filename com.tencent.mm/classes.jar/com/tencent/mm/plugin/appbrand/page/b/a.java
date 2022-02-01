package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<w>
{
  public static final a.a tCO;
  
  static
  {
    AppMethodBeat.i(325090);
    tCO = new a.a((byte)0);
    AppMethodBeat.o(325090);
  }
  
  private static void a(w paramw, int paramInt)
  {
    AppMethodBeat.i(325086);
    Object localObject = paramw.ccN().getCurrentPage();
    g localg;
    h localh;
    String str;
    long l;
    if (localObject != null)
    {
      localg = ((u)localObject).a(i.tCY);
      if (localg != null)
      {
        localh = h.OAn;
        str = paramw.mAppId;
        l = System.currentTimeMillis();
        paramw = paramw.ccN().getCurrentPage();
        if (paramw != null) {
          break label122;
        }
        paramw = "";
        if (paramInt != 1) {
          break label142;
        }
      }
    }
    label142:
    for (localObject = localg.tCT;; localObject = "")
    {
      localh.b(19169, new Object[] { str, Long.valueOf(l), paramw, Integer.valueOf(paramInt), localObject });
      AppMethodBeat.o(325086);
      return;
      label122:
      localObject = paramw.getCurrentUrl();
      paramw = (w)localObject;
      if (localObject != null) {
        break;
      }
      paramw = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.a
 * JD-Core Version:    0.7.0.1
 */