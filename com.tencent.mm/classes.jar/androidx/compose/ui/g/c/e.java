package androidx.compose.ui.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "()V", "motionEventToComposePointerIdMap", "", "", "Landroidx/compose/ui/input/pointer/PointerId;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Ljava/util/Map;", "nextId", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "createPointerInputEventData", "index", "downIndex", "upIndex", "(Landroidx/compose/ui/input/pointer/PositionCalculator;Landroid/view/MotionEvent;ILjava/lang/Integer;Ljava/lang/Integer;)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public long aKY;
  public final Map<Integer, l> aKZ;
  public final List<p> aLa;
  
  public e()
  {
    AppMethodBeat.i(205825);
    this.aKZ = ((Map)new LinkedHashMap());
    this.aLa = ((List)new ArrayList());
    AppMethodBeat.o(205825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.e
 * JD-Core Version:    0.7.0.1
 */