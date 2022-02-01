package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isHide", "", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "listener", "Lkotlin/Function0;", "backgroundColor", "color", "", "getView", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "plugin-appbrand-integration_release"})
public final class h
  extends b
  implements aa
{
  private boolean fYp;
  private s qaL;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50875);
    T(0, true);
    setBackgroundColor(0);
    AppMethodBeat.o(50875);
  }
  
  public final void BU(int paramInt) {}
  
  public final void eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50874);
    p.k(paramString1, "icon");
    p.k(paramString2, "name");
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
    if (this.fYp)
    {
      AppMethodBeat.o(50872);
      return;
    }
    Context localContext = getContext();
    getResources().getString(au.i.app_tip);
    this.qaL = com.tencent.mm.ui.base.h.a(localContext, getResources().getString(au.i.loading_tips), false, null);
    AppMethodBeat.o(50872);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50873);
    super.onDetachedFromWindow();
    s locals = this.qaL;
    if (locals != null)
    {
      if (locals.isShowing() == true)
      {
        locals = this.qaL;
        if (locals != null)
        {
          locals.dismiss();
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
      if (paramView.getId() == au.f.appbrand_loading_dialog_view)
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
  
  public final void x(a<x> parama)
  {
    AppMethodBeat.i(271675);
    this.fYp = true;
    s locals = this.qaL;
    if ((locals != null) && (locals.isShowing() == true))
    {
      locals = this.qaL;
      if (locals != null) {
        locals.dismiss();
      }
    }
    if (parama != null)
    {
      parama.invoke();
      AppMethodBeat.o(271675);
      return;
    }
    AppMethodBeat.o(271675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h
 * JD-Core Version:    0.7.0.1
 */