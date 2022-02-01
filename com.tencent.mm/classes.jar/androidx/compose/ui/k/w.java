package androidx.compose.ui.k;

import androidx.compose.ui.f.c;
import androidx.compose.ui.i.b;
import androidx.compose.ui.i.f;
import androidx.compose.ui.i.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "semanticsModifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/semantics/SemanticsModifier;)V", "collapsedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "detach", "", "hitTestSemantics", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitSemanticsWrappers", "", "hitTestSemantics-3MmeM6k", "(JLjava/util/List;)V", "onModifierChanged", "toString", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends b<l>
{
  public w(androidx.compose.ui.i.j paramj, l paraml)
  {
    super(paramj, (f.c)paraml);
    AppMethodBeat.i(205452);
    AppMethodBeat.o(205452);
  }
  
  public final j AE()
  {
    AppMethodBeat.i(205459);
    Object localObject1 = this.aNN;
    if (localObject1 != null) {
      if (!(localObject1 instanceof w)) {}
    }
    for (localObject1 = (w)localObject1;; localObject1 = null)
    {
      if ((localObject1 != null) && (!((l)wb()).zV().aXe)) {
        break label81;
      }
      localObject1 = ((l)wb()).zV();
      AppMethodBeat.o(205459);
      return localObject1;
      localObject1 = ((androidx.compose.ui.i.j)localObject1).xg();
      break;
    }
    label81:
    j localj = ((l)wb()).zV().zU();
    localObject1 = ((w)localObject1).AE();
    s.u(localObject1, "peer");
    if (((j)localObject1).aXd) {
      localj.aXd = true;
    }
    if (((j)localObject1).aXe) {
      localj.aXe = true;
    }
    Iterator localIterator = ((j)localObject1).aXc.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      t localt = (t)((Map.Entry)localObject1).getKey();
      Object localObject4 = ((Map.Entry)localObject1).getValue();
      if (!localj.aXc.containsKey(localt))
      {
        localj.aXc.put(localt, localObject4);
      }
      else if ((localObject4 instanceof a))
      {
        localObject1 = localj.aXc.get(localt);
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
          AppMethodBeat.o(205459);
          throw ((Throwable)localObject1);
        }
        Object localObject3 = (a)localObject1;
        Map localMap = localj.aXc;
        Object localObject2 = ((a)localObject3).label;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((a)localObject4).label;
        }
        localObject3 = ((a)localObject3).aWk;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = ((a)localObject4).aWk;
        }
        localMap.put(localt, new a((String)localObject1, (d)localObject2));
      }
    }
    AppMethodBeat.o(205459);
    return localj;
  }
  
  public final void c(long paramLong, List<w> paramList)
  {
    AppMethodBeat.i(205475);
    s.u(paramList, "hitSemanticsWrappers");
    if ((aE(paramLong)) && (aD(paramLong)))
    {
      paramList.add(this);
      paramLong = this.aNN.aC(paramLong);
      this.aNN.c(paramLong, paramList);
    }
    AppMethodBeat.o(205475);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(205464);
    super.detach();
    y localy = this.aOb.aOl;
    if (localy != null) {
      localy.ym();
    }
    AppMethodBeat.o(205464);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205471);
    String str = super.toString() + " id: " + ((l)wb()).getId() + " config: " + ((l)wb()).zV();
    AppMethodBeat.o(205471);
    return str;
  }
  
  public final void vV()
  {
    AppMethodBeat.i(205469);
    super.vV();
    y localy = this.aOb.aOl;
    if (localy != null) {
      localy.ym();
    }
    AppMethodBeat.o(205469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.w
 * JD-Core Version:    0.7.0.1
 */