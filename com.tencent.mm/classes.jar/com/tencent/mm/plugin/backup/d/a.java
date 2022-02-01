package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  private Object lock;
  public com.tencent.mm.plugin.backup.c.b nAe;
  public b.b nAf;
  public long nAg;
  public LinkedList<f.b> nAh;
  public LinkedList<f.b> nAi;
  public LinkedList<f.b> nAj;
  public boolean nAk;
  public boolean nAl;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.nAh = null;
    this.nAi = null;
    this.nAj = null;
    this.nAk = false;
    this.nAl = false;
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
      AppMethodBeat.o(21279);
      return l2;
    }
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21285);
    ae.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.nAk = true;
    this.nAh = new LinkedList(paramLinkedList);
    this.nAg = F(this.nAh);
    bIC();
    ae.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(bIz().size()), Integer.valueOf(bIA().size()) });
    if (this.nAf != null) {
      this.nAf.C(bIA());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    ae.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.nAl = true;
    this.nAh = ((LinkedList)paramLinkedList.clone());
    bIC();
    if (b.bIE().bIG().nBi)
    {
      ae.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bIE().bIG().bIU();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.nAf != null) {
      this.nAf.D(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.nAi = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.nAi = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.bJW().bJX().azI().G(localb.nys, paramLong1, paramLong2) > 0) {
        this.nAi.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    ae.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.nAh = paramLinkedList;
    if (this.nAi != null)
    {
      Iterator localIterator = this.nAi.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.nys.equals(paramb.nys))
        {
          localb.nyv = paramb.nyv;
          localb.nyw = paramb.nyw;
        }
      }
    }
    if (b.bIE().bIG().nBi)
    {
      ae.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bIE().bHV().R(13, paramInt, paramLinkedList.size());
      b.bIE().bIG().tK(13);
    }
    if (this.nAf != null) {
      this.nAf.a(bIA(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final LinkedList<f.b> bIA()
  {
    AppMethodBeat.i(21280);
    if (this.nAi == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21280);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.nAi;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bIB()
  {
    AppMethodBeat.i(21282);
    if (this.nAj == null) {
      this.nAj = new LinkedList();
    }
    LinkedList localLinkedList = this.nAj;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void bIC()
  {
    AppMethodBeat.i(21284);
    b.bIE();
    SharedPreferences localSharedPreferences = b.bIa();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), bIz());
    AppMethodBeat.o(21284);
  }
  
  public final long bID()
  {
    AppMethodBeat.i(21288);
    if (bIB() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = bIB().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).nyv + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
  
  public final LinkedList<f.b> bIz()
  {
    AppMethodBeat.i(21278);
    if (this.nAh == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21278);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.nAh;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.nAe != null)
      {
        this.nAe.cancel();
        this.nAe = null;
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