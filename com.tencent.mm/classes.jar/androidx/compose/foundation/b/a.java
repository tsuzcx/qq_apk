package androidx.compose.foundation.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/DragInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Cancel", "Start", "Stop", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends b
{
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/DragInteraction$Cancel;", "Landroidx/compose/foundation/interaction/DragInteraction;", "start", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "(Landroidx/compose/foundation/interaction/DragInteraction$Start;)V", "getStart", "()Landroidx/compose/foundation/interaction/DragInteraction$Start;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a
  {
    public final a.b abF;
    
    public a(a.b paramb)
    {
      AppMethodBeat.i(203561);
      this.abF = paramb;
      AppMethodBeat.o(203561);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/DragInteraction$Start;", "Landroidx/compose/foundation/interaction/DragInteraction;", "()V", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a
  {}
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/DragInteraction$Stop;", "Landroidx/compose/foundation/interaction/DragInteraction;", "start", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "(Landroidx/compose/foundation/interaction/DragInteraction$Start;)V", "getStart", "()Landroidx/compose/foundation/interaction/DragInteraction$Start;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a
  {
    public final a.b abF;
    
    public c(a.b paramb)
    {
      AppMethodBeat.i(203557);
      this.abF = paramb;
      AppMethodBeat.o(203557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.b.a
 * JD-Core Version:    0.7.0.1
 */