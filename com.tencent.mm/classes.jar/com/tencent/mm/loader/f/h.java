package com.tencent.mm.loader.f;

import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "checkNextTask", "", "clean", "postTask", "task", "postTaskOfHead", "reset", "start", "stop", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a nrx = new a((byte)0);
  public final String name;
  public boolean nrA;
  private final AtomicInteger nrB;
  private final b nrC;
  public int nrw;
  private d<g> nry;
  public ConcurrentLinkedDeque<g> nrz;
  
  public h(String paramString)
  {
    this.name = paramString;
    this.nry = new d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new a(1), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.nrz = new ConcurrentLinkedDeque();
    this.nrB = new AtomicInteger(0);
    this.nrw = this.nrB.get();
    this.nrC = new b(this);
  }
  
  public final void a(g paramg)
  {
    s.u(paramg, "task");
    Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.nrA + " task=" + paramg);
    paramg.nrw = this.nrw;
    this.nrz.add(paramg);
    blS();
  }
  
  public final void blS()
  {
    try
    {
      Log.i("Loader.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.nrA + " waitSize=" + this.nrz.size());
      if (!this.nrA)
      {
        g localg = (g)this.nrz.poll();
        if (localg != null)
        {
          this.nry.c((c)localg);
          this.nrA = true;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void clean()
  {
    Log.i("Loader.SingleTaskExecutor", s.X("[clean] name=", this.name));
    Iterator localIterator = ((Iterable)this.nrz).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cancel();
    }
    this.nrz.clear();
  }
  
  public final void reset()
  {
    this.nrw = this.nrB.incrementAndGet();
    Log.i("Loader.SingleTaskExecutor", s.X("[reset] name=", this.name));
    this.nry.clean();
    Iterator localIterator = ((Iterable)this.nrz).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cancel();
    }
    this.nrz.clear();
    this.nrA = false;
  }
  
  public final void start()
  {
    Log.i("Loader.SingleTaskExecutor", s.X("[start] name=", this.name));
    this.nry.a((e)this.nrC);
  }
  
  public final void stop()
  {
    Log.i("Loader.SingleTaskExecutor", s.X("[stop] name=", this.name));
    this.nry.b((e)this.nrC);
    this.nry.clean();
    Iterator localIterator = ((Iterable)this.nrz).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cancel();
    }
    this.nrz.clear();
    this.nrA = false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor$Companion;", "", "()V", "TAG", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e<g>
  {
    b(h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.f.h
 * JD-Core Version:    0.7.0.1
 */