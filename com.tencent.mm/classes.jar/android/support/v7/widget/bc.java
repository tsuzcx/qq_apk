package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.u;
import android.support.v4.view.v;
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
  private static bc azF;
  private static bc azG;
  private final CharSequence aeQ;
  private final Runnable azA = new Runnable()
  {
    public final void run()
    {
      bc.this.aD(false);
    }
  };
  private int azB;
  private int azC;
  private bd azD;
  private boolean azE;
  private final View azy;
  private final int azz;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      bc.this.hide();
    }
  };
  
  private bc(View paramView, CharSequence paramCharSequence)
  {
    this.azy = paramView;
    this.aeQ = paramCharSequence;
    this.azz = v.b(ViewConfiguration.get(this.azy.getContext()));
    nj();
    this.azy.setOnLongClickListener(this);
    this.azy.setOnHoverListener(this);
  }
  
  private static void a(bc parambc)
  {
    if (azF != null) {
      azF.ni();
    }
    azF = parambc;
    if (parambc != null) {
      azF.nh();
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((azF != null) && (azF.azy == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((azG != null) && (azG.azy == paramView)) {
        azG.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new bc(paramView, paramCharSequence);
  }
  
  private void nh()
  {
    this.azy.postDelayed(this.azA, ViewConfiguration.getLongPressTimeout());
  }
  
  private void ni()
  {
    this.azy.removeCallbacks(this.azA);
  }
  
  private void nj()
  {
    this.azB = 2147483647;
    this.azC = 2147483647;
  }
  
  final void aD(boolean paramBoolean)
  {
    if (!u.aD(this.azy)) {
      return;
    }
    a(null);
    if (azG != null) {
      azG.hide();
    }
    azG = this;
    this.azE = paramBoolean;
    this.azD = new bd(this.azy.getContext());
    this.azD.a(this.azy, this.azB, this.azC, this.azE, this.aeQ);
    this.azy.addOnAttachStateChangeListener(this);
    long l;
    if (this.azE) {
      l = 2500L;
    }
    for (;;)
    {
      this.azy.removeCallbacks(this.mHideRunnable);
      this.azy.postDelayed(this.mHideRunnable, l);
      return;
      if ((u.ao(this.azy) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    if (azG == this)
    {
      azG = null;
      if (this.azD != null)
      {
        this.azD.hide();
        this.azD = null;
        nj();
        this.azy.removeOnAttachStateChangeListener(this);
      }
    }
    if (azF == this) {
      a(null);
    }
    this.azy.removeCallbacks(this.mHideRunnable);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.azD != null) && (this.azE)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.azy.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.azy.isEnabled()) || (this.azD != null));
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.azB) <= this.azz) && (Math.abs(j - this.azC) <= this.azz)) {}
    for (i = 0; i != 0; i = 1)
    {
      a(this);
      return false;
      this.azB = i;
      this.azC = j;
    }
    nj();
    hide();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.azB = (paramView.getWidth() / 2);
    this.azC = (paramView.getHeight() / 2);
    aD(true);
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