package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

final class c$1
  implements Runnable
{
  c$1(c paramc, LinkedList paramLinkedList, long paramLong, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.hGh == null)
    {
      y.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
      if (this.hGk.hGd != null)
      {
        this.hGk.hGd.atk();
        this.hGk.hGe.atn().hFu = -21;
        this.hGk.hGd.nt(-21);
      }
      return;
    }
    com.tencent.mm.plugin.backup.g.b.auN();
    Object localObject2 = this.hGh;
    Object localObject1 = new HashSet();
    if (localObject2 == null) {}
    for (int i = 0;; i = ((HashSet)localObject1).size())
    {
      this.hGk.hGe.atn().B(14, 1, i);
      this.hGk.hGd.nt(14);
      localObject1 = (String)com.tencent.mm.plugin.backup.h.d.avi().avj().Dz().get(2, null);
      this.hGk.hGg = bk.UY();
      localObject2 = new c.c(this.hGk);
      Iterator localIterator = this.hGh.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        f.a locala = (f.a)localIterator.next();
        this.hGk.a(locala, (c.c)localObject2, (String)localObject1, this.hGi, this.hGj);
      } while (!this.hGk.hGc);
      if (!this.hGk.hGc) {
        break;
      }
      y.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
      return;
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).hFB);
      }
    }
    long l1 = bk.UY();
    long l2 = bk.UY();
    ((c.c)localObject2).hGJ.offer(((c.c)localObject2).hGK);
    ((c.c)localObject2).hGK.block();
    y.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(bk.co(l2)) });
    Assert.assertTrue(((c.c)localObject2).hGJ.isEmpty());
    y.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(this.hGh.size()), Long.valueOf(bk.co(this.hGk.hGg)), Long.valueOf(bk.co(l1)) });
    this.hGk.atC();
    this.hGk.hGe.atn().B(15, i, i);
    this.hGk.hGd.nt(15);
    this.hGk.ea(true);
    com.tencent.mm.plugin.backup.g.b.auM();
    com.tencent.mm.plugin.backup.g.b.auO();
    this.hGk.hGd.atj();
    y.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(this.hGk.hGf), Long.valueOf(bk.co(this.hGk.hGg)), Long.valueOf(this.hGk.hGg) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.1
 * JD-Core Version:    0.7.0.1
 */