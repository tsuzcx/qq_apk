package com.tencent.mm.plugin.expt.d.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.h.b.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.commons.b.g;

public final class a
{
  private com.tencent.mm.plugin.expt.d.h.a.b qYk;
  private Random qYl;
  
  public a()
  {
    AppMethodBeat.i(195932);
    this.qYk = new com.tencent.mm.plugin.expt.d.h.a.a();
    this.qYl = new Random(System.currentTimeMillis());
    AppMethodBeat.o(195932);
  }
  
  public final Map<Long, List<List<com.tencent.mm.plugin.expt.d.e.b>>> a(com.tencent.mm.plugin.expt.d.e.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195933);
    if ((paramb == null) || (paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(195933);
      return null;
    }
    if (g.ef(paramb.script))
    {
      AppMethodBeat.o(195933);
      return null;
    }
    ae.d("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript configID : " + paramb.qXW);
    String str = paramb.qXW + System.currentTimeMillis() + this.qYl.nextInt(10);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(new c(str, paramb.qXW));
    ((List)localObject1).add(new com.tencent.mm.plugin.expt.d.h.b.a.b(str, paramb.qXW));
    ((List)localObject1).add(new com.tencent.mm.plugin.expt.d.h.b.a.a(str, paramb.qXW));
    localObject1 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.expt.d.h.b.a)((Iterator)localObject1).next();
      if (!this.qYk.a((com.tencent.mm.plugin.expt.d.h.b.a)localObject3)) {
        ae.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript registerJsApi fail, jsApi : " + ((com.tencent.mm.plugin.expt.d.h.b.a)localObject3).coO());
      }
    }
    if (!this.qYk.aeh(paramb.script))
    {
      ae.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript loadScript fail!");
      AppMethodBeat.o(195933);
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    long l;
    do
    {
      do
      {
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            l = ((Long)localIterator1.next()).longValue();
            localObject1 = (List)paramMap.get(Long.valueOf(l));
          } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
          localIterator2 = ((List)localObject1).iterator();
        }
        localObject1 = (String)localIterator2.next();
      } while (g.ef((String)localObject1));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("2,");
      ((StringBuilder)localObject3).append(new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong1))).append(",");
      ((StringBuilder)localObject3).append(paramLong1).append(",");
      ((StringBuilder)localObject3).append(paramLong2).append(",");
      ((StringBuilder)localObject3).append(str).append(",");
      localObject1 = this.qYk.W("__main__", (String)localObject1, ((StringBuilder)localObject3).toString());
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Iterator localIterator3 = ((List)localObject1).iterator();
    label529:
    label1022:
    for (;;)
    {
      ArrayList localArrayList;
      com.tencent.mm.plugin.expt.d.e.a.a locala;
      com.tencent.mm.plugin.expt.d.e.b localb;
      int i;
      if (localIterator3.hasNext())
      {
        localObject1 = (String)localIterator3.next();
        if (!g.ef((String)localObject1))
        {
          localObject1 = ((String)localObject1).split(",");
          if ((localObject1 != null) && (localObject1.length > 0) && (paramb.qYc != null) && (paramb.qYc.size() > 0))
          {
            localArrayList = new ArrayList();
            localObject3 = new com.tencent.mm.plugin.expt.d.e.b();
            ((com.tencent.mm.plugin.expt.d.e.b)localObject3).index = 0;
            ((com.tencent.mm.plugin.expt.d.e.b)localObject3).type = 2;
            ((com.tencent.mm.plugin.expt.d.e.b)localObject3).name = "report_time_ec";
            ((com.tencent.mm.plugin.expt.d.e.b)localObject3).qXY = l;
            localArrayList.add(localObject3);
            localObject3 = paramb.qYc.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                locala = (com.tencent.mm.plugin.expt.d.e.a.a)((Iterator)localObject3).next();
                if ((locala.index <= 0) || (localObject1.length <= locala.index - 1)) {
                  continue;
                }
                localb = new com.tencent.mm.plugin.expt.d.e.b();
                localb.index = locala.index;
                localb.type = locala.type;
                localb.name = locala.name;
                try
                {
                  if (locala.type == 1)
                  {
                    if (g.ef(localObject1[(locala.index - 1)])) {}
                    for (localb.intValue = 0;; localb.intValue = Integer.parseInt(localObject1[(locala.index - 1)]))
                    {
                      localArrayList.add(localb);
                      break;
                    }
                    Collections.sort(localArrayList, new Comparator() {});
                  }
                }
                catch (Exception localException)
                {
                  i = 1;
                }
              }
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (i != 0) {
            break label1022;
          }
          localObject3 = (List)localHashMap.get(Long.valueOf(l));
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            localHashMap.put(Long.valueOf(l), localObject2);
          }
          ((List)localObject2).add(localArrayList);
          break label529;
          break;
          if (locala.type == 2)
          {
            if (g.ef(localObject2[(locala.index - 1)]))
            {
              localb.qXY = 0L;
              break label776;
            }
            localb.qXY = Long.parseLong(localObject2[(locala.index - 1)]);
            break label776;
          }
          if (locala.type == 0)
          {
            if (g.ef(localObject2[(locala.index - 1)]))
            {
              localb.stringValue = "";
              break label776;
            }
            localb.stringValue = localObject2[(locala.index - 1)];
            break label776;
          }
          i = 1;
          continue;
          AppMethodBeat.o(195933);
          return localHashMap;
          i = 0;
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(195934);
    if (this.qYk == null)
    {
      AppMethodBeat.o(195934);
      return;
    }
    this.qYk.release();
    AppMethodBeat.o(195934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.a
 * JD-Core Version:    0.7.0.1
 */