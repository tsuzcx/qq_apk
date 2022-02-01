package com.tencent.mm.plugin.appbrand.page.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", "Companion", "luggage-wxa-app_release"})
public class c<T extends AppBrandRuntime>
  implements d<T>
{
  public static final a lgP;
  
  static
  {
    AppMethodBeat.i(176468);
    lgP = new a((byte)0);
    AppMethodBeat.o(176468);
  }
  
  public final boolean a(final T paramT, String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(176463);
    d.g.b.k.h(paramT, "runtime");
    d.g.b.k.h(paramString, "scene");
    d.g.b.k.h(paramRunnable, "continueNavigateBack");
    Object localObject1 = paramT.aLK();
    d.g.b.k.g(localObject1, "runtime.pageContainer");
    localObject1 = ((t)localObject1).getCurrentPage();
    if (localObject1 != null) {}
    for (localObject1 = ((q)localObject1).getNavigateBackInterceptionInfo(); localObject1 == null; localObject1 = null)
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
      AppMethodBeat.o(176463);
      return false;
    }
    if (!((e)localObject1).enable)
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo.enable = " + ((e)localObject1).enable);
      AppMethodBeat.o(176463);
      return false;
    }
    if (((d.g.b.k.g(paramString, "scene_back_key_pressed") ^ true)) && ((d.g.b.k.g(paramString, "scene_jsapi_navigate_back") ^ true)) && ((d.g.b.k.g(paramString, "scene_actionbar_back") ^ true)))
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene[" + paramString + "], no necessary to intercept");
      AppMethodBeat.o(176463);
      return false;
    }
    Object localObject2 = paramT.aLK();
    d.g.b.k.g(localObject2, "runtime.pageContainer");
    if (((t)localObject2).getPageCount() <= 1)
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
      AppMethodBeat.o(176463);
      return false;
    }
    if (!l(paramT, paramString))
    {
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
      AppMethodBeat.o(176463);
      return false;
    }
    ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
    localObject2 = new b((Context)paramT.getContext());
    if (bt.isNullOrNil(((e)localObject1).lgT)) {}
    for (paramString = "";; paramString = ((e)localObject1).lgT)
    {
      ((b)localObject2).setMessage((CharSequence)paramString);
      ((b)localObject2).setCanceledOnTouchOutside(false);
      ((b)localObject2).setCancelable(false);
      ((b)localObject2).a(2131756003, (DialogInterface.OnClickListener)new b(this, paramRunnable, paramT));
      ((b)localObject2).b(2131756004, (DialogInterface.OnClickListener)new c(this, paramT));
      paramString = paramT.aLB();
      if (paramString != null) {
        paramString.b((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject2);
      }
      an(paramT);
      AppMethodBeat.o(176463);
      return true;
    }
  }
  
  protected void an(T paramT)
  {
    AppMethodBeat.i(176465);
    d.g.b.k.h(paramT, "runtime");
    AppMethodBeat.o(176465);
  }
  
  protected void ao(T paramT)
  {
    AppMethodBeat.i(176466);
    d.g.b.k.h(paramT, "runtime");
    AppMethodBeat.o(176466);
  }
  
  protected void ap(T paramT)
  {
    AppMethodBeat.i(176467);
    d.g.b.k.h(paramT, "runtime");
    AppMethodBeat.o(176467);
  }
  
  protected boolean l(T paramT, String paramString)
  {
    AppMethodBeat.i(176464);
    d.g.b.k.h(paramT, "runtime");
    d.g.b.k.h(paramString, "scene");
    AppMethodBeat.o(176464);
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageNavigateBackInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(c paramc, Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(176461);
      c localc = this.lgQ;
      paramRunnable.run();
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
      localc.ap(paramT);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(176461);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(c paramc, AppBrandRuntime paramAppBrandRuntime) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(176462);
      c localc = this.lgQ;
      ad.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
      localc.ao(paramT);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(176462);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c
 * JD-Core Version:    0.7.0.1
 */