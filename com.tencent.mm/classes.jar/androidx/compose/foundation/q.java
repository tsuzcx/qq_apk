package androidx.compose.foundation;

import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/NoIndication;", "Landroidx/compose/foundation/Indication;", "()V", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "NoIndicationInstance", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class q
  implements k
{
  public static final q Zi;
  
  static
  {
    AppMethodBeat.i(203524);
    Zi = new q();
    AppMethodBeat.o(203524);
  }
  
  public final l a(androidx.compose.foundation.b.c paramc, h paramh)
  {
    AppMethodBeat.i(203530);
    s.u(paramc, "interactionSource");
    paramh.bx(-325005537);
    paramc = a.Zj;
    paramh.od();
    paramc = (l)paramc;
    AppMethodBeat.o(203530);
    return paramc;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/NoIndication$NoIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "()V", "drawIndication", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements l
  {
    public static final a Zj;
    
    static
    {
      AppMethodBeat.i(203661);
      Zj = new a();
      AppMethodBeat.o(203661);
    }
    
    public final void b(androidx.compose.ui.e.b.c paramc)
    {
      AppMethodBeat.i(203667);
      s.u(paramc, "<this>");
      paramc.uK();
      AppMethodBeat.o(203667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.q
 * JD-Core Version:    0.7.0.1
 */