package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean oLE = false;
  private static boolean oOv = false;
  private boolean ifz;
  private Object lock;
  private long oJj;
  private boolean oKK;
  private HashSet<String> oLB;
  private long oLC;
  private long oLD;
  private com.tencent.mm.plugin.backup.c.d oLs;
  LinkedList<String> oLw;
  LinkedList<Long> oLx;
  private final com.tencent.mm.plugin.backup.g.b.d oOA;
  public Set<b.c> oOw;
  public b.a oOx;
  private long oOy;
  private boolean oOz;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.oJj = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.ifz = false;
    this.oOw = new HashSet();
    this.oLB = new HashSet();
    this.oLC = 0L;
    this.oLD = 0L;
    this.oOy = 0L;
    this.oKK = false;
    this.oOz = false;
    this.oOA = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt1, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(21580);
        if (paramAnonymousArrayOfByte == null) {}
        for (int i = 0;; i = paramAnonymousArrayOfByte.length)
        {
          Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (10011 != paramAnonymousInt1)) {
            break;
          }
          d.a(d.this);
          AppMethodBeat.o(21580);
          return;
        }
        if (paramAnonymousInt1 == 5)
        {
          Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
          d.this.a(true, false, -100);
          h.CyF.idkeyStat(400L, 52L, 1L, false);
          d.this.Bk(5);
          AppMethodBeat.o(21580);
          return;
        }
        i = b.cga().cgb().oOk;
        if ((2 != i) && (4 != i))
        {
          Log.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.cga().cgb().oOk) });
          AppMethodBeat.o(21580);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.oPN;; l = -1L)
          {
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
            AppMethodBeat.o(21580);
            return;
          }
        }
        Object localObject;
        if (paramAnonymousInt1 == 18)
        {
          localObject = new com.tencent.mm.plugin.backup.i.c();
          try
          {
            ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramAnonymousArrayOfByte);
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).oTl) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).oTl == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.cgz();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.Bo(2);
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.Bk(20);
                com.tencent.mm.plugin.backup.g.b.cgy();
                b.cga().ceM().oJc = 23;
                d.this.Ba(23);
                com.tencent.mm.plugin.backup.g.b.Bo(0);
                AppMethodBeat.o(21580);
                return;
              }
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
            }
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            AppMethodBeat.o(21580);
            return;
          }
        }
        if (paramAnonymousInt1 == 17)
        {
          localObject = new com.tencent.mm.plugin.backup.i.b();
          try
          {
            ((com.tencent.mm.plugin.backup.i.b)localObject).parseFrom(paramAnonymousArrayOfByte);
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).oTl) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).oTl == 10)
            {
              paramAnonymousInt1 = b.cga().ceM().oJc;
              Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.a(true, false, -4);
                b.cga().cfw().stop();
                h.CyF.idkeyStat(400L, 52L, 1L, false);
                d.this.Bk(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = Util.milliSecondsToNow(d.b(d.this));
                }
                h.CyF.a(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(d.this)), Long.valueOf(l) });
              }
            }
            AppMethodBeat.o(21580);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
            }
          }
        }
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(21579);
            if (paramAnonymousInt1 == 3)
            {
              d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(21579);
              return;
            }
            if (paramAnonymousInt1 == 11)
            {
              d.b(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(21579);
              return;
            }
            if (paramAnonymousInt1 == 6)
            {
              d.c(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(21579);
              return;
            }
            if (paramAnonymousInt1 == 13)
            {
              d.M(paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(21579);
              return;
            }
            if (paramAnonymousInt1 == 15)
            {
              d.d(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(21579);
              return;
            }
            if (paramAnonymousInt1 == 8)
            {
              d.a(d.this, paramAnonymousArrayOfByte);
              AppMethodBeat.o(21579);
              return;
            }
            AppMethodBeat.o(21579);
          }
        });
        AppMethodBeat.o(21580);
      }
    };
    AppMethodBeat.o(21584);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21590);
    y localy = new y();
    localy.oUz = paramString;
    localy.oUA = paramInt1;
    localy.oUC = paramInt2;
    localy.oUD = paramInt3;
    localy.oTW = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.D(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21590);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21590);
    }
  }
  
  public static boolean cfA()
  {
    AppMethodBeat.i(21586);
    boolean bool = bg.aVF().aTt().gzD();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void cgj()
  {
    oOv = true;
  }
  
  private static void g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.ID = b.cga().oIU;
    localo.oTW = paramInt1;
    localo.oTR = g.Bu(paramLong);
    try
    {
      Log.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.D(localo.toByteArray(), 4, paramInt2);
      AppMethodBeat.o(21591);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
      AppMethodBeat.o(21591);
    }
  }
  
  public final void Ba(final int paramInt)
  {
    AppMethodBeat.i(21593);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.oOw);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21582);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).Ba(paramInt);
        }
        AppMethodBeat.o(21582);
      }
    });
    if (this.oOx != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21583);
          if (d.d(d.this) != null) {
            d.d(d.this).AZ(paramInt);
          }
          AppMethodBeat.o(21583);
        }
      });
    }
    AppMethodBeat.o(21593);
  }
  
  public final void Bk(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.oLC != 0L) {
      l = Util.milliSecondsToNow(this.oLC);
    }
    h.CyF.a(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.oJj / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.cga().cgb().oOq) });
    Log.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.oJj / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21588);
    Log.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), MMStack.getCaller() });
    oOv = true;
    if (!paramBoolean1)
    {
      b.cga().cgb();
      c.cfF();
    }
    synchronized (this.lock)
    {
      this.ifz = true;
      if ((this.oLs != null) && (this.oLs.oKz))
      {
        this.oLs.x(paramBoolean2, paramInt);
        this.oLs = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.cga().ceM().oJc = paramInt;
          Ba(paramInt);
        }
        if (paramBoolean2) {
          cfB();
        }
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        com.tencent.mm.plugin.backup.g.b.cgy();
        b.cga().ceO();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void ceL()
  {
    AppMethodBeat.i(21594);
    cfB();
    h.CyF.idkeyStat(400L, 27L, 1L, false);
    h.CyF.idkeyStat(400L, 28L, Util.milliSecondsToNow(this.oLD) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.Bn(12);
    com.tencent.mm.plugin.backup.g.b.cgt();
    com.tencent.mm.plugin.backup.g.b.cgv();
    AppMethodBeat.o(21594);
  }
  
  public final void cfB()
  {
    AppMethodBeat.i(21587);
    Log.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.oLB.clear();
    if (!g.oJv) {
      g.agw(g.ceZ());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void cgk()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.oLs != null) && (this.oLs.oKz))
      {
        Log.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.oLs != null) {
        this.oLs.x(false, 0);
      }
      if ((this.oLB == null) || (this.oLB.size() <= 0))
      {
        i = bg.aVF().aTt().gzE();
        b.cga().ceM().S(26, 1, i);
        Ba(26);
        if (this.oLw == null) {
          this.oLw = new LinkedList();
        }
        if (this.oLx == null) {
          this.oLx = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.cgP().cgS();
        this.oLD = Util.nowMilliSecond();
        com.tencent.mm.plugin.backup.h.d.cgP().cgS();
        this.oLs = new com.tencent.mm.plugin.backup.c.d(b.cga(), 1, this, i, this.oKK, this.oLw, this.oLx);
        this.oLs.jz(false);
        h.CyF.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.oLB.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    Log.i("MicroMsg.BackupPcRecoverServer", "init");
    this.oOz = false;
    oOv = false;
    oLE = false;
    com.tencent.mm.plugin.backup.g.b.a(this.oOA);
    this.oJj = 0L;
    this.recvSize = 0L;
    this.ifz = false;
    this.oKK = false;
    this.oLB.clear();
    AppMethodBeat.o(21585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */