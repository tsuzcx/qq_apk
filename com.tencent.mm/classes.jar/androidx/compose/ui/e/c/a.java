package androidx.compose.ui.e.c;

import androidx.compose.ui.d.k;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.n.j;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "size", "J", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "validateSize", "validateSize-N5eqBDc", "(JJ)J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  private final af aAB;
  private final long aAC;
  private float alpha;
  private aa auz;
  private final long size;
  private final long srcSize;
  
  private a(af paramaf, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205971);
    this.aAB = paramaf;
    this.aAC = paramLong1;
    this.srcSize = paramLong2;
    paramLong1 = this.aAC;
    paramLong2 = this.srcSize;
    if ((j.bf(paramLong1) >= 0) && (j.bg(paramLong1) >= 0) && (l.bi(paramLong2) >= 0) && (l.bj(paramLong2) >= 0) && (l.bi(paramLong2) <= this.aAB.getWidth()) && (l.bj(paramLong2) <= this.aAB.getHeight())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramaf = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205971);
      throw paramaf;
    }
    this.size = paramLong2;
    this.alpha = 1.0F;
    AppMethodBeat.o(205971);
  }
  
  protected final boolean S(float paramFloat)
  {
    this.alpha = paramFloat;
    return true;
  }
  
  protected final void b(e parame)
  {
    AppMethodBeat.i(205983);
    s.u(parame, "<this>");
    e.b.a(parame, this.aAB, this.aAC, this.srcSize, 0L, m.an(kotlin.h.a.eH(k.Q(parame.sf())), kotlin.h.a.eH(k.R(parame.sf()))), this.alpha, null, this.auz, 0, 328);
    AppMethodBeat.o(205983);
  }
  
  protected final boolean c(aa paramaa)
  {
    this.auz = paramaa;
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205996);
    if (this == paramObject)
    {
      AppMethodBeat.o(205996);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(205996);
      return false;
    }
    if (!s.p(this.aAB, ((a)paramObject).aAB))
    {
      AppMethodBeat.o(205996);
      return false;
    }
    if (!j.e(this.aAC, ((a)paramObject).aAC))
    {
      AppMethodBeat.o(205996);
      return false;
    }
    if (!l.e(this.srcSize, ((a)paramObject).srcSize))
    {
      AppMethodBeat.o(205996);
      return false;
    }
    AppMethodBeat.o(205996);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205999);
    int i = this.aAB.hashCode();
    int j = j.I(this.aAC);
    int k = l.I(this.srcSize);
    AppMethodBeat.o(205999);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206004);
    String str = "BitmapPainter(image=" + this.aAB + ", srcOffset=" + j.H(this.aAC) + ", srcSize=" + l.H(this.srcSize) + ')';
    AppMethodBeat.o(206004);
    return str;
  }
  
  public final long uM()
  {
    AppMethodBeat.i(205986);
    long l = m.bl(this.size);
    AppMethodBeat.o(205986);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.c.a
 * JD-Core Version:    0.7.0.1
 */