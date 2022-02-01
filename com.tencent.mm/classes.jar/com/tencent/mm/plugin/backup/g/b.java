package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
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
  extends q
{
  private static final MMHandler handler = new MMHandler(Looper.getMainLooper());
  private static int rKO = -1;
  private static final Map<Integer, Set<i>> rRk = new HashMap();
  private static final LinkedHashMap<Integer, b> rRl = new LinkedHashMap();
  private static d rRm;
  private static a rRn;
  private static f rRo = null;
  private static j rRp = null;
  private static g rRq = null;
  private static h rRr = null;
  private static int rRs = new Random(Util.nowMilliSecond()).nextInt(1147483648);
  private static c rRt = null;
  private PByteArray rRj = new PByteArray();
  
  public static void EC(int paramInt)
  {
    rKO = paramInt;
  }
  
  public static void EO(int paramInt)
  {
    if (rRq != null)
    {
      g localg = rRq;
      try
      {
        Log.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.rRO == 0L))
        {
          Log.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.rRO) });
          return;
        }
        g.endTime = Util.nowMilliSecond();
        g.rRP = localg.L(g.startTime, g.endTime);
        Log.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.rRP), Long.valueOf(g.rRO) });
        if ((g.rRP != 0L) && (g.rRP > g.rRO)) {
          localg.a(paramInt, g.endTime - g.startTime, g.rRP - g.rRO, false);
        }
        g.init();
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BackupLogManager", localException, "end exception", new Object[0]);
      }
    }
  }
  
  public static void EP(int paramInt)
  {
    if (rRr != null) {
      rRr.rRW = paramInt;
    }
  }
  
  public static void EQ(int paramInt)
  {
    if (rRp != null)
    {
      j localj = rRp;
      localj.rSe = (paramInt + localj.rSe);
    }
  }
  
  public static boolean F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, rKO);
    if (rRn != null) {
      rRn.m(paramInt2, localPByteArray.value);
    }
    Log.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static boolean O(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (rRl)
    {
      int i = ctO();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, rKO);
      if (rRn != null) {
        rRn.m(i, localPByteArray.value);
      }
      Log.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, i parami)
  {
    synchronized (rRk)
    {
      if (!rRk.containsKey(Integer.valueOf(paramInt))) {
        rRk.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)rRk.get(Integer.valueOf(paramInt))).contains(parami)) {
        ((Set)rRk.get(Integer.valueOf(paramInt))).add(parami);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    rRn = parama;
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
          synchronized (b.ctQ())
          {
            l = Util.nowMilliSecond();
            Iterator localIterator = b.ctQ().entrySet().iterator();
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
              if (b.ctR() == null) {
                continue;
              }
              b.ctR().n(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
              Log.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
            }
            catch (Exception localException)
            {
              PByteArray localPByteArray;
              Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
              continue;
            }
            i += 1;
            if ((i > 0) && (i % 5 == 0)) {
              this.rRv.kP(false);
            }
            continue;
            Log.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
          }
          Log.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
          continue;
          this.rRv.kP(true);
          Log.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.ctQ().size()), Long.valueOf(Util.milliSecondsToNow(l)) });
          AppMethodBeat.o(21699);
          return;
        }
      }
    });
  }
  
  public static void a(c paramc)
  {
    rRt = paramc;
  }
  
  public static void a(d paramd)
  {
    rRm = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (rRr != null)
    {
      if (!rRr.aFI)
      {
        Log.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      rRr = parama;
      Log.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.aFI = false;
      parama.rRW = 1;
      if (parama.rRV == null) {
        break;
      }
      parama.rRX.startTimer(0L);
      return;
      Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    rRp = new j(parama);
  }
  
  public static void b(int paramInt, i parami)
  {
    synchronized (rRk)
    {
      try
      {
        if (rRk.get(Integer.valueOf(paramInt)) != null) {
          ((Set)rRk.get(Integer.valueOf(paramInt))).remove(parami);
        }
        return;
      }
      catch (Exception parami)
      {
        for (;;)
        {
          Log.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { parami });
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
      Log.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
          Log.w("MicroMsg.BackupBaseScene", str);
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
    if (rRo != null)
    {
      rRo.ctV();
      Log.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(Util.nowMilliSecond()) });
    }
    synchronized (rRl)
    {
      ??? = (b)rRl.remove(Integer.valueOf(paramInt1));
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
          ((b)???).r(3, -1, "buf to resq fail");
          Log.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).ctC().parseFrom(paramArrayOfByte);
    ((b)???).EN(paramInt1);
    return;
    label262:
    Log.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (rRl)
        {
          Iterator localIterator = new HashSet(rRl.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)rRl.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            Log.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            rRl.remove(localInteger2);
            try
            {
              localb.ctC().parseFrom(paramArrayOfByte);
              localb.EN(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.r(3, -1, "buf to tagResp fail");
              Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[] { Integer.valueOf(localb.getType()), localException2.toString() });
            }
          }
        }
        Integer localInteger1 = Integer.valueOf(localb.getType());
      }
      return;
    }
    Log.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b(paramBoolean, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  private static void b(boolean paramBoolean, final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2)
  {
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21697);
        if (b.ctP() != null)
        {
          b.ctP().a(this.rLu, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        Log.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static void clear()
  {
    Log.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (rRl)
    {
      rRl.clear();
    }
    synchronized (rRk)
    {
      rRk.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static void csV()
  {
    if (rRt != null) {
      rRt.csV();
    }
  }
  
  public static int csc()
  {
    return rKO;
  }
  
  public static void ctE()
  {
    if (rRo != null) {
      rRo.stop();
    }
    f localf = new f();
    rRo = localf;
    localf.start(true);
  }
  
  public static void ctF()
  {
    if (rRo != null) {
      rRo.stop();
    }
  }
  
  public static void ctG()
  {
    int i = 0;
    if (rRp != null)
    {
      j localj = rRp;
      Log.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.rSf = Util.nowMilliSecond();
      localj.rSe = 0L;
      localj.rSc = 0L;
      localj.rSi.clear();
      localj.rSh = 0;
      localj.rSg = 0L;
      while (i < 10)
      {
        localj.rSi.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.rSj.startTimer(1000L);
      return;
    }
    Log.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void ctH()
  {
    if (rRp != null)
    {
      j localj = rRp;
      Log.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.rSj.stopTimer();
      localj.rSh = 0;
    }
  }
  
  public static String ctI()
  {
    if (rRp == null) {
      return "0B";
    }
    String str = j.HK(rRp.rSd);
    Log.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void ctJ()
  {
    if (rRq == null) {
      rRq = new g();
    }
    g localg = rRq;
    try
    {
      Log.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.rRQ != null)
      {
        localg.rRQ.stopTimer();
        localg.rRQ = null;
      }
      g.startTime = Util.nowMilliSecond();
      g.rRO = localg.HJ(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void ctK()
  {
    if (rRr != null)
    {
      rRr.rRW = 0;
      h localh = rRr;
      if (!localh.aFI)
      {
        Log.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.rRX.stopTimer();
        localh.aFI = true;
      }
    }
  }
  
  public static int ctL()
  {
    if (rRr == null) {
      return 0;
    }
    return rRr.rRW;
  }
  
  public static int ctO()
  {
    int i = rRs;
    rRs += 1;
    return i;
  }
  
  public abstract void EN(int paramInt);
  
  public final boolean N(byte[] paramArrayOfByte, int paramInt)
  {
    if (rRn != null) {
      Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(rRn.n(paramInt, paramArrayOfByte)), Integer.valueOf(paramInt), Integer.valueOf(getType()), Integer.valueOf(paramArrayOfByte.length) });
    }
    return true;
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.rRj = new PByteArray();
    this.rRj.value = ???.value;
    synchronized (rRl)
    {
      rRl.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public abstract a ctC();
  
  public abstract a ctD();
  
  public boolean ctM()
  {
    try
    {
      byte[] arrayOfByte = ctD().toByteArray();
      synchronized (rRl)
      {
        int i = ctO();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.rRj, rKO);
        if (rRn != null) {
          rRn.m(i, this.rRj.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.rRj.value.length) });
        rRl.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean ctN()
  {
    try
    {
      byte[] arrayOfByte = ctD().toByteArray();
      synchronized (rRl)
      {
        int i = ctO();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.rRj, rKO);
        if (rRn != null) {
          rRn.n(i, this.rRj.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.rRj.value.length) });
        rRl.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void r(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public static abstract interface a
  {
    public abstract void m(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int n(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void kP(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void csV();
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b
 * JD-Core Version:    0.7.0.1
 */