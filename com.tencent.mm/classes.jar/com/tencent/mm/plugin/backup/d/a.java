package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.c.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.b
{
  public com.tencent.mm.plugin.backup.c.b hHr;
  public b.b hHs;
  public long hHt;
  public LinkedList<f.b> hHu = null;
  public LinkedList<f.b> hHv = null;
  public LinkedList<f.b> hHw = null;
  public boolean hHx = false;
  public boolean hHy = false;
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
  
  public final void A(LinkedList<f.b> paramLinkedList)
  {
    y.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
    this.hHx = true;
    this.hHu = new LinkedList(paramLinkedList);
    this.hHt = D(this.hHu);
    atR();
    y.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(atO().size()), Integer.valueOf(atP().size()) });
    if (this.hHs != null) {
      this.hHs.A(atP());
    }
  }
  
  public final void B(LinkedList<f.b> paramLinkedList)
  {
    y.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
    this.hHy = true;
    this.hHu = ((LinkedList)paramLinkedList.clone());
    atR();
    if (b.atS().atU().hIv)
    {
      y.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.atS().atU().aui();
    }
    while (this.hHs == null) {
      return;
    }
    this.hHs.B(paramLinkedList);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    if (paramInt == 0) {
      this.hHv = new LinkedList(paramLinkedList);
    }
    for (;;)
    {
      return;
      this.hHv = new LinkedList();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().u(localb.hFD, paramLong1, paramLong2) > 0) {
          this.hHv.add(localb);
        }
      }
    }
  }
  
  public final void a(LinkedList<f.b> paramLinkedList, f.b paramb, int paramInt)
  {
    y.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
    this.hHu = paramLinkedList;
    if (this.hHv != null)
    {
      Iterator localIterator = this.hHv.iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)localIterator.next();
        if (localb.hFD.equals(paramb.hFD))
        {
          localb.hFG = paramb.hFG;
          localb.hFH = paramb.hFH;
        }
      }
    }
    if (b.atS().atU().hIv)
    {
      y.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
      b.atS().atn().B(13, paramInt, paramLinkedList.size());
      b.atS().atU().nt(13);
    }
    if (this.hHs != null) {
      this.hHs.a(atP(), paramb, paramInt);
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
  
  public final LinkedList<f.b> atQ()
  {
    if (this.hHw == null) {
      this.hHw = new LinkedList();
    }
    return this.hHw;
  }
  
  public final void atR()
  {
    b.atS();
    SharedPreferences localSharedPreferences = b.ats();
    a(localSharedPreferences.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L), atO());
  }
  
  public final void cancel()
  {
    synchronized (this.lock)
    {
      if (this.hHr != null)
      {
        this.hHr.cancel();
        this.hHr = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a
 * JD-Core Version:    0.7.0.1
 */