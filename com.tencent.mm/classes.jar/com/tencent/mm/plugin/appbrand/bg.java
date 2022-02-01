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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "isFullScreen", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class bg
  extends a
{
  private Activity activity;
  private e.b nzL;
  private int nzM;
  public boolean nzN;
  private final c nzO;
  
  public bg(c paramc, d.b paramb, Activity paramActivity)
  {
    super(paramc, paramb);
    AppMethodBeat.i(243284);
    this.nzO = paramc;
    this.activity = paramActivity;
    this.nzL = e.b.qGv;
    this.nzM = 1;
    AppMethodBeat.o(243284);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(243279);
    p.k(paramView, "view");
    super.O(paramView, paramInt);
    yS(paramInt);
    cgQ();
    this.nzN = true;
    AppMethodBeat.o(243279);
  }
  
  public final boolean bEz()
  {
    AppMethodBeat.i(243283);
    boolean bool = this.qGs;
    if (bool) {
      this.nzN = false;
    }
    if (super.bEz())
    {
      if (e.b.c(this.nzL)) {
        this.nzO.setSoftOrientation("landscape");
      }
      for (;;)
      {
        if (this.activity != null)
        {
          Activity localActivity = this.activity;
          if (localActivity == null) {
            p.iCn();
          }
          localActivity.setRequestedOrientation(this.nzM);
        }
        cgR();
        AppMethodBeat.o(243283);
        return true;
        this.nzO.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.qGs = false;
      cgR();
      AppMethodBeat.o(243283);
      return true;
    }
    AppMethodBeat.o(243283);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(243280);
    super.release();
    this.activity = null;
    AppMethodBeat.o(243280);
  }
  
  public final void yS(int paramInt)
  {
    AppMethodBeat.i(243278);
    this.qGs = true;
    if ((paramInt == 90) || (paramInt == -90)) {}
    for (Object localObject1 = "landscape";; localObject1 = "portrait")
    {
      Object localObject2 = this.nzO.getOrientationHandler();
      p.j(localObject2, "windowAndroid.orientationHandler");
      localObject2 = ((e)localObject2).cgS();
      p.j(localObject2, "windowAndroid.orientatio…andler.currentOrientation");
      this.nzL = ((e.b)localObject2);
      this.nzO.setSoftOrientation((String)localObject1);
      if ((this.activity != null) && (p.h(localObject1, "landscape")))
      {
        localObject1 = this.activity;
        if (localObject1 == null) {
          p.iCn();
        }
        if (!e.b.c(e.b.CE(((Activity)localObject1).getRequestedOrientation())))
        {
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.iCn();
          }
          this.nzM = ((Activity)localObject1).getRequestedOrientation();
          localObject1 = this.activity;
          if (localObject1 == null) {
            p.iCn();
          }
          ((Activity)localObject1).setRequestedOrientation(6);
        }
      }
      AppMethodBeat.o(243278);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bg
 * JD-Core Version:    0.7.0.1
 */