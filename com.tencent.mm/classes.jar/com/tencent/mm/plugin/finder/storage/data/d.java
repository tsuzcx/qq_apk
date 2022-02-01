package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static final Map<Long, FinderItem> rPw;
  private static final HashMap<Integer, LongSparseArray<FinderObject>> sKB;
  private static final HashMap<Integer, LongSparseArray<d.a.a>> sKC;
  public static final a sKD;
  
  static
  {
    AppMethodBeat.i(167047);
    sKD = new a((byte)0);
    rPw = Collections.synchronizedMap((Map)new HashMap());
    sKB = new HashMap();
    sKC = new HashMap();
    AppMethodBeat.o(167047);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "feedCaches", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "Lkotlin/collections/HashMap;", "historyItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "clean", "", "collectFeed", "commentScene", "feeds", "", "collectHistoryFeed", "tabType", "getById", "id", "getFeedRecTime", "isHistoryFeed", "", "remove", "svrId", "update", "finder", "FeedData", "plugin-finder_release"})
  public static final class a
  {
    public static long ae(int paramInt, long paramLong)
    {
      AppMethodBeat.i(204390);
      synchronized (d.cLG())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)d.cLG().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = d.sKD;
          localObject1 = new LongSparseArray();
          ((Map)d.cLG()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.g(localObject1, "feedCaches[commentScene]…  cache\n                }");
        if (((LongSparseArray)localObject1).indexOfKey(paramLong) >= 0)
        {
          localObject1 = (a)((LongSparseArray)localObject1).get(paramLong);
          if (localObject1 != null) {}
          for (paramLong = ((a)localObject1).sKF;; paramLong = 0L)
          {
            AppMethodBeat.o(204390);
            return paramLong;
          }
        }
        AppMethodBeat.o(204390);
        return 0L;
      }
    }
    
    public static boolean af(int paramInt, long paramLong)
    {
      AppMethodBeat.i(204392);
      synchronized (d.cLH())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)d.cLH().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = d.sKD;
          localObject1 = new LongSparseArray();
          ((Map)d.cLH()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.g(localObject1, "historyItems[tabType] ?:…  cache\n                }");
        paramInt = ((LongSparseArray)localObject1).indexOfKey(paramLong);
        if (paramInt >= 0)
        {
          bool = true;
          AppMethodBeat.o(204392);
          return bool;
        }
        boolean bool = false;
      }
    }
    
    public static boolean f(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      p.h(paramFinderItem, "finder");
      Map localMap = d.cLF();
      p.g(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    public static void i(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(204389);
      p.h(paramList, "feeds");
      label143:
      for (;;)
      {
        synchronized (d.cLG())
        {
          Object localObject = (LongSparseArray)d.cLG().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label143;
          }
          localObject = d.sKD;
          localObject = new LongSparseArray();
          ((Map)d.cLG()).put(Integer.valueOf(paramInt), localObject);
          p.g(localObject, "feedCaches[commentScene]…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, new a(localFinderObject));
          }
        }
        paramList = z.Nhr;
        AppMethodBeat.o(204389);
        return;
      }
    }
    
    public static void j(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(204391);
      p.h(paramList, "feeds");
      label136:
      for (;;)
      {
        synchronized (d.cLH())
        {
          Object localObject = (LongSparseArray)d.cLH().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label136;
          }
          localObject = d.sKD;
          localObject = new LongSparseArray();
          ((Map)d.cLH()).put(Integer.valueOf(paramInt), localObject);
          p.g(localObject, "historyItems[tabType] ?:…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, localFinderObject);
          }
        }
        paramList = z.Nhr;
        AppMethodBeat.o(204391);
        return;
      }
    }
    
    public static boolean tS(long paramLong)
    {
      AppMethodBeat.i(204388);
      if (d.cLF().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(204388);
        return true;
      }
      AppMethodBeat.o(204388);
      return false;
    }
    
    public static FinderItem xk(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)d.cLF().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "recTime", "", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;J)V", "getFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      private final FinderObject sKE;
      final long sKF;
      
      private a(FinderObject paramFinderObject, long paramLong)
      {
        AppMethodBeat.i(204383);
        this.sKE = paramFinderObject;
        this.sKF = paramLong;
        AppMethodBeat.o(204383);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(204387);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!p.i(this.sKE, paramObject.sKE)) || (this.sKF != paramObject.sKF)) {}
          }
        }
        else
        {
          AppMethodBeat.o(204387);
          return true;
        }
        AppMethodBeat.o(204387);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(204386);
        FinderObject localFinderObject = this.sKE;
        if (localFinderObject != null) {}
        for (int i = localFinderObject.hashCode();; i = 0)
        {
          long l = this.sKF;
          int j = (int)(l ^ l >>> 32);
          AppMethodBeat.o(204386);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(204385);
        String str = "FeedData(feed=" + this.sKE + ", recTime=" + this.sKF + ")";
        AppMethodBeat.o(204385);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */