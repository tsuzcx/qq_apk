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
  private static bc axQ;
  private static bc axR;
  private final CharSequence acM;
  private final View axJ;
  private final int axK;
  private final Runnable axL = new Runnable()
  {
    public final void run()
    {
      bc.this.aF(false);
    }
  };
  private int axM;
  private int axN;
  private bd axO;
  private boolean axP;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      bc.this.hide();
    }
  };
  
  private bc(View paramView, CharSequence paramCharSequence)
  {
    this.axJ = paramView;
    this.acM = paramCharSequence;
    this.axK = u.b(ViewConfiguration.get(this.axJ.getContext()));
    mP();
    this.axJ.setOnLongClickListener(this);
    this.axJ.setOnHoverListener(this);
  }
  
  private static void a(bc parambc)
  {
    if (axQ != null) {
      axQ.mO();
    }
    axQ = parambc;
    if (parambc != null) {
      axQ.mN();
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((axQ != null) && (axQ.axJ == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((axR != null) && (axR.axJ == paramView)) {
        axR.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new bc(paramView, paramCharSequence);
  }
  
  private void mN()
  {
    this.axJ.postDelayed(this.axL, ViewConfiguration.getLongPressTimeout());
  }
  
  private void mO()
  {
    this.axJ.removeCallbacks(this.axL);
  }
  
  private void mP()
  {
    this.axM = 2147483647;
    this.axN = 2147483647;
  }
  
  final void aF(boolean paramBoolean)
  {
    if (!t.aC(this.axJ)) {
      return;
    }
    a(null);
    if (axR != null) {
      axR.hide();
    }
    axR = this;
    this.axP = paramBoolean;
    this.axO = new bd(this.axJ.getContext());
    this.axO.a(this.axJ, this.axM, this.axN, this.axP, this.acM);
    this.axJ.addOnAttachStateChangeListener(this);
    long l;
    if (this.axP) {
      l = 2500L;
    }
    for (;;)
    {
      this.axJ.removeCallbacks(this.mHideRunnable);
      this.axJ.postDelayed(this.mHideRunnable, l);
      return;
      if ((t.ao(this.axJ) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    if (axR == this)
    {
      axR = null;
      if (this.axO != null)
      {
        this.axO.hide();
        this.axO = null;
        mP();
        this.axJ.removeOnAttachStateChangeListener(this);
      }
    }
    if (axQ == this) {
      a(null);
    }
    this.axJ.removeCallbacks(this.mHideRunnable);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.axO != null) && (this.axP)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.axJ.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.axJ.isEnabled()) || (this.axO != null));
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.axM) <= this.axK) && (Math.abs(j - this.axN) <= this.axK)) {}
    for (i = 0; i != 0; i = 1)
    {
      a(this);
      return false;
      this.axM = i;
      this.axN = j;
    }
    mP();
    hide();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.axM = (paramView.getWidth() / 2);
    this.axN = (paramView.getHeight() / 2);
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