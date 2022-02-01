package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore;", "", "()V", "Companion", "GroupContract", "GroupObserver", "GroupOwner", "plugin-finder-base_release"})
public final class m
{
  private static final ConcurrentHashMap<String, b> xKJ;
  public static final a xKK;
  
  static
  {
    AppMethodBeat.i(261392);
    xKK = new a((byte)0);
    xKJ = new ConcurrentHashMap();
    AppMethodBeat.o(261392);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$Companion;", "", "()V", "GROUP_AT_FEED", "", "TAG", "groupMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupContract;", "getOwner", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "key", "notifyAllItemChange", "", "idMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "notifyItemChange", "pos", "feedId", "onOwnerAlive", "onOwnerDead", "registerObserver", "observer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "registerOwner", "owner", "unRegisterObserver", "unregisterOwner", "plugin-finder-base_release"})
  public static final class a
  {
    public static void A(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(258929);
      p.k(paramString, "key");
      if (m.duy().keySet().contains(paramString))
      {
        paramString = (m.b)m.duy().get(paramString);
        if (paramString != null)
        {
          if (paramString.xKL != null)
          {
            paramString = paramString.xKM.iterator();
            while (paramString.hasNext()) {
              ((m.c)paramString.next()).ah(paramInt, paramLong);
            }
          }
          AppMethodBeat.o(258929);
          return;
        }
      }
      AppMethodBeat.o(258929);
    }
    
    public static void c(String paramString, HashMap<Long, Integer> paramHashMap)
    {
      AppMethodBeat.i(258931);
      p.k(paramString, "key");
      p.k(paramHashMap, "idMap");
      if (m.duy().keySet().contains(paramString))
      {
        paramString = (m.b)m.duy().get(paramString);
        if (paramString != null)
        {
          if (paramString.xKL != null)
          {
            paramString = paramString.xKM.iterator();
            while (paramString.hasNext()) {
              ((m.c)paramString.next()).l(paramHashMap);
            }
          }
          AppMethodBeat.o(258931);
          return;
        }
      }
      AppMethodBeat.o(258931);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupContract;", "", "()V", "observers", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "getObservers", "()Ljava/util/List;", "owner", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "getOwner", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "setOwner", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;)V", "plugin-finder-base_release"})
  public static final class b
  {
    public m.d xKL;
    public final List<m.c> xKM;
    
    public b()
    {
      AppMethodBeat.i(262672);
      this.xKM = ((List)new ArrayList());
      AppMethodBeat.o(262672);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "", "()V", "fetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isObserveOnOwnerInactive", "", "observeKey", "", "onAllItemChange", "", "idMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onItemChange", "pos", "feedId", "onOwnerAlive", "onOwnerDead", "onUpdate", "changes", "", "plugin-finder-base_release"})
  public static abstract class c
  {
    public void ah(int paramInt, long paramLong) {}
    
    public final DataBuffer<bu> duA()
    {
      Object localObject = m.xKK;
      localObject = duz();
      p.k(localObject, "key");
      if (m.duy().keySet().contains(localObject))
      {
        localObject = (m.b)m.duy().get(localObject);
        if (localObject == null) {}
      }
      for (localObject = ((m.b)localObject).xKL; localObject != null; localObject = null) {
        return ((m.d)localObject).duE();
      }
      return null;
    }
    
    public void duB() {}
    
    public void duC() {}
    
    public abstract String duz();
    
    public void l(HashMap<Long, Integer> paramHashMap)
    {
      p.k(paramHashMap, "idMap");
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "", "()V", "alive", "", "dataSource", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dead", "groupKey", "", "plugin-finder-base_release"})
  public static abstract class d
  {
    public abstract String duD();
    
    public abstract DataBuffer<bu> duE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.m
 * JD-Core Version:    0.7.0.1
 */