package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public abstract class b
  extends n
{
  private static final ao handler = new ao(Looper.getMainLooper());
  static int mSg = -1;
  private static d mYA;
  static b.a mYB;
  private static f mYC = null;
  private static j mYD = null;
  private static g mYE = null;
  private static h mYF = null;
  private static int mYG = new Random(bs.eWj()).nextInt(1147483648);
  private static c mYH = null;
  private static final Map<Integer, Set<com.tencent.mm.ak.g>> mYy = new HashMap();
  private static final LinkedHashMap<Integer, b> mYz = new LinkedHashMap();
  private PByteArray mYx = new PByteArray();
  
  public static boolean L(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (mYz)
    {
      int i = bEC();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, mSg);
      if (mYB != null) {
        mYB.l(i, localPByteArray.value);
      }
      ac.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.ak.g paramg)
  {
    synchronized (mYy)
    {
      if (!mYy.containsKey(Integer.valueOf(paramInt))) {
        mYy.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)mYy.get(Integer.valueOf(paramInt))).contains(paramg)) {
        ((Set)mYy.get(Integer.valueOf(paramInt))).add(paramg);
      }
      return;
    }
  }
  
  public static void a(b.a parama)
  {
    mYB = parama;
  }
  
  public static void a(b.b paramb)
  {
    handler.postAtFrontOfQueue(new b.3(paramb));
  }
  
  public static void a(c paramc)
  {
    mYH = paramc;
  }
  
  public static void a(d paramd)
  {
    mYA = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (mYF != null)
    {
      if (!mYF.stopped)
      {
        ac.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      ac.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      mYF = parama;
      ac.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.stopped = false;
      parama.mZk = 1;
      if (parama.mZj == null) {
        break;
      }
      parama.mZl.au(0L, 0L);
      return;
      ac.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    mYD = new j(parama);
  }
  
  public static void b(int paramInt, com.tencent.mm.ak.g paramg)
  {
    synchronized (mYy)
    {
      try
      {
        if (mYy.get(Integer.valueOf(paramInt)) != null) {
          ((Set)mYy.get(Integer.valueOf(paramInt))).remove(paramg);
        }
        return;
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          ac.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramg });
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
      ac.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
          ac.w("MicroMsg.BackupBaseScene", str);
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
    if (mYC != null)
    {
      mYC.bEJ();
      ac.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(bs.eWj()) });
    }
    synchronized (mYz)
    {
      ??? = (b)mYz.remove(Integer.valueOf(paramInt1));
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
          ac.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).bEq().parseFrom(paramArrayOfByte);
    ((b)???).wW(paramInt1);
    return;
    label261:
    ac.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (mYz)
        {
          Iterator localIterator = new HashSet(mYz.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)mYz.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            ac.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            mYz.remove(localInteger2);
            try
            {
              localb.bEq().parseFrom(paramArrayOfByte);
              localb.wW(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.q(3, -1, "buf to tagResp fail");
              ac.printErrStackTrace("MicroMsg.BackupBaseScene", localException2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[] { Integer.valueOf(localb.getType()), localException2.toString() });
            }
          }
        }
        Integer localInteger1 = Integer.valueOf(localb.getType());
      }
      return;
    }
    ac.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  private static void b(boolean paramBoolean, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21697);
        if (b.bED() != null)
        {
          b.bED().a(this.mSN, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        ac.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static int bCS()
  {
    return mSg;
  }
  
  public static void bDM()
  {
    if (mYH != null) {
      mYH.bDM();
    }
  }
  
  public static int bEC()
  {
    int i = mYG;
    mYG += 1;
    return i;
  }
  
  public static void bEs()
  {
    if (mYC != null) {
      mYC.stop();
    }
    f localf = new f();
    mYC = localf;
    localf.start(true);
  }
  
  public static void bEt()
  {
    if (mYC != null) {
      mYC.stop();
    }
  }
  
  public static void bEu()
  {
    int i = 0;
    if (mYD != null)
    {
      j localj = mYD;
      ac.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.mZt = bs.eWj();
      localj.mZs = 0L;
      localj.mZq = 0L;
      localj.mZw.clear();
      localj.mZv = 0;
      localj.mZu = 0L;
      while (i < 10)
      {
        localj.mZw.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.mZx.au(1000L, 1000L);
      return;
    }
    ac.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void bEv()
  {
    if (mYD != null)
    {
      j localj = mYD;
      ac.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.mZx.stopTimer();
      localj.mZv = 0;
    }
  }
  
  public static String bEw()
  {
    if (mYD == null) {
      return "0B";
    }
    String str = j.re(mYD.mZr);
    ac.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void bEx()
  {
    if (mYE == null) {
      mYE = new g();
    }
    g localg = mYE;
    try
    {
      ac.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.mZe != null)
      {
        localg.mZe.stopTimer();
        localg.mZe = null;
      }
      g.startTime = bs.eWj();
      g.mZc = localg.rd(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void bEy()
  {
    if (mYF != null)
    {
      mYF.mZk = 0;
      h localh = mYF;
      if (!localh.stopped)
      {
        ac.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.mZl.stopTimer();
        localh.stopped = true;
      }
    }
  }
  
  public static int bEz()
  {
    if (mYF == null) {
      return 0;
    }
    return mYF.mZk;
  }
  
  public static void clear()
  {
    ac.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (mYz)
    {
      mYz.clear();
    }
    synchronized (mYy)
    {
      mYy.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static boolean t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, mSg);
    if (mYB != null) {
      mYB.l(paramInt2, localPByteArray.value);
    }
    ac.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static void wK(int paramInt)
  {
    mSg = paramInt;
  }
  
  public static void wX(int paramInt)
  {
    if (mYE != null)
    {
      g localg = mYE;
      try
      {
        ac.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.mZc == 0L))
        {
          ac.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.mZc) });
          return;
        }
        g.endTime = bs.eWj();
        g.mZd = localg.G(g.startTime, g.endTime);
        ac.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.mZd), Long.valueOf(g.mZc) });
        if ((g.mZd != 0L) && (g.mZd > g.mZc)) {
          localg.a(paramInt, g.endTime - g.startTime, g.mZd - g.mZc, false);
        }
        g.init();
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.BackupLogManager", localException, "end exception", new Object[0]);
      }
    }
  }
  
  public static void wY(int paramInt)
  {
    if (mYF != null) {
      mYF.mZk = paramInt;
    }
  }
  
  public static void wZ(int paramInt)
  {
    if (mYD != null)
    {
      j localj = mYD;
      localj.mZs = (paramInt + localj.mZs);
    }
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.mYx = new PByteArray();
    this.mYx.value = ???.value;
    synchronized (mYz)
    {
      mYz.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public boolean bEA()
  {
    try
    {
      byte[] arrayOfByte = bEr().toByteArray();
      synchronized (mYz)
      {
        int i = bEC();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.mYx, mSg);
        if (mYB != null) {
          mYB.l(i, this.mYx.value);
        }
        ac.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.mYx.value.length) });
        mYz.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean bEB()
  {
    try
    {
      byte[] arrayOfByte = bEr().toByteArray();
      synchronized (mYz)
      {
        int i = bEC();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.mYx, mSg);
        if (mYB != null) {
          mYB.m(i, this.mYx.value);
        }
        ac.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.mYx.value.length) });
        mYz.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public abstract a bEq();
  
  public abstract a bEr();
  
  public int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void q(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public abstract void wW(int paramInt);
  
  public static abstract interface c
  {
    public abstract void bDM();
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