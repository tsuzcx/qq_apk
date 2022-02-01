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
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.page.a.b;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleBar", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", "listener", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCapsuleHomeButtonLongClickListener", "Landroid/view/View$OnLongClickListener;", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"})
public final class ac
  extends LinearLayout
  implements f
{
  private final ProgressBar jqx;
  private View.OnClickListener mGL;
  private int mGM;
  private final int mGN;
  private final ImageView mGO;
  private final TextView mGP;
  private final CircleProgressDrawable mGQ;
  
  public ac(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148221);
    this.mGM = -16777216;
    this.mGN = paramContext.getResources().getDimensionPixelSize(2131165252);
    setOrientation(0);
    setGravity(16);
    setLayoutParams(new ViewGroup.LayoutParams(-1, this.mGN));
    Object localObject = new ImageView(paramContext);
    ((ImageView)localObject).setPadding(paramContext.getResources().getDimensionPixelSize(2131165568), 0, paramContext.getResources().getDimensionPixelSize(2131165568), 0);
    ((ImageView)localObject).setBackgroundResource(2131230858);
    ((ImageView)localObject).setImageResource(2131230842);
    ((ImageView)localObject).setId(2131296406);
    ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new ac.a(this, paramContext));
    addView((View)localObject);
    this.mGO = ((ImageView)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165184));
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setId(2131296415);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView((View)localObject);
    this.mGP = ((TextView)localObject);
    this.mGQ = new CircleProgressDrawable(paramContext);
    localObject = new ProgressBar((Context)new ContextThemeWrapper(paramContext, 2131821718));
    int i = a.fromDPToPix(paramContext, 3);
    ((ProgressBar)localObject).setPadding(i, i, i, i);
    ((ProgressBar)localObject).setId(2131296403);
    i = a.fromDPToPix(paramContext, 24);
    ((ProgressBar)localObject).setLayoutParams(new ViewGroup.LayoutParams(i, i));
    ((ProgressBar)localObject).setIndeterminateDrawable((Drawable)this.mGQ);
    addView((View)localObject);
    this.jqx = ((ProgressBar)localObject);
    AppMethodBeat.o(148221);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(192446);
    this.mGQ.stop();
    removeAllViews();
    this.mGL = null;
    AppMethodBeat.o(192446);
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
  
  public final b getCapsuleBar()
  {
    return null;
  }
  
  public final View getCapsuleView()
  {
    return null;
  }
  
  public final int getForegroundColor()
  {
    return this.mGM;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(148212);
    CharSequence localCharSequence = this.mGP.getText();
    AppMethodBeat.o(148212);
    return localCharSequence;
  }
  
  public final void hK(boolean paramBoolean) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(148218);
    super.onAttachedToWindow();
    if (this.jqx.getVisibility() == 0) {
      this.mGQ.start();
    }
    AppMethodBeat.o(148218);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(148219);
    super.onDetachedFromWindow();
    this.mGQ.stop();
    AppMethodBeat.o(148219);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148220);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mGN, 1073741824));
    AppMethodBeat.o(148220);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mGL = paramOnClickListener;
  }
  
  public final void setBackgroundAlpha(double paramDouble) {}
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(192447);
    super.setBackgroundColor(paramInt);
    if (paramInt != 0)
    {
      setWillNotDraw(false);
      AppMethodBeat.o(192447);
      return;
    }
    setWillNotDraw(true);
    AppMethodBeat.o(192447);
  }
  
  public final void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(148210);
    p.h(paramOnLongClickListener, "listener");
    AppMethodBeat.o(148210);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mGL = paramOnClickListener;
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(148215);
    this.mGM = paramInt;
    this.mGO.setColorFilter(this.mGM, PorterDuff.Mode.SRC_ATOP);
    this.mGP.setTextColor(this.mGM);
    this.mGQ.setStrokeColor(this.mGM);
    this.jqx.setIndeterminateDrawable((Drawable)this.mGQ);
    AppMethodBeat.o(148215);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(148216);
    p.h(paramString, "style");
    setForegroundColor(d.a.TA(paramString).mga);
    AppMethodBeat.o(148216);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(148217);
    if (paramBoolean)
    {
      this.jqx.setVisibility(0);
      this.mGQ.Mx();
      if (isAttachedToWindow())
      {
        this.mGQ.start();
        AppMethodBeat.o(148217);
      }
    }
    else
    {
      this.jqx.setVisibility(8);
      this.mGQ.stop();
    }
    AppMethodBeat.o(148217);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(148211);
    this.mGP.setText(paramCharSequence);
    AppMethodBeat.o(148211);
  }
  
  public final void setNavHidden(boolean paramBoolean) {}
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148214);
    p.h(paramOnClickListener, "listener");
    AppMethodBeat.o(148214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ac
 * JD-Core Version:    0.7.0.1
 */