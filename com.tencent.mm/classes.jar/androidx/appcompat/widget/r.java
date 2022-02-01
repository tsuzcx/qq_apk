package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class r
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private int mActivePointerId;
  final View tA;
  private Runnable tB;
  private Runnable tC;
  private boolean tD;
  private final int[] tE = new int[2];
  private final float tx;
  private final int ty;
  private final int tz;
  
  public r(View paramView)
  {
    this.tA = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.tx = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.ty = ViewConfiguration.getTapTimeout();
    this.tz = ((this.ty + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void eH()
  {
    if (this.tC != null) {
      this.tA.removeCallbacks(this.tC);
    }
    if (this.tB != null) {
      this.tA.removeCallbacks(this.tB);
    }
  }
  
  public abstract s cJ();
  
  protected boolean cK()
  {
    s locals = cJ();
    if ((locals != null) && (!locals.isShowing())) {
      locals.show();
    }
    return true;
  }
  
  protected boolean dK()
  {
    s locals = cJ();
    if ((locals != null) && (locals.isShowing())) {
      locals.dismiss();
    }
    return true;
  }
  
  final void eI()
  {
    eH();
    View localView = this.tA;
    if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
    while (!cK()) {
      return;
    }
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.tD = true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.tD;
    int i;
    if (bool3)
    {
      paramView = this.tA;
      Object localObject = cJ();
      if ((localObject == null) || (!((s)localObject).isShowing()))
      {
        i = 0;
        if ((i == 0) && (dK())) {
          break label241;
        }
      }
      label235:
      label241:
      for (bool1 = true;; bool1 = false)
      {
        this.tD = bool1;
        if (!bool1)
        {
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        localObject = (p)((s)localObject).getListView();
        if ((localObject == null) || (!((p)localObject).isShown()))
        {
          i = 0;
          break;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        int[] arrayOfInt = this.tE;
        paramView.getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        paramView = this.tE;
        ((View)localObject).getLocationOnScreen(paramView);
        localMotionEvent.offsetLocation(-paramView[0], -paramView[1]);
        bool1 = ((p)localObject).a(localMotionEvent, this.mActivePointerId);
        localMotionEvent.recycle();
        i = paramMotionEvent.getActionMasked();
        if ((i != 1) && (i != 3)) {}
        for (i = 1;; i = 0)
        {
          if ((!bool1) || (i == 0)) {
            break label235;
          }
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    paramView = this.tA;
    if (paramView.isEnabled()) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      label292:
      i = 0;
      label295:
      if ((i == 0) || (!cK())) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.tA.onTouchEvent(paramView);
        paramView.recycle();
      }
      break;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (this.tB == null) {
        this.tB = new a();
      }
      paramView.postDelayed(this.tB, this.ty);
      if (this.tC == null) {
        this.tC = new b();
      }
      paramView.postDelayed(this.tC, this.tz);
      break label292;
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i < 0) {
        break label292;
      }
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3 = this.tx;
      if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
      for (i = 1; i == 0; i = 0)
      {
        eH();
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        i = 1;
        break label295;
      }
      eH();
      break label292;
    }
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.tD = false;
    this.mActivePointerId = -1;
    if (this.tB != null) {
      this.tA.removeCallbacks(this.tB);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(199394);
      ViewParent localViewParent = r.this.tA.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
      AppMethodBeat.o(199394);
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(199381);
      r.this.eI();
      AppMethodBeat.o(199381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.r
 * JD-Core Version:    0.7.0.1
 */