package com.tencent.mm.loader.g;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c>
  implements b
{
  public static final d.a ePk = new d.a((byte)0);
  private a ePf;
  private a ePg;
  private final LinkedList<g<c, f<T>>> ePh;
  private final LinkedList<g<c, f<T>>> ePi;
  private final com.tencent.mm.loader.g.a.d ePj;
  private final LinkedList<f<T>> exy;
  
  public d(com.tencent.mm.loader.g.a.d paramd)
  {
    this.ePj = paramd;
    this.exy = new LinkedList();
    this.ePh = new LinkedList();
    this.ePi = new LinkedList();
  }
  
  private final String TM()
  {
    return "name:" + this.ePj.name() + "_this:" + hashCode() + '_';
  }
  
  private final void TN()
  {
    if (this.ePf != null) {
      return;
    }
    this.ePf = this.ePj.TP();
  }
  
  private final boolean TO()
  {
    if (this.ePh.size() <= 0) {
      ab.i("MicroMsg.Loader.DefaultTaskLoader", TM() + "DefaultTaskLoader mPendingQueue is empty");
    }
    while (this.ePi.size() > this.ePj.TR()) {
      return false;
    }
    ab.i("MicroMsg.Loader.DefaultTaskLoader", TM() + "callPrepare RunningQueue %s max_run_task %s mPendingQueue %s", new Object[] { Integer.valueOf(this.ePi.size()), Integer.valueOf(this.ePj.TR()), Integer.valueOf(this.ePh.size()) });
    Object localObject1 = this.ePh.remove(0);
    j.p(localObject1, "mPendingQueue.removeAt(0)");
    Object localObject2 = (g)localObject1;
    this.ePi.add(localObject2);
    if (!this.ePj.TS().a((c)((g)localObject2).first))
    {
      ab.w("MicroMsg.Loader.DefaultTaskLoader", TM() + " block retryStrategy " + localObject2 + ".first");
      localObject1 = (f)((g)localObject2).second;
      if (localObject1 != null)
      {
        localObject2 = ((g)localObject2).first;
        if (localObject2 == null) {
          throw new v("null cannot be cast to non-null type T");
        }
        ((f)localObject1).a((c)localObject2, h.ePu);
      }
      return true;
    }
    execute((Runnable)new i((c)((g)localObject2).first, (b)this, (i.a)new d.c(this)));
    return true;
  }
  
  public final void a(T paramT, f<T> paramf)
  {
    j.q(paramT, "t");
    a(paramT, paramf, false);
  }
  
  public final void a(T paramT, f<T> paramf, boolean paramBoolean)
  {
    j.q(paramT, "t");
    com.tencent.mm.ab.b.b((a.f.a.a)new d.b(this, paramT, paramf, paramBoolean));
  }
  
  public final void a(f<T> paramf)
  {
    j.q(paramf, "callback");
    com.tencent.mm.ab.b.b((a.f.a.a)new d.f(this, paramf));
  }
  
  public final void b(T paramT)
  {
    j.q(paramT, "t");
    a(paramT, null);
  }
  
  public final void b(f<T> paramf)
  {
    j.q(paramf, "callback");
    com.tencent.mm.ab.b.b((a.f.a.a)new d.h(this, paramf));
  }
  
  public final void clean()
  {
    com.tencent.mm.ab.b.b((a.f.a.a)new d.d(this));
  }
  
  public final void execute(Runnable paramRunnable)
  {
    j.q(paramRunnable, "runnable");
    TN();
    a locala = this.ePf;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
  
  public final void t(Runnable paramRunnable)
  {
    j.q(paramRunnable, "runnable");
    if (this.ePg == null) {
      this.ePg = this.ePj.TQ();
    }
    a locala = this.ePg;
    if (locala != null) {
      locala.execute(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */