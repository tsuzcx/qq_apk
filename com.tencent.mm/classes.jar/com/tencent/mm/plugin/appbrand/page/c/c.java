package com.tencent.mm.plugin.appbrand.page.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class c<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a mgl;
  
  static
  {
    AppMethodBeat.i(197512);
    mgl = new a((byte)0);
    AppMethodBeat.o(197512);
  }
  
  public final boolean a(final T paramT, String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(197507);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    Object localObject1 = paramT.aVN();
    p.g(localObject1, "runtime.pageContainer");
    localObject1 = ((u)localObject1).getCurrentPage();
    if (localObject1 != null) {}
    for (localObject1 = ((r)localObject1).a(h.mgz); localObject1 == null; localObject1 = null)
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(197507);
      return false;
    }
    if (!((f)localObject1).TB(paramString))
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + paramString + "] disable");
      AppMethodBeat.o(197507);
      return false;
    }
    Object localObject2 = paramT.aVN();
    p.g(localObject2, "runtime.pageContainer");
    if (((u)localObject2).getPageCount() <= 1)
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
      AppMethodBeat.o(197507);
      return false;
    }
    if (!l(paramT, paramString))
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
      AppMethodBeat.o(197507);
      return false;
    }
    ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
    localObject2 = new b((Context)paramT.getContext());
    if (bt.isNullOrNil(((f)localObject1).mgu)) {}
    for (paramString = "";; paramString = ((f)localObject1).mgu)
    {
      ((b)localObject2).setMessage((CharSequence)paramString);
      ((b)localObject2).setCanceledOnTouchOutside(false);
      ((b)localObject2).setCancelable(false);
      ((b)localObject2).a(2131756003, (DialogInterface.OnClickListener)new b(this, paramRunnable, paramT, (b)localObject2));
      ((b)localObject2).b(2131756004, (DialogInterface.OnClickListener)new c(this, paramT, (b)localObject2));
      paramString = paramT.aVE();
      if (paramString != null) {
        paramString.b((k)localObject2);
      }
      ah(paramT);
      AppMethodBeat.o(197507);
      return true;
    }
  }
  
  protected void ah(T paramT)
  {
    AppMethodBeat.i(197509);
    p.h(paramT, "runtime");
    AppMethodBeat.o(197509);
  }
  
  protected void ai(T paramT)
  {
    AppMethodBeat.i(197510);
    p.h(paramT, "runtime");
    AppMethodBeat.o(197510);
  }
  
  protected void aj(T paramT)
  {
    AppMethodBeat.i(197511);
    p.h(paramT, "runtime");
    AppMethodBeat.o(197511);
  }
  
  public final e.a bvE()
  {
    return (e.a)e.a.b.mgt;
  }
  
  public final h bvF()
  {
    return h.mgz;
  }
  
  protected boolean l(T paramT, String paramString)
  {
    AppMethodBeat.i(197508);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    AppMethodBeat.o(197508);
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(197505);
      paramDialogInterface = this.mgm;
      Runnable localRunnable = paramRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
      paramDialogInterface.aj(paramT);
      this.mgp.dismiss();
      AppMethodBeat.o(197505);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(c paramc, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(197506);
      paramDialogInterface = this.mgm;
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
      paramDialogInterface.ai(paramT);
      this.mgp.dismiss();
      AppMethodBeat.o(197506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c
 * JD-Core Version:    0.7.0.1
 */