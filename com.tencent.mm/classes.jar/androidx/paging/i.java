package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.b.h;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ChannelFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
public final class i<T>
  implements h<T>
{
  private final ab<T> bLy;
  
  public i(ab<? super T> paramab)
  {
    AppMethodBeat.i(197052);
    this.bLy = paramab;
    AppMethodBeat.o(197052);
  }
  
  public final Object a(T paramT, d<? super ah> paramd)
  {
    AppMethodBeat.i(197060);
    paramT = this.bLy.b(paramT, paramd);
    if (paramT == a.aiwj)
    {
      AppMethodBeat.o(197060);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(197060);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.i
 * JD-Core Version:    0.7.0.1
 */