package androidx.paging.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/NoBuffer;", "T", "Landroidx/paging/multicast/Buffer;", "()V", "items", "", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "getItems", "()Ljava/util/Collection;", "add", "", "item", "paging-common"}, k=1, mv={1, 4, 2})
final class e<T>
  implements a<T>
{
  public final void a(c.c.b.c<T> paramc)
  {
    AppMethodBeat.i(197159);
    s.u(paramc, "item");
    AppMethodBeat.o(197159);
  }
  
  public final Collection<c.c.b.c<T>> getItems()
  {
    AppMethodBeat.i(197152);
    Object localObject = Collections.emptyList();
    s.s(localObject, "Collections.emptyList()");
    localObject = (Collection)localObject;
    AppMethodBeat.o(197152);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(197173);
    boolean bool = a.a.a(this);
    AppMethodBeat.o(197173);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.a.e
 * JD-Core Version:    0.7.0.1
 */