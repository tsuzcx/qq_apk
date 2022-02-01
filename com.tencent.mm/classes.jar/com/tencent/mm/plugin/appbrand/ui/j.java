package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils;", "", "()V", "fromDPToPix", "", "Landroid/content/Context;", "dp", "hideImmediately", "", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "safeDetachFromWindow", "Landroid/view/View;", "luggage-wxa-app_release"})
public final class j
{
  public static final j mHh;
  
  static
  {
    AppMethodBeat.i(160939);
    mHh = new j();
    AppMethodBeat.o(160939);
  }
  
  public static final void a(w paramw)
  {
    AppMethodBeat.i(160938);
    Object localObject;
    if (paramw != null)
    {
      localObject = paramw.getView();
      if (localObject != null)
      {
        if (((View)localObject).isAttachedToWindow() != true) {
          break label143;
        }
        localObject = paramw.getView();
        p.g(localObject, "view");
        localObject = ((View)localObject).getAnimation();
        if (localObject != null) {
          ((Animation)localObject).cancel();
        }
        paramw.getView().animate().cancel();
        localObject = paramw.getView();
        p.g(localObject, "view");
        ((View)localObject).setVisibility(8);
        localObject = paramw.getView();
        p.g(localObject, "view");
        localObject = ((View)localObject).getParent();
        if (localObject != null) {
          break label130;
        }
        paramw = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(160938);
        throw paramw;
      }
    }
    AppMethodBeat.o(160938);
    return;
    label130:
    ((ViewGroup)localObject).removeView(paramw.getView());
    label143:
    AppMethodBeat.o(160938);
  }
  
  public static final void cN(View paramView)
  {
    AppMethodBeat.i(208167);
    if (paramView == null)
    {
      AppMethodBeat.o(208167);
      return;
    }
    paramView.setVisibility(8);
    ViewParent localViewParent = paramView.getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeView(paramView);
      AppMethodBeat.o(208167);
      return;
    }
    AppMethodBeat.o(208167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */