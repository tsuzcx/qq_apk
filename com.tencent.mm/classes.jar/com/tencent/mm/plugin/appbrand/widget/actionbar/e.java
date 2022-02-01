package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.svg.a.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBarSinglePageMode;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackgroundAlpha", "", "mBackgroundColor", "", "decorateDarkModeStyle", "", "isDarkMode", "", "destroy", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getSecurityTipsTextView", "Landroid/widget/TextView;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setForwardOnClickListener", "setForwardText", "forwardText", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "setSecurityTipsTitleColor", "showCapsuleArea", "show", "toSecurityTips", "toSecurityTipsCanForward", "plugin-appbrand-integration_release"})
public final class e
  extends RelativeLayout
  implements f
{
  private HashMap _$_findViewCache;
  private int rou;
  private double rov;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272872);
    this.rov = 1.0D;
    addView(LayoutInflater.from(paramContext).inflate(au.g.app_brand_action_bar_single_page_mode, (ViewGroup)this, false));
    AppMethodBeat.o(272872);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(272875);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(272875);
    return localView1;
  }
  
  public final void cnh()
  {
    AppMethodBeat.i(272854);
    Object localObject = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarTitleTv);
    p.j(localObject, "singlePageModeActionBarTitleTv");
    ((TextView)localObject).setVisibility(8);
    localObject = (LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarSecurityArea);
    p.j(localObject, "singlePageModeActionBarSecurityArea");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = (LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarForwardArea);
    p.j(localObject, "singlePageModeActionBarForwardArea");
    ((LinearLayout)localObject).setVisibility(8);
    localObject = (LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarRoot);
    p.j(localObject, "singlePageModeActionBarRoot");
    localObject = ((LinearLayout)localObject).getLayoutParams();
    Context localContext = getContext();
    p.j(localContext, "context");
    ((ViewGroup.LayoutParams)localObject).height = localContext.getResources().getDimensionPixelSize(au.d.app_brand_actionbar_height);
    AppMethodBeat.o(272854);
  }
  
  public final void cni()
  {
    AppMethodBeat.i(272855);
    Object localObject = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarTitleTv);
    p.j(localObject, "singlePageModeActionBarTitleTv");
    ((TextView)localObject).setVisibility(8);
    localObject = (LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarSecurityArea);
    p.j(localObject, "singlePageModeActionBarSecurityArea");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = (LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarForwardArea);
    p.j(localObject, "singlePageModeActionBarForwardArea");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = (LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarRoot);
    p.j(localObject, "singlePageModeActionBarRoot");
    localObject = ((LinearLayout)localObject).getLayoutParams();
    Context localContext = getContext();
    p.j(localContext, "context");
    ((ViewGroup.LayoutParams)localObject).height = localContext.getResources().getDimensionPixelSize(au.d.app_brand_actionbar_height_single_page_mode_security);
    AppMethodBeat.o(272855);
  }
  
  public final void destroy() {}
  
  public final View getActionView()
  {
    return (View)this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.rov;
  }
  
  public final int getBackgroundColor()
  {
    return this.rou;
  }
  
  public final View getCapsuleView()
  {
    return null;
  }
  
  public final int getForegroundColor()
  {
    AppMethodBeat.i(272869);
    TextView localTextView = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarTitleTv);
    p.j(localTextView, "singlePageModeActionBarTitleTv");
    int i = localTextView.getCurrentTextColor();
    AppMethodBeat.o(272869);
    return i;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(272870);
    Object localObject = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarTitleTv);
    p.j(localObject, "singlePageModeActionBarTitleTv");
    localObject = ((TextView)localObject).getText();
    p.j(localObject, "singlePageModeActionBarTitleTv.text");
    AppMethodBeat.o(272870);
    return localObject;
  }
  
  public final TextView getSecurityTipsTextView()
  {
    AppMethodBeat.i(272857);
    TextView localTextView = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarSecurityTipsTv);
    p.j(localTextView, "singlePageModeActionBarSecurityTipsTv");
    AppMethodBeat.o(272857);
    return localTextView;
  }
  
  public final void hk(boolean paramBoolean) {}
  
  public final void kb(boolean paramBoolean)
  {
    int j = -1;
    AppMethodBeat.i(272853);
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = getContext();
      p.j(localObject1, "context");
      i = ((Context)localObject1).getResources().getColor(au.c.app_brand_single_page_mode_action_bg_dark);
      setBackgroundColor(i);
      if (!paramBoolean) {
        break label212;
      }
      i = -1;
      label47:
      setForegroundColor(i);
      localObject1 = (ImageView)_$_findCachedViewById(au.f.singlePageModeActionBarCloseBtn);
      Object localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      if (!paramBoolean) {
        break label219;
      }
      i = au.h.actionbar_icon_light_close;
      label92:
      ((ImageView)localObject1).setImageDrawable(a.h((Resources)localObject2, i));
      localObject1 = (AppBrandActionBarCustomImageView)_$_findCachedViewById(au.f.singlePageModeActionBarMoreBtn);
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      if (!paramBoolean) {
        break label226;
      }
      i = au.h.actionbar_icon_light_more;
      label143:
      ((AppBrandActionBarCustomImageView)localObject1).setImageDrawable(a.h((Resources)localObject2, i));
      localObject1 = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarSecurityTipsTv);
      if (!paramBoolean) {
        break label233;
      }
    }
    label212:
    label219:
    label226:
    label233:
    for (int i = j;; i = -16777216)
    {
      ((TextView)localObject1).setTextColor(i);
      AppMethodBeat.o(272853);
      return;
      localObject1 = getContext();
      p.j(localObject1, "context");
      i = ((Context)localObject1).getResources().getColor(au.c.app_brand_single_page_mode_action_bg_light);
      break;
      i = -16777216;
      break label47;
      i = au.h.actionbar_icon_dark_close;
      break label92;
      i = au.h.actionbar_icon_dark_more;
      break label143;
    }
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(272865);
    this.rov = paramDouble;
    Drawable localDrawable2 = super.getBackground();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null)
    {
      super.setBackgroundColor(this.rou);
      localDrawable1 = super.getBackground();
    }
    if (localDrawable1 == null) {
      p.iCn();
    }
    localDrawable1.setAlpha((int)(255.0D * paramDouble));
    AppMethodBeat.o(272865);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(272861);
    this.rou = paramInt;
    super.setBackgroundColor(paramInt);
    setBackgroundAlpha(this.rov);
    AppMethodBeat.o(272861);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(272866);
    ((ImageView)_$_findCachedViewById(au.f.singlePageModeActionBarCloseBtn)).setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(272866);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(272864);
    ((TextView)_$_findCachedViewById(au.f.singlePageModeActionBarTitleTv)).setTextColor(paramInt);
    AppMethodBeat.o(272864);
  }
  
  public final void setForegroundStyle(String paramString) {}
  
  public final void setForwardOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(272858);
    ((LinearLayout)_$_findCachedViewById(au.f.singlePageModeActionBarForwardClickArea)).setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(272858);
  }
  
  public final void setForwardText(String paramString)
  {
    AppMethodBeat.i(272859);
    p.k(paramString, "forwardText");
    TextView localTextView = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarForwardTitleTv);
    p.j(localTextView, "singlePageModeActionBarForwardTitleTv");
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(272859);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean) {}
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(272863);
    TextView localTextView = (TextView)_$_findCachedViewById(au.f.singlePageModeActionBarTitleTv);
    p.j(localTextView, "singlePageModeActionBarTitleTv");
    localTextView.setText(paramCharSequence);
    AppMethodBeat.o(272863);
  }
  
  public final void setNavHidden(boolean paramBoolean) {}
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(272862);
    ((AppBrandActionBarCustomImageView)_$_findCachedViewById(au.f.singlePageModeActionBarMoreBtn)).setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(272862);
  }
  
  public final void setSecurityTipsTitleColor(int paramInt)
  {
    AppMethodBeat.i(272856);
    ((TextView)_$_findCachedViewById(au.f.singlePageModeActionBarSecurityTipsTv)).setTextColor(paramInt);
    AppMethodBeat.o(272856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e
 * JD-Core Version:    0.7.0.1
 */