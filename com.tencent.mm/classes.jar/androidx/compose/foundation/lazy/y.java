package androidx.compose.foundation.lazy;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/DataIndex;", "index", "getIndex-jQJCoq8", "()I", "I", "indexState", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "observableIndex", "getObservableIndex", "observableScrollOffset", "getObservableScrollOffset", "scrollOffset", "getScrollOffset", "scrollOffsetState", "requestPosition", "", "requestPosition-AhXoVpI", "update", "update-AhXoVpI", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemsProvider", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "Companion", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  private static final y.a afB;
  int afC;
  private final an<Integer> afD;
  private final an<Integer> afE;
  boolean afF;
  Object afG;
  int index;
  
  static
  {
    AppMethodBeat.i(204241);
    afB = new y.a((byte)0);
    AppMethodBeat.o(204241);
  }
  
  public y(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204226);
    this.index = paramInt1;
    this.afC = paramInt2;
    this.afD = bj.T(Integer.valueOf(this.index));
    this.afE = bj.T(Integer.valueOf(this.afC));
    AppMethodBeat.o(204226);
  }
  
  public final void D(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204263);
    E(paramInt1, paramInt2);
    this.afG = null;
    AppMethodBeat.o(204263);
  }
  
  final void E(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(204281);
    if (paramInt1 >= 0.0F) {}
    Throwable localThrowable;
    for (int i = 1; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException(("Index should be non-negative (" + paramInt1 + ')').toString());
      AppMethodBeat.o(204281);
      throw localThrowable;
    }
    if (paramInt2 >= 0.0F) {}
    for (i = j; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException(("scrollOffset should be non-negative (" + paramInt2 + ')').toString());
      AppMethodBeat.o(204281);
      throw localThrowable;
    }
    if (!a.C(paramInt1, this.index))
    {
      this.index = paramInt1;
      this.afD.setValue(Integer.valueOf(paramInt1));
    }
    if (paramInt2 != this.afC)
    {
      this.afC = paramInt2;
      this.afE.setValue(Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(204281);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(204272);
    s.u(paramn, "itemsProvider");
    Object localObject = this.afG;
    int m = this.index;
    int n;
    int j;
    int i;
    int k;
    if (localObject != null)
    {
      n = paramn.getItemsCount();
      if ((m >= n) || (!s.p(localObject, paramn.bu(m))))
      {
        j = Math.min(n - 1, m - 1);
        i = m + 1;
        if ((j >= 0) || (i < n))
        {
          k = j;
          if (j >= 0) {
            if (!s.p(localObject, paramn.bu(j))) {}
          }
        }
      }
    }
    for (;;)
    {
      E(j, this.afC);
      AppMethodBeat.o(204272);
      return;
      k = j - 1;
      j = k;
      if (i >= n) {
        break;
      }
      if (s.p(localObject, paramn.bu(i)))
      {
        j = i;
      }
      else
      {
        i += 1;
        j = k;
        break;
        j = m;
      }
    }
  }
  
  public final int mM()
  {
    AppMethodBeat.i(204248);
    int i = ((Number)this.afD.getValue()).intValue();
    AppMethodBeat.o(204248);
    return i;
  }
  
  public final int mN()
  {
    AppMethodBeat.i(204255);
    int i = ((Number)this.afE.getValue()).intValue();
    AppMethodBeat.o(204255);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.y
 * JD-Core Version:    0.7.0.1
 */