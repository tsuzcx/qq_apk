package androidx.compose.ui.g.c;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/MotionEventHelper;", "", "()V", "toRawOffset", "Landroidx/compose/ui/geometry/Offset;", "motionEvent", "Landroid/view/MotionEvent;", "index", "", "toRawOffset-dBAh8RU", "(Landroid/view/MotionEvent;I)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f aLb;
  
  static
  {
    AppMethodBeat.i(205823);
    aLb = new f();
    AppMethodBeat.o(205823);
  }
  
  public final long b(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(205830);
    s.u(paramMotionEvent, "motionEvent");
    long l = androidx.compose.ui.d.f.x(paramMotionEvent.getRawX(paramInt), paramMotionEvent.getRawY(paramInt));
    AppMethodBeat.o(205830);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.f
 * JD-Core Version:    0.7.0.1
 */