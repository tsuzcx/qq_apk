package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"})
public final class i
{
  private static final SparseArray<i> nFl;
  public static final a nFm;
  private final Context appContext;
  public final String lMQ;
  private ad.a nFh;
  private ad.a nFi;
  public final ad nFj;
  public final List<j> nFk;
  
  static
  {
    AppMethodBeat.i(176488);
    nFm = new a((byte)0);
    nFl = new SparseArray();
    AppMethodBeat.o(176488);
  }
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(176487);
    this.lMQ = ("MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode());
    this.appContext = paramActivity.getApplicationContext();
    this.nFh = ad.a.ohA;
    this.nFi = ad.a.ohA;
    this.nFj = new ad(this.appContext, (ad.b)new b(this));
    this.nFk = ((List)new CopyOnWriteArrayList());
    AppMethodBeat.o(176487);
  }
  
  public static final i F(Activity paramActivity)
  {
    AppMethodBeat.i(176490);
    paramActivity = a.F(paramActivity);
    AppMethodBeat.o(176490);
    return paramActivity;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"})
  public static final class a
  {
    public static i F(Activity paramActivity)
    {
      AppMethodBeat.i(176485);
      p.h(paramActivity, "activity");
      int i = paramActivity.hashCode();
      synchronized (i.bTV())
      {
        i locali2 = (i)i.bTV().get(i);
        i locali1 = locali2;
        if (locali2 == null)
        {
          locali1 = new i(paramActivity);
          i.bTV().put(i, locali1);
        }
        AppMethodBeat.o(176485);
        return locali1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class b
    implements ad.b
  {
    b(i parami) {}
    
    public final void a(ad.a parama1, ad.a parama2)
    {
      AppMethodBeat.i(176486);
      boolean bool = i.a(this.nFn);
      Log.d(i.b(this.nFn), "onFourOrientationsChange, newOrientation: " + parama2 + ", isSystemOrientationLocked: " + bool);
      if ((!bool) && (i.c(this.nFn) != parama2))
      {
        parama1 = ((Iterable)i.d(this.nFn)).iterator();
        while (parama1.hasNext())
        {
          j localj = (j)parama1.next();
          p.g(parama2, "newOrientation");
          localj.a(parama2);
        }
        parama1 = this.nFn;
        p.g(parama2, "newOrientation");
        i.a(parama1, parama2);
      }
      parama1 = this.nFn;
      p.g(parama2, "newOrientation");
      i.b(parama1, parama2);
      AppMethodBeat.o(176486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.i
 * JD-Core Version:    0.7.0.1
 */