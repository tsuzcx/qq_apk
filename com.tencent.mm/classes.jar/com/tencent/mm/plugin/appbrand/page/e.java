package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore;", "()V", "addOnBackPressedListener", "", "p0", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackPressedListener;", "kotlin.jvm.PlatformType", "addOnBackgroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "addOnDestroyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "addOnForegroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "addOnInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnInteractiveListener;", "addOnNonInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnNonInteractiveListener;", "addOnReadyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "addOnWillDisappearListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnWillDisappearListener;", "callInteractiveStateChanged", "", "callOnBackPressed", "callOnViewWillDisappear", "callPageOnBackground", "callPageOnDestroy", "callPageOnForeground", "callPageOnReady", "getContentView", "Landroid/view/View;", "hide", "post", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "removeAllLifecycleListeners", "removeCallbacks", "removeOnBackPressedListener", "removeOnBackgroundListener", "removeOnDestroyListener", "removeOnForegroundListener", "removeOnInteractiveListener", "removeOnNonInteractiveListener", "removeOnReadyListener", "removeOnWillDisappearListener", "runOnUiThread", "show", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  extends g
  implements i
{
  public final void a(i.b paramb)
  {
    this.ttM.a(paramb);
  }
  
  public final void a(i.c paramc)
  {
    this.ttM.a(paramc);
  }
  
  public final void a(i.d paramd)
  {
    this.ttM.a(paramd);
  }
  
  public final void a(i.f paramf)
  {
    this.ttM.a(paramf);
  }
  
  public final void b(i.b paramb)
  {
    this.ttM.b(paramb);
  }
  
  public final void b(i.c paramc)
  {
    this.ttM.b(paramc);
  }
  
  public final void b(i.d paramd)
  {
    this.ttM.b(paramd);
  }
  
  public final void b(i.f paramf)
  {
    this.ttM.rwl.remove(paramf);
  }
  
  public final void cDO()
  {
    j localj = this.ttM;
    Iterator localIterator = localj.rwm.iterator();
    while (localIterator.hasNext()) {
      ((i.b)localIterator.next()).onBackground();
    }
    localj.iW(false);
  }
  
  public final void cDP()
  {
    j localj = this.ttM;
    Iterator localIterator = localj.rwn.iterator();
    while (localIterator.hasNext()) {
      ((i.d)localIterator.next()).onForeground();
    }
    localj.iW(true);
  }
  
  public void d(Runnable paramRunnable, long paramLong)
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
  
  public void hide()
  {
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
  
  public final void iW(boolean paramBoolean)
  {
    this.ttM.iW(paramBoolean);
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
  
  public void show()
  {
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.e
 * JD-Core Version:    0.7.0.1
 */