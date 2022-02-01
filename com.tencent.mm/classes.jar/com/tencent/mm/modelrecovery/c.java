package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
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
  public static HashMap<String, Integer> ijK;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    ijK = localHashMap;
    localHashMap.put(aj.getPackageName(), Integer.valueOf(0));
    ijK.put(aj.getPackageName() + ":push", Integer.valueOf(20));
    ijK.put(aj.getPackageName() + ":tools", Integer.valueOf(40));
    ijK.put(aj.getPackageName() + ":exdevice", Integer.valueOf(60));
    ijK.put(aj.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(20597);
  }
  
  public static void aKc()
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
        ((a)localObject).fTM += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).ijN += 1;
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
        ((a)localObject).ijO += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.ijQ += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.ijY += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.ijU += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.ijR += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.ijZ += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.ijV += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.ijS += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.ika += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.ijW += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.ijT += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.ikb += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.ijX += 1;
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
      if (ijK.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)ijK.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).fTM > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).fTM);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).ijL > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).ijL);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).ijM > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).ijM);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).ijN > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).ijN);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).ijO > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).ijO);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).ijP > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).ijP);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      g.yhR.b(localArrayList, true);
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
      if (ijK.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)ijK.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).ijQ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).ijQ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijR > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).ijR);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijS > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).ijS);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijT > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).ijT);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijU > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).ijU);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijV > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).ijV);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijW > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).ijW);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijX > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).ijX);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijY > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).ijY);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ijZ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).ijZ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ika > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).ika);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).ikb > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).ikb);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      g.yhR.b(localArrayList, true);
    }
    ad.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { aj.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int fTM;
    public int ijL;
    public int ijM;
    public int ijN;
    public int ijO;
    public int ijP;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.fTM > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.fTM + " ");
      }
      if (this.ijL > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.ijL + " ");
      }
      if (this.ijM > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.ijM + " ");
      }
      if (this.ijN > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.ijN + " ");
      }
      if (this.ijO > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.ijO + " ");
      }
      if (this.ijP > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.ijP + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int ijQ;
    public int ijR;
    public int ijS;
    public int ijT;
    public int ijU;
    public int ijV;
    public int ijW;
    public int ijX;
    public int ijY;
    public int ijZ;
    public int ika;
    public int ikb;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.ijQ > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.ijQ + " ");
      }
      if (this.ijR > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.ijR + " ");
      }
      if (this.ijS > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.ijS + " ");
      }
      if (this.ijT > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.ijT + " ");
      }
      if (this.ijU > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.ijU + " ");
      }
      if (this.ijV > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.ijV + " ");
      }
      if (this.ijW > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.ijW + " ");
      }
      if (this.ijX > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.ijX + " ");
      }
      if (this.ijY > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.ijY + " ");
      }
      if (this.ijZ > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.ijZ + " ");
      }
      if (this.ika > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.ika + " ");
      }
      if (this.ikb > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.ikb + " ");
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