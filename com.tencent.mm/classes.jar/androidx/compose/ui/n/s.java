package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Velocity", "Landroidx/compose/ui/unit/Velocity;", "x", "", "y", "(FF)J", "ui-unit_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final long K(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204712);
    long l = r.J(Float.floatToIntBits(paramFloat1) << 32 | Float.floatToIntBits(paramFloat2) & 0xFFFFFFFF);
    AppMethodBeat.o(204712);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.s
 * JD-Core Version:    0.7.0.1
 */