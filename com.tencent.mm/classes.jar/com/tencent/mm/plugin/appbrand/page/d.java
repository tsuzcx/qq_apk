package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.e;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore;", "()V", "addOnBackPressedListener", "", "p0", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackPressedListener;", "kotlin.jvm.PlatformType", "addOnBackgroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "addOnDestroyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "addOnForegroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "addOnInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnInteractiveListener;", "addOnNonInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnNonInteractiveListener;", "addOnReadyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "addOnWillDisappearListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnWillDisappearListener;", "callInteractiveStateChanged", "", "callOnBackPressed", "callOnViewWillDisappear", "callPageOnBackground", "callPageOnDestroy", "callPageOnForeground", "callPageOnReady", "getContentView", "Landroid/view/View;", "hide", "post", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "removeAllLifecycleListeners", "removeCallbacks", "removeOnBackPressedListener", "removeOnBackgroundListener", "removeOnDestroyListener", "removeOnForegroundListener", "removeOnInteractiveListener", "removeOnNonInteractiveListener", "removeOnReadyListener", "removeOnWillDisappearListener", "runOnUiThread", "show", "luggage-wxa-app_release"})
public abstract class d
  extends com.tencent.mm.plugin.appbrand.d
  implements i
{
  public final void a(i.b paramb)
  {
    this.nnC.a(paramb);
  }
  
  public final void a(i.c paramc)
  {
    this.nnC.a(paramc);
  }
  
  public final void a(i.d paramd)
  {
    this.nnC.a(paramd);
  }
  
  public final void a(i.e parame)
  {
    this.nnC.a(parame);
  }
  
  public final void a(i.f paramf)
  {
    this.nnC.a(paramf);
  }
  
  public final void b(i.b paramb)
  {
    this.nnC.b(paramb);
  }
  
  public final void b(i.c paramc)
  {
    this.nnC.b(paramc);
  }
  
  public final void b(i.d paramd)
  {
    this.nnC.b(paramd);
  }
  
  public final void b(i.e parame)
  {
    this.nnC.b(parame);
  }
  
  public final void b(i.f paramf)
  {
    this.nnC.b(paramf);
  }
  
  public void c(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {}
    View localView;
    do
    {
      return;
      localView = getContentView();
    } while (localView == null);
    localView.postDelayed(paramRunnable, paramLong);
  }
  
  public abstract View getContentView();
  
  public final void hh(boolean paramBoolean)
  {
    this.nnC.hh(paramBoolean);
  }
  
  protected final void hide()
  {
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    View localView;
    do
    {
      return;
      localView = getContentView();
    } while (localView == null);
    localView.post(paramRunnable);
  }
  
  public void removeCallbacks(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    View localView;
    do
    {
      return;
      localView = getContentView();
    } while (localView == null);
    localView.removeCallbacks(paramRunnable);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */