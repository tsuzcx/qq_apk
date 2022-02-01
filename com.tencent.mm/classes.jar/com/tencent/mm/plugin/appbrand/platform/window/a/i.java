package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.utils.af.a;
import com.tencent.mm.plugin.appbrand.utils.af.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"})
public final class i
{
  private static final SparseArray<i> qHv;
  private static final AtomicBoolean qHw;
  public static final a qHx;
  private final Context appContext;
  public final String bqj;
  private af.a qHr;
  private af.a qHs;
  public final af qHt;
  public final List<j> qHu;
  
  static
  {
    AppMethodBeat.i(176488);
    qHx = new a((byte)0);
    qHv = new SparseArray();
    qHw = new AtomicBoolean(false);
    AppMethodBeat.o(176488);
  }
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(176487);
    this.bqj = ("MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode());
    this.appContext = paramActivity.getApplicationContext();
    this.qHr = af.a.rjo;
    this.qHs = af.a.rjo;
    this.qHt = new af(this.appContext, (af.b)new b(this));
    this.qHu = ((List)new CopyOnWriteArrayList());
    AppMethodBeat.o(176487);
  }
  
  public static final i F(Activity paramActivity)
  {
    AppMethodBeat.i(176490);
    paramActivity = a.F(paramActivity);
    AppMethodBeat.o(176490);
    return paramActivity;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "isActivityLifecycleCallbackRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"})
  public static final class a
  {
    public static i F(Activity paramActivity)
    {
      AppMethodBeat.i(176485);
      p.k(paramActivity, "activity");
      if (!i.cha().getAndSet(true)) {
        paramActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
      }
      int i = paramActivity.hashCode();
      synchronized (i.chb())
      {
        i locali2 = (i)i.chb().get(i);
        i locali1 = locali2;
        if (locali2 == null)
        {
          locali1 = new i(paramActivity);
          i.chb().put(i, locali1);
        }
        AppMethodBeat.o(176485);
        return locali1;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion$get$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"})
    public static final class a
      extends a
    {
      public final void onActivityDestroyed(Activity arg1)
      {
        AppMethodBeat.i(246477);
        p.k(???, "activity");
        super.onActivityDestroyed(???);
        int i = ???.hashCode();
        synchronized (i.chb())
        {
          i.chb().remove(i);
          x localx = x.aazN;
          AppMethodBeat.o(246477);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class b
    implements af.b
  {
    b(i parami) {}
    
    public final void a(af.a parama1, af.a parama2)
    {
      AppMethodBeat.i(176486);
      boolean bool = i.a(this.qHy);
      Log.d(i.b(this.qHy), "onFourOrientationsChange, newOrientation: " + parama2 + ", isSystemOrientationLocked: " + bool);
      if ((!bool) && (i.c(this.qHy) != parama2))
      {
        parama1 = ((Iterable)i.d(this.qHy)).iterator();
        while (parama1.hasNext())
        {
          j localj = (j)parama1.next();
          p.j(parama2, "newOrientation");
          localj.a(parama2);
        }
        parama1 = this.qHy;
        p.j(parama2, "newOrientation");
        i.a(parama1, parama2);
      }
      parama1 = this.qHy;
      p.j(parama2, "newOrientation");
      i.b(parama1, parama2);
      AppMethodBeat.o(176486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.i
 * JD-Core Version:    0.7.0.1
 */