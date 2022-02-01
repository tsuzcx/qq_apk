package androidx.compose.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DragEvent;", "", "()V", "DragCancelled", "DragDelta", "DragStarted", "DragStopped", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "Landroidx/compose/foundation/gestures/DragEvent$DragCancelled;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class c
{
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragCancelled;", "Landroidx/compose/foundation/gestures/DragEvent;", "()V", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
  {
    public static final a ZZ;
    
    static
    {
      AppMethodBeat.i(204163);
      ZZ = new a();
      AppMethodBeat.o(204163);
    }
    
    private a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Landroidx/compose/foundation/gestures/DragEvent;", "delta", "", "(F)V", "getDelta", "()F", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c
  {
    final float aaa;
    
    public b(float paramFloat)
    {
      super();
      this.aaa = paramFloat;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "Landroidx/compose/foundation/gestures/DragEvent;", "startPoint", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStartPoint-F1C5BW0", "()J", "J", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends c
  {
    final long aab;
    
    private c(long paramLong)
    {
      super();
      this.aab = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "Landroidx/compose/foundation/gestures/DragEvent;", "velocity", "", "(F)V", "getVelocity", "()F", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends c
  {
    final float aac;
    
    public d(float paramFloat)
    {
      super();
      this.aac = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.c
 * JD-Core Version:    0.7.0.1
 */