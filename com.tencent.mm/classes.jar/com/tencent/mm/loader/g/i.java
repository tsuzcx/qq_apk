package com.tencent.mm.loader.g;

import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "checkNextTask", "", "clean", "postTask", "task", "postTaskOfHead", "reset", "start", "stop", "Companion", "libimageloader_release"})
public final class i
{
  public static final a hfG = new a((byte)0);
  private d<h> hfB;
  public ConcurrentLinkedDeque<h> hfC;
  public boolean hfD;
  private final AtomicInteger hfE;
  private final b hfF;
  public final String name;
  public int token;
  
  public i(String paramString)
  {
    this.name = paramString;
    this.hfB = new d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(1), new g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.hfC = new ConcurrentLinkedDeque();
    this.hfE = new AtomicInteger(0);
    this.token = this.hfE.get();
    this.hfF = new b(this);
  }
  
  public final void a(h paramh)
  {
    p.h(paramh, "task");
    ad.i("Loader.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.hfD + " task=" + paramh);
    paramh.token = this.token;
    this.hfC.add(paramh);
    aro();
  }
  
  public final void aro()
  {
    try
    {
      ad.i("Loader.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.hfD + " waitSize=" + this.hfC.size());
      if (!this.hfD)
      {
        h localh = (h)this.hfC.poll();
        if (localh != null)
        {
          this.hfB.b((c)localh);
          this.hfD = true;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void reset()
  {
    this.token = this.hfE.incrementAndGet();
    ad.i("Loader.SingleTaskExecutor", "[reset] name=" + this.name);
    this.hfB.clean();
    this.hfC.clear();
    this.hfD = false;
  }
  
  public final void start()
  {
    ad.i("Loader.SingleTaskExecutor", "[start] name=" + this.name);
    this.hfB.a((f)this.hfF);
  }
  
  public final void stop()
  {
    ad.i("Loader.SingleTaskExecutor", "[stop] name=" + this.name);
    this.hfB.b((f)this.hfF);
    this.hfB.clean();
    this.hfC.clear();
    this.hfD = false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "libimageloader_release"})
  public static final class b
    implements f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */