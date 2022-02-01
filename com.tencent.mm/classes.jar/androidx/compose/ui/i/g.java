package androidx.compose.ui.i;

import androidx.compose.ui.h.b;
import androidx.compose.ui.h.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "dirty", "", "getDirty$ui_release", "()Z", "setDirty$ui_release", "(Z)V", "previousUsedDuringParentLayout", "getPreviousUsedDuringParentLayout$ui_release", "setPreviousUsedDuringParentLayout$ui_release", "queried", "getQueried$ui_release", "queryOwner", "required", "getRequired$ui_release", "usedByModifierLayout", "getUsedByModifierLayout$ui_release", "setUsedByModifierLayout$ui_release", "usedByModifierMeasurement", "getUsedByModifierMeasurement$ui_release", "setUsedByModifierMeasurement$ui_release", "usedDuringParentLayout", "getUsedDuringParentLayout$ui_release", "setUsedDuringParentLayout$ui_release", "usedDuringParentMeasurement", "getUsedDuringParentMeasurement$ui_release", "setUsedDuringParentMeasurement$ui_release", "getLastCalculation", "", "recalculate", "", "recalculateQueryOwner", "recalculateQueryOwner$ui_release", "reset", "reset$ui_release", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  final Map<androidx.compose.ui.h.a, Integer> aMO;
  private final f aOb;
  boolean aPb;
  boolean aPc;
  boolean aPd;
  boolean aPe;
  boolean aPf;
  f aPg;
  boolean dirty;
  
  public g(f paramf)
  {
    AppMethodBeat.i(204487);
    this.aOb = paramf;
    this.dirty = true;
    this.aMO = ((Map)new HashMap());
    AppMethodBeat.o(204487);
  }
  
  private static final void a(g paramg, androidx.compose.ui.h.a parama, int paramInt, j paramj)
  {
    AppMethodBeat.i(204499);
    long l = androidx.compose.ui.d.f.x(paramInt, paramInt);
    for (;;)
    {
      l = paramj.aB(l);
      j localj = paramj.aPj;
      s.checkNotNull(localj);
      if (s.p(localj, paramg.aOb.aOC)) {
        break;
      }
      paramj = localj;
      if (localj.xU().contains(parama))
      {
        paramInt = localj.b(parama);
        l = androidx.compose.ui.d.f.x(paramInt, paramInt);
        paramj = localj;
      }
    }
    if ((parama instanceof androidx.compose.ui.h.g)) {}
    for (paramInt = kotlin.h.a.eH(androidx.compose.ui.d.e.G(l));; paramInt = kotlin.h.a.eH(androidx.compose.ui.d.e.F(l)))
    {
      paramj = paramg.aMO;
      int i = paramInt;
      if (paramg.aMO.containsKey(parama)) {
        i = b.a(parama, ((Number)ak.e(paramg.aMO, parama)).intValue(), paramInt);
      }
      paramj.put(parama, Integer.valueOf(i));
      AppMethodBeat.o(204499);
      return;
    }
  }
  
  private boolean xN()
  {
    return (this.aPb) || (this.aPd) || (this.aPe) || (this.aPf);
  }
  
  public final boolean xO()
  {
    AppMethodBeat.i(204505);
    xP();
    if (this.aPg != null)
    {
      AppMethodBeat.o(204505);
      return true;
    }
    AppMethodBeat.o(204505);
    return false;
  }
  
  public final void xP()
  {
    AppMethodBeat.i(204511);
    Object localObject1;
    if (xN()) {
      localObject1 = this.aOb;
    }
    for (;;)
    {
      this.aPg = ((f)localObject1);
      AppMethodBeat.o(204511);
      return;
      localObject1 = this.aOb.xu();
      if (localObject1 == null)
      {
        AppMethodBeat.o(204511);
        return;
      }
      Object localObject2 = ((f)localObject1).aOu.aPg;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((f)localObject2).aOu.xN()) {}
      }
      else
      {
        localObject1 = this.aPg;
        if ((localObject1 == null) || (((f)localObject1).aOu.xN()))
        {
          AppMethodBeat.o(204511);
          return;
        }
        localObject2 = ((f)localObject1).xu();
        if (localObject2 != null)
        {
          localObject2 = ((f)localObject2).aOu;
          if (localObject2 != null) {
            ((g)localObject2).xP();
          }
        }
        localObject1 = ((f)localObject1).xu();
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((f)localObject1).aOu;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((g)localObject1).aPg;
          }
        }
      }
    }
  }
  
  public final void xQ()
  {
    AppMethodBeat.i(204518);
    this.aMO.clear();
    Object localObject1 = this.aOb.xr();
    int j = ((androidx.compose.runtime.a.e)localObject1).size;
    Object[] arrayOfObject;
    int i;
    if (j > 0)
    {
      arrayOfObject = ((androidx.compose.runtime.a.e)localObject1).aqq;
      i = 0;
    }
    for (;;)
    {
      localObject1 = (f)arrayOfObject[i];
      if (((f)localObject1).aOw)
      {
        if (((f)localObject1).aOu.dirty) {
          ((f)localObject1).xB();
        }
        Iterator localIterator = ((f)localObject1).aOu.aMO.entrySet().iterator();
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (Map.Entry)localIterator.next();
          a(this, (androidx.compose.ui.h.a)((Map.Entry)localObject2).getKey(), ((Number)((Map.Entry)localObject2).getValue()).intValue(), ((f)localObject1).aOC);
        }
        localObject1 = ((f)localObject1).aOC.aPj;
        s.checkNotNull(localObject1);
        while (!s.p(localObject1, this.aOb.aOC))
        {
          localIterator = ((Iterable)((j)localObject1).xU()).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (androidx.compose.ui.h.a)localIterator.next();
            a(this, (androidx.compose.ui.h.a)localObject2, ((j)localObject1).b((androidx.compose.ui.h.a)localObject2), (j)localObject1);
          }
          localObject1 = ((j)localObject1).aPj;
          s.checkNotNull(localObject1);
        }
      }
      i += 1;
      if (i >= j)
      {
        this.aMO.putAll(this.aOb.aOC.xT().wL());
        this.dirty = false;
        AppMethodBeat.o(204518);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.g
 * JD-Core Version:    0.7.0.1
 */