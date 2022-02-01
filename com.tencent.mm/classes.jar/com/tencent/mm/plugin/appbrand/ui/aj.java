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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", "listener", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"})
public final class aj
  extends LinearLayout
  implements e
{
  private final ProgressBar krF;
  private View.OnClickListener nYX;
  private int nYY;
  private final int nYZ;
  private final ImageView nZa;
  private final TextView nZb;
  private final CircleProgressDrawable nZc;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148221);
    this.nYY = -16777216;
    this.nYZ = paramContext.getResources().getDimensionPixelSize(2131165256);
    setOrientation(0);
    setGravity(16);
    setLayoutParams(new ViewGroup.LayoutParams(-1, this.nYZ));
    Object localObject = new ImageView(paramContext);
    ((ImageView)localObject).setPadding(paramContext.getResources().getDimensionPixelSize(2131165586), 0, paramContext.getResources().getDimensionPixelSize(2131165586), 0);
    ((ImageView)localObject).setBackgroundResource(2131230872);
    ((ImageView)localObject).setImageResource(2131230855);
    ((ImageView)localObject).setId(2131296436);
    ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new aj.a(this, paramContext));
    addView((View)localObject);
    this.nZa = ((ImageView)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165186));
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setId(2131296447);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView((View)localObject);
    this.nZb = ((TextView)localObject);
    this.nZc = new CircleProgressDrawable(paramContext);
    localObject = new ProgressBar((Context)new ContextThemeWrapper(paramContext, 2131821767));
    int i = a.fromDPToPix(paramContext, 3);
    ((ProgressBar)localObject).setPadding(i, i, i, i);
    ((ProgressBar)localObject).setId(2131296433);
    i = a.fromDPToPix(paramContext, 24);
    ((ProgressBar)localObject).setLayoutParams(new ViewGroup.LayoutParams(i, i));
    ((ProgressBar)localObject).setIndeterminateDrawable((Drawable)this.nZc);
    addView((View)localObject);
    this.krF = ((ProgressBar)localObject);
    AppMethodBeat.o(148221);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(230230);
    this.nZc.stop();
    removeAllViews();
    this.nYX = null;
    AppMethodBeat.o(230230);
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
  
  public final View getCapsuleView()
  {
    return null;
  }
  
  public final int getForegroundColor()
  {
    return this.nYY;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(148212);
    CharSequence localCharSequence = this.nZb.getText();
    AppMethodBeat.o(148212);
    return localCharSequence;
  }
  
  public final void gz(boolean paramBoolean) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(148218);
    super.onAttachedToWindow();
    if (this.krF.getVisibility() == 0) {
      this.nZc.start();
    }
    AppMethodBeat.o(148218);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(148219);
    super.onDetachedFromWindow();
    this.nZc.stop();
    AppMethodBeat.o(148219);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148220);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.nYZ, 1073741824));
    AppMethodBeat.o(148220);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nYX = paramOnClickListener;
  }
  
  public final void setBackgroundAlpha(double paramDouble) {}
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(230231);
    super.setBackgroundColor(paramInt);
    if (paramInt != 0)
    {
      setWillNotDraw(false);
      AppMethodBeat.o(230231);
      return;
    }
    setWillNotDraw(true);
    AppMethodBeat.o(230231);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nYX = paramOnClickListener;
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(148215);
    this.nYY = paramInt;
    this.nZa.setColorFilter(this.nYY, PorterDuff.Mode.SRC_ATOP);
    this.nZb.setTextColor(this.nYY);
    this.nZc.setStrokeColor(this.nYY);
    this.krF.setIndeterminateDrawable((Drawable)this.nZc);
    AppMethodBeat.o(148215);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(148216);
    p.h(paramString, "style");
    setForegroundColor(e.a.afW(paramString).omu);
    AppMethodBeat.o(148216);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(148217);
    if (paramBoolean)
    {
      this.krF.setVisibility(0);
      this.nZc.caK();
      if (isAttachedToWindow())
      {
        this.nZc.start();
        AppMethodBeat.o(148217);
      }
    }
    else
    {
      this.krF.setVisibility(8);
      this.nZc.stop();
    }
    AppMethodBeat.o(148217);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(148211);
    this.nZb.setText(paramCharSequence);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aj
 * JD-Core Version:    0.7.0.1
 */