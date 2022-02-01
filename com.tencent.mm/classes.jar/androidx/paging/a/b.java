package androidx.paging.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/BufferImpl;", "T", "Landroidx/paging/multicast/Buffer;", "limit", "", "(I)V", "items", "Ljava/util/ArrayDeque;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "getItems", "()Ljava/util/ArrayDeque;", "add", "", "item", "paging-common"}, k=1, mv={1, 4, 2})
final class b<T>
  implements a<T>
{
  private final ArrayDeque<c.c.b.c<T>> bRZ;
  private final int limit;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(197132);
    this.limit = paramInt;
    this.bRZ = new ArrayDeque(k.qv(this.limit, 10));
    AppMethodBeat.o(197132);
  }
  
  public final void a(c.c.b.c<T> paramc)
  {
    AppMethodBeat.i(197143);
    s.u(paramc, "item");
    while (this.bRZ.size() >= this.limit) {
      this.bRZ.pollFirst();
    }
    this.bRZ.offerLast(paramc);
    AppMethodBeat.o(197143);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(197147);
    boolean bool = a.a.a(this);
    AppMethodBeat.o(197147);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.a.b
 * JD-Core Version:    0.7.0.1
 */