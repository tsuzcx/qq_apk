package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  private Object lock;
  public long nuL;
  private LinkedList<f.b> nuM;
  private LinkedList<f.b> nuN;
  private LinkedList<f.b> nuO;
  public boolean nuP;
  com.tencent.mm.plugin.backup.c.b nvJ;
  public boolean nxJ;
  public b.a nxK;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.nxJ = false;
    this.lock = new Object();
    this.nuM = null;
    this.nuN = null;
    this.nuO = null;
    this.nuP = false;
    AppMethodBeat.o(21537);
  }
  
  private static long F(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21538);
    long l1 = 0L;
    long l2 = l1;
    if (paramLinkedList != null)
    {
      l2 = l1;
      if (paramLinkedList.size() > 0)
      {
        l1 = ((f.b)paramLinkedList.get(0)).nsY;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.nsY) {
            break label89;
          }
          l1 = localb.nsY;
        }
      }
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(21538);
      return l2;
    }
  }
  
  private LinkedList<f.b> bHD()
  {
    AppMethodBeat.i(21543);
    if (this.nuO == null) {
      this.nuO = new LinkedList();
    }
    LinkedList localLinkedList = this.nuO;
    AppMethodBeat.o(21543);
    return localLinkedList;
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21545);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ad.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.nuP = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.nxK != null) {
        this.nxK.C(paramLinkedList);
      }
      if (this.nxJ)
      {
        paramLinkedList = b.bIj().bIl();
        e.nym = true;
        paramLinkedList.nvK.bHq();
        b.bIj().bHH().stop();
        b.bIj().bGX().nsJ = -23;
        b.bIj().bIl().tF(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.nuM = new LinkedList(paramLinkedList);
    this.nuL = F(this.nuM);
    b.bIj();
    SharedPreferences localSharedPreferences = b.bHc();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), bHB());
    ad.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(bHC().size()) });
    if (this.nxJ)
    {
      G(bHC());
      b.bIj().bIl().H(g.B(bHD()));
      b.bIj().bIl().tb(bHD().size());
    }
    if (this.nxK != null) {
      this.nxK.C(bHC());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.nuO = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.nuO = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.nuO.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.nuN = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.nuN == null) {
      this.nuN = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.bIY().bIZ().azs().G(localb.nsX, paramLong1, paramLong2) > 0) {
          this.nuN.add(localb);
        }
      }
      this.nuN.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final LinkedList<f.b> bHB()
  {
    AppMethodBeat.i(21539);
    if (this.nuM == null) {
      this.nuM = new LinkedList();
    }
    LinkedList localLinkedList = this.nuM;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bHC()
  {
    AppMethodBeat.i(21540);
    if (this.nuN == null) {
      this.nuN = new LinkedList();
    }
    LinkedList localLinkedList = this.nuN;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final void bIi()
  {
    this.nuM = null;
    this.nuO = null;
    this.nuN = null;
    this.nuP = false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    ad.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { bt.flS() });
    synchronized (this.lock)
    {
      if (this.nvJ != null)
      {
        this.nvJ.cancel();
        this.nvJ = null;
      }
      this.nuP = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    ad.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nxJ = paramBoolean;
    d.bIY().bJb();
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21536);
        if (a.this.nvJ != null) {
          a.this.nvJ.cancel();
        }
        a.this.nvJ = new com.tencent.mm.plugin.backup.c.b();
        a.this.nvJ.a(a.this);
        AppMethodBeat.o(21536);
      }
    }, "BackupPcChooseServer.calculateToChoose");
    AppMethodBeat.o(21544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a
 * JD-Core Version:    0.7.0.1
 */