package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.t;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

final class bc
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static bc azH;
  private static bc azI;
  private final CharSequence aeD;
  private final View azA;
  private final int azB;
  private final Runnable azC = new Runnable()
  {
    public final void run()
    {
      bc.this.aF(false);
    }
  };
  private int azD;
  private int azE;
  private bd azF;
  private boolean azG;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      bc.this.hide();
    }
  };
  
  private bc(View paramView, CharSequence paramCharSequence)
  {
    this.azA = paramView;
    this.aeD = paramCharSequence;
    this.azB = u.b(ViewConfiguration.get(this.azA.getContext()));
    nh();
    this.azA.setOnLongClickListener(this);
    this.azA.setOnHoverListener(this);
  }
  
  private static void a(bc parambc)
  {
    if (azH != null) {
      azH.ng();
    }
    azH = parambc;
    if (parambc != null) {
      azH.nf();
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((azH != null) && (azH.azA == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((azI != null) && (azI.azA == paramView)) {
        azI.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new bc(paramView, paramCharSequence);
  }
  
  private void nf()
  {
    this.azA.postDelayed(this.azC, ViewConfiguration.getLongPressTimeout());
  }
  
  private void ng()
  {
    this.azA.removeCallbacks(this.azC);
  }
  
  private void nh()
  {
    this.azD = 2147483647;
    this.azE = 2147483647;
  }
  
  final void aF(boolean paramBoolean)
  {
    if (!t.aC(this.azA)) {
      return;
    }
    a(null);
    if (azI != null) {
      azI.hide();
    }
    azI = this;
    this.azG = paramBoolean;
    this.azF = new bd(this.azA.getContext());
    this.azF.a(this.azA, this.azD, this.azE, this.azG, this.aeD);
    this.azA.addOnAttachStateChangeListener(this);
    long l;
    if (this.azG) {
      l = 2500L;
    }
    for (;;)
    {
      this.azA.removeCallbacks(this.mHideRunnable);
      this.azA.postDelayed(this.mHideRunnable, l);
      return;
      if ((t.ao(this.azA) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    if (azI == this)
    {
      azI = null;
      if (this.azF != null)
      {
        this.azF.hide();
        this.azF = null;
        nh();
        this.azA.removeOnAttachStateChangeListener(this);
      }
    }
    if (azH == this) {
      a(null);
    }
    this.azA.removeCallbacks(this.mHideRunnable);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.azF != null) && (this.azG)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.azA.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.azA.isEnabled()) || (this.azF != null));
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.azD) <= this.azB) && (Math.abs(j - this.azE) <= this.azB)) {}
    for (i = 0; i != 0; i = 1)
    {
      a(this);
      return false;
      this.azD = i;
      this.azE = j;
    }
    nh();
    hide();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.azD = (paramView.getWidth() / 2);
    this.azE = (paramView.getHeight() / 2);
    aF(true);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bc
 * JD-Core Version:    0.7.0.1
 */