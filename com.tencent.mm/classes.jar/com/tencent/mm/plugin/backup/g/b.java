package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public abstract class b
  extends n
{
  private static final aq handler;
  private static final Map<Integer, Set<com.tencent.mm.ak.f>> nEq = new HashMap();
  private static final LinkedHashMap<Integer, b> nEr = new LinkedHashMap();
  private static d nEs;
  static a nEt;
  private static f nEu = null;
  private static j nEv = null;
  private static g nEw = null;
  private static h nEx = null;
  private static int nEy = new Random(bu.fpO()).nextInt(1147483648);
  private static c nEz = null;
  static int nya;
  private PByteArray nEp = new PByteArray();
  
  static
  {
    handler = new aq(Looper.getMainLooper());
    nya = -1;
  }
  
  public static boolean L(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (nEr)
    {
      int i = bJJ();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, nya);
      if (nEt != null) {
        nEt.l(i, localPByteArray.value);
      }
      ae.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.ak.f paramf)
  {
    synchronized (nEq)
    {
      if (!nEq.containsKey(Integer.valueOf(paramInt))) {
        nEq.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)nEq.get(Integer.valueOf(paramInt))).contains(paramf)) {
        ((Set)nEq.get(Integer.valueOf(paramInt))).add(paramf);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    nEt = parama;
  }
  
  public static void a(b paramb)
  {
    handler.postAtFrontOfQueue(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(21699);
        label297:
        label321:
        label374:
        for (;;)
        {
          long l;
          synchronized (b.bJL())
          {
            l = bu.fpO();
            Iterator localIterator = b.bJL().entrySet().iterator();
            if (!localIterator.hasNext()) {
              break label321;
            }
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (localEntry == null) {
              break label374;
            }
            try
            {
              localPByteArray = b.a((b)localEntry.getValue());
              if (localPByteArray == null) {
                break label297;
              }
              if (b.bJM() == null) {
                continue;
              }
              b.bJM().m(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
              ae.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
            }
            catch (Exception localException)
            {
              PByteArray localPByteArray;
              ae.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
              continue;
            }
            i += 1;
            if ((i > 0) && (i % 5 == 0)) {
              this.nEB.iD(false);
            }
            continue;
            ae.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
          }
          ae.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
          continue;
          this.nEB.iD(true);
          ae.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.bJL().size()), Long.valueOf(bu.DD(l)) });
          AppMethodBeat.o(21699);
          return;
        }
      }
    });
  }
  
  public static void a(c paramc)
  {
    nEz = paramc;
  }
  
  public static void a(d paramd)
  {
    nEs = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (nEx != null)
    {
      if (!nEx.stopped)
      {
        ae.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      ae.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      nEx = parama;
      ae.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.stopped = false;
      parama.nFc = 1;
      if (parama.nFb == null) {
        break;
      }
      parama.nFd.ay(0L, 0L);
      return;
      ae.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    nEv = new j(parama);
  }
  
  public static void b(int paramInt, com.tencent.mm.ak.f paramf)
  {
    synchronized (nEq)
    {
      try
      {
        if (nEq.get(Integer.valueOf(paramInt)) != null) {
          ((Set)nEq.get(Integer.valueOf(paramInt))).remove(paramf);
        }
        return;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          ae.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramf });
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
      ae.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
          ae.w("MicroMsg.BackupBaseScene", str);
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
    if (nEu != null)
    {
      nEu.bJQ();
      ae.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(bu.fpO()) });
    }
    synchronized (nEr)
    {
      ??? = (b)nEr.remove(Integer.valueOf(paramInt1));
      if (??? == null) {
        break label261;
      }
      if (paramArrayOfByte == null) {
        try
        {
          throw new Exception("buf is null");
        }
        catch (Exception paramArrayOfByte)
        {
          ((b)???).q(3, -1, "buf to resq fail");
          ae.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).bJx().parseFrom(paramArrayOfByte);
    ((b)???).xG(paramInt1);
    return;
    label261:
    ae.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (nEr)
        {
          Iterator localIterator = new HashSet(nEr.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)nEr.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            ae.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            nEr.remove(localInteger2);
            try
            {
              localb.bJx().parseFrom(paramArrayOfByte);
              localb.xG(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.q(3, -1, "buf to tagResp fail");
              ae.printErrStackTrace("MicroMsg.BackupBaseScene", localException2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[] { Integer.valueOf(localb.getType()), localException2.toString() });
            }
          }
        }
        Integer localInteger1 = Integer.valueOf(localb.getType());
      }
      return;
    }
    ae.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  private static void b(boolean paramBoolean, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21697);
        if (b.bJK() != null)
        {
          b.bJK().a(this.nyG, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        ae.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static int bHY()
  {
    return nya;
  }
  
  public static void bIT()
  {
    if (nEz != null) {
      nEz.bIT();
    }
  }
  
  public static void bJA()
  {
    if (nEu != null) {
      nEu.stop();
    }
  }
  
  public static void bJB()
  {
    int i = 0;
    if (nEv != null)
    {
      j localj = nEv;
      ae.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.nFl = bu.fpO();
      localj.nFk = 0L;
      localj.nFi = 0L;
      localj.nFo.clear();
      localj.nFn = 0;
      localj.nFm = 0L;
      while (i < 10)
      {
        localj.nFo.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.nFp.ay(1000L, 1000L);
      return;
    }
    ae.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void bJC()
  {
    if (nEv != null)
    {
      j localj = nEv;
      ae.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.nFp.stopTimer();
      localj.nFn = 0;
    }
  }
  
  public static String bJD()
  {
    if (nEv == null) {
      return "0B";
    }
    String str = j.tr(nEv.nFj);
    ae.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void bJE()
  {
    if (nEw == null) {
      nEw = new g();
    }
    g localg = nEw;
    try
    {
      ae.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.nEW != null)
      {
        localg.nEW.stopTimer();
        localg.nEW = null;
      }
      g.startTime = bu.fpO();
      g.nEU = localg.tq(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void bJF()
  {
    if (nEx != null)
    {
      nEx.nFc = 0;
      h localh = nEx;
      if (!localh.stopped)
      {
        ae.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.nFd.stopTimer();
        localh.stopped = true;
      }
    }
  }
  
  public static int bJG()
  {
    if (nEx == null) {
      return 0;
    }
    return nEx.nFc;
  }
  
  public static int bJJ()
  {
    int i = nEy;
    nEy += 1;
    return i;
  }
  
  public static void bJz()
  {
    if (nEu != null) {
      nEu.stop();
    }
    f localf = new f();
    nEu = localf;
    localf.start(true);
  }
  
  public static void clear()
  {
    ae.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (nEr)
    {
      nEr.clear();
    }
    synchronized (nEq)
    {
      nEq.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static boolean t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, nya);
    if (nEt != null) {
      nEt.l(paramInt2, localPByteArray.value);
    }
    ae.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static void xH(int paramInt)
  {
    if (nEw != null)
    {
      g localg = nEw;
      try
      {
        ae.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.nEU == 0L))
        {
          ae.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.nEU) });
          return;
        }
        g.endTime = bu.fpO();
        g.nEV = localg.F(g.startTime, g.endTime);
        ae.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.nEV), Long.valueOf(g.nEU) });
        if ((g.nEV != 0L) && (g.nEV > g.nEU)) {
          localg.a(paramInt, g.endTime - g.startTime, g.nEV - g.nEU, false);
        }
        g.init();
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.BackupLogManager", localException, "end exception", new Object[0]);
      }
    }
  }
  
  public static void xI(int paramInt)
  {
    if (nEx != null) {
      nEx.nFc = paramInt;
    }
  }
  
  public static void xJ(int paramInt)
  {
    if (nEv != null)
    {
      j localj = nEv;
      localj.nFk = (paramInt + localj.nFk);
    }
  }
  
  public static void xv(int paramInt)
  {
    nya = paramInt;
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.nEp = new PByteArray();
    this.nEp.value = ???.value;
    synchronized (nEr)
    {
      nEr.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public boolean bJH()
  {
    try
    {
      byte[] arrayOfByte = bJy().toByteArray();
      synchronized (nEr)
      {
        int i = bJJ();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.nEp, nya);
        if (nEt != null) {
          nEt.l(i, this.nEp.value);
        }
        ae.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.nEp.value.length) });
        nEr.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean bJI()
  {
    try
    {
      byte[] arrayOfByte = bJy().toByteArray();
      synchronized (nEr)
      {
        int i = bJJ();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.nEp, nya);
        if (nEt != null) {
          nEt.m(i, this.nEp.value);
        }
        ae.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.nEp.value.length) });
        nEr.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public abstract a bJx();
  
  public abstract a bJy();
  
  public int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void q(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public abstract void xG(int paramInt);
  
  public static abstract interface a
  {
    public abstract void l(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int m(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void iD(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void bIT();
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b
 * JD-Core Version:    0.7.0.1
 */