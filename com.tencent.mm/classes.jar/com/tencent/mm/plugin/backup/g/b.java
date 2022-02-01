package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
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
  extends p
{
  private static final MMHandler handler = new MMHandler(Looper.getMainLooper());
  private static int uWc = -1;
  private static final Map<Integer, Set<com.tencent.mm.am.h>> vcA = new HashMap();
  private static final LinkedHashMap<Integer, b> vcB = new LinkedHashMap();
  private static d vcC;
  private static a vcD;
  private static f vcE = null;
  private static j vcF = null;
  private static g vcG = null;
  private static h vcH = null;
  private static int vcI = new Random(Util.nowMilliSecond()).nextInt(1147483648);
  private static c vcJ = null;
  private PByteArray vcz = new PByteArray();
  
  public static boolean D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, uWc);
    if (vcD != null) {
      vcD.m(paramInt2, localPByteArray.value);
    }
    Log.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static void Fd(int paramInt)
  {
    uWc = paramInt;
  }
  
  public static void Fp(int paramInt)
  {
    if (vcG != null)
    {
      g localg = vcG;
      try
      {
        Log.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.vde == 0L))
        {
          Log.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.vde) });
          return;
        }
        g.endTime = Util.nowMilliSecond();
        g.vdf = localg.aj(g.startTime, g.endTime);
        Log.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.vdf), Long.valueOf(g.vde) });
        if ((g.vdf != 0L) && (g.vdf > g.vde)) {
          localg.a(paramInt, g.endTime - g.startTime, g.vdf - g.vde, false);
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
  
  public static void Fq(int paramInt)
  {
    if (vcH != null) {
      vcH.vdm = paramInt;
    }
  }
  
  public static void Fr(int paramInt)
  {
    if (vcF != null)
    {
      j localj = vcF;
      localj.vdu = (paramInt + localj.vdu);
    }
  }
  
  public static boolean N(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (vcB)
    {
      int i = cWy();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, uWc);
      if (vcD != null) {
        vcD.m(i, localPByteArray.value);
      }
      Log.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.am.h paramh)
  {
    synchronized (vcA)
    {
      if (!vcA.containsKey(Integer.valueOf(paramInt))) {
        vcA.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)vcA.get(Integer.valueOf(paramInt))).contains(paramh)) {
        ((Set)vcA.get(Integer.valueOf(paramInt))).add(paramh);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    vcD = parama;
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
          synchronized (b.cWA())
          {
            l = Util.nowMilliSecond();
            Iterator localIterator = b.cWA().entrySet().iterator();
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
              if (b.cWB() == null) {
                continue;
              }
              b.cWB().n(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
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
              b.this.mc(false);
            }
            continue;
            Log.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
          }
          Log.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
          continue;
          b.this.mc(true);
          Log.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.cWA().size()), Long.valueOf(Util.milliSecondsToNow(l)) });
          AppMethodBeat.o(21699);
          return;
        }
      }
    });
  }
  
  public static void a(c paramc)
  {
    vcJ = paramc;
  }
  
  public static void a(d paramd)
  {
    vcC = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (vcH != null)
    {
      if (!vcH.cBt)
      {
        Log.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      vcH = parama;
      Log.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.cBt = false;
      parama.vdm = 1;
      if (parama.vdl == null) {
        break;
      }
      parama.vdn.startTimer(0L);
      return;
      Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    vcF = new j(parama);
  }
  
  public static void b(int paramInt, com.tencent.mm.am.h paramh)
  {
    synchronized (vcA)
    {
      try
      {
        if (vcA.get(Integer.valueOf(paramInt)) != null) {
          ((Set)vcA.get(Integer.valueOf(paramInt))).remove(paramh);
        }
        return;
      }
      catch (Exception paramh)
      {
        for (;;)
        {
          Log.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramh });
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
    if (vcE != null)
    {
      vcE.cWF();
      Log.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(Util.nowMilliSecond()) });
    }
    synchronized (vcB)
    {
      ??? = (b)vcB.remove(Integer.valueOf(paramInt1));
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
          ((b)???).u(3, -1, "buf to resq fail");
          Log.printErrStackTrace("MicroMsg.BackupBaseScene", paramArrayOfByte, "%s ", new Object[] { paramArrayOfByte.toString() });
          return;
        }
      }
    }
    ((b)???).cWm().parseFrom(paramArrayOfByte);
    ((b)???).Fo(paramInt1);
    return;
    label262:
    Log.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (vcB)
        {
          Iterator localIterator = new HashSet(vcB.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)vcB.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            Log.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            vcB.remove(localInteger2);
            try
            {
              localb.cWm().parseFrom(paramArrayOfByte);
              localb.Fo(paramInt1);
            }
            catch (Exception localException2)
            {
              localb.u(3, -1, "buf to tagResp fail");
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
        if (b.cWz() != null)
        {
          b.cWz().a(this.uWH, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        Log.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static int cUM()
  {
    return uWc;
  }
  
  public static void cVF()
  {
    if (vcJ != null) {
      vcJ.cVF();
    }
  }
  
  public static void cWo()
  {
    if (vcE != null) {
      vcE.stop();
    }
    f localf = new f();
    vcE = localf;
    localf.start(true);
  }
  
  public static void cWp()
  {
    if (vcE != null) {
      vcE.stop();
    }
  }
  
  public static void cWq()
  {
    int i = 0;
    if (vcF != null)
    {
      j localj = vcF;
      Log.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.vdv = Util.nowMilliSecond();
      localj.vdu = 0L;
      localj.vds = 0L;
      localj.vdy.clear();
      localj.vdx = 0;
      localj.vdw = 0L;
      while (i < 10)
      {
        localj.vdy.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.vdz.startTimer(1000L);
      return;
    }
    Log.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void cWr()
  {
    if (vcF != null)
    {
      j localj = vcF;
      Log.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.vdz.stopTimer();
      localj.vdx = 0;
    }
  }
  
  public static String cWs()
  {
    if (vcF == null) {
      return "0B";
    }
    String str = j.kb(vcF.vdt);
    Log.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void cWt()
  {
    if (vcG == null) {
      vcG = new g();
    }
    g localg = vcG;
    try
    {
      Log.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.vdg != null)
      {
        localg.vdg.stopTimer();
        localg.vdg = null;
      }
      g.startTime = Util.nowMilliSecond();
      g.vde = localg.ka(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void cWu()
  {
    if (vcH != null)
    {
      vcH.vdm = 0;
      h localh = vcH;
      if (!localh.cBt)
      {
        Log.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.vdn.stopTimer();
        localh.cBt = true;
      }
    }
  }
  
  public static int cWv()
  {
    if (vcH == null) {
      return 0;
    }
    return vcH.vdm;
  }
  
  public static int cWy()
  {
    int i = vcI;
    vcI += 1;
    return i;
  }
  
  public static void clear()
  {
    Log.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (vcB)
    {
      vcB.clear();
    }
    synchronized (vcA)
    {
      vcA.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public abstract void Fo(int paramInt);
  
  public final boolean M(byte[] paramArrayOfByte, int paramInt)
  {
    if (vcD != null) {
      Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(vcD.n(paramInt, paramArrayOfByte)), Integer.valueOf(paramInt), Integer.valueOf(getType()), Integer.valueOf(paramArrayOfByte.length) });
    }
    return true;
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.vcz = new PByteArray();
    this.vcz.value = ???.value;
    synchronized (vcB)
    {
      vcB.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public abstract a cWm();
  
  public abstract a cWn();
  
  public boolean cWw()
  {
    try
    {
      byte[] arrayOfByte = cWn().toByteArray();
      synchronized (vcB)
      {
        int i = cWy();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.vcz, uWc);
        if (vcD != null) {
          vcD.m(i, this.vcz.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.vcz.value.length) });
        vcB.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean cWx()
  {
    try
    {
      byte[] arrayOfByte = cWn().toByteArray();
      synchronized (vcB)
      {
        int i = cWy();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.vcz, uWc);
        if (vcD != null) {
          vcD.n(i, this.vcz.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.vcz.value.length) });
        vcB.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void u(int paramInt1, int paramInt2, String paramString)
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
    public abstract void mc(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void cVF();
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b
 * JD-Core Version:    0.7.0.1
 */