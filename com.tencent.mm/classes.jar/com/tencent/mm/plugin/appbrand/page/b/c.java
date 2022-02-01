package com.tencent.mm.plugin.appbrand.page.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class c<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a mll;
  
  static
  {
    AppMethodBeat.i(208121);
    mll = new a((byte)0);
    AppMethodBeat.o(208121);
  }
  
  public final boolean a(final T paramT, String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(208116);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    Object localObject1 = paramT.aWm();
    p.g(localObject1, "runtime.pageContainer");
    localObject1 = ((t)localObject1).getCurrentPage();
    if (localObject1 != null) {}
    for (localObject1 = ((q)localObject1).a(i.mly); localObject1 == null; localObject1 = null)
    {
      ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(208116);
      return false;
    }
    if (!((g)localObject1).Uk(paramString))
    {
      ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + paramString + "] disable");
      AppMethodBeat.o(208116);
      return false;
    }
    Object localObject2 = paramT.aWm();
    p.g(localObject2, "runtime.pageContainer");
    if (((t)localObject2).getPageCount() <= 1)
    {
      ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
      AppMethodBeat.o(208116);
      return false;
    }
    if (!l(paramT, paramString))
    {
      ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
      AppMethodBeat.o(208116);
      return false;
    }
    ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
    localObject2 = new b((Context)paramT.getContext());
    if (bu.isNullOrNil(((g)localObject1).mlt)) {}
    for (paramString = "";; paramString = ((g)localObject1).mlt)
    {
      ((b)localObject2).setMessage((CharSequence)paramString);
      ((b)localObject2).setCanceledOnTouchOutside(false);
      ((b)localObject2).setCancelable(false);
      ((b)localObject2).a(2131756003, (DialogInterface.OnClickListener)new b(this, paramRunnable, paramT, (b)localObject2));
      ((b)localObject2).b(2131756004, (DialogInterface.OnClickListener)new c(this, paramT, (b)localObject2));
      paramString = paramT.aWd();
      if (paramString != null) {
        paramString.b((k)localObject2);
      }
      ah(paramT);
      AppMethodBeat.o(208116);
      return true;
    }
  }
  
  protected void ah(T paramT)
  {
    AppMethodBeat.i(208118);
    p.h(paramT, "runtime");
    AppMethodBeat.o(208118);
  }
  
  protected void ai(T paramT)
  {
    AppMethodBeat.i(208119);
    p.h(paramT, "runtime");
    AppMethodBeat.o(208119);
  }
  
  protected void aj(T paramT)
  {
    AppMethodBeat.i(208120);
    p.h(paramT, "runtime");
    AppMethodBeat.o(208120);
  }
  
  public final e.a bwv()
  {
    return (e.a)e.a.b.mls;
  }
  
  public final i bww()
  {
    return i.mly;
  }
  
  protected boolean l(T paramT, String paramString)
  {
    AppMethodBeat.i(208117);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    AppMethodBeat.o(208117);
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(208114);
      paramDialogInterface = this.mlm;
      Runnable localRunnable = paramRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
      ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
      paramDialogInterface.aj(paramT);
      this.mlp.dismiss();
      AppMethodBeat.o(208114);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(c paramc, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(208115);
      paramDialogInterface = this.mlm;
      ae.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
      paramDialogInterface.ai(paramT);
      this.mlp.dismiss();
      AppMethodBeat.o(208115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.c
 * JD-Core Version:    0.7.0.1
 */