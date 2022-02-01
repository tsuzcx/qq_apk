package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final ap handler = new ap(Looper.getMainLooper());
  static int mqf = -1;
  static a mwA;
  private static f mwB = null;
  private static j mwC = null;
  private static g mwD = null;
  private static h mwE = null;
  private static int mwF = new Random(bt.eGO()).nextInt(1147483648);
  private static c mwG = null;
  private static final Map<Integer, Set<com.tencent.mm.al.g>> mwx = new HashMap();
  private static final LinkedHashMap<Integer, b> mwy = new LinkedHashMap();
  private static d mwz;
  private PByteArray mww = new PByteArray();
  
  public static boolean N(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (mwy)
    {
      int i = bxG();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, mqf);
      if (mwA != null) {
        mwA.l(i, localPByteArray.value);
      }
      ad.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.al.g paramg)
  {
    synchronized (mwx)
    {
      if (!mwx.containsKey(Integer.valueOf(paramInt))) {
        mwx.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)mwx.get(Integer.valueOf(paramInt))).contains(paramg)) {
        ((Set)mwx.get(Integer.valueOf(paramInt))).add(paramg);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    mwA = parama;
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
          synchronized (b.bxI())
          {
            l = bt.eGO();
            Iterator localIterator = b.bxI().entrySet().iterator();
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
              if (b.bxJ() == null) {
                continue;
              }
              b.bxJ().m(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
              ad.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
            }
            catch (Exception localException)
            {
              PByteArray localPByteArray;
              ad.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
              continue;
            }
            i += 1;
            if ((i > 0) && (i % 5 == 0)) {
              this.mwI.hW(false);
            }
            continue;
            ad.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
          }
          ad.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
          continue;
          this.mwI.hW(true);
          ad.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.bxI().size()), Long.valueOf(bt.vM(l)) });
          AppMethodBeat.o(21699);
          return;
        }
      }
    });
  }
  
  public static void a(c paramc)
  {
    mwG = paramc;
  }
  
  public static void a(d paramd)
  {
    mwz = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (mwE != null)
    {
      if (!mwE.stopped)
      {
        ad.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      ad.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      mwE = parama;
      ad.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.stopped = false;
      parama.mxj = 1;
      if (parama.mxi == null) {
        break;
      }
      parama.mxk.av(0L, 0L);
      return;
      ad.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    mwC = new j(parama);
  }
  
  public static void b(int paramInt, com.tencent.mm.al.g paramg)
  {
    synchronized (mwx)
    {
      try
      {
        if (mwx.get(Integer.valueOf(paramInt)) != null) {
          ((Set)mwx.get(Integer.valueOf(paramInt))).remove(paramg);
        }
        return;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          ad.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramg });
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
      ad.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
          ad.w("MicroMsg.BackupBaseScene", str);
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
    if (mwB != null)
    {
      mwB.bxN();
      ad.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(bt.eGO()) });
    }
    synchronized (mwy)
    {
      ??? = (b)mwy.remove(Integer.valueOf(paramInt1));
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
          ad.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).bxu().parseFrom(paramArrayOfByte);
    ((b)???).wf(paramInt1);
    return;
    label261:
    ad.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (mwy)
        {
          Iterator localIterator = new HashSet(mwy.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)mwy.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            ad.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            mwy.remove(localInteger2);
            try
            {
              localb.bxu().parseFrom(paramArrayOfByte);
              localb.wf(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.q(3, -1, "buf to tagResp fail");
              ad.printErrStackTrace("MicroMsg.BackupBaseScene", localException2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[] { Integer.valueOf(localb.getType()), localException2.toString() });
            }
          }
        }
        Integer localInteger1 = Integer.valueOf(localb.getType());
      }
      return;
    }
    ad.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  private static void b(boolean paramBoolean, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21697);
        if (b.bxH() != null)
        {
          b.bxH().a(this.mqL, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        ad.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static int bvW()
  {
    return mqf;
  }
  
  public static void bwQ()
  {
    if (mwG != null) {
      mwG.bwQ();
    }
  }
  
  public static String bxA()
  {
    if (mwC == null) {
      return "0B";
    }
    String str = j.ns(mwC.mxq);
    ad.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void bxB()
  {
    if (mwD == null) {
      mwD = new g();
    }
    g localg = mwD;
    try
    {
      ad.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.mxd != null)
      {
        localg.mxd.stopTimer();
        localg.mxd = null;
      }
      g.startTime = bt.eGO();
      g.mxb = localg.nr(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void bxC()
  {
    if (mwE != null)
    {
      mwE.mxj = 0;
      h localh = mwE;
      if (!localh.stopped)
      {
        ad.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.mxk.stopTimer();
        localh.stopped = true;
      }
    }
  }
  
  public static int bxD()
  {
    if (mwE == null) {
      return 0;
    }
    return mwE.mxj;
  }
  
  public static int bxG()
  {
    int i = mwF;
    mwF += 1;
    return i;
  }
  
  public static void bxw()
  {
    if (mwB != null) {
      mwB.stop();
    }
    f localf = new f();
    mwB = localf;
    localf.start(true);
  }
  
  public static void bxx()
  {
    if (mwB != null) {
      mwB.stop();
    }
  }
  
  public static void bxy()
  {
    int i = 0;
    if (mwC != null)
    {
      j localj = mwC;
      ad.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.mxs = bt.eGO();
      localj.mxr = 0L;
      localj.mxp = 0L;
      localj.mxv.clear();
      localj.mxu = 0;
      localj.mxt = 0L;
      while (i < 10)
      {
        localj.mxv.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.mxw.av(1000L, 1000L);
      return;
    }
    ad.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void bxz()
  {
    if (mwC != null)
    {
      j localj = mwC;
      ad.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.mxw.stopTimer();
      localj.mxu = 0;
    }
  }
  
  public static void clear()
  {
    ad.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (mwy)
    {
      mwy.clear();
    }
    synchronized (mwx)
    {
      mwx.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static boolean u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, mqf);
    if (mwA != null) {
      mwA.l(paramInt2, localPByteArray.value);
    }
    ad.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static void vT(int paramInt)
  {
    mqf = paramInt;
  }
  
  public static void wg(int paramInt)
  {
    if (mwD != null)
    {
      g localg = mwD;
      try
      {
        ad.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.mxb == 0L))
        {
          ad.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.mxb) });
          return;
        }
        g.endTime = bt.eGO();
        g.mxc = localg.K(g.startTime, g.endTime);
        ad.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.mxc), Long.valueOf(g.mxb) });
        if ((g.mxc != 0L) && (g.mxc > g.mxb)) {
          localg.a(paramInt, g.endTime - g.startTime, g.mxc - g.mxb, false);
        }
        g.init();
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.BackupLogManager", localException, "end exception", new Object[0]);
      }
    }
  }
  
  public static void wh(int paramInt)
  {
    if (mwE != null) {
      mwE.mxj = paramInt;
    }
  }
  
  public static void wi(int paramInt)
  {
    if (mwC != null)
    {
      j localj = mwC;
      localj.mxr = (paramInt + localj.mxr);
    }
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.mww = new PByteArray();
    this.mww.value = ???.value;
    synchronized (mwy)
    {
      mwy.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public boolean bxE()
  {
    try
    {
      byte[] arrayOfByte = bxv().toByteArray();
      synchronized (mwy)
      {
        int i = bxG();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.mww, mqf);
        if (mwA != null) {
          mwA.l(i, this.mww.value);
        }
        ad.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.mww.value.length) });
        mwy.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean bxF()
  {
    try
    {
      byte[] arrayOfByte = bxv().toByteArray();
      synchronized (mwy)
      {
        int i = bxG();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.mww, mqf);
        if (mwA != null) {
          mwA.m(i, this.mww.value);
        }
        ad.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.mww.value.length) });
        mwy.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public abstract a bxu();
  
  public abstract a bxv();
  
  public int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void q(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public abstract void wf(int paramInt);
  
  public static abstract interface a
  {
    public abstract void l(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int m(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void hW(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void bwQ();
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