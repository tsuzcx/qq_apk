package com.tencent.mm.loader.g;

import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.v;
import d.y;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c>
  implements b
{
  public static final a gkP = new a((byte)0);
  private final LinkedList<f<T>> fRN;
  private a gkK;
  private a gkL;
  private final LinkedList<g<c, f<T>>> gkM;
  public final LinkedList<g<c, f<T>>> gkN;
  private final com.tencent.mm.loader.g.a.d gkO;
  
  public d(com.tencent.mm.loader.g.a.d paramd)
  {
    this.gkO = paramd;
    this.fRN = new LinkedList();
    this.gkM = new LinkedList();
    this.gkN = new LinkedList();
  }
  
  private final String ahx()
  {
    return "name:" + this.gkO.name() + "_this:" + hashCode() + '_';
  }
  
  private final void ahy()
  {
    if (this.gkK != null) {
      return;
    }
    this.gkK = this.gkO.ahA();
  }
  
  private final boolean ahz()
  {
    if (this.gkM.size() <= 0) {
      ad.i("MicroMsg.Loader.DefaultTaskLoader", ahx() + "DefaultTaskLoader mPendingQueue is empty");
    }
    while (this.gkN.size() >= this.gkO.ahC()) {
      return false;
    }
    ad.i("MicroMsg.Loader.DefaultTaskLoader", ahx() + "callPrepare RunningQueue " + this.gkN.size() + " max_run_task " + this.gkO.ahC() + " mPendingQueue " + this.gkM.size());
    Object localObject1 = this.gkM.remove(0);
    k.g(localObject1, "mPendingQueue.removeAt(0)");
    Object localObject2 = (g)localObject1;
    this.gkN.add(localObject2);
    if (!this.gkO.ahD().a((c)((g)localObject2).first))
    {
      ad.w("MicroMsg.Loader.DefaultTaskLoader", ahx() + " block retryStrategy " + localObject2 + ".first");
      localObject1 = (f)((g)localObject2).second;
      if (localObject1 != null)
      {
        localObject2 = ((g)localObject2).first;
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type T");
        }
        ((f)localObject1).a((c)localObject2, h.gkZ);
      }
      return true;
    }
    execute((Runnable)new i((c)((g)localObject2).first, (b)this, (i.a)new c(this)));
    return true;
  }
  
  public final void B(Runnable paramRunnable)
  {
    k.h(paramRunnable, "runnable");
    if (this.gkL == null) {
      this.gkL = this.gkO.ahB();
    }
    a locala = this.gkL;
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
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramT, paramf, paramBoolean));
  }
  
  public final void a(final f<T> paramf)
  {
    k.h(paramf, "callback");
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this, paramf));
  }
  
  public final void b(T paramT)
  {
    k.h(paramT, "t");
    a(paramT, null);
  }
  
  public final void b(final f<T> paramf)
  {
    k.h(paramf, "callback");
    com.tencent.mm.ad.c.g((d.g.a.a)new h(this, paramf));
  }
  
  public final void c(final T paramT)
  {
    k.h(paramT, "t");
    com.tencent.mm.ad.c.g((d.g.a.a)new g(this, paramT));
  }
  
  public final void clean()
  {
    com.tencent.mm.ad.c.g((d.g.a.a)new d(this));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    k.h(paramRunnable, "runnable");
    ahy();
    a locala = this.gkK;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/loader/LoaderCore$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(d paramd, c paramc, f paramf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
  static final class c
    implements i.a
  {
    c(d paramd) {}
    
    public final void b(final c paramc, final h paramh)
    {
      com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l(paramc) {});
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(d paramd, c paramc, h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(d paramd, f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(d paramd, c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */