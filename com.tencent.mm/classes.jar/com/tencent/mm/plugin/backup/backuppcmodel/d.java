package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean nAG = false;
  private static boolean nDy = false;
  private boolean hmD;
  private Object lock;
  private HashSet<String> nAD;
  private long nAE;
  private long nAF;
  private com.tencent.mm.plugin.backup.c.d nAu;
  LinkedList<String> nAy;
  LinkedList<Long> nAz;
  public b.a nDA;
  private long nDB;
  private boolean nDC;
  private final com.tencent.mm.plugin.backup.g.b.d nDD;
  public Set<b.c> nDz;
  private long nyl;
  private boolean nzM;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.nyl = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.hmD = false;
    this.nDz = new HashSet();
    this.nAD = new HashSet();
    this.nAE = 0L;
    this.nAF = 0L;
    this.nDB = 0L;
    this.nzM = false;
    this.nDC = false;
    this.nDD = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt1, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(21580);
        if (paramAnonymousArrayOfByte == null) {}
        for (int i = 0;; i = paramAnonymousArrayOfByte.length)
        {
          ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (10011 != paramAnonymousInt1)) {
            break;
          }
          d.a(d.this);
          AppMethodBeat.o(21580);
          return;
        }
        if (paramAnonymousInt1 == 5)
        {
          ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
          d.this.b(true, false, -100);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 52L, 1L, false);
          d.this.xE(5);
          AppMethodBeat.o(21580);
          return;
        }
        i = b.bJh().bJi().nDn;
        if ((2 != i) && (4 != i))
        {
          ae.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.bJh().bJi().nDn) });
          AppMethodBeat.o(21580);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.nEQ;; l = -1L)
          {
            ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
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
            ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).nIp) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).nIp == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bJG();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.xI(2);
                ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.xE(20);
                com.tencent.mm.plugin.backup.g.b.bJF();
                b.bJh().bHV().nye = 23;
                d.this.xu(23);
                com.tencent.mm.plugin.backup.g.b.xI(0);
                AppMethodBeat.o(21580);
                return;
              }
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
            }
            ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
            ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).nIp) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).nIp == 10)
            {
              paramAnonymousInt1 = b.bJh().bHV().nye;
              ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.b(true, false, -4);
                b.bJh().bIF().stop();
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 52L, 1L, false);
                d.this.xE(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = bu.DD(d.b(d.this));
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
                ae.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(d.this)), Long.valueOf(l) });
              }
            }
            AppMethodBeat.o(21580);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
            }
          }
        }
        bc.ajU().aw(new Runnable()
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
              d.K(paramAnonymousArrayOfByte, paramAnonymousInt2);
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
    localy.nJE = paramString;
    localy.nJF = paramInt1;
    localy.nJH = paramInt2;
    localy.nJI = paramInt3;
    localy.nJb = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21590);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21590);
    }
  }
  
  public static boolean bIJ()
  {
    AppMethodBeat.i(21586);
    boolean bool = bc.aCg().aAl().fsC();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void bJq()
  {
    nDy = true;
  }
  
  private static void f(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.ID = b.bJh().nxW;
    localo.nJb = paramInt1;
    localo.nIW = com.tencent.mm.plugin.backup.b.g.to(paramLong);
    try
    {
      ae.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.t(localo.toByteArray(), 4, paramInt2);
      AppMethodBeat.o(21591);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
      AppMethodBeat.o(21591);
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21588);
    ae.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), au.foQ() });
    nDy = true;
    if (!paramBoolean1)
    {
      b.bJh().bJi();
      c.bIO();
    }
    synchronized (this.lock)
    {
      this.hmD = true;
      if ((this.nAu != null) && (this.nAu.nzB))
      {
        this.nAu.x(paramBoolean2, paramInt);
        this.nAu = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bJh().bHV().nye = paramInt;
          xu(paramInt);
        }
        if (paramBoolean2) {
          bIK();
        }
        com.tencent.mm.plugin.backup.g.b.bJA();
        com.tencent.mm.plugin.backup.g.b.bJC();
        com.tencent.mm.plugin.backup.g.b.bJF();
        b.bJh().bHX();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void bHU()
  {
    AppMethodBeat.i(21594);
    bIK();
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 27L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 28L, bu.DD(this.nAF) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.xH(12);
    com.tencent.mm.plugin.backup.g.b.bJA();
    com.tencent.mm.plugin.backup.g.b.bJC();
    AppMethodBeat.o(21594);
  }
  
  public final void bIK()
  {
    AppMethodBeat.i(21587);
    ae.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.nAD.clear();
    if (!com.tencent.mm.plugin.backup.b.g.nyx) {
      com.tencent.mm.plugin.backup.b.g.WA(com.tencent.mm.plugin.backup.b.g.bIi());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void bJr()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.nAu != null) && (this.nAu.nzB))
      {
        ae.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.nAu != null) {
        this.nAu.x(false, 0);
      }
      if ((this.nAD == null) || (this.nAD.size() <= 0))
      {
        i = bc.aCg().aAl().fsD();
        b.bJh().bHV().R(26, 1, i);
        xu(26);
        if (this.nAy == null) {
          this.nAy = new LinkedList();
        }
        if (this.nAz == null) {
          this.nAz = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
        this.nAF = bu.fpO();
        com.tencent.mm.plugin.backup.h.d.bJW().bJZ();
        this.nAu = new com.tencent.mm.plugin.backup.c.d(b.bJh(), 1, this, i, this.nzM, this.nAy, this.nAz);
        this.nAu.iy(false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.nAD.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    ae.i("MicroMsg.BackupPcRecoverServer", "init");
    this.nDC = false;
    nDy = false;
    nAG = false;
    com.tencent.mm.plugin.backup.g.b.a(this.nDD);
    this.nyl = 0L;
    this.recvSize = 0L;
    this.hmD = false;
    this.nzM = false;
    this.nAD.clear();
    AppMethodBeat.o(21585);
  }
  
  public final void xE(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.nAE != 0L) {
      l = bu.DD(this.nAE);
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.nyl / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.bJh().bJi().nDt) });
    ae.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.nyl / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
  
  public final void xu(final int paramInt)
  {
    AppMethodBeat.i(21593);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.nDz);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21582);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).xu(paramInt);
        }
        AppMethodBeat.o(21582);
      }
    });
    if (this.nDA != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21583);
          if (d.d(d.this) != null) {
            d.d(d.this).xt(paramInt);
          }
          AppMethodBeat.o(21583);
        }
      });
    }
    AppMethodBeat.o(21593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */