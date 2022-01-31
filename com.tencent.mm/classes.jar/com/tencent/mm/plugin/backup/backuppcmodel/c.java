package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private static int ebp = 2;
  private static boolean hIf = false;
  private am hIe;
  final f hIg = new c.1(this);
  private final f hIh = new c.3(this);
  b.c hIl = new c.8(this);
  private final j.a hIm = new c.6(this);
  int hKA;
  boolean hKB;
  private com.tencent.mm.bv.b hKC;
  public int hKD;
  public boolean hKE = true;
  private final b.d hKF = new c.4(this);
  public final h.a hKG = new h.a()
  {
    public final void auD()
    {
      y.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
      int i;
      if (b.auw().atn().hFu != 5)
      {
        b.auw().atn().hFu = 5;
        i = b.auw().aux().hKx;
        if ((1 != i) && (3 != i)) {
          break label70;
        }
        b.auw().auy().nD(5);
      }
      for (;;)
      {
        c.this.nB(9);
        return;
        label70:
        if ((2 == i) || (4 == i)) {
          b.auw().auz().nt(5);
        }
      }
    }
    
    public final void auE()
    {
      int i = c.this.hKx;
      y.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[] { Integer.valueOf(i) });
      if ((1 == i) || (3 == i))
      {
        b.auw().auy();
        e.auG();
        b.auw().auy().cancel(true);
        b.auw().atT().stop();
        b.auw().atn().hFu = -4;
        b.auw().auy().nD(-4);
        h.nFQ.a(400L, 9L, 1L, false);
        b.auw().auy().nC(3);
      }
      while ((2 != i) && (4 != i)) {
        return;
      }
      b.auw().auz();
      d.auF();
      b.auw().auz().a(true, false, -4);
      b.auw().atT().stop();
      h.nFQ.a(400L, 17L, 1L, false);
      b.auw().auz().nC(3);
    }
  };
  public int hKx = 0;
  public String hKy;
  String hKz;
  
  private void auB()
  {
    b.auw().atT().connect(this.hKz, this.hKA);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.hIh);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.auw().hFn, b.auw().hFo, com.tencent.mm.plugin.backup.b.d.atr(), b.auw().hFm, 0, 1);
    locala.t(true, true);
    locala.hLu.hQT = 1;
    locala.auT();
    y.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.hIe == null) {
      this.hIe = new am(new c.2(this), false);
    }
    this.hIe.S(3000L, 3000L);
  }
  
  public static String auC()
  {
    return com.tencent.mm.plugin.backup.g.b.auP();
  }
  
  public static void auc()
  {
    y.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.auw().hFm;
    try
    {
      com.tencent.mm.plugin.backup.g.b.I(locala.toByteArray(), 5);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
    }
  }
  
  public static void cp(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.hPE = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.o(localc.toByteArray(), 18, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bv.b paramb)
  {
    this.hKB = paramBoolean;
    this.hKC = paramb;
  }
  
  public final void nB(int paramInt)
  {
    y.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.hPE = paramInt;
    if (paramInt == 9) {
      localb.hPF = this.hKC;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.I(localb.toByteArray(), 17);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */