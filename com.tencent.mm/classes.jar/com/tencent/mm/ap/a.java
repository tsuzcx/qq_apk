package com.tencent.mm.ap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.o;
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
  private static Future dkp;
  private static final c hYv;
  private static boolean hYw;
  private static long hYx;
  private static long hYy;
  
  static
  {
    AppMethodBeat.i(132522);
    active = false;
    hYv = new c();
    hYw = true;
    hYx = 0L;
    hYy = 0L;
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
    locala.hYz = paramc.hYz;
    locala.startTime = paramc.time;
    locala.endTime = paramc.time;
    locala.type = paramInt;
    locala.hYC = paramc.type;
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
    locala.hYz = paramd.hZp;
    locala.startTime = paramd.startTime;
    locala.endTime = paramd.endTime;
    locala.type = paramInt;
    locala.pid = paramd.pid;
    locala.hYA = paramd.hYA;
    if (paramInt == 1)
    {
      locala.networkStatus = paramd.networkStatus;
      locala.hYB = paramd.hYB;
    }
    AppMethodBeat.o(132520);
    return locala;
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132515);
    if (!hYw)
    {
      AppMethodBeat.o(132515);
      return;
    }
    c localc = hYv;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    ae.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInBackground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132515);
      return;
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZd.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZe.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZf.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZg.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZh.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZi.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZj.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZk.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZl.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hYJ.hZm.add(paramString);
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
        paramList1.hYz = localb.hYz;
        paramList1.startTime = localb.hZn;
        paramList1.endTime = localb.hZn;
        paramList1.type = 4;
        paramList1.hYD = localb.hYD;
        paramList1.hYE = localb.hYE;
        paramList1.hYF = localb.hYF;
        paramList1.cCq = paramBoolean;
      }
    }
    AppMethodBeat.o(132518);
  }
  
  public static List<a> aHy()
  {
    localObject2 = null;
    AppMethodBeat.i(132517);
    if (!ak.cpe())
    {
      AppMethodBeat.o(132517);
      return null;
    }
    Object localObject1 = hYv.hYN;
    Object localObject3 = (String)localObject1 + "/mm";
    localObject4 = (String)localObject1 + "/push";
    try
    {
      localObject1 = (c.a)b.z(o.openRead((String)localObject3));
      try
      {
        localObject3 = (c.a)b.z(o.openRead((String)localObject4));
        localObject2 = localObject3;
      }
      catch (Exception localException2)
      {
        a locala;
        for (;;)
        {
          ae.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject4 });
        }
        localObject4 = localIterator.hYS.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          locala = a((c.c)((Iterator)localObject4).next(), 3);
          if (locala != null) {
            localException2.add(locala);
          }
        }
        a(localException2, localIterator.hYT, true);
        a(localException2, localIterator.hYU, true);
        a(localException2, localIterator.hYV, true);
        a(localException2, localIterator.hYW, true);
        a(localException2, localIterator.hYX, true);
        a(localException2, localIterator.hYY, true);
        a(localException2, localIterator.hYZ, true);
        a(localException2, localIterator.hZa, true);
        a(localException2, localIterator.hZb, true);
        a(localException2, localIterator.hZc, true);
        a(localException2, localIterator.hZd, false);
        a(localException2, localIterator.hZe, false);
        a(localException2, localIterator.hZf, false);
        a(localException2, localIterator.hZg, false);
        a(localException2, localIterator.hZh, false);
        a(localException2, localIterator.hZi, false);
        a(localException2, localIterator.hZj, false);
        a(localException2, localIterator.hZk, false);
        a(localException2, localIterator.hZl, false);
        a(localException2, localIterator.hZm, false);
        if (localObject2 == null) {
          break label559;
        }
        Iterator localIterator = ((c.a)localObject2).hYQ.iterator();
        while (localIterator.hasNext())
        {
          localObject4 = a((c.d)localIterator.next(), 1);
          if (localObject4 != null) {
            localException2.add(localObject4);
          }
        }
        localIterator = ((c.a)localObject2).hYR.iterator();
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
        localObject4 = ((c.a)localObject1).hYQ.iterator();
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
        ae.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException1.getMessage(), new Object[] { localObject3 });
        localIterator = null;
      }
    }
  }
  
  public static void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132516);
    if (!hYw)
    {
      AppMethodBeat.o(132516);
      return;
    }
    c localc = hYv;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    ae.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInForeground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132516);
      return;
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYT.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYU.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYV.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYW.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYX.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYY.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hYZ.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hZa.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hZb.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hYJ.hZc.add(paramString);
    }
  }
  
  public static final void eO(boolean paramBoolean)
  {
    AppMethodBeat.i(132512);
    ae.i("MicroMsg.ActiveDetector", "onActive() active:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!ak.getContext().getSharedPreferences("system_config_prefs", g.abv()).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      hYw = bool;
      if (bool) {
        break;
      }
      AppMethodBeat.o(132512);
      return;
    }
    active = paramBoolean;
    if (paramBoolean)
    {
      ae.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
      ae.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      if (dkp != null) {
        dkp.cancel(true);
      }
      dkp = null;
      c localc = hYv;
      localc.hYP = false;
      localc.hYL = 0L;
      localc.hYM = 0L;
      ae.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      hYx = ch.aDa();
      AppMethodBeat.o(132512);
      return;
    }
    ae.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (dkp == null)
    {
      dkp = h.MqF.aR(hYv);
      hYv.hYP = true;
    }
    hYy = ch.aDa();
    AppMethodBeat.o(132512);
  }
  
  public static boolean isActive()
  {
    return active;
  }
  
  public static void pj(int paramInt)
  {
    hYv.hYG = paramInt;
  }
  
  public static boolean so(long paramLong)
  {
    boolean bool = true;
    if ((hYx <= 0L) || (hYy <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (hYx < hYy) {
          break;
        }
      } while (paramLong >= hYx);
      return false;
    } while (paramLong < hYy);
    return false;
  }
  
  static String sp(long paramLong)
  {
    AppMethodBeat.i(132519);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(132519);
    return localObject;
  }
  
  public static void y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132513);
    if (!hYw)
    {
      AppMethodBeat.o(132513);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132513);
      return;
    }
    c localc = hYv;
    c.c localc1 = new c.c(ch.aDa(), System.currentTimeMillis(), paramInt, paramLong);
    localc.hYJ.hYR.add(localc1);
    AppMethodBeat.o(132513);
  }
  
  public static void z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132514);
    if (!hYw)
    {
      AppMethodBeat.o(132514);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132514);
      return;
    }
    c localc = hYv;
    c.c localc1 = new c.c(ch.aDa(), System.currentTimeMillis(), paramInt, paramLong);
    localc.hYJ.hYS.add(localc1);
    AppMethodBeat.o(132514);
  }
  
  public static final class a
    implements Comparable<a>
  {
    public boolean cCq = false;
    public long endTime = 0L;
    public boolean hYA = true;
    public boolean hYB = false;
    public int hYC = 0;
    public long hYD = 0L;
    public long hYE = 0L;
    public long hYF = 0L;
    public long hYz = 0L;
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
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.sp(this.hYz), a.sp(this.startTime), a.sp(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.hYA) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.sp(this.hYz), a.sp(this.startTime), a.sp(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.networkStatus), Boolean.valueOf(this.hYA) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.sp(this.hYz), a.sp(this.startTime), a.sp(this.endTime), Integer.valueOf(this.hYC) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.sp(this.hYz), a.sp(this.startTime), a.sp(this.endTime), Integer.valueOf(this.hYC) }));
        }
      }
      String str2 = a.sp(this.hYz);
      String str3 = a.sp(this.startTime);
      String str4 = a.sp(this.endTime);
      int i = this.pid;
      String str5 = a.sp(this.hYD);
      long l1 = this.hYE;
      long l2 = this.hYF;
      if (this.cCq) {}
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