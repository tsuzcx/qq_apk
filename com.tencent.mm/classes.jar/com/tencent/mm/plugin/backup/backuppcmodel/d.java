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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean mUO = false;
  private static boolean mXG = false;
  private boolean gRx;
  private Object lock;
  private long mSs;
  private boolean mTT;
  private com.tencent.mm.plugin.backup.c.d mUC;
  LinkedList<String> mUG;
  LinkedList<Long> mUH;
  private HashSet<String> mUL;
  private long mUM;
  private long mUN;
  public Set<b.c> mXH;
  public b.a mXI;
  private long mXJ;
  private boolean mXK;
  private final com.tencent.mm.plugin.backup.g.b.d mXL;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.mSs = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.gRx = false;
    this.mXH = new HashSet();
    this.mUL = new HashSet();
    this.mUM = 0L;
    this.mUN = 0L;
    this.mXJ = 0L;
    this.mTT = false;
    this.mXK = false;
    this.mXL = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt1, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(21580);
        if (paramAnonymousArrayOfByte == null) {}
        for (int i = 0;; i = paramAnonymousArrayOfByte.length)
        {
          ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (10011 != paramAnonymousInt1)) {
            break;
          }
          d.a(d.this);
          AppMethodBeat.o(21580);
          return;
        }
        if (paramAnonymousInt1 == 5)
        {
          ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
          d.this.b(true, false, -100);
          h.wUl.idkeyStat(400L, 52L, 1L, false);
          d.this.wU(5);
          AppMethodBeat.o(21580);
          return;
        }
        i = b.bEa().bEb().mXv;
        if ((2 != i) && (4 != i))
        {
          ac.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.bEa().bEb().mXv) });
          AppMethodBeat.o(21580);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.mYY;; l = -1L)
          {
            ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
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
            ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).ncx) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).ncx == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.bEz();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.wY(2);
                ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.wU(20);
                com.tencent.mm.plugin.backup.g.b.bEy();
                b.bEa().bCP().mSk = 23;
                d.this.wJ(23);
                com.tencent.mm.plugin.backup.g.b.wY(0);
                AppMethodBeat.o(21580);
                return;
              }
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
            }
            ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
            ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).ncx) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).ncx == 10)
            {
              paramAnonymousInt1 = b.bEa().bCP().mSk;
              ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.b(true, false, -4);
                b.bEa().bDz().stop();
                h.wUl.idkeyStat(400L, 52L, 1L, false);
                d.this.wU(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = bs.Ap(d.b(d.this));
                }
                h.wUl.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
                ac.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(d.this)), Long.valueOf(l) });
              }
            }
            AppMethodBeat.o(21580);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramAnonymousArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
            }
          }
        }
        az.agU().az(new Runnable()
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
    localy.ndM = paramString;
    localy.ndN = paramInt1;
    localy.ndP = paramInt2;
    localy.ndQ = paramInt3;
    localy.ndj = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.t(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(21590);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(21590);
    }
  }
  
  public static boolean bDD()
  {
    AppMethodBeat.i(21586);
    boolean bool = az.ayM().axg().eYZ();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void bEj()
  {
    mXG = true;
  }
  
  private static void f(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.ID = b.bEa().mSc;
    localo.ndj = paramInt1;
    localo.nde = g.rb(paramLong);
    try
    {
      ac.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.t(localo.toByteArray(), 4, paramInt2);
      AppMethodBeat.o(21591);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
      AppMethodBeat.o(21591);
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21588);
    ac.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), as.eVo() });
    mXG = true;
    if (!paramBoolean1)
    {
      b.bEa().bEb();
      c.bDI();
    }
    synchronized (this.lock)
    {
      this.gRx = true;
      if ((this.mUC != null) && (this.mUC.mTI))
      {
        this.mUC.x(paramBoolean2, paramInt);
        this.mUC = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.bEa().bCP().mSk = paramInt;
          wJ(paramInt);
        }
        if (paramBoolean2) {
          bDE();
        }
        com.tencent.mm.plugin.backup.g.b.bEt();
        com.tencent.mm.plugin.backup.g.b.bEv();
        com.tencent.mm.plugin.backup.g.b.bEy();
        b.bEa().bCR();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void bCO()
  {
    AppMethodBeat.i(21594);
    bDE();
    h.wUl.idkeyStat(400L, 27L, 1L, false);
    h.wUl.idkeyStat(400L, 28L, bs.Ap(this.mUN) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.wX(12);
    com.tencent.mm.plugin.backup.g.b.bEt();
    com.tencent.mm.plugin.backup.g.b.bEv();
    AppMethodBeat.o(21594);
  }
  
  public final void bDE()
  {
    AppMethodBeat.i(21587);
    ac.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.mUL.clear();
    if (!g.mSE) {
      g.Sq(g.bDc());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void bEk()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.mUC != null) && (this.mUC.mTI))
      {
        ac.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.mUC != null) {
        this.mUC.x(false, 0);
      }
      if ((this.mUL == null) || (this.mUL.size() <= 0))
      {
        i = az.ayM().axg().eZa();
        b.bEa().bCP().P(26, 1, i);
        wJ(26);
        if (this.mUG == null) {
          this.mUG = new LinkedList();
        }
        if (this.mUH == null) {
          this.mUH = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.bEP().bES();
        this.mUN = bs.eWj();
        com.tencent.mm.plugin.backup.h.d.bEP().bES();
        this.mUC = new com.tencent.mm.plugin.backup.c.d(b.bEa(), 1, this, i, this.mTT, this.mUG, this.mUH);
        this.mUC.ir(false);
        h.wUl.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.mUL.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    ac.i("MicroMsg.BackupPcRecoverServer", "init");
    this.mXK = false;
    mXG = false;
    mUO = false;
    com.tencent.mm.plugin.backup.g.b.a(this.mXL);
    this.mSs = 0L;
    this.recvSize = 0L;
    this.gRx = false;
    this.mTT = false;
    this.mUL.clear();
    AppMethodBeat.o(21585);
  }
  
  public final void wJ(final int paramInt)
  {
    AppMethodBeat.i(21593);
    final HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.mXH);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21582);
        Iterator localIterator = localHashSet.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).wJ(paramInt);
        }
        AppMethodBeat.o(21582);
      }
    });
    if (this.mXI != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21583);
          if (d.d(d.this) != null) {
            d.d(d.this).wI(paramInt);
          }
          AppMethodBeat.o(21583);
        }
      });
    }
    AppMethodBeat.o(21593);
  }
  
  public final void wU(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.mUM != 0L) {
      l = bs.Ap(this.mUM);
    }
    h.wUl.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.mSs / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.bEa().bEb().mXB) });
    ac.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.mSs / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */