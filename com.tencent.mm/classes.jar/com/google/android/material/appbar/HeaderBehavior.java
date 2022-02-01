package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.b.a;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private Runnable bvC;
  OverScroller bvD;
  private boolean bvE;
  private int bvF = -1;
  private int bvG;
  private int bvH = -1;
  private VelocityTracker bvI;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void wd()
  {
    if (this.bvI == null) {
      this.bvI = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = vY();
    int j = 0;
    int i = j;
    if (paramInt2 != 0)
    {
      i = j;
      if (k >= paramInt2)
      {
        i = j;
        if (k <= paramInt3)
        {
          paramInt1 = a.clamp(paramInt1, paramInt2, paramInt3);
          i = j;
          if (k != paramInt1)
          {
            fT(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.bvH < 0) {
      this.bvH = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.bvE)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.bvI != null) {
        this.bvI.addMovement(paramMotionEvent);
      }
      return this.bvE;
      this.bvE = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((vW()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.bvG = j;
        this.bvF = paramMotionEvent.getPointerId(0);
        wd();
        continue;
        i = this.bvF;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.bvG) > this.bvH)
            {
              this.bvE = true;
              this.bvG = i;
              continue;
              this.bvE = false;
              this.bvF = -1;
              if (this.bvI != null)
              {
                this.bvI.recycle();
                this.bvI = null;
              }
            }
          }
        }
      }
    }
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, vV() - paramInt1, paramInt2, paramInt3);
  }
  
  void b(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.bvH < 0) {
      this.bvH = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.bvI != null) {
          this.bvI.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!vW())) {
          break;
        }
        this.bvG = j;
        this.bvF = paramMotionEvent.getPointerId(0);
        wd();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.bvF);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.bvG - k;
      i = j;
      if (!this.bvE)
      {
        i = j;
        if (Math.abs(j) > this.bvH)
        {
          this.bvE = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.bvH; this.bvE; i = j + this.bvH)
      {
        this.bvG = k;
        b(paramCoordinatorLayout, paramV, i, bU(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.bvI != null)
      {
        this.bvI.addMovement(paramMotionEvent);
        this.bvI.computeCurrentVelocity(1000);
        float f = this.bvI.getYVelocity(this.bvF);
        i = -bT(paramV);
        if (this.bvC != null)
        {
          paramV.removeCallbacks(this.bvC);
          this.bvC = null;
        }
        if (this.bvD == null) {
          this.bvD = new OverScroller(paramV.getContext());
        }
        this.bvD.fling(0, vY(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.bvD.computeScrollOffset()) {
          break label431;
        }
        this.bvC = new a(paramCoordinatorLayout, paramV);
        w.a(paramV, this.bvC);
      }
      break;
    }
    for (;;)
    {
      this.bvE = false;
      this.bvF = -1;
      if (this.bvI == null) {
        break;
      }
      this.bvI.recycle();
      this.bvI = null;
      break;
      label431:
      b(paramCoordinatorLayout, paramV);
    }
  }
  
  int bT(V paramV)
  {
    return paramV.getHeight();
  }
  
  int bU(V paramV)
  {
    return -paramV.getHeight();
  }
  
  int vV()
  {
    return vY();
  }
  
  boolean vW()
  {
    return false;
  }
  
  final class a
    implements Runnable
  {
    private final CoordinatorLayout bvJ;
    private final V bvK;
    
    a(V paramV)
    {
      this.bvJ = paramV;
      Object localObject;
      this.bvK = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(234711);
      if ((this.bvK != null) && (HeaderBehavior.this.bvD != null))
      {
        if (HeaderBehavior.this.bvD.computeScrollOffset())
        {
          HeaderBehavior.this.b(this.bvJ, this.bvK, HeaderBehavior.this.bvD.getCurrY());
          w.a(this.bvK, this);
          AppMethodBeat.o(234711);
          return;
        }
        HeaderBehavior.this.b(this.bvJ, this.bvK);
      }
      AppMethodBeat.o(234711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */