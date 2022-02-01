package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  private Object lock;
  public com.tencent.mm.plugin.backup.c.b mUl;
  public b.b mUm;
  public long mUn;
  public LinkedList<f.b> mUo;
  public LinkedList<f.b> mUp;
  public LinkedList<f.b> mUq;
  public boolean mUr;
  public boolean mUs;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.mUo = null;
    this.mUp = null;
    this.mUq = null;
    this.mUr = false;
    this.mUs = false;
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
      AppMethodBeat.o(21279);
      return l2;
    }
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21285);
    ac.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.mUr = true;
    this.mUo = new LinkedList(paramLinkedList);
    this.mUn = F(this.mUo);
    bDw();
    ac.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(bDt().size()), Integer.valueOf(bDu().size()) });
    if (this.mUm != null) {
      this.mUm.C(bDu());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    ac.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.mUs = true;
    this.mUo = ((LinkedList)paramLinkedList.clone());
    bDw();
    if (b.bDy().bDA().mVq)
    {
      ac.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bDy().bDA().bDN();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.mUm != null) {
      this.mUm.D(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.mUp = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.mUp = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().F(localb.mSz, paramLong1, paramLong2) > 0) {
        this.mUp.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    ac.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.mUo = paramLinkedList;
    if (this.mUp != null)
    {
      Iterator localIterator = this.mUp.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.mSz.equals(paramb.mSz))
        {
          localb.mSC = paramb.mSC;
          localb.mSD = paramb.mSD;
        }
      }
    }
    if (b.bDy().bDA().mVq)
    {
      ac.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bDy().bCP().P(13, paramInt, paramLinkedList.size());
      b.bDy().bDA().tc(13);
    }
    if (this.mUm != null) {
      this.mUm.a(bDu(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final LinkedList<f.b> bDt()
  {
    AppMethodBeat.i(21278);
    if (this.mUo == null) {
      this.mUo = new LinkedList();
    }
    LinkedList localLinkedList = this.mUo;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bDu()
  {
    AppMethodBeat.i(21280);
    if (this.mUp == null) {
      this.mUp = new LinkedList();
    }
    LinkedList localLinkedList = this.mUp;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bDv()
  {
    AppMethodBeat.i(21282);
    if (this.mUq == null) {
      this.mUq = new LinkedList();
    }
    LinkedList localLinkedList = this.mUq;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void bDw()
  {
    AppMethodBeat.i(21284);
    b.bDy();
    SharedPreferences localSharedPreferences = b.bCU();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), bDt());
    AppMethodBeat.o(21284);
  }
  
  public final long bDx()
  {
    AppMethodBeat.i(21288);
    if (bDv() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = bDv().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).mSC + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.mUl != null)
      {
        this.mUl.cancel();
        this.mUl = null;
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