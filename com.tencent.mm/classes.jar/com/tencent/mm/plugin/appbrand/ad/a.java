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
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;)V", "capsuleBarImplView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "destroy", "", "getActionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBackgroundAlpha", "", "getBackgroundColor", "", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "getParent", "Landroid/view/ViewParent;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "isBlack", "", "style", "", "setFullscreenMode", "fullscreen", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "showNavArea", "showTitleArea", "luggage-wxa-app_release"})
public final class a
  implements e
{
  private d kGm;
  final b kGn;
  
  public a(Context paramContext)
  {
    this(new b(paramContext));
    AppMethodBeat.i(219662);
    AppMethodBeat.o(219662);
  }
  
  private a(b paramb)
  {
    AppMethodBeat.i(219661);
    this.kGn = paramb;
    paramb = this.kGn.findViewById(2131307088);
    if (paramb == null) {
      p.hyc();
    }
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(219661);
      throw paramb;
    }
    ((ViewGroup)paramb).removeAllViews();
    this.kGm = new d(((ViewGroup)paramb).getContext());
    paramb = (ViewGroup)paramb;
    d locald = this.kGm;
    if (locald == null) {
      p.btv("capsuleBarImplView");
    }
    paramb.addView((View)locald, new ViewGroup.LayoutParams(-2, -2));
    this.kGn.setCapsuleBarInteractionDelegate((b.b)new a(this));
    AppMethodBeat.o(219661);
  }
  
  public final AppBrandOptionButton btD()
  {
    AppMethodBeat.i(219660);
    Object localObject = this.kGm;
    if (localObject == null) {
      p.btv("capsuleBarImplView");
    }
    localObject = ((d)localObject).getOptionBtn();
    AppMethodBeat.o(219660);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219663);
    this.kGn.destroy();
    AppMethodBeat.o(219663);
  }
  
  public final View getActionView()
  {
    AppMethodBeat.i(219664);
    View localView = this.kGn.getActionView();
    AppMethodBeat.o(219664);
    return localView;
  }
  
  public final int getBackgroundColor()
  {
    AppMethodBeat.i(219665);
    int i = this.kGn.getBackgroundColor();
    AppMethodBeat.o(219665);
    return i;
  }
  
  public final void gx(boolean paramBoolean)
  {
    AppMethodBeat.i(219658);
    this.kGn.gx(paramBoolean);
    AppMethodBeat.o(219658);
  }
  
  public final void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(219659);
    this.kGn.gy(paramBoolean);
    AppMethodBeat.o(219659);
  }
  
  public final void gz(boolean paramBoolean)
  {
    AppMethodBeat.i(219673);
    this.kGn.gz(paramBoolean);
    AppMethodBeat.o(219673);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219666);
    this.kGn.setBackButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(219666);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(219667);
    this.kGn.setBackgroundColor(paramInt);
    AppMethodBeat.o(219667);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219668);
    this.kGn.setCloseButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(219668);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(219669);
    this.kGn.setForegroundColor(paramInt);
    AppMethodBeat.o(219669);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(219670);
    this.kGn.setForegroundStyle(paramString);
    AppMethodBeat.o(219670);
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(219657);
    this.kGn.setFullscreenMode(paramBoolean);
    AppMethodBeat.o(219657);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(219671);
    this.kGn.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(219671);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219672);
    this.kGn.setMainTitle(paramCharSequence);
    AppMethodBeat.o(219672);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "dispatchCapsuleViewVisibilityChanged", "", "visibility", "", "setHomeButtonOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
  public static final class a
    implements b.b
  {
    a(a parama) {}
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(219654);
      a.a(this.kGo).setHomeButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(219654);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(219655);
      a.a(this.kGo).setOptionButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(219655);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(219653);
      a.a(this.kGo).setStyleColor(paramInt);
      AppMethodBeat.o(219653);
    }
    
    public final void vI(int paramInt)
    {
      AppMethodBeat.i(219656);
      a.a(this.kGo).setVisibility(paramInt);
      AppMethodBeat.o(219656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */