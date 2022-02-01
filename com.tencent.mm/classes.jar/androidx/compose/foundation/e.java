package androidx.compose.foundation;

import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/BorderStroke;", "", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "(FLandroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getWidth-D9Ej5fM", "()F", "F", "copy", "copy-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)Landroidx/compose/foundation/BorderStroke;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  final androidx.compose.ui.e.s XJ;
  final float width;
  
  private e(float paramFloat, androidx.compose.ui.e.s params)
  {
    this.width = paramFloat;
    this.XJ = params;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203616);
    if (this == paramObject)
    {
      AppMethodBeat.o(203616);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(203616);
      return false;
    }
    if (!g.G(this.width, ((e)paramObject).width))
    {
      AppMethodBeat.o(203616);
      return false;
    }
    if (!kotlin.g.b.s.p(this.XJ, ((e)paramObject).XJ))
    {
      AppMethodBeat.o(203616);
      return false;
    }
    AppMethodBeat.o(203616);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203627);
    int i = g.ah(this.width);
    int j = this.XJ.hashCode();
    AppMethodBeat.o(203627);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203635);
    String str = "BorderStroke(width=" + g.ak(this.width) + ", brush=" + this.XJ + ')';
    AppMethodBeat.o(203635);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.e
 * JD-Core Version:    0.7.0.1
 */