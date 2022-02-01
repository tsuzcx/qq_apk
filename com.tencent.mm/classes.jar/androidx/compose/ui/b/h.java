package androidx.compose.ui.b;

import androidx.compose.ui.e.b.c;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
  extends f.c
{
  public abstract void a(c paramc);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f a(h paramh, f paramf)
    {
      AppMethodBeat.i(204811);
      s.u(paramh, "this");
      s.u(paramf, "other");
      paramh = f.c.a.a((f.c)paramh, paramf);
      AppMethodBeat.o(204811);
      return paramh;
    }
    
    public static <R> R a(h paramh, R paramR, m<? super R, ? super f.c, ? extends R> paramm)
    {
      AppMethodBeat.i(204784);
      s.u(paramh, "this");
      s.u(paramm, "operation");
      paramh = f.c.a.a((f.c)paramh, paramR, paramm);
      AppMethodBeat.o(204784);
      return paramh;
    }
    
    public static boolean a(h paramh, b<? super f.c, Boolean> paramb)
    {
      AppMethodBeat.i(204801);
      s.u(paramh, "this");
      s.u(paramb, "predicate");
      boolean bool = f.c.a.a((f.c)paramh, paramb);
      AppMethodBeat.o(204801);
      return bool;
    }
    
    public static <R> R b(h paramh, R paramR, m<? super f.c, ? super R, ? extends R> paramm)
    {
      AppMethodBeat.i(204793);
      s.u(paramh, "this");
      s.u(paramm, "operation");
      paramh = f.c.a.b((f.c)paramh, paramR, paramm);
      AppMethodBeat.o(204793);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.h
 * JD-Core Version:    0.7.0.1
 */