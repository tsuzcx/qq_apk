package com.tencent.mm.loader.g;

import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "checkNextTask", "", "clean", "postTask", "task", "postTaskOfHead", "reset", "start", "stop", "Companion", "libimageloader_release"})
public final class i
{
  public static final i.a hiu = new i.a((byte)0);
  private d<h> hip;
  public ConcurrentLinkedDeque<h> hiq;
  public boolean hir;
  private final AtomicInteger his;
  private final b hit;
  public final String name;
  public int token;
  
  public i(String paramString)
  {
    this.name = paramString;
    this.hip = new d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(1), new g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.hiq = new ConcurrentLinkedDeque();
    this.his = new AtomicInteger(0);
    this.token = this.his.get();
    this.hit = new b(this);
  }
  
  public final void a(h paramh)
  {
    p.h(paramh, "task");
    ae.i("Loader.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.hir + " task=" + paramh);
    paramh.token = this.token;
    this.hiq.add(paramh);
    arD();
  }
  
  public final void arD()
  {
    try
    {
      ae.i("Loader.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.hir + " waitSize=" + this.hiq.size());
      if (!this.hir)
      {
        h localh = (h)this.hiq.poll();
        if (localh != null)
        {
          this.hip.b((c)localh);
          this.hir = true;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    this.token = this.his.incrementAndGet();
    ae.i("Loader.SingleTaskExecutor", "[reset] name=" + this.name);
    this.hip.clean();
    this.hiq.clear();
    this.hir = false;
  }
  
  public final void start()
  {
    ae.i("Loader.SingleTaskExecutor", "[start] name=" + this.name);
    this.hip.a((f)this.hit);
  }
  
  public final void stop()
  {
    ae.i("Loader.SingleTaskExecutor", "[stop] name=" + this.name);
    this.hip.b((f)this.hit);
    this.hip.clean();
    this.hiq.clear();
    this.hir = false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "libimageloader_release"})
  public static final class b
    implements f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */