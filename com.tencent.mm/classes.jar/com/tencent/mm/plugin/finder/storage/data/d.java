package com.tencent.mm.plugin.finder.storage.data;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static final Map<Long, FinderItem> qWq;
  public static final a rEF;
  private static final HashMap<Integer, LongSparseArray<FinderObject>> uGJ;
  
  static
  {
    AppMethodBeat.i(167047);
    rEF = new a((byte)0);
    qWq = Collections.synchronizedMap((Map)new HashMap());
    uGJ = new HashMap();
    AppMethodBeat.o(167047);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "historyItems", "Ljava/util/HashMap;", "", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Lkotlin/collections/HashMap;", "clean", "", "collectHistoryFeed", "tabType", "feeds", "", "getById", "id", "isHistoryFeed", "", "remove", "svrId", "update", "finder", "plugin-finder_release"})
  public static final class a
  {
    public static boolean aQ(int paramInt, long paramLong)
    {
      AppMethodBeat.i(210191);
      synchronized (d.bBj())
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)d.bBj().get(Integer.valueOf(paramInt));
        Object localObject1 = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          localObject1 = d.rEF;
          localObject1 = new LongSparseArray();
          ((Map)d.bBj()).put(Integer.valueOf(paramInt), localObject1);
        }
        k.g(localObject1, "historyItems[tabType] ?:…  cache\n                }");
        paramInt = ((LongSparseArray)localObject1).indexOfKey(paramLong);
        if (paramInt >= 0)
        {
          bool = true;
          AppMethodBeat.o(210191);
          return bool;
        }
        boolean bool = false;
      }
    }
    
    public static boolean f(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      k.h(paramFinderItem, "finder");
      Map localMap = d.cBd();
      k.g(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    public static void r(int paramInt, List<? extends FinderObject> paramList)
    {
      AppMethodBeat.i(210190);
      k.h(paramList, "feeds");
      label136:
      for (;;)
      {
        synchronized (d.bBj())
        {
          Object localObject = (LongSparseArray)d.bBj().get(Integer.valueOf(paramInt));
          if (localObject != null) {
            break label136;
          }
          localObject = d.rEF;
          localObject = new LongSparseArray();
          ((Map)d.bBj()).put(Integer.valueOf(paramInt), localObject);
          k.g(localObject, "historyItems[tabType] ?:…  cache\n                }");
          paramList = ((Iterable)paramList).iterator();
          if (paramList.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)paramList.next();
            ((LongSparseArray)localObject).append(localFinderObject.id, localFinderObject);
          }
        }
        paramList = y.KTp;
        AppMethodBeat.o(210190);
        return;
      }
    }
    
    public static boolean rC(long paramLong)
    {
      AppMethodBeat.i(203023);
      if (d.cBd().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(203023);
        return true;
      }
      AppMethodBeat.o(203023);
      return false;
    }
    
    public static FinderItem uS(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)d.cBd().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.d
 * JD-Core Version:    0.7.0.1
 */