package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.l;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d
  implements com.tencent.mm.plugin.backup.b.b.d
{
  private static boolean hHQ = false;
  private static boolean hKI = false;
  private boolean edT = false;
  private long hFz = 0L;
  private boolean hGZ = false;
  private com.tencent.mm.plugin.backup.c.d hHH;
  LinkedList<String> hHI;
  LinkedList<Long> hHJ;
  private HashSet<String> hHN = new HashSet();
  private long hHO = 0L;
  private long hHP = 0L;
  public Set<b.c> hKJ = new HashSet();
  public b.a hKK;
  private long hKL = 0L;
  private boolean hKM = false;
  private final com.tencent.mm.plugin.backup.g.b.d hKN = new d.1(this);
  private Object lock = new Object();
  private long recvSize = 0L;
  
  public static boolean atX()
  {
    return au.Hx().Ge().ctw();
  }
  
  public static void auF()
  {
    hKI = true;
  }
  
  private static void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    com.tencent.mm.plugin.backup.i.y localy = new com.tencent.mm.plugin.backup.i.y();
    localy.hQV = paramString;
    localy.hQW = paramInt1;
    localy.hQY = paramInt2;
    localy.hQZ = paramInt3;
    localy.hQq = paramInt4;
    try
    {
      com.tencent.mm.plugin.backup.g.b.o(localy.toByteArray(), 7, paramInt5);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramString, "sendResp", new Object[0]);
    }
  }
  
  private static void d(int paramInt1, int paramInt2, long paramLong)
  {
    o localo = new o();
    localo.ID = b.auw().hFm;
    localo.hQq = paramInt1;
    localo.hQl = g.cG(paramLong);
    try
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.backup.g.b.o(localo.toByteArray(), 4, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BackupPcRecoverServer", localException, "buf to BackupStartRequest err.", new Object[0]);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 0;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), ak.cri() });
    hKI = true;
    if (!paramBoolean1)
    {
      b.auw().aux();
      c.auc();
    }
    synchronized (this.lock)
    {
      this.edT = true;
      if ((this.hHH != null) && (this.hHH.hGO))
      {
        this.hHH.h(paramBoolean2, paramInt);
        this.hHH = null;
        if ((i != 0) && (paramInt != 0))
        {
          b.auw().atn().hFu = paramInt;
          nt(paramInt);
        }
        if (paramBoolean2) {
          atY();
        }
        com.tencent.mm.plugin.backup.g.b.auM();
        com.tencent.mm.plugin.backup.g.b.auO();
        com.tencent.mm.plugin.backup.g.b.auR();
        return;
      }
      i = 1;
    }
  }
  
  public final void atF()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if ((this.hHH != null) && (this.hHH.hGO))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
          return;
        }
        if (this.hHH != null) {
          this.hHH.h(false, 0);
        }
        if ((this.hHN == null) || (this.hHN.size() <= 0))
        {
          i = au.Hx().Ge().ctx();
          b.auw().atn().B(26, 1, i);
          nt(26);
          if (this.hHI == null) {
            this.hHI = new LinkedList();
          }
          if (this.hHJ == null) {
            this.hHJ = new LinkedList();
          }
          this.hHP = bk.UY();
          this.hHH = new com.tencent.mm.plugin.backup.c.d(b.auw(), 1, this, i, this.hGZ, this.hHI, this.hHJ);
          this.hHH.atF();
          h.nFQ.a(400L, 24L, 1L, false);
          return;
        }
      }
      int i = this.hHN.size();
    }
  }
  
  public final void atY()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
    this.hHN.clear();
  }
  
  public final void atm()
  {
    atY();
    h.nFQ.a(400L, 27L, 1L, false);
    h.nFQ.a(400L, 28L, bk.co(this.hHP) / 1000L, false);
    com.tencent.mm.plugin.backup.g.b.nG(12);
    com.tencent.mm.plugin.backup.g.b.auM();
    com.tencent.mm.plugin.backup.g.b.auO();
  }
  
  public final void init()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupPcRecoverServer", "init");
    this.hKM = false;
    hKI = false;
    hHQ = false;
    com.tencent.mm.plugin.backup.g.b.a(this.hKN);
    this.hFz = 0L;
    this.recvSize = 0L;
    this.edT = false;
    this.hGZ = false;
    this.hHN.clear();
  }
  
  public final void nC(int paramInt)
  {
    long l = 0L;
    if (this.hHO != 0L) {
      l = bk.co(this.hHO);
    }
    h.nFQ.f(13737, new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.hFz / 1024L), Long.valueOf(l / 1000L), Integer.valueOf(2), Integer.valueOf(b.auw().aux().hKD) });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[] { Integer.valueOf(13737), Integer.valueOf(paramInt), Long.valueOf(this.hFz / 1024L), Long.valueOf(l / 1000L) });
  }
  
  public final void nt(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.hKJ);
    ai.d(new d.3(this, localHashSet, paramInt));
    if (this.hKK != null) {
      ai.d(new d.4(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d
 * JD-Core Version:    0.7.0.1
 */