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
  private static bc apu;
  private static bc apv;
  private final CharSequence UQ;
  private final View apm;
  private final int apn;
  private final Runnable apo = new Runnable()
  {
    public final void run()
    {
      bc.this.aw(false);
    }
  };
  private int apq;
  private int apr;
  private bd aps;
  private boolean apt;
  private final Runnable mHideRunnable = new Runnable()
  {
    public final void run()
    {
      bc.this.hide();
    }
  };
  
  private bc(View paramView, CharSequence paramCharSequence)
  {
    this.apm = paramView;
    this.UQ = paramCharSequence;
    this.apn = u.b(ViewConfiguration.get(this.apm.getContext()));
    kY();
    this.apm.setOnLongClickListener(this);
    this.apm.setOnHoverListener(this);
  }
  
  private static void a(bc parambc)
  {
    if (apu != null) {
      apu.kX();
    }
    apu = parambc;
    if (parambc != null) {
      apu.kW();
    }
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if ((apu != null) && (apu.apm == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((apv != null) && (apv.apm == paramView)) {
        apv.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new bc(paramView, paramCharSequence);
  }
  
  private void kW()
  {
    this.apm.postDelayed(this.apo, ViewConfiguration.getLongPressTimeout());
  }
  
  private void kX()
  {
    this.apm.removeCallbacks(this.apo);
  }
  
  private void kY()
  {
    this.apq = 2147483647;
    this.apr = 2147483647;
  }
  
  final void aw(boolean paramBoolean)
  {
    if (!t.aw(this.apm)) {
      return;
    }
    a(null);
    if (apv != null) {
      apv.hide();
    }
    apv = this;
    this.apt = paramBoolean;
    this.aps = new bd(this.apm.getContext());
    this.aps.a(this.apm, this.apq, this.apr, this.apt, this.UQ);
    this.apm.addOnAttachStateChangeListener(this);
    long l;
    if (this.apt) {
      l = 2500L;
    }
    for (;;)
    {
      this.apm.removeCallbacks(this.mHideRunnable);
      this.apm.postDelayed(this.mHideRunnable, l);
      return;
      if ((t.aj(this.apm) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    if (apv == this)
    {
      apv = null;
      if (this.aps != null)
      {
        this.aps.hide();
        this.aps = null;
        kY();
        this.apm.removeOnAttachStateChangeListener(this);
      }
    }
    if (apu == this) {
      a(null);
    }
    this.apm.removeCallbacks(this.mHideRunnable);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.aps != null) && (this.apt)) {}
    do
    {
      do
      {
        return false;
        paramView = (AccessibilityManager)this.apm.getContext().getSystemService("accessibility");
      } while ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()));
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      case 9: 
      default: 
        return false;
      }
    } while ((!this.apm.isEnabled()) || (this.aps != null));
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.apq) <= this.apn) && (Math.abs(j - this.apr) <= this.apn)) {}
    for (i = 0; i != 0; i = 1)
    {
      a(this);
      return false;
      this.apq = i;
      this.apr = j;
    }
    kY();
    hide();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.apq = (paramView.getWidth() / 2);
    this.apr = (paramView.getHeight() / 2);
    aw(true);
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