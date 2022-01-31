package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(17198);
    e.reset();
    e.aTl();
    d.a(this.jAA).begin();
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = d.b(this.jAA).keySet().iterator();
    for (;;)
    {
      long l1;
      label357:
      long l2;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        d.aTg();
        Object localObject2 = g.Gg(str) + str;
        if (b.dsf())
        {
          l1 = d.a(this.jAA, (String)localObject2, (HashMap)localObject1, localHashMap);
          if (d.c(this.jAA))
          {
            ab.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", new Object[] { str, Long.valueOf(d.d(this.jAA)), Integer.valueOf(d.e(this.jAA)) });
            d.aTh();
            d.a(this.jAA).end();
            com.tencent.mm.plugin.backup.h.c.k((HashMap)localObject1);
            d.a(this.jAA, d.f(this.jAA), d.g(this.jAA));
            AppMethodBeat.o(17198);
          }
        }
        else
        {
          try
          {
            l1 = d.a(this.jAA, (String)localObject2, (HashMap)localObject1, localHashMap);
            if (!d.c(this.jAA)) {
              break label357;
            }
            ab.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", new Object[] { str, Long.valueOf(d.d(this.jAA)), Integer.valueOf(d.e(this.jAA)) });
            d.aTh();
            d.a(this.jAA).end();
            com.tencent.mm.plugin.backup.h.c.k((HashMap)localObject1);
            d.a(this.jAA, d.f(this.jAA), d.g(this.jAA));
            AppMethodBeat.o(17198);
            return;
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.BackupRecoverMerger", localException, "recoverFromSdcard MMThread.run():", new Object[0]);
          }
          continue;
        }
        d.a(this.jAA, d.h(this.jAA) + l1);
        d.i(this.jAA).add(d.b(this.jAA).get(localException));
        d.j(this.jAA);
        d.k(this.jAA).aSL().jyN = 26;
        localObject2 = d.k(this.jAA).aSL();
        if (d.d(this.jAA) > d.l(this.jAA))
        {
          l2 = 100L;
          label455:
          ((com.tencent.mm.plugin.backup.b.e)localObject2).jyQ = ((int)l2);
          this.jAA.rh(26);
          d.a(this.jAA).aTj();
          d.aTh();
        }
      }
      try
      {
        Thread.sleep(10L);
        label491:
        ab.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferMsgList[%d], transferSessions size[%d], msgListMsgCount:%d, receiveMsgCount:%d", new Object[] { localException, Long.valueOf(d.d(this.jAA)), Integer.valueOf(d.i(this.jAA).size()), Long.valueOf(l1), Long.valueOf(d.h(this.jAA)) });
        continue;
        l2 = d.d(this.jAA) * 100L / d.l(this.jAA);
        break label455;
        d.k(this.jAA).aSL().jyX = d.h(this.jAA);
        this.jAA.rh(30);
        com.tencent.mm.plugin.backup.h.c.k((HashMap)localObject1);
        ab.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", new Object[] { Long.valueOf(d.d(this.jAA)), Long.valueOf(d.l(this.jAA)), Integer.valueOf(d.i(this.jAA).size()), Integer.valueOf(d.e(this.jAA)) });
        d.a(this.jAA).end();
        if (b.dsf())
        {
          localObject1 = d.k(this.jAA).aSL();
          if (d.i(this.jAA).size() > d.e(this.jAA))
          {
            i = d.e(this.jAA);
            ((com.tencent.mm.plugin.backup.b.e)localObject1).jyO = i;
            localObject1 = d.k(this.jAA).aSL();
            if (d.d(this.jAA) <= d.l(this.jAA)) {
              break label1026;
            }
            l1 = 100L;
            label779:
            ((com.tencent.mm.plugin.backup.b.e)localObject1).jyQ = ((int)l1);
            label786:
            d.k(this.jAA).aSL().jyP = d.e(this.jAA);
            ab.dsI();
            if (d.m(this.jAA) != d.access$1500())
            {
              d.a(this.jAA, d.access$1500());
              d.aTf();
              ab.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
              if (d.n(this.jAA) != 1) {
                break label1105;
              }
              aw.aaz();
              com.tencent.mm.model.c.Ru().set(ac.a.yEr, Boolean.FALSE);
              label871:
              if (d.o(this.jAA) != null) {
                d.o(this.jAA).aSK();
              }
              aw.aaz().Ze().dvQ();
              aw.aaz().Zf().dvQ();
              localObject1 = d.k(this.jAA).aSL();
              if (d.i(this.jAA).size() <= d.e(this.jAA)) {
                break label1135;
              }
            }
          }
        }
        label1026:
        label1105:
        label1135:
        for (int i = d.e(this.jAA);; i = d.i(this.jAA).size())
        {
          ((com.tencent.mm.plugin.backup.b.e)localObject1).N(27, i, d.e(this.jAA));
          this.jAA.rh(27);
          d.a(this.jAA, d.aTi());
          d.p(this.jAA);
          d.k(this.jAA).aSN();
          AppMethodBeat.o(17198);
          return;
          i = d.i(this.jAA).size();
          break;
          l1 = d.d(this.jAA) * 100L / d.l(this.jAA);
          break label779;
          d.k(this.jAA).aSL().jyO = d.e(this.jAA);
          d.k(this.jAA).aSL().jyQ = ((int)(d.d(this.jAA) * 100L / d.l(this.jAA)));
          break label786;
          if (d.n(this.jAA) != 2) {
            break label871;
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yEu, Boolean.FALSE);
          break label871;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label491;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d.1
 * JD-Core Version:    0.7.0.1
 */