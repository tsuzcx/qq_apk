package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.br;
import kotlinx.coroutines.bt;

@Metadata(d1={""}, d2={"FinderAsyncDefaultExecutor", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "getFinderAsyncDefaultExecutor", "()Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "FinderCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getFinderCoroutineDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "coreSize", "", "getCoreSize", "()I", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final int Ark;
  private static final br Arl;
  private static final b Arm;
  
  static
  {
    AppMethodBeat.i(329821);
    Ark = Runtime.getRuntime().availableProcessors();
    Object localObject = h.ahAA;
    int i = Ark;
    localObject = ((i)localObject).a("FinderCoroutineDispatcher", i, i, (BlockingQueue)new LinkedBlockingQueue());
    s.s(localObject, "INSTANCE.forkExecutorSer…  LinkedBlockingQueue()\n)");
    Arl = bt.b((ExecutorService)localObject);
    localObject = h.ahAA;
    i = Ark;
    localObject = ((i)localObject).a("FinderAsyncExecutor", i, i * 2, (BlockingQueue)new LinkedBlockingQueue());
    s.checkNotNull(localObject);
    Arm = (b)localObject;
    AppMethodBeat.o(329821);
  }
  
  public static final b dTo()
  {
    return Arm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.a
 * JD-Core Version:    0.7.0.1
 */