package androidx.compose.ui.h;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.e.a;
import androidx.compose.ui.d.f;
import androidx.compose.ui.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.b.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRoot", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final long b(j paramj)
  {
    AppMethodBeat.i(205662);
    s.u(paramj, "<this>");
    e.a locala = e.avo;
    long l = paramj.av(e.su());
    AppMethodBeat.o(205662);
    return l;
  }
  
  public static final long c(j paramj)
  {
    AppMethodBeat.i(205665);
    s.u(paramj, "<this>");
    e.a locala = e.avo;
    long l = paramj.au(e.su());
    AppMethodBeat.o(205665);
    return l;
  }
  
  public static final g d(j paramj)
  {
    AppMethodBeat.i(205666);
    s.u(paramj, "<this>");
    paramj = f(paramj).a(paramj);
    AppMethodBeat.o(205666);
    return paramj;
  }
  
  public static final g e(j paramj)
  {
    AppMethodBeat.i(205671);
    s.u(paramj, "<this>");
    j localj = f(paramj);
    paramj = d(paramj);
    long l1 = localj.au(f.x(paramj.left, paramj.top));
    long l2 = localj.au(f.x(paramj.right, paramj.top));
    long l3 = localj.au(f.x(paramj.right, paramj.bottom));
    long l4 = localj.au(f.x(paramj.left, paramj.bottom));
    paramj = new g(a.c(e.F(l1), new float[] { e.F(l2), e.F(l4), e.F(l3) }), a.c(e.G(l1), new float[] { e.G(l2), e.G(l4), e.G(l3) }), a.b(e.F(l1), new float[] { e.F(l2), e.F(l4), e.F(l3) }), a.b(e.G(l1), new float[] { e.G(l2), e.G(l4), e.G(l3) }));
    AppMethodBeat.o(205671);
    return paramj;
  }
  
  private static j f(j paramj)
  {
    AppMethodBeat.i(205674);
    s.u(paramj, "<this>");
    Object localObject2 = paramj.wJ();
    Object localObject1 = paramj;
    for (paramj = (j)localObject2; paramj != null; paramj = (j)localObject2)
    {
      localObject2 = paramj.wJ();
      localObject1 = paramj;
    }
    if ((localObject1 instanceof androidx.compose.ui.i.j)) {}
    for (paramj = (androidx.compose.ui.i.j)localObject1; paramj == null; paramj = null)
    {
      AppMethodBeat.o(205674);
      return localObject1;
    }
    for (localObject1 = paramj.aPj; localObject1 != null; localObject1 = localObject2)
    {
      localObject2 = ((androidx.compose.ui.i.j)localObject1).aPj;
      paramj = (j)localObject1;
    }
    paramj = (j)paramj;
    AppMethodBeat.o(205674);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.k
 * JD-Core Version:    0.7.0.1
 */