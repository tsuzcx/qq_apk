package androidx.compose.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleAlpha;", "", "draggedAlpha", "", "focusedAlpha", "hoveredAlpha", "pressedAlpha", "(FFFF)V", "getDraggedAlpha", "()F", "getFocusedAlpha", "getHoveredAlpha", "getPressedAlpha", "equals", "", "other", "hashCode", "", "toString", "", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  final float akk;
  private final float akl;
  private final float akm;
  final float akn;
  
  public f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.akk = paramFloat1;
    this.akl = paramFloat2;
    this.akm = paramFloat3;
    this.akn = paramFloat4;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof f)) {
      return false;
    }
    if (this.akk == ((f)paramObject).akk) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    if (this.akl == ((f)paramObject).akl) {}
    for (i = 1; i == 0; i = 0) {
      return false;
    }
    if (this.akm == ((f)paramObject).akm) {}
    for (i = 1; i == 0; i = 0) {
      return false;
    }
    if (this.akn == ((f)paramObject).akn) {}
    for (i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201824);
    int i = Float.floatToIntBits(this.akk);
    int j = Float.floatToIntBits(this.akl);
    int k = Float.floatToIntBits(this.akm);
    int m = Float.floatToIntBits(this.akn);
    AppMethodBeat.o(201824);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201826);
    String str = "RippleAlpha(draggedAlpha=" + this.akk + ", focusedAlpha=" + this.akl + ", hoveredAlpha=" + this.akm + ", pressedAlpha=" + this.akn + ')';
    AppMethodBeat.o(201826);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.f
 * JD-Core Version:    0.7.0.1
 */