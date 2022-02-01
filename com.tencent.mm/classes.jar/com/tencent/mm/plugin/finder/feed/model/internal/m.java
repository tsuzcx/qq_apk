package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore;", "", "()V", "Companion", "GroupContract", "GroupObserver", "GroupOwner", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a Bkx;
  private static final ConcurrentHashMap<String, b> Bky;
  
  static
  {
    AppMethodBeat.i(366517);
    Bkx = new a((byte)0);
    Bky = new ConcurrentHashMap();
    AppMethodBeat.o(366517);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$Companion;", "", "()V", "GROUP_AT_FEED", "", "TAG", "groupMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupContract;", "getOwner", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "key", "notifyAllItemChange", "", "idMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "notifyItemChange", "pos", "feedId", "onOwnerAlive", "onOwnerDead", "registerObserver", "observer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "registerOwner", "owner", "unRegisterObserver", "unregisterOwner", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void A(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(366620);
      s.u(paramString, "key");
      if (m.edX().keySet().contains(paramString))
      {
        paramString = (m.b)m.edX().get(paramString);
        if ((paramString != null) && (paramString.Bkz != null))
        {
          paramString = paramString.BkA.iterator();
          while (paramString.hasNext()) {
            ((m.c)paramString.next()).al(paramInt, paramLong);
          }
        }
      }
      AppMethodBeat.o(366620);
    }
    
    public static void c(String paramString, HashMap<Long, Integer> paramHashMap)
    {
      AppMethodBeat.i(366624);
      s.u(paramString, "key");
      s.u(paramHashMap, "idMap");
      if (m.edX().keySet().contains(paramString))
      {
        paramString = (m.b)m.edX().get(paramString);
        if ((paramString != null) && (paramString.Bkz != null))
        {
          paramString = paramString.BkA.iterator();
          while (paramString.hasNext()) {
            ((m.c)paramString.next()).p(paramHashMap);
          }
        }
      }
      AppMethodBeat.o(366624);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupContract;", "", "()V", "observers", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "getObservers", "()Ljava/util/List;", "owner", "Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "getOwner", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "setOwner", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final List<m.c> BkA;
    public m.d Bkz;
    
    public b()
    {
      AppMethodBeat.i(366615);
      this.BkA = ((List)new ArrayList());
      AppMethodBeat.o(366615);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupObserver;", "", "()V", "fetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isObserveOnOwnerInactive", "", "observeKey", "", "onAllItemChange", "", "idMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onItemChange", "pos", "feedId", "onOwnerAlive", "onOwnerDead", "onUpdate", "changes", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class c
  {
    public void al(int paramInt, long paramLong) {}
    
    public abstract String edY();
    
    public final DataBuffer<cc> edZ()
    {
      Object localObject = m.Bkx;
      localObject = edY();
      s.u(localObject, "key");
      if (m.edX().keySet().contains(localObject))
      {
        localObject = (m.b)m.edX().get(localObject);
        if (localObject == null) {}
      }
      for (localObject = ((m.b)localObject).Bkz; localObject == null; localObject = null) {
        return null;
      }
      return ((m.d)localObject).eed();
    }
    
    public void eea() {}
    
    public void eeb() {}
    
    public void p(HashMap<Long, Integer> paramHashMap)
    {
      s.u(paramHashMap, "idMap");
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/LoaderShareStore$GroupOwner;", "", "()V", "alive", "", "dataSource", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dead", "groupKey", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class d
  {
    public abstract String eec();
    
    public abstract DataBuffer<cc> eed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.m
 * JD-Core Version:    0.7.0.1
 */