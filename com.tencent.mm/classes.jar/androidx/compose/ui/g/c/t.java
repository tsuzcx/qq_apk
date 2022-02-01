package androidx.compose.ui.g.c;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/Modifier$Element;", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface t
  extends f.c
{
  public abstract s wq();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f a(t paramt, f paramf)
    {
      AppMethodBeat.i(205753);
      kotlin.g.b.s.u(paramt, "this");
      kotlin.g.b.s.u(paramf, "other");
      paramt = f.c.a.a((f.c)paramt, paramf);
      AppMethodBeat.o(205753);
      return paramt;
    }
    
    public static <R> R a(t paramt, R paramR, m<? super R, ? super f.c, ? extends R> paramm)
    {
      AppMethodBeat.i(205733);
      kotlin.g.b.s.u(paramt, "this");
      kotlin.g.b.s.u(paramm, "operation");
      paramt = f.c.a.a((f.c)paramt, paramR, paramm);
      AppMethodBeat.o(205733);
      return paramt;
    }
    
    public static boolean a(t paramt, b<? super f.c, Boolean> paramb)
    {
      AppMethodBeat.i(205746);
      kotlin.g.b.s.u(paramt, "this");
      kotlin.g.b.s.u(paramb, "predicate");
      boolean bool = f.c.a.a((f.c)paramt, paramb);
      AppMethodBeat.o(205746);
      return bool;
    }
    
    public static <R> R b(t paramt, R paramR, m<? super f.c, ? super R, ? extends R> paramm)
    {
      AppMethodBeat.i(205738);
      kotlin.g.b.s.u(paramt, "this");
      kotlin.g.b.s.u(paramm, "operation");
      paramt = f.c.a.b((f.c)paramt, paramR, paramm);
      AppMethodBeat.o(205738);
      return paramt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.t
 * JD-Core Version:    0.7.0.1
 */