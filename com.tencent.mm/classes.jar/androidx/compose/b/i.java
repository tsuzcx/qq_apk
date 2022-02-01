package androidx.compose.b;

import androidx.compose.runtime.as;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.q;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalAbsoluteElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalElevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final as<h> aiA;
  private static final as<g> aiB;
  
  static
  {
    AppMethodBeat.i(201716);
    aiA = q.e((a)b.aiD);
    a locala = (a)a.aiC;
    aiB = q.a(bj.qi(), locala);
    AppMethodBeat.o(201716);
  }
  
  public static final as<h> nw()
  {
    return aiA;
  }
  
  public static final as<g> nx()
  {
    return aiB;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/Dp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<g>
  {
    public static final a aiC;
    
    static
    {
      AppMethodBeat.i(201743);
      aiC = new a();
      AppMethodBeat.o(201743);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/material/ElevationOverlay;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<h>
  {
    public static final b aiD;
    
    static
    {
      AppMethodBeat.i(201749);
      aiD = new b();
      AppMethodBeat.o(201749);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.i
 * JD-Core Version:    0.7.0.1
 */