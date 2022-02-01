package com.tencent.mm.plugin.expt.d.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.i.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
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
  private com.tencent.mm.plugin.expt.d.i.a.b wes;
  
  public a()
  {
    AppMethodBeat.i(252257);
    this.wes = new com.tencent.mm.plugin.expt.d.i.a.a();
    dbS();
    AppMethodBeat.o(252257);
  }
  
  private void dbS()
  {
    AppMethodBeat.i(252259);
    Object localObject = new ArrayList();
    ((List)localObject).add(new com.tencent.mm.plugin.expt.d.i.b.a.a());
    ((List)localObject).add(new c());
    ((List)localObject).add(new com.tencent.mm.plugin.expt.d.i.b.a.b());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.expt.d.i.b.a locala = (com.tencent.mm.plugin.expt.d.i.b.a)((Iterator)localObject).next();
      if (!this.wes.a(locala)) {
        Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] registerJsApi fail, jsApi : " + locala.dbT());
      }
    }
    AppMethodBeat.o(252259);
  }
  
  public final Map<Long, List<List<com.tencent.mm.plugin.expt.d.f.b>>> a(com.tencent.mm.plugin.expt.d.f.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(252262);
    if ((paramb == null) || (paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(252262);
      return null;
    }
    if ((g.fK(paramb.script)) || (g.fK(paramb.wem)))
    {
      AppMethodBeat.o(252262);
      return null;
    }
    if (!g.oC(MD5Util.getMD5String(paramb.script), paramb.wem))
    {
      AppMethodBeat.o(252262);
      return null;
    }
    Log.i("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript configID : " + paramb.wdY);
    if (!this.wes.awq(paramb.script))
    {
      Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript loadScript fail!");
      AppMethodBeat.o(252262);
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    long l;
    Object localObject1;
    Object localObject3;
    int i;
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
      } while (g.fK((String)localObject1));
      localObject3 = this.wes;
      com.tencent.mm.plugin.expt.h.d.dgX();
      i = com.tencent.mm.plugin.expt.h.d.getUin();
      int j = com.tencent.mm.protocal.d.RAD;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("2,");
      ((StringBuilder)localObject4).append(new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong1))).append(",");
      ((StringBuilder)localObject4).append(paramLong1).append(",");
      ((StringBuilder)localObject4).append(paramLong2).append(",");
      ((StringBuilder)localObject4).append(i).append(",");
      ((StringBuilder)localObject4).append(j);
      localObject1 = ((com.tencent.mm.plugin.expt.d.i.a.b)localObject3).Y("__main__", (String)localObject1, ((StringBuilder)localObject4).toString());
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Object localObject4 = ((List)localObject1).iterator();
    label900:
    for (;;)
    {
      label407:
      ArrayList localArrayList;
      com.tencent.mm.plugin.expt.d.f.a.a locala;
      com.tencent.mm.plugin.expt.d.f.b localb;
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (String)((Iterator)localObject4).next();
        if (!g.fK((String)localObject1))
        {
          localObject1 = ((String)localObject1).split(",");
          if ((localObject1 != null) && (localObject1.length > 0) && (paramb.wee != null) && (paramb.wee.size() > 0))
          {
            localArrayList = new ArrayList();
            localObject3 = new com.tencent.mm.plugin.expt.d.f.b();
            ((com.tencent.mm.plugin.expt.d.f.b)localObject3).index = 0;
            ((com.tencent.mm.plugin.expt.d.f.b)localObject3).type = 2;
            ((com.tencent.mm.plugin.expt.d.f.b)localObject3).name = "report_time_ec";
            ((com.tencent.mm.plugin.expt.d.f.b)localObject3).wea = l;
            localArrayList.add(localObject3);
            localObject3 = paramb.wee.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                locala = (com.tencent.mm.plugin.expt.d.f.a.a)((Iterator)localObject3).next();
                if ((locala.index <= 0) || (localObject1.length <= locala.index - 1)) {
                  continue;
                }
                localb = new com.tencent.mm.plugin.expt.d.f.b();
                localb.index = locala.index;
                localb.type = locala.type;
                localb.name = locala.name;
                try
                {
                  if (locala.type == 1)
                  {
                    if (g.fK(localObject1[(locala.index - 1)])) {}
                    for (localb.intValue = 0;; localb.intValue = Integer.parseInt(localObject1[(locala.index - 1)]))
                    {
                      label654:
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
            break label900;
          }
          localObject3 = (List)localHashMap.get(Long.valueOf(l));
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            localHashMap.put(Long.valueOf(l), localObject2);
          }
          ((List)localObject2).add(localArrayList);
          break label407;
          break;
          if (locala.type == 2)
          {
            if (g.fK(localObject2[(locala.index - 1)]))
            {
              localb.wea = 0L;
              break label654;
            }
            localb.wea = Long.parseLong(localObject2[(locala.index - 1)]);
            break label654;
          }
          if (locala.type == 0)
          {
            if (g.fK(localObject2[(locala.index - 1)]))
            {
              localb.stringValue = "";
              break label654;
            }
            localb.stringValue = localObject2[(locala.index - 1)];
            break label654;
          }
          i = 1;
          continue;
          AppMethodBeat.o(252262);
          return localHashMap;
          i = 0;
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(252263);
    if (this.wes == null)
    {
      AppMethodBeat.o(252263);
      return;
    }
    this.wes.release();
    AppMethodBeat.o(252263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.a
 * JD-Core Version:    0.7.0.1
 */