package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.h.a;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class c
{
  private static int ePG = 2;
  private static boolean jBD = false;
  private ap jBC;
  final f jBE;
  private final f jBF;
  b.c jBJ;
  private final j.a jBK;
  public int jEa;
  public String jEb;
  String jEc;
  int jEd;
  boolean jEe;
  private com.tencent.mm.bv.b jEf;
  public int jEg;
  public boolean jEh;
  private final b.d jEi;
  public final h.a jEj;
  
  public c()
  {
    AppMethodBeat.i(17510);
    this.jEa = 0;
    this.jEh = true;
    this.jBE = new c.1(this);
    this.jBF = new c.3(this);
    this.jEi = new c.4(this);
    this.jBK = new c.6(this);
    this.jEj = new c.7(this);
    this.jBJ = new c.8(this);
    AppMethodBeat.o(17510);
  }
  
  public static void aTB()
  {
    AppMethodBeat.i(17515);
    ab.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
    com.tencent.mm.plugin.backup.i.a locala = new com.tencent.mm.plugin.backup.i.a();
    locala.ID = b.aTX().jyF;
    try
    {
      com.tencent.mm.plugin.backup.g.b.J(locala.toByteArray(), 5);
      AppMethodBeat.o(17515);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCancelRequest to buf err.", new Object[0]);
      AppMethodBeat.o(17515);
    }
  }
  
  private void aUc()
  {
    AppMethodBeat.i(17511);
    b.aTX().aTs().connect(this.jEc, this.jEd);
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.plugin.backup.g.b.a(1, this.jBF);
    com.tencent.mm.plugin.backup.g.a locala = new com.tencent.mm.plugin.backup.g.a(b.aTX().jyG, b.aTX().jyH, d.aSP(), b.aTX().jyF, 0, 1);
    locala.t(true, true);
    locala.jEX.jKu = 1;
    locala.aUv();
    ab.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
    if (this.jBC == null) {
      this.jBC = new ap(new c.2(this), false);
    }
    this.jBC.ag(3000L, 3000L);
    AppMethodBeat.o(17511);
  }
  
  public static String aUd()
  {
    AppMethodBeat.i(17512);
    String str = com.tencent.mm.plugin.backup.g.b.aUr();
    AppMethodBeat.o(17512);
    return str;
  }
  
  public static void dF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17514);
    ab.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[] { Integer.valueOf(paramInt1) });
    com.tencent.mm.plugin.backup.i.c localc = new com.tencent.mm.plugin.backup.i.c();
    localc.jJg = paramInt1;
    try
    {
      com.tencent.mm.plugin.backup.g.b.r(localc.toByteArray(), 18, paramInt2);
      AppMethodBeat.o(17514);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandResponse to buf err.", new Object[0]);
      AppMethodBeat.o(17514);
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.bv.b paramb)
  {
    this.jEe = paramBoolean;
    this.jEf = paramb;
  }
  
  public final void rq(int paramInt)
  {
    AppMethodBeat.i(17513);
    ab.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.backup.i.b localb = new com.tencent.mm.plugin.backup.i.b();
    localb.jJg = paramInt;
    if (paramInt == 9) {
      localb.jJh = this.jEf;
    }
    try
    {
      com.tencent.mm.plugin.backup.g.b.J(localb.toByteArray(), 17);
      AppMethodBeat.o(17513);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", localException, "BackupCommandRequest to buf err.", new Object[0]);
      AppMethodBeat.o(17513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c
 * JD-Core Version:    0.7.0.1
 */