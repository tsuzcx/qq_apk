package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static HashMap<String, Integer> fMY;
  
  static
  {
    AppMethodBeat.i(16552);
    HashMap localHashMap = new HashMap();
    fMY = localHashMap;
    localHashMap.put(ah.getPackageName(), Integer.valueOf(0));
    fMY.put(ah.getPackageName() + ":push", Integer.valueOf(20));
    fMY.put(ah.getPackageName() + ":tools", Integer.valueOf(40));
    fMY.put(ah.getPackageName() + ":exdevice", Integer.valueOf(60));
    fMY.put(ah.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(16552);
  }
  
  public static void aiS()
  {
    AppMethodBeat.i(16549);
    Object localObject = RecoveryReporter.a(ah.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    ab.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      RecoveryStatusItem localRecoveryStatusItem = (RecoveryStatusItem)localIterator.next();
      label115:
      b.b localb;
      label142:
      label171:
      int i;
      if (localHashMap1.containsKey(localRecoveryStatusItem.processName))
      {
        localObject = (b.a)localHashMap1.get(localRecoveryStatusItem.processName);
        if (!localHashMap2.containsKey(localRecoveryStatusItem.processName)) {
          break label252;
        }
        localb = (b.b)localHashMap2.get(localRecoveryStatusItem.processName);
        ((b.a)localObject).eke += 1;
        if (localRecoveryStatusItem.Bij != 1) {
          break label263;
        }
        ((b.a)localObject).fNb += 1;
        i = 0;
        switch (localRecoveryStatusItem.Bil)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          ab.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
        }
        localHashMap1.put(localRecoveryStatusItem.processName, localObject);
        localHashMap2.put(localRecoveryStatusItem.processName, localb);
        break;
        localObject = new b.a();
        break label115;
        label252:
        localb = new b.b();
        break label142;
        label263:
        ((b.a)localObject).fNc += 1;
        break label171;
        if (localRecoveryStatusItem.Bij == 1)
        {
          localb.fNe += 1;
          switch (localRecoveryStatusItem.Bim)
          {
          default: 
            break;
          case 4096: 
            localb.fNm += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.fNi += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.fNf += 1;
          switch (localRecoveryStatusItem.Bim)
          {
          default: 
            break;
          case 4096: 
            localb.fNn += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.fNj += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.Bij == 1)
            {
              localb.fNg += 1;
              switch (localRecoveryStatusItem.Bim)
              {
              default: 
                break;
              case 4096: 
                localb.fNo += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.fNk += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.fNh += 1;
              switch (localRecoveryStatusItem.Bim)
              {
              default: 
                break;
              case 4096: 
                localb.fNp += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.fNl += 1;
                i = 1;
              }
            }
            break;
          }
        }
      }
    }
    i(localHashMap1);
    j(localHashMap2);
    RecoveryReporter.bW(ah.getContext(), "ProcessStatus");
    AppMethodBeat.o(16549);
  }
  
  private static void i(HashMap<String, b.a> paramHashMap)
  {
    AppMethodBeat.i(16550);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (fMY.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)fMY.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b.a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b.a)localObject).eke > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b.a)localObject).eke);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).fMZ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b.a)localObject).fMZ);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).fNa > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b.a)localObject).fNa);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).fNb > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b.a)localObject).fNb);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).fNc > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b.a)localObject).fNc);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).fNd > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b.a)localObject).fNd);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.qsU.b(localArrayList, true);
    }
    ab.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { ah.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(16550);
  }
  
  private static void j(HashMap<String, b.b> paramHashMap)
  {
    AppMethodBeat.i(16551);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (fMY.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)fMY.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b.b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b.b)localObject).fNe > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b.b)localObject).fNe);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNf > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b.b)localObject).fNf);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNg > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b.b)localObject).fNg);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNh > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b.b)localObject).fNh);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNi > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b.b)localObject).fNi);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNj > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b.b)localObject).fNj);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNk > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b.b)localObject).fNk);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNl > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b.b)localObject).fNl);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNm > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b.b)localObject).fNm);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNn > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b.b)localObject).fNn);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNo > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b.b)localObject).fNo);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).fNp > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b.b)localObject).fNp);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.qsU.b(localArrayList, true);
    }
    ab.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { ah.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(16551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b
 * JD-Core Version:    0.7.0.1
 */