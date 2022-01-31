package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  public long jAP;
  private LinkedList<f.b> jAQ;
  private LinkedList<f.b> jAR;
  private LinkedList<f.b> jAS;
  public boolean jAT;
  com.tencent.mm.plugin.backup.c.b jBP;
  public boolean jDR;
  public b.a jDS;
  private Object lock;
  
  public a()
  {
    AppMethodBeat.i(17478);
    this.jDR = false;
    this.lock = new Object();
    this.jAQ = null;
    this.jAR = null;
    this.jAS = null;
    this.jAT = false;
    AppMethodBeat.o(17478);
  }
  
  private static long E(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17479);
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
      AppMethodBeat.o(17479);
      return l2;
    }
  }
  
  private LinkedList<f.b> aTo()
  {
    AppMethodBeat.i(17484);
    if (this.jAS == null) {
      this.jAS = new LinkedList();
    }
    LinkedList localLinkedList = this.jAS;
    AppMethodBeat.o(17484);
    return localLinkedList;
  }
  
  public final void B(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17486);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ab.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.jAT = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.jDS != null) {
        this.jDS.B(paramLinkedList);
      }
      if (this.jDR)
      {
        paramLinkedList = b.aTX().aTZ();
        e.jEu = true;
        paramLinkedList.jBQ.aTa();
        b.aTX().aTs().stop();
        b.aTX().aSL().jyN = -23;
        b.aTX().aTZ().rl(-23);
      }
      AppMethodBeat.o(17486);
      return;
    }
    this.jAQ = new LinkedList(paramLinkedList);
    this.jAP = E(this.jAQ);
    b.aTX();
    SharedPreferences localSharedPreferences = b.aSQ();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), aTm());
    ab.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(aTn().size()) });
    if (this.jDR)
    {
      F(aTn());
      b.aTX().aTZ().G(g.A(aTo()));
      b.aTX().aTZ().hJ(aTo().size());
    }
    if (this.jDS != null) {
      this.jDS.B(aTn());
    }
    AppMethodBeat.o(17486);
  }
  
  public final void F(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17483);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.jAS = new LinkedList();
      AppMethodBeat.o(17483);
      return;
    }
    this.jAS = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.jAS.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(17483);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(17482);
    if (paramInt == 0)
    {
      this.jAR = new LinkedList(paramLinkedList);
      AppMethodBeat.o(17482);
      return;
    }
    if (this.jAR == null) {
      this.jAR = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().C(localb.jza, paramLong1, paramLong2) > 0) {
          this.jAR.add(localb);
        }
      }
      this.jAR.clear();
    }
    AppMethodBeat.o(17482);
  }
  
  public final void aTW()
  {
    this.jAQ = null;
    this.jAS = null;
    this.jAR = null;
    this.jAT = false;
  }
  
  public final LinkedList<f.b> aTm()
  {
    AppMethodBeat.i(17480);
    if (this.jAQ == null) {
      this.jAQ = new LinkedList();
    }
    LinkedList localLinkedList = this.jAQ;
    AppMethodBeat.o(17480);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> aTn()
  {
    AppMethodBeat.i(17481);
    if (this.jAR == null) {
      this.jAR = new LinkedList();
    }
    LinkedList localLinkedList = this.jAR;
    AppMethodBeat.o(17481);
    return localLinkedList;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17487);
    ab.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { bo.dtY() });
    synchronized (this.lock)
    {
      if (this.jBP != null)
      {
        this.jBP.cancel();
        this.jBP = null;
      }
      this.jAT = false;
      AppMethodBeat.o(17487);
      return;
    }
  }
  
  public final void fB(boolean paramBoolean)
  {
    AppMethodBeat.i(17485);
    ab.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jDR = paramBoolean;
    com.tencent.mm.plugin.backup.h.d.aUK().aUN();
    com.tencent.mm.sdk.g.d.post(new a.1(this), "BackupPcChooseServer.calculateToChoose");
    AppMethodBeat.o(17485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a
 * JD-Core Version:    0.7.0.1
 */