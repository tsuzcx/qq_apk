package androidx.compose.runtime.e;

import androidx.compose.runtime.as;
import androidx.compose.runtime.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalSaveableStateRegistry", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getLocalSaveableStateRegistry", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "SaveableStateRegistry", "restoredValues", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "runtime-saveable_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final as<f> asg;
  
  static
  {
    AppMethodBeat.i(202931);
    asg = q.e((a)a.ash);
    AppMethodBeat.o(202931);
  }
  
  public static final f a(Map<String, ? extends List<? extends Object>> paramMap, b<Object, Boolean> paramb)
  {
    AppMethodBeat.i(202919);
    s.u(paramb, "canBeSaved");
    paramMap = (f)new g(paramMap, paramb);
    AppMethodBeat.o(202919);
    return paramMap;
  }
  
  public static final as<f> rd()
  {
    return asg;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<f>
  {
    public static final a ash;
    
    static
    {
      AppMethodBeat.i(202963);
      ash = new a();
      AppMethodBeat.o(202963);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.runtime.e.h
 * JD-Core Version:    0.7.0.1
 */