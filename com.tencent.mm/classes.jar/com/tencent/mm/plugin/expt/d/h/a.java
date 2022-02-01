package com.tencent.mm.plugin.expt.d.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.g;

public final class a
{
  public com.tencent.mm.plugin.expt.d.h.a.b qQp;
  
  public a()
  {
    AppMethodBeat.i(210278);
    this.qQp = new com.tencent.mm.plugin.expt.d.h.a.a();
    AppMethodBeat.o(210278);
  }
  
  public final Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> b(com.tencent.mm.plugin.expt.d.e.a.b paramb, Map<Long, List<String>> paramMap)
  {
    AppMethodBeat.i(210279);
    if ((paramb == null) || (paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(210279);
      return null;
    }
    if (g.ea(paramb.script))
    {
      AppMethodBeat.o(210279);
      return null;
    }
    if ((paramb.qQj == null) || (paramb.qQj.size() <= 0))
    {
      AppMethodBeat.o(210279);
      return null;
    }
    ad.d("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript configID : " + paramb.qQf);
    if (!this.qQp.adn(paramb.script))
    {
      ad.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript loadScript fail!");
      AppMethodBeat.o(210279);
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    break label211;
    break label211;
    break label211;
    label148:
    long l;
    Object localObject1;
    do
    {
      if (!localIterator1.hasNext()) {
        break;
      }
      l = ((Long)localIterator1.next()).longValue();
      localObject1 = (List)paramMap.get(Long.valueOf(l));
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Iterator localIterator2 = ((List)localObject1).iterator();
    label211:
    do
    {
      do
      {
        break label335;
        break label335;
        if (!localIterator2.hasNext()) {
          break label148;
        }
        localObject1 = (String)localIterator2.next();
        if (g.ea((String)localObject1)) {
          break;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("2,");
        ((StringBuilder)localObject2).append(new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()))).append(",");
        localObject1 = this.qQp.V("__main__", (String)localObject1, ((StringBuilder)localObject2).toString());
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        Iterator localIterator3 = ((List)localObject1).iterator();
        if (!localIterator3.hasNext()) {
          break;
        }
        localObject1 = (String)localIterator3.next();
      } while (g.ea((String)localObject1));
      localObject1 = ((String)localObject1).split(",");
    } while ((localObject1 == null) || (localObject1.length <= 0));
    label335:
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new com.tencent.mm.plugin.expt.d.e.b();
    ((com.tencent.mm.plugin.expt.d.e.b)localObject2).index = 0;
    ((com.tencent.mm.plugin.expt.d.e.b)localObject2).type = 2;
    ((com.tencent.mm.plugin.expt.d.e.b)localObject2).name = "report_time_ec";
    ((com.tencent.mm.plugin.expt.d.e.b)localObject2).qQe = l;
    localArrayList.add(localObject2);
    localObject2 = paramb.qQj.iterator();
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.plugin.expt.d.e.a.a locala;
        com.tencent.mm.plugin.expt.d.e.b localb;
        if (((Iterator)localObject2).hasNext())
        {
          locala = (com.tencent.mm.plugin.expt.d.e.a.a)((Iterator)localObject2).next();
          if ((locala.index <= 0) || (localObject1.length <= locala.index - 1) || (g.ea(localObject1[(locala.index - 1)]))) {
            continue;
          }
          localb = new com.tencent.mm.plugin.expt.d.e.b();
          localb.index = locala.index;
          localb.type = locala.type;
          localb.name = locala.name;
        }
        try
        {
          if (locala.type == 1) {
            localb.intValue = Integer.parseInt(localObject1[(locala.index - 1)]);
          }
          for (;;)
          {
            localArrayList.add(localb);
            break;
            if (locala.type == 2)
            {
              localb.qQe = Long.parseLong(localObject1[(locala.index - 1)]);
            }
            else
            {
              if (locala.type != 0) {
                break;
              }
              localb.stringValue = localObject1[(locala.index - 1)];
            }
          }
          Collections.sort(localArrayList, new Comparator() {});
          localObject2 = (List)localHashMap.get(Long.valueOf(l));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            localHashMap.put(Long.valueOf(l), localObject1);
          }
          ((List)localObject1).add(localArrayList);
        }
        catch (Exception localException) {}
      }
      AppMethodBeat.o(210279);
      return localHashMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.a
 * JD-Core Version:    0.7.0.1
 */