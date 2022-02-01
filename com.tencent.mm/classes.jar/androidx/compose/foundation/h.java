package androidx.compose.foundation;

import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final long YI;
  
  static
  {
    AppMethodBeat.i(203551);
    YI = ViewConfiguration.getTapTimeout();
    AppMethodBeat.o(203551);
  }
  
  public static final long mi()
  {
    return YI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.h
 * JD-Core Version:    0.7.0.1
 */