package androidx.compose.ui.g.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "process-gBdvCQM", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;)I", "processCancel", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  private final f aLw;
  private final c aLx;
  private final n aLy;
  private final List<s> aLz;
  
  public q(f paramf)
  {
    AppMethodBeat.i(205818);
    this.aLw = paramf;
    this.aLx = new c((androidx.compose.ui.h.j)this.aLw.aOC);
    this.aLy = new n();
    this.aLz = ((List)new ArrayList());
    AppMethodBeat.o(205818);
  }
  
  public final int a(o paramo, z paramz)
  {
    AppMethodBeat.i(205826);
    kotlin.g.b.s.u(paramo, "pointerEvent");
    kotlin.g.b.s.u(paramz, "positionCalculator");
    Object localObject = this.aLy;
    kotlin.g.b.s.u(paramo, "pointerInputEvent");
    kotlin.g.b.s.u(paramz, "positionCalculator");
    Map localMap = (Map)new LinkedHashMap(paramo.aLa.size());
    List localList = paramo.aLa;
    int i = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      p localp = (p)localList.get(i);
      n.a locala = (n.a)((n)localObject).aLs.get(l.ar(localp.id));
      long l1;
      long l2;
      if (locala == null)
      {
        l1 = localp.aLt;
        l2 = localp.position;
        bool1 = false;
        localMap.put(l.ar(localp.id), new m(localp.id, localp.aLt, localp.position, localp.aLv, l1, l2, bool1, new b(false, 3), localp.type, (byte)0));
        if (!localp.aLv) {
          break label416;
        }
        ((n)localObject).aLs.put(l.ar(localp.id), new n.a(localp.aLt, localp.aLu, localp.aLv, (byte)0));
        label257:
        if (j <= k) {
          break label592;
        }
        paramo = new d(localMap, paramo);
        paramz = ((Iterable)paramo.aKW.values()).iterator();
      }
      label293:
      label441:
      for (;;)
      {
        if (!paramz.hasNext()) {
          break label443;
        }
        localObject = (m)paramz.next();
        if (j.b((m)localObject))
        {
          this.aLw.d(((m)localObject).position, this.aLz);
          if (!((Collection)this.aLz).isEmpty()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label441;
            }
            this.aLx.a(((m)localObject).id, this.aLz);
            this.aLz.clear();
            break label293;
            l1 = locala.aLt;
            bool1 = locala.aLv;
            l2 = paramz.as(locala.aLu);
            break;
            ((n)localObject).aLs.remove(l.ar(localp.id));
            break label257;
          }
        }
      }
      label416:
      label443:
      this.aLx.wl();
      paramz = this.aLx;
      kotlin.g.b.s.u(paramo, "internalPointerEvent");
      boolean bool1 = paramz.aKV.a(paramo.aKW, paramz.aKU, paramo);
      boolean bool2;
      if ((paramz.aKV.wm()) || (bool1))
      {
        bool2 = true;
        bool1 = false;
        paramo = ((Iterable)paramo.aKW.values()).iterator();
        label518:
        if (!paramo.hasNext()) {
          break label574;
        }
        paramz = (m)paramo.next();
        if (j.d(paramz)) {
          this.aLx.ap(paramz.id);
        }
        if (!j.g(paramz)) {
          break label589;
        }
        bool1 = true;
      }
      label574:
      label589:
      for (;;)
      {
        break label518;
        bool2 = false;
        break;
        i = r.f(bool2, bool1);
        AppMethodBeat.o(205826);
        return i;
      }
      label592:
      i = j;
    }
  }
  
  public final void wo()
  {
    AppMethodBeat.i(205832);
    this.aLy.aLs.clear();
    c localc = this.aLx;
    localc.aKV.wn();
    localc.aKV.aLh.clear();
    AppMethodBeat.o(205832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.q
 * JD-Core Version:    0.7.0.1
 */