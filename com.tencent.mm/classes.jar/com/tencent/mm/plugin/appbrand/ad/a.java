package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;)V", "capsuleBarImplView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "destroy", "", "getActionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBackgroundAlpha", "", "getBackgroundColor", "", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "getParent", "Landroid/view/ViewParent;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "isBlack", "", "style", "", "setFullscreenMode", "fullscreen", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "showNavArea", "showTitleArea", "luggage-wxa-app_release"})
public final class a
  implements e
{
  private d jEC;
  final b jED;
  
  public a(Context paramContext)
  {
    this(new b(paramContext));
    AppMethodBeat.i(208055);
    AppMethodBeat.o(208055);
  }
  
  private a(b paramb)
  {
    AppMethodBeat.i(208054);
    this.jED = paramb;
    paramb = this.jED.findViewById(2131304180);
    if (paramb == null) {
      p.gkB();
    }
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(208054);
      throw paramb;
    }
    ((ViewGroup)paramb).removeAllViews();
    this.jEC = new d(((ViewGroup)paramb).getContext());
    paramb = (ViewGroup)paramb;
    d locald = this.jEC;
    if (locald == null) {
      p.bdF("capsuleBarImplView");
    }
    paramb.addView((View)locald, new ViewGroup.LayoutParams(-2, -2));
    this.jED.setCapsuleBarInteractionDelegate((b.a)new a(this));
    AppMethodBeat.o(208054);
  }
  
  public final AppBrandOptionButton aYp()
  {
    AppMethodBeat.i(208053);
    Object localObject = this.jEC;
    if (localObject == null) {
      p.bdF("capsuleBarImplView");
    }
    localObject = ((d)localObject).getOptionBtn();
    AppMethodBeat.o(208053);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(208056);
    this.jED.destroy();
    AppMethodBeat.o(208056);
  }
  
  public final void fC(boolean paramBoolean)
  {
    AppMethodBeat.i(208051);
    this.jED.fC(paramBoolean);
    AppMethodBeat.o(208051);
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(208052);
    this.jED.fD(paramBoolean);
    AppMethodBeat.o(208052);
  }
  
  public final void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(208066);
    this.jED.fE(paramBoolean);
    AppMethodBeat.o(208066);
  }
  
  public final View getActionView()
  {
    AppMethodBeat.i(208057);
    View localView = this.jED.getActionView();
    AppMethodBeat.o(208057);
    return localView;
  }
  
  public final int getBackgroundColor()
  {
    AppMethodBeat.i(208058);
    int i = this.jED.getBackgroundColor();
    AppMethodBeat.o(208058);
    return i;
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(208059);
    this.jED.setBackButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(208059);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(208060);
    this.jED.setBackgroundColor(paramInt);
    AppMethodBeat.o(208060);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(208061);
    this.jED.setCloseButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(208061);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(208062);
    this.jED.setForegroundColor(paramInt);
    AppMethodBeat.o(208062);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(208063);
    this.jED.setForegroundStyle(paramString);
    AppMethodBeat.o(208063);
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(208050);
    this.jED.setFullscreenMode(paramBoolean);
    AppMethodBeat.o(208050);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(208064);
    this.jED.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(208064);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(208065);
    this.jED.setMainTitle(paramCharSequence);
    AppMethodBeat.o(208065);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "dispatchCapsuleViewVisibilityChanged", "", "visibility", "", "setHomeButtonOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
  public static final class a
    implements b.a
  {
    a(a parama) {}
    
    public final void rN(int paramInt)
    {
      AppMethodBeat.i(208049);
      a.a(this.jEE).setVisibility(paramInt);
      AppMethodBeat.o(208049);
    }
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(208047);
      a.a(this.jEE).setHomeButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(208047);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(208048);
      a.a(this.jEE).setOptionButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(208048);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(208046);
      a.a(this.jEE).setStyleColor(paramInt);
      AppMethodBeat.o(208046);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */