package androidx.compose.ui.platform;

import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidViewConfiguration;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "(Landroid/view/ViewConfiguration;)V", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "touchSlop", "", "getTouchSlop", "()F", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements av
{
  public static final int Ue = 8;
  private final ViewConfiguration aTn;
  
  public q(ViewConfiguration paramViewConfiguration)
  {
    AppMethodBeat.i(206899);
    this.aTn = paramViewConfiguration;
    AppMethodBeat.o(206899);
  }
  
  public final long yQ()
  {
    AppMethodBeat.i(206910);
    long l = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(206910);
    return l;
  }
  
  public final long yR()
  {
    AppMethodBeat.i(206914);
    long l = ViewConfiguration.getDoubleTapTimeout();
    AppMethodBeat.o(206914);
    return l;
  }
  
  public final float yS()
  {
    AppMethodBeat.i(206919);
    float f = this.aTn.getScaledTouchSlop();
    AppMethodBeat.o(206919);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.q
 * JD-Core Version:    0.7.0.1
 */