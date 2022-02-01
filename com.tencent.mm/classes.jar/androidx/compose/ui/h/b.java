package androidx.compose.ui.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"FirstBaseline", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "getFirstBaseline", "()Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "LastBaseline", "getLastBaseline", "merge", "", "Landroidx/compose/ui/layout/AlignmentLine;", "position1", "position2", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final g aMA;
  private static final g aMz;
  
  static
  {
    AppMethodBeat.i(205639);
    aMz = new g((m)a.aMB);
    aMA = new g((m)b.aMC);
    AppMethodBeat.o(205639);
  }
  
  public static final int a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205625);
    s.u(parama, "<this>");
    paramInt1 = ((Number)parama.aMy.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2))).intValue();
    AppMethodBeat.o(205625);
    return paramInt1;
  }
  
  public static final g wC()
  {
    return aMz;
  }
  
  public static final g wD()
  {
    return aMA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.h.b
 * JD-Core Version:    0.7.0.1
 */