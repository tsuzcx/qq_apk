package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.widget.d.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseAppBrandSingleCloseCapsuleBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/IAppBrandHalfScreenCapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/IDarkModeUIAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "transparentAnimating", "", "animateHeaderAlpha", "", "alpha", "", "blink", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "prior", "destroy", "getCloseButton", "Landroid/view/View;", "getView", "getWxaIcon", "Landroid/widget/ImageView;", "isTouchCloseButton", "rx", "ry", "setHeaderAlpha", "percent", "setHomeButtonOnClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setOptionButtonOnClickListener", "setStyleColor", "color", "setTitleClickListener", "listener", "setWxaIconUrl", "url", "showHeader", "show", "animate", "callback", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CallBack;", "transformResource", "reId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseAppBrandSingleCloseCapsuleBar
  extends FrameLayout
  implements k, n
{
  private final String TAG = "MicroMsg.BaseAppBrandSingleCloseCapsuleBar";
  private boolean tCA;
  
  public BaseAppBrandSingleCloseCapsuleBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseAppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseAppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BaseAppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private static final void a(BaseAppBrandSingleCloseCapsuleBar paramBaseAppBrandSingleCloseCapsuleBar, j paramj, ValueAnimator paramValueAnimator)
  {
    s.u(paramBaseAppBrandSingleCloseCapsuleBar, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
    float f = ((Integer)paramValueAnimator).intValue() / 255;
    paramBaseAppBrandSingleCloseCapsuleBar.bS(f);
    if (paramj != null) {
      paramj.bT(f);
    }
  }
  
  private void bS(float paramFloat)
  {
    Iterator localIterator = getViewsNeedResponseAlphaAnimation().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setAlpha(paramFloat);
      if (paramFloat == 0.0F) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label62;
        }
        localView.setClickable(false);
        break;
      }
      label62:
      if (!localView.isClickable()) {
        localView.setClickable(true);
      }
    }
  }
  
  public int CO(int paramInt)
  {
    throw new RuntimeException("must override this method");
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, j paramj)
  {
    if (this.tCA)
    {
      Log.i(getTAG(), "is animating, return");
      return;
    }
    int j;
    int i;
    if (paramBoolean1)
    {
      j = 255;
      i = (int)(cGp() * 255.0F);
      Log.i(getTAG(), s.X("iconIv.alpha=", Float.valueOf(cGp())));
      if (!paramBoolean1)
      {
        if (cGp() != 0.0F) {
          break label131;
        }
        k = 1;
        label71:
        if (k != 0) {}
      }
      else
      {
        if (!paramBoolean1) {
          break label143;
        }
        if (cGp() != 1.0F) {
          break label137;
        }
      }
    }
    label131:
    label137:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        break label143;
      }
      Log.i(getTAG(), "status not change, return");
      paramj.bT(cGp());
      return;
      i = (int)(cGp() * 255.0F);
      j = 0;
      break;
      k = 0;
      break label71;
    }
    label143:
    if (!paramBoolean2)
    {
      bS(j / 255);
      paramj.bT(cGp());
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
    if (localValueAnimator != null) {
      localValueAnimator.addUpdateListener(new BaseAppBrandSingleCloseCapsuleBar..ExternalSyntheticLambda0(this, paramj));
    }
    if (localValueAnimator != null) {
      localValueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    }
    if (localValueAnimator != null) {
      localValueAnimator.setDuration(300L);
    }
    if (localValueAnimator != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)new a(this));
    }
    if (localValueAnimator != null) {
      localValueAnimator.start();
    }
    this.tCA = true;
  }
  
  public final boolean au(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    View localView = getCloseButton();
    if (localView == null) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      localView.getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      k = localView.getWidth();
      m = localView.getHeight();
    } while ((paramFloat1 < i) || (paramFloat1 > i + k) || (paramFloat2 < j) || (paramFloat2 > j + m));
    return true;
  }
  
  protected abstract View getCloseButton();
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  protected abstract ImageView getWxaIcon();
  
  public void setHeaderAlpha(float paramFloat)
  {
    Log.i(getTAG(), "setHeaderAlpha percent[" + paramFloat + ']');
    bS(255.0F * paramFloat / 100.0F / 255.0F);
  }
  
  public void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setStyleColor(int paramInt) {}
  
  public void setTitleClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setWxaIconUrl(String paramString)
  {
    if (getWxaIcon() == null) {
      return;
    }
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label60;
      }
      paramString = getWxaIcon();
      if (paramString == null) {
        break;
      }
      paramString.setImageDrawable(a.m(MMApplicationContext.getContext(), ba.e.miniprogram_default_avatar));
      return;
    }
    label60:
    localObject = b.bEY();
    ImageView localImageView = getWxaIcon();
    s.checkNotNull(localImageView);
    ((b)localObject).a(localImageView, paramString, ba.e.miniprogram_default_avatar, (b.h)new e());
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/capsulebar/BaseAppBrandSingleCloseCapsuleBar$showHeader$2", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerImp$AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends f.a
  {
    a(BaseAppBrandSingleCloseCapsuleBar paramBaseAppBrandSingleCloseCapsuleBar) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(325333);
      BaseAppBrandSingleCloseCapsuleBar.a(this.tCB);
      AppMethodBeat.o(325333);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.BaseAppBrandSingleCloseCapsuleBar
 * JD-Core Version:    0.7.0.1
 */