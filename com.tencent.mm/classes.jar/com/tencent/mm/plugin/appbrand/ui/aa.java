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
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleBar", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", "listener", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCapsuleHomeButtonLongClickListener", "Landroid/view/View$OnLongClickListener;", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"})
public final class aa
  extends LinearLayout
  implements f
{
  private final ProgressBar iXo;
  private View.OnClickListener mgk;
  private int mgl;
  private final int mgm;
  private final ImageView mgn;
  private final TextView mgo;
  private final CircleProgressDrawable mgp;
  
  public aa(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148221);
    this.mgl = -16777216;
    this.mgm = paramContext.getResources().getDimensionPixelSize(2131165252);
    setOrientation(0);
    setGravity(16);
    setLayoutParams(new ViewGroup.LayoutParams(-1, this.mgm));
    Object localObject = new ImageView(paramContext);
    ((ImageView)localObject).setPadding(paramContext.getResources().getDimensionPixelSize(2131165568), 0, paramContext.getResources().getDimensionPixelSize(2131165568), 0);
    ((ImageView)localObject).setBackgroundResource(2131230858);
    ((ImageView)localObject).setImageResource(2131230842);
    ((ImageView)localObject).setId(2131296406);
    ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    addView((View)localObject);
    this.mgn = ((ImageView)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131165184));
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setId(2131296415);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView((View)localObject);
    this.mgo = ((TextView)localObject);
    this.mgp = new CircleProgressDrawable(paramContext);
    localObject = new ProgressBar((Context)new ContextThemeWrapper(paramContext, 2131821718));
    int i = a.fromDPToPix(paramContext, 3);
    ((ProgressBar)localObject).setPadding(i, i, i, i);
    ((ProgressBar)localObject).setId(2131296403);
    i = a.fromDPToPix(paramContext, 24);
    ((ProgressBar)localObject).setLayoutParams(new ViewGroup.LayoutParams(i, i));
    ((ProgressBar)localObject).setIndeterminateDrawable((Drawable)this.mgp);
    addView((View)localObject);
    this.iXo = ((ProgressBar)localObject);
    AppMethodBeat.o(148221);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(206228);
    this.mgp.stop();
    removeAllViews();
    this.mgk = null;
    AppMethodBeat.o(206228);
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
    return this.mgl;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(148212);
    CharSequence localCharSequence = this.mgo.getText();
    AppMethodBeat.o(148212);
    return localCharSequence;
  }
  
  public final void hA(boolean paramBoolean) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(148218);
    super.onAttachedToWindow();
    if (this.iXo.getVisibility() == 0) {
      this.mgp.start();
    }
    AppMethodBeat.o(148218);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(148219);
    super.onDetachedFromWindow();
    this.mgp.stop();
    AppMethodBeat.o(148219);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148220);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mgm, 1073741824));
    AppMethodBeat.o(148220);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mgk = paramOnClickListener;
  }
  
  public final void setBackgroundAlpha(double paramDouble) {}
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(206229);
    super.setBackgroundColor(paramInt);
    if (paramInt != 0)
    {
      setWillNotDraw(false);
      AppMethodBeat.o(206229);
      return;
    }
    setWillNotDraw(true);
    AppMethodBeat.o(206229);
  }
  
  public final void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(148210);
    k.h(paramOnLongClickListener, "listener");
    AppMethodBeat.o(148210);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mgk = paramOnClickListener;
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(148215);
    this.mgl = paramInt;
    this.mgn.setColorFilter(this.mgl, PorterDuff.Mode.SRC_ATOP);
    this.mgo.setTextColor(this.mgl);
    this.mgp.setStrokeColor(this.mgl);
    this.iXo.setIndeterminateDrawable((Drawable)this.mgp);
    AppMethodBeat.o(148215);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(148216);
    k.h(paramString, "style");
    setForegroundColor(d.a.PW(paramString).lGx);
    AppMethodBeat.o(148216);
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(148217);
    if (paramBoolean)
    {
      this.iXo.setVisibility(0);
      this.mgp.blV();
      if (isAttachedToWindow())
      {
        this.mgp.start();
        AppMethodBeat.o(148217);
      }
    }
    else
    {
      this.iXo.setVisibility(8);
      this.mgp.stop();
    }
    AppMethodBeat.o(148217);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(148211);
    this.mgo.setText(paramCharSequence);
    AppMethodBeat.o(148211);
  }
  
  public final void setNavHidden(boolean paramBoolean) {}
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148214);
    k.h(paramOnClickListener, "listener");
    AppMethodBeat.o(148214);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(aa paramaa, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148209);
      View.OnClickListener localOnClickListener = aa.a(this.mgq);
      if (localOnClickListener != null)
      {
        localOnClickListener.onClick(paramView);
        AppMethodBeat.o(148209);
        return;
      }
      AppMethodBeat.o(148209);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa
 * JD-Core Version:    0.7.0.1
 */