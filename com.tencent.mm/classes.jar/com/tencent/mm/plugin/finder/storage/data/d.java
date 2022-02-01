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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static final Map<Long, FinderItem> rHl;
  private static final HashMap<Integer, LongSparseArray<FinderObject>> szH;
  public static final a szI;
  
  static
  {
    AppMethodBeat.i(167047);
    szI = new a((byte)0);
    rHl = Collections.synchronizedMap((Map)new HashMap());
    szH = new HashMap();
    AppMethodBeat.o(167047);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "historyItems", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Lkotlin/collections/HashMap;", "clean", "", "collectHistoryFeed", "tabType", "feeds", "", "getById", "id", "isHistoryFeed", "", "remove", "svrId", "update", "finder", "plugin-finder_release"})
  public static final class a
  {
    public static boolean af(int paramInt, long paramLong)
    {
      AppMethodBeat.i(203801);
      synchronized (d.cJe())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)d.cJe().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = d.szI;
          localObject1 = new LongSparseArray();
          ((Map)d.cJe()).put(Integer.valueOf(paramInt), localObject1);
        }
        p.g(localObject1, "historyItems[tabType] ?:…  cache\n                }");
        paramInt = ((LongSparseArray)localObject1).indexOfKey(paramLong);
        if (paramInt >= 0)
        {
          bool = true;
          AppMethodBeat.o(203801);
          return bool;
        }
        boolean bool = false;
      }
    }
    
    public static boolean f(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      p.h(paramFinderItem, "finder");
      Map localMap = d.cJd();
      p.g(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    public static void i(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(203800);
      p.h(paramList, "feeds");
      label136:
      for (;;)
      {
        synchronized (d.cJe())
        {
          Object localObject = (LongSparseArray)d.cJe().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label136;
          }
          localObject = d.szI;
          localObject = new LongSparseArray();
          ((Map)d.cJe()).put(Integer.valueOf(paramInt), localObject);
          p.g(localObject, "historyItems[tabType] ?:…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, localFinderObject);
          }
        }
        paramList = z.MKo;
        AppMethodBeat.o(203800);
        return;
      }
    }
    
    public static boolean tB(long paramLong)
    {
      AppMethodBeat.i(203799);
      if (d.cJd().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(203799);
        return true;
      }
      AppMethodBeat.o(203799);
      return false;
    }
    
    public static FinderItem wT(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)d.cJd().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */