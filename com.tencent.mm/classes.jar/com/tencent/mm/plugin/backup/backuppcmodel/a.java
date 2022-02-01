package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  private Object lock;
  public long nAg;
  private LinkedList<f.b> nAh;
  private LinkedList<f.b> nAi;
  private LinkedList<f.b> nAj;
  public boolean nAk;
  com.tencent.mm.plugin.backup.c.b nBe;
  public boolean nDe;
  public b.a nDf;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.nDe = false;
    this.lock = new Object();
    this.nAh = null;
    this.nAi = null;
    this.nAj = null;
    this.nAk = false;
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
        l1 = ((f.b)paramLinkedList.get(0)).nyt;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.nyt) {
            break label89;
          }
          l1 = localb.nyt;
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
  
  private LinkedList<f.b> bIB()
  {
    AppMethodBeat.i(21543);
    if (this.nAj == null) {
      this.nAj = new LinkedList();
    }
    LinkedList localLinkedList = this.nAj;
    AppMethodBeat.o(21543);
    return localLinkedList;
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21545);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ae.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.nAk = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.nDf != null) {
        this.nDf.C(paramLinkedList);
      }
      if (this.nDe)
      {
        paramLinkedList = b.bJh().bJj();
        e.nDH = true;
        paramLinkedList.nBf.bIo();
        b.bJh().bIF().stop();
        b.bJh().bHV().nye = -23;
        b.bJh().bJj().tK(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.nAh = new LinkedList(paramLinkedList);
    this.nAg = F(this.nAh);
    b.bJh();
    SharedPreferences localSharedPreferences = b.bIa();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), bIz());
    ae.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(bIA().size()) });
    if (this.nDe)
    {
      G(bIA());
      b.bJh().bJj().H(g.B(bIB()));
      b.bJh().bJj().tp(bIB().size());
    }
    if (this.nDf != null) {
      this.nDf.C(bIA());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.nAj = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.nAj = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.nAj.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.nAi = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.nAi == null) {
      this.nAi = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.bJW().bJX().azI().G(localb.nys, paramLong1, paramLong2) > 0) {
          this.nAi.add(localb);
        }
      }
      this.nAi.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final LinkedList<f.b> bIA()
  {
    AppMethodBeat.i(21540);
    if (this.nAi == null) {
      this.nAi = new LinkedList();
    }
    LinkedList localLinkedList = this.nAi;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bIz()
  {
    AppMethodBeat.i(21539);
    if (this.nAh == null) {
      this.nAh = new LinkedList();
    }
    LinkedList localLinkedList = this.nAh;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final void bJg()
  {
    this.nAh = null;
    this.nAj = null;
    this.nAi = null;
    this.nAk = false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    ae.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { bu.fpN() });
    synchronized (this.lock)
    {
      if (this.nBe != null)
      {
        this.nBe.cancel();
        this.nBe = null;
      }
      this.nAk = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final void iC(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    ae.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nDe = paramBoolean;
    d.bJW().bJZ();
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21536);
        if (a.this.nBe != null) {
          a.this.nBe.cancel();
        }
        a.this.nBe = new com.tencent.mm.plugin.backup.c.b();
        a.this.nBe.a(a.this);
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