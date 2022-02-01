package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  public static final a qKl;
  private static final Map<Long, FinderItem> qnU;
  
  static
  {
    AppMethodBeat.i(167047);
    qKl = new a((byte)0);
    qnU = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(167047);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderCache$Companion;", "", "()V", "TAG", "", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "", "clean", "", "getById", "id", "remove", "", "svrId", "update", "finder", "plugin-finder_release"})
  public static final class a
  {
    public static boolean e(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167046);
      k.h(paramFinderItem, "finder");
      Map localMap = b.cqE();
      k.g(localMap, "cacheItems");
      localMap.put(Long.valueOf(paramFinderItem.field_id), paramFinderItem);
      AppMethodBeat.o(167046);
      return true;
    }
    
    public static boolean nQ(long paramLong)
    {
      AppMethodBeat.i(190879);
      if (b.cqE().remove(Long.valueOf(paramLong)) != null)
      {
        AppMethodBeat.o(190879);
        return true;
      }
      AppMethodBeat.o(190879);
      return false;
    }
    
    public static FinderItem qC(long paramLong)
    {
      AppMethodBeat.i(167045);
      FinderItem localFinderItem = (FinderItem)b.cqE().get(Long.valueOf(paramLong));
      AppMethodBeat.o(167045);
      return localFinderItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.b
 * JD-Core Version:    0.7.0.1
 */