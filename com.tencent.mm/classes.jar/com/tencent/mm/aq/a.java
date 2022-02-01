package com.tencent.mm.aq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  private static Future daz;
  private static final c hcv;
  private static boolean hcw;
  private static long hcx;
  private static long hcy;
  
  static
  {
    AppMethodBeat.i(132522);
    active = false;
    hcv = new c();
    hcw = true;
    hcx = 0L;
    hcy = 0L;
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
    locala.hcz = paramc.hcz;
    locala.startTime = paramc.time;
    locala.endTime = paramc.time;
    locala.type = paramInt;
    locala.hcC = paramc.type;
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
    locala.hcz = paramd.hdp;
    locala.startTime = paramd.startTime;
    locala.endTime = paramd.endTime;
    locala.type = paramInt;
    locala.pid = paramd.pid;
    locala.hcA = paramd.hcA;
    if (paramInt == 1)
    {
      locala.networkStatus = paramd.networkStatus;
      locala.hcB = paramd.hcB;
    }
    AppMethodBeat.o(132520);
    return locala;
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132515);
    if (!hcw)
    {
      AppMethodBeat.o(132515);
      return;
    }
    c localc = hcv;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    ad.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInBackground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132515);
      return;
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdd.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hde.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdf.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdg.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdh.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdi.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdj.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdk.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdl.add(paramString);
      AppMethodBeat.o(132515);
      return;
      localc.hcJ.hdm.add(paramString);
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
        paramList1.hcz = localb.hcz;
        paramList1.startTime = localb.hdn;
        paramList1.endTime = localb.hdn;
        paramList1.type = 4;
        paramList1.hcD = localb.hcD;
        paramList1.hcE = localb.hcE;
        paramList1.hcF = localb.hcF;
        paramList1.ctF = paramBoolean;
      }
    }
    AppMethodBeat.o(132518);
  }
  
  public static List<a> axk()
  {
    localObject2 = null;
    AppMethodBeat.i(132517);
    if (!aj.cbv())
    {
      AppMethodBeat.o(132517);
      return null;
    }
    Object localObject1 = hcv.hcN;
    Object localObject3 = (String)localObject1 + "/mm";
    localObject4 = (String)localObject1 + "/push";
    try
    {
      localObject1 = (c.a)b.w(com.tencent.mm.vfs.i.openRead((String)localObject3));
      try
      {
        localObject3 = (c.a)b.w(com.tencent.mm.vfs.i.openRead((String)localObject4));
        localObject2 = localObject3;
      }
      catch (Exception localException2)
      {
        a locala;
        for (;;)
        {
          ad.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject4 });
        }
        localObject4 = localIterator.hcS.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          locala = a((c.c)((Iterator)localObject4).next(), 3);
          if (locala != null) {
            localException2.add(locala);
          }
        }
        a(localException2, localIterator.hcT, true);
        a(localException2, localIterator.hcU, true);
        a(localException2, localIterator.hcV, true);
        a(localException2, localIterator.hcW, true);
        a(localException2, localIterator.hcX, true);
        a(localException2, localIterator.hcY, true);
        a(localException2, localIterator.hcZ, true);
        a(localException2, localIterator.hda, true);
        a(localException2, localIterator.hdb, true);
        a(localException2, localIterator.hdc, true);
        a(localException2, localIterator.hdd, false);
        a(localException2, localIterator.hde, false);
        a(localException2, localIterator.hdf, false);
        a(localException2, localIterator.hdg, false);
        a(localException2, localIterator.hdh, false);
        a(localException2, localIterator.hdi, false);
        a(localException2, localIterator.hdj, false);
        a(localException2, localIterator.hdk, false);
        a(localException2, localIterator.hdl, false);
        a(localException2, localIterator.hdm, false);
        if (localObject2 == null) {
          break label559;
        }
        Iterator localIterator = ((c.a)localObject2).hcQ.iterator();
        while (localIterator.hasNext())
        {
          localObject4 = a((c.d)localIterator.next(), 1);
          if (localObject4 != null) {
            localException2.add(localObject4);
          }
        }
        localIterator = ((c.a)localObject2).hcR.iterator();
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
        localObject4 = ((c.a)localObject1).hcQ.iterator();
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
        ad.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException1.getMessage(), new Object[] { localObject3 });
        localIterator = null;
      }
    }
  }
  
  public static void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(132516);
    if (!hcw)
    {
      AppMethodBeat.o(132516);
      return;
    }
    c localc = hcv;
    paramString = new c.b(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt2);
    ad.i("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgInForeground() delayed msg[%s]", new Object[] { paramString.toString() });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132516);
      return;
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcT.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcU.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcV.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcW.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcX.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcY.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hcZ.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hda.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hdb.add(paramString);
      AppMethodBeat.o(132516);
      return;
      localc.hcJ.hdc.add(paramString);
    }
  }
  
  public static final void ep(boolean paramBoolean)
  {
    AppMethodBeat.i(132512);
    ad.i("MicroMsg.ActiveDetector", "onActive() active:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!aj.getContext().getSharedPreferences("system_config_prefs", g.XN()).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      hcw = bool;
      if (bool) {
        break;
      }
      AppMethodBeat.o(132512);
      return;
    }
    active = paramBoolean;
    if (paramBoolean)
    {
      ad.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
      ad.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      if (daz != null) {
        daz.cancel(true);
      }
      daz = null;
      c localc = hcv;
      localc.hcP = false;
      localc.hcL = 0L;
      localc.hcM = 0L;
      ad.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      hcx = ce.asQ();
      AppMethodBeat.o(132512);
      return;
    }
    ad.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (daz == null)
    {
      daz = h.Iye.aS(hcv);
      hcv.hcP = true;
    }
    hcy = ce.asQ();
    AppMethodBeat.o(132512);
  }
  
  public static boolean isActive()
  {
    return active;
  }
  
  public static boolean mo(long paramLong)
  {
    boolean bool = true;
    if ((hcx <= 0L) || (hcy <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (hcx < hcy) {
          break;
        }
      } while (paramLong >= hcx);
      return false;
    } while (paramLong < hcy);
    return false;
  }
  
  static String mp(long paramLong)
  {
    AppMethodBeat.i(132519);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(132519);
    return localObject;
  }
  
  public static void nR(int paramInt)
  {
    hcv.hcG = paramInt;
  }
  
  public static void y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132513);
    if (!hcw)
    {
      AppMethodBeat.o(132513);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132513);
      return;
    }
    c localc = hcv;
    c.c localc1 = new c.c(ce.asQ(), System.currentTimeMillis(), paramInt, paramLong);
    localc.hcJ.hcR.add(localc1);
    AppMethodBeat.o(132513);
  }
  
  public static void z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(132514);
    if (!hcw)
    {
      AppMethodBeat.o(132514);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(132514);
      return;
    }
    c localc = hcv;
    c.c localc1 = new c.c(ce.asQ(), System.currentTimeMillis(), paramInt, paramLong);
    localc.hcJ.hcS.add(localc1);
    AppMethodBeat.o(132514);
  }
  
  public static final class a
    implements Comparable<a>
  {
    public boolean ctF = false;
    public long endTime = 0L;
    public boolean hcA = true;
    public boolean hcB = false;
    public int hcC = 0;
    public long hcD = 0L;
    public long hcE = 0L;
    public long hcF = 0L;
    public long hcz = 0L;
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
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.mp(this.hcz), a.mp(this.startTime), a.mp(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.hcA) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.mp(this.hcz), a.mp(this.startTime), a.mp(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.networkStatus), Boolean.valueOf(this.hcA) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.mp(this.hcz), a.mp(this.startTime), a.mp(this.endTime), Integer.valueOf(this.hcC) }));
          continue;
          localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.mp(this.hcz), a.mp(this.startTime), a.mp(this.endTime), Integer.valueOf(this.hcC) }));
        }
      }
      String str2 = a.mp(this.hcz);
      String str3 = a.mp(this.startTime);
      String str4 = a.mp(this.endTime);
      int i = this.pid;
      String str5 = a.mp(this.hcD);
      long l1 = this.hcE;
      long l2 = this.hcF;
      if (this.ctF) {}
      for (String str1 = "foreground";; str1 = "background")
      {
        localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s, %s", new Object[] { str2, str3, str4, Integer.valueOf(i), str5, Long.valueOf(l1), Long.valueOf(l2), str1 }));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aq.a
 * JD-Core Version:    0.7.0.1
 */