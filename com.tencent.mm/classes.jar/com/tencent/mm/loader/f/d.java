package com.tencent.mm.loader.f;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T extends c>
  implements b
{
  public static final d.a nrg = new d.a((byte)0);
  private final LinkedList<e<T>> mng;
  private final com.tencent.mm.loader.f.a.d nrh;
  private a nri;
  private a nrj;
  private final LinkedList<f<c, e<T>>> nrk;
  public final LinkedList<f<c, e<T>>> nrl;
  
  public d(com.tencent.mm.loader.f.a.d paramd)
  {
    this.nrh = paramd;
    this.mng = new LinkedList();
    this.nrk = new LinkedList();
    this.nrl = new LinkedList();
  }
  
  private static final void a(d paramd, final f paramf, final c paramc, final i parami)
  {
    s.u(paramd, "this$0");
    s.u(paramf, "$pair");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramd, paramc, parami, paramf));
  }
  
  private final String blP()
  {
    return "name:" + this.nrh.name() + "_this:" + hashCode() + '_';
  }
  
  private final void blQ()
  {
    if (this.nri != null) {
      return;
    }
    this.nri = this.nrh.blT();
  }
  
  private final boolean blR()
  {
    if (this.nrk.size() <= 0) {
      Log.i("MicroMsg.Loader.DefaultTaskLoader", s.X(blP(), "DefaultTaskLoader mPendingQueue is empty"));
    }
    while (this.nrl.size() >= this.nrh.blV()) {
      return false;
    }
    Log.i("MicroMsg.Loader.DefaultTaskLoader", blP() + "callPrepare RunningQueue " + this.nrl.size() + " max_run_task " + this.nrh.blV() + " mPendingQueue " + this.nrk.size());
    Object localObject = this.nrk.remove(0);
    s.s(localObject, "mPendingQueue.removeAt(0)");
    localObject = (f)localObject;
    this.nrl.add(localObject);
    Log.i("MicroMsg.Loader.DefaultTaskLoader", s.X("add task,mediaId:", ((c)((f)localObject).bsC).aUE()));
    if (!this.nrh.blW().a((c)((f)localObject).bsC))
    {
      Log.w("MicroMsg.Loader.DefaultTaskLoader", blP() + " block retryStrategy " + ((f)localObject).bsC + " callback size=" + ((f)localObject).nru.size());
      Iterator localIterator = ((Iterable)((f)localObject).nru).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale != null) {
          locale.a((c)((f)localObject).bsC, i.nrF);
        }
      }
      return true;
    }
    execute((Runnable)new j((c)((f)localObject).bsC, (b)this, new d..ExternalSyntheticLambda0(this, (f)localObject)));
    return true;
  }
  
  public final void I(Runnable paramRunnable)
  {
    s.u(paramRunnable, "runnable");
    if (this.nrj == null) {
      this.nrj = this.nrh.blU();
    }
    a locala = this.nrj;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  public final void a(T paramT, e<T> parame)
  {
    s.u(paramT, "t");
    a(paramT, parame, false);
  }
  
  public final void a(final T paramT, final e<T> parame, final boolean paramBoolean)
  {
    s.u(paramT, "t");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramT, paramBoolean, parame));
  }
  
  public final void a(final e<T> parame)
  {
    s.u(parame, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, parame));
  }
  
  public final void b(final e<T> parame)
  {
    s.u(parame, "callback");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, parame));
  }
  
  public final void c(T paramT)
  {
    s.u(paramT, "t");
    a(paramT, null);
  }
  
  public final void clean()
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
  }
  
  public final void d(final T paramT)
  {
    s.u(paramT, "t");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramT));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    s.u(paramRunnable, "runnable");
    blQ();
    a locala = this.nri;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d<T> paramd, T paramT, boolean paramBoolean, e<T> parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(d<T> paramd, c paramc, i parami, f<? extends c, e<T>> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(d<T> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(d<T> paramd, c paramc, i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(d<T> paramd, e<T> parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(d<T> paramd, T paramT)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(d<T> paramd, e<T> parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.d
 * JD-Core Version:    0.7.0.1
 */