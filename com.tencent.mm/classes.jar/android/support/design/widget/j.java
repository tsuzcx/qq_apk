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
import android.support.v4.view.t;
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
  final TextInputLayout sf;
  private LinearLayout sg;
  private int sh;
  private FrameLayout si;
  private int sj;
  Animator sk;
  private final float sl;
  int sm;
  int sn;
  CharSequence so;
  boolean sq;
  TextView sr;
  int ss;
  CharSequence st;
  boolean su;
  TextView sv;
  int sw;
  Typeface sx;
  
  public j(TextInputLayout paramTextInputLayout)
  {
    this.context = paramTextInputLayout.getContext();
    this.sf = paramTextInputLayout;
    this.sl = this.context.getResources().getDimensionPixelSize(2131166135);
  }
  
  private static boolean X(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private TextView Y(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.sr;
    }
    return this.sv;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.sl, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.gL);
    return paramTextView;
  }
  
  private static ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      paramTextView.setDuration(167L);
      paramTextView.setInterpolator(a.gI);
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
      localTextView = Y(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = Y(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.sm = paramInt2;
  }
  
  final void Z(int paramInt)
  {
    this.sw = paramInt;
    if (this.sv != null) {
      q.d(this.sv, paramInt);
    }
  }
  
  final void a(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.sk = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.su, this.sv, 2, paramInt1, paramInt2);
      a(localArrayList, this.sq, this.sr, 1, paramInt1, paramInt2);
      b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          j.this.sm = paramInt2;
          j.this.sk = null;
          if (this.sz != null)
          {
            this.sz.setVisibility(4);
            if ((paramInt1 == 1) && (j.this.sr != null)) {
              j.this.sr.setText(null);
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (this.sB != null) {
            this.sB.setVisibility(0);
          }
        }
      });
      localAnimatorSet.start();
    }
    for (;;)
    {
      this.sf.dk();
      this.sf.d(paramBoolean, false);
      this.sf.dt();
      return;
      p(paramInt1, paramInt2);
    }
  }
  
  final void a(TextView paramTextView, int paramInt)
  {
    if ((this.sg == null) && (this.si == null))
    {
      this.sg = new LinearLayout(this.context);
      this.sg.setOrientation(0);
      this.sf.addView(this.sg, -1, -2);
      this.si = new FrameLayout(this.context);
      this.sg.addView(this.si, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.sg.addView(localSpace, localLayoutParams);
      if (this.sf.getEditText() != null) {
        cO();
      }
    }
    if (X(paramInt))
    {
      this.si.setVisibility(0);
      this.si.addView(paramTextView);
      this.sj += 1;
    }
    for (;;)
    {
      this.sg.setVisibility(0);
      this.sh += 1;
      return;
      this.sg.addView(paramTextView, paramInt);
    }
  }
  
  final boolean a(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (t.ay(this.sf)) && (this.sf.isEnabled()) && ((this.sn != this.sm) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  final void b(TextView paramTextView, int paramInt)
  {
    if (this.sg == null) {
      return;
    }
    if ((X(paramInt)) && (this.si != null))
    {
      this.sj -= 1;
      b(this.si, this.sj);
      this.si.removeView(paramTextView);
    }
    for (;;)
    {
      this.sh -= 1;
      b(this.sg, this.sh);
      return;
      this.sg.removeView(paramTextView);
    }
  }
  
  final void cM()
  {
    this.so = null;
    cN();
    if (this.sm == 1) {
      if ((!this.su) || (TextUtils.isEmpty(this.st))) {
        break label61;
      }
    }
    label61:
    for (this.sn = 2;; this.sn = 0)
    {
      a(this.sm, this.sn, a(this.sr, null));
      return;
    }
  }
  
  final void cN()
  {
    if (this.sk != null) {
      this.sk.cancel();
    }
  }
  
  final void cO()
  {
    if ((this.sg != null) && (this.sf.getEditText() != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        t.d(this.sg, t.ab(this.sf.getEditText()), 0, t.ac(this.sf.getEditText()), 0);
      }
      return;
    }
  }
  
  final boolean cP()
  {
    return (this.sn == 1) && (this.sr != null) && (!TextUtils.isEmpty(this.so));
  }
  
  final int cQ()
  {
    if (this.sr != null) {
      return this.sr.getCurrentTextColor();
    }
    return -1;
  }
  
  final ColorStateList cR()
  {
    if (this.sr != null) {
      return this.sr.getTextColors();
    }
    return null;
  }
  
  final void setErrorTextAppearance(int paramInt)
  {
    this.ss = paramInt;
    if (this.sr != null) {
      this.sf.c(this.sr, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.j
 * JD-Core Version:    0.7.0.1
 */