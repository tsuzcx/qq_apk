package androidx.compose.ui.g.c;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "(Ljava/util/List;)V", "motionEvent", "Landroid/view/MotionEvent;", "(Ljava/util/List;Landroid/view/MotionEvent;)V", "getChanges", "()Ljava/util/List;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "component1", "component2", "component2$ui_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final int Ue = 8;
  final MotionEvent aKX;
  public final List<m> alK;
  
  public i(List<m> paramList)
  {
    this(paramList, null);
    AppMethodBeat.i(205861);
    AppMethodBeat.o(205861);
  }
  
  private i(List<m> paramList, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205849);
    this.alK = paramList;
    this.aKX = paramMotionEvent;
    AppMethodBeat.o(205849);
  }
  
  public i(List<m> paramList, d paramd) {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205882);
    if (this == paramObject)
    {
      AppMethodBeat.o(205882);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(205882);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.alK, paramObject.alK))
    {
      AppMethodBeat.o(205882);
      return false;
    }
    if (!s.p(this.aKX, paramObject.aKX))
    {
      AppMethodBeat.o(205882);
      return false;
    }
    AppMethodBeat.o(205882);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205876);
    int j = this.alK.hashCode();
    if (this.aKX == null) {}
    for (int i = 0;; i = this.aKX.hashCode())
    {
      AppMethodBeat.o(205876);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205873);
    String str = "PointerEvent(changes=" + this.alK + ", motionEvent=" + this.aKX + ')';
    AppMethodBeat.o(205873);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.i
 * JD-Core Version:    0.7.0.1
 */