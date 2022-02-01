package androidx.core.g;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private final a MH;
  
  public d(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private d(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    AppMethodBeat.i(251435);
    if (Build.VERSION.SDK_INT > 17)
    {
      this.MH = new c(paramContext, paramOnGestureListener);
      AppMethodBeat.o(251435);
      return;
    }
    this.MH = new d.b(paramContext, paramOnGestureListener);
    AppMethodBeat.o(251435);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251436);
    boolean bool = this.MH.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(251436);
    return bool;
  }
  
  static abstract interface a
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  static final class c
    implements d.a
  {
    private final GestureDetector Nf;
    
    c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      AppMethodBeat.i(251430);
      this.Nf = new GestureDetector(paramContext, paramOnGestureListener, null);
      AppMethodBeat.o(251430);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251432);
      GestureDetector localGestureDetector = this.Nf;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(251432);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.d
 * JD-Core Version:    0.7.0.1
 */