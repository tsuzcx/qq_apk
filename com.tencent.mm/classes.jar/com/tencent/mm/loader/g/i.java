package com.tencent.mm.loader.g;

import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "checkNextTask", "", "clean", "postTask", "task", "postTaskOfHead", "reset", "start", "stop", "Companion", "libimageloader_release"})
public final class i
{
  public static final a kPZ = new a((byte)0);
  public int kPS;
  private d<h> kPU;
  public ConcurrentLinkedDeque<h> kPV;
  public boolean kPW;
  private final AtomicInteger kPX;
  private final b kPY;
  public final String name;
  
  public i(String paramString)
  {
    this.name = paramString;
    this.kPU = new d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(1), new g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.kPV = new ConcurrentLinkedDeque();
    this.kPX = new AtomicInteger(0);
    this.kPS = this.kPX.get();
    this.kPY = new b(this);
  }
  
  public final void a(h paramh)
  {
    p.k(paramh, "task");
    Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.kPW + " task=" + paramh);
    paramh.kPS = this.kPS;
    this.kPV.add(paramh);
    aSd();
  }
  
  public final void aSd()
  {
    try
    {
      Log.i("Loader.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.kPW + " waitSize=" + this.kPV.size());
      if (!this.kPW)
      {
        h localh = (h)this.kPV.poll();
        if (localh != null)
        {
          this.kPU.b((c)localh);
          this.kPW = true;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void clean()
  {
    Log.i("Loader.SingleTaskExecutor", "[clean] name=" + this.name);
    Iterator localIterator = ((Iterable)this.kPV).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cancel();
    }
    this.kPV.clear();
  }
  
  public final void reset()
  {
    this.kPS = this.kPX.incrementAndGet();
    Log.i("Loader.SingleTaskExecutor", "[reset] name=" + this.name);
    this.kPU.clean();
    Iterator localIterator = ((Iterable)this.kPV).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cancel();
    }
    this.kPV.clear();
    this.kPW = false;
  }
  
  public final void start()
  {
    Log.i("Loader.SingleTaskExecutor", "[start] name=" + this.name);
    this.kPU.a((f)this.kPY);
  }
  
  public final void stop()
  {
    Log.i("Loader.SingleTaskExecutor", "[stop] name=" + this.name);
    this.kPU.b((f)this.kPY);
    this.kPU.clean();
    Iterator localIterator = ((Iterable)this.kPV).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cancel();
    }
    this.kPV.clear();
    this.kPW = false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "libimageloader_release"})
  public static final class b
    implements f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */