package android.support.v7.widget.a;

import android.support.v4.view.c;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import java.util.List;

final class a$2
  implements RecyclerView.l
{
  a$2(a parama) {}
  
  public final void Z(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.aoa.e(null, 0);
  }
  
  public final boolean h(MotionEvent paramMotionEvent)
  {
    this.aoa.anW.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    Object localObject;
    if (i == 0)
    {
      this.aoa.fC = paramMotionEvent.getPointerId(0);
      this.aoa.anF = paramMotionEvent.getX();
      this.aoa.anG = paramMotionEvent.getY();
      localObject = this.aoa;
      if (((a)localObject).fB != null) {
        ((a)localObject).fB.recycle();
      }
      ((a)localObject).fB = VelocityTracker.obtain();
      if (this.aoa.anE == null)
      {
        a locala = this.aoa;
        if (locala.anQ.isEmpty()) {
          break label349;
        }
        View localView = locala.k(paramMotionEvent);
        i = locala.anQ.size() - 1;
        if (i < 0) {
          break label349;
        }
        localObject = (a.c)locala.anQ.get(i);
        if (((a.c)localObject).ahi.aie != localView) {
          break label342;
        }
        label168:
        if (localObject != null)
        {
          locala = this.aoa;
          locala.anF -= ((a.c)localObject).aoq;
          locala = this.aoa;
          locala.anG -= ((a.c)localObject).aor;
          this.aoa.b(((a.c)localObject).ahi, true);
          if (this.aoa.anC.remove(((a.c)localObject).ahi.aie)) {
            this.aoa.anN.a(this.aoa.acI, ((a.c)localObject).ahi);
          }
          this.aoa.e(((a.c)localObject).ahi, ((a.c)localObject).anO);
          this.aoa.a(paramMotionEvent, this.aoa.anP, 0);
        }
      }
    }
    for (;;)
    {
      if (this.aoa.fB != null) {
        this.aoa.fB.addMovement(paramMotionEvent);
      }
      if (this.aoa.anE == null) {
        break label426;
      }
      return true;
      label342:
      i -= 1;
      break;
      label349:
      localObject = null;
      break label168;
      if ((i == 3) || (i == 1))
      {
        this.aoa.fC = -1;
        this.aoa.e(null, 0);
      }
      else if (this.aoa.fC != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.aoa.fC);
        if (j >= 0) {
          this.aoa.a(i, paramMotionEvent, j);
        }
      }
    }
    label426:
    return false;
  }
  
  public final void i(MotionEvent paramMotionEvent)
  {
    int i = 0;
    this.aoa.anW.onTouchEvent(paramMotionEvent);
    if (this.aoa.fB != null) {
      this.aoa.fB.addMovement(paramMotionEvent);
    }
    if (this.aoa.fC == -1) {}
    int j;
    do
    {
      int k;
      RecyclerView.v localv;
      do
      {
        return;
        j = paramMotionEvent.getActionMasked();
        k = paramMotionEvent.findPointerIndex(this.aoa.fC);
        if (k >= 0) {
          this.aoa.a(j, paramMotionEvent, k);
        }
        localv = this.aoa.anE;
      } while (localv == null);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.aoa.e(null, 0);
          this.aoa.fC = -1;
          return;
          if (k < 0) {
            break;
          }
          this.aoa.a(paramMotionEvent, this.aoa.anP, k);
          this.aoa.G(localv);
          this.aoa.acI.removeCallbacks(this.aoa.anR);
          this.aoa.anR.run();
          this.aoa.acI.invalidate();
          return;
          if (this.aoa.fB != null) {
            this.aoa.fB.clear();
          }
        }
      }
      j = paramMotionEvent.getActionIndex();
    } while (paramMotionEvent.getPointerId(j) != this.aoa.fC);
    if (j == 0) {
      i = 1;
    }
    this.aoa.fC = paramMotionEvent.getPointerId(i);
    this.aoa.a(paramMotionEvent, this.aoa.anP, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.2
 * JD-Core Version:    0.7.0.1
 */