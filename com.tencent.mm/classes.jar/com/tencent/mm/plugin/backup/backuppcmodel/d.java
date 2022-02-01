package com.tencent.mm.plugin.backup.backuppcmodel;

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
import com.tencent.threadpool.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean uYH = false;
  private static boolean vbI = false;
  private Object lock;
  private boolean nzW;
  private long recvSize;
  private long uWn;
  private boolean uXO;
  LinkedList<String> uYA;
  LinkedList<Long> uYB;
  private HashSet<String> uYE;
  private long uYF;
  private long uYG;
  private com.tencent.mm.plugin.backup.c.d uYw;
  public Set<b.c> vbJ;
  public b.a vbK;
  private long vbL;
  private boolean vbM;
  private final com.tencent.mm.plugin.backup.g.b.d vbN;
  
  public d()
  {
    AppMethodBeat.i(21584);
    this.uWn = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.nzW = false;
    this.vbJ = new HashSet();
    this.uYE = new HashSet();
    this.uYF = 0L;
    this.uYG = 0L;
    this.vbL = 0L;
    this.uXO = false;
    this.vbM = false;
    this.vbN = new com.tencent.mm.plugin.backup.g.b.d()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt1, final byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(300734);
        if (paramAnonymousArrayOfByte == null) {}
        for (int i = 0;; i = paramAnonymousArrayOfByte.length)
        {
          Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
          if ((!paramAnonymousBoolean) || (10011 != paramAnonymousInt1)) {
            break;
          }
          d.a(d.this);
          AppMethodBeat.o(300734);
          return;
        }
        if (paramAnonymousInt1 == 5)
        {
          Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
          d.this.a(true, false, -100);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 52L, 1L, false);
          d.this.Fm(5);
          AppMethodBeat.o(300734);
          return;
        }
        i = b.cVW().cVX().vbw;
        if ((2 != i) && (4 != i))
        {
          Log.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.cVW().cVX().vbw) });
          AppMethodBeat.o(300734);
          return;
        }
        long l;
        if (paramAnonymousInt1 == 10)
        {
          paramAnonymousArrayOfByte = (f)g.a(new f(), paramAnonymousArrayOfByte);
          if (paramAnonymousArrayOfByte != null) {}
          for (l = paramAnonymousArrayOfByte.vda;; l = -1L)
          {
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
            AppMethodBeat.o(300734);
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
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).vgz) });
            if (((com.tencent.mm.plugin.backup.i.c)localObject).vgz == 9)
            {
              paramAnonymousInt1 = com.tencent.mm.plugin.backup.g.b.cWv();
              if (paramAnonymousInt1 == 1)
              {
                com.tencent.mm.plugin.backup.g.b.Fq(2);
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                d.this.Fm(20);
                com.tencent.mm.plugin.backup.g.b.cWu();
                b.cVW().cUJ().uWg = 23;
                d.this.Fc(23);
                com.tencent.mm.plugin.backup.g.b.Fq(0);
                AppMethodBeat.o(300734);
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
            AppMethodBeat.o(300734);
            return;
          }
        }
        if (paramAnonymousInt1 == 17)
        {
          localObject = new com.tencent.mm.plugin.backup.i.b();
          try
          {
            ((com.tencent.mm.plugin.backup.i.b)localObject).parseFrom(paramAnonymousArrayOfByte);
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).vgz) });
            if (((com.tencent.mm.plugin.backup.i.b)localObject).vgz == 10)
            {
              paramAnonymousInt1 = b.cVW().cUJ().uWg;
              Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              if ((paramAnonymousInt1 == 22) || (paramAnonymousInt1 == 23))
              {
                d.this.a(true, false, -4);
                b.cVW().cVt().stop();
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 52L, 1L, false);
                d.this.Fm(5);
                l = 0L;
                if (d.b(d.this) != 0L) {
                  l = Util.milliSecondsToNow(d.b(d.this));
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(d.this)), Long.valueOf(l), Integer.valueOf(2) });
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(d.this)), Long.valueOf(l) });
              }
            }
            AppMethodBeat.o(300734);
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
        bh.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(300735);
            if (paramAnonymousInt1 == 3)
            {
              d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(300735);
              return;
            }
            if (paramAnonymousInt1 == 11)
            {
              d.b(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(300735);
              return;
            }
            if (paramAnonymousInt1 == 6)
            {
              d.c(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(300735);
              return;
            }
            if (paramAnonymousInt1 == 13)
            {
              d.L(paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(300735);
              return;
            }
            if (paramAnonymousInt1 == 15)
            {
              d.d(d.this, paramAnonymousArrayOfByte, paramAnonymousInt2);
              AppMethodBeat.o(300735);
              return;
            }
            if (paramAnonymousInt1 == 8)
            {
              d.a(d.this, paramAnonymousArrayOfByte);
              AppMethodBeat.o(300735);
              return;
            }
            AppMethodBeat.o(300735);
          }
        });
        AppMethodBeat.o(300734);
      }
    };
    AppMethodBeat.o(21584);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(21590);
    y localy = new y();
    localy.vhN = paramString;
    localy.vhO = paramInt1;
    localy.vhQ = paramInt2;
    localy.vhR = paramInt3;
    localy.vhk = paramInt4;
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
  
  public static boolean cVx()
  {
    AppMethodBeat.i(21586);
    boolean bool = bh.bCz().bAg().iXd();
    AppMethodBeat.o(21586);
    return bool;
  }
  
  public static void cWf()
  {
    vbI = true;
  }
  
  private static void i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(21591);
    o localo = new o();
    localo.vgy = b.cVW().uVY;
    localo.vhk = paramInt1;
    localo.vhf = g.jY(paramLong);
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
  
  public final void Fc(final int paramInt)
  {
    AppMethodBeat.i(21593);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21583);
        Iterator localIterator = this.uZh.iterator();
        while (localIterator.hasNext()) {
          ((b.c)localIterator.next()).Fc(paramInt);
        }
        AppMethodBeat.o(21583);
      }
    });
    if (this.vbK != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300732);
          if (d.d(d.this) != null) {
            d.d(d.this).Fb(paramInt);
          }
          AppMethodBeat.o(300732);
        }
      });
    }
    AppMethodBeat.o(21593);
  }
  
  public final void Fm(int paramInt)
  {
    AppMethodBeat.i(21589);
    long l = 0L;
    if (this.uYF != 0L) {
      l = Util.milliSecondsToNow(this.uYF);
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.uWn / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.cVW().cVX().vbC) });
    Log.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.uWn / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(21589);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21588);
    Log.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), MMStack.getCaller() });
    vbI = true;
    if (!paramBoolean1)
    {
      b.cVW().cVX();
      c.cVC();
    }
    synchronized (this.lock)
    {
      this.nzW = true;
      if ((this.uYw != null) && (this.uYw.uXC))
      {
        this.uYw.A(paramBoolean2, paramInt);
        this.uYw = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.cVW().cUJ().uWg = paramInt;
          Fc(paramInt);
        }
        if (paramBoolean2) {
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(300733);
              d.this.cVy();
              AppMethodBeat.o(300733);
            }
          });
        }
        com.tencent.mm.plugin.backup.g.b.cWp();
        com.tencent.mm.plugin.backup.g.b.cWr();
        com.tencent.mm.plugin.backup.g.b.cWu();
        b.cVW().cUL();
        AppMethodBeat.o(21588);
        return;
      }
      i = 1;
    }
  }
  
  public final void cUI()
  {
    AppMethodBeat.i(21594);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(300731);
        d.this.cVy();
        AppMethodBeat.o(300731);
      }
    });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 27L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 28L, Util.milliSecondsToNow(this.uYG) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.Fp(12);
    com.tencent.mm.plugin.backup.g.b.cWp();
    com.tencent.mm.plugin.backup.g.b.cWr();
    AppMethodBeat.o(21594);
  }
  
  public final void cVy()
  {
    AppMethodBeat.i(21587);
    Log.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.uYE.clear();
    if (!g.uWz) {
      g.ahx(g.cUW());
    }
    AppMethodBeat.o(21587);
  }
  
  public final void cWg()
  {
    AppMethodBeat.i(21592);
    synchronized (this.lock)
    {
      if ((this.uYw != null) && (this.uYw.uXC))
      {
        Log.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(21592);
        return;
      }
      if (this.uYw != null) {
        this.uYw.A(false, 0);
      }
      if ((this.uYE == null) || (this.uYE.size() <= 0))
      {
        i = bh.bCz().bAg().iXe();
        b.cVW().cUJ().ak(26, 1, i);
        Fc(26);
        if (this.uYA == null) {
          this.uYA = new LinkedList();
        }
        if (this.uYB == null) {
          this.uYB = new LinkedList();
        }
        com.tencent.mm.plugin.backup.h.d.cWK().cWN();
        this.uYG = Util.nowMilliSecond();
        com.tencent.mm.plugin.backup.h.d.cWK().cWN();
        this.uYw = new com.tencent.mm.plugin.backup.c.d(b.cVW(), 1, this, i, this.uXO, this.uYA, this.uYB);
        this.uYw.lX(false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(21592);
        return;
      }
      int i = this.uYE.size();
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(21585);
    Log.i("MicroMsg.BackupPcRecoverServer", "init");
    this.vbM = false;
    vbI = false;
    uYH = false;
    com.tencent.mm.plugin.backup.g.b.a(this.vbN);
    this.uWn = 0L;
    this.recvSize = 0L;
    this.nzW = false;
    this.uXO = false;
    this.uYE.clear();
    AppMethodBeat.o(21585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */