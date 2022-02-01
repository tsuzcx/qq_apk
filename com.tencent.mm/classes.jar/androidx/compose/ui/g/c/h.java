package androidx.compose.ui.g.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/NodeParent;", "", "()V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/Node;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "clear", "", "dispatchCancel", "dispatchFinalEventPass", "", "dispatchMainEventPass", "changes", "", "Landroidx/compose/ui/input/pointer/PointerId;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "recursivelyRemovePointerId", "pointerId", "recursivelyRemovePointerId-0FcD4WY", "(J)V", "removeDetachedPointerInputFilters", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
{
  final e<g> aLh;
  
  public h()
  {
    AppMethodBeat.i(205854);
    this.aLh = new e(new g[16]);
    AppMethodBeat.o(205854);
  }
  
  public boolean a(Map<l, m> paramMap, j paramj, d paramd)
  {
    AppMethodBeat.i(205860);
    kotlin.g.b.s.u(paramMap, "changes");
    kotlin.g.b.s.u(paramj, "parentCoordinates");
    kotlin.g.b.s.u(paramd, "internalPointerEvent");
    Object localObject = this.aLh;
    int j = ((e)localObject).size;
    boolean bool;
    if (j > 0)
    {
      localObject = ((e)localObject).aqq;
      int i = 0;
      bool = false;
      if ((((g)localObject[i]).a(paramMap, paramj, paramd)) || (bool))
      {
        bool = true;
        label79:
        i += 1;
        if (i < j) {
          break label106;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205860);
      return bool;
      bool = false;
      break label79;
      label106:
      break;
      bool = false;
    }
  }
  
  public final void aq(long paramLong)
  {
    AppMethodBeat.i(205883);
    int i = 0;
    while (i < this.aLh.size)
    {
      g localg = (g)this.aLh.aqq[i];
      localg.aLd.remove(l.ar(paramLong));
      if (localg.aLd.isEmpty())
      {
        this.aLh.removeAt(i);
      }
      else
      {
        localg.aq(paramLong);
        i += 1;
      }
    }
    AppMethodBeat.o(205883);
  }
  
  public final void wl()
  {
    AppMethodBeat.i(205875);
    int i = 0;
    while (i < this.aLh.size)
    {
      g localg = (g)this.aLh.aqq[i];
      if (!localg.aLc.wp())
      {
        this.aLh.removeAt(i);
        localg.wn();
      }
      else
      {
        i += 1;
        localg.wl();
      }
    }
    AppMethodBeat.o(205875);
  }
  
  public boolean wm()
  {
    AppMethodBeat.i(205866);
    Object localObject = this.aLh;
    int j = ((e)localObject).size;
    boolean bool;
    if (j > 0)
    {
      localObject = ((e)localObject).aqq;
      int i = 0;
      bool = false;
      if ((((g)localObject[i]).wm()) || (bool))
      {
        bool = true;
        label51:
        i += 1;
        if (i < j) {
          break label72;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205866);
      return bool;
      bool = false;
      break label51;
      label72:
      break;
      bool = false;
    }
  }
  
  public void wn()
  {
    AppMethodBeat.i(205871);
    Object localObject = this.aLh;
    int j = ((e)localObject).size;
    int i;
    if (j > 0)
    {
      localObject = ((e)localObject).aqq;
      i = 0;
    }
    for (;;)
    {
      ((g)localObject[i]).wn();
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(205871);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.h
 * JD-Core Version:    0.7.0.1
 */