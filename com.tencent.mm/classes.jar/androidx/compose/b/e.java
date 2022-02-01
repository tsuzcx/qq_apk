package androidx.compose.b;

import androidx.compose.runtime.as;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.q;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalContentColor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/graphics/Color;", "getLocalContentColor", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final as<z> aiu;
  
  static
  {
    AppMethodBeat.i(201702);
    a locala = (a)a.aiv;
    aiu = q.a(bj.qi(), locala);
    AppMethodBeat.o(201702);
  }
  
  public static final as<z> nv()
  {
    return aiu;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/graphics/Color;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<z>
  {
    public static final a aiv;
    
    static
    {
      AppMethodBeat.i(201744);
      aiv = new a();
      AppMethodBeat.o(201744);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.e
 * JD-Core Version:    0.7.0.1
 */