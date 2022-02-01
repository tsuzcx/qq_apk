package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"})
public final class i
{
  private static final SparseArray<i> muC;
  public static final a muD;
  private final Context appContext;
  public final String kIm;
  public final ad muA;
  public final List<j> muB;
  private ad.a muy;
  private ad.a muz;
  
  static
  {
    AppMethodBeat.i(176488);
    muD = new a((byte)0);
    muC = new SparseArray();
    AppMethodBeat.o(176488);
  }
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(176487);
    this.kIm = ("MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode());
    this.appContext = paramActivity.getApplicationContext();
    this.muy = ad.a.mUz;
    this.muz = ad.a.mUz;
    this.muA = new ad(this.appContext, (ad.b)new b(this));
    this.muB = ((List)new CopyOnWriteArrayList());
    AppMethodBeat.o(176487);
  }
  
  public static final i E(Activity paramActivity)
  {
    AppMethodBeat.i(176490);
    paramActivity = a.E(paramActivity);
    AppMethodBeat.o(176490);
    return paramActivity;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"})
  public static final class a
  {
    public static i E(Activity paramActivity)
    {
      AppMethodBeat.i(176485);
      p.h(paramActivity, "activity");
      int i = paramActivity.hashCode();
      synchronized (i.bxK())
      {
        i locali2 = (i)i.bxK().get(i);
        i locali1 = locali2;
        if (locali2 == null)
        {
          locali1 = new i(paramActivity);
          i.bxK().put(i, locali1);
        }
        AppMethodBeat.o(176485);
        return locali1;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class b
    implements ad.b
  {
    b(i parami) {}
    
    public final void a(ad.a parama1, ad.a parama2)
    {
      AppMethodBeat.i(176486);
      boolean bool = i.a(this.muE);
      ae.d(i.b(this.muE), "onFourOrientationsChange, newOrientation: " + parama2 + ", isSystemOrientationLocked: " + bool);
      if ((!bool) && (i.c(this.muE) != parama2))
      {
        parama1 = ((Iterable)i.d(this.muE)).iterator();
        while (parama1.hasNext())
        {
          j localj = (j)parama1.next();
          p.g(parama2, "newOrientation");
          localj.a(parama2);
        }
        parama1 = this.muE;
        p.g(parama2, "newOrientation");
        i.a(parama1, parama2);
      }
      parama1 = this.muE;
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