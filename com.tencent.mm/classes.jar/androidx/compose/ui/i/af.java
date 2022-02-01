package androidx.compose.ui.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/TreeSet;", "E", "Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af<E>
  extends TreeSet<E>
{
  public af(Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    AppMethodBeat.i(204664);
    AppMethodBeat.o(204664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.af
 * JD-Core Version:    0.7.0.1
 */