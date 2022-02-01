package androidx.core.g;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private final a bsK;
  
  public d(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  private d(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    AppMethodBeat.i(195717);
    if (Build.VERSION.SDK_INT > 17)
    {
      this.bsK = new c(paramContext, paramOnGestureListener);
      AppMethodBeat.o(195717);
      return;
    }
    this.bsK = new d.b(paramContext, paramOnGestureListener);
    AppMethodBeat.o(195717);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195725);
    boolean bool = this.bsK.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(195725);
    return bool;
  }
  
  static abstract interface a
  {
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
  
  static final class c
    implements d.a
  {
    private final GestureDetector bth;
    
    c(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
    {
      AppMethodBeat.i(195664);
      this.bth = new GestureDetector(paramContext, paramOnGestureListener, null);
      AppMethodBeat.o(195664);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(195672);
      GestureDetector localGestureDetector = this.bth;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "androidx/core/view/GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(195672);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.d
 * JD-Core Version:    0.7.0.1
 */