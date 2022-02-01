package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.e;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "parserOrientation", "orientation", "", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class ar
  extends a
{
  private Activity activity;
  private e.b jik;
  private int jil;
  boolean jim;
  private final c jin;
  
  public ar(c paramc, d.b paramb, Activity paramActivity)
  {
    super(paramc, paramb);
    AppMethodBeat.i(193277);
    this.jin = paramc;
    this.activity = paramActivity;
    this.jik = e.b.lOQ;
    this.jil = 1;
    AppMethodBeat.o(193277);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(193274);
    k.h(paramView, "view");
    super.O(paramView, paramInt);
    rj(paramInt);
    bsF();
    this.jim = true;
    AppMethodBeat.o(193274);
  }
  
  public final boolean aUJ()
  {
    AppMethodBeat.i(193276);
    boolean bool = this.lOM;
    if (bool) {
      this.jim = false;
    }
    if (super.aUJ())
    {
      if (e.b.c(this.jik)) {
        this.jin.setSoftOrientation("landscape");
      }
      for (;;)
      {
        if (this.activity != null)
        {
          Activity localActivity = this.activity;
          if (localActivity == null) {
            k.fOy();
          }
          localActivity.setRequestedOrientation(this.jil);
        }
        bsG();
        AppMethodBeat.o(193276);
        return true;
        this.jin.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.lOM = false;
      bsG();
      AppMethodBeat.o(193276);
      return true;
    }
    AppMethodBeat.o(193276);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(193275);
    super.release();
    this.activity = null;
    AppMethodBeat.o(193275);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(193273);
    this.lOM = true;
    if ((paramInt == 90) || (paramInt == -90)) {}
    for (Object localObject1 = "landscape";; localObject1 = "portrait")
    {
      Object localObject2 = this.jin.getOrientationHandler();
      k.g(localObject2, "windowAndroid.orientationHandler");
      localObject2 = ((e)localObject2).aUB();
      k.g(localObject2, "windowAndroid.orientatio…andler.currentOrientation");
      this.jik = ((e.b)localObject2);
      this.jin.setSoftOrientation((String)localObject1);
      if ((this.activity != null) && (k.g(localObject1, "landscape")))
      {
        localObject1 = this.activity;
        if (localObject1 == null) {
          k.fOy();
        }
        if (!e.b.c(e.b.uy(((Activity)localObject1).getRequestedOrientation())))
        {
          localObject1 = this.activity;
          if (localObject1 == null) {
            k.fOy();
          }
          this.jil = ((Activity)localObject1).getRequestedOrientation();
          localObject1 = this.activity;
          if (localObject1 == null) {
            k.fOy();
          }
          ((Activity)localObject1).setRequestedOrientation(6);
        }
      }
      AppMethodBeat.o(193273);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ar
 * JD-Core Version:    0.7.0.1
 */