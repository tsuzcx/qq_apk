package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.ah.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public abstract class b
  extends m
{
  static int hFq = -1;
  private static final Map<Integer, Set<com.tencent.mm.ah.f>> hLB = new HashMap();
  static final LinkedHashMap<Integer, b> hLC = new LinkedHashMap();
  private static d hLD;
  static a hLE;
  private static f hLF = null;
  private static j hLG = null;
  private static g hLH = null;
  private static h hLI = null;
  private static int hLJ = new Random(bk.UY()).nextInt(1147483648);
  private static c hLK = null;
  private static final ah handler = new ah(Looper.getMainLooper());
  PByteArray hLA = new PByteArray();
  
  public static boolean I(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (hLC)
    {
      int i = auV();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, hFq);
      if (hLE != null) {
        hLE.j(i, localPByteArray.value);
      }
      y.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.ah.f paramf)
  {
    synchronized (hLB)
    {
      if (!hLB.containsKey(Integer.valueOf(paramInt))) {
        hLB.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)hLB.get(Integer.valueOf(paramInt))).contains(paramf)) {
        ((Set)hLB.get(Integer.valueOf(paramInt))).add(paramf);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    hLE = parama;
  }
  
  public static void a(b paramb)
  {
    handler.postAtFrontOfQueueV2(new b.3(paramb));
  }
  
  public static void a(c paramc)
  {
    hLK = paramc;
  }
  
  public static void a(d paramd)
  {
    hLD = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (hLI != null)
    {
      if (!hLI.hMo)
      {
        y.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      y.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      hLI = parama;
      y.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.hMo = false;
      parama.hMn = 1;
      if (parama.hMm == null) {
        break;
      }
      parama.hMp.S(0L, 0L);
      return;
      y.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    hLG = new j(parama);
  }
  
  public static int atq()
  {
    return hFq;
  }
  
  public static void auL()
  {
    if (hLF != null) {
      hLF.stop();
    }
    f localf = new f();
    hLF = localf;
    localf.eg(true);
  }
  
  public static void auM()
  {
    if (hLF != null) {
      hLF.stop();
    }
  }
  
  public static void auN()
  {
    int i = 0;
    if (hLG != null)
    {
      j localj = hLG;
      y.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.hMx = bk.UY();
      localj.hMw = 0L;
      localj.hMu = 0L;
      localj.hMA.clear();
      localj.hMz = 0;
      localj.hMy = 0L;
      while (i < 10)
      {
        localj.hMA.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.hMB.S(1000L, 1000L);
      return;
    }
    y.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void auO()
  {
    if (hLG != null)
    {
      j localj = hLG;
      y.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.hMB.stopTimer();
      localj.hMz = 0;
    }
  }
  
  public static String auP()
  {
    if (hLG == null) {
      return "0B";
    }
    String str = j.cJ(hLG.hMv);
    y.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void auQ()
  {
    if (hLH == null) {
      hLH = new g();
    }
    g localg = hLH;
    try
    {
      y.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.hMh != null)
      {
        localg.hMh.stopTimer();
        localg.hMh = null;
      }
      g.startTime = bk.UY();
      g.hMf = localg.cI(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void auR()
  {
    if (hLI != null)
    {
      hLI.hMn = 0;
      h localh = hLI;
      if (!localh.hMo)
      {
        y.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.hMp.stopTimer();
        localh.hMo = true;
      }
    }
  }
  
  public static int auS()
  {
    if (hLI == null) {
      return 0;
    }
    return hLI.hMn;
  }
  
  public static int auV()
  {
    int i = hLJ;
    hLJ += 1;
    return i;
  }
  
  public static void auf()
  {
    if (hLK != null) {
      hLK.auf();
    }
  }
  
  public static void b(int paramInt, com.tencent.mm.ah.f paramf)
  {
    synchronized (hLB)
    {
      try
      {
        if (hLB.get(Integer.valueOf(paramInt)) != null) {
          ((Set)hLB.get(Integer.valueOf(paramInt))).remove(paramf);
        }
        return;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          y.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramf });
        }
      }
    }
  }
  
  public static void b(boolean paramBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      y.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (!paramBoolean) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          ??? = new StringBuilder("callback error buf content : ");
          if (paramArrayOfByte != null) {
            continue;
          }
          str = "null";
          y.w("MicroMsg.BackupBaseScene", str);
        }
        catch (Exception localException1)
        {
          String str;
          continue;
        }
        b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
        return;
        i = paramArrayOfByte.length;
        break;
        str = new String(paramArrayOfByte);
      }
    }
    if (hLF != null)
    {
      hLF.avc();
      y.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(bk.UY()) });
    }
    synchronized (hLC)
    {
      ??? = (b)hLC.remove(Integer.valueOf(paramInt1));
      if (??? == null) {
        break label262;
      }
      if (paramArrayOfByte == null) {
        try
        {
          throw new Exception("buf is null");
        }
        catch (Exception paramArrayOfByte)
        {
          ((b)???).j(3, -1, "buf to resq fail");
          y.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).auJ().aH(paramArrayOfByte);
    ((b)???).nF(paramInt1);
    return;
    label262:
    y.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (hLC)
        {
          Iterator localIterator = new HashSet(hLC.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)hLC.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            y.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            hLC.remove(localInteger2);
            try
            {
              localb.auJ().aH(paramArrayOfByte);
              localb.nF(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.j(3, -1, "buf to tagResp fail");
              y.printErrStackTrace("MicroMsg.BackupBaseScene", localException2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[] { Integer.valueOf(localb.getType()), localException2.toString() });
            }
          }
        }
        Integer localInteger1 = Integer.valueOf(localb.getType());
      }
      return;
    }
    y.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  private static void b(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    handler.post(new b.1(paramBoolean, paramInt1, paramArrayOfByte, paramInt2));
  }
  
  public static void clear()
  {
    y.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (hLC)
    {
      hLC.clear();
    }
    synchronized (hLB)
    {
      hLB.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static void nG(int paramInt)
  {
    if (hLH != null)
    {
      g localg = hLH;
      try
      {
        y.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.hMf == 0L))
        {
          y.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.hMf) });
          return;
        }
        g.endTime = bk.UY();
        g.hMg = localg.t(g.startTime, g.endTime);
        y.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.hMg), Long.valueOf(g.hMf) });
        if ((g.hMg != 0L) && (g.hMg > g.hMf)) {
          localg.a(paramInt, g.endTime - g.startTime, g.hMg - g.hMf, false);
        }
        g.init();
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.BackupLogManager", localException, "end exception", new Object[0]);
      }
    }
  }
  
  public static void nH(int paramInt)
  {
    if (hLI != null) {
      hLI.hMn = paramInt;
    }
  }
  
  public static void nI(int paramInt)
  {
    if (hLG != null)
    {
      j localj = hLG;
      localj.hMw = (paramInt + localj.hMw);
    }
  }
  
  public static void nu(int paramInt)
  {
    hFq = paramInt;
  }
  
  public static boolean o(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, hFq);
    if (hLE != null) {
      hLE.j(paramInt2, localPByteArray.value);
    }
    y.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    return 0;
  }
  
  public abstract a auJ();
  
  public abstract a auK();
  
  public boolean auT()
  {
    try
    {
      byte[] arrayOfByte = auK().toByteArray();
      synchronized (hLC)
      {
        int i = auV();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.hLA, hFq);
        if (hLE != null) {
          hLE.j(i, this.hLA.value);
        }
        y.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.hLA.value.length) });
        hLC.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean auU()
  {
    try
    {
      byte[] arrayOfByte = auK().toByteArray();
      synchronized (hLC)
      {
        int i = auV();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.hLA, hFq);
        if (hLE != null) {
          hLE.k(i, this.hLA.value);
        }
        y.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.hLA.value.length) });
        hLC.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public abstract int getType();
  
  public final void j(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public abstract void nF(int paramInt);
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int k(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void ef(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void auf();
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b
 * JD-Core Version:    0.7.0.1
 */