package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
  public static HashMap<String, Integer> lYo;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    lYo = localHashMap;
    localHashMap.put(MMApplicationContext.getPackageName(), Integer.valueOf(0));
    lYo.put(MMApplicationContext.getPackageName() + ":push", Integer.valueOf(20));
    lYo.put(MMApplicationContext.getPackageName() + ":tools", Integer.valueOf(40));
    lYo.put(MMApplicationContext.getPackageName() + ":exdevice", Integer.valueOf(60));
    lYo.put(MMApplicationContext.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(20597);
  }
  
  private static void b(HashMap<String, a> paramHashMap)
  {
    AppMethodBeat.i(20595);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (lYo.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)lYo.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).jlf > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).jlf);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).lYp > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).lYp);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).lYq > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).lYq);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).lYr > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).lYr);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).lYs > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).lYs);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).lYt > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).lYt);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.IzE.b(localArrayList, true);
    }
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { MMApplicationContext.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20595);
  }
  
  public static void bnX()
  {
    AppMethodBeat.i(20594);
    Object localObject = RecoveryReporter.getItemList(MMApplicationContext.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
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
        ((a)localObject).jlf += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).lYr += 1;
        i = 0;
        switch (localRecoveryStatusItem.processStage)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          Log.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
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
        ((a)localObject).lYs += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.lYu += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.lYC += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.lYy += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.lYv += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.lYD += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.lYz += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.lYw += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.lYE += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.lYA += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.lYx += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.lYF += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.lYB += 1;
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
    RecoveryReporter.clearReportFile(MMApplicationContext.getContext(), "ProcessStatus");
    AppMethodBeat.o(20594);
  }
  
  private static void c(HashMap<String, b> paramHashMap)
  {
    AppMethodBeat.i(20596);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (lYo.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)lYo.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).lYu > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).lYu);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYv > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).lYv);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYw > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).lYw);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYx > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).lYx);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYy > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).lYy);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYz > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).lYz);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYA > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).lYA);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYB > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).lYB);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYC > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).lYC);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYD > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).lYD);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYE > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).lYE);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).lYF > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).lYF);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.IzE.b(localArrayList, true);
    }
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { MMApplicationContext.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int jlf;
    public int lYp;
    public int lYq;
    public int lYr;
    public int lYs;
    public int lYt;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.jlf > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.jlf + " ");
      }
      if (this.lYp > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.lYp + " ");
      }
      if (this.lYq > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.lYq + " ");
      }
      if (this.lYr > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.lYr + " ");
      }
      if (this.lYs > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.lYs + " ");
      }
      if (this.lYt > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.lYt + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int lYA;
    public int lYB;
    public int lYC;
    public int lYD;
    public int lYE;
    public int lYF;
    public int lYu;
    public int lYv;
    public int lYw;
    public int lYx;
    public int lYy;
    public int lYz;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.lYu > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.lYu + " ");
      }
      if (this.lYv > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.lYv + " ");
      }
      if (this.lYw > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.lYw + " ");
      }
      if (this.lYx > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.lYx + " ");
      }
      if (this.lYy > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.lYy + " ");
      }
      if (this.lYz > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.lYz + " ");
      }
      if (this.lYA > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.lYA + " ");
      }
      if (this.lYB > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.lYB + " ");
      }
      if (this.lYC > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.lYC + " ");
      }
      if (this.lYD > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.lYD + " ");
      }
      if (this.lYE > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.lYE + " ");
      }
      if (this.lYF > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.lYF + " ");
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