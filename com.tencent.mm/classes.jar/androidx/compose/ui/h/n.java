package androidx.compose.ui.h;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/Modifier$Element;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
  extends f.c
{
  public abstract q a(r paramr, o paramo, long paramLong);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f a(n paramn, f paramf)
    {
      AppMethodBeat.i(205700);
      s.u(paramn, "this");
      s.u(paramf, "other");
      paramn = f.c.a.a((f.c)paramn, paramf);
      AppMethodBeat.o(205700);
      return paramn;
    }
    
    public static <R> R a(n paramn, R paramR, m<? super R, ? super f.c, ? extends R> paramm)
    {
      AppMethodBeat.i(205682);
      s.u(paramn, "this");
      s.u(paramm, "operation");
      paramn = f.c.a.a((f.c)paramn, paramR, paramm);
      AppMethodBeat.o(205682);
      return paramn;
    }
    
    public static boolean a(n paramn, b<? super f.c, Boolean> paramb)
    {
      AppMethodBeat.i(205693);
      s.u(paramn, "this");
      s.u(paramb, "predicate");
      boolean bool = f.c.a.a((f.c)paramn, paramb);
      AppMethodBeat.o(205693);
      return bool;
    }
    
    public static <R> R b(n paramn, R paramR, m<? super f.c, ? super R, ? extends R> paramm)
    {
      AppMethodBeat.i(205686);
      s.u(paramn, "this");
      s.u(paramm, "operation");
      paramn = f.c.a.b((f.c)paramn, paramR, paramm);
      AppMethodBeat.o(205686);
      return paramn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.n
 * JD-Core Version:    0.7.0.1
 */