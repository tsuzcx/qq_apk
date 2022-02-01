package com.tencent.mm.plugin.findersdk.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigUtil;", "", "()V", "Companion", "finder-sdk_release"})
public final class b
{
  public static final a BwD;
  
  static
  {
    AppMethodBeat.i(207821);
    BwD = new a((byte)0);
    AppMethodBeat.o(207821);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigUtil$Companion;", "", "()V", "getSpValue", "T", "spKey", "", "defValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "makePairList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "configDataList", "", "configDataNameList", "setSpValue", "", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "finder-sdk_release"})
  public static final class a
  {
    public static <T> LinkedList<o<T, String>> q(List<? extends T> paramList, List<String> paramList1)
    {
      AppMethodBeat.i(209863);
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
            j.iBO();
          }
          if (paramList1 != null)
          {
            String str = (String)j.M(paramList1, i);
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
      AppMethodBeat.o(209863);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */