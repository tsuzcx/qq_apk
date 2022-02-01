package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/FlattenedPageEventStorage;", "T", "", "()V", "loadStates", "Landroidx/paging/MutableLoadStateCollection;", "pages", "Ljava/util/ArrayDeque;", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "placeholdersBefore", "add", "", "event", "Landroidx/paging/PageEvent;", "getAsEvents", "", "handleInsert", "Landroidx/paging/PageEvent$Insert;", "handleLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "handlePageDrop", "Landroidx/paging/PageEvent$Drop;", "paging-common"}, k=1, mv={1, 4, 2})
public final class p<T>
{
  int bMw;
  int bMx;
  final ArrayDeque<bn<T>> bMy;
  final af bMz;
  
  public p()
  {
    AppMethodBeat.i(197074);
    this.bMy = new ArrayDeque();
    this.bMz = new af();
    AppMethodBeat.o(197074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.p
 * JD-Core Version:    0.7.0.1
 */