package androidx.compose.ui.g.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "addHitPath-KNwqfcY", "(JLjava/util/List;)V", "dispatchChanges", "", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "processCancel", "removeDetachedPointerInputFilters", "removeHitPath", "removeHitPath-0FcD4WY", "(J)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final j aKU;
  final h aKV;
  
  public c(j paramj)
  {
    AppMethodBeat.i(205835);
    this.aKU = paramj;
    this.aKV = new h();
    AppMethodBeat.o(205835);
  }
  
  public final void a(long paramLong, List<? extends s> paramList)
  {
    AppMethodBeat.i(205840);
    kotlin.g.b.s.u(paramList, "pointerInputFilters");
    h localh = this.aKV;
    int m = paramList.size() - 1;
    int j;
    int i;
    int k;
    s locals;
    Object localObject;
    int n;
    Object[] arrayOfObject;
    if (m >= 0)
    {
      j = 0;
      i = 1;
      k = j + 1;
      locals = (s)paramList.get(j);
      j = i;
      if (i == 0) {
        break label200;
      }
      localObject = localh.aLh;
      n = ((e)localObject).size;
      if (n <= 0) {
        break label191;
      }
      arrayOfObject = ((e)localObject).aqq;
      j = 0;
    }
    label256:
    for (;;)
    {
      localObject = arrayOfObject[j];
      if (kotlin.g.b.s.p(((g)localObject).aLc, locals))
      {
        localObject = (g)localObject;
        if (localObject == null) {
          break label197;
        }
        if (!((g)localObject).aLd.contains(l.ar(paramLong))) {
          ((g)localObject).aLd.add(l.ar(paramLong));
        }
        localh = (h)localObject;
      }
      for (;;)
      {
        if (k <= m) {
          break label249;
        }
        AppMethodBeat.o(205840);
        return;
        j += 1;
        if (j < n) {
          break label256;
        }
        label191:
        localObject = null;
        break;
        label197:
        j = 0;
        label200:
        localObject = new g(locals);
        ((g)localObject).aLd.add(l.ar(paramLong));
        localh.aLh.add(localObject);
        localh = (h)localObject;
        i = j;
      }
      label249:
      j = k;
      break;
    }
  }
  
  public final void ap(long paramLong)
  {
    AppMethodBeat.i(205845);
    this.aKV.aq(paramLong);
    AppMethodBeat.o(205845);
  }
  
  public final void wl()
  {
    AppMethodBeat.i(205850);
    this.aKV.wl();
    AppMethodBeat.o(205850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.c
 * JD-Core Version:    0.7.0.1
 */