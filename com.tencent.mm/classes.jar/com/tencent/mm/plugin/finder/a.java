package com.tencent.mm.plugin.finder;

import com.tencent.f.b;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.bm;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"FinderAsyncDefaultExecutor", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "getFinderAsyncDefaultExecutor", "()Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "FinderCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getFinderCoroutineDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "coreSize", "", "getCoreSize", "()I", "plugin-finder_release"})
public final class a
{
  private static final int tnJ;
  private static final bk tnK;
  private static final b tnL;
  
  static
  {
    AppMethodBeat.i(241825);
    tnJ = Runtime.getRuntime().availableProcessors();
    Object localObject = h.RTc;
    int i = tnJ;
    localObject = ((i)localObject).a("FinderCoroutineDispatcher", i, i, (BlockingQueue)new LinkedBlockingQueue());
    p.g(localObject, "ThreadPool.INSTANCE.fork…  LinkedBlockingQueue()\n)");
    tnK = (bk)new bm((Executor)localObject);
    localObject = h.RTc;
    i = tnJ;
    tnL = ((i)localObject).a("FinderAsyncExecutor", i, i * 2, (BlockingQueue)new LinkedBlockingQueue());
    AppMethodBeat.o(241825);
  }
  
  public static final b cXm()
  {
    return tnL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.a
 * JD-Core Version:    0.7.0.1
 */