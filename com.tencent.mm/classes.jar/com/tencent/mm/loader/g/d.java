package com.tencent.mm.loader.g;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c>
  implements b
{
  public static final d.a kPI = new d.a((byte)0);
  private final LinkedList<f<T>> jOi;
  private a kPD;
  private a kPE;
  private final LinkedList<g<c, f<T>>> kPF;
  public final LinkedList<g<c, f<T>>> kPG;
  private final com.tencent.mm.loader.g.a.d kPH;
  
  public d(com.tencent.mm.loader.g.a.d paramd)
  {
    this.kPH = paramd;
    this.jOi = new LinkedList();
    this.kPF = new LinkedList();
    this.kPG = new LinkedList();
  }
  
  private final String aSa()
  {
    return "name:" + this.kPH.name() + "_this:" + hashCode() + '_';
  }
  
  private final void aSb()
  {
    if (this.kPD != null) {
      return;
    }
    this.kPD = this.kPH.aSe();
  }
  
  private final boolean aSc()
  {
    if (this.kPF.size() <= 0) {
      Log.i("MicroMsg.Loader.DefaultTaskLoader", aSa() + "DefaultTaskLoader mPendingQueue is empty");
    }
    while (this.kPG.size() >= this.kPH.aSg()) {
      return false;
    }
    Log.i("MicroMsg.Loader.DefaultTaskLoader", aSa() + "callPrepare RunningQueue " + this.kPG.size() + " max_run_task " + this.kPH.aSg() + " mPendingQueue " + this.kPF.size());
    Object localObject1 = this.kPF.remove(0);
    p.j(localObject1, "mPendingQueue.removeAt(0)");
    Object localObject2 = (g)localObject1;
    this.kPG.add(localObject2);
    Log.i("MicroMsg.Loader.DefaultTaskLoader", "add task,mediaId:" + ((c)((g)localObject2).Mx).aBG());
    if (!this.kPH.aSh().a((c)((g)localObject2).Mx))
    {
      Log.w("MicroMsg.Loader.DefaultTaskLoader", aSa() + " block retryStrategy " + localObject2 + ".first");
      localObject1 = (f)((g)localObject2).My;
      if (localObject1 != null)
      {
        localObject2 = ((g)localObject2).Mx;
        if (localObject2 == null) {
          throw new t("null cannot be cast to non-null type T");
        }
        ((f)localObject1).a((c)localObject2, j.kQc);
      }
      return true;
    }
    execute((Runnable)new k((c)((g)localObject2).Mx, (b)this, (k.a)new c(this, (g)localObject2)));
    return true;
  }
  
  public final void D(Runnable paramRunnable)
  {
    p.k(paramRunnable, "runnable");
    if (this.kPE == null) {
      this.kPE = this.kPH.aSf();
    }
    a locala = this.kPE;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  public final void a(T paramT, f<T> paramf)
  {
    p.k(paramT, "t");
    a(paramT, paramf, false);
  }
  
  public final void a(final T paramT, final f<T> paramf, final boolean paramBoolean)
  {
    p.k(paramT, "t");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramT, paramf, paramBoolean));
  }
  
  public final void a(final f<T> paramf)
  {
    p.k(paramf, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramf));
  }
  
  public final void b(T paramT)
  {
    p.k(paramT, "t");
    a(paramT, null);
  }
  
  public final void b(final f<T> paramf)
  {
    p.k(paramf, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramf));
  }
  
  public final void c(final T paramT)
  {
    p.k(paramT, "t");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramT));
  }
  
  public final void clean()
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    p.k(paramRunnable, "runnable");
    aSb();
    a locala = this.kPD;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(d paramd, c paramc, f paramf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
  static final class c
    implements k.a
  {
    c(d paramd, g paramg) {}
    
    public final void b(final c paramc, final j paramj)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramc) {});
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(d paramd, c paramc, j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(d paramd, f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(d paramd, c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(d paramd, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */