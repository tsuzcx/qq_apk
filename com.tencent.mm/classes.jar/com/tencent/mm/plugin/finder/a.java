package com.tencent.mm.plugin.finder;

import com.tencent.e.b;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import kotlinx.coroutines.bh;
import kotlinx.coroutines.bj;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"FinderAsyncDefaultExecutor", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "getFinderAsyncDefaultExecutor", "()Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "FinderCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getFinderCoroutineDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "coreSize", "", "getCoreSize", "()I", "plugin-finder_release"})
public final class a
{
  private static final int rNV;
  private static final bh rNW;
  private static final b rNX;
  
  static
  {
    AppMethodBeat.i(201351);
    rNV = Runtime.getRuntime().availableProcessors();
    Object localObject = h.MqF;
    int i = rNV;
    localObject = ((i)localObject).a("FinderCoroutineDispatcher", i, i, (BlockingQueue)new LinkedBlockingQueue());
    p.g(localObject, "ThreadPool.INSTANCE.fork…  LinkedBlockingQueue()\n)");
    rNW = (bh)new bj((Executor)localObject);
    localObject = h.MqF;
    i = rNV;
    rNX = ((i)localObject).a("FinderAsyncExecutor", i, i * 2, (BlockingQueue)new LinkedBlockingQueue());
    AppMethodBeat.o(201351);
  }
  
  public static final b czi()
  {
    return rNX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.a
 * JD-Core Version:    0.7.0.1
 */