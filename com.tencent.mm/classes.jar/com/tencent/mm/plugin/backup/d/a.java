package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  private Object lock;
  public com.tencent.mm.plugin.backup.c.b oLc;
  public b.b oLd;
  public long oLe;
  public LinkedList<f.b> oLf;
  public LinkedList<f.b> oLg;
  public LinkedList<f.b> oLh;
  public boolean oLi;
  public boolean oLj;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.oLf = null;
    this.oLg = null;
    this.oLh = null;
    this.oLi = false;
    this.oLj = false;
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
      AppMethodBeat.o(21279);
      return l2;
    }
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21285);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.oLi = true;
    this.oLf = new LinkedList(paramLinkedList);
    this.oLe = F(this.oLf);
    cft();
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(cfq().size()), Integer.valueOf(cfr().size()) });
    if (this.oLd != null) {
      this.oLd.C(cfr());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.oLj = true;
    this.oLf = ((LinkedList)paramLinkedList.clone());
    cft();
    if (b.cfv().cfx().oMh)
    {
      Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.cfv().cfx().cfM();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.oLd != null) {
      this.oLd.D(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.oLg = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.oLg = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().H(localb.oJq, paramLong1, paramLong2) > 0) {
        this.oLg.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.oLf = paramLinkedList;
    if (this.oLg != null)
    {
      Iterator localIterator = this.oLg.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.oJq.equals(paramb.oJq))
        {
          localb.oJt = paramb.oJt;
          localb.oJu = paramb.oJu;
        }
      }
    }
    if (b.cfv().cfx().oMh)
    {
      Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.cfv().ceM().S(13, paramInt, paramLinkedList.size());
      b.cfv().cfx().xI(13);
    }
    if (this.oLd != null) {
      this.oLd.a(cfr(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.oLc != null)
      {
        this.oLc.cancel();
        this.oLc = null;
      }
      AppMethodBeat.o(21283);
      return;
    }
  }
  
  public final LinkedList<f.b> cfq()
  {
    AppMethodBeat.i(21278);
    if (this.oLf == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21278);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.oLf;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> cfr()
  {
    AppMethodBeat.i(21280);
    if (this.oLg == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21280);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.oLg;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> cfs()
  {
    AppMethodBeat.i(21282);
    if (this.oLh == null) {
      this.oLh = new LinkedList();
    }
    LinkedList localLinkedList = this.oLh;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void cft()
  {
    AppMethodBeat.i(21284);
    b.cfv();
    SharedPreferences localSharedPreferences = b.ceR();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), cfq());
    AppMethodBeat.o(21284);
  }
  
  public final long cfu()
  {
    AppMethodBeat.i(21288);
    if (cfs() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = cfs().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).oJt + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a
 * JD-Core Version:    0.7.0.1
 */