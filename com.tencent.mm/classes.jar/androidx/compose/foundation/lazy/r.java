package androidx.compose.foundation.lazy;

import androidx.compose.ui.h.x.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "firstVisibleItem", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "firstVisibleItemScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "composedButNotVisibleItems", "", "layoutWidth", "layoutHeight", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "(Landroidx/compose/foundation/lazy/LazyMeasuredItem;IZFLjava/util/List;IILkotlin/jvm/functions/Function1;Ljava/util/List;III)V", "getCanScrollForward", "()Z", "getComposedButNotVisibleItems", "()Ljava/util/List;", "getConsumedScroll", "()F", "getFirstVisibleItem", "()Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "getFirstVisibleItemScrollOffset", "()I", "getLayoutHeight", "getLayoutWidth", "getPlacementBlock", "()Lkotlin/jvm/functions/Function1;", "getTotalItemsCount", "getViewportEndOffset", "getViewportStartOffset", "getVisibleItemsInfo", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements p
{
  final ac aeY;
  final int aeZ;
  final List<m> aem;
  private final int aen;
  final int aeo;
  final boolean afa;
  final float afb;
  final List<ac> afc;
  final int afd;
  final b<x.a, ah> afe;
  private final int aff;
  final int layoutWidth;
  
  public r(ac paramac, int paramInt1, boolean paramBoolean, float paramFloat, List<ac> paramList, int paramInt2, int paramInt3, b<? super x.a, ah> paramb, List<? extends m> paramList1, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(204225);
    this.aeY = paramac;
    this.aeZ = paramInt1;
    this.afa = paramBoolean;
    this.afb = paramFloat;
    this.afc = paramList;
    this.layoutWidth = paramInt2;
    this.afd = paramInt3;
    this.afe = paramb;
    this.aem = paramList1;
    this.aff = paramInt4;
    this.aen = paramInt5;
    this.aeo = paramInt6;
    AppMethodBeat.o(204225);
  }
  
  public final List<m> mE()
  {
    return this.aem;
  }
  
  public final int mF()
  {
    return this.aen;
  }
  
  public final int mG()
  {
    return this.aeo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.r
 * JD-Core Version:    0.7.0.1
 */