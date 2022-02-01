package com.tencent.mm.plugin.appbrand.page.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class c<T extends AppBrandRuntime>
  implements e<T>
{
  public static final c.a qxL;
  
  static
  {
    AppMethodBeat.i(246623);
    qxL = new c.a((byte)0);
    AppMethodBeat.o(246623);
  }
  
  public final boolean a(final T paramT, String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(246618);
    p.k(paramT, "runtime");
    p.k(paramString, "scene");
    Object localObject1 = paramT.bBX();
    p.j(localObject1, "runtime.pageContainer");
    localObject1 = ((x)localObject1).getCurrentPage();
    if (localObject1 != null) {}
    for (localObject1 = ((u)localObject1).a(i.qxY); localObject1 == null; localObject1 = null)
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(246618);
      return false;
    }
    if (!((g)localObject1).alT(paramString))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + paramString + "] disable");
      AppMethodBeat.o(246618);
      return false;
    }
    Object localObject2 = paramT.bBX();
    p.j(localObject2, "runtime.pageContainer");
    if (((x)localObject2).getPageCount() <= 1)
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
      AppMethodBeat.o(246618);
      return false;
    }
    if (!m(paramT, paramString))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
      AppMethodBeat.o(246618);
      return false;
    }
    Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
    localObject2 = new b((Context)paramT.getContext());
    if (Util.isNullOrNil(((g)localObject1).qxT)) {}
    for (paramString = "";; paramString = ((g)localObject1).qxT)
    {
      ((b)localObject2).setMessage((CharSequence)paramString);
      ((b)localObject2).setCanceledOnTouchOutside(false);
      ((b)localObject2).setCancelable(false);
      ((b)localObject2).a(a.g.appbrand_navigate_back_confirm_dialog_leave_btn, (DialogInterface.OnClickListener)new b(this, paramRunnable, paramT, (b)localObject2));
      ((b)localObject2).b(a.g.appbrand_navigate_back_confirm_dialog_stay_btn, (DialogInterface.OnClickListener)new c(this, paramT, (b)localObject2));
      paramString = paramT.getDialogContainer();
      if (paramString != null) {
        paramString.a((j)localObject2);
      }
      ai(paramT);
      AppMethodBeat.o(246618);
      return true;
    }
  }
  
  protected void ai(T paramT)
  {
    AppMethodBeat.i(246620);
    p.k(paramT, "runtime");
    AppMethodBeat.o(246620);
  }
  
  protected void aj(T paramT)
  {
    AppMethodBeat.i(246621);
    p.k(paramT, "runtime");
    AppMethodBeat.o(246621);
  }
  
  protected void ak(T paramT)
  {
    AppMethodBeat.i(246622);
    p.k(paramT, "runtime");
    AppMethodBeat.o(246622);
  }
  
  public final e.a cfG()
  {
    return (e.a)e.a.b.qxS;
  }
  
  public final i cfH()
  {
    return i.qxY;
  }
  
  protected boolean m(T paramT, String paramString)
  {
    AppMethodBeat.i(246619);
    p.k(paramT, "runtime");
    p.k(paramString, "scene");
    AppMethodBeat.o(246619);
    return true;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(246499);
      paramDialogInterface = this.qxM;
      Runnable localRunnable = paramRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
      paramDialogInterface.ak(paramT);
      this.qxP.dismiss();
      AppMethodBeat.o(246499);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(c paramc, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(246616);
      paramDialogInterface = this.qxM;
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
      paramDialogInterface.aj(paramT);
      this.qxP.dismiss();
      AppMethodBeat.o(246616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.c
 * JD-Core Version:    0.7.0.1
 */