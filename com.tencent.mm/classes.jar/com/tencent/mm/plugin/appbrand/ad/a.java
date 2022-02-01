package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;)V", "capsuleBarImplView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "destroy", "", "getActionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBackgroundAlpha", "", "getBackgroundColor", "", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "getParent", "Landroid/view/ViewParent;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "isBlack", "", "style", "", "setFullscreenMode", "fullscreen", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "showNavArea", "showTitleArea", "luggage-wxa-app_release"})
public final class a
  implements f
{
  private d nzT;
  final b nzU;
  
  public a(Context paramContext)
  {
    this(new b(paramContext));
    AppMethodBeat.i(246295);
    AppMethodBeat.o(246295);
  }
  
  private a(b paramb)
  {
    AppMethodBeat.i(246294);
    this.nzU = paramb;
    paramb = this.nzU.findViewById(a.d.right_btn_area);
    if (paramb == null) {
      p.iCn();
    }
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(246294);
      throw paramb;
    }
    ((ViewGroup)paramb).removeAllViews();
    this.nzT = new d(((ViewGroup)paramb).getContext());
    paramb = (ViewGroup)paramb;
    d locald = this.nzT;
    if (locald == null) {
      p.bGy("capsuleBarImplView");
    }
    paramb.addView((View)locald, new ViewGroup.LayoutParams(-2, -2));
    this.nzU.setCapsuleBarInteractionDelegate((b.b)new a(this));
    AppMethodBeat.o(246294);
  }
  
  public final AppBrandOptionButton bEB()
  {
    AppMethodBeat.i(246293);
    Object localObject = this.nzT;
    if (localObject == null) {
      p.bGy("capsuleBarImplView");
    }
    localObject = ((d)localObject).getOptionBtn();
    AppMethodBeat.o(246293);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(246296);
    this.nzU.destroy();
    AppMethodBeat.o(246296);
  }
  
  public final View getActionView()
  {
    AppMethodBeat.i(246297);
    View localView = this.nzU.getActionView();
    AppMethodBeat.o(246297);
    return localView;
  }
  
  public final int getBackgroundColor()
  {
    AppMethodBeat.i(246298);
    int i = this.nzU.getBackgroundColor();
    AppMethodBeat.o(246298);
    return i;
  }
  
  public final void hi(boolean paramBoolean)
  {
    AppMethodBeat.i(246291);
    this.nzU.hi(paramBoolean);
    AppMethodBeat.o(246291);
  }
  
  public final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(246292);
    this.nzU.hj(paramBoolean);
    AppMethodBeat.o(246292);
  }
  
  public final void hk(boolean paramBoolean)
  {
    AppMethodBeat.i(246307);
    this.nzU.hk(paramBoolean);
    AppMethodBeat.o(246307);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(246299);
    this.nzU.setBackButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(246299);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(246300);
    this.nzU.setBackgroundColor(paramInt);
    AppMethodBeat.o(246300);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(246301);
    this.nzU.setCloseButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(246301);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(246302);
    this.nzU.setForegroundColor(paramInt);
    AppMethodBeat.o(246302);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(246303);
    this.nzU.setForegroundStyle(paramString);
    AppMethodBeat.o(246303);
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(246290);
    this.nzU.setFullscreenMode(paramBoolean);
    AppMethodBeat.o(246290);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(246304);
    this.nzU.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(246304);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(246306);
    this.nzU.setMainTitle(paramCharSequence);
    AppMethodBeat.o(246306);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "dispatchCapsuleViewVisibilityChanged", "", "visibility", "", "setHomeButtonOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
  public static final class a
    implements b.b
  {
    a(a parama) {}
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(245674);
      a.a(this.nzV).setHomeButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(245674);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(245676);
      a.a(this.nzV).setOptionButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(245676);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(245673);
      a.a(this.nzV).setStyleColor(paramInt);
      AppMethodBeat.o(245673);
    }
    
    public final void yT(int paramInt)
    {
      AppMethodBeat.i(245677);
      a.a(this.nzV).setVisibility(paramInt);
      AppMethodBeat.o(245677);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */