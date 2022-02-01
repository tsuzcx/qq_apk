package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isHide", "", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "listener", "Lkotlin/Function0;", "backgroundColor", "color", "", "getView", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "plugin-appbrand-integration_release"})
public final class h
  extends b
  implements ab
{
  private boolean eea;
  private q naw;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50875);
    S(0, true);
    setBackgroundColor(0);
    AppMethodBeat.o(50875);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50874);
    p.h(paramString1, "icon");
    p.h(paramString2, "name");
    AppMethodBeat.o(50874);
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(50872);
    super.onAttachedToWindow();
    if (this.eea)
    {
      AppMethodBeat.o(50872);
      return;
    }
    Context localContext = getContext();
    getResources().getString(2131755998);
    this.naw = com.tencent.mm.ui.base.h.a(localContext, getResources().getString(2131762446), false, null);
    AppMethodBeat.o(50872);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50873);
    super.onDetachedFromWindow();
    q localq = this.naw;
    if (localq != null)
    {
      if (localq.isShowing() == true)
      {
        localq = this.naw;
        if (localq != null)
        {
          localq.dismiss();
          AppMethodBeat.o(50873);
        }
      }
    }
    else
    {
      AppMethodBeat.o(50873);
      return;
    }
    AppMethodBeat.o(50873);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(50871);
    super.onViewAdded(paramView);
    if (paramView != null)
    {
      if (paramView.getId() == 2131296991)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        Object localObject = localLayoutParams;
        if (!(localLayoutParams instanceof FrameLayout.LayoutParams)) {
          localObject = null;
        }
        localObject = (FrameLayout.LayoutParams)localObject;
        if (localObject != null) {
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
        }
        paramView.setLayoutParams(paramView.getLayoutParams());
      }
      AppMethodBeat.o(50871);
      return;
    }
    AppMethodBeat.o(50871);
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void yu(int paramInt) {}
  
  public final void z(a<x> parama)
  {
    AppMethodBeat.i(228834);
    this.eea = true;
    q localq = this.naw;
    if ((localq != null) && (localq.isShowing() == true))
    {
      localq = this.naw;
      if (localq != null) {
        localq.dismiss();
      }
    }
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(228834);
      return;
    }
    AppMethodBeat.o(228834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h
 * JD-Core Version:    0.7.0.1
 */