package androidx.compose.ui.g.c;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputEvent;", "", "uptime", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "motionEvent", "Landroid/view/MotionEvent;", "(JLjava/util/List;Landroid/view/MotionEvent;)V", "getMotionEvent", "()Landroid/view/MotionEvent;", "getPointers", "()Ljava/util/List;", "getUptime", "()J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  final MotionEvent aKX;
  final List<p> aLa;
  private final long aLt;
  
  public o(long paramLong, List<p> paramList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205808);
    this.aLt = paramLong;
    this.aLa = paramList;
    this.aKX = paramMotionEvent;
    AppMethodBeat.o(205808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.o
 * JD-Core Version:    0.7.0.1
 */