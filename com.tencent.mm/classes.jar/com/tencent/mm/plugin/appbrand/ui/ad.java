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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", "listener", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"})
public final class ad
  extends LinearLayout
  implements e
{
  private final ProgressBar jtq;
  private View.OnClickListener mLP;
  private int mLQ;
  private final int mLR;
  private final ImageView mLS;
  private final TextView mLT;
  private final CircleProgressDrawable mLU;
  
  public ad(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148221);
    this.mLQ = -16777216;
    this.mLR = paramContext.getResources().getDimensionPixelSize(2131165252);
    setOrientation(0);
    setGravity(16);
    setLayoutParams(new ViewGroup.LayoutParams(-1, this.mLR));
    Object localObject = new ImageView(paramContext);
    ((ImageView)localObject).setPadding(paramContext.getResources().getDimensionPixelSize(2131165568), 0, paramContext.getResources().getDimensionPixelSize(2131165568), 0);
    ((ImageView)localObject).setBackgroundResource(2131230858);
    ((ImageView)localObject).setImageResource(2131230842);
    ((ImageView)localObject).setId(2131296406);
    ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    addView((View)localObject);
    this.mLS = ((ImageView)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165184));
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setId(2131296415);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView((View)localObject);
    this.mLT = ((TextView)localObject);
    this.mLU = new CircleProgressDrawable(paramContext);
    localObject = new ProgressBar((Context)new ContextThemeWrapper(paramContext, 2131821718));
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 3);
    ((ProgressBar)localObject).setPadding(i, i, i, i);
    ((ProgressBar)localObject).setId(2131296403);
    i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    ((ProgressBar)localObject).setLayoutParams(new ViewGroup.LayoutParams(i, i));
    ((ProgressBar)localObject).setIndeterminateDrawable((Drawable)this.mLU);
    addView((View)localObject);
    this.jtq = ((ProgressBar)localObject);
    AppMethodBeat.o(148221);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(221059);
    this.mLU.stop();
    removeAllViews();
    this.mLP = null;
    AppMethodBeat.o(221059);
  }
  
  public final void fE(boolean paramBoolean) {}
  
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
    Drawable localDrawable = super.getBackground();
    Object localObject = localDrawable;
    if (!(localDrawable instanceof ColorDrawable)) {
      localObject = null;
    }
    localObject = (ColorDrawable)localObject;
    if (localObject != null)
    {
      int i = ((ColorDrawable)localObject).getColor();
      AppMethodBeat.o(148213);
      return i;
    }
    AppMethodBeat.o(148213);
    return 0;
  }
  
  public final View getCapsuleView()
  {
    return null;
  }
  
  public final int getForegroundColor()
  {
    return this.mLQ;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(148212);
    CharSequence localCharSequence = this.mLT.getText();
    AppMethodBeat.o(148212);
    return localCharSequence;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(148218);
    super.onAttachedToWindow();
    if (this.jtq.getVisibility() == 0) {
      this.mLU.start();
    }
    AppMethodBeat.o(148218);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(148219);
    super.onDetachedFromWindow();
    this.mLU.stop();
    AppMethodBeat.o(148219);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148220);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mLR, 1073741824));
    AppMethodBeat.o(148220);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mLP = paramOnClickListener;
  }
  
  public final void setBackgroundAlpha(double paramDouble) {}
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(221060);
    super.setBackgroundColor(paramInt);
    if (paramInt != 0)
    {
      setWillNotDraw(false);
      AppMethodBeat.o(221060);
      return;
    }
    setWillNotDraw(true);
    AppMethodBeat.o(221060);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mLP = paramOnClickListener;
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(148215);
    this.mLQ = paramInt;
    this.mLS.setColorFilter(this.mLQ, PorterDuff.Mode.SRC_ATOP);
    this.mLT.setTextColor(this.mLQ);
    this.mLU.setStrokeColor(this.mLQ);
    this.jtq.setIndeterminateDrawable((Drawable)this.mLU);
    AppMethodBeat.o(148215);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(148216);
    p.h(paramString, "style");
    setForegroundColor(e.a.Wa(paramString).mZp);
    AppMethodBeat.o(148216);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(148217);
    if (paramBoolean)
    {
      this.jtq.setVisibility(0);
      this.mLU.bEw();
      if (isAttachedToWindow())
      {
        this.mLU.start();
        AppMethodBeat.o(148217);
      }
    }
    else
    {
      this.jtq.setVisibility(8);
      this.mLU.stop();
    }
    AppMethodBeat.o(148217);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(148211);
    this.mLT.setText(paramCharSequence);
    AppMethodBeat.o(148211);
  }
  
  public final void setNavHidden(boolean paramBoolean) {}
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148214);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(148214);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(ad paramad, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148209);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      localObject = ad.a(this.mLV);
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(148209);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ad
 * JD-Core Version:    0.7.0.1
 */