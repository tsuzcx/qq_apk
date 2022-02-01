package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "isFullScreen", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class at
  extends a
{
  private Activity activity;
  private e.b jEu;
  private int jEv;
  public boolean jEw;
  private final c jEx;
  
  public at(c paramc, d.b paramb, Activity paramActivity)
  {
    super(paramc, paramb);
    AppMethodBeat.i(208045);
    this.jEx = paramc;
    this.activity = paramActivity;
    this.jEu = e.b.mtD;
    this.jEv = 1;
    AppMethodBeat.o(208045);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(208042);
    p.h(paramView, "view");
    super.O(paramView, paramInt);
    rM(paramInt);
    bxA();
    this.jEw = true;
    AppMethodBeat.o(208042);
  }
  
  public final boolean aYo()
  {
    AppMethodBeat.i(208044);
    boolean bool = this.mtA;
    if (bool) {
      this.jEw = false;
    }
    if (super.aYo())
    {
      if (e.b.c(this.jEu)) {
        this.jEx.setSoftOrientation("landscape");
      }
      for (;;)
      {
        if (this.activity != null)
        {
          Activity localActivity = this.activity;
          if (localActivity == null) {
            p.gkB();
          }
          localActivity.setRequestedOrientation(this.jEv);
        }
        bxB();
        AppMethodBeat.o(208044);
        return true;
        this.jEx.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.mtA = false;
      bxB();
      AppMethodBeat.o(208044);
      return true;
    }
    AppMethodBeat.o(208044);
    return false;
  }
  
  public final void rM(int paramInt)
  {
    AppMethodBeat.i(208041);
    this.mtA = true;
    if ((paramInt == 90) || (paramInt == -90)) {}
    for (Object localObject1 = "landscape";; localObject1 = "portrait")
    {
      Object localObject2 = this.jEx.getOrientationHandler();
      p.g(localObject2, "windowAndroid.orientationHandler");
      localObject2 = ((e)localObject2).aYg();
      p.g(localObject2, "windowAndroid.orientatio…andler.currentOrientation");
      this.jEu = ((e.b)localObject2);
      this.jEx.setSoftOrientation((String)localObject1);
      if ((this.activity != null) && (p.i(localObject1, "landscape")))
      {
        localObject1 = this.activity;
        if (localObject1 == null) {
          p.gkB();
        }
        if (!e.b.c(e.b.vh(((Activity)localObject1).getRequestedOrientation())))
        {
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.gkB();
          }
          this.jEv = ((Activity)localObject1).getRequestedOrientation();
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.gkB();
          }
          ((Activity)localObject1).setRequestedOrientation(6);
        }
      }
      AppMethodBeat.o(208041);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(208043);
    super.release();
    this.activity = null;
    AppMethodBeat.o(208043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.at
 * JD-Core Version:    0.7.0.1
 */