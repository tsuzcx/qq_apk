package com.tencent.mm.am;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static boolean axD = false;
  private static final c eka = new c();
  private static boolean ekb = true;
  private static long ekc = 0L;
  private static long ekd = 0L;
  private static Thread thread = null;
  
  public static List<a.a> Nw()
  {
    if (!ae.cqV()) {
      return null;
    }
    Object localObject2 = eka.eks;
    Object localObject1 = (String)localObject2 + "/mm";
    Object localObject4 = (String)localObject2 + "/push";
    try
    {
      localObject2 = (c.b)b.q(new FileInputStream((String)localObject1));
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          localObject1 = (c.b)b.q(new FileInputStream((String)localObject4));
          localObject4 = new ArrayList();
          if (localObject2 == null) {
            break label406;
          }
          localObject5 = ((c.b)localObject2).ekv.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = a((c.d)((Iterator)localObject5).next(), 0);
            if (localObject6 != null) {
              ((List)localObject4).add(localObject6);
            }
          }
          localException2 = localException2;
          y.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException2.getMessage(), new Object[] { localObject1 });
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
          y.e("MicroMsg.ActiveDetector", "%s,read exception:" + localException1.getMessage(), new Object[] { localObject4 });
          localIterator = null;
        }
        Object localObject5 = ((c.b)localObject3).ekx.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = a((c.a)((Iterator)localObject5).next(), 3);
          if (localObject6 != null) {
            ((List)localObject4).add(localObject6);
          }
        }
        localObject5 = ((c.b)localObject3).eky.iterator();
        label404:
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (c.c)((Iterator)localObject5).next();
          if (localObject6 == null) {
            localObject3 = null;
          }
          for (;;)
          {
            if (localObject3 == null) {
              break label404;
            }
            ((List)localObject4).add(localObject3);
            break;
            localObject3 = new a.a();
            ((a.a)localObject3).pid = ((c.c)localObject6).pid;
            ((a.a)localObject3).eke = ((c.c)localObject6).eke;
            ((a.a)localObject3).startTime = ((c.c)localObject6).ekz;
            ((a.a)localObject3).endTime = ((c.c)localObject6).ekz;
            ((a.a)localObject3).type = 4;
            ((a.a)localObject3).ekj = ((c.c)localObject6).ekj;
            ((a.a)localObject3).ekk = ((c.c)localObject6).ekk;
            ((a.a)localObject3).ekl = ((c.c)localObject6).ekl;
          }
        }
        label406:
        if (localIterator != null)
        {
          localObject3 = localIterator.ekv.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = a((c.d)((Iterator)localObject3).next(), 1);
            if (localObject5 != null) {
              ((List)localObject4).add(localObject5);
            }
          }
          localIterator = localIterator.ekw.iterator();
          while (localIterator.hasNext())
          {
            localObject3 = a((c.a)localIterator.next(), 2);
            if (localObject3 != null) {
              ((List)localObject4).add(localObject3);
            }
          }
        }
        Collections.sort((List)localObject4);
      }
    }
    return localObject4;
  }
  
  private static a.a a(c.a parama, int paramInt)
  {
    if (parama == null) {
      return null;
    }
    a.a locala = new a.a();
    locala.eke = parama.eke;
    locala.startTime = parama.time;
    locala.endTime = parama.time;
    locala.type = paramInt;
    locala.eki = parama.type;
    return locala;
  }
  
  private static a.a a(c.d paramd, int paramInt)
  {
    Object localObject;
    if (paramd == null) {
      localObject = null;
    }
    a.a locala;
    do
    {
      return localObject;
      locala = new a.a();
      locala.eke = paramd.ekA;
      locala.startTime = paramd.startTime;
      locala.endTime = paramd.endTime;
      locala.type = paramInt;
      locala.pid = paramd.pid;
      locala.ekg = paramd.ekg;
      localObject = locala;
    } while (paramInt != 1);
    locala.ekf = paramd.ekf;
    locala.ekh = paramd.ekh;
    return locala;
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if (!ekb) {
      return;
    }
    c localc = eka;
    c.c localc1 = new c.c(Process.myPid(), paramLong1, paramLong2, paramLong3, paramLong4, paramLong5);
    y.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new Object[] { localc1.toString() });
    localc.eko.eky.add(localc1);
  }
  
  public static boolean bT(long paramLong)
  {
    boolean bool = true;
    if ((ekc <= 0L) || (ekd <= 0L) || (paramLong <= 0L)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (ekc < ekd) {
          break;
        }
      } while (paramLong >= ekc);
      return false;
    } while (paramLong < ekd);
    return false;
  }
  
  static String bU(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(localDate);
  }
  
  public static final void bU(boolean paramBoolean)
  {
    if (!ae.getContext().getSharedPreferences("system_config_prefs", 4).getBoolean("msg_delay_close_detect", false)) {}
    for (boolean bool = true;; bool = false)
    {
      ekb = bool;
      if (bool) {
        break;
      }
      return;
    }
    axD = paramBoolean;
    if (paramBoolean)
    {
      y.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
      if (thread != null) {
        thread.interrupt();
      }
      thread = null;
      eka.clear();
      ekc = bz.Is();
      return;
    }
    y.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()) });
    if (thread == null)
    {
      Thread localThread = e.b(eka, "ProcessDetector_" + Process.myPid());
      thread = localThread;
      localThread.start();
      eka.eku = true;
    }
    ekd = bz.Is();
  }
  
  public static void iu(int paramInt)
  {
    if (!ekb) {}
    while (axD) {
      return;
    }
    c localc = eka;
    c.a locala = new c.a(bz.Is(), System.currentTimeMillis(), paramInt);
    localc.eko.ekw.add(locala);
  }
  
  public static void iv(int paramInt)
  {
    if (!ekb) {}
    while (axD) {
      return;
    }
    c localc = eka;
    c.a locala = new c.a(bz.Is(), System.currentTimeMillis(), paramInt);
    localc.eko.ekx.add(locala);
  }
  
  public static void iw(int paramInt)
  {
    eka.ekm = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */