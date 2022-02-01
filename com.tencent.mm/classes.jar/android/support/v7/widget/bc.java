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
  private static bc awW;
  private static bc awX;
  private final CharSequence abS;
  private final View awP;
  private final int awQ;
  private final Runnable awR = new Runnable()
  {
    public final void run()
    {
      bc.this.aF(false);
    }
  };
  private int awS;
  private int awT;
  private bd awU;
  private boolean awV;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      bc.this.hide();
    }
  };
  
  private bc(View paramView, CharSequence paramCharSequence)
  {
    this.awP = paramView;
    this.abS = paramCharSequence;
    this.awQ = u.b(ViewConfiguration.get(this.awP.getContext()));
    mF();
    this.awP.setOnLongClickListener(this);
    this.awP.setOnHoverListener(this);
  }
  
  private static void a(bc parambc)
  {
    if (awW != null) {
      awW.mE();
    }
    awW = parambc;
    if (parambc != null) {
      awW.mD();
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((awW != null) && (awW.awP == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((awX != null) && (awX.awP == paramView)) {
        awX.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new bc(paramView, paramCharSequence);
  }
  
  private void mD()
  {
    this.awP.postDelayed(this.awR, ViewConfiguration.getLongPressTimeout());
  }
  
  private void mE()
  {
    this.awP.removeCallbacks(this.awR);
  }
  
  private void mF()
  {
    this.awS = 2147483647;
    this.awT = 2147483647;
  }
  
  final void aF(boolean paramBoolean)
  {
    if (!t.aC(this.awP)) {
      return;
    }
    a(null);
    if (awX != null) {
      awX.hide();
    }
    awX = this;
    this.awV = paramBoolean;
    this.awU = new bd(this.awP.getContext());
    this.awU.a(this.awP, this.awS, this.awT, this.awV, this.abS);
    this.awP.addOnAttachStateChangeListener(this);
    long l;
    if (this.awV) {
      l = 2500L;
    }
    for (;;)
    {
      this.awP.removeCallbacks(this.mHideRunnable);
      this.awP.postDelayed(this.mHideRunnable, l);
      return;
      if ((t.ao(this.awP) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    if (awX == this)
    {
      awX = null;
      if (this.awU != null)
      {
        this.awU.hide();
        this.awU = null;
        mF();
        this.awP.removeOnAttachStateChangeListener(this);
      }
    }
    if (awW == this) {
      a(null);
    }
    this.awP.removeCallbacks(this.mHideRunnable);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.awU != null) && (this.awV)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.awP.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.awP.isEnabled()) || (this.awU != null));
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.awS) <= this.awQ) && (Math.abs(j - this.awT) <= this.awQ)) {}
    for (i = 0; i != 0; i = 1)
    {
      a(this);
      return false;
      this.awS = i;
      this.awT = j;
    }
    mF();
    hide();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.awS = (paramView.getWidth() / 2);
    this.awT = (paramView.getHeight() / 2);
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