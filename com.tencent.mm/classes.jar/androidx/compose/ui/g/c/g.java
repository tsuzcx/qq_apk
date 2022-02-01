package androidx.compose.ui.g.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "(Landroidx/compose/ui/input/pointer/PointerInputFilter;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "buildCache", "", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends h
{
  final s aLc;
  final e<l> aLd;
  private final Map<l, m> aLe;
  private j aLf;
  private i aLg;
  
  public g(s params)
  {
    AppMethodBeat.i(205834);
    this.aLc = params;
    this.aLd = new e(new l[16]);
    this.aLe = ((Map)new LinkedHashMap());
    AppMethodBeat.o(205834);
  }
  
  public final boolean a(Map<l, m> paramMap, j paramj, d paramd)
  {
    AppMethodBeat.i(205842);
    kotlin.g.b.s.u(paramMap, "changes");
    kotlin.g.b.s.u(paramj, "parentCoordinates");
    kotlin.g.b.s.u(paramd, "internalPointerEvent");
    Object localObject1;
    Map localMap;
    Object localObject2;
    if (this.aLc.wp())
    {
      this.aLf = this.aLc.ahy;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject1 = (Map.Entry)paramMap.next();
        l = ((l)((Map.Entry)localObject1).getKey()).value;
        localObject1 = (m)((Map.Entry)localObject1).getValue();
        if (this.aLd.contains(l.ar(l)))
        {
          localMap = this.aLe;
          localObject2 = l.ar(l);
          j localj = this.aLf;
          kotlin.g.b.s.checkNotNull(localj);
          l = localj.a(paramj, ((m)localObject1).aLp);
          localj = this.aLf;
          kotlin.g.b.s.checkNotNull(localj);
          localMap.put(localObject2, m.a((m)localObject1, 0L, 0L, localj.a(paramj, ((m)localObject1).position), false, 0L, l, false, null, 0, 475));
        }
      }
      if (!this.aLe.isEmpty()) {
        this.aLg = new i(p.p((Iterable)this.aLe.values()), paramd);
      }
    }
    if (this.aLe.isEmpty())
    {
      AppMethodBeat.o(205842);
      return false;
    }
    if (!this.aLc.wp())
    {
      AppMethodBeat.o(205842);
      return false;
    }
    paramMap = this.aLg;
    kotlin.g.b.s.checkNotNull(paramMap);
    paramj = this.aLf;
    kotlin.g.b.s.checkNotNull(paramj);
    long l = paramj.wj();
    this.aLc.a(paramMap, k.aLi, l);
    int j;
    int i;
    if (this.aLc.wp())
    {
      paramj = this.aLh;
      j = paramj.size;
      if (j > 0)
      {
        paramj = paramj.aqq;
        i = 0;
      }
    }
    for (;;)
    {
      localObject1 = (g)paramj[i];
      localMap = this.aLe;
      localObject2 = this.aLf;
      kotlin.g.b.s.checkNotNull(localObject2);
      ((g)localObject1).a(localMap, (j)localObject2, paramd);
      i += 1;
      if (i >= j)
      {
        if (this.aLc.wp()) {
          this.aLc.a(paramMap, k.aLj, l);
        }
        AppMethodBeat.o(205842);
        return true;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205857);
    String str = "Node(pointerInputFilter=" + this.aLc + ", children=" + this.aLh + ", pointerIds=" + this.aLd + ')';
    AppMethodBeat.o(205857);
    return str;
  }
  
  public final boolean wm()
  {
    boolean bool = false;
    AppMethodBeat.i(205848);
    if (this.aLe.isEmpty()) {}
    while (!this.aLc.wp())
    {
      this.aLe.clear();
      this.aLf = null;
      this.aLg = null;
      AppMethodBeat.o(205848);
      return bool;
    }
    Object localObject = this.aLg;
    kotlin.g.b.s.checkNotNull(localObject);
    j localj = this.aLf;
    kotlin.g.b.s.checkNotNull(localj);
    long l = localj.wj();
    this.aLc.a((i)localObject, k.aLk, l);
    int j;
    int i;
    if (this.aLc.wp())
    {
      localObject = this.aLh;
      j = ((e)localObject).size;
      if (j > 0)
      {
        localObject = ((e)localObject).aqq;
        i = 0;
      }
    }
    for (;;)
    {
      ((g)localObject[i]).wm();
      i += 1;
      if (i >= j)
      {
        bool = true;
        break;
      }
    }
  }
  
  public final void wn()
  {
    AppMethodBeat.i(205852);
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
        this.aLc.onCancel();
        AppMethodBeat.o(205852);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.g
 * JD-Core Version:    0.7.0.1
 */