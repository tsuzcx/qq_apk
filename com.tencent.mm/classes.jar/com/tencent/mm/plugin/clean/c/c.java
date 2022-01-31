package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.c.a.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  implements a.a, Runnable
{
  private static final Long iBi = Long.valueOf(604800000L);
  private static final Long iBj = Long.valueOf(7776000000L);
  private static final int iBv = com.tencent.mm.model.c.FU().length() - 1;
  private ah dPi = new ah(Looper.getMainLooper());
  private long endTime = 0L;
  private ConcurrentHashMap<String, b> iBA = new ConcurrentHashMap();
  private long iBB;
  private long iBC;
  private HashSet<String> iBD = new HashSet();
  private HashSet<String> iBE = new HashSet();
  private boolean iBF = true;
  private int[] iBG = new int[10];
  private long iBl;
  private long iBm;
  private com.tencent.mm.plugin.clean.c.a.b iBw;
  private g iBx;
  private int iBy = 0;
  private int iBz = 0;
  public boolean isStop;
  private long startTime = 0L;
  
  static
  {
    au.Hx();
  }
  
  public c(com.tencent.mm.plugin.clean.c.a.b paramb, g paramg)
  {
    this.iBx = paramg;
    this.iBw = paramb;
  }
  
  private void aDH()
  {
    this.endTime = System.currentTimeMillis();
    y.i("MicroMsg.CleanController", "totalUserTime:%d", new Object[] { Long.valueOf(this.endTime - this.startTime) });
    if ((this.iBx != null) && (!this.isStop))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.iBA.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((b)localIterator.next());
      }
      Collections.sort(localArrayList);
      Collections.reverse(localArrayList);
      this.dPi.post(new c.1(this, localArrayList));
    }
  }
  
  public static long aDI()
  {
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.bkF);
      l1 = localStatFs.getBlockCount();
      int i = localStatFs.getBlockSize();
      l1 = i * l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
      }
    }
    l2 = l1;
    if (l1 <= 0L) {
      l2 = 1L;
    }
    return l2;
  }
  
  public static long aDJ()
  {
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.bkF);
      l1 = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      l1 = i * l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
      }
    }
    l2 = l1;
    if (l1 <= 0L) {
      l2 = 1L;
    }
    return l2;
  }
  
  private static ArrayList<String> aDK()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new LinkedList();
    Object localObject2 = s.dVc;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((LinkedList)localObject1).add(localObject2[i]);
      i += 1;
    }
    au.Hx();
    localObject1 = com.tencent.mm.model.c.FB().c(s.dUT, (List)localObject1, "*");
    if (((Cursor)localObject1).moveToFirst()) {
      do
      {
        localObject2 = new ak();
        ((ak)localObject2).d((Cursor)localObject1);
        if (!bk.bl(((as)localObject2).field_username))
        {
          au.Hx();
          if (!ad.Fn(com.tencent.mm.model.c.Fw().abl(((as)localObject2).field_username).field_verifyFlag)) {
            localArrayList.add(((as)localObject2).field_username);
          }
        }
      } while ((((Cursor)localObject1).moveToNext()) && (!((Cursor)localObject1).isAfterLast()));
    }
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  private void cT(long paramLong)
  {
    if (paramLong < 0L) {}
    for (;;)
    {
      try
      {
        y.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", new Object[] { Long.valueOf(paramLong) });
        this.iBC += 60L;
        return;
      }
      finally {}
      this.iBC += paramLong;
    }
  }
  
  private static ArrayList<String> zp(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.b)localObject).list();
      int j;
      int i;
      if ((localObject != null) && (localObject.length > 0))
      {
        j = localObject.length;
        i = 0;
      }
      while (i < j)
      {
        String str = localObject[i];
        localArrayList.add(paramString + "/" + str);
        i += 1;
        continue;
        localArrayList.add(paramString);
      }
      return localArrayList;
    }
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public final void a(com.tencent.mm.plugin.clean.c.a.a parama)
  {
    if ((parama instanceof c.a)) {
      y.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", new Object[] { Integer.valueOf(parama.hashCode()), parama.Sj() });
    }
    for (;;)
    {
      com.tencent.mm.sdk.f.e.Y(this);
      this.iBz += 1;
      if ((this.iBx != null) && (!this.isStop)) {
        this.dPi.post(new c.2(this));
      }
      if (this.iBz == this.iBy) {
        aDH();
      }
      return;
      y.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", new Object[] { Integer.valueOf(parama.hashCode()), parama.Sj() });
    }
  }
  
  public final void run()
  {
    y.i("MicroMsg.CleanController", "Start to run clean controller");
    this.startTime = System.currentTimeMillis();
    long l = bk.UZ();
    Object localObject2 = com.tencent.mm.compatible.util.e.bkH;
    y.v("MicroMsg.CleanController", "root path: %s", new Object[] { localObject2 });
    Object localObject1 = new StringBuilder("mm");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN();
    Object localObject3 = com.tencent.mm.a.g.o(com.tencent.mm.kernel.a.CK().getBytes());
    localObject1 = new ArrayList();
    Object localObject4 = new com.tencent.mm.vfs.b((String)localObject2);
    if (((com.tencent.mm.vfs.b)localObject4).isDirectory())
    {
      localObject4 = ((com.tencent.mm.vfs.b)localObject4).list();
      if (localObject4 != null)
      {
        j = localObject4.length;
        i = 0;
        if (i < j)
        {
          String str = localObject4[i];
          Object localObject5 = (String)localObject2 + str;
          if (str.length() >= 32)
          {
            y.v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", new Object[] { str, localObject3 });
            localObject5 = zp((String)localObject5);
            if (((ArrayList)localObject1).size() > 0)
            {
              if (!((String)localObject3).equals(str))
              {
                y.i("MicroMsg.CleanController", "add other acc tmp path %s", new Object[] { str });
                this.iBD.add(str);
              }
              ((ArrayList)localObject1).addAll(0, (Collection)localObject5);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((ArrayList)localObject1).addAll((Collection)localObject5);
            continue;
            y.v("MicroMsg.CleanController", "subfile: %s", new Object[] { str });
            if (((ArrayList)localObject1).size() > 0) {
              ((ArrayList)localObject1).add(0, localObject5);
            } else {
              ((ArrayList)localObject1).add(localObject5);
            }
          }
        }
      }
    }
    else
    {
      cT(com.tencent.mm.vfs.e.aeQ((String)localObject2));
    }
    int k = -1;
    int j = -1;
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      localObject2 = (String)((ArrayList)localObject1).get(i);
      if (((String)localObject2).contains("image2")) {
        k = i;
      }
      if (((String)localObject2).contains("voice2")) {
        j = i;
      }
      i += 1;
    }
    if (j != -1) {
      ((ArrayList)localObject1).add(0, (String)((ArrayList)localObject1).remove(j));
    }
    if (k != -1) {
      ((ArrayList)localObject1).add(0, (String)((ArrayList)localObject1).remove(k));
    }
    y.d("MicroMsg.CleanController", "scan is finish [%s]", new Object[] { Long.valueOf(bk.cp(l)) });
    l = bk.UZ();
    localObject2 = aDK();
    y.d("MicroMsg.CleanController", "user is finish [%s]", new Object[] { Long.valueOf(bk.cp(l)) });
    this.iBy = (((ArrayList)localObject1).size() + ((ArrayList)localObject2).size());
    if (this.iBy == 0)
    {
      y.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
      aDH();
    }
    for (;;)
    {
      return;
      y.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", new Object[] { Integer.valueOf(this.iBy) });
      i = 0;
      while ((!this.isStop) && (i < ((ArrayList)localObject1).size()))
      {
        localObject3 = (String)((ArrayList)localObject1).get(i);
        y.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", new Object[] { Integer.valueOf(i), localObject3 });
        localObject4 = new c.b(this, (String)localObject3);
        while (!this.iBw.b((com.tencent.mm.plugin.clean.c.a.a)localObject4)) {
          try
          {
            Thread.sleep(2147483647L);
          }
          catch (InterruptedException localInterruptedException2) {}
        }
        y.d("MicroMsg.CleanController", "Start task： filePath＝%s", new Object[] { localObject3 });
        i += 1;
      }
      i = 0;
      while ((!this.isStop) && (i < ((ArrayList)localObject2).size()))
      {
        localObject1 = (String)((ArrayList)localObject2).get(i);
        y.d("MicroMsg.CleanController", "while loop index=%d | username=%s", new Object[] { Integer.valueOf(i), localObject1 });
        localObject3 = new c.a(this, (String)localObject1);
        while (!this.iBw.b((com.tencent.mm.plugin.clean.c.a.a)localObject3)) {
          try
          {
            Thread.sleep(2147483647L);
          }
          catch (InterruptedException localInterruptedException1) {}
        }
        y.d("MicroMsg.CleanController", "Start task： user＝%s", new Object[] { localObject1 });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c
 * JD-Core Version:    0.7.0.1
 */