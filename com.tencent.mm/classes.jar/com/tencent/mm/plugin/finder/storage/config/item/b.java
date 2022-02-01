package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigUtil;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  public static final a vFL;
  
  static
  {
    AppMethodBeat.i(251933);
    vFL = new a((byte)0);
    AppMethodBeat.o(251933);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigUtil$Companion;", "", "()V", "getSpValue", "T", "spKey", "", "defValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "makePairList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "configDataList", "", "configDataNameList", "setSpValue", "", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class a
  {
    public static <T> LinkedList<o<T, String>> n(List<? extends T> paramList, List<String> paramList1)
    {
      AppMethodBeat.i(251932);
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
            j.hxH();
          }
          if (paramList1 != null)
          {
            String str = (String)j.L(paramList1, i);
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
      AppMethodBeat.o(251932);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.b
 * JD-Core Version:    0.7.0.1
 */