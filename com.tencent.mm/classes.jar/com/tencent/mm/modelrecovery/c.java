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
  public static HashMap<String, Integer> jhL;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    jhL = localHashMap;
    localHashMap.put(MMApplicationContext.getPackageName(), Integer.valueOf(0));
    jhL.put(MMApplicationContext.getPackageName() + ":push", Integer.valueOf(20));
    jhL.put(MMApplicationContext.getPackageName() + ":tools", Integer.valueOf(40));
    jhL.put(MMApplicationContext.getPackageName() + ":exdevice", Integer.valueOf(60));
    jhL.put(MMApplicationContext.getPackageName() + ":sandbox", Integer.valueOf(80));
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
      if (jhL.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)jhL.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).gAZ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).gAZ);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).jhM > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).jhM);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).jhN > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).jhN);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).jhO > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).jhO);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).jhP > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).jhP);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).jhQ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).jhQ);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.CyF.b(localArrayList, true);
    }
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { MMApplicationContext.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20595);
  }
  
  public static void bey()
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
        ((a)localObject).gAZ += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).jhO += 1;
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
        ((a)localObject).jhP += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.jhR += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.jhZ += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.jhV += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.jhS += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.jia += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.jhW += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.jhT += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.jib += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.jhX += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.jhU += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.jic += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.jhY += 1;
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
      if (jhL.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)jhL.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).jhR > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).jhR);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhS > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).jhS);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhT > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).jhT);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhU > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).jhU);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhV > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).jhV);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhW > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).jhW);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhX > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).jhX);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhY > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).jhY);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jhZ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).jhZ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jia > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).jia);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jib > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).jib);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).jic > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).jic);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.CyF.b(localArrayList, true);
    }
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { MMApplicationContext.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int gAZ;
    public int jhM;
    public int jhN;
    public int jhO;
    public int jhP;
    public int jhQ;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.gAZ > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.gAZ + " ");
      }
      if (this.jhM > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.jhM + " ");
      }
      if (this.jhN > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.jhN + " ");
      }
      if (this.jhO > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.jhO + " ");
      }
      if (this.jhP > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.jhP + " ");
      }
      if (this.jhQ > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.jhQ + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int jhR;
    public int jhS;
    public int jhT;
    public int jhU;
    public int jhV;
    public int jhW;
    public int jhX;
    public int jhY;
    public int jhZ;
    public int jia;
    public int jib;
    public int jic;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.jhR > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.jhR + " ");
      }
      if (this.jhS > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.jhS + " ");
      }
      if (this.jhT > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.jhT + " ");
      }
      if (this.jhU > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.jhU + " ");
      }
      if (this.jhV > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.jhV + " ");
      }
      if (this.jhW > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.jhW + " ");
      }
      if (this.jhX > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.jhX + " ");
      }
      if (this.jhY > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.jhY + " ");
      }
      if (this.jhZ > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.jhZ + " ");
      }
      if (this.jia > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.jia + " ");
      }
      if (this.jib > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.jib + " ");
      }
      if (this.jic > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.jic + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20593);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.c
 * JD-Core Version:    0.7.0.1
 */