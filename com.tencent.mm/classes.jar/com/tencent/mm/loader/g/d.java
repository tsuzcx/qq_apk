package com.tencent.mm.loader.g;

import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.v;
import d.y;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c>
  implements b
{
  public static final d.a gLC = new d.a((byte)0);
  private final LinkedList<f<T>> fVI;
  public final LinkedList<g<c, f<T>>> gLA;
  private final com.tencent.mm.loader.g.a.d gLB;
  private a gLx;
  private a gLy;
  private final LinkedList<g<c, f<T>>> gLz;
  
  public d(com.tencent.mm.loader.g.a.d paramd)
  {
    this.gLB = paramd;
    this.fVI = new LinkedList();
    this.gLz = new LinkedList();
    this.gLA = new LinkedList();
  }
  
  private final void aoA()
  {
    if (this.gLx != null) {
      return;
    }
    this.gLx = this.gLB.aoC();
  }
  
  private final boolean aoB()
  {
    if (this.gLz.size() <= 0) {
      ac.i("MicroMsg.Loader.DefaultTaskLoader", aoz() + "DefaultTaskLoader mPendingQueue is empty");
    }
    while (this.gLA.size() >= this.gLB.aoE()) {
      return false;
    }
    ac.i("MicroMsg.Loader.DefaultTaskLoader", aoz() + "callPrepare RunningQueue " + this.gLA.size() + " max_run_task " + this.gLB.aoE() + " mPendingQueue " + this.gLz.size());
    Object localObject1 = this.gLz.remove(0);
    k.g(localObject1, "mPendingQueue.removeAt(0)");
    Object localObject2 = (g)localObject1;
    this.gLA.add(localObject2);
    if (!this.gLB.aoF().a((c)((g)localObject2).first))
    {
      ac.w("MicroMsg.Loader.DefaultTaskLoader", aoz() + " block retryStrategy " + localObject2 + ".first");
      localObject1 = (f)((g)localObject2).second;
      if (localObject1 != null)
      {
        localObject2 = ((g)localObject2).first;
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type T");
        }
        ((f)localObject1).a((c)localObject2, h.gLM);
      }
      return true;
    }
    execute((Runnable)new i((c)((g)localObject2).first, (b)this, (i.a)new c(this)));
    return true;
  }
  
  private final String aoz()
  {
    return "name:" + this.gLB.name() + "_this:" + hashCode() + '_';
  }
  
  public final void D(Runnable paramRunnable)
  {
    k.h(paramRunnable, "runnable");
    if (this.gLy == null) {
      this.gLy = this.gLB.aoD();
    }
    a locala = this.gLy;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  public final void a(T paramT, f<T> paramf)
  {
    k.h(paramT, "t");
    a(paramT, paramf, false);
  }
  
  public final void a(final T paramT, final f<T> paramf, final boolean paramBoolean)
  {
    k.h(paramT, "t");
    com.tencent.mm.ac.c.g((d.g.a.a)new b(this, paramT, paramf, paramBoolean));
  }
  
  public final void a(final f<T> paramf)
  {
    k.h(paramf, "callback");
    com.tencent.mm.ac.c.g((d.g.a.a)new f(this, paramf));
  }
  
  public final void b(T paramT)
  {
    k.h(paramT, "t");
    a(paramT, null);
  }
  
  public final void b(final f<T> paramf)
  {
    k.h(paramf, "callback");
    com.tencent.mm.ac.c.g((d.g.a.a)new h(this, paramf));
  }
  
  public final void c(final T paramT)
  {
    k.h(paramT, "t");
    com.tencent.mm.ac.c.g((d.g.a.a)new g(this, paramT));
  }
  
  public final void clean()
  {
    com.tencent.mm.ac.c.g((d.g.a.a)new d(this));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    k.h(paramRunnable, "runnable");
    aoA();
    a locala = this.gLx;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(d paramd, c paramc, f paramf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
  static final class c
    implements i.a
  {
    c(d paramd) {}
    
    public final void b(final c paramc, final h paramh)
    {
      com.tencent.mm.ac.c.g((d.g.a.a)new d.g.b.l(paramc) {});
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(d paramd, c paramc, h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(d paramd, f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(d paramd, c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(d paramd, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */