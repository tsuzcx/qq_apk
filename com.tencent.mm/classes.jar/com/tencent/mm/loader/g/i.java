package com.tencent.mm.loader.g;

import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "", "name", "", "(Ljava/lang/String;)V", "increment", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRunningTask", "", "postCallback", "com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/SingleTask;", "token", "", "getToken", "()I", "setToken", "(I)V", "waitingTask", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "checkNextTask", "", "clean", "postTask", "task", "postTaskOfHead", "reset", "start", "stop", "Companion", "libimageloader_release"})
public final class i
{
  public static final a ibs = new a((byte)0);
  private d<h> ibn;
  public ConcurrentLinkedDeque<h> ibo;
  public boolean ibp;
  private final AtomicInteger ibq;
  private final b ibr;
  public final String name;
  public int token;
  
  public i(String paramString)
  {
    this.name = paramString;
    this.ibn = new d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(1), new g(1, (byte)0), 1, "SingleTaskExecutor"));
    this.ibo = new ConcurrentLinkedDeque();
    this.ibq = new AtomicInteger(0);
    this.token = this.ibq.get();
    this.ibr = new b(this);
  }
  
  public final void a(h paramh)
  {
    p.h(paramh, "task");
    Log.i("Loader.SingleTaskExecutor", "[postTask] name=" + this.name + " isRunningTask=" + this.ibp + " task=" + paramh);
    paramh.token = this.token;
    this.ibo.add(paramh);
    aKc();
  }
  
  public final void aKc()
  {
    try
    {
      Log.i("Loader.SingleTaskExecutor", "[checkNextTask] name=" + this.name + " isRunningTask=" + this.ibp + " waitSize=" + this.ibo.size());
      if (!this.ibp)
      {
        h localh = (h)this.ibo.poll();
        if (localh != null)
        {
          this.ibn.c((c)localh);
          this.ibp = true;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void clean()
  {
    Log.i("Loader.SingleTaskExecutor", "[clean] name=" + this.name);
    this.ibo.clear();
  }
  
  public final void reset()
  {
    this.token = this.ibq.incrementAndGet();
    Log.i("Loader.SingleTaskExecutor", "[reset] name=" + this.name);
    this.ibn.clean();
    this.ibo.clear();
    this.ibp = false;
  }
  
  public final void start()
  {
    Log.i("Loader.SingleTaskExecutor", "[start] name=" + this.name);
    this.ibn.a((f)this.ibr);
  }
  
  public final void stop()
  {
    Log.i("Loader.SingleTaskExecutor", "[stop] name=" + this.name);
    this.ibn.b((f)this.ibr);
    this.ibn.clean();
    this.ibo.clear();
    this.ibp = false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/SingleTaskExecutor$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/loader/loader/SingleTaskExecutor$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/SingleTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "libimageloader_release"})
  public static final class b
    implements f<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.g.i
 * JD-Core Version:    0.7.0.1
 */