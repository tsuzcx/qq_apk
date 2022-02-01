package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
  public static HashMap<String, Integer> hQw;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    hQw = localHashMap;
    localHashMap.put(ai.getPackageName(), Integer.valueOf(0));
    hQw.put(ai.getPackageName() + ":push", Integer.valueOf(20));
    hQw.put(ai.getPackageName() + ":tools", Integer.valueOf(40));
    hQw.put(ai.getPackageName() + ":exdevice", Integer.valueOf(60));
    hQw.put(ai.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(20597);
  }
  
  public static void aGR()
  {
    AppMethodBeat.i(20594);
    Object localObject = RecoveryReporter.getItemList(ai.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    ac.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
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
        ((a)localObject).fAw += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).hQz += 1;
        i = 0;
        switch (localRecoveryStatusItem.processStage)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          ac.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
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
        ((a)localObject).hQA += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.hQC += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.hQK += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.hQG += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.hQD += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.hQL += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.hQH += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.hQE += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.hQM += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.hQI += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.hQF += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.hQN += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.hQJ += 1;
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
    RecoveryReporter.clearReportFile(ai.getContext(), "ProcessStatus");
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
      if (hQw.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)hQw.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).fAw > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).fAw);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hQx > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).hQx);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hQy > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).hQy);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hQz > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).hQz);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hQA > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).hQA);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).hQB > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).hQB);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.wUl.b(localArrayList, true);
    }
    ac.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { ai.getProcessName(), paramHashMap.toString() });
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
      if (hQw.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)hQw.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).hQC > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).hQC);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQD > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).hQD);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQE > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).hQE);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQF > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).hQF);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQG > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).hQG);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQH > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).hQH);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQI > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).hQI);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQJ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).hQJ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQK > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).hQK);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQL > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).hQL);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQM > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).hQM);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).hQN > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).hQN);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.wUl.b(localArrayList, true);
    }
    ac.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { ai.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int fAw;
    public int hQA;
    public int hQB;
    public int hQx;
    public int hQy;
    public int hQz;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.fAw > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.fAw + " ");
      }
      if (this.hQx > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.hQx + " ");
      }
      if (this.hQy > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.hQy + " ");
      }
      if (this.hQz > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.hQz + " ");
      }
      if (this.hQA > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.hQA + " ");
      }
      if (this.hQB > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.hQB + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int hQC;
    public int hQD;
    public int hQE;
    public int hQF;
    public int hQG;
    public int hQH;
    public int hQI;
    public int hQJ;
    public int hQK;
    public int hQL;
    public int hQM;
    public int hQN;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.hQC > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.hQC + " ");
      }
      if (this.hQD > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.hQD + " ");
      }
      if (this.hQE > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.hQE + " ");
      }
      if (this.hQF > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.hQF + " ");
      }
      if (this.hQG > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.hQG + " ");
      }
      if (this.hQH > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.hQH + " ");
      }
      if (this.hQI > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.hQI + " ");
      }
      if (this.hQJ > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.hQJ + " ");
      }
      if (this.hQK > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.hQK + " ");
      }
      if (this.hQL > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.hQL + " ");
      }
      if (this.hQM > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.hQM + " ");
      }
      if (this.hQN > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.hQN + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20593);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.c
 * JD-Core Version:    0.7.0.1
 */