package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
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
  public static HashMap<String, Integer> exi;
  
  static
  {
    HashMap localHashMap = new HashMap();
    exi = localHashMap;
    localHashMap.put(ae.getPackageName(), Integer.valueOf(0));
    exi.put(ae.getPackageName() + ":push", Integer.valueOf(20));
    exi.put(ae.getPackageName() + ":tools", Integer.valueOf(40));
    exi.put(ae.getPackageName() + ":exdevice", Integer.valueOf(60));
    exi.put(ae.getPackageName() + ":sandbox", Integer.valueOf(80));
  }
  
  public static void PN()
  {
    Object localObject = RecoveryReporter.a(ae.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    y.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      RecoveryStatusItem localRecoveryStatusItem = (RecoveryStatusItem)localIterator.next();
      label109:
      b.b localb;
      label136:
      label165:
      int i;
      if (localHashMap1.containsKey(localRecoveryStatusItem.processName))
      {
        localObject = (b.a)localHashMap1.get(localRecoveryStatusItem.processName);
        if (!localHashMap2.containsKey(localRecoveryStatusItem.processName)) {
          break label248;
        }
        localb = (b.b)localHashMap2.get(localRecoveryStatusItem.processName);
        ((b.a)localObject).dsw += 1;
        if (localRecoveryStatusItem.wKI != 1) {
          break label259;
        }
        ((b.a)localObject).exl += 1;
        i = 0;
        switch (localRecoveryStatusItem.wKK)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          y.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
        }
        localHashMap1.put(localRecoveryStatusItem.processName, localObject);
        localHashMap2.put(localRecoveryStatusItem.processName, localb);
        break;
        localObject = new b.a();
        break label109;
        label248:
        localb = new b.b();
        break label136;
        label259:
        ((b.a)localObject).exm += 1;
        break label165;
        if (localRecoveryStatusItem.wKI == 1)
        {
          localb.exo += 1;
          switch (localRecoveryStatusItem.wKL)
          {
          default: 
            break;
          case 4096: 
            localb.exw += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.exs += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.exp += 1;
          switch (localRecoveryStatusItem.wKL)
          {
          default: 
            break;
          case 4096: 
            localb.exx += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.ext += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.wKI == 1)
            {
              localb.exq += 1;
              switch (localRecoveryStatusItem.wKL)
              {
              default: 
                break;
              case 4096: 
                localb.exy += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.exu += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.exr += 1;
              switch (localRecoveryStatusItem.wKL)
              {
              default: 
                break;
              case 4096: 
                localb.exz += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.exv += 1;
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
    RecoveryReporter.bJ(ae.getContext(), "ProcessStatus");
  }
  
  private static void i(HashMap<String, b.a> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (exi.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)exi.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b.a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b.a)localObject).dsw > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b.a)localObject).dsw);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).exj > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b.a)localObject).exj);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).exk > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b.a)localObject).exk);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).exl > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b.a)localObject).exl);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).exm > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b.a)localObject).exm);
          localArrayList.add(localIDKey);
        }
        if (((b.a)localObject).exn > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b.a)localObject).exn);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.nFQ.b(localArrayList, true);
    }
    y.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { ae.getProcessName(), paramHashMap.toString() });
  }
  
  private static void j(HashMap<String, b.b> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (exi.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)exi.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b.b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b.b)localObject).exo > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b.b)localObject).exo);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exp > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b.b)localObject).exp);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exq > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b.b)localObject).exq);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exr > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b.b)localObject).exr);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exs > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b.b)localObject).exs);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).ext > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b.b)localObject).ext);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exu > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b.b)localObject).exu);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exv > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b.b)localObject).exv);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exw > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b.b)localObject).exw);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exx > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b.b)localObject).exx);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exy > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b.b)localObject).exy);
          localArrayList.add(localIDKey);
        }
        if (((b.b)localObject).exz > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b.b)localObject).exz);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.nFQ.b(localArrayList, true);
    }
    y.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { ae.getProcessName(), paramHashMap.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b
 * JD-Core Version:    0.7.0.1
 */