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
  TextView qA;
  int qB;
  Typeface qC;
  final TextInputLayout qk;
  private LinearLayout ql;
  private int qm;
  private FrameLayout qn;
  private int qo;
  Animator qp;
  private final float qr;
  int qs;
  int qt;
  CharSequence qu;
  boolean qv;
  TextView qw;
  int qx;
  CharSequence qy;
  boolean qz;
  
  public j(TextInputLayout paramTextInputLayout)
  {
    this.context = paramTextInputLayout.getContext();
    this.qk = paramTextInputLayout;
    this.qr = this.context.getResources().getDimensionPixelSize(2131166135);
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
      return this.qw;
    }
    return this.qA;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.qr, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(a.eS);
    return paramTextView;
  }
  
  private static ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
      paramTextView.setDuration(167L);
      paramTextView.setInterpolator(a.eP);
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
    this.qs = paramInt2;
  }
  
  final void a(final int paramInt1, final int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.qp = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.qz, this.qA, 2, paramInt1, paramInt2);
      a(localArrayList, this.qv, this.qw, 1, paramInt1, paramInt2);
      b.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          j.this.qs = paramInt2;
          j.this.qp = null;
          if (this.qE != null)
          {
            this.qE.setVisibility(4);
            if ((paramInt1 == 1) && (j.this.qw != null)) {
              j.this.qw.setText(null);
            }
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (this.qG != null) {
            this.qG.setVisibility(0);
          }
        }
      });
      localAnimatorSet.start();
    }
    for (;;)
    {
      this.qk.cV();
      this.qk.d(paramBoolean, false);
      this.qk.de();
      return;
      i(paramInt1, paramInt2);
    }
  }
  
  final void a(TextView paramTextView, int paramInt)
  {
    if ((this.ql == null) && (this.qn == null))
    {
      this.ql = new LinearLayout(this.context);
      this.ql.setOrientation(0);
      this.qk.addView(this.ql, -1, -2);
      this.qn = new FrameLayout(this.context);
      this.ql.addView(this.qn, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.context);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.ql.addView(localSpace, localLayoutParams);
      if (this.qk.getEditText() != null) {
        cy();
      }
    }
    if (Y(paramInt))
    {
      this.qn.setVisibility(0);
      this.qn.addView(paramTextView);
      this.qo += 1;
    }
    for (;;)
    {
      this.ql.setVisibility(0);
      this.qm += 1;
      return;
      this.ql.addView(paramTextView, paramInt);
    }
  }
  
  final boolean a(TextView paramTextView, CharSequence paramCharSequence)
  {
    return (t.ay(this.qk)) && (this.qk.isEnabled()) && ((this.qt != this.qs) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  final void ab(int paramInt)
  {
    this.qB = paramInt;
    if (this.qA != null) {
      q.d(this.qA, paramInt);
    }
  }
  
  final void b(TextView paramTextView, int paramInt)
  {
    if (this.ql == null) {
      return;
    }
    if ((Y(paramInt)) && (this.qn != null))
    {
      this.qo -= 1;
      b(this.qn, this.qo);
      this.qn.removeView(paramTextView);
    }
    for (;;)
    {
      this.qm -= 1;
      b(this.ql, this.qm);
      return;
      this.ql.removeView(paramTextView);
    }
  }
  
  final int cA()
  {
    if (this.qw != null) {
      return this.qw.getCurrentTextColor();
    }
    return -1;
  }
  
  final ColorStateList cB()
  {
    if (this.qw != null) {
      return this.qw.getTextColors();
    }
    return null;
  }
  
  final void cw()
  {
    this.qu = null;
    cx();
    if (this.qs == 1) {
      if ((!this.qz) || (TextUtils.isEmpty(this.qy))) {
        break label61;
      }
    }
    label61:
    for (this.qt = 2;; this.qt = 0)
    {
      a(this.qs, this.qt, a(this.qw, null));
      return;
    }
  }
  
  final void cx()
  {
    if (this.qp != null) {
      this.qp.cancel();
    }
  }
  
  final void cy()
  {
    if ((this.ql != null) && (this.qk.getEditText() != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        t.d(this.ql, t.ab(this.qk.getEditText()), 0, t.ac(this.qk.getEditText()), 0);
      }
      return;
    }
  }
  
  final boolean cz()
  {
    return (this.qt == 1) && (this.qw != null) && (!TextUtils.isEmpty(this.qu));
  }
  
  final void setErrorTextAppearance(int paramInt)
  {
    this.qx = paramInt;
    if (this.qw != null) {
      this.qk.c(this.qw, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.j
 * JD-Core Version:    0.7.0.1
 */