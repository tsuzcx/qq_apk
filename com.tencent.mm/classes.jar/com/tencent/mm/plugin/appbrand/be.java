package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "isFullScreen", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class be
  extends a
{
  private Activity activity;
  private e.b kGe;
  private int kGf;
  public boolean kGg;
  private final c kGh;
  
  public be(c paramc, d.b paramb, Activity paramActivity)
  {
    super(paramc, paramb);
    AppMethodBeat.i(219652);
    this.kGh = paramc;
    this.activity = paramActivity;
    this.kGe = e.b.nEl;
    this.kGf = 1;
    AppMethodBeat.o(219652);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(219649);
    p.h(paramView, "view");
    super.N(paramView, paramInt);
    vH(paramInt);
    bTL();
    this.kGg = true;
    AppMethodBeat.o(219649);
  }
  
  public final boolean btC()
  {
    AppMethodBeat.i(219651);
    boolean bool = this.nEi;
    if (bool) {
      this.kGg = false;
    }
    if (super.btC())
    {
      if (e.b.c(this.kGe)) {
        this.kGh.setSoftOrientation("landscape");
      }
      for (;;)
      {
        if (this.activity != null)
        {
          Activity localActivity = this.activity;
          if (localActivity == null) {
            p.hyc();
          }
          localActivity.setRequestedOrientation(this.kGf);
        }
        bTM();
        AppMethodBeat.o(219651);
        return true;
        this.kGh.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.nEi = false;
      bTM();
      AppMethodBeat.o(219651);
      return true;
    }
    AppMethodBeat.o(219651);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(219650);
    super.release();
    this.activity = null;
    AppMethodBeat.o(219650);
  }
  
  public final void vH(int paramInt)
  {
    AppMethodBeat.i(219648);
    this.nEi = true;
    if ((paramInt == 90) || (paramInt == -90)) {}
    for (Object localObject1 = "landscape";; localObject1 = "portrait")
    {
      Object localObject2 = this.kGh.getOrientationHandler();
      p.g(localObject2, "windowAndroid.orientationHandler");
      localObject2 = ((e)localObject2).btm();
      p.g(localObject2, "windowAndroid.orientatio…andler.currentOrientation");
      this.kGe = ((e.b)localObject2);
      this.kGh.setSoftOrientation((String)localObject1);
      if ((this.activity != null) && (p.j(localObject1, "landscape")))
      {
        localObject1 = this.activity;
        if (localObject1 == null) {
          p.hyc();
        }
        if (!e.b.c(e.b.yZ(((Activity)localObject1).getRequestedOrientation())))
        {
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.hyc();
          }
          this.kGf = ((Activity)localObject1).getRequestedOrientation();
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.hyc();
          }
          ((Activity)localObject1).setRequestedOrientation(6);
        }
      }
      AppMethodBeat.o(219648);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.be
 * JD-Core Version:    0.7.0.1
 */