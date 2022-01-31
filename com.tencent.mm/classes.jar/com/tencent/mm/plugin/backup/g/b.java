package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.ai.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final ak handler;
  private static final Map<Integer, Set<com.tencent.mm.ai.f>> jFd = new HashMap();
  private static final LinkedHashMap<Integer, b> jFe = new LinkedHashMap();
  private static d jFf;
  static a jFg;
  private static f jFh = null;
  private static j jFi = null;
  private static g jFj = null;
  private static h jFk = null;
  private static int jFl = new Random(bo.aoy()).nextInt(1147483648);
  private static b.c jFm = null;
  static int jyJ;
  private PByteArray jFc = new PByteArray();
  
  static
  {
    handler = new ak(Looper.getMainLooper());
    jyJ = -1;
  }
  
  public static boolean J(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (jFe)
    {
      int i = aUx();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, jyJ);
      if (jFg != null) {
        jFg.j(i, localPByteArray.value);
      }
      ab.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.ai.f paramf)
  {
    synchronized (jFd)
    {
      if (!jFd.containsKey(Integer.valueOf(paramInt))) {
        jFd.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)jFd.get(Integer.valueOf(paramInt))).contains(paramf)) {
        ((Set)jFd.get(Integer.valueOf(paramInt))).add(paramf);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    jFg = parama;
  }
  
  public static void a(b paramb)
  {
    handler.postAtFrontOfQueueV2(new b.3(paramb));
  }
  
  public static void a(b.c paramc)
  {
    jFm = paramc;
  }
  
  public static void a(d paramd)
  {
    jFf = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (jFk != null)
    {
      if (!jFk.jFQ)
      {
        ab.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      ab.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      jFk = parama;
      ab.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.jFQ = false;
      parama.jFP = 1;
      if (parama.jFO == null) {
        break;
      }
      parama.jFR.ag(0L, 0L);
      return;
      ab.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    jFi = new j(parama);
  }
  
  public static int aSO()
  {
    return jyJ;
  }
  
  public static void aTE()
  {
    if (jFm != null) {
      jFm.aTE();
    }
  }
  
  public static void aUn()
  {
    if (jFh != null) {
      jFh.stop();
    }
    f localf = new f();
    jFh = localf;
    localf.start(true);
  }
  
  public static void aUo()
  {
    if (jFh != null) {
      jFh.stop();
    }
  }
  
  public static void aUp()
  {
    int i = 0;
    if (jFi != null)
    {
      j localj = jFi;
      ab.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.jFZ = bo.aoy();
      localj.jFY = 0L;
      localj.jFW = 0L;
      localj.jGc.clear();
      localj.jGb = 0;
      localj.jGa = 0L;
      while (i < 10)
      {
        localj.jGc.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.jGd.ag(1000L, 1000L);
      return;
    }
    ab.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void aUq()
  {
    if (jFi != null)
    {
      j localj = jFi;
      ab.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.jGd.stopTimer();
      localj.jGb = 0;
    }
  }
  
  public static String aUr()
  {
    if (jFi == null) {
      return "0B";
    }
    String str = j.hL(jFi.jFX);
    ab.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void aUs()
  {
    if (jFj == null) {
      jFj = new g();
    }
    g localg = jFj;
    try
    {
      ab.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.jFJ != null)
      {
        localg.jFJ.stopTimer();
        localg.jFJ = null;
      }
      g.startTime = bo.aoy();
      g.jFH = localg.hK(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void aUt()
  {
    if (jFk != null)
    {
      jFk.jFP = 0;
      h localh = jFk;
      if (!localh.jFQ)
      {
        ab.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.jFR.stopTimer();
        localh.jFQ = true;
      }
    }
  }
  
  public static int aUu()
  {
    if (jFk == null) {
      return 0;
    }
    return jFk.jFP;
  }
  
  public static int aUx()
  {
    int i = jFl;
    jFl += 1;
    return i;
  }
  
  public static void b(int paramInt, com.tencent.mm.ai.f paramf)
  {
    synchronized (jFd)
    {
      try
      {
        if (jFd.get(Integer.valueOf(paramInt)) != null) {
          ((Set)jFd.get(Integer.valueOf(paramInt))).remove(paramf);
        }
        return;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          ab.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramf });
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
      ab.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
          ab.w("MicroMsg.BackupBaseScene", str);
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
    if (jFh != null)
    {
      jFh.aUE();
      ab.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(bo.aoy()) });
    }
    synchronized (jFe)
    {
      ??? = (b)jFe.remove(Integer.valueOf(paramInt1));
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
          ((b)???).n(3, -1, "buf to resq fail");
          ab.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).aUl().parseFrom(paramArrayOfByte);
    ((b)???).rt(paramInt1);
    return;
    label262:
    ab.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (jFe)
        {
          Iterator localIterator = new HashSet(jFe.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)jFe.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            ab.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            jFe.remove(localInteger2);
            try
            {
              localb.aUl().parseFrom(paramArrayOfByte);
              localb.rt(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.n(3, -1, "buf to tagResp fail");
              ab.printErrStackTrace("MicroMsg.BackupBaseScene", localException2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[] { Integer.valueOf(localb.getType()), localException2.toString() });
            }
          }
        }
        Integer localInteger1 = Integer.valueOf(localb.getType());
      }
      return;
    }
    ab.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  private static void b(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    handler.post(new b.1(paramBoolean, paramInt1, paramArrayOfByte, paramInt2));
  }
  
  public static void clear()
  {
    ab.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (jFe)
    {
      jFe.clear();
    }
    synchronized (jFd)
    {
      jFd.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static boolean r(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, jyJ);
    if (jFg != null) {
      jFg.j(paramInt2, localPByteArray.value);
    }
    ab.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static void rg(int paramInt)
  {
    jyJ = paramInt;
  }
  
  public static void ru(int paramInt)
  {
    if (jFj != null)
    {
      g localg = jFj;
      try
      {
        ab.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.jFH == 0L))
        {
          ab.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.jFH) });
          return;
        }
        g.endTime = bo.aoy();
        g.jFI = localg.D(g.startTime, g.endTime);
        ab.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.jFI), Long.valueOf(g.jFH) });
        if ((g.jFI != 0L) && (g.jFI > g.jFH)) {
          localg.a(paramInt, g.endTime - g.startTime, g.jFI - g.jFH, false);
        }
        g.init();
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.BackupLogManager", localException, "end exception", new Object[0]);
      }
    }
  }
  
  public static void rv(int paramInt)
  {
    if (jFk != null) {
      jFk.jFP = paramInt;
    }
  }
  
  public static void rw(int paramInt)
  {
    if (jFi != null)
    {
      j localj = jFi;
      localj.jFY = (paramInt + localj.jFY);
    }
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.jFc = new PByteArray();
    this.jFc.value = ???.value;
    synchronized (jFe)
    {
      jFe.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public abstract a aUl();
  
  public abstract a aUm();
  
  public boolean aUv()
  {
    try
    {
      byte[] arrayOfByte = aUm().toByteArray();
      synchronized (jFe)
      {
        int i = aUx();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.jFc, jyJ);
        if (jFg != null) {
          jFg.j(i, this.jFc.value);
        }
        ab.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.jFc.value.length) });
        jFe.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean aUw()
  {
    try
    {
      byte[] arrayOfByte = aUm().toByteArray();
      synchronized (jFe)
      {
        int i = aUx();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.jFc, jyJ);
        if (jFg != null) {
          jFg.k(i, this.jFc.value);
        }
        ab.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.jFc.value.length) });
        jFe.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void n(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public abstract void rt(int paramInt);
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int k(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void fC(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b
 * JD-Core Version:    0.7.0.1
 */