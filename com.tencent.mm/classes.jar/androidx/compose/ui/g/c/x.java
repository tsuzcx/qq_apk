package androidx.compose.ui.g.c;

import android.view.MotionEvent;
import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"emptyCancelMotionEventScope", "", "nowMillis", "", "block", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "toCancelMotionEventScope", "Landroidx/compose/ui/input/pointer/PointerEvent;", "offset", "Landroidx/compose/ui/geometry/Offset;", "toCancelMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;)V", "toMotionEventScope", "toMotionEventScope-d-4ec7I", "cancel", "", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;Z)V", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final void a(i parami, long paramLong, b<? super MotionEvent, ah> paramb)
  {
    AppMethodBeat.i(205907);
    s.u(parami, "$this$toMotionEventScope");
    s.u(paramb, "block");
    a(parami, paramLong, paramb, false);
    AppMethodBeat.o(205907);
  }
  
  private static final void a(i parami, long paramLong, b<? super MotionEvent, ah> paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(205914);
    if (parami.aKX == null)
    {
      parami = (Throwable)new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
      AppMethodBeat.o(205914);
      throw parami;
    }
    parami = parami.aKX;
    int i = parami.getAction();
    if (paramBoolean) {
      parami.setAction(3);
    }
    parami.offsetLocation(-e.F(paramLong), -e.G(paramLong));
    paramb.invoke(parami);
    parami.offsetLocation(e.F(paramLong), e.G(paramLong));
    parami.setAction(i);
    AppMethodBeat.o(205914);
  }
  
  public static final void b(i parami, long paramLong, b<? super MotionEvent, ah> paramb)
  {
    AppMethodBeat.i(205911);
    s.u(parami, "$this$toCancelMotionEventScope");
    s.u(paramb, "block");
    a(parami, paramLong, paramb, true);
    AppMethodBeat.o(205911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.x
 * JD-Core Version:    0.7.0.1
 */