package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.aq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/SimpleProducerScopeImpl;", "T", "Landroidx/paging/SimpleProducerScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "scope", "channel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "isClosedForSend", "", "()Z", "isFull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "awaitClose", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "cause", "", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
public final class bi<T>
  implements bh<T>
{
  private final ab<T> bLy;
  
  public bi(aq paramaq, ab<? super T> paramab)
  {
    AppMethodBeat.i(196991);
    this.bRj = paramaq;
    this.bLy = paramab;
    AppMethodBeat.o(196991);
  }
  
  public final boolean Ij()
  {
    AppMethodBeat.i(197028);
    boolean bool = this.bLy.Ij();
    AppMethodBeat.o(197028);
    return bool;
  }
  
  public final Object b(T paramT, d<? super ah> paramd)
  {
    AppMethodBeat.i(197063);
    paramT = this.bLy.b(paramT, paramd);
    AppMethodBeat.o(197063);
    return paramT;
  }
  
  public final f getCoroutineContext()
  {
    AppMethodBeat.i(196997);
    f localf = this.bRj.getCoroutineContext();
    AppMethodBeat.o(196997);
    return localf;
  }
  
  public final boolean k(Throwable paramThrowable)
  {
    AppMethodBeat.i(197036);
    boolean bool = this.bLy.k(paramThrowable);
    AppMethodBeat.o(197036);
    return bool;
  }
  
  public final boolean offer(T paramT)
  {
    AppMethodBeat.i(197051);
    boolean bool = this.bLy.offer(paramT);
    AppMethodBeat.o(197051);
    return bool;
  }
  
  public final void p(b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(197042);
    s.u(paramb, "handler");
    this.bLy.p(paramb);
    AppMethodBeat.o(197042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bi
 * JD-Core Version:    0.7.0.1
 */