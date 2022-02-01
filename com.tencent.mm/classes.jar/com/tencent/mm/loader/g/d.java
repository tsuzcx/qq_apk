package com.tencent.mm.loader.g;

import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c>
  implements b
{
  public static final d.a hfr = new d.a((byte)0);
  private final LinkedList<f<T>> gpl;
  private a hfm;
  private a hfn;
  private final LinkedList<g<c, f<T>>> hfo;
  public final LinkedList<g<c, f<T>>> hfp;
  private final com.tencent.mm.loader.g.a.d hfq;
  
  public d(com.tencent.mm.loader.g.a.d paramd)
  {
    this.hfq = paramd;
    this.gpl = new LinkedList();
    this.hfo = new LinkedList();
    this.hfp = new LinkedList();
  }
  
  private final String arl()
  {
    return "name:" + this.hfq.name() + "_this:" + hashCode() + '_';
  }
  
  private final void arm()
  {
    if (this.hfm != null) {
      return;
    }
    this.hfm = this.hfq.arp();
  }
  
  private final boolean arn()
  {
    if (this.hfo.size() <= 0) {
      ad.i("MicroMsg.Loader.DefaultTaskLoader", arl() + "DefaultTaskLoader mPendingQueue is empty");
    }
    while (this.hfp.size() >= this.hfq.arr()) {
      return false;
    }
    ad.i("MicroMsg.Loader.DefaultTaskLoader", arl() + "callPrepare RunningQueue " + this.hfp.size() + " max_run_task " + this.hfq.arr() + " mPendingQueue " + this.hfo.size());
    Object localObject1 = this.hfo.remove(0);
    p.g(localObject1, "mPendingQueue.removeAt(0)");
    Object localObject2 = (g)localObject1;
    this.hfp.add(localObject2);
    if (!this.hfq.ars().a((c)((g)localObject2).first))
    {
      ad.w("MicroMsg.Loader.DefaultTaskLoader", arl() + " block retryStrategy " + localObject2 + ".first");
      localObject1 = (f)((g)localObject2).second;
      if (localObject1 != null)
      {
        localObject2 = ((g)localObject2).first;
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type T");
        }
        ((f)localObject1).a((c)localObject2, j.hfJ);
      }
      return true;
    }
    execute((Runnable)new k((c)((g)localObject2).first, (b)this, (k.a)new c(this)));
    return true;
  }
  
  public final void C(Runnable paramRunnable)
  {
    p.h(paramRunnable, "runnable");
    if (this.hfn == null) {
      this.hfn = this.hfq.arq();
    }
    a locala = this.hfn;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  public final void a(T paramT, f<T> paramf)
  {
    p.h(paramT, "t");
    a(paramT, paramf, false);
  }
  
  public final void a(final T paramT, final f<T> paramf, final boolean paramBoolean)
  {
    p.h(paramT, "t");
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramT, paramf, paramBoolean));
  }
  
  public final void a(final f<T> paramf)
  {
    p.h(paramf, "callback");
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this, paramf));
  }
  
  public final void b(T paramT)
  {
    p.h(paramT, "t");
    a(paramT, null);
  }
  
  public final void b(final f<T> paramf)
  {
    p.h(paramf, "callback");
    com.tencent.mm.ad.c.g((d.g.a.a)new h(this, paramf));
  }
  
  public final void c(final T paramT)
  {
    p.h(paramT, "t");
    com.tencent.mm.ad.c.g((d.g.a.a)new g(this, paramT));
  }
  
  public final void clean()
  {
    com.tencent.mm.ad.c.g((d.g.a.a)new d(this));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    p.h(paramRunnable, "runnable");
    arm();
    a locala = this.hfm;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(d paramd, c paramc, f paramf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
  static final class c
    implements k.a
  {
    c(d paramd) {}
    
    public final void b(final c paramc, final j paramj)
    {
      com.tencent.mm.ad.c.g((d.g.a.a)new q(paramc) {});
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(d paramd, c paramc, j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(d paramd, f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(d paramd, c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(d paramd, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */