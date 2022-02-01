package androidx.compose.foundation.f.a;

import androidx.compose.runtime.as;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.q;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DefaultSelectionColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getDefaultTextSelectionColors$annotations", "()V", "LocalTextSelectionColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextSelectionColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final as<i> ahU;
  private static final long ahV;
  private static final i ahW;
  
  static
  {
    AppMethodBeat.i(203759);
    a locala = (a)a.ahX;
    ahU = q.a(bj.qi(), locala);
    ahV = ab.af(4282550004L);
    long l = ahV;
    ahW = new i(l, z.g(l, 0.4F), (byte)0);
    AppMethodBeat.o(203759);
  }
  
  public static final as<i> nd()
  {
    return ahU;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/foundation/text/selection/TextSelectionColors;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<i>
  {
    public static final a ahX;
    
    static
    {
      AppMethodBeat.i(203745);
      ahX = new a();
      AppMethodBeat.o(203745);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.a.j
 * JD-Core Version:    0.7.0.1
 */