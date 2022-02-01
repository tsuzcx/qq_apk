package androidx.core.g;

import android.view.VelocityTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class v
{
  @Deprecated
  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    AppMethodBeat.i(251574);
    float f = paramVelocityTracker.getXVelocity(paramInt);
    AppMethodBeat.o(251574);
    return f;
  }
  
  @Deprecated
  public static float b(VelocityTracker paramVelocityTracker, int paramInt)
  {
    AppMethodBeat.i(251575);
    float f = paramVelocityTracker.getYVelocity(paramInt);
    AppMethodBeat.o(251575);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.v
 * JD-Core Version:    0.7.0.1
 */