package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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
  public static HashMap<String, Integer> imD;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    imD = localHashMap;
    localHashMap.put(ak.getPackageName(), Integer.valueOf(0));
    imD.put(ak.getPackageName() + ":push", Integer.valueOf(20));
    imD.put(ak.getPackageName() + ":tools", Integer.valueOf(40));
    imD.put(ak.getPackageName() + ":exdevice", Integer.valueOf(60));
    imD.put(ak.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(20597);
  }
  
  public static void aKv()
  {
    AppMethodBeat.i(20594);
    Object localObject = RecoveryReporter.getItemList(ak.getContext(), "ProcessStatus", RecoveryStatusItem.class);
    ae.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + ((List)localObject).size());
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
        ((a)localObject).fVS += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).imG += 1;
        i = 0;
        switch (localRecoveryStatusItem.processStage)
        {
        }
      }
      for (;;)
      {
        if (i == 0) {
          ae.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
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
        ((a)localObject).imH += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.imJ += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.imR += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.imN += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.imK += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.imS += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.imO += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.imL += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.imT += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.imP += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.imM += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.imU += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.imQ += 1;
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
    RecoveryReporter.clearReportFile(ak.getContext(), "ProcessStatus");
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
      if (imD.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)imD.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).fVS > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).fVS);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).imE > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).imE);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).imF > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).imF);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).imG > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).imG);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).imH > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).imH);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).imI > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).imI);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      g.yxI.b(localArrayList, true);
    }
    ae.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { ak.getProcessName(), paramHashMap.toString() });
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
      if (imD.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)imD.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).imJ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).imJ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imK > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).imK);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imL > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).imL);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imM > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).imM);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imN > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).imN);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imO > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).imO);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imP > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).imP);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imQ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).imQ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imR > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).imR);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imS > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).imS);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imT > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).imT);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).imU > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).imU);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      g.yxI.b(localArrayList, true);
    }
    ae.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { ak.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int fVS;
    public int imE;
    public int imF;
    public int imG;
    public int imH;
    public int imI;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.fVS > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.fVS + " ");
      }
      if (this.imE > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.imE + " ");
      }
      if (this.imF > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.imF + " ");
      }
      if (this.imG > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.imG + " ");
      }
      if (this.imH > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.imH + " ");
      }
      if (this.imI > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.imI + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int imJ;
    public int imK;
    public int imL;
    public int imM;
    public int imN;
    public int imO;
    public int imP;
    public int imQ;
    public int imR;
    public int imS;
    public int imT;
    public int imU;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.imJ > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.imJ + " ");
      }
      if (this.imK > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.imK + " ");
      }
      if (this.imL > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.imL + " ");
      }
      if (this.imM > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.imM + " ");
      }
      if (this.imN > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.imN + " ");
      }
      if (this.imO > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.imO + " ");
      }
      if (this.imP > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.imP + " ");
      }
      if (this.imQ > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.imQ + " ");
      }
      if (this.imR > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.imR + " ");
      }
      if (this.imS > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.imS + " ");
      }
      if (this.imT > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.imT + " ");
      }
      if (this.imU > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.imU + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20593);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.c
 * JD-Core Version:    0.7.0.1
 */