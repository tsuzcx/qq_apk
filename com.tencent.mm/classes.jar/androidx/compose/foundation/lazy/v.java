package androidx.compose.foundation.lazy;

import android.view.View;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.h.af;
import androidx.compose.ui.platform.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"LazyListPrefetcher", "", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "itemContentFactory", "Landroidx/compose/foundation/lazy/LazyListItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/State;Landroidx/compose/foundation/lazy/LazyListItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final void a(aa paramaa, final bm<? extends n> parambm, final k paramk, final af paramaf, h paramh, final int paramInt)
  {
    AppMethodBeat.i(204215);
    s.u(paramaa, "lazyListState");
    s.u(parambm, "stateOfItemsProvider");
    s.u(paramk, "itemContentFactory");
    s.u(paramaf, "subcomposeLayoutState");
    paramh = paramh.by(-2138645958);
    View localView = (View)paramh.a((p)j.yL());
    int i = af.Ue;
    paramh.bx(-3686095);
    boolean bool1 = paramh.G(paramaf);
    boolean bool2 = paramh.G(paramaa);
    boolean bool3 = paramh.G(localView);
    Object localObject = paramh.or();
    if (!(bool1 | bool2 | bool3))
    {
      h.a locala = h.alD;
      if (localObject != h.a.ox()) {}
    }
    else
    {
      paramh.F(new u(paramaf, paramaa, parambm, paramk, localView));
    }
    paramh.od();
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new a(paramaa, parambm, paramk, paramaf, paramInt));
    }
    AppMethodBeat.o(204215);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    a(aa paramaa, bm<? extends n> parambm, k paramk, af paramaf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.v
 * JD-Core Version:    0.7.0.1
 */