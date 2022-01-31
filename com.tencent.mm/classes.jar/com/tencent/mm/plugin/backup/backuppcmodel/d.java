package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.l;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean jBo = false;
  private static boolean jEl = false;
  private boolean eUJ;
  private boolean jAv;
  private com.tencent.mm.plugin.backup.c.d jBd;
  LinkedList<String> jBg;
  LinkedList<Long> jBh;
  private HashSet<String> jBl;
  private long jBm;
  private long jBn;
  public Set<b.c> jEm;
  public b.a jEn;
  private long jEo;
  private boolean jEp;
  private final com.tencent.mm.plugin.backup.g.b.d jEq;
  private long jyU;
  private Object lock;
  private long recvSize;
  
  public d()
  {
    AppMethodBeat.i(17525);
    this.jyU = 0L;
    this.recvSize = 0L;
    this.lock = new Object();
    this.eUJ = false;
    this.jEm = new HashSet();
    this.jBl = new HashSet();
    this.jBm = 0L;
    this.jBn = 0L;
    this.jEo = 0L;
    this.jAv = false;
    this.jEp = false;
    this.jEq = new d.1(this);
    AppMethodBeat.o(17525);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(17531);
    y localy = new y();
    localy.jKw = paramString;
    localy.jKx = paramInt1;
    localy.jKz = paramInt2;
    localy.jKA = paramInt3;
    localy.jJS = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.r(localy.toByteArray(), 7, paramInt5);
      AppMethodBeat.o(17531);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
      AppMethodBeat.o(17531);
    }
  }
  
  public static boolean aTw()
  {
    AppMethodBeat.i(17527);
    boolean bool = aw.aaz().Zf().dvS();
    AppMethodBeat.o(17527);
    return bool;
  }
  
  public static void aUg()
  {
    jEl = true;
  }
  
  private static void e(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(17532);
    o localo = new o();
    localo.ID = b.aTX().jyF;
    localo.jJS = paramInt1;
    localo.jJN = g.hI(paramLong);
    try
    {
      ab.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.r(localo.toByteArray(), 4, paramInt2);
      AppMethodBeat.o(17532);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
      AppMethodBeat.o(17532);
    }
  }
  
  public final void aSK()
  {
    AppMethodBeat.i(17535);
    aTx();
    h.qsU.idkeyStat(400L, 27L, 1L, false);
    h.qsU.idkeyStat(400L, 28L, bo.hl(this.jBn) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.ru(12);
    com.tencent.mm.plugin.backup.g.b.aUo();
    com.tencent.mm.plugin.backup.g.b.aUq();
    AppMethodBeat.o(17535);
  }
  
  public final void aTd()
  {
    AppMethodBeat.i(17533);
    synchronized (this.lock)
    {
      if ((this.jBd != null) && (this.jBd.jAk))
      {
        ab.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
        AppMethodBeat.o(17533);
        return;
      }
      if (this.jBd != null) {
        this.jBd.n(false, 0);
      }
      if ((this.jBl == null) || (this.jBl.size() <= 0))
      {
        i = aw.aaz().Zf().dvT();
        b.aTX().aSL().N(26, 1, i);
        rf(26);
        if (this.jBg == null) {
          this.jBg = new LinkedList();
        }
        if (this.jBh == null) {
          this.jBh = new LinkedList();
        }
        this.jBn = bo.aoy();
        this.jBd = new com.tencent.mm.plugin.backup.c.d(b.aTX(), 1, this, i, this.jAv, this.jBg, this.jBh);
        this.jBd.aTd();
        h.qsU.idkeyStat(400L, 24L, 1L, false);
        AppMethodBeat.o(17533);
        return;
      }
      int i = this.jBl.size();
    }
  }
  
  public final void aTx()
  {
    AppMethodBeat.i(17528);
    ab.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.jBl.clear();
    com.tencent.mm.vfs.e.O(g.aSW(), true);
    AppMethodBeat.o(17528);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(17529);
    ab.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), an.dtg() });
    jEl = true;
    if (!paramBoolean1)
    {
      b.aTX().aTY();
      c.aTB();
    }
    synchronized (this.lock)
    {
      this.eUJ = true;
      if ((this.jBd != null) && (this.jBd.jAk))
      {
        this.jBd.n(paramBoolean2, paramInt);
        this.jBd = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.aTX().aSL().jyN = paramInt;
          rf(paramInt);
        }
        if (paramBoolean2) {
          aTx();
        }
        com.tencent.mm.plugin.backup.g.b.aUo();
        com.tencent.mm.plugin.backup.g.b.aUq();
        com.tencent.mm.plugin.backup.g.b.aUt();
        b.aTX().aSN();
        AppMethodBeat.o(17529);
        return;
      }
      i = 1;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(17526);
    ab.i("MicroMsg.BackupPcRecoverServer", "init");
    this.jEp = false;
    jEl = false;
    jBo = false;
    com.tencent.mm.plugin.backup.g.b.a(this.jEq);
    this.jyU = 0L;
    this.recvSize = 0L;
    this.eUJ = false;
    this.jAv = false;
    this.jBl.clear();
    AppMethodBeat.o(17526);
  }
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(17534);
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jEm);
    al.d(new d.3(this, localHashSet, paramInt));
    if (this.jEn != null) {
      al.d(new d.4(this, paramInt));
    }
    AppMethodBeat.o(17534);
  }
  
  public final void rr(int paramInt)
  {
    AppMethodBeat.i(17530);
    long l = 0L;
    if (this.jBm != 0L) {
      l = bo.hl(this.jBm);
    }
    h.qsU.e(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.jyU / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.aTX().aTY().jEg) });
    ab.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.jyU / 1024L), Long.valueOf(l / 1000L) });
    AppMethodBeat.o(17530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */