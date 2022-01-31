package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  public com.tencent.mm.plugin.backup.c.b jAN;
  public b.b jAO;
  public long jAP;
  public LinkedList<f.b> jAQ;
  public LinkedList<f.b> jAR;
  public LinkedList<f.b> jAS;
  public boolean jAT;
  public boolean jAU;
  private Object lock;
  
  public a()
  {
    AppMethodBeat.i(17223);
    this.lock = new Object();
    this.jAQ = null;
    this.jAR = null;
    this.jAS = null;
    this.jAT = false;
    this.jAU = false;
    AppMethodBeat.o(17223);
  }
  
  private static long E(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17225);
    long l1 = 0L;
    long l2 = l1;
    if (paramLinkedList != null)
    {
      l2 = l1;
      if (paramLinkedList.size() > 0)
      {
        l1 = ((f.b)paramLinkedList.get(0)).jzb;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.jzb) {
            break label89;
          }
          l1 = localb.jzb;
        }
      }
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(17225);
      return l2;
    }
  }
  
  public final void B(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17231);
    ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.jAT = true;
    this.jAQ = new LinkedList(paramLinkedList);
    this.jAP = E(this.jAQ);
    aTp();
    ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(aTm().size()), Integer.valueOf(aTn().size()) });
    if (this.jAO != null) {
      this.jAO.B(aTn());
    }
    AppMethodBeat.o(17231);
  }
  
  public final void C(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17233);
    ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.jAU = true;
    this.jAQ = ((LinkedList)paramLinkedList.clone());
    aTp();
    if (b.aTr().aTt().jBT)
    {
      ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.aTr().aTt().aTH();
      AppMethodBeat.o(17233);
      return;
    }
    if (this.jAO != null) {
      this.jAO.C(paramLinkedList);
    }
    AppMethodBeat.o(17233);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17227);
    if (paramInt == 0)
    {
      this.jAR = new LinkedList(paramLinkedList);
      AppMethodBeat.o(17227);
      return;
    }
    this.jAR = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      f.b localb = (f.b)paramLinkedList.next();
      if (com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().C(localb.jza, paramLong1, paramLong2) > 0) {
        this.jAR.add(localb);
      }
    }
    AppMethodBeat.o(17227);
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    AppMethodBeat.i(17232);
    ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.jAQ = paramLinkedList;
    if (this.jAR != null)
    {
      Iterator localIterator = this.jAR.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.jza.equals(paramb.jza))
        {
          localb.jzd = paramb.jzd;
          localb.jze = paramb.jze;
        }
      }
    }
    if (b.aTr().aTt().jBT)
    {
      ab.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.aTr().aSL().N(13, paramInt, paramLinkedList.size());
      b.aTr().aTt().rl(13);
    }
    if (this.jAO != null) {
      this.jAO.a(aTn(), paramb, paramInt);
    }
    AppMethodBeat.o(17232);
  }
  
  public final LinkedList<f.b> aTm()
  {
    AppMethodBeat.i(17224);
    if (this.jAQ == null) {
      this.jAQ = new LinkedList();
    }
    LinkedList localLinkedList = this.jAQ;
    AppMethodBeat.o(17224);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> aTn()
  {
    AppMethodBeat.i(17226);
    if (this.jAR == null) {
      this.jAR = new LinkedList();
    }
    LinkedList localLinkedList = this.jAR;
    AppMethodBeat.o(17226);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> aTo()
  {
    AppMethodBeat.i(17228);
    if (this.jAS == null) {
      this.jAS = new LinkedList();
    }
    LinkedList localLinkedList = this.jAS;
    AppMethodBeat.o(17228);
    return localLinkedList;
  }
  
  public final void aTp()
  {
    AppMethodBeat.i(17230);
    b.aTr();
    SharedPreferences localSharedPreferences = b.aSQ();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), aTm());
    AppMethodBeat.o(17230);
  }
  
  public final long aTq()
  {
    AppMethodBeat.i(17234);
    if (aTo() == null)
    {
      AppMethodBeat.o(17234);
      return 0L;
    }
    Iterator localIterator = aTo().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((f.b)localIterator.next()).jzd + l) {}
    AppMethodBeat.o(17234);
    return l;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17229);
    synchronized (this.lock)
    {
      if (this.jAN != null)
      {
        this.jAN.cancel();
        this.jAN = null;
      }
      AppMethodBeat.o(17229);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a
 * JD-Core Version:    0.7.0.1
 */