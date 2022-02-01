package androidx.compose.foundation.lazy;

import androidx.compose.ui.h.ag;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.x;
import androidx.compose.ui.n.b;
import androidx.compose.ui.n.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "scope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "itemsProvider", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "itemContentFactory", "Landroidx/compose/foundation/lazy/LazyListItemContentFactory;", "measuredItemFactory", "Landroidx/compose/foundation/lazy/MeasuredItemFactory;", "(JZLandroidx/compose/ui/layout/SubcomposeMeasureScope;Landroidx/compose/foundation/lazy/LazyListItemsProvider;Landroidx/compose/foundation/lazy/LazyListItemContentFactory;Landroidx/compose/foundation/lazy/MeasuredItemFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "childConstraints", "getChildConstraints-msEJaDk", "()J", "J", "getAndMeasure", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/DataIndex;", "getAndMeasure-ZjPyQlc", "(I)Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  private final k afk;
  private final ag agt;
  private final n agu;
  private final af agv;
  final long agw;
  
  private ad(long paramLong, boolean paramBoolean, ag paramag, n paramn, k paramk, af paramaf)
  {
    AppMethodBeat.i(204268);
    this.agt = paramag;
    this.agu = paramn;
    this.afk = paramk;
    this.agv = paramaf;
    if (paramBoolean) {}
    for (int i = b.aU(paramLong);; i = 2147483647)
    {
      if (!paramBoolean) {
        j = b.aW(paramLong);
      }
      this.agw = c.o(i, j, 5);
      AppMethodBeat.o(204268);
      return;
    }
  }
  
  public final ac bv(int paramInt)
  {
    AppMethodBeat.i(204276);
    Object localObject1 = this.agu.bu(paramInt);
    Object localObject2 = this.afk.f(paramInt, localObject1);
    localObject2 = this.agt.d(localObject1, (m)localObject2);
    int j = ((List)localObject2).size();
    x[] arrayOfx = new x[j];
    int i = 0;
    while (i < j)
    {
      arrayOfx[i] = ((o)((List)localObject2).get(i)).aw(this.agw);
      i += 1;
    }
    localObject1 = this.agv.a(paramInt, localObject1, arrayOfx);
    AppMethodBeat.o(204276);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.ad
 * JD-Core Version:    0.7.0.1
 */