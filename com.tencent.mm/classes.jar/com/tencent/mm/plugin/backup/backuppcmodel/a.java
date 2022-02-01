package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  private Object lock;
  public long mUn;
  private LinkedList<f.b> mUo;
  private LinkedList<f.b> mUp;
  private LinkedList<f.b> mUq;
  public boolean mUr;
  com.tencent.mm.plugin.backup.c.b mVm;
  public boolean mXm;
  public b.a mXn;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.mXm = false;
    this.lock = new Object();
    this.mUo = null;
    this.mUp = null;
    this.mUq = null;
    this.mUr = false;
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
        l1 = ((f.b)paramLinkedList.get(0)).mSA;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.mSA) {
            break label89;
          }
          l1 = localb.mSA;
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
  
  private LinkedList<f.b> bDv()
  {
    AppMethodBeat.i(21543);
    if (this.mUq == null) {
      this.mUq = new LinkedList();
    }
    LinkedList localLinkedList = this.mUq;
    AppMethodBeat.o(21543);
    return localLinkedList;
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21545);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ac.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.mUr = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.mXn != null) {
        this.mXn.C(paramLinkedList);
      }
      if (this.mXm)
      {
        paramLinkedList = b.bEa().bEc();
        e.mXP = true;
        paramLinkedList.mVn.bDi();
        b.bEa().bDz().stop();
        b.bEa().bCP().mSk = -23;
        b.bEa().bEc().tc(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.mUo = new LinkedList(paramLinkedList);
    this.mUn = F(this.mUo);
    b.bEa();
    SharedPreferences localSharedPreferences = b.bCU();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), bDt());
    ac.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(bDu().size()) });
    if (this.mXm)
    {
      G(bDu());
      b.bEa().bEc().H(g.B(bDv()));
      b.bEa().bEc().rc(bDv().size());
    }
    if (this.mXn != null) {
      this.mXn.C(bDu());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.mUq = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.mUq = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.mUq.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.mUp = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.mUp == null) {
      this.mUp = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.bEP().bEQ().awD().F(localb.mSz, paramLong1, paramLong2) > 0) {
          this.mUp.add(localb);
        }
      }
      this.mUp.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final void bDZ()
  {
    this.mUo = null;
    this.mUq = null;
    this.mUp = null;
    this.mUr = false;
  }
  
  public final LinkedList<f.b> bDt()
  {
    AppMethodBeat.i(21539);
    if (this.mUo == null) {
      this.mUo = new LinkedList();
    }
    LinkedList localLinkedList = this.mUo;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bDu()
  {
    AppMethodBeat.i(21540);
    if (this.mUp == null) {
      this.mUp = new LinkedList();
    }
    LinkedList localLinkedList = this.mUp;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    ac.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { bs.eWi() });
    synchronized (this.lock)
    {
      if (this.mVm != null)
      {
        this.mVm.cancel();
        this.mVm = null;
      }
      this.mUr = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final void iv(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    ac.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mXm = paramBoolean;
    d.bEP().bES();
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21536);
        if (a.this.mVm != null) {
          a.this.mVm.cancel();
        }
        a.this.mVm = new com.tencent.mm.plugin.backup.c.b();
        a.this.mVm.a(a.this);
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