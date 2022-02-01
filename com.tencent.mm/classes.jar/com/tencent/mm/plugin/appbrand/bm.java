package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "activity", "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", "direction", "exitFullscreen", "isFullScreen", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
  extends a
{
  private Activity activity;
  private final c qyP;
  private e.b qyQ;
  private int qyR;
  public boolean qyS;
  
  public bm(c paramc, d.b paramb, Activity paramActivity)
  {
    super(paramc, paramb);
    AppMethodBeat.i(316569);
    this.qyP = paramc;
    this.activity = paramActivity;
    this.qyQ = e.b.tLh;
    this.qyR = 1;
    AppMethodBeat.o(316569);
  }
  
  public final void T(View paramView, int paramInt)
  {
    AppMethodBeat.i(316581);
    s.u(paramView, "view");
    super.T(paramView, paramInt);
    zb(paramInt);
    cHO();
    this.qyS = true;
    AppMethodBeat.o(316581);
  }
  
  public final boolean cdL()
  {
    AppMethodBeat.i(316599);
    boolean bool = this.tLe;
    if (bool) {
      this.qyS = false;
    }
    if (super.cdL())
    {
      if (e.b.c(this.qyQ)) {
        this.qyP.setSoftOrientation("landscape");
      }
      for (;;)
      {
        if (this.activity != null)
        {
          Activity localActivity = this.activity;
          s.checkNotNull(localActivity);
          localActivity.setRequestedOrientation(this.qyR);
        }
        cHP();
        AppMethodBeat.o(316599);
        return true;
        this.qyP.setSoftOrientation("portrait");
      }
    }
    if (bool)
    {
      this.tLe = false;
      cHP();
      AppMethodBeat.o(316599);
      return true;
    }
    AppMethodBeat.o(316599);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(316588);
    super.release();
    this.activity = null;
    AppMethodBeat.o(316588);
  }
  
  public final void zb(int paramInt)
  {
    AppMethodBeat.i(316575);
    this.tLe = true;
    switch (paramInt)
    {
    }
    for (Object localObject = "portrait";; localObject = "landscape")
    {
      e.b localb = this.qyP.getOrientationHandler().cHQ();
      s.s(localb, "windowAndroid.orientatio…andler.currentOrientation");
      this.qyQ = localb;
      this.qyP.setSoftOrientation((String)localObject);
      if ((this.activity != null) && (s.p(localObject, "landscape")))
      {
        localObject = this.activity;
        s.checkNotNull(localObject);
        if (!e.b.c(e.b.CV(((Activity)localObject).getRequestedOrientation())))
        {
          localObject = this.activity;
          s.checkNotNull(localObject);
          this.qyR = ((Activity)localObject).getRequestedOrientation();
          localObject = this.activity;
          s.checkNotNull(localObject);
          ((Activity)localObject).setRequestedOrientation(6);
        }
      }
      AppMethodBeat.o(316575);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bm
 * JD-Core Version:    0.7.0.1
 */