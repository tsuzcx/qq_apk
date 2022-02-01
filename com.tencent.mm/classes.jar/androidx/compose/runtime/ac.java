package androidx.compose.runtime;

import androidx.compose.runtime.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/GroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/SlotTable;", "start", "", "end", "(Landroidx/compose/runtime/SlotTable;II)V", "getEnd", "()I", "index", "getTable", "()Landroidx/compose/runtime/SlotTable;", "version", "hasNext", "", "next", "validateRead", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ac
  implements Iterator<b>, a
{
  final be anZ;
  private final int end;
  private int index;
  private final int version;
  
  public ac(be parambe, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201873);
    this.anZ = parambe;
    this.end = paramInt2;
    this.index = paramInt1;
    this.version = this.anZ.version;
    if (this.anZ.apK)
    {
      parambe = new ConcurrentModificationException();
      AppMethodBeat.o(201873);
      throw parambe;
    }
    AppMethodBeat.o(201873);
  }
  
  private final void pu()
  {
    AppMethodBeat.i(201884);
    if (this.anZ.version != this.version)
    {
      ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException();
      AppMethodBeat.o(201884);
      throw localConcurrentModificationException;
    }
    AppMethodBeat.o(201884);
  }
  
  public final boolean hasNext()
  {
    return this.index < this.end;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(201912);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(201912);
    throw localUnsupportedOperationException;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/GroupIterator$next$1", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "data", "", "getData", "isEmpty", "", "()Z", "key", "getKey", "()Ljava/lang/Object;", "node", "getNode", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "iterator", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b, Iterable<b>, a
  {
    a(ac paramac, int paramInt) {}
    
    public final Iterator<b> iterator()
    {
      AppMethodBeat.i(202177);
      ac.a(this.aoa);
      Iterator localIterator = (Iterator)new ac(this.aoa.anZ, this.aob + 1, this.aob + this.aoa.anZ.apB[(this.aob * 5 + 3)]);
      AppMethodBeat.o(202177);
      return localIterator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.ac
 * JD-Core Version:    0.7.0.1
 */