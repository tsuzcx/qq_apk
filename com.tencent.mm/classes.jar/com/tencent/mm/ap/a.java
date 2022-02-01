package com.tencent.mm.ap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
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
  private static Future dBz;
  private static final c iTt;
  private static boolean iTu;
  private static long iTv;
  private static long iTw;
  
  static
  {
    AppMethodBeat.i(132522);
    active = false;
    iTt = new c();
    iTu = true;
    iTv = 0L;
    iTw = 0L;
    AppMethodBeat.o(132522);
  }
  
  public static void A(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132513);
    if (!iTu)
    {
      AppMethodBeat.o(132513);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132513);
      return;
    }
    c localc = iTt;
    c.c localc1 = new c.c(cl.aWy(), System.currentTimeMillis(), paramInt, paramLong);
    localc.iTH.iTP.add(localc1);
    AppMethodBeat.o(132513);
  }
  
  public static boolean Au(long paramLong)
  {
    boolean bool = true;
    if ((iTv <= 0L) || (iTw <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (iTv < iTw) {
          break;
        }
      } while (paramLong >= iTv);
      return false;
    } while (paramLong < iTw);
    return false;
  }
  
  static String Av(long paramLong)
  {
    AppMethodBeat.i(132519);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(132519);
    return localObject;
  }
  
  public static void B(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132514);
    if (!iTu)
    {
      AppMethodBeat.o(132514);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132514);
      return;
    }
    c localc = iTt;
    c.c localc1 = new c.c(cl.aWy(), System.currentTimeMillis(), paramInt, paramLong);
    localc.iTH.iTQ.add(localc1);
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
    locala.iTx = paramc.iTx;
    locala.startTime = paramc.time;
    locala.endTime = paramc.time;
    locala.type = paramInt;
    locala.iTA = paramc.type;
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
    locala.iTx = paramd.iUn;
    locala.startTime = paramd.startTime;
    locala.endTime = paramd.endTime;
    locala.type = paramInt;
    locala.pid = paramd.pid;
    locala.iTy = paramd.iTy;
    if (paramInt == 1)
    {
      locala.networkStatus = paramd.networkStatus;
      locala.iTz = paramd.iTz;
    }
    AppMethodBeat.o(132520);
    return locala;
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132515);
    if (!iTu)
    {
      AppMethodBeat.o(132515);
      return;
    }
    c localc = iTt;
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
      localc.iTH.iUb.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUc.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUd.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUe.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUf.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUg.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUh.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUi.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUj.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.iTH.iUk.add(paramString);
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
        paramList1.iTx = localb.iTx;
        paramList1.startTime = localb.iUl;
        paramList1.endTime = localb.iUl;
        paramList1.type = 4;
        paramList1.iTB = localb.iTB;
        paramList1.iTC = localb.iTC;
        paramList1.iTD = localb.iTD;
        paramList1.cQp = paramBoolean;
      }
    }
    AppMethodBeat.o(132518);
  }
  
  public static void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132516);
    if (!iTu)
    {
      AppMethodBeat.o(132516);
      return;
    }
    c localc = iTt;
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
      localc.iTH.iTR.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTS.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTT.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTU.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTV.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTW.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTX.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTY.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iTZ.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.iTH.iUa.add(paramString);
    }
  }
  
  public static List<a> bbr()
  {
    localObject2 = null;
    AppMethodBeat.i(132517);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(132517);
      return null;
    }
    Object localObject1 = iTt.iTL;
    Object localObject3 = (String)localObject1 + "/mm";
    localObject4 = (String)localObject1 + "/push";
    try
    {
      localObject1 = (c.a)b.y(s.openRead((String)localObject3));
      try
      {
        localObject3 = (c.a)b.y(s.openRead((String)localObject4));
        localObject2 = localObject3;
      }
      catch (Exception localException2)
      {
        a locala;
        for (;;)
        {
          Log.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject4 });
        }
        localObject4 = localIterator.iTQ.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          locala = a((c.c)((Iterator)localObject4).next(), 3);
          if (locala != null) {
            localException2.add(locala);
          }
        }
        a(localException2, localIterator.iTR, true);
        a(localException2, localIterator.iTS, true);
        a(localException2, localIterator.iTT, true);
        a(localException2, localIterator.iTU, true);
        a(localException2, localIterator.iTV, true);
        a(localException2, localIterator.iTW, true);
        a(localException2, localIterator.iTX, true);
        a(localException2, localIterator.iTY, true);
        a(localException2, localIterator.iTZ, true);
        a(localException2, localIterator.iUa, true);
        a(localException2, localIterator.iUb, false);
        a(localException2, localIterator.iUc, false);
        a(localException2, localIterator.iUd, false);
        a(localException2, localIterator.iUe, false);
        a(localException2, localIterator.iUf, false);
        a(localException2, localIterator.iUg, false);
        a(localException2, localIterator.iUh, false);
        a(localException2, localIterator.iUi, false);
        a(localException2, localIterator.iUj, false);
        a(localException2, localIterator.iUk, false);
        if (localObject2 == null) {
          break label567;
        }
        Iterator localIterator = ((c.a)localObject2).iTO.iterator();
        while (localIterator.hasNext())
        {
          localObject4 = a((c.d)localIterator.next(), 1);
          if (localObject4 != null) {
            localException2.add(localObject4);
          }
        }
        localIterator = ((c.a)localObject2).iTP.iterator();
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
        localObject4 = ((c.a)localObject1).iTO.iterator();
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
  
  public static final void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(132512);
    Log.i("MicroMsg.ActiveDetector", "onActive() active:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aps()).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      iTu = bool;
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
      if (dBz != null) {
        dBz.cancel(true);
      }
      dBz = null;
      c localc = iTt;
      localc.iTN = false;
      localc.iTJ = 0L;
      localc.iTK = 0L;
      Log.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      iTv = cl.aWy();
      AppMethodBeat.o(132512);
      return;
    }
    Log.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (dBz == null)
    {
      dBz = h.RTc.ba(iTt);
      iTt.iTN = true;
    }
    iTw = cl.aWy();
    AppMethodBeat.o(132512);
  }
  
  public static boolean isActive()
  {
    return active;
  }
  
  public static void sY(int paramInt)
  {
    iTt.iTE = paramInt;
  }
  
  public static final class a
    implements Comparable<a>
  {
    public boolean cQp = false;
    public long endTime = 0L;
    public int iTA = 0;
    public long iTB = 0L;
    public long iTC = 0L;
    public long iTD = 0L;
    public long iTx = 0L;
    public boolean iTy = true;
    public boolean iTz = false;
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
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.iTy) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.networkStatus), Boolean.valueOf(this.iTy) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.iTA) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.Av(this.iTx), a.Av(this.startTime), a.Av(this.endTime), Integer.valueOf(this.iTA) }));
        }
      }
      String str2 = a.Av(this.iTx);
      String str3 = a.Av(this.startTime);
      String str4 = a.Av(this.endTime);
      int i = this.pid;
      String str5 = a.Av(this.iTB);
      long l1 = this.iTC;
      long l2 = this.iTD;
      if (this.cQp) {}
      for (String str1 = "foreground";; str1 = "background")
      {
        localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s, %s", new Object[] { str2, str3, str4, Integer.valueOf(i), str5, Long.valueOf(l1), Long.valueOf(l2), str1 }));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ap.a
 * JD-Core Version:    0.7.0.1
 */