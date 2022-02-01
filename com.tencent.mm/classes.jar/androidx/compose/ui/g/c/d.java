package androidx.compose.ui.g.c;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "(Ljava/util/Map;Landroidx/compose/ui/input/pointer/PointerInputEvent;)V", "motionEvent", "Landroid/view/MotionEvent;", "(Ljava/util/Map;Landroid/view/MotionEvent;)V", "getChanges", "()Ljava/util/Map;", "getMotionEvent", "()Landroid/view/MotionEvent;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final Map<l, m> aKW;
  final MotionEvent aKX;
  
  private d(Map<l, m> paramMap, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205821);
    this.aKW = paramMap;
    this.aKX = paramMotionEvent;
    AppMethodBeat.o(205821);
  }
  
  public d(Map<l, m> paramMap, o paramo)
  {
    this(paramMap, paramo.aKX);
    AppMethodBeat.i(205828);
    AppMethodBeat.o(205828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.d
 * JD-Core Version:    0.7.0.1
 */