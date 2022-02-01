package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "()V", "dispatcher", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "merger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getMerger", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "createDataMerger", "onAlive", "", "onDead", "register", "callback", "unregister", "STATUS", "plugin-finder_release"})
public abstract class Dispatcher<T extends i>
  extends DataStore<T>
{
  private final d<T> dispatcher = new d(this.viewCallbacks);
  private final b<T> merger = createDataMerger();
  private final LinkedList<com.tencent.mm.view.d> viewCallbacks = new LinkedList();
  
  public abstract b<T> createDataMerger();
  
  public final d<T> dispatcher()
  {
    return this.dispatcher;
  }
  
  public final b<T> getMerger()
  {
    return this.merger;
  }
  
  public abstract void onAlive();
  
  public abstract void onDead();
  
  public final void register(com.tencent.mm.view.d paramd)
  {
    p.h(paramd, "callback");
    this.viewCallbacks.add(paramd);
    ad.i(getTAG(), "register callback " + paramd + " size:" + this.viewCallbacks.size() + " from " + bt.flS() + '}');
    if (this.viewCallbacks.size() == 1) {
      onAlive();
    }
  }
  
  public final void unregister(com.tencent.mm.view.d paramd)
  {
    p.h(paramd, "callback");
    synchronized ((Iterable)this.viewCallbacks)
    {
      localObject = ???.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.view.d locald = (com.tencent.mm.view.d)((Iterator)localObject).next();
        if (p.i(locald, paramd)) {
          this.viewCallbacks.remove(locald);
        }
      }
    }
    Object localObject = z.MKo;
    ad.i(getTAG(), "unregister callback " + paramd + " size " + this.viewCallbacks.size() + " from " + bt.flS() + '}');
    if (this.viewCallbacks.size() == 0) {
      onDead();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher
 * JD-Core Version:    0.7.0.1
 */