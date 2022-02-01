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

public final class d
{
  public static HashMap<String, Integer> oRt;
  
  static
  {
    AppMethodBeat.i(20597);
    HashMap localHashMap = new HashMap();
    oRt = localHashMap;
    localHashMap.put(MMApplicationContext.getPackageName(), Integer.valueOf(0));
    oRt.put(MMApplicationContext.getPackageName() + ":push", Integer.valueOf(20));
    oRt.put(MMApplicationContext.getPackageName() + ":tools", Integer.valueOf(40));
    oRt.put(MMApplicationContext.getPackageName() + ":exdevice", Integer.valueOf(60));
    oRt.put(MMApplicationContext.getPackageName() + ":sandbox", Integer.valueOf(80));
    AppMethodBeat.o(20597);
  }
  
  public static void bLK()
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
        ((a)localObject).lNX += 1;
        if (localRecoveryStatusItem.processStartFlag != 1) {
          break label263;
        }
        ((a)localObject).oRw += 1;
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
        ((a)localObject).oRx += 1;
        break label171;
        if (localRecoveryStatusItem.processStartFlag == 1)
        {
          localb.oRz += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.oRH += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.oRD += 1;
            i = 1;
            break;
          }
        }
        else
        {
          localb.oRA += 1;
          switch (localRecoveryStatusItem.processStatus)
          {
          default: 
            break;
          case 4096: 
            localb.oRI += 1;
            i = 1;
            break;
          case 65536: 
          case 1048576: 
            localb.oRE += 1;
            i = 1;
            continue;
            if (localRecoveryStatusItem.processStartFlag == 1)
            {
              localb.oRB += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.oRJ += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.oRF += 1;
                i = 1;
                break;
              }
            }
            else
            {
              localb.oRC += 1;
              switch (localRecoveryStatusItem.processStatus)
              {
              default: 
                break;
              case 4096: 
                localb.oRK += 1;
                i = 1;
                break;
              case 65536: 
              case 1048576: 
                localb.oRG += 1;
                i = 1;
              }
            }
            break;
          }
        }
      }
    }
    c(localHashMap1);
    d(localHashMap2);
    RecoveryReporter.clearReportFile(MMApplicationContext.getContext(), "ProcessStatus");
    AppMethodBeat.o(20594);
  }
  
  private static void c(HashMap<String, a> paramHashMap)
  {
    AppMethodBeat.i(20595);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (oRt.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)oRt.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (a)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((a)localObject).lNX > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((a)localObject).lNX);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).oRu > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((a)localObject).oRu);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).oRv > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((a)localObject).oRv);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).oRw > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((a)localObject).oRw);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).oRx > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((a)localObject).oRx);
          localArrayList.add(localIDKey);
        }
        if (((a)localObject).oRy > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(424);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((a)localObject).oRy);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.OAn.b(localArrayList, true);
    }
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", new Object[] { MMApplicationContext.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20595);
  }
  
  private static void d(HashMap<String, b> paramHashMap)
  {
    AppMethodBeat.i(20596);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (oRt.containsKey(((Map.Entry)localObject).getKey()))
      {
        int i = ((Integer)oRt.get(((Map.Entry)localObject).getKey())).intValue();
        localObject = (b)((Map.Entry)localObject).getValue();
        IDKey localIDKey;
        if (((b)localObject).oRz > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 0);
          localIDKey.SetValue(((b)localObject).oRz);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRA > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 1);
          localIDKey.SetValue(((b)localObject).oRA);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRB > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 2);
          localIDKey.SetValue(((b)localObject).oRB);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRC > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 3);
          localIDKey.SetValue(((b)localObject).oRC);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRD > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 4);
          localIDKey.SetValue(((b)localObject).oRD);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRE > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 5);
          localIDKey.SetValue(((b)localObject).oRE);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRF > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 6);
          localIDKey.SetValue(((b)localObject).oRF);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRG > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 7);
          localIDKey.SetValue(((b)localObject).oRG);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRH > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 8);
          localIDKey.SetValue(((b)localObject).oRH);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRI > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 9);
          localIDKey.SetValue(((b)localObject).oRI);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRJ > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 10);
          localIDKey.SetValue(((b)localObject).oRJ);
          localArrayList.add(localIDKey);
        }
        if (((b)localObject).oRK > 0)
        {
          localIDKey = new IDKey();
          localIDKey.SetID(442);
          localIDKey.SetKey(i + 11);
          localIDKey.SetValue(((b)localObject).oRK);
          localArrayList.add(localIDKey);
        }
      }
    }
    if (localArrayList.size() > 0) {
      h.OAn.b(localArrayList, true);
    }
    Log.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", new Object[] { MMApplicationContext.getProcessName(), paramHashMap.toString() });
    AppMethodBeat.o(20596);
  }
  
  public static final class a
  {
    public int lNX;
    public int oRu;
    public int oRv;
    public int oRw;
    public int oRx;
    public int oRy;
    
    public final String toString()
    {
      AppMethodBeat.i(20592);
      Object localObject = new StringBuffer();
      if (this.lNX > 0) {
        ((StringBuffer)localObject).append("totalCount:" + this.lNX + " ");
      }
      if (this.oRu > 0) {
        ((StringBuffer)localObject).append("enterRecoveryCount:" + this.oRu + " ");
      }
      if (this.oRv > 0) {
        ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.oRv + " ");
      }
      if (this.oRw > 0) {
        ((StringBuffer)localObject).append("foregroundExpCount:" + this.oRw + " ");
      }
      if (this.oRx > 0) {
        ((StringBuffer)localObject).append("backgroundExpCount:" + this.oRx + " ");
      }
      if (this.oRy > 0) {
        ((StringBuffer)localObject).append("normalCount:" + this.oRy + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20592);
      return localObject;
    }
  }
  
  public static final class b
  {
    public int oRA;
    public int oRB;
    public int oRC;
    public int oRD;
    public int oRE;
    public int oRF;
    public int oRG;
    public int oRH;
    public int oRI;
    public int oRJ;
    public int oRK;
    public int oRz;
    
    public final String toString()
    {
      AppMethodBeat.i(20593);
      Object localObject = new StringBuffer();
      if (this.oRz > 0) {
        ((StringBuffer)localObject).append("appForegroundExpCount:" + this.oRz + " ");
      }
      if (this.oRA > 0) {
        ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.oRA + " ");
      }
      if (this.oRB > 0) {
        ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.oRB + " ");
      }
      if (this.oRC > 0) {
        ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.oRC + " ");
      }
      if (this.oRD > 0) {
        ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.oRD + " ");
      }
      if (this.oRE > 0) {
        ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.oRE + " ");
      }
      if (this.oRF > 0) {
        ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.oRF + " ");
      }
      if (this.oRG > 0) {
        ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.oRG + " ");
      }
      if (this.oRH > 0) {
        ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.oRH + " ");
      }
      if (this.oRI > 0) {
        ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.oRI + " ");
      }
      if (this.oRJ > 0) {
        ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.oRJ + " ");
      }
      if (this.oRK > 0) {
        ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.oRK + " ");
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(20593);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.d
 * JD-Core Version:    0.7.0.1
 */