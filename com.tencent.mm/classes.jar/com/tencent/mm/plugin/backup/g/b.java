package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
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
  static int oIY = -1;
  private static final Map<Integer, Set<i>> oPn = new HashMap();
  private static final LinkedHashMap<Integer, b> oPo = new LinkedHashMap();
  private static d oPp;
  static a oPq;
  private static f oPr = null;
  private static j oPs = null;
  private static g oPt = null;
  private static h oPu = null;
  private static int oPv = new Random(Util.nowMilliSecond()).nextInt(1147483648);
  private static c oPw = null;
  private PByteArray oPm = new PByteArray();
  
  public static void Bb(int paramInt)
  {
    oIY = paramInt;
  }
  
  public static void Bn(int paramInt)
  {
    if (oPt != null)
    {
      g localg = oPt;
      try
      {
        Log.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.oPR == 0L))
        {
          Log.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.oPR) });
          return;
        }
        g.endTime = Util.nowMilliSecond();
        g.oPS = localg.K(g.startTime, g.endTime);
        Log.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.oPS), Long.valueOf(g.oPR) });
        if ((g.oPS != 0L) && (g.oPS > g.oPR)) {
          localg.a(paramInt, g.endTime - g.startTime, g.oPS - g.oPR, false);
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
  
  public static void Bo(int paramInt)
  {
    if (oPu != null) {
      oPu.oPZ = paramInt;
    }
  }
  
  public static void Bp(int paramInt)
  {
    if (oPs != null)
    {
      j localj = oPs;
      localj.oQh = (paramInt + localj.oQh);
    }
  }
  
  public static boolean D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, oIY);
    if (oPq != null) {
      oPq.l(paramInt2, localPByteArray.value);
    }
    Log.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static boolean N(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (oPo)
    {
      int i = cgC();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, oIY);
      if (oPq != null) {
        oPq.l(i, localPByteArray.value);
      }
      Log.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, i parami)
  {
    synchronized (oPn)
    {
      if (!oPn.containsKey(Integer.valueOf(paramInt))) {
        oPn.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)oPn.get(Integer.valueOf(paramInt))).contains(parami)) {
        ((Set)oPn.get(Integer.valueOf(paramInt))).add(parami);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    oPq = parama;
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
          synchronized (b.cgE())
          {
            l = Util.nowMilliSecond();
            Iterator localIterator = b.cgE().entrySet().iterator();
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
              if (b.cgF() == null) {
                continue;
              }
              b.cgF().m(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
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
              this.oPy.jE(false);
            }
            continue;
            Log.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
          }
          Log.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
          continue;
          this.oPy.jE(true);
          Log.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.cgE().size()), Long.valueOf(Util.milliSecondsToNow(l)) });
          AppMethodBeat.o(21699);
          return;
        }
      }
    });
  }
  
  public static void a(c paramc)
  {
    oPw = paramc;
  }
  
  public static void a(d paramd)
  {
    oPp = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (oPu != null)
    {
      if (!oPu.stopped)
      {
        Log.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      oPu = parama;
      Log.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.stopped = false;
      parama.oPZ = 1;
      if (parama.oPY == null) {
        break;
      }
      parama.oQa.startTimer(0L);
      return;
      Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    oPs = new j(parama);
  }
  
  public static void b(int paramInt, i parami)
  {
    synchronized (oPn)
    {
      try
      {
        if (oPn.get(Integer.valueOf(paramInt)) != null) {
          ((Set)oPn.get(Integer.valueOf(paramInt))).remove(parami);
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
    if (oPr != null)
    {
      oPr.cgJ();
      Log.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(Util.nowMilliSecond()) });
    }
    synchronized (oPo)
    {
      ??? = (b)oPo.remove(Integer.valueOf(paramInt1));
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
          ((b)???).q(3, -1, "buf to resq fail");
          Log.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).cgq().parseFrom(paramArrayOfByte);
    ((b)???).Bm(paramInt1);
    return;
    label262:
    Log.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (oPo)
        {
          Iterator localIterator = new HashSet(oPo.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)oPo.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            Log.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            oPo.remove(localInteger2);
            try
            {
              localb.cgq().parseFrom(paramArrayOfByte);
              localb.Bm(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.q(3, -1, "buf to tagResp fail");
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
        if (b.cgD() != null)
        {
          b.cgD().a(this.oJE, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        Log.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static int ceP()
  {
    return oIY;
  }
  
  public static void cfK()
  {
    if (oPw != null) {
      oPw.cfK();
    }
  }
  
  public static int cgC()
  {
    int i = oPv;
    oPv += 1;
    return i;
  }
  
  public static void cgs()
  {
    if (oPr != null) {
      oPr.stop();
    }
    f localf = new f();
    oPr = localf;
    localf.start(true);
  }
  
  public static void cgt()
  {
    if (oPr != null) {
      oPr.stop();
    }
  }
  
  public static void cgu()
  {
    int i = 0;
    if (oPs != null)
    {
      j localj = oPs;
      Log.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.oQi = Util.nowMilliSecond();
      localj.oQh = 0L;
      localj.oQf = 0L;
      localj.oQl.clear();
      localj.oQk = 0;
      localj.oQj = 0L;
      while (i < 10)
      {
        localj.oQl.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.oQm.startTimer(1000L);
      return;
    }
    Log.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void cgv()
  {
    if (oPs != null)
    {
      j localj = oPs;
      Log.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.oQm.stopTimer();
      localj.oQk = 0;
    }
  }
  
  public static String cgw()
  {
    if (oPs == null) {
      return "0B";
    }
    String str = j.Bx(oPs.oQg);
    Log.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void cgx()
  {
    if (oPt == null) {
      oPt = new g();
    }
    g localg = oPt;
    try
    {
      Log.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.oPT != null)
      {
        localg.oPT.stopTimer();
        localg.oPT = null;
      }
      g.startTime = Util.nowMilliSecond();
      g.oPR = localg.Bw(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void cgy()
  {
    if (oPu != null)
    {
      oPu.oPZ = 0;
      h localh = oPu;
      if (!localh.stopped)
      {
        Log.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.oQa.stopTimer();
        localh.stopped = true;
      }
    }
  }
  
  public static int cgz()
  {
    if (oPu == null) {
      return 0;
    }
    return oPu.oPZ;
  }
  
  public static void clear()
  {
    Log.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (oPo)
    {
      oPo.clear();
    }
    synchronized (oPn)
    {
      oPn.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public abstract void Bm(int paramInt);
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.oPm = new PByteArray();
    this.oPm.value = ???.value;
    synchronized (oPo)
    {
      oPo.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public boolean cgA()
  {
    try
    {
      byte[] arrayOfByte = cgr().toByteArray();
      synchronized (oPo)
      {
        int i = cgC();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.oPm, oIY);
        if (oPq != null) {
          oPq.l(i, this.oPm.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.oPm.value.length) });
        oPo.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean cgB()
  {
    try
    {
      byte[] arrayOfByte = cgr().toByteArray();
      synchronized (oPo)
      {
        int i = cgC();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.oPm, oIY);
        if (oPq != null) {
          oPq.m(i, this.oPm.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.oPm.value.length) });
        oPo.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public abstract a cgq();
  
  public abstract a cgr();
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void q(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public static abstract interface a
  {
    public abstract void l(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int m(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void jE(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void cfK();
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b
 * JD-Core Version:    0.7.0.1
 */