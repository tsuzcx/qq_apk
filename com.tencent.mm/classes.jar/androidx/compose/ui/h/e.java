package androidx.compose.ui.h;

import androidx.compose.ui.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"computeFillHeight", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillHeight-iLBOSCw", "(JJ)F", "computeFillMaxDimension", "computeFillMaxDimension-iLBOSCw", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  static final float m(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205630);
    float f = Math.min(n(paramLong1, paramLong2), o(paramLong1, paramLong2));
    AppMethodBeat.o(205630);
    return f;
  }
  
  static final float n(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205637);
    float f = k.Q(paramLong2) / k.Q(paramLong1);
    AppMethodBeat.o(205637);
    return f;
  }
  
  static final float o(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205644);
    float f = k.R(paramLong2) / k.R(paramLong1);
    AppMethodBeat.o(205644);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.e
 * JD-Core Version:    0.7.0.1
 */