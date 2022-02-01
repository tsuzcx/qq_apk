package com.tencent.mm.ap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
  private static Future cXV;
  private static final c hCY;
  private static boolean hCZ;
  private static long hDa;
  private static long hDb;
  
  static
  {
    AppMethodBeat.i(132522);
    active = false;
    hCY = new c();
    hCZ = true;
    hDa = 0L;
    hDb = 0L;
    AppMethodBeat.o(132522);
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
    locala.hDc = paramc.hDc;
    locala.startTime = paramc.time;
    locala.endTime = paramc.time;
    locala.type = paramInt;
    locala.hDf = paramc.type;
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
    locala.hDc = paramd.hDS;
    locala.startTime = paramd.startTime;
    locala.endTime = paramd.endTime;
    locala.type = paramInt;
    locala.pid = paramd.pid;
    locala.hDd = paramd.hDd;
    if (paramInt == 1)
    {
      locala.networkStatus = paramd.networkStatus;
      locala.hDe = paramd.hDe;
    }
    AppMethodBeat.o(132520);
    return locala;
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132515);
    if (!hCZ)
    {
      AppMethodBeat.o(132515);
      return;
    }
    c localc = hCY;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    ac.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInBackground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132515);
      return;
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDG.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDH.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDI.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDJ.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDK.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDL.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDM.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDN.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDO.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hDm.hDP.add(paramString);
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
        paramList1.hDc = localb.hDc;
        paramList1.startTime = localb.hDQ;
        paramList1.endTime = localb.hDQ;
        paramList1.type = 4;
        paramList1.hDg = localb.hDg;
        paramList1.hDh = localb.hDh;
        paramList1.hDi = localb.hDi;
        paramList1.cqM = paramBoolean;
      }
    }
    AppMethodBeat.o(132518);
  }
  
  public static List<a> aEc()
  {
    localObject2 = null;
    AppMethodBeat.i(132517);
    if (!ai.ciE())
    {
      AppMethodBeat.o(132517);
      return null;
    }
    Object localObject1 = hCY.hDq;
    Object localObject3 = (String)localObject1 + "/mm";
    localObject4 = (String)localObject1 + "/push";
    try
    {
      localObject1 = (c.a)b.v(com.tencent.mm.vfs.i.openRead((String)localObject3));
      try
      {
        localObject3 = (c.a)b.v(com.tencent.mm.vfs.i.openRead((String)localObject4));
        localObject2 = localObject3;
      }
      catch (Exception localException2)
      {
        a locala;
        for (;;)
        {
          ac.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject4 });
        }
        localObject4 = localIterator.hDv.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          locala = a((c.c)((Iterator)localObject4).next(), 3);
          if (locala != null) {
            localException2.add(locala);
          }
        }
        a(localException2, localIterator.hDw, true);
        a(localException2, localIterator.hDx, true);
        a(localException2, localIterator.hDy, true);
        a(localException2, localIterator.hDz, true);
        a(localException2, localIterator.hDA, true);
        a(localException2, localIterator.hDB, true);
        a(localException2, localIterator.hDC, true);
        a(localException2, localIterator.hDD, true);
        a(localException2, localIterator.hDE, true);
        a(localException2, localIterator.hDF, true);
        a(localException2, localIterator.hDG, false);
        a(localException2, localIterator.hDH, false);
        a(localException2, localIterator.hDI, false);
        a(localException2, localIterator.hDJ, false);
        a(localException2, localIterator.hDK, false);
        a(localException2, localIterator.hDL, false);
        a(localException2, localIterator.hDM, false);
        a(localException2, localIterator.hDN, false);
        a(localException2, localIterator.hDO, false);
        a(localException2, localIterator.hDP, false);
        if (localObject2 == null) {
          break label559;
        }
        Iterator localIterator = ((c.a)localObject2).hDt.iterator();
        while (localIterator.hasNext())
        {
          localObject4 = a((c.d)localIterator.next(), 1);
          if (localObject4 != null) {
            localException2.add(localObject4);
          }
        }
        localIterator = ((c.a)localObject2).hDu.iterator();
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
        localObject4 = ((c.a)localObject1).hDt.iterator();
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
        ac.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException1.getMessage(), new Object[] { localObject3 });
        localIterator = null;
      }
    }
  }
  
  public static void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132516);
    if (!hCZ)
    {
      AppMethodBeat.o(132516);
      return;
    }
    c localc = hCY;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    ac.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInForeground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132516);
      return;
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDw.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDx.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDy.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDz.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDA.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDB.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDC.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDD.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDE.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hDm.hDF.add(paramString);
    }
  }
  
  public static final void eK(boolean paramBoolean)
  {
    AppMethodBeat.i(132512);
    ac.i("MicroMsg.ActiveDetector", "onActive() active:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!ai.getContext().getSharedPreferences("system_config_prefs", g.YK()).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      hCZ = bool;
      if (bool) {
        break;
      }
      AppMethodBeat.o(132512);
      return;
    }
    active = paramBoolean;
    if (paramBoolean)
    {
      ac.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
      ac.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      if (cXV != null) {
        cXV.cancel(true);
      }
      cXV = null;
      c localc = hCY;
      localc.hDs = false;
      localc.hDo = 0L;
      localc.hDp = 0L;
      ac.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      hDa = ce.azH();
      AppMethodBeat.o(132512);
      return;
    }
    ac.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (cXV == null)
    {
      cXV = h.JZN.aV(hCY);
      hCY.hDs = true;
    }
    hDb = ce.azH();
    AppMethodBeat.o(132512);
  }
  
  public static boolean isActive()
  {
    return active;
  }
  
  public static void oF(int paramInt)
  {
    hCY.hDj = paramInt;
  }
  
  public static boolean qc(long paramLong)
  {
    boolean bool = true;
    if ((hDa <= 0L) || (hDb <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (hDa < hDb) {
          break;
        }
      } while (paramLong >= hDa);
      return false;
    } while (paramLong < hDb);
    return false;
  }
  
  static String qd(long paramLong)
  {
    AppMethodBeat.i(132519);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(132519);
    return localObject;
  }
  
  public static void x(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132513);
    if (!hCZ)
    {
      AppMethodBeat.o(132513);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132513);
      return;
    }
    c localc = hCY;
    c.c localc1 = new c.c(ce.azH(), System.currentTimeMillis(), paramInt, paramLong);
    localc.hDm.hDu.add(localc1);
    AppMethodBeat.o(132513);
  }
  
  public static void y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132514);
    if (!hCZ)
    {
      AppMethodBeat.o(132514);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132514);
      return;
    }
    c localc = hCY;
    c.c localc1 = new c.c(ce.azH(), System.currentTimeMillis(), paramInt, paramLong);
    localc.hDm.hDv.add(localc1);
    AppMethodBeat.o(132514);
  }
  
  public static final class a
    implements Comparable<a>
  {
    public boolean cqM = false;
    public long endTime = 0L;
    public long hDc = 0L;
    public boolean hDd = true;
    public boolean hDe = false;
    public int hDf = 0;
    public long hDg = 0L;
    public long hDh = 0L;
    public long hDi = 0L;
    public int networkStatus = 0;
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
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.qd(this.hDc), a.qd(this.startTime), a.qd(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.hDd) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.qd(this.hDc), a.qd(this.startTime), a.qd(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.networkStatus), Boolean.valueOf(this.hDd) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.qd(this.hDc), a.qd(this.startTime), a.qd(this.endTime), Integer.valueOf(this.hDf) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.qd(this.hDc), a.qd(this.startTime), a.qd(this.endTime), Integer.valueOf(this.hDf) }));
        }
      }
      String str2 = a.qd(this.hDc);
      String str3 = a.qd(this.startTime);
      String str4 = a.qd(this.endTime);
      int i = this.pid;
      String str5 = a.qd(this.hDg);
      long l1 = this.hDh;
      long l2 = this.hDi;
      if (this.cqM) {}
      for (String str1 = "foreground";; str1 = "background")
      {
        localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s, %s", new Object[] { str2, str3, str4, Integer.valueOf(i), str5, Long.valueOf(l1), Long.valueOf(l2), str1 }));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ap.a
 * JD-Core Version:    0.7.0.1
 */