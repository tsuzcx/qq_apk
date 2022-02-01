package androidx.core.g;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  @Deprecated
  public static int d(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195685);
    int i = paramMotionEvent.getActionMasked();
    AppMethodBeat.o(195685);
    return i;
  }
  
  @Deprecated
  public static int d(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(195704);
    paramInt = paramMotionEvent.findPointerIndex(paramInt);
    AppMethodBeat.o(195704);
    return paramInt;
  }
  
  @Deprecated
  public static int e(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195694);
    int i = paramMotionEvent.getActionIndex();
    AppMethodBeat.o(195694);
    return i;
  }
  
  @Deprecated
  public static int e(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(195711);
    paramInt = paramMotionEvent.getPointerId(paramInt);
    AppMethodBeat.o(195711);
    return paramInt;
  }
  
  @Deprecated
  public static float f(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(195723);
    float f = paramMotionEvent.getX(paramInt);
    AppMethodBeat.o(195723);
    return f;
  }
  
  @Deprecated
  public static int f(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195741);
    int i = paramMotionEvent.getPointerCount();
    AppMethodBeat.o(195741);
    return i;
  }
  
  @Deprecated
  public static float g(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(195734);
    float f = paramMotionEvent.getY(paramInt);
    AppMethodBeat.o(195734);
    return f;
  }
  
  public static boolean g(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195754);
    if ((paramMotionEvent.getSource() & 0x2002) == 8194)
    {
      AppMethodBeat.o(195754);
      return true;
    }
    AppMethodBeat.o(195754);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.j
 * JD-Core Version:    0.7.0.1
 */