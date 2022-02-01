package com.tencent.mm.plugin.appbrand.r.a.a;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.aa.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "isSystemOrientationLocked", "", "()Z", "lastNotifiedOrientation", "myTag", "", "orientationObserver", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper;", "orientationObservers", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObserver;", "addOrientationObserver", "", "onPause", "onResume", "removeOrientationObserver", "Companion", "luggage-wxa-app_release"})
public final class i
{
  private static final SparseArray<i> lPM;
  public static final a lPN;
  private final Context appContext;
  public final String kjY;
  private aa.a lPI;
  private aa.a lPJ;
  public final aa lPK;
  public final List<j> lPL;
  
  static
  {
    AppMethodBeat.i(176488);
    lPN = new a((byte)0);
    lPM = new SparseArray();
    AppMethodBeat.o(176488);
  }
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(176487);
    this.kjY = ("MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode());
    this.appContext = paramActivity.getApplicationContext();
    this.lPI = aa.a.moO;
    this.lPJ = aa.a.moO;
    this.lPK = new aa(this.appContext, (aa.b)new b(this));
    this.lPL = ((List)new CopyOnWriteArrayList());
    AppMethodBeat.o(176487);
  }
  
  public static final i D(Activity paramActivity)
  {
    AppMethodBeat.i(176490);
    paramActivity = a.D(paramActivity);
    AppMethodBeat.o(176490);
    return paramActivity;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable$Companion;", "", "()V", "SYSTEM_ACCELEROMETER_ROTATION_DEFAULT", "", "TAG", "", "activity2OrientationObservableMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/AppBrandOrientationObservable;", "activity2OrientationObservableMap$annotations", "get", "activity", "Landroid/app/Activity;", "luggage-wxa-app_release"})
  public static final class a
  {
    public static i D(Activity paramActivity)
    {
      AppMethodBeat.i(176485);
      k.h(paramActivity, "activity");
      int i = paramActivity.hashCode();
      synchronized (i.bsO())
      {
        i locali2 = (i)i.bsO().get(i);
        i locali1 = locali2;
        if (locali2 == null)
        {
          locali1 = new i(paramActivity);
          i.bsO().put(i, locali1);
        }
        AppMethodBeat.o(176485);
        return locali1;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
  static final class b
    implements aa.b
  {
    b(i parami) {}
    
    public final void a(aa.a parama1, aa.a parama2)
    {
      AppMethodBeat.i(176486);
      boolean bool = i.a(this.lPO);
      ac.d(i.b(this.lPO), "onFourOrientationsChange, newOrientation: " + parama2 + ", isSystemOrientationLocked: " + bool);
      if ((!bool) && (i.c(this.lPO) != parama2))
      {
        parama1 = ((Iterable)i.d(this.lPO)).iterator();
        while (parama1.hasNext())
        {
          j localj = (j)parama1.next();
          k.g(parama2, "newOrientation");
          localj.a(parama2);
        }
        parama1 = this.lPO;
        k.g(parama2, "newOrientation");
        i.a(parama1, parama2);
      }
      parama1 = this.lPO;
      k.g(parama2, "newOrientation");
      i.b(parama1, parama2);
      AppMethodBeat.o(176486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.i
 * JD-Core Version:    0.7.0.1
 */