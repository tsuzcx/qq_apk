package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  private Object lock;
  public long msm;
  private LinkedList<f.b> msn;
  private LinkedList<f.b> mso;
  private LinkedList<f.b> msp;
  public boolean msq;
  com.tencent.mm.plugin.backup.c.b mtk;
  public boolean mvl;
  public b.a mvm;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.mvl = false;
    this.lock = new Object();
    this.msn = null;
    this.mso = null;
    this.msp = null;
    this.msq = false;
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
        l1 = ((f.b)paramLinkedList.get(0)).mqy;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.mqy) {
            break label89;
          }
          l1 = localb.mqy;
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
  
  private LinkedList<f.b> bwz()
  {
    AppMethodBeat.i(21543);
    if (this.msp == null) {
      this.msp = new LinkedList();
    }
    LinkedList localLinkedList = this.msp;
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
      this.msq = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.mvm != null) {
        this.mvm.C(paramLinkedList);
      }
      if (this.mvl)
      {
        paramLinkedList = b.bxe().bxg();
        e.mvO = true;
        paramLinkedList.mtl.bwm();
        b.bxe().bwD().stop();
        b.bxe().bvT().mqj = -23;
        b.bxe().bxg().sm(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.msn = new LinkedList(paramLinkedList);
    this.msm = F(this.msn);
    b.bxe();
    SharedPreferences localSharedPreferences = b.bvY();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), bwx());
    ad.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(bwy().size()) });
    if (this.mvl)
    {
      G(bwy());
      b.bxe().bxg().H(g.B(bwz()));
      b.bxe().bxg().nq(bwz().size());
    }
    if (this.mvm != null) {
      this.mvm.C(bwy());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.msp = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.msp = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.msp.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.mso = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.mso == null) {
      this.mso = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.bxT().bxU().apO().H(localb.mqx, paramLong1, paramLong2) > 0) {
          this.mso.add(localb);
        }
      }
      this.mso.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final LinkedList<f.b> bwx()
  {
    AppMethodBeat.i(21539);
    if (this.msn == null) {
      this.msn = new LinkedList();
    }
    LinkedList localLinkedList = this.msn;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bwy()
  {
    AppMethodBeat.i(21540);
    if (this.mso == null) {
      this.mso = new LinkedList();
    }
    LinkedList localLinkedList = this.mso;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final void bxd()
  {
    this.msn = null;
    this.msp = null;
    this.mso = null;
    this.msq = false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    ad.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { bt.eGN() });
    synchronized (this.lock)
    {
      if (this.mtk != null)
      {
        this.mtk.cancel();
        this.mtk = null;
      }
      this.msq = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    ad.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mvl = paramBoolean;
    d.bxT().bxW();
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21536);
        if (a.this.mtk != null) {
          a.this.mtk.cancel();
        }
        a.this.mtk = new com.tencent.mm.plugin.backup.c.b();
        a.this.mtk.a(a.this);
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