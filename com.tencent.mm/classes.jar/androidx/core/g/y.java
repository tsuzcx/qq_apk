package androidx.core.g;

import android.view.VelocityTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class y
{
  @Deprecated
  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    AppMethodBeat.i(195682);
    float f = paramVelocityTracker.getXVelocity(paramInt);
    AppMethodBeat.o(195682);
    return f;
  }
  
  @Deprecated
  public static float b(VelocityTracker paramVelocityTracker, int paramInt)
  {
    AppMethodBeat.i(195689);
    float f = paramVelocityTracker.getYVelocity(paramInt);
    AppMethodBeat.o(195689);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.y
 * JD-Core Version:    0.7.0.1
 */