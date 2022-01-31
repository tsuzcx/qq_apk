package android.support.v7.widget.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

final class a$b
  extends GestureDetector.SimpleOnGestureListener
{
  boolean aoi = true;
  
  a$b(a parama) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (!this.aoi) {}
    for (;;)
    {
      return;
      Object localObject = this.aoa.k(paramMotionEvent);
      if (localObject != null)
      {
        localObject = this.aoa.acI.aT((View)localObject);
        if (localObject != null)
        {
          if ((a.a.g(this.aoa.acI) & 0xFF0000) != 0) {}
          for (int i = 1; (i != 0) && (paramMotionEvent.getPointerId(0) == this.aoa.fC); i = 0)
          {
            i = paramMotionEvent.findPointerIndex(this.aoa.fC);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            this.aoa.anF = f1;
            this.aoa.anG = f2;
            paramMotionEvent = this.aoa;
            this.aoa.anK = 0.0F;
            paramMotionEvent.anJ = 0.0F;
            this.aoa.anN.jl();
            this.aoa.e((RecyclerView.v)localObject, 2);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.a.a.b
 * JD-Core Version:    0.7.0.1
 */