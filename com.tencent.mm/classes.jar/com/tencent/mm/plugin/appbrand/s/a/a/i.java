package com.tencent.mm.plugin.appbrand.s.a.a;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"})
public final class i
{
  private static final SparseArray<i> lnL;
  public static final a lnM;
  public final String jJy;
  private final Context kob;
  private z.a lnH;
  private z.a lnI;
  public final z lnJ;
  public final List<j> lnK;
  
  static
  {
    AppMethodBeat.i(176488);
    lnM = new a((byte)0);
    lnL = new SparseArray();
    AppMethodBeat.o(176488);
  }
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(176487);
    this.jJy = ("MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode());
    this.kob = paramActivity.getApplicationContext();
    this.lnH = z.a.lMO;
    this.lnI = z.a.lMO;
    this.lnJ = new z(this.kob, (z.b)new b(this));
    this.lnK = ((List)new CopyOnWriteArrayList());
    AppMethodBeat.o(176487);
  }
  
  public static final i D(Activity paramActivity)
  {
    AppMethodBeat.i(176490);
    paramActivity = a.D(paramActivity);
    AppMethodBeat.o(176490);
    return paramActivity;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"})
  public static final class a
  {
    public static i D(Activity paramActivity)
    {
      AppMethodBeat.i(176485);
      k.h(paramActivity, "activity");
      int i = paramActivity.hashCode();
      synchronized (i.blS())
      {
        i locali2 = (i)i.blS().get(i);
        i locali1 = locali2;
        if (locali2 == null)
        {
          locali1 = new i(paramActivity);
          i.blS().put(i, locali1);
        }
        AppMethodBeat.o(176485);
        return locali1;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class b
    implements z.b
  {
    b(i parami) {}
    
    public final void a(z.a parama1, z.a parama2)
    {
      AppMethodBeat.i(176486);
      boolean bool = i.a(this.lnN);
      ad.d(i.b(this.lnN), "onFourOrientationsChange, newOrientation: " + parama2 + ", isSystemOrientationLocked: " + bool);
      if ((!bool) && (i.c(this.lnN) != parama2))
      {
        parama1 = ((Iterable)i.d(this.lnN)).iterator();
        while (parama1.hasNext())
        {
          j localj = (j)parama1.next();
          k.g(parama2, "newOrientation");
          localj.a(parama2);
        }
        parama1 = this.lnN;
        k.g(parama2, "newOrientation");
        i.a(parama1, parama2);
      }
      parama1 = this.lnN;
      k.g(parama2, "newOrientation");
      i.b(parama1, parama2);
      AppMethodBeat.o(176486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.i
 * JD-Core Version:    0.7.0.1
 */