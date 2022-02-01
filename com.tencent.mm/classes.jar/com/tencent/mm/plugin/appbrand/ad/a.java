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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;)V", "capsuleBarImplView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "destroy", "", "getActionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBackgroundAlpha", "", "getBackgroundColor", "", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "getParent", "Landroid/view/ViewParent;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "isBlack", "", "style", "", "setFullscreenMode", "fullscreen", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "showNavArea", "showTitleArea", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  final b qyW;
  private d qyX;
  
  public a(Context paramContext)
  {
    this(new b(paramContext));
    AppMethodBeat.i(321277);
    AppMethodBeat.o(321277);
  }
  
  private a(b paramb)
  {
    AppMethodBeat.i(321272);
    this.qyW = paramb;
    paramb = this.qyW.findViewById(a.d.right_btn_area);
    s.checkNotNull(paramb);
    ((ViewGroup)paramb).removeAllViews();
    this.qyX = new d(((ViewGroup)paramb).getContext());
    ViewGroup localViewGroup = (ViewGroup)paramb;
    d locald = this.qyX;
    paramb = locald;
    if (locald == null)
    {
      s.bIx("capsuleBarImplView");
      paramb = null;
    }
    localViewGroup.addView((View)paramb, new ViewGroup.LayoutParams(-2, -2));
    this.qyW.setCapsuleBarInteractionDelegate((b.b)new a(this));
    AppMethodBeat.o(321272);
  }
  
  public final AppBrandOptionButton cdM()
  {
    AppMethodBeat.i(321332);
    d locald = this.qyX;
    Object localObject = locald;
    if (locald == null)
    {
      s.bIx("capsuleBarImplView");
      localObject = null;
    }
    localObject = ((d)localObject).getOptionBtn();
    AppMethodBeat.o(321332);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(321283);
    this.qyW.destroy();
    AppMethodBeat.o(321283);
  }
  
  public final View getActionView()
  {
    AppMethodBeat.i(321286);
    View localView = this.qyW.getActionView();
    AppMethodBeat.o(321286);
    return localView;
  }
  
  public final int getBackgroundColor()
  {
    AppMethodBeat.i(321293);
    int i = this.qyW.getBackgroundColor();
    AppMethodBeat.o(321293);
    return i;
  }
  
  public final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(321323);
    this.qyW.hZ(paramBoolean);
    AppMethodBeat.o(321323);
  }
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(321327);
    this.qyW.ia(paramBoolean);
    AppMethodBeat.o(321327);
  }
  
  public final void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(321329);
    this.qyW.ib(paramBoolean);
    AppMethodBeat.o(321329);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(321295);
    this.qyW.setBackButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(321295);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(321301);
    this.qyW.setBackgroundColor(paramInt);
    AppMethodBeat.o(321301);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(321304);
    this.qyW.setCloseButtonClickListener(paramOnClickListener);
    AppMethodBeat.o(321304);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(321307);
    this.qyW.setForegroundColor(paramInt);
    AppMethodBeat.o(321307);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(321310);
    this.qyW.setForegroundStyle(paramString);
    AppMethodBeat.o(321310);
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(321326);
    this.qyW.setFullscreenMode(paramBoolean);
    AppMethodBeat.o(321326);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(321316);
    this.qyW.setLoadingIconVisibility(paramBoolean);
    AppMethodBeat.o(321316);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(321318);
    this.qyW.setMainTitle(paramCharSequence);
    AppMethodBeat.o(321318);
  }
  
  public final void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(321321);
    this.qyW.setNavHidden(paramBoolean);
    AppMethodBeat.o(321321);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "dispatchCapsuleViewVisibilityChanged", "", "visibility", "", "setHomeButtonOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.b
  {
    a(a parama) {}
    
    public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(321275);
      d locald2 = a.a(this.qyY);
      d locald1 = locald2;
      if (locald2 == null)
      {
        s.bIx("capsuleBarImplView");
        locald1 = null;
      }
      locald1.setHomeButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(321275);
    }
    
    public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(321281);
      d locald2 = a.a(this.qyY);
      d locald1 = locald2;
      if (locald2 == null)
      {
        s.bIx("capsuleBarImplView");
        locald1 = null;
      }
      locald1.setOptionButtonOnClickListener(paramOnClickListener);
      AppMethodBeat.o(321281);
    }
    
    public final void setStyleColor(int paramInt)
    {
      AppMethodBeat.i(321266);
      d locald2 = a.a(this.qyY);
      d locald1 = locald2;
      if (locald2 == null)
      {
        s.bIx("capsuleBarImplView");
        locald1 = null;
      }
      locald1.setStyleColor(paramInt);
      AppMethodBeat.o(321266);
    }
    
    public final void zc(int paramInt)
    {
      AppMethodBeat.i(321287);
      d locald2 = a.a(this.qyY);
      d locald1 = locald2;
      if (locald2 == null)
      {
        s.bIx("capsuleBarImplView");
        locald1 = null;
      }
      locald1.setVisibility(paramInt);
      AppMethodBeat.o(321287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.a
 * JD-Core Version:    0.7.0.1
 */