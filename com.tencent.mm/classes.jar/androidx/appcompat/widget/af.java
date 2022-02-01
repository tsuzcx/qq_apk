package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.g.w;
import androidx.core.g.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class af
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static af xI;
  private static af xJ;
  private final CharSequence kY;
  private final Runnable mHideRunnable;
  private final View xB;
  private final int xC;
  private final Runnable xD;
  private int xE;
  private int xF;
  private ag xG;
  private boolean xH;
  
  private af(View paramView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242456);
    this.xD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242442);
        af.this.T(false);
        AppMethodBeat.o(242442);
      }
    };
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242450);
        af.this.hide();
        AppMethodBeat.o(242450);
      }
    };
    this.xB = paramView;
    this.kY = paramCharSequence;
    this.xC = x.b(ViewConfiguration.get(this.xB.getContext()));
    eG();
    this.xB.setOnLongClickListener(this);
    this.xB.setOnHoverListener(this);
    AppMethodBeat.o(242456);
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(242454);
    if ((xI != null) && (xI.xB == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((xJ != null) && (xJ.xB == paramView)) {
        xJ.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      AppMethodBeat.o(242454);
      return;
    }
    new af(paramView, paramCharSequence);
    AppMethodBeat.o(242454);
  }
  
  private static void a(af paramaf)
  {
    AppMethodBeat.i(242469);
    if (xI != null) {
      xI.eF();
    }
    xI = paramaf;
    if (paramaf != null) {
      xI.eE();
    }
    AppMethodBeat.o(242469);
  }
  
  private void eE()
  {
    AppMethodBeat.i(242470);
    this.xB.postDelayed(this.xD, ViewConfiguration.getLongPressTimeout());
    AppMethodBeat.o(242470);
  }
  
  private void eF()
  {
    AppMethodBeat.i(242471);
    this.xB.removeCallbacks(this.xD);
    AppMethodBeat.o(242471);
  }
  
  private void eG()
  {
    this.xE = 2147483647;
    this.xF = 2147483647;
  }
  
  final void T(boolean paramBoolean)
  {
    AppMethodBeat.i(242466);
    if (!w.al(this.xB))
    {
      AppMethodBeat.o(242466);
      return;
    }
    a(null);
    if (xJ != null) {
      xJ.hide();
    }
    xJ = this;
    this.xH = paramBoolean;
    this.xG = new ag(this.xB.getContext());
    this.xG.a(this.xB, this.xE, this.xF, this.xH, this.kY);
    this.xB.addOnAttachStateChangeListener(this);
    long l;
    if (this.xH) {
      l = 2500L;
    }
    for (;;)
    {
      this.xB.removeCallbacks(this.mHideRunnable);
      this.xB.postDelayed(this.mHideRunnable, l);
      AppMethodBeat.o(242466);
      return;
      if ((w.X(this.xB) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    AppMethodBeat.i(242468);
    if (xJ == this)
    {
      xJ = null;
      if (this.xG != null)
      {
        this.xG.hide();
        this.xG = null;
        eG();
        this.xB.removeOnAttachStateChangeListener(this);
      }
    }
    if (xI == this) {
      a(null);
    }
    this.xB.removeCallbacks(this.mHideRunnable);
    AppMethodBeat.o(242468);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(242460);
    if ((this.xG != null) && (this.xH))
    {
      AppMethodBeat.o(242460);
      return false;
    }
    paramView = (AccessibilityManager)this.xB.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()))
    {
      AppMethodBeat.o(242460);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(242460);
      return false;
      if ((this.xB.isEnabled()) && (this.xG == null))
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((Math.abs(i - this.xE) <= this.xC) && (Math.abs(j - this.xF) <= this.xC)) {}
        for (i = 0; i != 0; i = 1)
        {
          a(this);
          break;
          this.xE = i;
          this.xF = j;
        }
        eG();
        hide();
      }
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(242457);
    this.xE = (paramView.getWidth() / 2);
    this.xF = (paramView.getHeight() / 2);
    T(true);
    AppMethodBeat.o(242457);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(242462);
    hide();
    AppMethodBeat.o(242462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.af
 * JD-Core Version:    0.7.0.1
 */