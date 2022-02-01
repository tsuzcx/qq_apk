package androidx.compose.ui.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"getOrNull", "T", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "key", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final <T> T a(j paramj, t<T> paramt)
  {
    AppMethodBeat.i(205443);
    s.u(paramj, "<this>");
    s.u(paramt, "key");
    paramj = paramj.a(paramt, (a)a.aXf);
    AppMethodBeat.o(205443);
    return paramj;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<T>
  {
    public static final a aXf;
    
    static
    {
      AppMethodBeat.i(205490);
      aXf = new a();
      AppMethodBeat.o(205490);
    }
    
    a()
    {
      super();
    }
    
    public final T invoke()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.k.k
 * JD-Core Version:    0.7.0.1
 */