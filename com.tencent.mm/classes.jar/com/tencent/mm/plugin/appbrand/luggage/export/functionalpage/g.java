package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isHide", "", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "backgroundColor", "color", "", "getView", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "plugin-appbrand-integration_release"})
public final class g
  extends b
  implements u
{
  private boolean dyK;
  private p lqV;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50875);
    L(0, true);
    setBackgroundColor(0);
    AppMethodBeat.o(50875);
  }
  
  public final void boo()
  {
    AppMethodBeat.i(162537);
    this.dyK = true;
    p localp = this.lqV;
    if (localp != null)
    {
      if (localp.isShowing() == true)
      {
        localp = this.lqV;
        if (localp != null)
        {
          localp.dismiss();
          AppMethodBeat.o(162537);
        }
      }
    }
    else
    {
      AppMethodBeat.o(162537);
      return;
    }
    AppMethodBeat.o(162537);
  }
  
  public final void dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50874);
    k.h(paramString1, "icon");
    k.h(paramString2, "name");
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
    if (this.dyK)
    {
      AppMethodBeat.o(50872);
      return;
    }
    Context localContext = getContext();
    getResources().getString(2131755906);
    this.lqV = h.b(localContext, getResources().getString(2131760709), false, null);
    AppMethodBeat.o(50872);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50873);
    super.onDetachedFromWindow();
    p localp = this.lqV;
    if (localp != null)
    {
      if (localp.isShowing() == true)
      {
        localp = this.lqV;
        if (localp != null)
        {
          localp.dismiss();
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
      if (paramView.getId() == 2131296892)
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
  
  public final void tT(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g
 * JD-Core Version:    0.7.0.1
 */