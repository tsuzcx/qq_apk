package com.tencent.mm.loader.g;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c>
  implements b
{
  public static final d.a ibc = new d.a((byte)0);
  private final LinkedList<f<T>> hcR;
  private a iaX;
  private a iaY;
  private final LinkedList<g<c, f<T>>> iaZ;
  public final LinkedList<g<c, f<T>>> iba;
  private final com.tencent.mm.loader.g.a.d ibb;
  
  public d(com.tencent.mm.loader.g.a.d paramd)
  {
    this.ibb = paramd;
    this.hcR = new LinkedList();
    this.iaZ = new LinkedList();
    this.iba = new LinkedList();
  }
  
  private void a(final T paramT, final f<T> paramf, final boolean paramBoolean)
  {
    p.h(paramT, "t");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramT, paramf, paramBoolean));
  }
  
  private final String aJZ()
  {
    return "name:" + this.ibb.name() + "_this:" + hashCode() + '_';
  }
  
  private final void aKa()
  {
    if (this.iaX != null) {
      return;
    }
    this.iaX = this.ibb.aKd();
  }
  
  private final boolean aKb()
  {
    if (this.iaZ.size() <= 0) {
      Log.i("MicroMsg.Loader.DefaultTaskLoader", aJZ() + "DefaultTaskLoader mPendingQueue is empty");
    }
    while (this.iba.size() >= this.ibb.aKf()) {
      return false;
    }
    Log.i("MicroMsg.Loader.DefaultTaskLoader", aJZ() + "callPrepare RunningQueue " + this.iba.size() + " max_run_task " + this.ibb.aKf() + " mPendingQueue " + this.iaZ.size());
    Object localObject1 = this.iaZ.remove(0);
    p.g(localObject1, "mPendingQueue.removeAt(0)");
    Object localObject2 = (g)localObject1;
    this.iba.add(localObject2);
    Log.i("MicroMsg.Loader.DefaultTaskLoader", "add task,mediaId:" + ((c)((g)localObject2).first).auK());
    if (!this.ibb.aKg().a((c)((g)localObject2).first))
    {
      Log.w("MicroMsg.Loader.DefaultTaskLoader", aJZ() + " block retryStrategy " + localObject2 + ".first");
      localObject1 = (f)((g)localObject2).second;
      if (localObject1 != null)
      {
        localObject2 = ((g)localObject2).first;
        if (localObject2 == null) {
          throw new t("null cannot be cast to non-null type T");
        }
        ((f)localObject1).a((c)localObject2, j.ibv);
      }
      return true;
    }
    execute((Runnable)new k((c)((g)localObject2).first, (b)this, (k.a)new c(this, (g)localObject2)));
    return true;
  }
  
  public final void D(Runnable paramRunnable)
  {
    p.h(paramRunnable, "runnable");
    if (this.iaY == null) {
      this.iaY = this.ibb.aKe();
    }
    a locala = this.iaY;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  public final void a(T paramT, f<T> paramf)
  {
    p.h(paramT, "t");
    a(paramT, paramf, false);
  }
  
  public final void a(final f<T> paramf)
  {
    p.h(paramf, "callback");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this, paramf));
  }
  
  public final void b(T paramT)
  {
    p.h(paramT, "t");
    a(paramT, null, true);
  }
  
  public final void b(final f<T> paramf)
  {
    p.h(paramf, "callback");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, paramf));
  }
  
  public final void c(T paramT)
  {
    p.h(paramT, "t");
    a(paramT, null);
  }
  
  public final void clean()
  {
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this));
  }
  
  public final void d(final T paramT)
  {
    p.h(paramT, "t");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this, paramT));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    p.h(paramRunnable, "runnable");
    aKa();
    a locala = this.iaX;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(d paramd, c paramc, f paramf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
  static final class c
    implements k.a
  {
    c(d paramd, g paramg) {}
    
    public final void b(final c paramc, final j paramj)
    {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramc) {});
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(d paramd, c paramc, j paramj)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(d paramd, f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(d paramd, c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */