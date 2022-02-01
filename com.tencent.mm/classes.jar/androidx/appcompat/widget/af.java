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
import androidx.core.g.aa;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class af
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static af yD;
  private static af yE;
  private final CharSequence lU;
  private final Runnable mHideRunnable;
  private int yA;
  private ag yB;
  private boolean yC;
  private final View yw;
  private final int yx;
  private final Runnable yy;
  private int yz;
  
  private af(View paramView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199592);
    this.yy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199413);
        af.this.W(false);
        AppMethodBeat.o(199413);
      }
    };
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199424);
        af.this.hide();
        AppMethodBeat.o(199424);
      }
    };
    this.yw = paramView;
    this.lU = paramCharSequence;
    this.yx = aa.b(ViewConfiguration.get(this.yw.getContext()));
    fD();
    this.yw.setOnLongClickListener(this);
    this.yw.setOnHoverListener(this);
    AppMethodBeat.o(199592);
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199580);
    if ((yD != null) && (yD.yw == paramView)) {
      a(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((yE != null) && (yE.yw == paramView)) {
        yE.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      AppMethodBeat.o(199580);
      return;
    }
    new af(paramView, paramCharSequence);
    AppMethodBeat.o(199580);
  }
  
  private static void a(af paramaf)
  {
    AppMethodBeat.i(199602);
    if (yD != null) {
      yD.fC();
    }
    yD = paramaf;
    if (paramaf != null) {
      yD.fB();
    }
    AppMethodBeat.o(199602);
  }
  
  private void fB()
  {
    AppMethodBeat.i(199614);
    this.yw.postDelayed(this.yy, ViewConfiguration.getLongPressTimeout());
    AppMethodBeat.o(199614);
  }
  
  private void fC()
  {
    AppMethodBeat.i(199624);
    this.yw.removeCallbacks(this.yy);
    AppMethodBeat.o(199624);
  }
  
  private void fD()
  {
    this.yz = 2147483647;
    this.yA = 2147483647;
  }
  
  final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(199689);
    if (!z.ay(this.yw))
    {
      AppMethodBeat.o(199689);
      return;
    }
    a(null);
    if (yE != null) {
      yE.hide();
    }
    yE = this;
    this.yC = paramBoolean;
    this.yB = new ag(this.yw.getContext());
    this.yB.a(this.yw, this.yz, this.yA, this.yC, this.lU);
    this.yw.addOnAttachStateChangeListener(this);
    long l;
    if (this.yC) {
      l = 2500L;
    }
    for (;;)
    {
      this.yw.removeCallbacks(this.mHideRunnable);
      this.yw.postDelayed(this.mHideRunnable, l);
      AppMethodBeat.o(199689);
      return;
      if ((z.aj(this.yw) & 0x1) == 1) {
        l = 3000L - ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L - ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  final void hide()
  {
    AppMethodBeat.i(199698);
    if (yE == this)
    {
      yE = null;
      if (this.yB != null)
      {
        this.yB.hide();
        this.yB = null;
        fD();
        this.yw.removeOnAttachStateChangeListener(this);
      }
    }
    if (yD == this) {
      a(null);
    }
    this.yw.removeCallbacks(this.mHideRunnable);
    AppMethodBeat.o(199698);
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199658);
    if ((this.yB != null) && (this.yC))
    {
      AppMethodBeat.o(199658);
      return false;
    }
    paramView = (AccessibilityManager)this.yw.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled()))
    {
      AppMethodBeat.o(199658);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199658);
      return false;
      if ((this.yw.isEnabled()) && (this.yB == null))
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((Math.abs(i - this.yz) <= this.yx) && (Math.abs(j - this.yA) <= this.yx)) {}
        for (i = 0; i != 0; i = 1)
        {
          a(this);
          break;
          this.yz = i;
          this.yA = j;
        }
        fD();
        hide();
      }
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(199644);
    this.yz = (paramView.getWidth() / 2);
    this.yA = (paramView.getHeight() / 2);
    W(true);
    AppMethodBeat.o(199644);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(199677);
    hide();
    AppMethodBeat.o(199677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.af
 * JD-Core Version:    0.7.0.1
 */