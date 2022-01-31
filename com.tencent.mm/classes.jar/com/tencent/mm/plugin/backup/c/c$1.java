package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(17174);
    if (this.jzD == null)
    {
      ab.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
      if (this.jzG.jzz != null)
      {
        this.jzG.jzz.aSI();
        this.jzG.jzA.aSL().jyN = -21;
        this.jzG.jzz.rf(-21);
      }
      AppMethodBeat.o(17174);
      return;
    }
    com.tencent.mm.plugin.backup.g.b.aUp();
    Object localObject2 = this.jzD;
    Object localObject1 = new HashSet();
    if (localObject2 == null) {}
    for (int i = 0;; i = ((HashSet)localObject1).size())
    {
      this.jzG.jzA.aSL().N(14, 1, i);
      this.jzG.jzz.rf(14);
      localObject1 = (String)com.tencent.mm.plugin.backup.h.d.aUK().aUL().Ru().get(2, null);
      this.jzG.jzC = bo.aoy();
      localObject2 = new c.c(this.jzG);
      Iterator localIterator = this.jzD.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        f.a locala = (f.a)localIterator.next();
        this.jzG.a(locala, (c.c)localObject2, (String)localObject1, this.jzE, this.jzF);
      } while (!this.jzG.jzy);
      if (!this.jzG.jzy) {
        break;
      }
      ab.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
      AppMethodBeat.o(17174);
      return;
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(((f.a)((Iterator)localObject2).next()).jyY);
      }
    }
    long l1 = bo.aoy();
    long l2 = bo.aoy();
    ((c.c)localObject2).jAf.offer(((c.c)localObject2).jAg);
    ((c.c)localObject2).jAg.block();
    ab.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[] { Long.valueOf(bo.hl(l2)) });
    Assert.assertTrue(((c.c)localObject2).jAf.isEmpty());
    ab.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[] { Integer.valueOf(this.jzD.size()), Long.valueOf(bo.hl(this.jzG.jzC)), Long.valueOf(bo.hl(l1)) });
    this.jzG.aTa();
    this.jzG.jzA.aSL().N(15, i, i);
    this.jzG.jzz.rf(15);
    this.jzG.fx(true);
    com.tencent.mm.plugin.backup.g.b.aUo();
    com.tencent.mm.plugin.backup.g.b.aUq();
    this.jzG.jzz.aSH();
    ab.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[] { Long.valueOf(this.jzG.jzB), Long.valueOf(bo.hl(this.jzG.jzC)), Long.valueOf(this.jzG.jzC) });
    AppMethodBeat.o(17174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.1
 * JD-Core Version:    0.7.0.1
 */