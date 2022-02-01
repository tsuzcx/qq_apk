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
  public long oLe;
  private LinkedList<f.b> oLf;
  private LinkedList<f.b> oLg;
  private LinkedList<f.b> oLh;
  public boolean oLi;
  com.tencent.mm.plugin.backup.c.b oMd;
  public boolean oOb;
  public b.a oOc;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.oOb = false;
    this.lock = new Object();
    this.oLf = null;
    this.oLg = null;
    this.oLh = null;
    this.oLi = false;
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
        l1 = ((f.b)paramLinkedList.get(0)).oJr;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.oJr) {
            break label89;
          }
          l1 = localb.oJr;
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
  
  private LinkedList<f.b> cfs()
  {
    AppMethodBeat.i(21543);
    if (this.oLh == null) {
      this.oLh = new LinkedList();
    }
    LinkedList localLinkedList = this.oLh;
    AppMethodBeat.o(21543);
    return localLinkedList;
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21545);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.oLi = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.oOc != null) {
        this.oOc.C(paramLinkedList);
      }
      if (this.oOb)
      {
        paramLinkedList = b.cga().cgc();
        e.oOE = true;
        paramLinkedList.oMe.cff();
        b.cga().cfw().stop();
        b.cga().ceM().oJc = -23;
        b.cga().cgc().xI(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.oLf = new LinkedList(paramLinkedList);
    this.oLe = F(this.oLf);
    b.cga();
    SharedPreferences localSharedPreferences = b.ceR();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), cfq());
    Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(cfr().size()) });
    if (this.oOb)
    {
      H(cfr());
      b.cga().cgc().G(g.B(cfs()));
      b.cga().cgc().Bv(cfs().size());
    }
    if (this.oOc != null) {
      this.oOc.C(cfr());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void H(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.oLh = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.oLh = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.oLh.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.oLg = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.oLg == null) {
      this.oLg = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.cgP().cgQ().aSQ().H(localb.oJq, paramLong1, paramLong2) > 0) {
          this.oLg.add(localb);
        }
      }
      this.oLg.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    Log.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { Util.getStack() });
    synchronized (this.lock)
    {
      if (this.oMd != null)
      {
        this.oMd.cancel();
        this.oMd = null;
      }
      this.oLi = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final void cfZ()
  {
    this.oLf = null;
    this.oLh = null;
    this.oLg = null;
    this.oLi = false;
  }
  
  public final LinkedList<f.b> cfq()
  {
    AppMethodBeat.i(21539);
    if (this.oLf == null) {
      this.oLf = new LinkedList();
    }
    LinkedList localLinkedList = this.oLf;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> cfr()
  {
    AppMethodBeat.i(21540);
    if (this.oLg == null) {
      this.oLg = new LinkedList();
    }
    LinkedList localLinkedList = this.oLg;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final void jD(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    Log.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oOb = paramBoolean;
    d.cgP().cgS();
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21536);
        if (a.this.oMd != null) {
          a.this.oMd.cancel();
        }
        a.this.oMd = new com.tencent.mm.plugin.backup.c.b();
        a.this.oMd.a(a.this);
        AppMethodBeat.o(21536);
      }
    }, "BackupPcChooseServer.calculateToChoose");
    AppMethodBeat.o(21544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a
 * JD-Core Version:    0.7.0.1
 */