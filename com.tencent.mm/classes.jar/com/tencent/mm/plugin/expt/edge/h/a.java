package com.tencent.mm.plugin.expt.edge.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.edge.h.b.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
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
import org.apache.commons.c.i;

public final class a
{
  public com.tencent.mm.plugin.expt.edge.h.a.b zAn;
  private List<com.tencent.mm.plugin.expt.edge.h.b.a> zAo;
  
  public a()
  {
    AppMethodBeat.i(299726);
    this.zAn = new com.tencent.mm.plugin.expt.edge.h.a.a();
    this.zAo = new ArrayList();
    dIw();
    AppMethodBeat.o(299726);
  }
  
  public static String b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(299741);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2,");
    localStringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong1))).append(",");
    localStringBuilder.append(paramLong1).append(",");
    localStringBuilder.append(paramLong2).append(",");
    localStringBuilder.append(paramString).append(",");
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(299741);
    return paramString;
  }
  
  private void dIw()
  {
    AppMethodBeat.i(299734);
    this.zAo.add(new com.tencent.mm.plugin.expt.edge.h.b.a.a());
    this.zAo.add(new c());
    this.zAo.add(new com.tencent.mm.plugin.expt.edge.h.b.a.b());
    Iterator localIterator = this.zAo.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.expt.edge.h.b.a locala = (com.tencent.mm.plugin.expt.edge.h.b.a)localIterator.next();
      if (!this.zAn.a(locala)) {
        Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] registerJsApi fail, jsApi : " + locala.dIx());
      }
    }
    AppMethodBeat.o(299734);
  }
  
  public final Map<Long, List<List<com.tencent.mm.plugin.expt.edge.e.b>>> a(com.tencent.mm.plugin.expt.edge.e.a.b paramb, Map<Long, List<String>> paramMap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(299758);
    if ((paramb == null) || (paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(299758);
      return null;
    }
    if ((i.hm(paramb.script)) || (i.hm(paramb.zAg)))
    {
      AppMethodBeat.o(299758);
      return null;
    }
    if (!i.qA(MD5Util.getMD5String(paramb.script), paramb.zAg))
    {
      AppMethodBeat.o(299758);
      return null;
    }
    Log.i("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript configID : " + paramb.zzS);
    if (!this.zAn.aqt(paramb.script))
    {
      Log.e("EdgeComputingScriptService", "[EdgeComputingScriptService] executeScript loadScript fail!");
      AppMethodBeat.o(299758);
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    long l;
    Object localObject1;
    Object localObject3;
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
      } while (i.hm((String)localObject1));
      localObject3 = this.zAn;
      h.baC();
      localObject1 = ((com.tencent.mm.plugin.expt.edge.h.a.b)localObject3).ab("__main__", (String)localObject1, b(p.getString(com.tencent.mm.kernel.b.getUin()), d.Yxh, paramLong1, paramLong2));
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    Iterator localIterator3 = ((List)localObject1).iterator();
    label808:
    for (;;)
    {
      label313:
      ArrayList localArrayList;
      com.tencent.mm.plugin.expt.edge.e.a.a locala;
      com.tencent.mm.plugin.expt.edge.e.b localb;
      label560:
      int i;
      if (localIterator3.hasNext())
      {
        localObject1 = (String)localIterator3.next();
        if (!i.hm((String)localObject1))
        {
          localObject1 = ((String)localObject1).split(",");
          if ((localObject1 != null) && (localObject1.length > 0) && (paramb.zzY != null) && (paramb.zzY.size() > 0))
          {
            localArrayList = new ArrayList();
            localObject3 = new com.tencent.mm.plugin.expt.edge.e.b();
            ((com.tencent.mm.plugin.expt.edge.e.b)localObject3).index = 0;
            ((com.tencent.mm.plugin.expt.edge.e.b)localObject3).type = 2;
            ((com.tencent.mm.plugin.expt.edge.e.b)localObject3).name = "report_time_ec";
            ((com.tencent.mm.plugin.expt.edge.e.b)localObject3).zzU = l;
            localArrayList.add(localObject3);
            localObject3 = paramb.zzY.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                locala = (com.tencent.mm.plugin.expt.edge.e.a.a)((Iterator)localObject3).next();
                if ((locala.index <= 0) || (localObject1.length <= locala.index - 1)) {
                  continue;
                }
                localb = new com.tencent.mm.plugin.expt.edge.e.b();
                localb.index = locala.index;
                localb.type = locala.type;
                localb.name = locala.name;
                try
                {
                  if (locala.type == 1)
                  {
                    if (i.hm(localObject1[(locala.index - 1)])) {}
                    for (localb.qDL = 0;; localb.qDL = Util.getInt(localObject1[(locala.index - 1)], 0))
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
            break label808;
          }
          localObject3 = (List)localHashMap.get(Long.valueOf(l));
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            localHashMap.put(Long.valueOf(l), localObject2);
          }
          ((List)localObject2).add(localArrayList);
          break label313;
          break;
          if (locala.type == 2)
          {
            if (i.hm(localObject2[(locala.index - 1)]))
            {
              localb.zzU = 0L;
              break label560;
            }
            localb.zzU = Util.getLong(localObject2[(locala.index - 1)], 0L);
            break label560;
          }
          if (locala.type == 0)
          {
            if (i.hm(localObject2[(locala.index - 1)]))
            {
              localb.stringValue = "";
              break label560;
            }
            localb.stringValue = localObject2[(locala.index - 1)];
            break label560;
          }
          i = 1;
          continue;
          AppMethodBeat.o(299758);
          return localHashMap;
          i = 0;
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(299766);
    if (this.zAn != null) {
      this.zAn.release();
    }
    if (this.zAo.size() > 0)
    {
      Iterator localIterator = this.zAo.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.expt.edge.h.b.a)localIterator.next()).release();
      }
      this.zAo.clear();
    }
    AppMethodBeat.o(299766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.h.a
 * JD-Core Version:    0.7.0.1
 */