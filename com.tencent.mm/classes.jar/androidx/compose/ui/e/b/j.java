package androidx.compose.ui.e.b;

import androidx.compose.ui.e.ap;
import androidx.compose.ui.e.bb;
import androidx.compose.ui.e.bc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", "", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getMiter", "()F", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "getWidth", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends f
{
  private static final int aAA;
  public static final j.a aAv;
  private static final int aAz;
  final float aAw;
  final int aAx;
  final int aAy;
  final ap avL;
  final float width;
  
  static
  {
    AppMethodBeat.i(206089);
    aAv = new j.a((byte)0);
    Object localObject = bb.ayr;
    aAz = bb.tO();
    localObject = bc.ayv;
    aAA = bc.tR();
    AppMethodBeat.o(206089);
  }
  
  private j(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, ap paramap)
  {
    super((byte)0);
    this.width = paramFloat1;
    this.aAw = paramFloat2;
    this.aAx = paramInt1;
    this.aAy = paramInt2;
    this.avL = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206096);
    if (this == paramObject)
    {
      AppMethodBeat.o(206096);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(206096);
      return false;
    }
    if (this.width == ((j)paramObject).width) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206096);
      return false;
    }
    if (this.aAw == ((j)paramObject).aAw) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206096);
      return false;
    }
    if (!bb.C(this.aAx, ((j)paramObject).aAx))
    {
      AppMethodBeat.o(206096);
      return false;
    }
    if (!bc.C(this.aAy, ((j)paramObject).aAy))
    {
      AppMethodBeat.o(206096);
      return false;
    }
    if (!s.p(this.avL, ((j)paramObject).avL))
    {
      AppMethodBeat.o(206096);
      return false;
    }
    AppMethodBeat.o(206096);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206101);
    int j = Float.floatToIntBits(this.width);
    int k = Float.floatToIntBits(this.aAw);
    int m = bb.cG(this.aAx);
    int n = bc.cG(this.aAy);
    ap localap = this.avL;
    if (localap == null) {}
    for (int i = 0;; i = localap.hashCode())
    {
      AppMethodBeat.o(206101);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206108);
    String str = "Stroke(width=" + this.width + ", miter=" + this.aAw + ", cap=" + bb.cJ(this.aAx) + ", join=" + bc.cJ(this.aAy) + ", pathEffect=" + this.avL + ')';
    AppMethodBeat.o(206108);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.b.j
 * JD-Core Version:    0.7.0.1
 */