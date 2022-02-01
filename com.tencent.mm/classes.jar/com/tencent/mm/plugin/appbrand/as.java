package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "parserOrientation", "orientation", "", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class as
  extends a
{
  private Activity activity;
  private e.b jBA;
  private int jBB;
  boolean jBC;
  private final c jBD;
  
  public as(c paramc, d.b paramb, Activity paramActivity)
  {
    super(paramc, paramb);
    AppMethodBeat.i(197496);
    this.jBD = paramc;
    this.activity = paramActivity;
    this.jBA = e.b.moG;
    this.jBB = 1;
    AppMethodBeat.o(197496);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(197493);
    p.h(paramView, "view");
    super.O(paramView, paramInt);
    rK(paramInt);
    bwJ();
    this.jBC = true;
    AppMethodBeat.o(197493);
  }
  
  public final boolean aXV()
  {
    AppMethodBeat.i(197495);
    boolean bool = this.moC;
    if (bool) {
      this.jBC = false;
    }
    if (super.aXV())
    {
      if (e.b.c(this.jBA)) {
        this.jBD.setSoftOrientation("landscape");
      }
      for (;;)
      {
        if (this.activity != null)
        {
          Activity localActivity = this.activity;
          if (localActivity == null) {
            p.gfZ();
          }
          localActivity.setRequestedOrientation(this.jBB);
        }
        bwK();
        AppMethodBeat.o(197495);
        return true;
        this.jBD.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.moC = false;
      bwK();
      AppMethodBeat.o(197495);
      return true;
    }
    AppMethodBeat.o(197495);
    return false;
  }
  
  public final void rK(int paramInt)
  {
    AppMethodBeat.i(197492);
    this.moC = true;
    if ((paramInt == 90) || (paramInt == -90)) {}
    for (Object localObject1 = "landscape";; localObject1 = "portrait")
    {
      Object localObject2 = this.jBD.getOrientationHandler();
      p.g(localObject2, "windowAndroid.orientationHandler");
      localObject2 = ((e)localObject2).aXN();
      p.g(localObject2, "windowAndroid.orientatio…andler.currentOrientation");
      this.jBA = ((e.b)localObject2);
      this.jBD.setSoftOrientation((String)localObject1);
      if ((this.activity != null) && (p.i(localObject1, "landscape")))
      {
        localObject1 = this.activity;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (!e.b.c(e.b.vc(((Activity)localObject1).getRequestedOrientation())))
        {
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.gfZ();
          }
          this.jBB = ((Activity)localObject1).getRequestedOrientation();
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.gfZ();
          }
          ((Activity)localObject1).setRequestedOrientation(6);
        }
      }
      AppMethodBeat.o(197492);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(197494);
    super.release();
    this.activity = null;
    AppMethodBeat.o(197494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.as
 * JD-Core Version:    0.7.0.1
 */