package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  private Object lock;
  public com.tencent.mm.plugin.backup.c.b uYg;
  public b.b uYh;
  public long uYi;
  public LinkedList<f.b> uYj;
  public LinkedList<f.b> uYk;
  public LinkedList<f.b> uYl;
  public boolean uYm;
  public boolean uYn;
  
  public a()
  {
    AppMethodBeat.i(21277);
    this.lock = new Object();
    this.uYj = null;
    this.uYk = null;
    this.uYl = null;
    this.uYm = false;
    this.uYn = false;
    AppMethodBeat.o(21277);
  }
  
  private static long J(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21279);
    long l1 = 0L;
    long l2 = l1;
    if (paramLinkedList != null)
    {
      l2 = l1;
      if (paramLinkedList.size() > 0)
      {
        l1 = ((f.b)paramLinkedList.get(0)).uWv;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.uWv) {
            break label89;
          }
          l1 = localb.uWv;
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
  
  public final void G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21285);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.uYm = true;
    this.uYj = new LinkedList(paramLinkedList);
    this.uYi = J(this.uYj);
    cVq();
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(cVn().size()), Integer.valueOf(cVo().size()) });
    if (this.uYh != null) {
      this.uYh.G(cVo());
    }
    AppMethodBeat.o(21285);
  }
  
  public final void H(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21287);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.uYn = true;
    this.uYj = ((LinkedList)paramLinkedList.clone());
    cVq();
    if (b.cVs().cVu().uZq)
    {
      Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.cVs().cVu().cVJ();
      AppMethodBeat.o(21287);
      return;
    }
    if (this.uYh != null) {
      this.uYh.H(paramLinkedList);
    }
    AppMethodBeat.o(21287);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21281);
    if (paramInt == 0)
    {
      this.uYk = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21281);
      return;
    }
    this.uYk = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.cWK().cWL().bzD().L(localb.uWu, paramLong1, paramLong2) > 0) {
        this.uYk.add(localb);
      }
    }
    AppMethodBeat.o(21281);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(21286);
    Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.uYj = paramLinkedList;
    if (this.uYk != null)
    {
      Iterator localIterator = this.uYk.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.uWu.equals(paramb.uWu))
        {
          localb.uWx = paramb.uWx;
          localb.uWy = paramb.uWy;
        }
      }
    }
    if (b.cVs().cVu().uZq)
    {
      Log.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.cVs().cUJ().ak(13, paramInt, paramLinkedList.size());
      b.cVs().cVu().Bt(13);
    }
    if (this.uYh != null) {
      this.uYh.a(cVo(), paramb, paramInt);
    }
    AppMethodBeat.o(21286);
  }
  
  public final LinkedList<f.b> cVn()
  {
    AppMethodBeat.i(21278);
    if (this.uYj == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21278);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.uYj;
    AppMethodBeat.o(21278);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> cVo()
  {
    AppMethodBeat.i(21280);
    if (this.uYk == null)
    {
      localLinkedList = new LinkedList();
      AppMethodBeat.o(21280);
      return localLinkedList;
    }
    LinkedList localLinkedList = this.uYk;
    AppMethodBeat.o(21280);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> cVp()
  {
    AppMethodBeat.i(21282);
    if (this.uYl == null) {
      this.uYl = new LinkedList();
    }
    LinkedList localLinkedList = this.uYl;
    AppMethodBeat.o(21282);
    return localLinkedList;
  }
  
  public final void cVq()
  {
    AppMethodBeat.i(21284);
    b.cVs();
    SharedPreferences localSharedPreferences = b.cUO();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), cVn());
    AppMethodBeat.o(21284);
  }
  
  public final long cVr()
  {
    AppMethodBeat.i(21288);
    if (cVp() == null)
    {
      AppMethodBeat.o(21288);
      return 0L;
    }
    Iterator localIterator = cVp().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).uWx + l) {}
    AppMethodBeat.o(21288);
    return l;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21283);
    synchronized (this.lock)
    {
      if (this.uYg != null)
      {
        this.uYg.cancel();
        this.uYg = null;
      }
      AppMethodBeat.o(21283);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a
 * JD-Core Version:    0.7.0.1
 */