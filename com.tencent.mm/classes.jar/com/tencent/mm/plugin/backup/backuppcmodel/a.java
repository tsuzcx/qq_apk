package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.b.a;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b.a
{
  private Object lock;
  public long uYi;
  private LinkedList<f.b> uYj;
  private LinkedList<f.b> uYk;
  private LinkedList<f.b> uYl;
  public boolean uYm;
  com.tencent.mm.plugin.backup.c.b uZm;
  public boolean vbn;
  public b.a vbo;
  
  public a()
  {
    AppMethodBeat.i(21537);
    this.vbn = false;
    this.lock = new Object();
    this.uYj = null;
    this.uYk = null;
    this.uYl = null;
    this.uYm = false;
    AppMethodBeat.o(21537);
  }
  
  private static long J(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21538);
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
      AppMethodBeat.o(21538);
      return l2;
    }
  }
  
  private LinkedList<f.b> cVp()
  {
    AppMethodBeat.i(21543);
    if (this.uYl == null) {
      this.uYl = new LinkedList();
    }
    LinkedList localLinkedList = this.uYl;
    AppMethodBeat.o(21543);
    return localLinkedList;
  }
  
  public final void G(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21545);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, conv size[%d]", new Object[] { Integer.valueOf(i) });
      this.uYm = true;
      if ((paramLinkedList != null) && (paramLinkedList.size() != 0)) {
        break;
      }
      if (this.vbo != null) {
        this.vbo.G(paramLinkedList);
      }
      if (this.vbn)
      {
        paramLinkedList = b.cVW().cVY();
        e.vbQ = true;
        paramLinkedList.uZn.cVc();
        b.cVW().cVt().stop();
        b.cVW().cUJ().uWg = -23;
        b.cVW().cVY().Bt(-23);
      }
      AppMethodBeat.o(21545);
      return;
    }
    this.uYj = new LinkedList(paramLinkedList);
    this.uYi = J(this.uYj);
    b.cVW();
    SharedPreferences localSharedPreferences = b.cUO();
    a(localSharedPreferences.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L), localSharedPreferences.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L), cVn());
    Log.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(cVo().size()) });
    if (this.vbn)
    {
      L(cVo());
      b.cVW().cVY().K(g.F(cVp()));
      b.cVW().cVY().jZ(cVp().size());
    }
    if (this.vbo != null) {
      this.vbo.G(cVo());
    }
    AppMethodBeat.o(21545);
  }
  
  public final void L(LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21542);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      this.uYl = new LinkedList();
      AppMethodBeat.o(21542);
      return;
    }
    this.uYl = new LinkedList(paramLinkedList.subList(paramLinkedList.size() * 3 / 4, paramLinkedList.size()));
    this.uYl.addAll(paramLinkedList.subList(0, paramLinkedList.size() * 3 / 4));
    AppMethodBeat.o(21542);
  }
  
  public final void a(int paramInt, long paramLong1, long paramLong2, LinkedList<f.b> paramLinkedList)
  {
    AppMethodBeat.i(21541);
    if (paramInt == 0)
    {
      this.uYk = new LinkedList(paramLinkedList);
      AppMethodBeat.o(21541);
      return;
    }
    if (this.uYk == null) {
      this.uYk = new LinkedList();
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        f.b localb = (f.b)paramLinkedList.next();
        if (d.cWK().cWL().bzD().L(localb.uWu, paramLong1, paramLong2) > 0) {
          this.uYk.add(localb);
        }
      }
      this.uYk.clear();
    }
    AppMethodBeat.o(21541);
  }
  
  public final void cVV()
  {
    this.uYj = null;
    this.uYl = null;
    this.uYk = null;
    this.uYm = false;
  }
  
  public final LinkedList<f.b> cVn()
  {
    AppMethodBeat.i(21539);
    if (this.uYj == null) {
      this.uYj = new LinkedList();
    }
    LinkedList localLinkedList = this.uYj;
    AppMethodBeat.o(21539);
    return localLinkedList;
  }
  
  public final LinkedList<f.b> cVo()
  {
    AppMethodBeat.i(21540);
    if (this.uYk == null) {
      this.uYk = new LinkedList();
    }
    LinkedList localLinkedList = this.uYk;
    AppMethodBeat.o(21540);
    return localLinkedList;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21546);
    Log.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[] { Util.getStack() });
    synchronized (this.lock)
    {
      if (this.uZm != null)
      {
        this.uZm.cancel();
        this.uZm = null;
      }
      this.uYm = false;
      AppMethodBeat.o(21546);
      return;
    }
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(21544);
    Log.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vbn = paramBoolean;
    d.cWK().cWN();
    ThreadPool.post(new a.1(this), "BackupPcChooseServer.calculateToChoose");
    AppMethodBeat.o(21544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a
 * JD-Core Version:    0.7.0.1
 */