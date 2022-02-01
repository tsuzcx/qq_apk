package com.tencent.mm.plugin.appbrand.platform.window.c.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.appbrand.platform.window.a.c
{
  private static final a.a tMt;
  @Deprecated
  private static final e.b[] tMv;
  private final com.tencent.mm.plugin.appbrand.platform.window.c tMu;
  
  static
  {
    AppMethodBeat.i(317508);
    tMt = new a.a((byte)0);
    tMv = e.b.tLo;
    AppMethodBeat.o(317508);
  }
  
  public a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    AppMethodBeat.i(317505);
    this.tMu = paramc;
    AppMethodBeat.o(317505);
  }
  
  public final void a(e.b paramb, e.a parama)
  {
    boolean bool = true;
    AppMethodBeat.i(317514);
    if (paramb == null)
    {
      if (parama != null) {
        parama.onOrientationChanged(null, false);
      }
      AppMethodBeat.o(317514);
      return;
    }
    Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + paramb.tLn + ',' + paramb.name());
    int i = b.$EnumSwitchMapping$0[paramb.ordinal()];
    Object localObject;
    if (i == 1)
    {
      this.tMu.setSoftOrientation("portrait");
      if (parama != null)
      {
        localObject = cHQ();
        if (cHQ() == paramb) {}
        for (bool = true;; bool = false)
        {
          parama.onOrientationChanged((e.b)localObject, bool);
          AppMethodBeat.o(317514);
          return;
        }
      }
    }
    else
    {
      localObject = tMv;
      s.s(localObject, "LANDSCAPE_ENUMS");
      if (!k.contains((Object[])localObject, paramb)) {
        break label218;
      }
      this.tMu.setSoftOrientation("landscape");
      if (parama != null)
      {
        localObject = cHQ();
        paramb = tMv;
        s.s(paramb, "LANDSCAPE_ENUMS");
        bool = k.contains((Object[])paramb, cHQ());
      }
    }
    for (;;)
    {
      parama.onOrientationChanged((e.b)localObject, bool);
      label218:
      do
      {
        do
        {
          AppMethodBeat.o(317514);
          return;
          if (i != 2) {
            break;
          }
          this.tMu.setSoftOrientation("auto");
        } while (parama == null);
        localObject = cHQ();
        break;
        this.tMu.setSoftOrientation("portrait");
      } while (parama == null);
      e.b localb = cHQ();
      localObject = localb;
      if (cHQ() != paramb)
      {
        bool = false;
        localObject = localb;
      }
    }
  }
  
  public final e.b cHQ()
  {
    AppMethodBeat.i(317529);
    Object localObject = this.tMu.getVDisplayMetrics();
    if (((DisplayMetrics)localObject).heightPixels >= ((DisplayMetrics)localObject).widthPixels)
    {
      Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      localObject = e.b.tLh;
      AppMethodBeat.o(317529);
      return localObject;
    }
    Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    localObject = e.b.tLj;
    AppMethodBeat.o(317529);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.c.a.a
 * JD-Core Version:    0.7.0.1
 */