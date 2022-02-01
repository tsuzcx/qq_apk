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
  public com.tencent.mm.plugin.backup.c.b rMS;
  public b.b rMT;
  public long rMU;
  public LinkedList<f.b> rMV;
  public LinkedList<f.b> rMW;
  public LinkedList<f.b> rMX;
  public boolean rMY;
  public boolean rMZ;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.rMV = null;
    this.rMW = null;
    this.rMX = null;
    this.rMY = false;
    this.rMZ = false;
    AppMethodBeat.o(21277);
  }
  
  private static long G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21279);
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
      AppMethodBeat.o(21279);
      return l2;
    }
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21285);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.rMY = true;
    this.rMV = new LinkedList(paramLinkedList);
    this.rMU = G(this.rMV);
    csG();
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(csD().size()), Integer.valueOf(csE().size()) });
    if (this.rMT != null) {
      this.rMT.D(csE());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void E(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.rMZ = true;
    this.rMV = ((LinkedList)paramLinkedList.clone());
    csG();
    if (b.csI().csK().rOc)
    {
      Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.csI().csK().csZ();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.rMT != null) {
      this.rMT.E(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.rMW = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.rMW = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.cua().cub().bbO().G(localb.rLg, paramLong1, paramLong2) > 0) {
        this.rMW.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.rMV = paramLinkedList;
    if (this.rMW != null)
    {
      Iterator localIterator = this.rMW.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.rLg.equals(paramb.rLg))
        {
          localb.rLj = paramb.rLj;
          localb.rLk = paramb.rLk;
        }
      }
    }
    if (b.csI().csK().rOc)
    {
      Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.csI().crZ().T(13, paramInt, paramLinkedList.size());
      b.csI().csK().Bg(13);
    }
    if (this.rMT != null) {
      this.rMT.a(csE(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.rMS != null)
      {
        this.rMS.cancel();
        this.rMS = null;
      }
      AppMethodBeat.o(21283);
      return;
    }
  }
  
  public final LinkedList<f.b> csD()
  {
    AppMethodBeat.i(21278);
    if (this.rMV == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21278);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.rMV;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> csE()
  {
    AppMethodBeat.i(21280);
    if (this.rMW == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21280);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.rMW;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> csF()
  {
    AppMethodBeat.i(21282);
    if (this.rMX == null) {
      this.rMX = new LinkedList();
    }
    LinkedList localLinkedList = this.rMX;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void csG()
  {
    AppMethodBeat.i(21284);
    b.csI();
    SharedPreferences localSharedPreferences = b.cse();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), csD());
    AppMethodBeat.o(21284);
  }
  
  public final long csH()
  {
    AppMethodBeat.i(21288);
    if (csF() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = csF().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).rLj + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a
 * JD-Core Version:    0.7.0.1
 */