package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public static HashMap<String, Integer> hpU;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    hpU = localHashMap;
    localHashMap.put(aj.getPackageName(), Integer.valueOf(0));
    hpU.put(aj.getPackageName() + ":push", Integer.valueOf(20));
    hpU.put(aj.getPackageName() + ":tools", Integer.valueOf(40));
    hpU.put(aj.getPackageName() + ":exdevice", Integer.valueOf(60));
    hpU.put(aj.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(20597);
  }
  
  public static void aAb()
  {
    AppMethodBeat.i(20594);
    Object localObject = RecoveryReporter.getItemList(aj.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    ad.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      RecoveryStatusItem localRecoveryStatusItem = (RecoveryStatusItem)localIterator.next();
      label115:
      b localb;
      label142:
      label171:
      int i;
      if (localHashMap1.containsKey(localRecoveryStatusItem.processName))
      {
        localObject = (a)localHashMap1.get(localRecoveryStatusItem.processName);
        if (!localHashMap2.containsKey(localRecoveryStatusItem.processName)) {
          break label252;
        }
        localb = (b)localHashMap2.get(localRecoveryStatusItem.processName);
        ((a)localObject).fwP += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).hpX += 1;
        i = 0;
        switch (localRecoveryStatusItem.processStage)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          ad.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
        }
        localHashMap1.put(localRecoveryStatusItem.processName, localObject);
        localHashMap2.put(localRecoveryStatusItem.processName, localb);
        break;
        localObject = new a();
        break label115;
        label252:
        localb = new b();
        break label142;
        label263:
        ((a)localObject).hpY += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.hqa += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.hqi += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.hqe += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.hqb += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.hqj += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.hqf += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.hqc += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.hqk += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.hqg += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.hqd += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.hql += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.hqh += 1;
                i = 1;
              }
            }
            break;
          }
        }
      }
    }
    b(localHashMap1);
    c(localHashMap2);
    RecoveryReporter.clearReportFile(aj.getContext(), "ProcessStatus");
    AppMethodBeat.o(20594);
  }
  
  private static void b(HashMap<String, a> paramHashMap)
  {
    AppMethodBeat.i(20595);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (hpU.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)hpU.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).fwP > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).fwP);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hpV > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).hpV);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hpW > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).hpW);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hpX > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).hpX);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hpY > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).hpY);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hpZ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).hpZ);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.vKh.b(localArrayList, true);
    }
    ad.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { aj.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20595);
  }
  
  private static void c(HashMap<String, b> paramHashMap)
  {
    AppMethodBeat.i(20596);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (hpU.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)hpU.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).hqa > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).hqa);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqb > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).hqb);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqc > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).hqc);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqd > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).hqd);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqe > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).hqe);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqf > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).hqf);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqg > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).hqg);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqh > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).hqh);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqi > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).hqi);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqj > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).hqj);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hqk > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).hqk);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hql > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).hql);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.vKh.b(localArrayList, true);
    }
    ad.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { aj.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int fwP;
    public int hpV;
    public int hpW;
    public int hpX;
    public int hpY;
    public int hpZ;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.fwP > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.fwP + " ");
      }
      if (this.hpV > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.hpV + " ");
      }
      if (this.hpW > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.hpW + " ");
      }
      if (this.hpX > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.hpX + " ");
      }
      if (this.hpY > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.hpY + " ");
      }
      if (this.hpZ > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.hpZ + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int hqa;
    public int hqb;
    public int hqc;
    public int hqd;
    public int hqe;
    public int hqf;
    public int hqg;
    public int hqh;
    public int hqi;
    public int hqj;
    public int hqk;
    public int hql;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.hqa > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.hqa + " ");
      }
      if (this.hqb > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.hqb + " ");
      }
      if (this.hqc > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.hqc + " ");
      }
      if (this.hqd > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.hqd + " ");
      }
      if (this.hqe > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.hqe + " ");
      }
      if (this.hqf > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.hqf + " ");
      }
      if (this.hqg > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.hqg + " ");
      }
      if (this.hqh > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.hqh + " ");
      }
      if (this.hqi > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.hqi + " ");
      }
      if (this.hqj > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.hqj + " ");
      }
      if (this.hqk > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.hqk + " ");
      }
      if (this.hql > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.hql + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20593);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.c
 * JD-Core Version:    0.7.0.1
 */