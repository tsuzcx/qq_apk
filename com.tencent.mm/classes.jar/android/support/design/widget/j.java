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
  TextView pA;
  int pB;
  Typeface pC;
  final TextInputLayout pl;
  private LinearLayout pm;
  private int pn;
  private FrameLayout po;
  private int pp;
  Animator pq;
  private final float pr;
  int ps;
  int pt;
  CharSequence pu;
  boolean pv;
  TextView pw;
  int px;
  CharSequence py;
  boolean pz;
  
  public j(TextInputLayout paramTextInputLayout)
  {
    this.context = paramTextInputLayout.getContext();
    this.pl = paramTextInputLayout;
    this.pr = this.context.getResources().getDimensionPixelSize(2131166135);
  }
  
  private static boolean Y(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private TextView Z(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.pw;
    }
    return this.pA;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.pr, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.dS);
    return paramTextView;
  }
  
  private static ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      paramTextView.setDuration(167L);
      paramTextView.setInterpolator(a.dP);
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
  
  private void i(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = Z(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = Z(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.ps = paramInt2;
  }
  
  final void a(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.pq = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.pz, this.pA, 2, paramInt1, paramInt2);
      a(localArrayList, this.pv, this.pw, 1, paramInt1, paramInt2);
      b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          j.this.ps = paramInt2;
          j.this.pq = null;
          if (this.pE != null)
          {
            this.pE.setVisibility(4);
            if ((paramInt1 == 1) && (j.this.pw != null)) {
              j.this.pw.setText(null);
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (this.pG != null) {
            this.pG.setVisibility(0);
          }
        }
      });
      localAnimatorSet.start();
    }
    for (;;)
    {
      this.pl.cO();
      this.pl.d(paramBoolean, false);
      this.pl.cX();
      return;
      i(paramInt1, paramInt2);
    }
  }
  
  final void a(TextView paramTextView, int paramInt)
  {
    if ((this.pm == null) && (this.po == null))
    {
      this.pm = new LinearLayout(this.context);
      this.pm.setOrientation(0);
      this.pl.addView(this.pm, -1, -2);
      this.po = new FrameLayout(this.context);
      this.pm.addView(this.po, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.pm.addView(localSpace, localLayoutParams);
      if (this.pl.getEditText() != null) {
        cr();
      }
    }
    if (Y(paramInt))
    {
      this.po.setVisibility(0);
      this.po.addView(paramTextView);
      this.pp += 1;
    }
    for (;;)
    {
      this.pm.setVisibility(0);
      this.pn += 1;
      return;
      this.pm.addView(paramTextView, paramInt);
    }
  }
  
  final boolean a(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (t.ay(this.pl)) && (this.pl.isEnabled()) && ((this.pt != this.ps) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  final void ab(int paramInt)
  {
    this.pB = paramInt;
    if (this.pA != null) {
      q.d(this.pA, paramInt);
    }
  }
  
  final void b(TextView paramTextView, int paramInt)
  {
    if (this.pm == null) {
      return;
    }
    if ((Y(paramInt)) && (this.po != null))
    {
      this.pp -= 1;
      b(this.po, this.pp);
      this.po.removeView(paramTextView);
    }
    for (;;)
    {
      this.pn -= 1;
      b(this.pm, this.pn);
      return;
      this.pm.removeView(paramTextView);
    }
  }
  
  final void cp()
  {
    this.pu = null;
    cq();
    if (this.ps == 1) {
      if ((!this.pz) || (TextUtils.isEmpty(this.py))) {
        break label61;
      }
    }
    label61:
    for (this.pt = 2;; this.pt = 0)
    {
      a(this.ps, this.pt, a(this.pw, null));
      return;
    }
  }
  
  final void cq()
  {
    if (this.pq != null) {
      this.pq.cancel();
    }
  }
  
  final void cr()
  {
    if ((this.pm != null) && (this.pl.getEditText() != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        t.d(this.pm, t.ab(this.pl.getEditText()), 0, t.ac(this.pl.getEditText()), 0);
      }
      return;
    }
  }
  
  final boolean cs()
  {
    return (this.pt == 1) && (this.pw != null) && (!TextUtils.isEmpty(this.pu));
  }
  
  final int ct()
  {
    if (this.pw != null) {
      return this.pw.getCurrentTextColor();
    }
    return -1;
  }
  
  final ColorStateList cu()
  {
    if (this.pw != null) {
      return this.pw.getTextColors();
    }
    return null;
  }
  
  final void setErrorTextAppearance(int paramInt)
  {
    this.px = paramInt;
    if (this.pw != null) {
      this.pl.c(this.pw, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.j
 * JD-Core Version:    0.7.0.1
 */