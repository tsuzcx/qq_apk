package androidx.compose.foundation.lazy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/ItemFoundInScroll;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "item", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "(Landroidx/compose/foundation/lazy/LazyListItemInfo;)V", "getItem", "()Landroidx/compose/foundation/lazy/LazyListItemInfo;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f
  extends CancellationException
{
  final m aet;
  
  public f(m paramm)
  {
    AppMethodBeat.i(204198);
    this.aet = paramm;
    AppMethodBeat.o(204198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.f
 * JD-Core Version:    0.7.0.1
 */