package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.design.a.a;
import android.support.design.a.b;
import android.support.v4.view.u;
import android.support.v4.widget.Space;
import android.support.v4.widget.q;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class j
{
  final Context context;
  int sA;
  Typeface sB;
  final TextInputLayout si;
  private LinearLayout sj;
  private int sk;
  private FrameLayout sl;
  private int sm;
  Animator sn;
  private final float so;
  int sq;
  int sr;
  CharSequence ss;
  boolean st;
  TextView su;
  int sv;
  CharSequence sx;
  boolean sy;
  TextView sz;
  
  public j(TextInputLayout paramTextInputLayout)
  {
    this.context = paramTextInputLayout.getContext();
    this.si = paramTextInputLayout;
    this.so = this.context.getResources().getDimensionPixelSize(2131166176);
  }
  
  private static boolean W(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private TextView X(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.su;
    }
    return this.sz;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.so, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.gN);
    return paramTextView;
  }
  
  private static ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      paramTextView.setDuration(167L);
      paramTextView.setInterpolator(a.gK);
      return paramTextView;
    }
  }
  
  static void a(TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
  }
  
  private void a(List<Animator> paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramTextView == null) || (!paramBoolean)) {
      break label8;
    }
    label8:
    while ((paramInt1 != paramInt3) && (paramInt1 != paramInt2)) {
      return;
    }
    if (paramInt3 == paramInt1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramList.add(a(paramTextView, paramBoolean));
      if (paramInt3 != paramInt1) {
        break;
      }
      paramList.add(a(paramTextView));
      return;
    }
  }
  
  private static void b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void p(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = X(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = X(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.sq = paramInt2;
  }
  
  final void Y(int paramInt)
  {
    this.sA = paramInt;
    if (this.sz != null) {
      q.d(this.sz, paramInt);
    }
  }
  
  final void a(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.sn = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.sy, this.sz, 2, paramInt1, paramInt2);
      a(localArrayList, this.st, this.su, 1, paramInt1, paramInt2);
      b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          j.this.sq = paramInt2;
          j.this.sn = null;
          if (this.sD != null)
          {
            this.sD.setVisibility(4);
            if ((paramInt1 == 1) && (j.this.su != null)) {
              j.this.su.setText(null);
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (this.sF != null) {
            this.sF.setVisibility(0);
          }
        }
      });
      localAnimatorSet.start();
    }
    for (;;)
    {
      this.si.dn();
      this.si.d(paramBoolean, false);
      this.si.dw();
      return;
      p(paramInt1, paramInt2);
    }
  }
  
  final void a(TextView paramTextView, int paramInt)
  {
    if ((this.sj == null) && (this.sl == null))
    {
      this.sj = new LinearLayout(this.context);
      this.sj.setOrientation(0);
      this.si.addView(this.sj, -1, -2);
      this.sl = new FrameLayout(this.context);
      this.sj.addView(this.sl, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.sj.addView(localSpace, localLayoutParams);
      if (this.si.getEditText() != null) {
        cQ();
      }
    }
    if (W(paramInt))
    {
      this.sl.setVisibility(0);
      this.sl.addView(paramTextView);
      this.sm += 1;
    }
    for (;;)
    {
      this.sj.setVisibility(0);
      this.sk += 1;
      return;
      this.sj.addView(paramTextView, paramInt);
    }
  }
  
  final boolean a(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (u.az(this.si)) && (this.si.isEnabled()) && ((this.sr != this.sq) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  final void b(TextView paramTextView, int paramInt)
  {
    if (this.sj == null) {
      return;
    }
    if ((W(paramInt)) && (this.sl != null))
    {
      this.sm -= 1;
      b(this.sl, this.sm);
      this.sl.removeView(paramTextView);
    }
    for (;;)
    {
      this.sk -= 1;
      b(this.sj, this.sk);
      return;
      this.sj.removeView(paramTextView);
    }
  }
  
  final void cO()
  {
    this.ss = null;
    cP();
    if (this.sq == 1) {
      if ((!this.sy) || (TextUtils.isEmpty(this.sx))) {
        break label61;
      }
    }
    label61:
    for (this.sr = 2;; this.sr = 0)
    {
      a(this.sq, this.sr, a(this.su, null));
      return;
    }
  }
  
  final void cP()
  {
    if (this.sn != null) {
      this.sn.cancel();
    }
  }
  
  final void cQ()
  {
    if ((this.sj != null) && (this.si.getEditText() != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        u.d(this.sj, u.ac(this.si.getEditText()), 0, u.ad(this.si.getEditText()), 0);
      }
      return;
    }
  }
  
  final boolean cR()
  {
    return (this.sr == 1) && (this.su != null) && (!TextUtils.isEmpty(this.ss));
  }
  
  final int cS()
  {
    if (this.su != null) {
      return this.su.getCurrentTextColor();
    }
    return -1;
  }
  
  final ColorStateList cT()
  {
    if (this.su != null) {
      return this.su.getTextColors();
    }
    return null;
  }
  
  final void setErrorTextAppearance(int paramInt)
  {
    this.sv = paramInt;
    if (this.su != null) {
      this.si.c(this.su, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.j
 * JD-Core Version:    0.7.0.1
 */