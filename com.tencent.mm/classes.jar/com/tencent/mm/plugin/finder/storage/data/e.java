package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder_release"})
public final class e
{
  private static final Map<Long, FinderItem> tsn;
  private static final Map<Long, FinderObject> vFU;
  private static final HashMap<Integer, LongSparseArray<FinderObject>> vFV;
  private static final HashMap<Integer, LongSparseArray<e.a.a>> vFW;
  public static final a vFX;
  
  static
  {
    AppMethodBeat.i(167047);
    vFX = new a((byte)0);
    tsn = Collections.synchronizedMap((Map)new HashMap());
    vFU = Collections.synchronizedMap((Map)new HashMap());
    vFV = new HashMap();
    vFW = new HashMap();
    AppMethodBeat.o(167047);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "cacheMegaVideoItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedCaches", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "Lkotlin/collections/HashMap;", "historyItems", "clean", "", "collectFeed", "commentScene", "feeds", "", "collectHistoryFeed", "tabType", "collectMegaVideoFeed", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getById", "id", "getFeedRecTime", "getMegaVideoById", "isHistoryFeed", "", "remove", "svrId", "removeMegaVideo", "update", "finder", "updateMegaVideo", "item", "FeedData", "plugin-finder_release"})
  public static final class a
  {
    public static boolean BX(long paramLong)
    {
      AppMethodBeat.i(251974);
      if (e.dyx().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(251974);
        return true;
      }
      AppMethodBeat.o(251974);
      return false;
    }
    
    public static FinderObject FD(long paramLong)
    {
      AppMethodBeat.i(251972);
      FinderObject localFinderObject = (FinderObject)e.dyy().get(Long.valueOf(paramLong));
      AppMethodBeat.o(251972);
      return localFinderObject;
    }
    
    public static boolean FE(long paramLong)
    {
      AppMethodBeat.i(251975);
      if (e.dyy().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(251975);
        return true;
      }
      AppMethodBeat.o(251975);
      return false;
    }
    
    public static FinderItem Fy(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)e.dyx().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
    
    public static long ak(int paramInt, long paramLong)
    {
      AppMethodBeat.i(251978);
      synchronized (e.dyz())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)e.dyz().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = e.vFX;
          localObject1 = new LongSparseArray();
          ((Map)e.dyz()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.g(localObject1, "feedCaches[commentScene]…  cache\n                }");
        if (((LongSparseArray)localObject1).indexOfKey(paramLong) >= 0)
        {
          localObject1 = (a)((LongSparseArray)localObject1).get(paramLong);
          if (localObject1 != null) {}
          for (paramLong = ((a)localObject1).vFZ;; paramLong = 0L)
          {
            AppMethodBeat.o(251978);
            return paramLong;
          }
        }
        AppMethodBeat.o(251978);
        return 0L;
      }
    }
    
    public static boolean al(int paramInt, long paramLong)
    {
      AppMethodBeat.i(251980);
      synchronized (e.dyA())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)e.dyA().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = e.vFX;
          localObject1 = new LongSparseArray();
          ((Map)e.dyA()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.g(localObject1, "historyItems[tabType] ?:…  cache\n                }");
        paramInt = ((LongSparseArray)localObject1).indexOfKey(paramLong);
        if (paramInt >= 0)
        {
          bool = true;
          AppMethodBeat.o(251980);
          return bool;
        }
        boolean bool = false;
      }
    }
    
    public static void j(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(251973);
      p.h(paramFinderObject, "item");
      Object localObject = paramFinderObject.attachmentList;
      if (localObject != null)
      {
        localObject = ((aoq)localObject).LAM;
        if (localObject != null)
        {
          localObject = (aop)j.kt((List)localObject);
          if (localObject != null)
          {
            localObject = ((aop)localObject).LAL;
            if (localObject != null)
            {
              localObject = ((bei)localObject).LIA;
              if (localObject == null) {}
            }
          }
        }
      }
      for (localObject = Long.valueOf(((cng)localObject).id); localObject != null; localObject = null)
      {
        ((Number)localObject).longValue();
        Map localMap = e.dyy();
        p.g(localMap, "cacheMegaVideoItems");
        localMap.put(localObject, paramFinderObject);
        AppMethodBeat.o(251973);
        return;
      }
      AppMethodBeat.o(251973);
    }
    
    public static void k(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(251976);
      p.h(paramList, "feeds");
      label146:
      for (;;)
      {
        synchronized (e.dyz())
        {
          Object localObject = (LongSparseArray)e.dyz().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label146;
          }
          localObject = e.vFX;
          localObject = new LongSparseArray();
          ((Map)e.dyz()).put(Integer.valueOf(paramInt), localObject);
          p.g(localObject, "feedCaches[commentScene]…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, new a((a)localFinderObject));
          }
        }
        paramList = x.SXb;
        AppMethodBeat.o(251976);
        return;
      }
    }
    
    public static void l(int paramInt, List<? extends cng> paramList)
    {
      AppMethodBeat.i(251977);
      p.h(paramList, "feeds");
      label146:
      for (;;)
      {
        synchronized (e.dyz())
        {
          Object localObject = (LongSparseArray)e.dyz().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label146;
          }
          localObject = e.vFX;
          localObject = new LongSparseArray();
          ((Map)e.dyz()).put(Integer.valueOf(paramInt), localObject);
          p.g(localObject, "feedCaches[commentScene]…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            cng localcng = (cng)paramList.next();
            ((LongSparseArray)localObject).append(localcng.id, new a((a)localcng));
          }
        }
        paramList = x.SXb;
        AppMethodBeat.o(251977);
        return;
      }
    }
    
    public static void m(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(251979);
      p.h(paramList, "feeds");
      label136:
      for (;;)
      {
        synchronized (e.dyA())
        {
          Object localObject = (LongSparseArray)e.dyA().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label136;
          }
          localObject = e.vFX;
          localObject = new LongSparseArray();
          ((Map)e.dyA()).put(Integer.valueOf(paramInt), localObject);
          p.g(localObject, "historyItems[tabType] ?:…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, localFinderObject);
          }
        }
        paramList = x.SXb;
        AppMethodBeat.o(251979);
        return;
      }
    }
    
    public static boolean n(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      p.h(paramFinderItem, "finder");
      Map localMap = e.dyx();
      p.g(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "", "feed", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "recTime", "", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;J)V", "getFeed", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getRecTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      private final a vFY;
      final long vFZ;
      
      private a(a parama, long paramLong)
      {
        AppMethodBeat.i(251967);
        this.vFY = parama;
        this.vFZ = paramLong;
        AppMethodBeat.o(251967);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(251971);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!p.j(this.vFY, paramObject.vFY)) || (this.vFZ != paramObject.vFZ)) {}
          }
        }
        else
        {
          AppMethodBeat.o(251971);
          return true;
        }
        AppMethodBeat.o(251971);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(251970);
        a locala = this.vFY;
        if (locala != null) {}
        for (int i = locala.hashCode();; i = 0)
        {
          long l = this.vFZ;
          int j = (int)(l ^ l >>> 32);
          AppMethodBeat.o(251970);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(251969);
        String str = "FeedData(feed=" + this.vFY + ", recTime=" + this.vFZ + ")";
        AppMethodBeat.o(251969);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e
 * JD-Core Version:    0.7.0.1
 */