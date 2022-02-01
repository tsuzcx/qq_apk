package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  private Object lock;
  public com.tencent.mm.plugin.backup.c.b msk;
  public b.b msl;
  public long msm;
  public LinkedList<f.b> msn;
  public LinkedList<f.b> mso;
  public LinkedList<f.b> msp;
  public boolean msq;
  public boolean msr;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.msn = null;
    this.mso = null;
    this.msp = null;
    this.msq = false;
    this.msr = false;
    AppMethodBeat.o(21277);
  }
  
  private static long F(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21279);
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
      AppMethodBeat.o(21279);
      return l2;
    }
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21285);
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.msq = true;
    this.msn = new LinkedList(paramLinkedList);
    this.msm = F(this.msn);
    bwA();
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(bwx().size()), Integer.valueOf(bwy().size()) });
    if (this.msl != null) {
      this.msl.C(bwy());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.msr = true;
    this.msn = ((LinkedList)paramLinkedList.clone());
    bwA();
    if (b.bwC().bwE().mto)
    {
      ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bwC().bwE().bwR();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.msl != null) {
      this.msl.D(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.mso = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.mso = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.bxT().bxU().apO().H(localb.mqx, paramLong1, paramLong2) > 0) {
        this.mso.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.msn = paramLinkedList;
    if (this.mso != null)
    {
      Iterator localIterator = this.mso.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.mqx.equals(paramb.mqx))
        {
          localb.mqA = paramb.mqA;
          localb.mqB = paramb.mqB;
        }
      }
    }
    if (b.bwC().bwE().mto)
    {
      ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bwC().bvT().O(13, paramInt, paramLinkedList.size());
      b.bwC().bwE().sm(13);
    }
    if (this.msl != null) {
      this.msl.a(bwy(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final void bwA()
  {
    AppMethodBeat.i(21284);
    b.bwC();
    SharedPreferences localSharedPreferences = b.bvY();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), bwx());
    AppMethodBeat.o(21284);
  }
  
  public final long bwB()
  {
    AppMethodBeat.i(21288);
    if (bwz() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = bwz().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).mqA + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
  
  public final LinkedList<f.b> bwx()
  {
    AppMethodBeat.i(21278);
    if (this.msn == null) {
      this.msn = new LinkedList();
    }
    LinkedList localLinkedList = this.msn;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bwy()
  {
    AppMethodBeat.i(21280);
    if (this.mso == null) {
      this.mso = new LinkedList();
    }
    LinkedList localLinkedList = this.mso;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bwz()
  {
    AppMethodBeat.i(21282);
    if (this.msp == null) {
      this.msp = new LinkedList();
    }
    LinkedList localLinkedList = this.msp;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.msk != null)
      {
        this.msk.cancel();
        this.msk = null;
      }
      AppMethodBeat.o(21283);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a
 * JD-Core Version:    0.7.0.1
 */