package androidx.compose.foundation.f.a;

import androidx.compose.runtime.as;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"LocalSelectionRegistrar", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "getLocalSelectionRegistrar", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "hasSelection", "", "selectableId", "", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final as<g> ahQ;
  
  static
  {
    AppMethodBeat.i(203750);
    a locala = (a)h.a.ahR;
    ahQ = q.a(bj.qi(), locala);
    AppMethodBeat.o(203750);
  }
  
  public static final boolean a(g paramg, long paramLong)
  {
    AppMethodBeat.i(203744);
    if (paramg == null)
    {
      AppMethodBeat.o(203744);
      return false;
    }
    boolean bool = paramg.mZ().containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(203744);
    return bool;
  }
  
  public static final as<g> nc()
  {
    return ahQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.a.h
 * JD-Core Version:    0.7.0.1
 */