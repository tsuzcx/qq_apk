package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.b.ah;
import kotlinx.coroutines.b.x;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/AccessorStateHolder;", "Key", "", "Value", "()V", "_loadStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/LoadStates;", "internalState", "Landroidx/paging/AccessorState;", "loadStates", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadStates", "()Lkotlinx/coroutines/flow/StateFlow;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "use", "R", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
final class c<Key, Value>
{
  private final ReentrantLock bKF;
  final x<ab> bKG;
  private final a<Key, Value> bKH;
  
  public c()
  {
    AppMethodBeat.i(197062);
    this.bKF = new ReentrantLock();
    ab.a locala = ab.bNB;
    this.bKG = ah.ji(ab.HN());
    this.bKH = new a();
    AppMethodBeat.o(197062);
  }
  
  public final <R> R o(b<? super a<Key, Value>, ? extends R> paramb)
  {
    AppMethodBeat.i(197065);
    s.u(paramb, "block");
    Lock localLock = (Lock)this.bKF;
    localLock.lock();
    try
    {
      paramb = paramb.invoke(this.bKH);
      this.bKG.setValue(this.bKH.HC());
      return paramb;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(197065);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.c
 * JD-Core Version:    0.7.0.1
 */