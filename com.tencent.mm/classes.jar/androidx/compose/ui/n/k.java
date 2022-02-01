package androidx.compose.ui.n;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "minus", "Landroidx/compose/ui/geometry/Offset;", "offset", "minus-Nv-tHpc", "(JJ)J", "minus-oCl6YwE", "plus", "plus-Nv-tHpc", "plus-oCl6YwE", "round", "round-k-4lQ0M", "(J)J", "toOffset", "toOffset--gyyYBs", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final long am(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204746);
    long l = j.J(paramInt1 << 32 | paramInt2 & 0xFFFFFFFF);
    AppMethodBeat.o(204746);
    return l;
  }
  
  public static final long r(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(204759);
    paramLong1 = f.x(e.F(paramLong1) + j.bf(paramLong2), e.G(paramLong1) + j.bg(paramLong2));
    AppMethodBeat.o(204759);
    return paramLong1;
  }
  
  public static final long s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(204770);
    paramLong1 = f.x(e.F(paramLong1) - j.bf(paramLong2), e.G(paramLong1) - j.bg(paramLong2));
    AppMethodBeat.o(204770);
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.k
 * JD-Core Version:    0.7.0.1
 */