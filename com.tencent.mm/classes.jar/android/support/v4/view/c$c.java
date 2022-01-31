package android.support.v4.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class c$c
  implements c.a
{
  private final GestureDetector Fh;
  
  c$c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.Fh = new GestureDetector(paramContext, paramOnGestureListener, null);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.Fh.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.view.c.c
 * JD-Core Version:    0.7.0.1
 */