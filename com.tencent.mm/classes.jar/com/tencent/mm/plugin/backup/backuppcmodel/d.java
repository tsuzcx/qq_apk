package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
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
  private static boolean rNt = false;
  private static boolean rQt = false;
  private boolean kUn;
  private Object lock;
  private long rKZ;
  private boolean rMB;
  private com.tencent.mm.plugin.backup.c.d rNi;
  LinkedList<String> rNm;
  LinkedList<Long> rNn;
  private HashSet<String> rNq;
  private long rNr;
  private long rNs;
  public Set<b.c> rQu;
  public b.a rQv;
  private long rQw;
  private boolean rQx;
  private final com.tencent.mm.plugin.backup.g.b.d rQy;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.rKZ = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.kUn = false;
    this.rQu = new HashSet();
    this.rNq = new HashSet();
    this.rNr = 0L;
    this.rNs = 0L;
    this.rQw = 0L;
    this.rMB = false;
    this.rQx = false;
    this.rQy = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt1, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(271681);
        if (paramAnonymousArrayOfByte == null) {}
        for (int i = 0;; i = paramAnonymousArrayOfByte.length)
        {
          Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (10011 != paramAnonymousInt1)) {
            break;
          }
          d.a(d.this);
          AppMethodBeat.o(271681);
          return;
        }
        if (paramAnonymousInt1 == 5)
        {
          Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
          d.this.a(true, false, -100);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 52L, 1L, false);
          d.this.EL(5);
          AppMethodBeat.o(271681);
          return;
        }
        i = b.ctm().ctn().rQh;
        if ((2 != i) && (4 != i))
        {
          Log.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.ctm().ctn().rQh) });
          AppMethodBeat.o(271681);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.rRK;; l = -1L)
          {
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
            AppMethodBeat.o(271681);
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
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).rVj) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).rVj == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.ctL();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.EP(2);
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.EL(20);
                com.tencent.mm.plugin.backup.g.b.ctK();
                b.ctm().crZ().rKS = 23;
                d.this.EB(23);
                com.tencent.mm.plugin.backup.g.b.EP(0);
                AppMethodBeat.o(271681);
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
            AppMethodBeat.o(271681);
            return;
          }
        }
        if (paramAnonymousInt1 == 17)
        {
          localObject = new com.tencent.mm.plugin.backup.i.b();
          try
          {
            ((com.tencent.mm.plugin.backup.i.b)localObject).parseFrom(paramAnonymousArrayOfByte);
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).rVj) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).rVj == 10)
            {
              paramAnonymousInt1 = b.ctm().crZ().rKS;
              Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.a(true, false, -4);
                b.ctm().csJ().stop();
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 52L, 1L, false);
                d.this.EL(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = Util.milliSecondsToNow(d.b(d.this));
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(d.this)), Long.valueOf(l) });
              }
            }
            AppMethodBeat.o(271681);
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
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(270580);
            if (paramAnonymousInt1 == 3)
            {
              d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(270580);
              return;
            }
            if (paramAnonymousInt1 == 11)
            {
              d.b(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(270580);
              return;
            }
            if (paramAnonymousInt1 == 6)
            {
              d.c(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(270580);
              return;
            }
            if (paramAnonymousInt1 == 13)
            {
              d.M(paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(270580);
              return;
            }
            if (paramAnonymousInt1 == 15)
            {
              d.d(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(270580);
              return;
            }
            if (paramAnonymousInt1 == 8)
            {
              d.a(d.this, paramAnonymousArrayOfByte);
              AppMethodBeat.o(270580);
              return;
            }
            AppMethodBeat.o(270580);
          }
        });
        AppMethodBeat.o(271681);
      }
    };
    AppMethodBeat.o(21584);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21590);
    y localy = new y();
    localy.rWy = paramString;
    localy.rWz = paramInt1;
    localy.rWB = paramInt2;
    localy.rWC = paramInt3;
    localy.rVU = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.F(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21590);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21590);
    }
  }
  
  public static boolean csN()
  {
    AppMethodBeat.i(21586);
    boolean bool = bh.beI().bcr().hvD();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void ctv()
  {
    rQt = true;
  }
  
  private static void h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.ID = b.ctm().rKK;
    localo.rVU = paramInt1;
    localo.rVP = g.HH(paramLong);
    try
    {
      Log.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.F(localo.toByteArray(), 4, paramInt2);
      AppMethodBeat.o(21591);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
      AppMethodBeat.o(21591);
    }
  }
  
  public final void EB(final int paramInt)
  {
    AppMethodBeat.i(21593);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21583);
        Iterator localIterator = this.rNT.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).EB(paramInt);
        }
        AppMethodBeat.o(21583);
      }
    });
    if (this.rQv != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(279372);
          if (d.d(d.this) != null) {
            d.d(d.this).EA(paramInt);
          }
          AppMethodBeat.o(279372);
        }
      });
    }
    AppMethodBeat.o(21593);
  }
  
  public final void EL(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.rNr != 0L) {
      l = Util.milliSecondsToNow(this.rNr);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.rKZ / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.ctm().ctn().rQn) });
    Log.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.rKZ / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21588);
    Log.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), MMStack.getCaller() });
    rQt = true;
    if (!paramBoolean1)
    {
      b.ctm().ctn();
      c.csS();
    }
    synchronized (this.lock)
    {
      this.kUn = true;
      if ((this.rNi != null) && (this.rNi.rMp))
      {
        this.rNi.C(paramBoolean2, paramInt);
        this.rNi = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.ctm().crZ().rKS = paramInt;
          EB(paramInt);
        }
        if (paramBoolean2) {
          com.tencent.e.h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275032);
              d.this.csO();
              AppMethodBeat.o(275032);
            }
          });
        }
        com.tencent.mm.plugin.backup.g.b.ctF();
        com.tencent.mm.plugin.backup.g.b.ctH();
        com.tencent.mm.plugin.backup.g.b.ctK();
        b.ctm().csb();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void crY()
  {
    AppMethodBeat.i(21594);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(281558);
        d.this.csO();
        AppMethodBeat.o(281558);
      }
    });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 27L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 28L, Util.milliSecondsToNow(this.rNs) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.EO(12);
    com.tencent.mm.plugin.backup.g.b.ctF();
    com.tencent.mm.plugin.backup.g.b.ctH();
    AppMethodBeat.o(21594);
  }
  
  public final void csO()
  {
    AppMethodBeat.i(21587);
    Log.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.rNq.clear();
    if (!g.rLl) {
      g.aoa(g.csm());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void ctw()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.rNi != null) && (this.rNi.rMp))
      {
        Log.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.rNi != null) {
        this.rNi.C(false, 0);
      }
      if ((this.rNq == null) || (this.rNq.size() <= 0))
      {
        i = bh.beI().bcr().hvE();
        b.ctm().crZ().T(26, 1, i);
        EB(26);
        if (this.rNm == null) {
          this.rNm = new LinkedList();
        }
        if (this.rNn == null) {
          this.rNn = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.cua().cud();
        this.rNs = Util.nowMilliSecond();
        com.tencent.mm.plugin.backup.h.d.cua().cud();
        this.rNi = new com.tencent.mm.plugin.backup.c.d(b.ctm(), 1, this, i, this.rMB, this.rNm, this.rNn);
        this.rNi.kK(false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.rNq.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    Log.i("MicroMsg.BackupPcRecoverServer", "init");
    this.rQx = false;
    rQt = false;
    rNt = false;
    com.tencent.mm.plugin.backup.g.b.a(this.rQy);
    this.rKZ = 0L;
    this.recvSize = 0L;
    this.kUn = false;
    this.rMB = false;
    this.rNq.clear();
    AppMethodBeat.o(21585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */