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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private Runnable doF;
  OverScroller doG;
  private boolean doH;
  private int doI = -1;
  private int doJ;
  private int doK = -1;
  private VelocityTracker doL;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void VC()
  {
    if (this.doL == null) {
      this.doL = VelocityTracker.obtain();
    }
  }
  
  int Vu()
  {
    return Vx();
  }
  
  boolean Vv()
  {
    return false;
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = Vx();
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
            ji(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.doK < 0) {
      this.doK = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.doH)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.doL != null) {
        this.doL.addMovement(paramMotionEvent);
      }
      return this.doH;
      this.doH = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((Vv()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.doJ = j;
        this.doI = paramMotionEvent.getPointerId(0);
        VC();
        continue;
        i = this.doI;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.doJ) > this.doK)
            {
              this.doH = true;
              this.doJ = i;
              continue;
              this.doH = false;
              this.doI = -1;
              if (this.doL != null)
              {
                this.doL.recycle();
                this.doL = null;
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
    return a(paramCoordinatorLayout, paramV, Vu() - paramInt1, paramInt2, paramInt3);
  }
  
  void b(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.doK < 0) {
      this.doK = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.doL != null) {
          this.doL.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!Vv())) {
          break;
        }
        this.doJ = j;
        this.doI = paramMotionEvent.getPointerId(0);
        VC();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.doI);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.doJ - k;
      i = j;
      if (!this.doH)
      {
        i = j;
        if (Math.abs(j) > this.doK)
        {
          this.doH = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.doK; this.doH; i = j + this.doK)
      {
        this.doJ = k;
        b(paramCoordinatorLayout, paramV, i, cq(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.doL != null)
      {
        this.doL.addMovement(paramMotionEvent);
        this.doL.computeCurrentVelocity(1000);
        float f = this.doL.getYVelocity(this.doI);
        i = -cp(paramV);
        if (this.doF != null)
        {
          paramV.removeCallbacks(this.doF);
          this.doF = null;
        }
        if (this.doG == null) {
          this.doG = new OverScroller(paramV.getContext());
        }
        this.doG.fling(0, Vx(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.doG.computeScrollOffset()) {
          break label431;
        }
        this.doF = new a(paramCoordinatorLayout, paramV);
        z.b(paramV, this.doF);
      }
      break;
    }
    for (;;)
    {
      this.doH = false;
      this.doI = -1;
      if (this.doL == null) {
        break;
      }
      this.doL.recycle();
      this.doL = null;
      break;
      label431:
      b(paramCoordinatorLayout, paramV);
    }
  }
  
  int cp(V paramV)
  {
    return paramV.getHeight();
  }
  
  int cq(V paramV)
  {
    return -paramV.getHeight();
  }
  
  final class a
    implements Runnable
  {
    private final CoordinatorLayout doM;
    private final V doN;
    
    a(V paramV)
    {
      this.doM = paramV;
      Object localObject;
      this.doN = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(210021);
      if ((this.doN != null) && (HeaderBehavior.this.doG != null))
      {
        if (HeaderBehavior.this.doG.computeScrollOffset())
        {
          HeaderBehavior.this.b(this.doM, this.doN, HeaderBehavior.this.doG.getCurrY());
          z.b(this.doN, this);
          AppMethodBeat.o(210021);
          return;
        }
        HeaderBehavior.this.b(this.doM, this.doN);
      }
      AppMethodBeat.o(210021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */