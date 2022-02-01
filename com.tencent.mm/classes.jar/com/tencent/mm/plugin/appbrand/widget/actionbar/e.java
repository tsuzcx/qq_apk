package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.svg.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBarSinglePageMode;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackgroundAlpha", "", "mBackgroundColor", "", "decorateDarkModeStyle", "", "isDarkMode", "", "destroy", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getSecurityTipsTextView", "Landroid/widget/TextView;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setForwardOnClickListener", "setForwardText", "forwardText", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "setSecurityTipsTitleColor", "showCapsuleArea", "show", "toSecurityTips", "toSecurityTipsCanForward", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RelativeLayout
  implements f
{
  private int uyB;
  private double uyC;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(324157);
    this.uyC = 1.0D;
    addView(LayoutInflater.from(paramContext).inflate(ba.g.app_brand_action_bar_single_page_mode, (ViewGroup)this, false));
    AppMethodBeat.o(324157);
  }
  
  public final void cPa()
  {
    AppMethodBeat.i(324163);
    ((TextView)findViewById(ba.f.singlePageModeActionBarTitleTv)).setVisibility(8);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarSecurityArea)).setVisibility(0);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarForwardArea)).setVisibility(8);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarRoot)).getLayoutParams().height = getContext().getResources().getDimensionPixelSize(ba.d.app_brand_actionbar_height);
    AppMethodBeat.o(324163);
  }
  
  public final void cPb()
  {
    AppMethodBeat.i(324167);
    ((TextView)findViewById(ba.f.singlePageModeActionBarTitleTv)).setVisibility(8);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarSecurityArea)).setVisibility(0);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarForwardArea)).setVisibility(0);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarRoot)).getLayoutParams().height = getContext().getResources().getDimensionPixelSize(ba.d.app_brand_actionbar_height_single_page_mode_security);
    AppMethodBeat.o(324167);
  }
  
  public final void destroy() {}
  
  public final View getActionView()
  {
    return (View)this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.uyC;
  }
  
  public final int getBackgroundColor()
  {
    return this.uyB;
  }
  
  public final View getCapsuleView()
  {
    return null;
  }
  
  public final int getForegroundColor()
  {
    AppMethodBeat.i(324208);
    int i = ((TextView)findViewById(ba.f.singlePageModeActionBarTitleTv)).getCurrentTextColor();
    AppMethodBeat.o(324208);
    return i;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(324211);
    CharSequence localCharSequence = ((TextView)findViewById(ba.f.singlePageModeActionBarTitleTv)).getText();
    s.s(localCharSequence, "singlePageModeActionBarTitleTv.text");
    AppMethodBeat.o(324211);
    return localCharSequence;
  }
  
  public final TextView getSecurityTipsTextView()
  {
    AppMethodBeat.i(324172);
    TextView localTextView = (TextView)findViewById(ba.f.singlePageModeActionBarSecurityTipsTv);
    s.s(localTextView, "singlePageModeActionBarSecurityTipsTv");
    AppMethodBeat.o(324172);
    return localTextView;
  }
  
  public final void hZ(boolean paramBoolean) {}
  
  public final void lm(boolean paramBoolean)
  {
    int j = -1;
    AppMethodBeat.i(324160);
    label36:
    Object localObject;
    if (paramBoolean)
    {
      i = getContext().getResources().getColor(ba.c.app_brand_single_page_mode_action_bg_dark);
      setBackgroundColor(i);
      if (!paramBoolean) {
        break label168;
      }
      i = -1;
      setForegroundColor(i);
      localObject = (ImageView)findViewById(ba.f.singlePageModeActionBarCloseBtn);
      Resources localResources = getContext().getResources();
      if (!paramBoolean) {
        break label174;
      }
      i = ba.h.actionbar_icon_light_close;
      label70:
      ((ImageView)localObject).setImageDrawable(a.i(localResources, i));
      localObject = (AppBrandActionBarCustomImageView)findViewById(ba.f.singlePageModeActionBarMoreBtn);
      localResources = getContext().getResources();
      if (!paramBoolean) {
        break label181;
      }
      i = ba.h.actionbar_icon_light_more;
      label110:
      ((AppBrandActionBarCustomImageView)localObject).setImageDrawable(a.i(localResources, i));
      localObject = (TextView)findViewById(ba.f.singlePageModeActionBarSecurityTipsTv);
      if (!paramBoolean) {
        break label188;
      }
    }
    label168:
    label174:
    label181:
    label188:
    for (int i = j;; i = -16777216)
    {
      ((TextView)localObject).setTextColor(i);
      AppMethodBeat.o(324160);
      return;
      i = getContext().getResources().getColor(ba.c.app_brand_single_page_mode_action_bg_light);
      break;
      i = -16777216;
      break label36;
      i = ba.h.actionbar_icon_dark_close;
      break label70;
      i = ba.h.actionbar_icon_dark_more;
      break label110;
    }
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(324192);
    this.uyC = paramDouble;
    Drawable localDrawable2 = super.getBackground();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null)
    {
      super.setBackgroundColor(this.uyB);
      localDrawable1 = super.getBackground();
    }
    s.checkNotNull(localDrawable1);
    localDrawable1.setAlpha((int)(255.0D * paramDouble));
    AppMethodBeat.o(324192);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(324178);
    this.uyB = paramInt;
    super.setBackgroundColor(paramInt);
    setBackgroundAlpha(this.uyC);
    AppMethodBeat.o(324178);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(324195);
    ((ImageView)findViewById(ba.f.singlePageModeActionBarCloseBtn)).setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(324195);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(324186);
    ((TextView)findViewById(ba.f.singlePageModeActionBarTitleTv)).setTextColor(paramInt);
    AppMethodBeat.o(324186);
  }
  
  public final void setForegroundStyle(String paramString) {}
  
  public final void setForwardOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(324174);
    ((LinearLayout)findViewById(ba.f.singlePageModeActionBarForwardClickArea)).setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(324174);
  }
  
  public final void setForwardText(String paramString)
  {
    AppMethodBeat.i(324176);
    s.u(paramString, "forwardText");
    ((TextView)findViewById(ba.f.singlePageModeActionBarForwardTitleTv)).setText((CharSequence)paramString);
    AppMethodBeat.o(324176);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean) {}
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(324184);
    ((TextView)findViewById(ba.f.singlePageModeActionBarTitleTv)).setText(paramCharSequence);
    AppMethodBeat.o(324184);
  }
  
  public final void setNavHidden(boolean paramBoolean) {}
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(324182);
    ((AppBrandActionBarCustomImageView)findViewById(ba.f.singlePageModeActionBarMoreBtn)).setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(324182);
  }
  
  public final void setSecurityTipsTitleColor(int paramInt)
  {
    AppMethodBeat.i(324170);
    ((TextView)findViewById(ba.f.singlePageModeActionBarSecurityTipsTv)).setTextColor(paramInt);
    AppMethodBeat.o(324170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e
 * JD-Core Version:    0.7.0.1
 */