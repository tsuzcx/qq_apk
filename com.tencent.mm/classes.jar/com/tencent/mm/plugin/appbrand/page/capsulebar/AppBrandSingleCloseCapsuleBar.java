package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.widget.c.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandSingleCloseCapsuleBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "closeV", "Landroid/view/View;", "contentView", "iconIv", "Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "transparentAnimating", "", "blink", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "destroy", "", "isHeaderTransparent", "isTouchCloseButton", "rx", "", "ry", "setCloseBtnListener", "listener", "Landroid/view/View$OnClickListener;", "setHeaderAlpha", "percent", "setHomeButtonOnClickListener", "onClickListener", "setOptionButtonOnClickListener", "setStyleColor", "color", "setTitle", "name", "", "setWxaIconUrl", "url", "showHeader", "show", "animate", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandSingleCloseCapsuleBar
  extends FrameLayout
  implements g
{
  public static final AppBrandSingleCloseCapsuleBar.a qxu;
  private View contentView;
  private TextView jbF;
  private ImageView jmf;
  public View qxs;
  private boolean qxt;
  
  static
  {
    AppMethodBeat.i(270721);
    qxu = new AppBrandSingleCloseCapsuleBar.a((byte)0);
    AppMethodBeat.o(270721);
  }
  
  public AppBrandSingleCloseCapsuleBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(270716);
    paramContext = LayoutInflater.from(getContext()).inflate(au.g.appbrand_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(au.f.root_container);
    p.j(paramContext, "LayoutInflater.from(cont…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(au.f.close);
    p.j(paramContext, "findViewById(R.id.close)");
    this.qxs = paramContext;
    paramContext = findViewById(au.f.name);
    p.j(paramContext, "findViewById(R.id.name)");
    this.jbF = ((TextView)paramContext);
    paramContext = findViewById(au.f.icon);
    p.j(paramContext, "findViewById(R.id.icon)");
    this.jmf = ((ImageView)paramContext);
    AppMethodBeat.o(270716);
  }
  
  public AppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(270718);
    paramContext = LayoutInflater.from(getContext()).inflate(au.g.appbrand_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(au.f.root_container);
    p.j(paramContext, "LayoutInflater.from(cont…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(au.f.close);
    p.j(paramContext, "findViewById(R.id.close)");
    this.qxs = paramContext;
    paramContext = findViewById(au.f.name);
    p.j(paramContext, "findViewById(R.id.name)");
    this.jbF = ((TextView)paramContext);
    paramContext = findViewById(au.f.icon);
    p.j(paramContext, "findViewById(R.id.icon)");
    this.jmf = ((ImageView)paramContext);
    AppMethodBeat.o(270718);
  }
  
  public AppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(270720);
    paramContext = LayoutInflater.from(getContext()).inflate(au.g.appbrand_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(au.f.root_container);
    p.j(paramContext, "LayoutInflater.from(cont…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(au.f.close);
    p.j(paramContext, "findViewById(R.id.close)");
    this.qxs = paramContext;
    paramContext = findViewById(au.f.name);
    p.j(paramContext, "findViewById(R.id.name)");
    this.jbF = ((TextView)paramContext);
    paramContext = findViewById(au.f.icon);
    p.j(paramContext, "findViewById(R.id.icon)");
    this.jmf = ((ImageView)paramContext);
    AppMethodBeat.o(270720);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(270714);
    if (this.qxt)
    {
      Log.i("MicroMsg.AppBrandSingleCloseCapsuleBar", "is animating, return");
      AppMethodBeat.o(270714);
      return;
    }
    Object localObject = getContext();
    p.j(localObject, "context");
    final int k = ((Context)localObject).getResources().getColor(au.c.app_brand_single_close_capsule_bar_bg);
    int j;
    int i;
    if (paramBoolean1)
    {
      j = 255;
      i = (int)(this.jmf.getAlpha() * 255.0F);
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandSingleCloseCapsuleBar", "iconIv.alpha=" + this.jmf.getAlpha());
      if (((paramBoolean1) || (this.jmf.getAlpha() != 0.0F)) && ((!paramBoolean1) || (this.jmf.getAlpha() != 1.0F))) {
        break;
      }
      Log.i("MicroMsg.AppBrandSingleCloseCapsuleBar", "status not change, return");
      AppMethodBeat.o(270714);
      return;
      i = (int)(this.jmf.getAlpha() * 255.0F);
      j = 0;
    }
    if (!paramBoolean2)
    {
      this.jmf.setAlpha(j / 255);
      this.jbF.setAlpha(j / 255);
      i = Color.argb(j, Color.red(k), Color.green(k), Color.blue(k));
      setBackgroundColor(i);
      this.contentView.setBackgroundColor(i);
      AppMethodBeat.o(270714);
      return;
    }
    localObject = ValueAnimator.ofInt(new int[] { i, j });
    if (localObject != null) {
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, k));
    }
    if (localObject != null) {
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    }
    if (localObject != null) {
      ((ValueAnimator)localObject).setDuration(300L);
    }
    if (localObject != null) {
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new c(this));
    }
    if (localObject != null) {
      ((ValueAnimator)localObject).start();
    }
    this.qxt = true;
    AppMethodBeat.o(270714);
  }
  
  public final boolean cfA()
  {
    AppMethodBeat.i(270713);
    if ((this.contentView.getBackground() instanceof ColorDrawable))
    {
      Object localObject = this.contentView.getBackground();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        AppMethodBeat.o(270713);
        throw ((Throwable)localObject);
      }
      if (((ColorDrawable)localObject).getAlpha() == 0)
      {
        AppMethodBeat.o(270713);
        return true;
      }
      AppMethodBeat.o(270713);
      return false;
    }
    AppMethodBeat.o(270713);
    return false;
  }
  
  public final void setCloseBtnListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(270710);
    p.k(paramOnClickListener, "listener");
    this.qxs.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(270710);
  }
  
  public final void setHeaderAlpha(float paramFloat)
  {
    AppMethodBeat.i(270712);
    Log.i("MicroMsg.AppBrandSingleCloseCapsuleBar", "setHeaderAlpha percent[" + paramFloat + ']');
    paramFloat = 255.0F * paramFloat / 100.0F;
    this.jmf.setAlpha(paramFloat / 255.0F);
    this.jbF.setAlpha(paramFloat / 255.0F);
    Context localContext = getContext();
    p.j(localContext, "context");
    int i = localContext.getResources().getColor(au.c.app_brand_single_close_capsule_bar_bg);
    setBackgroundColor(Color.argb((int)paramFloat, Color.red(i), Color.green(i), Color.blue(i)));
    this.contentView.setBackgroundColor(Color.argb((int)paramFloat, Color.red(i), Color.green(i), Color.blue(i)));
    AppMethodBeat.o(270712);
  }
  
  public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public final void setStyleColor(int paramInt) {}
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(270709);
    p.k(paramString, "name");
    this.jbF.setText((CharSequence)paramString);
    AppMethodBeat.o(270709);
  }
  
  public final void setWxaIconUrl(String paramString)
  {
    AppMethodBeat.i(270708);
    p.k(paramString, "url");
    b.bhh().a(this.jmf, paramString, au.e.miniprogram_default_avatar, (b.h)new e());
    AppMethodBeat.o(270708);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(AppBrandSingleCloseCapsuleBar paramAppBrandSingleCloseCapsuleBar, int paramInt) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(265892);
      p.j(paramValueAnimator, "animation");
      Object localObject = paramValueAnimator.getAnimatedValue();
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(265892);
        throw paramValueAnimator;
      }
      int i = Color.argb(((Integer)localObject).intValue(), Color.red(k), Color.green(k), Color.blue(k));
      Log.d("MicroMsg.AppBrandSingleCloseCapsuleBar", "[showHeader] setBg=" + Integer.toHexString(i));
      this.qxv.setBackgroundColor(i);
      AppBrandSingleCloseCapsuleBar.a(this.qxv).setBackgroundColor(i);
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(265892);
        throw paramValueAnimator;
      }
      float f = ((Integer)paramValueAnimator).intValue() / 255;
      AppBrandSingleCloseCapsuleBar.b(this.qxv).setAlpha(f);
      AppBrandSingleCloseCapsuleBar.c(this.qxv).setAlpha(f);
      AppMethodBeat.o(265892);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandSingleCloseCapsuleBar$showHeader$2", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"})
  public static final class c
    extends g.a
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(265800);
      AppBrandSingleCloseCapsuleBar.d(this.qxv);
      AppMethodBeat.o(265800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandSingleCloseCapsuleBar
 * JD-Core Version:    0.7.0.1
 */