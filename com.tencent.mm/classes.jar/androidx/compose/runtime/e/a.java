package androidx.compose.runtime.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"listSaver", "Landroidx/compose/runtime/saveable/Saver;", "Original", "", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "list", "runtime-saveable_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final <Original, Saveable> i<Original, Object> a(m<? super k, ? super Original, ? extends List<? extends Saveable>> paramm, b<? super List<? extends Saveable>, ? extends Original> paramb)
  {
    AppMethodBeat.i(202932);
    s.u(paramm, "save");
    s.u(paramb, "restore");
    paramm = j.b((m)new a(paramm), paramb);
    AppMethodBeat.o(202932);
    return paramm;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Original", "Saveable", "Landroidx/compose/runtime/saveable/SaverScope;", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<k, Original, Object>
  {
    a(m<? super k, ? super Original, ? extends List<? extends Saveable>> paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.e.a
 * JD-Core Version:    0.7.0.1
 */