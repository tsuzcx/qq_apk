package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class c
{
  private final a Pq;
  
  public c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.Pq = new c(paramContext, paramOnGestureListener);
      return;
    }
    this.Pq = new c.b(paramContext, paramOnGestureListener);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.Pq.onTouchEvent(paramMotionEvent);
  }
  
  static abstract interface a
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  static final class c
    implements c.a
  {
    private final GestureDetector PO;
    
    c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      this.PO = new GestureDetector(paramContext, paramOnGestureListener, null);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      GestureDetector localGestureDetector = this.PO;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.axQ(), "android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      return com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.view.c
 * JD-Core Version:    0.7.0.1
 */