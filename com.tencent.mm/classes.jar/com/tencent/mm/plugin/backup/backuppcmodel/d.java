package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean nvl = false;
  private static boolean nyd = false;
  private boolean hjP;
  private Object lock;
  private long nsQ;
  private com.tencent.mm.plugin.backup.c.d nuZ;
  private boolean nur;
  LinkedList<String> nvd;
  LinkedList<Long> nve;
  private HashSet<String> nvi;
  private long nvj;
  private long nvk;
  public Set<b.c> nye;
  public b.a nyf;
  private long nyg;
  private boolean nyh;
  private final com.tencent.mm.plugin.backup.g.b.d nyi;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.nsQ = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.hjP = false;
    this.nye = new HashSet();
    this.nvi = new HashSet();
    this.nvj = 0L;
    this.nvk = 0L;
    this.nyg = 0L;
    this.nur = false;
    this.nyh = false;
    this.nyi = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt1, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(21580);
        if (paramAnonymousArrayOfByte == null) {}
        for (int i = 0;; i = paramAnonymousArrayOfByte.length)
        {
          ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (10011 != paramAnonymousInt1)) {
            break;
          }
          d.a(d.this);
          AppMethodBeat.o(21580);
          return;
        }
        if (paramAnonymousInt1 == 5)
        {
          ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
          d.this.b(true, false, -100);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 52L, 1L, false);
          d.this.xA(5);
          AppMethodBeat.o(21580);
          return;
        }
        i = b.bIj().bIk().nxS;
        if ((2 != i) && (4 != i))
        {
          ad.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.bIj().bIk().nxS) });
          AppMethodBeat.o(21580);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)com.tencent.mm.plugin.backup.b.g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.nzv;; l = -1L)
          {
            ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
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
            ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).nCU) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).nCU == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bII();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.xE(2);
                ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.xA(20);
                com.tencent.mm.plugin.backup.g.b.bIH();
                b.bIj().bGX().nsJ = 23;
                d.this.xp(23);
                com.tencent.mm.plugin.backup.g.b.xE(0);
                AppMethodBeat.o(21580);
                return;
              }
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
            }
            ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
            ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).nCU) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).nCU == 10)
            {
              paramAnonymousInt1 = b.bIj().bGX().nsJ;
              ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.b(true, false, -4);
                b.bIj().bHH().stop();
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 52L, 1L, false);
                d.this.xA(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = bt.Df(d.b(d.this));
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
                ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(d.this)), Long.valueOf(l) });
              }
            }
            AppMethodBeat.o(21580);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
            }
          }
        }
        ba.ajF().ay(new Runnable()
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
    localy.nEj = paramString;
    localy.nEk = paramInt1;
    localy.nEm = paramInt2;
    localy.nEn = paramInt3;
    localy.nDG = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21590);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21590);
    }
  }
  
  public static boolean bHL()
  {
    AppMethodBeat.i(21586);
    boolean bool = ba.aBQ().azV().foJ();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void bIs()
  {
    nyd = true;
  }
  
  private static void f(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.ID = b.bIj().nsB;
    localo.nDG = paramInt1;
    localo.nDB = com.tencent.mm.plugin.backup.b.g.ta(paramLong);
    try
    {
      ad.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.t(localo.toByteArray(), 4, paramInt2);
      AppMethodBeat.o(21591);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
      AppMethodBeat.o(21591);
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21588);
    ad.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), at.fkV() });
    nyd = true;
    if (!paramBoolean1)
    {
      b.bIj().bIk();
      c.bHQ();
    }
    synchronized (this.lock)
    {
      this.hjP = true;
      if ((this.nuZ != null) && (this.nuZ.nug))
      {
        this.nuZ.w(paramBoolean2, paramInt);
        this.nuZ = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bIj().bGX().nsJ = paramInt;
          xp(paramInt);
        }
        if (paramBoolean2) {
          bHM();
        }
        com.tencent.mm.plugin.backup.g.b.bIC();
        com.tencent.mm.plugin.backup.g.b.bIE();
        com.tencent.mm.plugin.backup.g.b.bIH();
        b.bIj().bGZ();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void bGW()
  {
    AppMethodBeat.i(21594);
    bHM();
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 27L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 28L, bt.Df(this.nvk) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.xD(12);
    com.tencent.mm.plugin.backup.g.b.bIC();
    com.tencent.mm.plugin.backup.g.b.bIE();
    AppMethodBeat.o(21594);
  }
  
  public final void bHM()
  {
    AppMethodBeat.i(21587);
    ad.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.nvi.clear();
    if (!com.tencent.mm.plugin.backup.b.g.ntc) {
      com.tencent.mm.plugin.backup.b.g.VO(com.tencent.mm.plugin.backup.b.g.bHk());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void bIt()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.nuZ != null) && (this.nuZ.nug))
      {
        ad.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.nuZ != null) {
        this.nuZ.w(false, 0);
      }
      if ((this.nvi == null) || (this.nvi.size() <= 0))
      {
        i = ba.aBQ().azV().foK();
        b.bIj().bGX().R(26, 1, i);
        xp(26);
        if (this.nvd == null) {
          this.nvd = new LinkedList();
        }
        if (this.nve == null) {
          this.nve = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.bIY().bJb();
        this.nvk = bt.flT();
        com.tencent.mm.plugin.backup.h.d.bIY().bJb();
        this.nuZ = new com.tencent.mm.plugin.backup.c.d(b.bIj(), 1, this, i, this.nur, this.nvd, this.nve);
        this.nuZ.iA(false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.nvi.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    ad.i("MicroMsg.BackupPcRecoverServer", "init");
    this.nyh = false;
    nyd = false;
    nvl = false;
    com.tencent.mm.plugin.backup.g.b.a(this.nyi);
    this.nsQ = 0L;
    this.recvSize = 0L;
    this.hjP = false;
    this.nur = false;
    this.nvi.clear();
    AppMethodBeat.o(21585);
  }
  
  public final void xA(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.nvj != 0L) {
      l = bt.Df(this.nvj);
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.nsQ / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.bIj().bIk().nxY) });
    ad.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.nsQ / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
  
  public final void xp(final int paramInt)
  {
    AppMethodBeat.i(21593);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.nye);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21582);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).xp(paramInt);
        }
        AppMethodBeat.o(21582);
      }
    });
    if (this.nyf != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21583);
          if (d.d(d.this) != null) {
            d.d(d.this).xo(paramInt);
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