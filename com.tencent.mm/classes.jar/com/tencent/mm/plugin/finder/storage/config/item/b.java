package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l;
import d.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  public static final a szA;
  
  static
  {
    AppMethodBeat.i(203771);
    szA = new a((byte)0);
    AppMethodBeat.o(203771);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigUtil$Companion;", "", "()V", "getSpValue", "T", "spKey", "", "defValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "makePairList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "configDataList", "", "configDataNameList", "setSpValue", "", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class a
  {
    public static <T> LinkedList<o<T, String>> l(List<? extends T> paramList, List<String> paramList1)
    {
      AppMethodBeat.i(203770);
      LinkedList localLinkedList = new LinkedList();
      if (paramList != null)
      {
        paramList = (Iterable)paramList;
        int i = 0;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (i < 0) {
            j.gfB();
          }
          if (paramList1 != null)
          {
            String str = (String)j.E(paramList1, i);
            paramList = str;
            if (str != null) {}
          }
          else
          {
            paramList = "";
          }
          localLinkedList.add(new o(localObject, paramList));
          i += 1;
        }
      }
      AppMethodBeat.o(203770);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.b
 * JD-Core Version:    0.7.0.1
 */