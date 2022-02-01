package com.tencent.mm.plugin.appbrand.page.b;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c<T extends AppBrandRuntime>
  implements e<T>
{
  public static final c.a tCP;
  
  static
  {
    AppMethodBeat.i(325108);
    tCP = new c.a((byte)0);
    AppMethodBeat.o(325108);
  }
  
  private static final void a(c paramc, AppBrandRuntime paramAppBrandRuntime, b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(325102);
    s.u(paramc, "this$0");
    s.u(paramAppBrandRuntime, "$runtime");
    s.u(paramb, "$dialog");
    Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
    paramc.ax(paramAppBrandRuntime);
    paramb.dismiss();
    AppMethodBeat.o(325102);
  }
  
  private static final void a(c paramc, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime, b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(325095);
    s.u(paramc, "this$0");
    s.u(paramAppBrandRuntime, "$runtime");
    s.u(paramb, "$dialog");
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
    paramc.ay(paramAppBrandRuntime);
    paramb.dismiss();
    AppMethodBeat.o(325095);
  }
  
  public final boolean a(T paramT, String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(325127);
    s.u(paramT, "runtime");
    s.u(paramString, "scene");
    Object localObject = paramT.getPageContainer().getCurrentPage();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((u)localObject).a(i.tCY))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(325127);
      return false;
    }
    if (!((g)localObject).afc(paramString))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + paramString + "] disable");
      AppMethodBeat.o(325127);
      return false;
    }
    if (paramT.getPageContainer().getPageCount() <= 1)
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
      AppMethodBeat.o(325127);
      return false;
    }
    if (!m(paramT, paramString))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
      AppMethodBeat.o(325127);
      return false;
    }
    Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
    b localb = new b((Context)AndroidContextUtil.castActivityOrNull(paramT.mContext));
    if (Util.isNullOrNil(((g)localObject).tCT)) {}
    for (paramString = "";; paramString = ((g)localObject).tCT)
    {
      localb.setMessage((CharSequence)paramString);
      localb.setCanceledOnTouchOutside(false);
      localb.setCancelable(false);
      localb.a(a.g.appbrand_navigate_back_confirm_dialog_leave_btn, new c..ExternalSyntheticLambda1(this, paramRunnable, paramT, localb));
      localb.b(a.g.appbrand_navigate_back_confirm_dialog_stay_btn, new c..ExternalSyntheticLambda0(this, paramT, localb));
      paramString = paramT.pmu;
      if (paramString != null) {
        paramString.b((n)localb);
      }
      aw(paramT);
      AppMethodBeat.o(325127);
      return true;
    }
  }
  
  protected void aw(T paramT)
  {
    AppMethodBeat.i(325132);
    s.u(paramT, "runtime");
    AppMethodBeat.o(325132);
  }
  
  protected void ax(T paramT)
  {
    AppMethodBeat.i(325136);
    s.u(paramT, "runtime");
    AppMethodBeat.o(325136);
  }
  
  protected void ay(T paramT)
  {
    AppMethodBeat.i(325138);
    s.u(paramT, "runtime");
    AppMethodBeat.o(325138);
  }
  
  public final e.a cGt()
  {
    return (e.a)e.a.b.tCS;
  }
  
  public final i cGu()
  {
    return i.tCY;
  }
  
  protected boolean m(T paramT, String paramString)
  {
    AppMethodBeat.i(325131);
    s.u(paramT, "runtime");
    s.u(paramString, "scene");
    AppMethodBeat.o(325131);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.c
 * JD-Core Version:    0.7.0.1
 */