package com.tencent.mm.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static boolean active;
  private static final c fAq;
  private static boolean fAr;
  private static long fAs;
  private static long fAt;
  private static Thread thread;
  
  static
  {
    AppMethodBeat.i(58336);
    thread = null;
    active = false;
    fAq = new c();
    fAr = true;
    fAs = 0L;
    fAt = 0L;
    AppMethodBeat.o(58336);
  }
  
  private static a.a a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(58335);
    if (parama == null)
    {
      AppMethodBeat.o(58335);
      return null;
    }
    a.a locala = new a.a();
    locala.fAu = parama.fAu;
    locala.startTime = parama.time;
    locala.endTime = parama.time;
    locala.type = paramInt;
    locala.fAy = parama.type;
    AppMethodBeat.o(58335);
    return locala;
  }
  
  private static a.a a(c.d paramd, int paramInt)
  {
    AppMethodBeat.i(58334);
    if (paramd == null)
    {
      AppMethodBeat.o(58334);
      return null;
    }
    a.a locala = new a.a();
    locala.fAu = paramd.fAQ;
    locala.startTime = paramd.startTime;
    locala.endTime = paramd.endTime;
    locala.type = paramInt;
    locala.pid = paramd.pid;
    locala.fAw = paramd.fAw;
    if (paramInt == 1)
    {
      locala.fAv = paramd.fAv;
      locala.fAx = paramd.fAx;
    }
    AppMethodBeat.o(58334);
    return locala;
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    AppMethodBeat.i(58331);
    if (!fAr)
    {
      AppMethodBeat.o(58331);
      return;
    }
    c localc = fAq;
    c.c localc1 = new c.c(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5);
    ab.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new Object[] { localc1.toString() });
    localc.fAE.fAO.add(localc1);
    AppMethodBeat.o(58331);
  }
  
  public static List<a.a> agj()
  {
    AppMethodBeat.i(58332);
    if (!ah.brt())
    {
      AppMethodBeat.o(58332);
      return null;
    }
    Object localObject2 = fAq.fAI;
    Object localObject1 = (String)localObject2 + "/mm";
    Object localObject4 = (String)localObject2 + "/push";
    try
    {
      localObject2 = (c.b)b.t(new FileInputStream((String)localObject1));
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          localObject1 = (c.b)b.t(new FileInputStream((String)localObject4));
          localObject4 = new ArrayList();
          if (localObject2 == null) {
            break label416;
          }
          localObject5 = ((c.b)localObject2).fAL.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = a((c.d)((Iterator)localObject5).next(), 0);
            if (localObject6 != null) {
              ((List)localObject4).add(localObject6);
            }
          }
          localException2 = localException2;
          ab.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject1 });
          localObject3 = null;
        }
      }
      catch (Exception localException1)
      {
        Object localObject6;
        Object localObject3;
        Iterator localIterator;
        for (;;)
        {
          ab.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException1.getMessage(), new Object[] { localObject4 });
          localIterator = null;
        }
        Object localObject5 = ((c.b)localObject3).fAN.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = a((c.a)((Iterator)localObject5).next(), 3);
          if (localObject6 != null) {
            ((List)localObject4).add(localObject6);
          }
        }
        localObject5 = ((c.b)localObject3).fAO.iterator();
        label414:
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (c.c)((Iterator)localObject5).next();
          if (localObject6 == null) {
            localObject3 = null;
          }
          for (;;)
          {
            if (localObject3 == null) {
              break label414;
            }
            ((List)localObject4).add(localObject3);
            break;
            localObject3 = new a.a();
            ((a.a)localObject3).pid = ((c.c)localObject6).pid;
            ((a.a)localObject3).fAu = ((c.c)localObject6).fAu;
            ((a.a)localObject3).startTime = ((c.c)localObject6).fAP;
            ((a.a)localObject3).endTime = ((c.c)localObject6).fAP;
            ((a.a)localObject3).type = 4;
            ((a.a)localObject3).fAz = ((c.c)localObject6).fAz;
            ((a.a)localObject3).fAA = ((c.c)localObject6).fAA;
            ((a.a)localObject3).fAB = ((c.c)localObject6).fAB;
          }
        }
        label416:
        if (localIterator != null)
        {
          localObject3 = localIterator.fAL.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = a((c.d)((Iterator)localObject3).next(), 1);
            if (localObject5 != null) {
              ((List)localObject4).add(localObject5);
            }
          }
          localIterator = localIterator.fAM.iterator();
          while (localIterator.hasNext())
          {
            localObject3 = a((c.a)localIterator.next(), 2);
            if (localObject3 != null) {
              ((List)localObject4).add(localObject3);
            }
          }
        }
        Collections.sort((List)localObject4);
        AppMethodBeat.o(58332);
      }
    }
    return localObject4;
  }
  
  public static final void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(58328);
    if (!ah.getContext().getSharedPreferences("system_config_prefs", h.Mp()).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      fAr = bool;
      if (bool) {
        break;
      }
      AppMethodBeat.o(58328);
      return;
    }
    active = paramBoolean;
    if (paramBoolean)
    {
      ab.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
      if (thread != null) {
        thread.interrupt();
      }
      ab.i("MicroMsg.ActiveDetector", "active, interrupt end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      thread = null;
      fAq.clear();
      ab.i("MicroMsg.ActiveDetector", "active, processDetector.clear end, time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      fAs = cb.abp();
      AppMethodBeat.o(58328);
      return;
    }
    ab.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (thread == null)
    {
      Thread localThread = d.h(fAq, "ProcessDetector_" + Process.myPid());
      thread = localThread;
      localThread.start();
      fAq.fAK = true;
    }
    fAt = cb.abp();
    AppMethodBeat.o(58328);
  }
  
  public static boolean gO(long paramLong)
  {
    boolean bool = true;
    if ((fAs <= 0L) || (fAt <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (fAs < fAt) {
          break;
        }
      } while (paramLong >= fAs);
      return false;
    } while (paramLong < fAt);
    return false;
  }
  
  static String gP(long paramLong)
  {
    AppMethodBeat.i(58333);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(58333);
    return localObject;
  }
  
  public static boolean isActive()
  {
    return active;
  }
  
  public static void li(int paramInt)
  {
    AppMethodBeat.i(58329);
    if (!fAr)
    {
      AppMethodBeat.o(58329);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(58329);
      return;
    }
    c localc = fAq;
    c.a locala = new c.a(cb.abp(), System.currentTimeMillis(), paramInt);
    localc.fAE.fAM.add(locala);
    AppMethodBeat.o(58329);
  }
  
  public static void lj(int paramInt)
  {
    AppMethodBeat.i(58330);
    if (!fAr)
    {
      AppMethodBeat.o(58330);
      return;
    }
    if (active)
    {
      AppMethodBeat.o(58330);
      return;
    }
    c localc = fAq;
    c.a locala = new c.a(cb.abp(), System.currentTimeMillis(), paramInt);
    localc.fAE.fAN.add(locala);
    AppMethodBeat.o(58330);
  }
  
  public static void lk(int paramInt)
  {
    fAq.fAC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */