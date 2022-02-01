package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  private Object lock;
  public long rMU;
  private LinkedList<f.b> rMV;
  private LinkedList<f.b> rMW;
  private LinkedList<f.b> rMX;
  public boolean rMY;
  com.tencent.mm.plugin.backup.c.b rNY;
  public boolean rPY;
  public b.a rPZ;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.rPY = false;
    this.lock = new Object();
    this.rMV = null;
    this.rMW = null;
    this.rMX = null;
    this.rMY = false;
    AppMethodBeat.o(21537);
  }
  
  private static long G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21538);
    long l1 = 0L;
    long l2 = l1;
    if (paramLinkedList != null)
    {
      l2 = l1;
      if (paramLinkedList.size() > 0)
      {
        l1 = ((f.b)paramLinkedList.get(0)).rLh;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.rLh) {
            break label89;
          }
          l1 = localb.rLh;
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
  
  private LinkedList<f.b> csF()
  {
    AppMethodBeat.i(21543);
    if (this.rMX == null) {
      this.rMX = new LinkedList();
    }
    LinkedList localLinkedList = this.rMX;
    AppMethodBeat.o(21543);
    return localLinkedList;
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21545);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.rMY = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.rPZ != null) {
        this.rPZ.D(paramLinkedList);
      }
      if (this.rPY)
      {
        paramLinkedList = b.ctm().cto();
        e.rQB = true;
        paramLinkedList.rNZ.css();
        b.ctm().csJ().stop();
        b.ctm().crZ().rKS = -23;
        b.ctm().cto().Bg(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.rMV = new LinkedList(paramLinkedList);
    this.rMU = G(this.rMV);
    b.ctm();
    SharedPreferences localSharedPreferences = b.cse();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), csD());
    Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(csE().size()) });
    if (this.rPY)
    {
      I(csE());
      b.ctm().cto().H(g.C(csF()));
      b.ctm().cto().HI(csF().size());
    }
    if (this.rPZ != null) {
      this.rPZ.D(csE());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void I(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.rMX = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.rMX = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.rMX.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.rMW = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.rMW == null) {
      this.rMW = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.cua().cub().bbO().G(localb.rLg, paramLong1, paramLong2) > 0) {
          this.rMW.add(localb);
        }
      }
      this.rMW.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    Log.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { Util.getStack() });
    synchronized (this.lock)
    {
      if (this.rNY != null)
      {
        this.rNY.cancel();
        this.rNY = null;
      }
      this.rMY = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final LinkedList<f.b> csD()
  {
    AppMethodBeat.i(21539);
    if (this.rMV == null) {
      this.rMV = new LinkedList();
    }
    LinkedList localLinkedList = this.rMV;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> csE()
  {
    AppMethodBeat.i(21540);
    if (this.rMW == null) {
      this.rMW = new LinkedList();
    }
    LinkedList localLinkedList = this.rMW;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final void ctl()
  {
    this.rMV = null;
    this.rMX = null;
    this.rMW = null;
    this.rMY = false;
  }
  
  public final void kO(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    Log.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rPY = paramBoolean;
    d.cua().cud();
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21536);
        if (a.this.rNY != null) {
          a.this.rNY.cancel();
        }
        a.this.rNY = new com.tencent.mm.plugin.backup.c.b();
        a.this.rNY.a(a.this);
        AppMethodBeat.o(21536);
      }
    }, "BackupPcChooseServer.calculateToChoose");
    AppMethodBeat.o(21544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a
 * JD-Core Version:    0.7.0.1
 */