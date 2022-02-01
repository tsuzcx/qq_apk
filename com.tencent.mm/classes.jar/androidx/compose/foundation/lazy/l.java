package androidx.compose.foundation.lazy;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.e.b;
import androidx.compose.runtime.e.d;
import androidx.compose.runtime.e.e.a;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"InitialLazyItemsScopeImpl", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "rememberItemContentFactory", "Landroidx/compose/foundation/lazy/LazyListItemContentFactory;", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/runtime/State;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/LazyListItemContentFactory;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  private static final i aeK;
  
  static
  {
    AppMethodBeat.i(204247);
    aeK = new i(androidx.compose.ui.n.f.H(0.0F, 0.0F), androidx.compose.ui.n.c.o(0, 0, 15), (byte)0);
    AppMethodBeat.o(204247);
  }
  
  public static final k a(bm<? extends n> parambm, aa paramaa, androidx.compose.runtime.h paramh)
  {
    AppMethodBeat.i(204231);
    s.u(parambm, "stateOfItemsProvider");
    s.u(paramaa, "state");
    paramh.bx(149230656);
    paramh.bx(-579869653);
    Object localObject1 = d.arN;
    localObject1 = d.mm();
    Object localObject2 = (a)e.a.asa;
    localObject1 = b.a(new Object[0], (androidx.compose.runtime.e.i)localObject1, (a)localObject2, paramh, 4);
    ((d)localObject1).arQ = ((androidx.compose.runtime.e.f)paramh.a((p)androidx.compose.runtime.e.h.rd()));
    localObject1 = (d)localObject1;
    paramh.od();
    androidx.compose.runtime.e.c localc = (androidx.compose.runtime.e.c)localObject1;
    paramh.bx(-3686930);
    boolean bool = paramh.G(parambm);
    localObject2 = paramh.or();
    if (!bool)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new k(localc, parambm);
      paramh.F(localObject1);
    }
    paramh.od();
    parambm = (k)localObject1;
    s.u(paramaa, "state");
    localObject1 = (n)parambm.aeD.getValue();
    int j = ((n)localObject1).getItemsCount();
    int i;
    int k;
    if (j > 0)
    {
      paramaa.b((n)localObject1);
      i = paramaa.afS.index;
      k = Math.min(j, paramaa.afV + i);
      if (i >= k) {}
    }
    for (;;)
    {
      j = i + 1;
      paramaa = ((n)localObject1).bu(i);
      paramaa = (k.a)parambm.aeE.get(paramaa);
      if (paramaa != null) {
        paramaa.aeH.setValue(Integer.valueOf(i));
      }
      if (j >= k)
      {
        paramh.od();
        AppMethodBeat.o(204231);
        return parambm;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.l
 * JD-Core Version:    0.7.0.1
 */