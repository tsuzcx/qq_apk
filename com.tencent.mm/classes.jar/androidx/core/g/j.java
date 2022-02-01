package androidx.core.g;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  @Deprecated
  public static int c(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(251472);
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    AppMethodBeat.o(251472);
    return paramInt;
  }
  
  @Deprecated
  public static int d(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251469);
    int i = paramMotionEvent.getActionMasked();
    AppMethodBeat.o(251469);
    return i;
  }
  
  @Deprecated
  public static int d(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(251474);
    paramInt = paramMotionEvent.getPointerId(paramInt);
    AppMethodBeat.o(251474);
    return paramInt;
  }
  
  @Deprecated
  public static float e(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(251475);
    float f = paramMotionEvent.getX(paramInt);
    AppMethodBeat.o(251475);
    return f;
  }
  
  @Deprecated
  public static int e(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251471);
    int i = paramMotionEvent.getActionIndex();
    AppMethodBeat.o(251471);
    return i;
  }
  
  @Deprecated
  public static float f(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(251476);
    float f = paramMotionEvent.getY(paramInt);
    AppMethodBeat.o(251476);
    return f;
  }
  
  @Deprecated
  public static int f(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251477);
    int i = paramMotionEvent.getPointerCount();
    AppMethodBeat.o(251477);
    return i;
  }
  
  public static boolean g(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251478);
    if ((paramMotionEvent.getSource() & 0x2002) == 8194)
    {
      AppMethodBeat.o(251478);
      return true;
    }
    AppMethodBeat.o(251478);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.j
 * JD-Core Version:    0.7.0.1
 */