package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITransparentLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplashEx;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animateHide", "", "listener", "Lkotlin/Function0;", "backgroundColor", "color", "", "getView", "Landroid/view/View;", "setAppInfo", "icon", "", "name", "setCanShowHideAnimation", "can", "", "setProgress", "progress", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends b
  implements ak
{
  public ad(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(322059);
    MU(true);
    AppMethodBeat.o(322059);
  }
  
  private static final void a(ad paramad, a parama)
  {
    AppMethodBeat.i(322062);
    s.u(paramad, "this$0");
    paramad.as(parama);
    AppMethodBeat.o(322062);
  }
  
  public final void Cj(int paramInt) {}
  
  public final void as(a<ah> parama)
  {
    AppMethodBeat.i(322074);
    if (!s.p(Looper.getMainLooper(), Looper.myLooper()))
    {
      post(new ad..ExternalSyntheticLambda0(this, parama));
      AppMethodBeat.o(322074);
      return;
    }
    setVisibility(8);
    Object localObject = getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)this);
      }
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(322074);
      return;
    }
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final void setCanShowHideAnimation(boolean paramBoolean) {}
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ad
 * JD-Core Version:    0.7.0.1
 */