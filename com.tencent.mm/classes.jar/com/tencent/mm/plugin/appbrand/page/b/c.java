package com.tencent.mm.plugin.appbrand.page.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class c<T extends AppBrandRuntime>
  implements e<T>
{
  public static final a nvJ;
  
  static
  {
    AppMethodBeat.i(219737);
    nvJ = new a((byte)0);
    AppMethodBeat.o(219737);
  }
  
  public final boolean a(final T paramT, String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(219732);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    Object localObject1 = paramT.brh();
    p.g(localObject1, "runtime.pageContainer");
    localObject1 = ((w)localObject1).getCurrentPage();
    if (localObject1 != null) {}
    for (localObject1 = ((t)localObject1).a(i.nvW); localObject1 == null; localObject1 = null)
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(219732);
      return false;
    }
    if (!((g)localObject1).adY(paramString))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + paramString + "] disable");
      AppMethodBeat.o(219732);
      return false;
    }
    Object localObject2 = paramT.brh();
    p.g(localObject2, "runtime.pageContainer");
    if (((w)localObject2).getPageCount() <= 1)
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
      AppMethodBeat.o(219732);
      return false;
    }
    if (!l(paramT, paramString))
    {
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
      AppMethodBeat.o(219732);
      return false;
    }
    Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
    localObject2 = new b((Context)paramT.getContext());
    if (Util.isNullOrNil(((g)localObject1).nvR)) {}
    for (paramString = "";; paramString = ((g)localObject1).nvR)
    {
      ((b)localObject2).setMessage((CharSequence)paramString);
      ((b)localObject2).setCanceledOnTouchOutside(false);
      ((b)localObject2).setCancelable(false);
      ((b)localObject2).a(2131756118, (DialogInterface.OnClickListener)new b(this, paramRunnable, paramT, (b)localObject2));
      ((b)localObject2).b(2131756119, (DialogInterface.OnClickListener)new c(this, paramT, (b)localObject2));
      paramString = paramT.getDialogContainer();
      if (paramString != null) {
        paramString.b((k)localObject2);
      }
      ai(paramT);
      AppMethodBeat.o(219732);
      return true;
    }
  }
  
  protected void ai(T paramT)
  {
    AppMethodBeat.i(219734);
    p.h(paramT, "runtime");
    AppMethodBeat.o(219734);
  }
  
  protected void aj(T paramT)
  {
    AppMethodBeat.i(219735);
    p.h(paramT, "runtime");
    AppMethodBeat.o(219735);
  }
  
  protected void ak(T paramT)
  {
    AppMethodBeat.i(219736);
    p.h(paramT, "runtime");
    AppMethodBeat.o(219736);
  }
  
  public final e.a bSD()
  {
    return (e.a)e.a.b.nvQ;
  }
  
  public final i bSE()
  {
    return i.nvW;
  }
  
  protected boolean l(T paramT, String paramString)
  {
    AppMethodBeat.i(219733);
    p.h(paramT, "runtime");
    p.h(paramString, "scene");
    AppMethodBeat.o(219733);
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(219730);
      paramDialogInterface = this.nvK;
      Runnable localRunnable = paramRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
      paramDialogInterface.ak(paramT);
      this.nvN.dismiss();
      AppMethodBeat.o(219730);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(c paramc, AppBrandRuntime paramAppBrandRuntime, b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(219731);
      paramDialogInterface = this.nvK;
      Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
      paramDialogInterface.aj(paramT);
      this.nvN.dismiss();
      AppMethodBeat.o(219731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.c
 * JD-Core Version:    0.7.0.1
 */