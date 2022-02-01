package com.tencent.mm.plugin.findersdk.storage.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigUtil;", "", "()V", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a HdO;
  
  static
  {
    AppMethodBeat.i(273817);
    HdO = new a((byte)0);
    AppMethodBeat.o(273817);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigUtil$Companion;", "", "()V", "getSpValue", "T", "spKey", "", "defValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "makePairList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "configDataList", "", "configDataNameList", "setSpValue", "", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T> LinkedList<r<T, String>> B(List<? extends T> paramList, List<String> paramList1)
    {
      AppMethodBeat.i(273803);
      LinkedList localLinkedList = new LinkedList();
      if (paramList != null)
      {
        paramList = (Iterable)paramList;
        int i = 0;
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (i < 0) {
            p.kkW();
          }
          if (paramList1 == null) {
            paramList = "";
          }
          for (;;)
          {
            localLinkedList.add(new r(localObject, paramList));
            i += 1;
            break;
            String str = (String)p.ae(paramList1, i);
            paramList = str;
            if (str == null) {
              paramList = "";
            }
          }
        }
      }
      AppMethodBeat.o(273803);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a.b
 * JD-Core Version:    0.7.0.1
 */