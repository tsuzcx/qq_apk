package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.j;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingData;", "T", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "receiver", "Landroidx/paging/UiReceiver;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/UiReceiver;)V", "getFlow$paging_common", "()Lkotlinx/coroutines/flow/Flow;", "getReceiver$paging_common", "()Landroidx/paging/UiReceiver;", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
public final class av<T>
{
  private static final bo bQl;
  private static final av<Object> bQm;
  public static final av.a bQn;
  public final g<ag<T>> bLH;
  public final bo bQk;
  
  static
  {
    AppMethodBeat.i(196649);
    bQn = new av.a((byte)0);
    bQl = (bo)new b();
    ag.b.a locala = ag.b.bNQ;
    bQm = new av(j.jb(ag.b.HQ()), bQl);
    AppMethodBeat.o(196649);
  }
  
  public av(g<? extends ag<T>> paramg, bo parambo)
  {
    AppMethodBeat.i(196641);
    this.bLH = paramg;
    this.bQk = parambo;
    AppMethodBeat.o(196641);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"androidx/paging/PagingData$Companion$NOOP_RECEIVER$1", "Landroidx/paging/UiReceiver;", "accessHint", "", "viewportHint", "Landroidx/paging/ViewportHint;", "refresh", "retry", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b
    implements bo
  {
    public final void a(bp parambp)
    {
      AppMethodBeat.i(196584);
      s.u(parambp, "viewportHint");
      AppMethodBeat.o(196584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.av
 * JD-Core Version:    0.7.0.1
 */