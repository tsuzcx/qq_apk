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
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.ffc;

public final class f$21
  implements AppBrandGameEvaluateOptionView.a
{
  public f$21(f paramf, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, LinearLayout paramLinearLayout, q paramq, Runnable paramRunnable, ffc paramffc) {}
  
  public final void a(cxp paramcxp)
  {
    AppMethodBeat.i(49885);
    this.JRP.setVisibility(4);
    this.JRQ.setVisibility(8);
    this.JRR.setVisibility(4);
    this.JRS.findViewById(2131305652).setVisibility(8);
    f localf = this.oqB;
    q localq = this.kzl;
    Object localObject1 = this.JRS;
    Runnable localRunnable = this.oqD;
    ffc localffc = this.Iae;
    if (!localf.Iad)
    {
      Object localObject2 = (ImageView)((LinearLayout)localObject1).findViewById(2131309046);
      ((ImageView)localObject2).setAlpha(0.0F);
      ((ImageView)localObject2).setScaleX(0.4807692F);
      ((ImageView)localObject2).setScaleY(0.4807692F);
      ((ImageView)localObject2).setRotation(24.0F);
      ((ImageView)localObject2).setVisibility(0);
      Object localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131309047);
      ((TextView)localObject3).setText(localffc.NAw);
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
      localf.a(localq, false, paramcxp, localffc);
    }
    AppMethodBeat.o(49885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.21
 * JD-Core Version:    0.7.0.1
 */