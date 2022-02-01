package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils;", "", "()V", "fromDPToPix", "", "Landroid/content/Context;", "dp", "hideImmediately", "", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "safeDetachFromWindow", "Landroid/view/View;", "luggage-wxa-app_release"})
public final class h
{
  public static final h lzY;
  
  static
  {
    AppMethodBeat.i(160939);
    lzY = new h();
    AppMethodBeat.o(160939);
  }
  
  public static final void a(v paramv)
  {
    AppMethodBeat.i(160938);
    Object localObject;
    if (paramv != null)
    {
      localObject = paramv.getView();
      if (localObject != null)
      {
        if (((View)localObject).isAttachedToWindow() != true) {
          break label143;
        }
        localObject = paramv.getView();
        k.g(localObject, "view");
        localObject = ((View)localObject).getAnimation();
        if (localObject != null) {
          ((Animation)localObject).cancel();
        }
        paramv.getView().animate().cancel();
        localObject = paramv.getView();
        k.g(localObject, "view");
        ((View)localObject).setVisibility(8);
        localObject = paramv.getView();
        k.g(localObject, "view");
        localObject = ((View)localObject).getParent();
        if (localObject != null) {
          break label130;
        }
        paramv = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(160938);
        throw paramv;
      }
    }
    AppMethodBeat.o(160938);
    return;
    label130:
    ((ViewGroup)localObject).removeView(paramv.getView());
    label143:
    AppMethodBeat.o(160938);
  }
  
  public static final void cI(View paramView)
  {
    AppMethodBeat.i(194385);
    if (paramView == null)
    {
      AppMethodBeat.o(194385);
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
      AppMethodBeat.o(194385);
      return;
    }
    AppMethodBeat.o(194385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h
 * JD-Core Version:    0.7.0.1
 */