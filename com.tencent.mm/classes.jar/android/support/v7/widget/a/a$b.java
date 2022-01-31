package android.support.v7.widget.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

final class a$b
  extends GestureDetector.SimpleOnGestureListener
{
  boolean aqz = true;
  
  a$b(a parama) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (!this.aqz) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.aqr.k(paramMotionEvent);
        } while (localObject == null);
        localObject = this.aqr.adt.bb((View)localObject);
      } while (localObject == null);
      a.a.j(this.aqr.adt);
    } while (paramMotionEvent.getPointerId(0) != this.aqr.mActivePointerId);
    int i = paramMotionEvent.findPointerIndex(this.aqr.mActivePointerId);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    this.aqr.apW = f1;
    this.aqr.apX = f2;
    paramMotionEvent = this.aqr;
    this.aqr.aqb = 0.0F;
    paramMotionEvent.aqa = 0.0F;
    this.aqr.e((RecyclerView.v)localObject, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.a.a.b
 * JD-Core Version:    0.7.0.1
 */