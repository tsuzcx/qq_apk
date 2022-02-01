package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "()V", "dispatcher", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "merger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getMerger", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "createDataMerger", "onAlive", "", "onDead", "register", "callback", "unregister", "STATUS", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class Dispatcher<T extends k>
  extends DataStore<T>
{
  private final f<T> dispatcher = new f(this.viewCallbacks);
  private final d<T> merger = createDataMerger();
  private final LinkedList<com.tencent.mm.view.k> viewCallbacks = new LinkedList();
  
  public abstract d<T> createDataMerger();
  
  public final f<T> dispatcher()
  {
    return this.dispatcher;
  }
  
  public final d<T> getMerger()
  {
    return this.merger;
  }
  
  public abstract void onAlive();
  
  public abstract void onDead();
  
  public final void register(com.tencent.mm.view.k paramk)
  {
    s.u(paramk, "callback");
    this.viewCallbacks.add(paramk);
    Log.i(getTAG(), "register callback " + paramk + " size:" + this.viewCallbacks.size());
    if (this.viewCallbacks.size() == 1) {
      onAlive();
    }
  }
  
  public final void unregister(com.tencent.mm.view.k paramk)
  {
    s.u(paramk, "callback");
    synchronized ((Iterable)this.viewCallbacks)
    {
      localObject = ???.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.view.k localk = (com.tencent.mm.view.k)((Iterator)localObject).next();
        if (s.p(localk, paramk)) {
          this.viewCallbacks.remove(localk);
        }
      }
    }
    Object localObject = ah.aiuX;
    Log.i(getTAG(), "unregister callback " + paramk + " size " + this.viewCallbacks.size() + " from " + Util.getStack() + '}');
    if (this.viewCallbacks.size() == 0) {
      onDead();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher
 * JD-Core Version:    0.7.0.1
 */