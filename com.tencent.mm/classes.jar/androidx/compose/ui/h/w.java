package androidx.compose.ui.h;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import androidx.compose.ui.n.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/Modifier$Element;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface w
  extends f.c
{
  public abstract Object a(d paramd, Object paramObject);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f a(w paramw, f paramf)
    {
      AppMethodBeat.i(205593);
      s.u(paramw, "this");
      s.u(paramf, "other");
      paramw = f.c.a.a((f.c)paramw, paramf);
      AppMethodBeat.o(205593);
      return paramw;
    }
    
    public static <R> R a(w paramw, R paramR, m<? super R, ? super f.c, ? extends R> paramm)
    {
      AppMethodBeat.i(205574);
      s.u(paramw, "this");
      s.u(paramm, "operation");
      paramw = f.c.a.a((f.c)paramw, paramR, paramm);
      AppMethodBeat.o(205574);
      return paramw;
    }
    
    public static boolean a(w paramw, b<? super f.c, Boolean> paramb)
    {
      AppMethodBeat.i(205586);
      s.u(paramw, "this");
      s.u(paramb, "predicate");
      boolean bool = f.c.a.a((f.c)paramw, paramb);
      AppMethodBeat.o(205586);
      return bool;
    }
    
    public static <R> R b(w paramw, R paramR, m<? super f.c, ? super R, ? extends R> paramm)
    {
      AppMethodBeat.i(205578);
      s.u(paramw, "this");
      s.u(paramm, "operation");
      paramw = f.c.a.b((f.c)paramw, paramR, paramm);
      AppMethodBeat.o(205578);
      return paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.w
 * JD-Core Version:    0.7.0.1
 */