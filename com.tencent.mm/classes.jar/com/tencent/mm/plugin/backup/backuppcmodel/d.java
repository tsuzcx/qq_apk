package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.report.service.h;
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
  private static boolean msM = false;
  private static boolean mvF = false;
  private boolean gqP;
  private Object lock;
  private long mqq;
  private boolean mrR;
  private com.tencent.mm.plugin.backup.c.d msA;
  LinkedList<String> msE;
  LinkedList<Long> msF;
  private HashSet<String> msJ;
  private long msK;
  private long msL;
  public Set<b.c> mvG;
  public b.a mvH;
  private long mvI;
  private boolean mvJ;
  private final com.tencent.mm.plugin.backup.g.b.d mvK;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.mqq = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.gqP = false;
    this.mvG = new HashSet();
    this.msJ = new HashSet();
    this.msK = 0L;
    this.msL = 0L;
    this.mvI = 0L;
    this.mrR = false;
    this.mvJ = false;
    this.mvK = new com.tencent.mm.plugin.backup.g.b.d()
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
          h.vKh.idkeyStat(400L, 52L, 1L, false);
          d.this.wd(5);
          AppMethodBeat.o(21580);
          return;
        }
        i = b.bxe().bxf().mvu;
        if ((2 != i) && (4 != i))
        {
          ad.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.bxe().bxf().mvu) });
          AppMethodBeat.o(21580);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.mwX;; l = -1L)
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
            ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).mAw) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).mAw == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bxD();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.wh(2);
                ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.wd(20);
                com.tencent.mm.plugin.backup.g.b.bxC();
                b.bxe().bvT().mqj = 23;
                d.this.vS(23);
                com.tencent.mm.plugin.backup.g.b.wh(0);
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
            ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).mAw) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).mAw == 10)
            {
              paramAnonymousInt1 = b.bxe().bvT().mqj;
              ad.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.b(true, false, -4);
                b.bxe().bwD().stop();
                h.vKh.idkeyStat(400L, 52L, 1L, false);
                d.this.wd(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = bt.vM(d.b(d.this));
                }
                h.vKh.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
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
        az.afE().ax(new Runnable()
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
    localy.mBL = paramString;
    localy.mBM = paramInt1;
    localy.mBO = paramInt2;
    localy.mBP = paramInt3;
    localy.mBi = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.u(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21590);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21590);
    }
  }
  
  public static boolean bwH()
  {
    AppMethodBeat.i(21586);
    boolean bool = az.arV().aqr().eJC();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void bxn()
  {
    mvF = true;
  }
  
  private static void f(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.ID = b.bxe().mqb;
    localo.mBi = paramInt1;
    localo.mBd = g.np(paramLong);
    try
    {
      ad.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.u(localo.toByteArray(), 4, paramInt2);
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
    ad.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), at.eFT() });
    mvF = true;
    if (!paramBoolean1)
    {
      b.bxe().bxf();
      c.bwM();
    }
    synchronized (this.lock)
    {
      this.gqP = true;
      if ((this.msA != null) && (this.msA.mrG))
      {
        this.msA.w(paramBoolean2, paramInt);
        this.msA = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bxe().bvT().mqj = paramInt;
          vS(paramInt);
        }
        if (paramBoolean2) {
          bwI();
        }
        com.tencent.mm.plugin.backup.g.b.bxx();
        com.tencent.mm.plugin.backup.g.b.bxz();
        com.tencent.mm.plugin.backup.g.b.bxC();
        b.bxe().bvV();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void bvS()
  {
    AppMethodBeat.i(21594);
    bwI();
    h.vKh.idkeyStat(400L, 27L, 1L, false);
    h.vKh.idkeyStat(400L, 28L, bt.vM(this.msL) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.wg(12);
    com.tencent.mm.plugin.backup.g.b.bxx();
    com.tencent.mm.plugin.backup.g.b.bxz();
    AppMethodBeat.o(21594);
  }
  
  public final void bwI()
  {
    AppMethodBeat.i(21587);
    ad.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.msJ.clear();
    if (!g.mqC) {
      g.Og(g.bwg());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void bxo()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.msA != null) && (this.msA.mrG))
      {
        ad.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.msA != null) {
        this.msA.w(false, 0);
      }
      if ((this.msJ == null) || (this.msJ.size() <= 0))
      {
        i = az.arV().aqr().eJD();
        b.bxe().bvT().O(26, 1, i);
        vS(26);
        if (this.msE == null) {
          this.msE = new LinkedList();
        }
        if (this.msF == null) {
          this.msF = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.bxT().bxW();
        this.msL = bt.eGO();
        com.tencent.mm.plugin.backup.h.d.bxT().bxW();
        this.msA = new com.tencent.mm.plugin.backup.c.d(b.bxe(), 1, this, i, this.mrR, this.msE, this.msF);
        this.msA.hR(false);
        h.vKh.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.msJ.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    ad.i("MicroMsg.BackupPcRecoverServer", "init");
    this.mvJ = false;
    mvF = false;
    msM = false;
    com.tencent.mm.plugin.backup.g.b.a(this.mvK);
    this.mqq = 0L;
    this.recvSize = 0L;
    this.gqP = false;
    this.mrR = false;
    this.msJ.clear();
    AppMethodBeat.o(21585);
  }
  
  public final void vS(final int paramInt)
  {
    AppMethodBeat.i(21593);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.mvG);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21582);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).vS(paramInt);
        }
        AppMethodBeat.o(21582);
      }
    });
    if (this.mvH != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21583);
          if (d.d(d.this) != null) {
            d.d(d.this).vR(paramInt);
          }
          AppMethodBeat.o(21583);
        }
      });
    }
    AppMethodBeat.o(21593);
  }
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.msK != 0L) {
      l = bt.vM(this.msK);
    }
    h.vKh.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.mqq / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.bxe().bxf().mvA) });
    ad.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.mqq / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */