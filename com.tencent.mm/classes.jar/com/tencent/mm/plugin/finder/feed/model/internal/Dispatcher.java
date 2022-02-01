package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.j;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "()V", "dispatcher", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "merger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getMerger", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "createDataMerger", "onAlive", "", "onDead", "register", "callback", "unregister", "STATUS", "plugin-finder_release"})
public abstract class Dispatcher<T extends i>
  extends DataStore<T>
{
  private final d<T> dispatcher = new d(this.viewCallbacks);
  private final b<T> merger = createDataMerger();
  private final LinkedList<j> viewCallbacks = new LinkedList();
  
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
  
  public final void register(j paramj)
  {
    p.h(paramj, "callback");
    this.viewCallbacks.add(paramj);
    Log.i(getTAG(), "register callback " + paramj + " size:" + this.viewCallbacks.size());
    if (this.viewCallbacks.size() == 1) {
      onAlive();
    }
  }
  
  public final void unregister(j paramj)
  {
    p.h(paramj, "callback");
    synchronized ((Iterable)this.viewCallbacks)
    {
      localObject = ???.iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        if (p.j(localj, paramj)) {
          this.viewCallbacks.remove(localj);
        }
      }
    }
    Object localObject = x.SXb;
    Log.i(getTAG(), "unregister callback " + paramj + " size " + this.viewCallbacks.size() + " from " + Util.getStack() + '}');
    if (this.viewCallbacks.size() == 0) {
      onDead();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher
 * JD-Core Version:    0.7.0.1
 */