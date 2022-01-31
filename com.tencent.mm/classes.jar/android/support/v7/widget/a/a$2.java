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
  
  public final void ac(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.aqr.e(null, 0);
  }
  
  public final boolean h(MotionEvent paramMotionEvent)
  {
    this.aqr.aqn.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    Object localObject;
    if (i == 0)
    {
      this.aqr.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.aqr.apW = paramMotionEvent.getX();
      this.aqr.apX = paramMotionEvent.getY();
      localObject = this.aqr;
      if (((a)localObject).mVelocityTracker != null) {
        ((a)localObject).mVelocityTracker.recycle();
      }
      ((a)localObject).mVelocityTracker = VelocityTracker.obtain();
      if (this.aqr.apV == null)
      {
        a locala = this.aqr;
        if (locala.aqh.isEmpty()) {
          break label349;
        }
        View localView = locala.k(paramMotionEvent);
        i = locala.aqh.size() - 1;
        if (i < 0) {
          break label349;
        }
        localObject = (a.c)locala.aqh.get(i);
        if (((a.c)localObject).ajy.aku != localView) {
          break label342;
        }
        label168:
        if (localObject != null)
        {
          locala = this.aqr;
          locala.apW -= ((a.c)localObject).mX;
          locala = this.aqr;
          locala.apX -= ((a.c)localObject).mY;
          this.aqr.b(((a.c)localObject).ajy, true);
          if (this.aqr.apT.remove(((a.c)localObject).ajy.aku)) {
            this.aqr.aqe.a(this.aqr.adt, ((a.c)localObject).ajy);
          }
          this.aqr.e(((a.c)localObject).ajy, ((a.c)localObject).aqf);
          this.aqr.a(paramMotionEvent, this.aqr.aqg, 0);
        }
      }
    }
    for (;;)
    {
      if (this.aqr.mVelocityTracker != null) {
        this.aqr.mVelocityTracker.addMovement(paramMotionEvent);
      }
      if (this.aqr.apV == null) {
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
        this.aqr.mActivePointerId = -1;
        this.aqr.e(null, 0);
      }
      else if (this.aqr.mActivePointerId != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.aqr.mActivePointerId);
        if (j >= 0) {
          this.aqr.a(i, paramMotionEvent, j);
        }
      }
    }
    label426:
    return false;
  }
  
  public final void i(MotionEvent paramMotionEvent)
  {
    int i = 0;
    this.aqr.aqn.onTouchEvent(paramMotionEvent);
    if (this.aqr.mVelocityTracker != null) {
      this.aqr.mVelocityTracker.addMovement(paramMotionEvent);
    }
    if (this.aqr.mActivePointerId == -1) {}
    int j;
    do
    {
      int k;
      RecyclerView.v localv;
      do
      {
        return;
        j = paramMotionEvent.getActionMasked();
        k = paramMotionEvent.findPointerIndex(this.aqr.mActivePointerId);
        if (k >= 0) {
          this.aqr.a(j, paramMotionEvent, k);
        }
        localv = this.aqr.apV;
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
          this.aqr.e(null, 0);
          this.aqr.mActivePointerId = -1;
          return;
          if (k < 0) {
            break;
          }
          this.aqr.a(paramMotionEvent, this.aqr.aqg, k);
          this.aqr.M(localv);
          this.aqr.adt.removeCallbacks(this.aqr.aqi);
          this.aqr.aqi.run();
          this.aqr.adt.invalidate();
          return;
          if (this.aqr.mVelocityTracker != null) {
            this.aqr.mVelocityTracker.clear();
          }
        }
      }
      j = paramMotionEvent.getActionIndex();
    } while (paramMotionEvent.getPointerId(j) != this.aqr.mActivePointerId);
    if (j == 0) {
      i = 1;
    }
    this.aqr.mActivePointerId = paramMotionEvent.getPointerId(i);
    this.aqr.a(paramMotionEvent, this.aqr.aqg, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.2
 * JD-Core Version:    0.7.0.1
 */