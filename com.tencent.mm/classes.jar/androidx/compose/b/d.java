package androidx.compose.b;

import androidx.compose.runtime.as;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"LocalContentAlpha", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalContentAlpha", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final as<Float> ais;
  
  static
  {
    AppMethodBeat.i(201704);
    a locala = (a)d.a.ait;
    ais = q.a(bj.qi(), locala);
    AppMethodBeat.o(201704);
  }
  
  public static final as<Float> nu()
  {
    return ais;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.d
 * JD-Core Version:    0.7.0.1
 */