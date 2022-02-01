package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class c
{
  private final a Pe;
  
  public c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.Pe = new c(paramContext, paramOnGestureListener);
      return;
    }
    this.Pe = new c.b(paramContext, paramOnGestureListener);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.Pe.onTouchEvent(paramMotionEvent);
  }
  
  static abstract interface a
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  static final class c
    implements c.a
  {
    private final GestureDetector PC;
    
    c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      this.PC = new GestureDetector(paramContext, paramOnGestureListener, null);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      GestureDetector localGestureDetector = this.PC;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahp(), "android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      return com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "android/support/v4/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.view.c
 * JD-Core Version:    0.7.0.1
 */