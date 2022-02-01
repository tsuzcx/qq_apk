package com.tencent.mm.plugin.finder;

import com.tencent.e.b;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bq;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"FinderAsyncDefaultExecutor", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "getFinderAsyncDefaultExecutor", "()Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "FinderCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getFinderCoroutineDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "coreSize", "", "getCoreSize", "()I", "plugin-finder_release"})
public final class a
{
  private static final int wUF;
  private static final bn wUG;
  private static final b wUH;
  
  static
  {
    AppMethodBeat.i(270646);
    wUF = Runtime.getRuntime().availableProcessors();
    Object localObject = h.ZvG;
    int i = wUF;
    localObject = ((i)localObject).a("FinderCoroutineDispatcher", i, i, (BlockingQueue)new LinkedBlockingQueue());
    p.j(localObject, "ThreadPool.INSTANCE.fork…  LinkedBlockingQueue()\n)");
    wUG = bq.a((ExecutorService)localObject);
    localObject = h.ZvG;
    i = wUF;
    wUH = ((i)localObject).a("FinderAsyncExecutor", i, i * 2, (BlockingQueue)new LinkedBlockingQueue());
    AppMethodBeat.o(270646);
  }
  
  public static final b dmw()
  {
    return wUH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.a
 * JD-Core Version:    0.7.0.1
 */