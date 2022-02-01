package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mBackBtnContainer", "Landroid/widget/FrameLayout;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", "listener", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  extends LinearLayout
  implements f
{
  private final ProgressBar qgC;
  private final int ugA;
  private final ImageView ugB;
  private final FrameLayout ugC;
  private final TextView ugD;
  private final CircleProgressDrawable ugE;
  private View.OnClickListener ugy;
  private int ugz;
  
  public ar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148221);
    this.ugz = -16777216;
    this.ugA = paramContext.getResources().getDimensionPixelSize(a.b.DefaultActionbarHeightPort);
    setOrientation(0);
    setGravity(16);
    setLayoutParams(new ViewGroup.LayoutParams(-1, this.ugA));
    Object localObject1 = new ImageView(paramContext);
    ((ImageView)localObject1).setPadding(paramContext.getResources().getDimensionPixelSize(a.b.SmallPadding), 0, paramContext.getResources().getDimensionPixelSize(a.b.SmallPadding), 0);
    ((ImageView)localObject1).setBackgroundResource(a.c.actionbar_menu_selector);
    ((ImageView)localObject1).setImageResource(a.c.actionbar_icon_dark_back);
    ((ImageView)localObject1).setId(a.d.actionbar_nav_btn);
    ((ImageView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((ImageView)localObject1).setOnClickListener(new ar..ExternalSyntheticLambda0(this));
    Object localObject2 = ah.aiuX;
    localObject2 = new FrameLayout(paramContext);
    ((FrameLayout)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((FrameLayout)localObject2).setMinimumWidth(paramContext.getResources().getDimensionPixelSize(a.b.app_brand_actionbar_left_margin));
    ((FrameLayout)localObject2).addView((View)localObject1);
    ah localah = ah.aiuX;
    this.ugC = ((FrameLayout)localObject2);
    addView((View)this.ugC);
    localObject2 = ah.aiuX;
    this.ugB = ((ImageView)localObject1);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setTextSize(0, paramContext.getResources().getDimensionPixelSize(a.b.ActionBarTextSize));
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setId(a.d.actionbar_title_main);
    ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localObject2 = ah.aiuX;
    addView((View)localObject1);
    localObject2 = ah.aiuX;
    this.ugD = ((TextView)localObject1);
    this.ugE = new CircleProgressDrawable(paramContext);
    localObject1 = new ProgressBar((Context)new ContextThemeWrapper(paramContext, a.h.mediumCustomProgressBar));
    int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 3);
    ((ProgressBar)localObject1).setPadding(i, i, i, i);
    ((ProgressBar)localObject1).setId(a.d.actionbar_loading_icon);
    i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
    ((ProgressBar)localObject1).setLayoutParams(new ViewGroup.LayoutParams(i, i));
    ((ProgressBar)localObject1).setIndeterminateDrawable((Drawable)this.ugE);
    paramContext = ah.aiuX;
    addView((View)localObject1);
    paramContext = ah.aiuX;
    this.qgC = ((ProgressBar)localObject1);
    AppMethodBeat.o(148221);
  }
  
  private static final void a(ar paramar, View paramView)
  {
    AppMethodBeat.i(322079);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramar);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramar, "this$0");
    paramar = paramar.ugy;
    if (paramar != null) {
      paramar.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322079);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(322085);
    this.ugE.stop();
    removeAllViews();
    this.ugy = null;
    AppMethodBeat.o(322085);
  }
  
  public final View getActionView()
  {
    return (View)this;
  }
  
  public final double getBackgroundAlpha()
  {
    return 1.0D;
  }
  
  public final int getBackgroundColor()
  {
    AppMethodBeat.i(148213);
    Object localObject = super.getBackground();
    if ((localObject instanceof ColorDrawable)) {}
    for (localObject = (ColorDrawable)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(148213);
      return 0;
    }
    int i = ((ColorDrawable)localObject).getColor();
    AppMethodBeat.o(148213);
    return i;
  }
  
  public final View getCapsuleView()
  {
    return null;
  }
  
  public final int getForegroundColor()
  {
    return this.ugz;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(148212);
    CharSequence localCharSequence = this.ugD.getText();
    AppMethodBeat.o(148212);
    return localCharSequence;
  }
  
  public final void hZ(boolean paramBoolean) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(148218);
    super.onAttachedToWindow();
    if (this.qgC.getVisibility() == 0) {
      this.ugE.start();
    }
    AppMethodBeat.o(148218);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(148219);
    super.onDetachedFromWindow();
    this.ugE.stop();
    AppMethodBeat.o(148219);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148220);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.ugA, 1073741824));
    AppMethodBeat.o(148220);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ugy = paramOnClickListener;
  }
  
  public final void setBackgroundAlpha(double paramDouble) {}
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(322127);
    super.setBackgroundColor(paramInt);
    if (paramInt != 0)
    {
      setWillNotDraw(false);
      AppMethodBeat.o(322127);
      return;
    }
    setWillNotDraw(true);
    AppMethodBeat.o(322127);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ugy = paramOnClickListener;
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(148215);
    this.ugz = paramInt;
    this.ugB.setColorFilter(this.ugz, PorterDuff.Mode.SRC_ATOP);
    this.ugD.setTextColor(this.ugz);
    this.ugE.setStrokeColor(this.ugz);
    this.qgC.setIndeterminateDrawable((Drawable)this.ugE);
    AppMethodBeat.o(148215);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(148216);
    s.u(paramString, "style");
    setForegroundColor(f.a.agY(paramString).uzh);
    AppMethodBeat.o(148216);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(148217);
    if (paramBoolean)
    {
      this.qgC.setVisibility(0);
      this.ugE.cQH();
      if (isAttachedToWindow())
      {
        this.ugE.start();
        AppMethodBeat.o(148217);
      }
    }
    else
    {
      this.qgC.setVisibility(8);
      this.ugE.stop();
    }
    AppMethodBeat.o(148217);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(148211);
    this.ugD.setText(paramCharSequence);
    AppMethodBeat.o(148211);
  }
  
  public final void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(322131);
    ImageView localImageView = this.ugB;
    if (!paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(322131);
      return;
    }
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148214);
    s.u(paramOnClickListener, "listener");
    AppMethodBeat.o(148214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ar
 * JD-Core Version:    0.7.0.1
 */