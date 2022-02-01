package android.support.v4.view;

import android.view.MotionEvent;

public final class i
{
  @Deprecated
  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.findPointerIndex(paramInt);
  }
  
  @Deprecated
  public static int c(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getPointerId(paramInt);
  }
  
  @Deprecated
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getX(paramInt);
  }
  
  @Deprecated
  public static float e(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getY(paramInt);
  }
  
  @Deprecated
  public static int e(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getActionMasked();
  }
  
  @Deprecated
  public static int f(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getActionIndex();
  }
  
  @Deprecated
  public static int g(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getPointerCount();
  }
  
  public static boolean h(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getSource() & 0x2002) == 8194;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.i
 * JD-Core Version:    0.7.0.1
 */