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
  static int nsF = -1;
  private static final Map<Integer, Set<com.tencent.mm.al.f>> nyV = new HashMap();
  private static final LinkedHashMap<Integer, b> nyW = new LinkedHashMap();
  private static d nyX;
  static a nyY;
  private static f nyZ = null;
  private static j nza = null;
  private static g nzb = null;
  private static h nzc = null;
  private static int nzd = new Random(bt.flT()).nextInt(1147483648);
  private static c nze = null;
  private PByteArray nyU = new PByteArray();
  
  public static boolean L(byte[] paramArrayOfByte, int paramInt)
  {
    PByteArray localPByteArray = new PByteArray();
    synchronized (nyW)
    {
      int i = bIL();
      com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, i, (short)paramInt, localPByteArray, nsF);
      if (nyY != null) {
        nyY.l(i, localPByteArray.value);
      }
      ad.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localPByteArray.value.length) });
      return true;
    }
  }
  
  public static void a(int paramInt, com.tencent.mm.al.f paramf)
  {
    synchronized (nyV)
    {
      if (!nyV.containsKey(Integer.valueOf(paramInt))) {
        nyV.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)nyV.get(Integer.valueOf(paramInt))).contains(paramf)) {
        ((Set)nyV.get(Integer.valueOf(paramInt))).add(paramf);
      }
      return;
    }
  }
  
  public static void a(a parama)
  {
    nyY = parama;
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
          synchronized (b.bIN())
          {
            l = bt.flT();
            Iterator localIterator = b.bIN().entrySet().iterator();
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
              if (b.bIO() == null) {
                continue;
              }
              b.bIO().m(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
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
              this.nzg.iF(false);
            }
            continue;
            ad.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
          }
          ad.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
          continue;
          this.nzg.iF(true);
          ad.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.bIN().size()), Long.valueOf(bt.Df(l)) });
          AppMethodBeat.o(21699);
          return;
        }
      }
    });
  }
  
  public static void a(c paramc)
  {
    nze = paramc;
  }
  
  public static void a(d paramd)
  {
    nyX = paramd;
  }
  
  public static void a(h.a parama)
  {
    if (nzc != null)
    {
      if (!nzc.stopped)
      {
        ad.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
        return;
      }
      ad.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
    }
    for (;;)
    {
      parama = new h(parama);
      nzc = parama;
      ad.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
      h.index = 0;
      parama.stopped = false;
      parama.nzH = 1;
      if (parama.nzG == null) {
        break;
      }
      parama.nzI.az(0L, 0L);
      return;
      ad.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
    }
  }
  
  public static void a(j.a parama)
  {
    nza = new j(parama);
  }
  
  public static void b(int paramInt, com.tencent.mm.al.f paramf)
  {
    synchronized (nyV)
    {
      try
      {
        if (nyV.get(Integer.valueOf(paramInt)) != null) {
          ((Set)nyV.get(Integer.valueOf(paramInt))).remove(paramf);
        }
        return;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          ad.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[] { paramf });
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
    if (nyZ != null)
    {
      nyZ.bIS();
      ad.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(bt.flT()) });
    }
    synchronized (nyW)
    {
      ??? = (b)nyW.remove(Integer.valueOf(paramInt1));
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
    ((b)???).bIz().parseFrom(paramArrayOfByte);
    ((b)???).xC(paramInt1);
    return;
    label261:
    ad.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[] { Integer.valueOf(paramInt2) });
    if ((??? == null) && (paramInt2 == 16))
    {
      for (;;)
      {
        b localb;
        synchronized (nyW)
        {
          Iterator localIterator = new HashSet(nyW.keySet()).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Integer localInteger2 = (Integer)localIterator.next();
          localb = (b)nyW.get(localInteger2);
          if (localb == null)
          {
            ??? = "null";
            ad.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", new Object[] { localInteger2, localb, ??? });
            if ((localb == null) || (localb.getType() != 15)) {
              continue;
            }
            nyW.remove(localInteger2);
            try
            {
              localb.bIz().parseFrom(paramArrayOfByte);
              localb.xC(paramInt1);
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
        if (b.bIM() != null)
        {
          b.bIM().a(this.ntl, paramInt1, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(21697);
          return;
        }
        ad.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
        AppMethodBeat.o(21697);
      }
    });
  }
  
  public static void bHV()
  {
    if (nze != null) {
      nze.bHV();
    }
  }
  
  public static int bHa()
  {
    return nsF;
  }
  
  public static void bIB()
  {
    if (nyZ != null) {
      nyZ.stop();
    }
    f localf = new f();
    nyZ = localf;
    localf.start(true);
  }
  
  public static void bIC()
  {
    if (nyZ != null) {
      nyZ.stop();
    }
  }
  
  public static void bID()
  {
    int i = 0;
    if (nza != null)
    {
      j localj = nza;
      ad.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
      localj.nzQ = bt.flT();
      localj.nzP = 0L;
      localj.nzN = 0L;
      localj.nzT.clear();
      localj.nzS = 0;
      localj.nzR = 0L;
      while (i < 10)
      {
        localj.nzT.offer(Long.valueOf(204800L));
        i += 1;
      }
      localj.nzU.az(1000L, 1000L);
      return;
    }
    ad.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
  }
  
  public static void bIE()
  {
    if (nza != null)
    {
      j localj = nza;
      ad.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
      localj.nzU.stopTimer();
      localj.nzS = 0;
    }
  }
  
  public static String bIF()
  {
    if (nza == null) {
      return "0B";
    }
    String str = j.td(nza.nzO);
    ad.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", new Object[] { str });
    return str;
  }
  
  public static void bIG()
  {
    if (nzb == null) {
      nzb = new g();
    }
    g localg = nzb;
    try
    {
      ad.i("MicroMsg.BackupLogManager", "start");
      g.init();
      if (localg.nzB != null)
      {
        localg.nzB.stopTimer();
        localg.nzB = null;
      }
      g.startTime = bt.flT();
      g.nzz = localg.tc(g.startTime);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupLogManager", localException, "start exception", new Object[0]);
    }
  }
  
  public static void bIH()
  {
    if (nzc != null)
    {
      nzc.nzH = 0;
      h localh = nzc;
      if (!localh.stopped)
      {
        ad.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
        localh.nzI.stopTimer();
        localh.stopped = true;
      }
    }
  }
  
  public static int bII()
  {
    if (nzc == null) {
      return 0;
    }
    return nzc.nzH;
  }
  
  public static int bIL()
  {
    int i = nzd;
    nzd += 1;
    return i;
  }
  
  public static void clear()
  {
    ad.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
    synchronized (nyW)
    {
      nyW.clear();
    }
    synchronized (nyV)
    {
      nyV.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static boolean t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PByteArray localPByteArray = new PByteArray();
    com.tencent.mm.plugin.backup.f.j.a(paramArrayOfByte, paramInt2, (short)paramInt1, localPByteArray, nsF);
    if (nyY != null) {
      nyY.l(paramInt2, localPByteArray.value);
    }
    ad.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(localPByteArray.value.length) });
    return true;
  }
  
  public static void xD(int paramInt)
  {
    if (nzb != null)
    {
      g localg = nzb;
      try
      {
        ad.i("MicroMsg.BackupLogManager", "end backupMode[%d]", new Object[] { Integer.valueOf(paramInt) });
        if ((g.startTime == 0L) || (g.nzz == 0L))
        {
          ad.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", new Object[] { Long.valueOf(g.startTime), Long.valueOf(g.nzz) });
          return;
        }
        g.endTime = bt.flT();
        g.nzA = localg.G(g.startTime, g.endTime);
        ad.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.nzA), Long.valueOf(g.nzz) });
        if ((g.nzA != 0L) && (g.nzA > g.nzz)) {
          localg.a(paramInt, g.endTime - g.startTime, g.nzA - g.nzz, false);
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
  
  public static void xE(int paramInt)
  {
    if (nzc != null) {
      nzc.nzH = paramInt;
    }
  }
  
  public static void xF(int paramInt)
  {
    if (nza != null)
    {
      j localj = nza;
      localj.nzP = (paramInt + localj.nzP);
    }
  }
  
  public static void xq(int paramInt)
  {
    nsF = paramInt;
  }
  
  public final void a(int paramInt, PByteArray arg2)
  {
    this.nyU = new PByteArray();
    this.nyU.value = ???.value;
    synchronized (nyW)
    {
      nyW.put(Integer.valueOf(paramInt), this);
      return;
    }
  }
  
  public abstract a bIA();
  
  public boolean bIJ()
  {
    try
    {
      byte[] arrayOfByte = bIA().toByteArray();
      synchronized (nyW)
      {
        int i = bIL();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.nyU, nsF);
        if (nyY != null) {
          nyY.l(i, this.nyU.value);
        }
        ad.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.nyU.value.length) });
        nyW.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public final boolean bIK()
  {
    try
    {
      byte[] arrayOfByte = bIA().toByteArray();
      synchronized (nyW)
      {
        int i = bIL();
        com.tencent.mm.plugin.backup.f.j.a(arrayOfByte, i, (short)getType(), this.nyU, nsF);
        if (nyY != null) {
          nyY.m(i, this.nyU.value);
        }
        ad.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(this.nyU.value.length) });
        nyW.put(Integer.valueOf(i), this);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
    }
  }
  
  public abstract a bIz();
  
  public int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    return 0;
  }
  
  public abstract int getType();
  
  protected final void q(int paramInt1, int paramInt2, String paramString)
  {
    handler.post(new b.2(this, paramInt1, paramInt2, paramString));
  }
  
  public abstract void xC(int paramInt);
  
  public static abstract interface a
  {
    public abstract void l(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int m(int paramInt, byte[] paramArrayOfByte);
  }
  
  public static abstract interface b
  {
    public abstract void iF(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void bHV();
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