package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.cvy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder-base_release"})
public final class e
{
  private static final Map<Long, FinderObject> AmT;
  private static final HashMap<Integer, LongSparseArray<FinderObject>> AmU;
  private static final HashMap<Integer, LongSparseArray<e.a.a>> AmV;
  public static final a AmW;
  private static final Map<Long, FinderItem> wZM;
  
  static
  {
    AppMethodBeat.i(167047);
    AmW = new a((byte)0);
    wZM = Collections.synchronizedMap((Map)new HashMap());
    AmT = Collections.synchronizedMap((Map)new HashMap());
    AmU = new HashMap();
    AmV = new HashMap();
    AppMethodBeat.o(167047);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "cacheMegaVideoItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedCaches", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "Lkotlin/collections/HashMap;", "historyItems", "clean", "", "collectFeed", "commentScene", "feeds", "", "collectHistoryFeed", "tabType", "collectMegaVideoFeed", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getById", "id", "getFeedRecTime", "getMegaVideoById", "isHistoryFeed", "", "remove", "svrId", "removeMegaVideo", "update", "finder", "updateMegaVideo", "item", "FeedData", "plugin-finder-base_release"})
  public static final class a
  {
    public static boolean Ig(long paramLong)
    {
      AppMethodBeat.i(258101);
      if (e.dZp().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(258101);
        return true;
      }
      AppMethodBeat.o(258101);
      return false;
    }
    
    public static FinderItem MH(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)e.dZp().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
    
    public static FinderObject MM(long paramLong)
    {
      AppMethodBeat.i(258098);
      FinderObject localFinderObject = (FinderObject)e.dZq().get(Long.valueOf(paramLong));
      AppMethodBeat.o(258098);
      return localFinderObject;
    }
    
    public static boolean MN(long paramLong)
    {
      AppMethodBeat.i(258103);
      if (e.dZq().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(258103);
        return true;
      }
      AppMethodBeat.o(258103);
      return false;
    }
    
    public static boolean a(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(258099);
      p.k(paramFinderItem, "finder");
      Map localMap = e.dZp();
      p.j(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramLong), paramFinderItem);
      AppMethodBeat.o(258099);
      return true;
    }
    
    public static long an(int paramInt, long paramLong)
    {
      AppMethodBeat.i(258106);
      synchronized (e.dZr())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)e.dZr().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = e.AmW;
          localObject1 = new LongSparseArray();
          ((Map)e.dZr()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.j(localObject1, "feedCaches[commentScene]…  cache\n                }");
        if (((LongSparseArray)localObject1).indexOfKey(paramLong) >= 0)
        {
          localObject1 = (a)((LongSparseArray)localObject1).get(paramLong);
          if (localObject1 != null) {}
          for (paramLong = ((a)localObject1).AmY;; paramLong = 0L)
          {
            AppMethodBeat.o(258106);
            return paramLong;
          }
        }
        AppMethodBeat.o(258106);
        return 0L;
      }
    }
    
    public static boolean ao(int paramInt, long paramLong)
    {
      AppMethodBeat.i(258108);
      synchronized (e.dZs())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)e.dZs().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = e.AmW;
          localObject1 = new LongSparseArray();
          ((Map)e.dZs()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.j(localObject1, "historyItems[tabType] ?:…  cache\n                }");
        paramInt = ((LongSparseArray)localObject1).indexOfKey(paramLong);
        if (paramInt >= 0)
        {
          bool = true;
          AppMethodBeat.o(258108);
          return bool;
        }
        boolean bool = false;
      }
    }
    
    public static void m(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(258104);
      p.k(paramList, "feeds");
      label146:
      for (;;)
      {
        synchronized (e.dZr())
        {
          Object localObject = (LongSparseArray)e.dZr().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label146;
          }
          localObject = e.AmW;
          localObject = new LongSparseArray();
          ((Map)e.dZr()).put(Integer.valueOf(paramInt), localObject);
          p.j(localObject, "feedCaches[commentScene]…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, new a((a)localFinderObject));
          }
        }
        paramList = x.aazN;
        AppMethodBeat.o(258104);
        return;
      }
    }
    
    public static void n(int paramInt, List<? extends cvy> paramList)
    {
      AppMethodBeat.i(258105);
      p.k(paramList, "feeds");
      label146:
      for (;;)
      {
        synchronized (e.dZr())
        {
          Object localObject = (LongSparseArray)e.dZr().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label146;
          }
          localObject = e.AmW;
          localObject = new LongSparseArray();
          ((Map)e.dZr()).put(Integer.valueOf(paramInt), localObject);
          p.j(localObject, "feedCaches[commentScene]…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            cvy localcvy = (cvy)paramList.next();
            ((LongSparseArray)localObject).append(localcvy.id, new a((a)localcvy));
          }
        }
        paramList = x.aazN;
        AppMethodBeat.o(258105);
        return;
      }
    }
    
    public static void o(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(258107);
      p.k(paramList, "feeds");
      label136:
      for (;;)
      {
        synchronized (e.dZs())
        {
          Object localObject = (LongSparseArray)e.dZs().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label136;
          }
          localObject = e.AmW;
          localObject = new LongSparseArray();
          ((Map)e.dZs()).put(Integer.valueOf(paramInt), localObject);
          p.j(localObject, "historyItems[tabType] ?:…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, localFinderObject);
          }
        }
        paramList = x.aazN;
        AppMethodBeat.o(258107);
        return;
      }
    }
    
    public static void o(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(258100);
      p.k(paramFinderObject, "item");
      Object localObject = paramFinderObject.attachmentList;
      if (localObject != null)
      {
        localObject = ((apx)localObject).SDm;
        if (localObject != null)
        {
          localObject = (apw)j.lp((List)localObject);
          if (localObject != null)
          {
            localObject = ((apw)localObject).SDl;
            if (localObject != null)
            {
              localObject = ((blj)localObject).SPm;
              if (localObject == null) {}
            }
          }
        }
      }
      for (localObject = Long.valueOf(((cvy)localObject).id); localObject != null; localObject = null)
      {
        ((Number)localObject).longValue();
        Map localMap = e.dZq();
        p.j(localMap, "cacheMegaVideoItems");
        localMap.put(localObject, paramFinderObject);
        AppMethodBeat.o(258100);
        return;
      }
      AppMethodBeat.o(258100);
    }
    
    public static boolean o(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      p.k(paramFinderItem, "finder");
      Map localMap = e.dZp();
      p.j(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "", "feed", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "recTime", "", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;J)V", "getFeed", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getRecTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-base_release"})
    public static final class a
    {
      private final a AmX;
      final long AmY;
      
      private a(a parama, long paramLong)
      {
        AppMethodBeat.i(263266);
        this.AmX = parama;
        this.AmY = paramLong;
        AppMethodBeat.o(263266);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(263276);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!p.h(this.AmX, paramObject.AmX)) || (this.AmY != paramObject.AmY)) {}
          }
        }
        else
        {
          AppMethodBeat.o(263276);
          return true;
        }
        AppMethodBeat.o(263276);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(263274);
        a locala = this.AmX;
        if (locala != null) {}
        for (int i = locala.hashCode();; i = 0)
        {
          long l = this.AmY;
          int j = (int)(l ^ l >>> 32);
          AppMethodBeat.o(263274);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(263271);
        String str = "FeedData(feed=" + this.AmX + ", recTime=" + this.AmY + ")";
        AppMethodBeat.o(263271);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e
 * JD-Core Version:    0.7.0.1
 */