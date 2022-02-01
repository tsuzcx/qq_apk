package androidx.compose.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/CombinedModifier;", "Landroidx/compose/ui/Modifier;", "outer", "inner", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;)V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "equals", "other", "", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "hashCode", "", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements f
{
  private final f atX;
  private final f atY;
  
  public c(f paramf1, f paramf2)
  {
    AppMethodBeat.i(204781);
    this.atX = paramf1;
    this.atY = paramf2;
    AppMethodBeat.o(204781);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204829);
    paramf = f.b.a(this, paramf);
    AppMethodBeat.o(204829);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204792);
    s.u(paramm, "operation");
    paramR = this.atY.a(this.atX.a(paramR, paramm), paramm);
    AppMethodBeat.o(204792);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204809);
    s.u(paramb, "predicate");
    if ((this.atX.a(paramb)) && (this.atY.a(paramb)))
    {
      AppMethodBeat.o(204809);
      return true;
    }
    AppMethodBeat.o(204809);
    return false;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204800);
    s.u(paramm, "operation");
    paramR = this.atX.b(this.atY.b(paramR, paramm), paramm);
    AppMethodBeat.o(204800);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204817);
    if (((paramObject instanceof c)) && (s.p(this.atX, ((c)paramObject).atX)) && (s.p(this.atY, ((c)paramObject).atY)))
    {
      AppMethodBeat.o(204817);
      return true;
    }
    AppMethodBeat.o(204817);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204822);
    int i = this.atX.hashCode();
    int j = this.atY.hashCode();
    AppMethodBeat.o(204822);
    return i + j * 31;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204827);
    String str = "[" + (String)a("", (m)c.a.atZ) + ']';
    AppMethodBeat.o(204827);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c
 * JD-Core Version:    0.7.0.1
 */