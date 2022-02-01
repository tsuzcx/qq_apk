package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveWarnningCountWidget;", "", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bgAlphaAnim", "Landroid/animation/ValueAnimator;", "countDownTv", "Landroid/widget/TextView;", "getCountDownTv", "()Landroid/widget/TextView;", "setCountDownTv", "(Landroid/widget/TextView;)V", "getRoot", "()Landroid/view/ViewGroup;", "setRoot", "tipsTv", "getTipsTv", "setTipsTv", "widgetRoot", "Landroid/view/View;", "getWidgetRoot", "()Landroid/view/View;", "setWidgetRoot", "(Landroid/view/View;)V", "checkWarnningState", "", "freeTomeToWatch", "", "hide", "show", "countDown", "tips", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
{
  private TextView DMt;
  View Esf;
  private ValueAnimator Ewn;
  private final String TAG;
  private ViewGroup mJe;
  private TextView njJ;
  
  public bm(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(361274);
    this.mJe = paramViewGroup;
    this.TAG = "FinderLiveWarnningCountWidget";
    AppMethodBeat.o(361274);
  }
  
  private static final void a(bm parambm, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(361294);
    s.u(parambm, "this$0");
    parambm = parambm.Esf;
    if (parambm == null) {
      parambm = null;
    }
    while (parambm != null)
    {
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        parambm = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(361294);
        throw parambm;
        parambm = parambm.getBackground();
      }
      else
      {
        parambm.setAlpha((int)(((Float)paramValueAnimator).floatValue() * 255.0F));
      }
    }
    AppMethodBeat.o(361294);
  }
  
  private void by(int paramInt, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(361284);
    s.u(paramString, "tips");
    if (this.Esf == null)
    {
      this.Esf = LayoutInflater.from(this.mJe.getContext()).inflate(p.f.Cgg, this.mJe, false);
      localObject1 = this.Esf;
      if (localObject1 != null) {
        break label355;
      }
      localObject1 = null;
      this.njJ = ((TextView)localObject1);
      localObject1 = this.Esf;
      if (localObject1 != null) {
        break label371;
      }
      localObject1 = null;
      label80:
      this.DMt = ((TextView)localObject1);
      localObject1 = this.Esf;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(-16777216);
      }
      if (this.mJe.indexOfChild(this.Esf) == -1) {
        this.mJe.addView(this.Esf);
      }
    }
    Object localObject1 = this.Esf;
    int i;
    label151:
    Object localObject3;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = this.Ewn;
        if (localObject1 != null) {
          ((ValueAnimator)localObject1).cancel();
        }
        localObject1 = ObjectAnimator.ofFloat(new float[] { 0.0F, 0.6F });
        ((ValueAnimator)localObject1).setDuration(paramInt * 1000);
        ((ValueAnimator)localObject1).addUpdateListener(new bm..ExternalSyntheticLambda0(this));
        ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new a(this));
        localObject3 = ah.aiuX;
        this.Ewn = ((ValueAnimator)localObject1);
        localObject1 = this.Ewn;
        if (localObject1 != null) {
          ((ValueAnimator)localObject1).start();
        }
        localObject3 = this.TAG;
        localObject1 = this.Ewn;
        if (localObject1 != null) {
          break label392;
        }
      }
    }
    label392:
    for (localObject1 = localObject2;; localObject1 = Long.valueOf(((ValueAnimator)localObject1).getDuration()))
    {
      Log.i((String)localObject3, s.X("start alpha anim:duration$", localObject1));
      localObject1 = this.Esf;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.njJ;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)String.valueOf(paramInt));
      }
      localObject1 = this.DMt;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(361284);
      return;
      label355:
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCx);
      break;
      label371:
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.Cai);
      break label80;
      i = 0;
      break label151;
    }
  }
  
  public final void Qr(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(361308);
    int i = j;
    if (paramInt > 0)
    {
      i = j;
      if (paramInt <= 3) {
        i = 1;
      }
    }
    if (i != 0)
    {
      String str = MMApplicationContext.getContext().getString(p.h.CiY);
      s.s(str, "getContext().getString(R…_free_time_warnning_tips)");
      by(paramInt, str);
      AppMethodBeat.o(361308);
      return;
    }
    hide();
    AppMethodBeat.o(361308);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(361313);
    Object localObject = this.Esf;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.Ewn;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    AppMethodBeat.o(361313);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveWarnningCountWidget$show$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(bm parambm) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(361181);
      paramAnimator = this.Ewo.Esf;
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = paramAnimator.getBackground())
      {
        if (paramAnimator != null) {
          paramAnimator.setAlpha(0);
        }
        AppMethodBeat.o(361181);
        return;
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361187);
      paramAnimator = this.Ewo.Esf;
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = paramAnimator.getBackground())
      {
        if (paramAnimator != null) {
          paramAnimator.setAlpha(0);
        }
        AppMethodBeat.o(361187);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bm
 * JD-Core Version:    0.7.0.1
 */