package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "getView", "Landroid/view/View;", "hideNavBtn", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "", "plugin-appbrand-integration_release"})
public final class g
  extends b
  implements r
{
  private p ioD;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(134746);
    K(0, true);
    setBackgroundColor(0);
    AppMethodBeat.o(134746);
  }
  
  public final void aHA() {}
  
  public final void aHB() {}
  
  public final void cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134745);
    j.q(paramString1, "icon");
    j.q(paramString2, "name");
    AppMethodBeat.o(134745);
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(134743);
    super.onAttachedToWindow();
    Context localContext = getContext();
    getResources().getString(2131297087);
    this.ioD = h.b(localContext, getResources().getString(2131301086), false, null);
    AppMethodBeat.o(134743);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(134744);
    super.onDetachedFromWindow();
    p localp = this.ioD;
    if (localp != null)
    {
      localp.dismiss();
      AppMethodBeat.o(134744);
      return;
    }
    AppMethodBeat.o(134744);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(134742);
    super.onViewAdded(paramView);
    if (paramView != null)
    {
      if (paramView.getId() == 2131821521)
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
      AppMethodBeat.o(134742);
      return;
    }
    AppMethodBeat.o(134742);
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g
 * JD-Core Version:    0.7.0.1
 */