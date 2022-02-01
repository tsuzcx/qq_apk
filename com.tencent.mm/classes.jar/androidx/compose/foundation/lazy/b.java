package androidx.compose.foundation.lazy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/EmptyLazyListLayoutInfo;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "()V", "totalItemsCount", "", "getTotalItemsCount", "()I", "viewportEndOffset", "getViewportEndOffset", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  implements p
{
  public static final b ael;
  private static final List<m> aem;
  private static final int aen = 0;
  private static final int aeo = 0;
  
  static
  {
    AppMethodBeat.i(204219);
    ael = new b();
    aem = (List)ab.aivy;
    AppMethodBeat.o(204219);
  }
  
  public final List<m> mE()
  {
    return aem;
  }
  
  public final int mF()
  {
    return aen;
  }
  
  public final int mG()
  {
    return aeo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.b
 * JD-Core Version:    0.7.0.1
 */