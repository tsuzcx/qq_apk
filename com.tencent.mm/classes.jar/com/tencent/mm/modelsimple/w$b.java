package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

public final class w$b
{
  public String desc;
  public LinkedList<w.a> fQb;
  public String title;
  
  public static LinkedList<w.a> f(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(78587);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < 1000)
    {
      Object localObject2 = new StringBuilder().append(paramString).append(".action");
      if (i > 0) {}
      for (Object localObject1 = Integer.valueOf(i);; localObject1 = "")
      {
        localObject1 = localObject1;
        try
        {
          int j = Integer.valueOf((String)paramMap.get((String)localObject1 + ".$type")).intValue();
          localObject2 = new w.a();
          if (j != 5) {
            break;
          }
          ((w.a)localObject2).ffD = bo.nullAsNil((String)paramMap.get((String)localObject1 + ".iconurl"));
          ((w.a)localObject2).desc = bo.nullAsNil((String)paramMap.get((String)localObject1 + ".desc"));
          ((w.a)localObject2).link = bo.nullAsNil((String)paramMap.get((String)localObject1 + ".link"));
          if ((!bo.isNullOrNil(((w.a)localObject2).ffD)) || (!bo.isNullOrNil(((w.a)localObject2).desc)) || (!bo.isNullOrNil(((w.a)localObject2).link))) {
            break label313;
          }
          AppMethodBeat.o(78587);
          return localLinkedList;
        }
        catch (Exception paramMap)
        {
          ab.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + paramMap.getMessage());
          AppMethodBeat.o(78587);
          return localLinkedList;
        }
      }
      AppMethodBeat.o(78587);
      return localLinkedList;
      label313:
      localLinkedList.add(localObject2);
      i += 1;
    }
    AppMethodBeat.o(78587);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w.b
 * JD-Core Version:    0.7.0.1
 */