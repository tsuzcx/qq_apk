package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils;", "", "()V", "fromDPToPix", "", "Landroid/content/Context;", "dp", "hideImmediately", "", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "safeDetachFromWindow", "Landroid/view/View;", "luggage-wxa-app_release"})
public final class l
{
  public static final l nUf;
  
  static
  {
    AppMethodBeat.i(160939);
    nUf = new l();
    AppMethodBeat.o(160939);
  }
  
  public static final void a(ab paramab)
  {
    AppMethodBeat.i(160938);
    Object localObject;
    if (paramab != null)
    {
      localObject = paramab.getView();
      if (localObject != null)
      {
        if (((View)localObject).isAttachedToWindow() != true) {
          break label143;
        }
        localObject = paramab.getView();
        p.g(localObject, "view");
        localObject = ((View)localObject).getAnimation();
        if (localObject != null) {
          ((Animation)localObject).cancel();
        }
        paramab.getView().animate().cancel();
        localObject = paramab.getView();
        p.g(localObject, "view");
        ((View)localObject).setVisibility(8);
        localObject = paramab.getView();
        p.g(localObject, "view");
        localObject = ((View)localObject).getParent();
        if (localObject != null) {
          break label130;
        }
        paramab = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(160938);
        throw paramab;
      }
    }
    AppMethodBeat.o(160938);
    return;
    label130:
    ((ViewGroup)localObject).removeView(paramab.getView());
    label143:
    AppMethodBeat.o(160938);
  }
  
  public static final void cG(View paramView)
  {
    AppMethodBeat.i(219785);
    if (paramView == null)
    {
      AppMethodBeat.o(219785);
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
      AppMethodBeat.o(219785);
      return;
    }
    AppMethodBeat.o(219785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */