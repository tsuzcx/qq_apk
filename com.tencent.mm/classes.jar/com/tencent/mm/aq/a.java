package com.tencent.mm.aq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

public final class a
{
  private static boolean active;
  private static Future dBj;
  private static final c oCo;
  private static boolean oCp;
  private static long oCq;
  private static long oCr;
  
  static
  {
    AppMethodBeat.i(132522);
    active = false;
    oCo = new c();
    oCp = true;
    oCq = 0L;
    oCr = 0L;
    AppMethodBeat.o(132522);
  }
  
  public static void D(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132513);
    if (!oCp)
    {
      AppMethodBeat.o(132513);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132513);
      return;
    }
    Object localObject = oCo;
    c.c localc = new c.c(cn.bDu(), System.currentTimeMillis(), paramInt, paramLong);
    localObject = ((c)localObject).oCC;
    if (((c.a)localObject).oCK.size() > 30000)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < 100) {
          try
          {
            ((c.a)localObject).oCK.remove(0);
            paramInt += 1;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ActiveDetector.ProcessDetector", "addSendInterProcessList %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
    ((c.a)localObject).oCK.add(localc);
    AppMethodBeat.o(132513);
  }
  
  public static void E(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132514);
    if (!oCp)
    {
      AppMethodBeat.o(132514);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132514);
      return;
    }
    Object localObject = oCo;
    c.c localc = new c.c(cn.bDu(), System.currentTimeMillis(), paramInt, paramLong);
    localObject = ((c)localObject).oCC;
    if (((c.a)localObject).oCL.size() > 30000)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt < 100) {
          try
          {
            ((c.a)localObject).oCL.remove(0);
            paramInt += 1;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.ActiveDetector.ProcessDetector", "addReceiveInterProcessList %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
    ((c.a)localObject).oCL.add(localc);
    AppMethodBeat.o(132514);
  }
  
  private static a a(c.c paramc, int paramInt)
  {
    AppMethodBeat.i(132521);
    if (paramc == null)
    {
      AppMethodBeat.o(132521);
      return null;
    }
    a locala = new a();
    locala.oCs = paramc.oCs;
    locala.startTime = paramc.time;
    locala.endTime = paramc.time;
    locala.type = paramInt;
    locala.oCv = paramc.type;
    AppMethodBeat.o(132521);
    return locala;
  }
  
  private static a a(c.d paramd, int paramInt)
  {
    AppMethodBeat.i(132520);
    if (paramd == null)
    {
      AppMethodBeat.o(132520);
      return null;
    }
    a locala = new a();
    locala.oCs = paramd.oDi;
    locala.startTime = paramd.startTime;
    locala.endTime = paramd.endTime;
    locala.type = paramInt;
    locala.pid = paramd.pid;
    locala.oCt = paramd.oCt;
    if (paramInt == 1)
    {
      locala.networkStatus = paramd.networkStatus;
      locala.oCu = paramd.oCu;
    }
    AppMethodBeat.o(132520);
    return locala;
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132515);
    if (!oCp)
    {
      AppMethodBeat.o(132515);
      return;
    }
    c localc = oCo;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    Log.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInBackground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132515);
      return;
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oCW.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oCX.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oCY.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oCZ.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oDa.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oDb.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oDc.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oDd.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oDe.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.oCC.oDf.add(paramString);
    }
  }
  
  private static void a(List<a> paramList, List<c.b> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(132518);
    if (paramList1 == null)
    {
      AppMethodBeat.o(132518);
      return;
    }
    Iterator localIterator = paramList1.iterator();
    label146:
    while (localIterator.hasNext())
    {
      c.b localb = (c.b)localIterator.next();
      if (localb == null) {
        paramList1 = null;
      }
      for (;;)
      {
        if (paramList1 == null) {
          break label146;
        }
        paramList.add(paramList1);
        break;
        paramList1 = new a();
        paramList1.pid = localb.pid;
        paramList1.oCs = localb.oCs;
        paramList1.startTime = localb.oDg;
        paramList1.endTime = localb.oDg;
        paramList1.type = 4;
        paramList1.oCw = localb.oCw;
        paramList1.oCx = localb.oCx;
        paramList1.oCy = localb.oCy;
        paramList1.ffv = paramBoolean;
      }
    }
    AppMethodBeat.o(132518);
  }
  
  public static void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132516);
    if (!oCp)
    {
      AppMethodBeat.o(132516);
      return;
    }
    c localc = oCo;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    Log.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInForeground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132516);
      return;
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCM, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCN, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCO, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCP, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCQ, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCR, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCS, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCT, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCU, paramString);
      AppMethodBeat.o(132516);
      return;
      c.a.a(localc.oCC.oCV, paramString);
    }
  }
  
  public static List<a> bIB()
  {
    localObject2 = null;
    AppMethodBeat.i(132517);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(132517);
      return null;
    }
    Object localObject1 = oCo.oCG;
    Object localObject3 = (String)localObject1 + "/mm";
    localObject4 = (String)localObject1 + "/push";
    try
    {
      localObject1 = (c.a)b.I(y.Lh((String)localObject3));
      try
      {
        localObject3 = (c.a)b.I(y.Lh((String)localObject4));
        localObject2 = localObject3;
      }
      catch (Exception localException2)
      {
        a locala;
        for (;;)
        {
          Log.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject4 });
        }
        localObject4 = localIterator.oCL.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          locala = a((c.c)((Iterator)localObject4).next(), 3);
          if (locala != null) {
            localException2.add(locala);
          }
        }
        a(localException2, localIterator.oCM, true);
        a(localException2, localIterator.oCN, true);
        a(localException2, localIterator.oCO, true);
        a(localException2, localIterator.oCP, true);
        a(localException2, localIterator.oCQ, true);
        a(localException2, localIterator.oCR, true);
        a(localException2, localIterator.oCS, true);
        a(localException2, localIterator.oCT, true);
        a(localException2, localIterator.oCU, true);
        a(localException2, localIterator.oCV, true);
        a(localException2, localIterator.oCW, false);
        a(localException2, localIterator.oCX, false);
        a(localException2, localIterator.oCY, false);
        a(localException2, localIterator.oCZ, false);
        a(localException2, localIterator.oDa, false);
        a(localException2, localIterator.oDb, false);
        a(localException2, localIterator.oDc, false);
        a(localException2, localIterator.oDd, false);
        a(localException2, localIterator.oDe, false);
        a(localException2, localIterator.oDf, false);
        if (localObject2 == null) {
          break label567;
        }
        Iterator localIterator = ((c.a)localObject2).oCJ.iterator();
        while (localIterator.hasNext())
        {
          localObject4 = a((c.d)localIterator.next(), 1);
          if (localObject4 != null) {
            localException2.add(localObject4);
          }
        }
        localIterator = ((c.a)localObject2).oCK.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = a((c.c)localIterator.next(), 2);
          if (localObject2 != null) {
            localException2.add(localObject2);
          }
        }
        Collections.sort(localException2);
        AppMethodBeat.o(132517);
        return localException2;
      }
      localObject3 = new ArrayList();
      if (localObject1 != null)
      {
        localObject4 = ((c.a)localObject1).oCJ.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          locala = a((c.d)((Iterator)localObject4).next(), 0);
          if (locala != null) {
            ((List)localObject3).add(locala);
          }
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException1.getMessage(), new Object[] { localObject3 });
        localIterator = null;
      }
    }
  }
  
  public static final void hg(boolean paramBoolean)
  {
    AppMethodBeat.i(132512);
    Log.i("MicroMsg.ActiveDetector", "onActive() active:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aQe()).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      oCp = bool;
      if (bool) {
        break;
      }
      AppMethodBeat.o(132512);
      return;
    }
    active = paramBoolean;
    if (paramBoolean)
    {
      Log.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
      Log.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      if (dBj != null) {
        dBj.cancel(true);
      }
      dBj = null;
      c localc = oCo;
      localc.oCI = false;
      localc.oCE = 0L;
      localc.oCF = 0L;
      Log.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      oCq = cn.bDu();
      AppMethodBeat.o(132512);
      return;
    }
    Log.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (dBj == null)
    {
      dBj = h.ahAA.bp(oCo);
      oCo.oCI = true;
    }
    oCr = cn.bDu();
    AppMethodBeat.o(132512);
  }
  
  public static boolean iN(long paramLong)
  {
    boolean bool = true;
    if ((oCq <= 0L) || (oCr <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (oCq < oCr) {
          break;
        }
      } while (paramLong >= oCq);
      return false;
    } while (paramLong < oCr);
    return false;
  }
  
  static String iO(long paramLong)
  {
    AppMethodBeat.i(132519);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(132519);
    return localObject;
  }
  
  public static boolean isActive()
  {
    return active;
  }
  
  public static void wc(int paramInt)
  {
    oCo.oCz = paramInt;
  }
  
  public static final class a
    implements Comparable<a>
  {
    public long endTime = 0L;
    public boolean ffv = false;
    public int networkStatus = 0;
    public long oCs = 0L;
    public boolean oCt = true;
    public boolean oCu = false;
    public int oCv = 0;
    public long oCw = 0L;
    public long oCx = 0L;
    public long oCy = 0L;
    public int pid = 0;
    public long startTime = 0L;
    public int type = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(132511);
      StringBuilder localStringBuilder = new StringBuilder();
      switch (this.type)
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          localStringBuilder.append("\n");
          str1 = localStringBuilder.toString();
          AppMethodBeat.o(132511);
          return str1;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.iO(this.oCs), a.iO(this.startTime), a.iO(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.oCt) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.iO(this.oCs), a.iO(this.startTime), a.iO(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.networkStatus), Boolean.valueOf(this.oCt) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.iO(this.oCs), a.iO(this.startTime), a.iO(this.endTime), Integer.valueOf(this.oCv) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.iO(this.oCs), a.iO(this.startTime), a.iO(this.endTime), Integer.valueOf(this.oCv) }));
        }
      }
      String str2 = a.iO(this.oCs);
      String str3 = a.iO(this.startTime);
      String str4 = a.iO(this.endTime);
      int i = this.pid;
      String str5 = a.iO(this.oCw);
      long l1 = this.oCx;
      long l2 = this.oCy;
      if (this.ffv) {}
      for (String str1 = "foreground";; str1 = "background")
      {
        localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s, %s", new Object[] { str2, str3, str4, Integer.valueOf(i), str5, Long.valueOf(l1), Long.valueOf(l2), str1 }));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.aq.a
 * JD-Core Version:    0.7.0.1
 */