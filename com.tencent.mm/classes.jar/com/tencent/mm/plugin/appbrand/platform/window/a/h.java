package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.provider.Settings.System;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.a;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a tMb;
  private static final SparseArray<h> tMg;
  private static final AtomicBoolean tMh;
  private final Context appContext;
  public final String djQ;
  private ak.a tMc;
  private ak.a tMd;
  public final ak tMe;
  public final List<i> tMf;
  
  static
  {
    AppMethodBeat.i(176488);
    tMb = new a((byte)0);
    tMg = new SparseArray();
    tMh = new AtomicBoolean(false);
    AppMethodBeat.o(176488);
  }
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(176487);
    this.djQ = s.X("MicroMsg.AppBrand.AppBrandOrientationObservable#", Integer.valueOf(hashCode()));
    this.appContext = paramActivity.getApplicationContext();
    this.tMc = ak.a.urD;
    this.tMd = ak.a.urD;
    this.tMe = new ak(this.appContext, new h..ExternalSyntheticLambda0(this));
    this.tMf = ((List)new CopyOnWriteArrayList());
    AppMethodBeat.o(176487);
  }
  
  public static final h L(Activity paramActivity)
  {
    AppMethodBeat.i(176490);
    paramActivity = a.L(paramActivity);
    AppMethodBeat.o(176490);
    return paramActivity;
  }
  
  private static final void a(h paramh, ak.a parama1, ak.a parama2)
  {
    boolean bool = false;
    AppMethodBeat.i(317531);
    s.u(paramh, "this$0");
    if (Settings.System.getInt(paramh.appContext.getContentResolver(), "accelerometer_rotation", 0) == 0) {
      bool = true;
    }
    Log.d(paramh.djQ, "onFourOrientationsChange, newOrientation: " + parama2 + ", isSystemOrientationLocked: " + bool);
    if ((!bool) && (paramh.tMc != parama2))
    {
      parama1 = ((Iterable)paramh.tMf).iterator();
      while (parama1.hasNext())
      {
        i locali = (i)parama1.next();
        s.s(parama2, "newOrientation");
        locali.a(parama2);
      }
      s.s(parama2, "newOrientation");
      paramh.tMc = parama2;
    }
    s.s(parama2, "newOrientation");
    paramh.tMd = parama2;
    AppMethodBeat.o(317531);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "getActivity2OrientationObservableMap$annotations", "isActivityLifecycleCallbackRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static h L(Activity paramActivity)
    {
      AppMethodBeat.i(176485);
      s.u(paramActivity, "activity");
      if (!h.cHX().getAndSet(true)) {
        paramActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
      }
      int i = paramActivity.hashCode();
      synchronized (h.cHY())
      {
        h localh2 = (h)h.cHY().get(i);
        h localh1 = localh2;
        if (localh2 == null)
        {
          localh1 = new h(paramActivity);
          h.cHY().put(i, localh1);
        }
        AppMethodBeat.o(176485);
        return localh1;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion$get$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends a
    {
      public final void onActivityDestroyed(Activity arg1)
      {
        AppMethodBeat.i(317523);
        s.u(???, "activity");
        super.onActivityDestroyed(???);
        int i = ???.hashCode();
        synchronized (h.cHY())
        {
          h.cHY().remove(i);
          ah localah = ah.aiuX;
          AppMethodBeat.o(317523);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.h
 * JD-Core Version:    0.7.0.1
 */