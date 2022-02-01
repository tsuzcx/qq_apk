package androidx.compose.ui.g.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/util/Matrix;", "", "rows", "", "cols", "(II)V", "elements", "", "Landroidx/compose/ui/input/pointer/util/Vector;", "[Landroidx/compose/ui/input/pointer/util/Vector;", "get", "", "row", "col", "getRow", "set", "", "value", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
{
  final d[] aMn;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205886);
    int i = 0;
    d[] arrayOfd = new d[paramInt1];
    while (i < paramInt1)
    {
      arrayOfd[i] = new d(paramInt2);
      i += 1;
    }
    this.aMn = arrayOfd;
    AppMethodBeat.o(205886);
  }
  
  public final float ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205891);
    float f = this.aMn[paramInt1].get(paramInt2);
    AppMethodBeat.o(205891);
    return f;
  }
  
  public final void b(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(205896);
    this.aMn[paramInt1].f(paramInt2, paramFloat);
    AppMethodBeat.o(205896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.a
 * JD-Core Version:    0.7.0.1
 */