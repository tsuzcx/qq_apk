package com.tencent.mm.modelsimple;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

public final class v$b
{
  public String desc;
  public LinkedList<v.a> eAm;
  public String title;
  
  public static LinkedList<v.a> f(Map<String, String> paramMap, String paramString)
  {
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
          localObject2 = new v.a();
          if (j != 5) {
            break;
          }
          ((v.a)localObject2).dPV = bk.pm((String)paramMap.get((String)localObject1 + ".iconurl"));
          ((v.a)localObject2).desc = bk.pm((String)paramMap.get((String)localObject1 + ".desc"));
          ((v.a)localObject2).eAl = bk.pm((String)paramMap.get((String)localObject1 + ".link"));
          if ((!bk.bl(((v.a)localObject2).dPV)) || (!bk.bl(((v.a)localObject2).desc)) || (!bk.bl(((v.a)localObject2).eAl))) {
            break label293;
          }
          return localLinkedList;
        }
        catch (Exception paramMap)
        {
          y.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + paramMap.getMessage());
          return localLinkedList;
        }
      }
      return localLinkedList;
      label293:
      localLinkedList.add(localObject2);
      i += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v.b
 * JD-Core Version:    0.7.0.1
 */