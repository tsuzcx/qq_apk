package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.statusbar.b;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLoadingSplash;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isHide", "", "progresDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "animateHide", "", "listener", "Lkotlin/Function0;", "backgroundColor", "color", "", "getView", "Landroid/view/View;", "onAttachedToWindow", "onDetachedFromWindow", "onViewAdded", "child", "setAppInfo", "icon", "", "name", "setProgress", "progress", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends b
  implements com.tencent.mm.plugin.appbrand.ui.ah
{
  private boolean iep;
  private w tfR;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50875);
    aj(0, true);
    setBackgroundColor(0);
    AppMethodBeat.o(50875);
  }
  
  public final void Cj(int paramInt) {}
  
  public final void as(a<kotlin.ah> parama)
  {
    int i = 1;
    AppMethodBeat.i(320081);
    this.iep = true;
    w localw = this.tfR;
    if ((localw != null) && (localw.isShowing() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localw = this.tfR;
        if (localw != null) {
          localw.dismiss();
        }
      }
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(320081);
      return;
      i = 0;
    }
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50874);
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
    if (this.iep)
    {
      AppMethodBeat.o(50872);
      return;
    }
    Context localContext = getContext();
    getResources().getString(ba.i.app_tip);
    this.tfR = k.a(localContext, getResources().getString(ba.i.loading_tips), false, null);
    AppMethodBeat.o(50872);
  }
  
  protected final void onDetachedFromWindow()
  {
    int i = 1;
    AppMethodBeat.i(50873);
    super.onDetachedFromWindow();
    w localw = this.tfR;
    if ((localw != null) && (localw.isShowing() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localw = this.tfR;
        if (localw != null) {
          localw.dismiss();
        }
      }
      AppMethodBeat.o(50873);
      return;
      i = 0;
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(50871);
    super.onViewAdded(paramView);
    if ((paramView != null) && (paramView.getId() == ba.f.appbrand_loading_dialog_view))
    {
      localObject = paramView.getLayoutParams();
      if (!(localObject instanceof FrameLayout.LayoutParams)) {
        break label65;
      }
    }
    label65:
    for (Object localObject = (FrameLayout.LayoutParams)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
      }
      paramView.setLayoutParams(paramView.getLayoutParams());
      AppMethodBeat.o(50871);
      return;
    }
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.h
 * JD-Core Version:    0.7.0.1
 */