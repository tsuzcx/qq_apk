package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dne;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final Map<Long, FinderItem> AwX;
  public static final a FMN;
  private static final Map<Long, FinderObject> FMO;
  private static final HashMap<Integer, LongSparseArray<FinderObject>> FMP;
  private static final HashMap<Integer, LongSparseArray<e.a.a>> FMQ;
  
  static
  {
    AppMethodBeat.i(167047);
    FMN = new a((byte)0);
    AwX = Collections.synchronizedMap((Map)new HashMap());
    FMO = Collections.synchronizedMap((Map)new HashMap());
    FMP = new HashMap();
    FMQ = new HashMap();
    AppMethodBeat.o(167047);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "cacheMegaVideoItems", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "feedCaches", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "Lkotlin/collections/HashMap;", "historyItems", "clean", "", "collectFeed", "commentScene", "feeds", "", "collectHistoryFeed", "tabType", "collectMegaVideoFeed", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getById", "id", "getFeedRecTime", "getMegaVideoById", "isHistoryFeed", "", "putIfNotExist", "finder", "remove", "svrId", "removeMegaVideo", "update", "updateMegaVideo", "item", "FeedData", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void H(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(339321);
      s.u(paramList, "feeds");
      label140:
      for (;;)
      {
        synchronized (e.faa())
        {
          Object localObject = (LongSparseArray)e.faa().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label140;
          }
          localObject = e.FMN;
          localObject = new LongSparseArray();
          ((Map)e.faa()).put(Integer.valueOf(paramInt), localObject);
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, new a((a)localFinderObject));
          }
        }
        paramList = ah.aiuX;
        AppMethodBeat.o(339321);
        return;
      }
    }
    
    public static void I(int paramInt, List<? extends dne> paramList)
    {
      AppMethodBeat.i(339328);
      s.u(paramList, "feeds");
      label140:
      for (;;)
      {
        synchronized (e.faa())
        {
          Object localObject = (LongSparseArray)e.faa().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label140;
          }
          localObject = e.FMN;
          localObject = new LongSparseArray();
          ((Map)e.faa()).put(Integer.valueOf(paramInt), localObject);
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            dne localdne = (dne)paramList.next();
            ((LongSparseArray)localObject).append(localdne.id, new a((a)localdne));
          }
        }
        paramList = ah.aiuX;
        AppMethodBeat.o(339328);
        return;
      }
    }
    
    public static void J(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(339341);
      s.u(paramList, "feeds");
      label130:
      for (;;)
      {
        synchronized (e.fab())
        {
          Object localObject = (LongSparseArray)e.fab().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label130;
          }
          localObject = e.FMN;
          localObject = new LongSparseArray();
          ((Map)e.fab()).put(Integer.valueOf(paramInt), localObject);
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, localFinderObject);
          }
        }
        paramList = ah.aiuX;
        AppMethodBeat.o(339341);
        return;
      }
    }
    
    public static long at(int paramInt, long paramLong)
    {
      AppMethodBeat.i(339333);
      synchronized (e.faa())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)e.faa().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = e.FMN;
          localObject1 = new LongSparseArray();
          ((Map)e.faa()).put(Integer.valueOf(paramInt), localObject1);
        }
        if (((LongSparseArray)localObject1).indexOfKey(paramLong) >= 0)
        {
          localObject1 = (a)((LongSparseArray)localObject1).get(paramLong);
          if (localObject1 == null) {}
          for (paramLong = 0L;; paramLong = ((a)localObject1).FMS)
          {
            AppMethodBeat.o(339333);
            return paramLong;
          }
        }
        AppMethodBeat.o(339333);
        return 0L;
      }
    }
    
    public static boolean au(int paramInt, long paramLong)
    {
      AppMethodBeat.i(339345);
      synchronized (e.fab())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)e.fab().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = e.FMN;
          localObject1 = new LongSparseArray();
          ((Map)e.fab()).put(Integer.valueOf(paramInt), localObject1);
        }
        paramInt = ((LongSparseArray)localObject1).indexOfKey(paramLong);
        if (paramInt >= 0)
        {
          bool = true;
          AppMethodBeat.o(339345);
          return bool;
        }
        boolean bool = false;
      }
    }
    
    public static boolean b(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(339288);
      s.u(paramFinderItem, "finder");
      Map localMap = e.eZY();
      s.s(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramLong), paramFinderItem);
      AppMethodBeat.o(339288);
      return true;
    }
    
    public static FinderItem jn(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)e.eZY().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
    
    public static boolean ky(long paramLong)
    {
      AppMethodBeat.i(339306);
      if (e.eZY().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(339306);
        return true;
      }
      AppMethodBeat.o(339306);
      return false;
    }
    
    public static FinderObject qh(long paramLong)
    {
      AppMethodBeat.i(339279);
      FinderObject localFinderObject = (FinderObject)e.eZZ().get(Long.valueOf(paramLong));
      AppMethodBeat.o(339279);
      return localFinderObject;
    }
    
    public static boolean qi(long paramLong)
    {
      AppMethodBeat.i(339314);
      if (e.eZZ().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(339314);
        return true;
      }
      AppMethodBeat.o(339314);
      return false;
    }
    
    public static void r(FinderObject paramFinderObject)
    {
      AppMethodBeat.i(339298);
      s.u(paramFinderObject, "item");
      Object localObject1 = paramFinderObject.attachmentList;
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2;
        if (localObject1 != null)
        {
          ((Number)localObject1).longValue();
          localObject2 = e.eZZ();
          s.s(localObject2, "cacheMegaVideoItems");
          ((Map)localObject2).put(localObject1, paramFinderObject);
        }
        AppMethodBeat.o(339298);
        return;
        localObject1 = ((atr)localObject1).ZEi;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject2 = ((Iterable)localObject1).iterator();
          label83:
          int i;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            if (((atq)localObject1).type == 1)
            {
              i = 1;
              label112:
              if (i == 0) {
                break label133;
              }
            }
          }
          for (;;)
          {
            localObject1 = (atq)localObject1;
            if (localObject1 != null) {
              break label140;
            }
            localObject1 = null;
            break;
            i = 0;
            break label112;
            label133:
            break label83;
            localObject1 = null;
          }
          label140:
          localObject1 = ((atq)localObject1).ZEf;
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = ((byx)localObject1).ZXx;
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = Long.valueOf(((dne)localObject1).id);
            }
          }
        }
      }
    }
    
    public static boolean s(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      s.u(paramFinderItem, "finder");
      Map localMap = e.eZY();
      s.s(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion$FeedData;", "", "feed", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "recTime", "", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;J)V", "getFeed", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getRecTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private final a FMR;
      final long FMS;
      
      private a(a parama, long paramLong)
      {
        AppMethodBeat.i(339371);
        this.FMR = parama;
        this.FMS = paramLong;
        AppMethodBeat.o(339371);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(339390);
        if (this == paramObject)
        {
          AppMethodBeat.o(339390);
          return true;
        }
        if (!(paramObject instanceof a))
        {
          AppMethodBeat.o(339390);
          return false;
        }
        paramObject = (a)paramObject;
        if (!s.p(this.FMR, paramObject.FMR))
        {
          AppMethodBeat.o(339390);
          return false;
        }
        if (this.FMS != paramObject.FMS)
        {
          AppMethodBeat.o(339390);
          return false;
        }
        AppMethodBeat.o(339390);
        return true;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(339385);
        int i = this.FMR.hashCode();
        int j = q.a..ExternalSyntheticBackport0.m(this.FMS);
        AppMethodBeat.o(339385);
        return i * 31 + j;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(339379);
        String str = "FeedData(feed=" + this.FMR + ", recTime=" + this.FMS + ')';
        AppMethodBeat.o(339379);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.e
 * JD-Core Version:    0.7.0.1
 */