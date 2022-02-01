package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.ekj;

public final class f$21
  implements AppBrandGameEvaluateOptionView.a
{
  public f$21(f paramf, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, LinearLayout paramLinearLayout, p paramp, Runnable paramRunnable, ekj paramekj) {}
  
  public final void a(chi paramchi)
  {
    AppMethodBeat.i(49885);
    this.nhe.setVisibility(4);
    this.nhf.setVisibility(8);
    this.nhg.setVisibility(4);
    this.nhj.findViewById(2131303046).setVisibility(8);
    f localf = this.ngO;
    p localp = this.jyD;
    Object localObject1 = this.nhj;
    Runnable localRunnable = this.ngQ;
    ekj localekj = this.nhd;
    if (!localf.nhc)
    {
      Object localObject2 = (ImageView)((LinearLayout)localObject1).findViewById(2131305771);
      ((ImageView)localObject2).setAlpha(0.0F);
      ((ImageView)localObject2).setScaleX(0.4807692F);
      ((ImageView)localObject2).setScaleY(0.4807692F);
      ((ImageView)localObject2).setRotation(24.0F);
      ((ImageView)localObject2).setVisibility(0);
      Object localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131305772);
      ((TextView)localObject3).setText(localekj.Inu);
      ((TextView)localObject3).setAlpha(0.0F);
      ((TextView)localObject3).setVisibility(0);
      localObject1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject1).setDuration(300L);
      ((ValueAnimator)localObject1).addUpdateListener(new f.10(localf, (ImageView)localObject2, (TextView)localObject3));
      localObject3 = ValueAnimator.ofFloat(new float[] { 0.4807692F, 1.0F });
      ((ValueAnimator)localObject3).setDuration(300L);
      ((ValueAnimator)localObject3).addUpdateListener(new f.11(localf, (ImageView)localObject2));
      localObject2 = ObjectAnimator.ofFloat(localObject2, "rotation", new float[] { 24.0F, 0.0F });
      ((ObjectAnimator)localObject2).setDuration(1300L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject1, localObject3, localObject2 });
      localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      localAnimatorSet.addListener(new f.13(localf, localRunnable));
      localAnimatorSet.start();
      localf.a(localp, false, paramchi, localekj);
    }
    AppMethodBeat.o(49885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.21
 * JD-Core Version:    0.7.0.1
 */