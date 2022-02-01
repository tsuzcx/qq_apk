package androidx.compose.foundation.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/PressInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Cancel", "Press", "Release", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
  extends b
{
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/PressInteraction$Cancel;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    public final g.b abH;
    
    public a(g.b paramb)
    {
      AppMethodBeat.i(203554);
      this.abH = paramb;
      AppMethodBeat.o(203554);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/foundation/interaction/PressInteraction;", "pressPosition", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPressPosition-F1C5BW0", "()J", "J", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    public final long abI;
    
    private b(long paramLong)
    {
      this.abI = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/PressInteraction$Release;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g
  {
    public final g.b abH;
    
    public c(g.b paramb)
    {
      AppMethodBeat.i(203548);
      this.abH = paramb;
      AppMethodBeat.o(203548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.b.g
 * JD-Core Version:    0.7.0.1
 */