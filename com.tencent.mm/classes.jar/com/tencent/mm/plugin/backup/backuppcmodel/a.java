package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  public long hHt;
  private LinkedList<f.b> hHu = null;
  private LinkedList<f.b> hHv = null;
  private LinkedList<f.b> hHw = null;
  public boolean hHx = false;
  com.tencent.mm.plugin.backup.c.b hIr;
  public boolean hKo = false;
  public b.a hKp;
  private Object lock = new Object();
  
  private static long D(LinkedList<f.b> paramLinkedList)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramLinkedList != null)
    {
      l2 = l1;
      if (paramLinkedList.size() > 0)
      {
        l1 = ((f.b)paramLinkedList.get(0)).hFE;
        paramLinkedList = paramLinkedList.iterator();
        l2 = l1;
        if (paramLinkedList.hasNext())
        {
          f.b localb = (f.b)paramLinkedList.next();
          if (l1 <= localb.hFE) {
            break label77;
          }
          l1 = localb.hFE;
        }
      }
    }
    label77:
    for (;;)
    {
      break;
      return l2;
    }
  }
  
  private LinkedList<f.b> atQ()
  {
    if (this.hHw == null) {
      this.hHw = new LinkedList();
    }
    return this.hHw;
  }
  
  public final void A(LinkedList<f.b> paramLinkedList)
  {
    int i;
    if (paramLinkedList == null)
    {
      i = -1;
      y.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.hHx = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break label122;
      }
      if (this.hKp != null) {
        this.hKp.A(paramLinkedList);
      }
      if (this.hKo)
      {
        paramLinkedList = b.auw().auy();
        e.hKR = true;
        paramLinkedList.hIs.atC();
        b.auw().atT().stop();
        b.auw().atn().hFu = -23;
        b.auw().auy().nD(-23);
      }
    }
    label122:
    do
    {
      return;
      i = paramLinkedList.size();
      break;
      this.hHu = new LinkedList(paramLinkedList);
      this.hHt = D(this.hHu);
      b.auw();
      SharedPreferences localSharedPreferences = b.ats();
      a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), atO());
      y.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(atP().size()) });
      if (this.hKo)
      {
        E(atP());
        b.auw().auy().F(com.tencent.mm.plugin.backup.b.g.z(atQ()));
        b.auw().auy().cH(atQ().size());
      }
    } while (this.hKp == null);
    this.hKp.A(atP());
  }
  
  public final void E(LinkedList<f.b> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.hHw = new LinkedList();
      return;
    }
    this.hHw = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.hHw.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    if (paramInt == 0)
    {
      this.hHv = new LinkedList(paramLinkedList);
      return;
    }
    if (this.hHv == null) {
      this.hHv = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.avi().avj().Fy().u(localb.hFD, paramLong1, paramLong2) > 0) {
          this.hHv.add(localb);
        }
      }
      break;
      this.hHv.clear();
    }
  }
  
  public final LinkedList<f.b> atO()
  {
    if (this.hHu == null) {
      this.hHu = new LinkedList();
    }
    return this.hHu;
  }
  
  public final LinkedList<f.b> atP()
  {
    if (this.hHv == null) {
      this.hHv = new LinkedList();
    }
    return this.hHv;
  }
  
  public final void auv()
  {
    this.hHu = null;
    this.hHw = null;
    this.hHv = null;
    this.hHx = false;
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { bk.csb() });
    synchronized (this.lock)
    {
      if (this.hIr != null)
      {
        this.hIr.cancel();
        this.hIr = null;
      }
      this.hHx = false;
      return;
    }
  }
  
  public final void ee(boolean paramBoolean)
  {
    y.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hKo = paramBoolean;
    d.avi().avl();
    com.tencent.mm.sdk.f.e.post(new a.1(this), "BackupPcChooseServer.calculateToChoose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a
 * JD-Core Version:    0.7.0.1
 */