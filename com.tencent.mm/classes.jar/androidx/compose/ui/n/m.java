package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"center", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntSize;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "IntSize", "width", "", "height", "(II)J", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final long an(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204735);
    long l = l.J(paramInt1 << 32 | paramInt2 & 0xFFFFFFFF);
    AppMethodBeat.o(204735);
    return l;
  }
  
  public static final long bl(long paramLong)
  {
    AppMethodBeat.i(204745);
    paramLong = androidx.compose.ui.d.l.z(l.bi(paramLong), l.bj(paramLong));
    AppMethodBeat.o(204745);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.m
 * JD-Core Version:    0.7.0.1
 */