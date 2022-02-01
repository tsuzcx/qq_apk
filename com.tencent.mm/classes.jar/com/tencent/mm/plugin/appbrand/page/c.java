package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore;", "()V", "addOnBackPressedListener", "", "p0", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackPressedListener;", "kotlin.jvm.PlatformType", "addOnBackgroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "addOnDestroyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "addOnForegroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "addOnInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnInteractiveListener;", "addOnNonInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnNonInteractiveListener;", "addOnReadyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "addOnWillDisappearListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnWillDisappearListener;", "callInteractiveStateChanged", "", "callOnBackPressed", "callOnViewWillDisappear", "callPageOnBackground", "callPageOnDestroy", "callPageOnForeground", "callPageOnReady", "getContentView", "Landroid/view/View;", "hide", "post", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "removeAllLifecycleListeners", "removeCallbacks", "removeOnBackPressedListener", "removeOnBackgroundListener", "removeOnDestroyListener", "removeOnForegroundListener", "removeOnInteractiveListener", "removeOnNonInteractiveListener", "removeOnReadyListener", "removeOnWillDisappearListener", "runOnUiThread", "show", "luggage-wxa-app_release"})
public abstract class c
  extends d
  implements f
{
  public final void a(f.b paramb)
  {
    this.kXJ.a(paramb);
  }
  
  public final void a(f.c paramc)
  {
    this.kXJ.a(paramc);
  }
  
  public final void a(f.d paramd)
  {
    this.kXJ.a(paramd);
  }
  
  public final void a(f.e parame)
  {
    this.kXJ.a(parame);
  }
  
  public final void a(f.f paramf)
  {
    this.kXJ.a(paramf);
  }
  
  public final void b(f.b paramb)
  {
    this.kXJ.b(paramb);
  }
  
  public final void b(f.c paramc)
  {
    this.kXJ.b(paramc);
  }
  
  public final void b(f.d paramd)
  {
    this.kXJ.b(paramd);
  }
  
  public final void b(f.e parame)
  {
    this.kXJ.b(parame);
  }
  
  public final void b(f.f paramf)
  {
    this.kXJ.b(paramf);
  }
  
  public final void fL(boolean paramBoolean)
  {
    this.kXJ.fL(paramBoolean);
  }
  
  public abstract View getContentView();
  
  public final void post(Runnable paramRunnable)
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
  
  public final void removeCallbacks(Runnable paramRunnable)
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
    if (aq.isMainThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c
 * JD-Core Version:    0.7.0.1
 */