package androidx.paging.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/Buffer;", "T", "", "items", "", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "getItems", "()Ljava/util/Collection;", "add", "", "item", "isEmpty", "", "paging-common"}, k=1, mv={1, 4, 2})
abstract interface a<T>
{
  public abstract void a(c.c.b.c<T> paramc);
  
  public abstract Collection<c.c.b.c<T>> getItems();
  
  public abstract boolean isEmpty();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 4, 2})
  public static final class a
  {
    public static <T> boolean a(a<T> parama)
    {
      AppMethodBeat.i(197109);
      boolean bool = parama.getItems().isEmpty();
      AppMethodBeat.o(197109);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.a.a
 * JD-Core Version:    0.7.0.1
 */