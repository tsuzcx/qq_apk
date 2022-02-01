package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.3;
import com.tencent.mm.plugin.backup.c.b.4;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  private Object lock;
  public com.tencent.mm.plugin.backup.c.b nuJ;
  public b.b nuK;
  public long nuL;
  public LinkedList<f.b> nuM;
  public LinkedList<f.b> nuN;
  public LinkedList<f.b> nuO;
  public boolean nuP;
  public boolean nuQ;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.nuM = null;
    this.nuN = null;
    this.nuO = null;
    this.nuP = false;
    this.nuQ = false;
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
        l1 = ((f.b)paramLinkedList.get(0)).nsY;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.nsY) {
            break label89;
          }
          l1 = localb.nsY;
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
    this.nuP = true;
    this.nuM = new LinkedList(paramLinkedList);
    this.nuL = F(this.nuM);
    bHE();
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(bHB().size()), Integer.valueOf(bHC().size()) });
    if (this.nuK != null) {
      this.nuK.C(bHC());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void D(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.nuQ = true;
    this.nuM = ((LinkedList)paramLinkedList.clone());
    bHE();
    if (b.bHG().bHI().nvN)
    {
      ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bHG().bHI().bHW();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.nuK != null) {
      this.nuK.D(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.nuN = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.nuN = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().G(localb.nsX, paramLong1, paramLong2) > 0) {
        this.nuN.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.nuM = paramLinkedList;
    if (this.nuN != null)
    {
      Iterator localIterator = this.nuN.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.nsX.equals(paramb.nsX))
        {
          localb.nta = paramb.nta;
          localb.ntb = paramb.ntb;
        }
      }
    }
    if (b.bHG().bHI().nvN)
    {
      ad.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.bHG().bGX().R(13, paramInt, paramLinkedList.size());
      b.bHG().bHI().tF(13);
    }
    if (this.nuK != null) {
      this.nuK.a(bHC(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final LinkedList<f.b> bHB()
  {
    AppMethodBeat.i(21278);
    if (this.nuM == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21278);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.nuM;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bHC()
  {
    AppMethodBeat.i(21280);
    if (this.nuN == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21280);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.nuN;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> bHD()
  {
    AppMethodBeat.i(21282);
    if (this.nuO == null) {
      this.nuO = new LinkedList();
    }
    LinkedList localLinkedList = this.nuO;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void bHE()
  {
    AppMethodBeat.i(21284);
    b.bHG();
    SharedPreferences localSharedPreferences = b.bHc();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), bHB());
    AppMethodBeat.o(21284);
  }
  
  public final long bHF()
  {
    AppMethodBeat.i(21288);
    if (bHD() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = bHD().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).nta + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.nuJ != null)
      {
        this.nuJ.cancel();
        this.nuJ = null;
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