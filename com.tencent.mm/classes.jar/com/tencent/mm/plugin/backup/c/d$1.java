package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.y;
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
    e.reset();
    e.atN();
    d.a(this.hHe).begin();
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = d.b(this.hHe).keySet().iterator();
    for (;;)
    {
      label212:
      long l;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        d.atI();
        Object localObject2 = g.xo(str) + str;
        if (b.cqk())
        {
          d.a(this.hHe, (String)localObject2, (HashMap)localObject1, localHashMap);
          if (d.c(this.hHe))
          {
            y.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", new Object[] { str, Long.valueOf(d.d(this.hHe)), Integer.valueOf(d.e(this.hHe)) });
            d.atJ();
            d.a(this.hHe).end();
            com.tencent.mm.plugin.backup.h.c.k((HashMap)localObject1);
            d.a(this.hHe, d.f(this.hHe), d.g(this.hHe));
          }
        }
        else
        {
          try
          {
            d.a(this.hHe, (String)localObject2, (HashMap)localObject1, localHashMap);
            if (!d.c(this.hHe)) {
              break label337;
            }
            y.e("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp Thread has been canceled, msgDataId[%s], transferMsgList[%d], recovering session num[%d]", new Object[] { str, Long.valueOf(d.d(this.hHe)), Integer.valueOf(d.e(this.hHe)) });
            d.atJ();
            d.a(this.hHe).end();
            com.tencent.mm.plugin.backup.h.c.k((HashMap)localObject1);
            d.a(this.hHe, d.f(this.hHe), d.g(this.hHe));
            return;
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.BackupRecoverMerger", localException, "recoverFromSdcard MMThread.run():", new Object[0]);
          }
          continue;
        }
        label337:
        d.h(this.hHe).add(d.b(this.hHe).get(localException));
        d.i(this.hHe);
        d.j(this.hHe).atn().hFu = 26;
        localObject2 = d.j(this.hHe).atn();
        if (d.d(this.hHe) > d.k(this.hHe))
        {
          l = 100L;
          label417:
          ((com.tencent.mm.plugin.backup.b.e)localObject2).hFx = ((int)l);
          this.hHe.nv(26);
          d.a(this.hHe).atL();
          d.atJ();
        }
      }
      try
      {
        Thread.sleep(10L);
        label452:
        y.i("MicroMsg.BackupRecoverMerger", "msgDataId[%s] merge finish, transferMsgList[%d], transferSessions size[%d]", new Object[] { localException, Long.valueOf(d.d(this.hHe)), Integer.valueOf(d.h(this.hHe).size()) });
        continue;
        l = d.d(this.hHe) * 100L / d.k(this.hHe);
        break label417;
        this.hHe.nv(30);
        com.tencent.mm.plugin.backup.h.c.k((HashMap)localObject1);
        y.i("MicroMsg.BackupRecoverMerger", "readFromSdcard build temDB finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", new Object[] { Long.valueOf(d.d(this.hHe)), Long.valueOf(d.k(this.hHe)), Integer.valueOf(d.h(this.hHe).size()), Integer.valueOf(d.e(this.hHe)) });
        d.a(this.hHe).end();
        if (b.cqk())
        {
          localObject1 = d.j(this.hHe).atn();
          if (d.h(this.hHe).size() > d.e(this.hHe))
          {
            i = d.e(this.hHe);
            ((com.tencent.mm.plugin.backup.b.e)localObject1).hFv = i;
            localObject1 = d.j(this.hHe).atn();
            if (d.d(this.hHe) <= d.k(this.hHe)) {
              break label940;
            }
            l = 100L;
            label699:
            ((com.tencent.mm.plugin.backup.b.e)localObject1).hFx = ((int)l);
            label706:
            d.j(this.hHe).atn().hFw = d.e(this.hHe);
            y.cqL();
            if (d.l(this.hHe) == d.access$1400()) {
              break label212;
            }
            d.a(this.hHe, d.access$1400());
            d.atH();
            y.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp backupRecoverCloseTempDb merge success, restart sync");
            if (d.m(this.hHe) != 1) {
              break label1019;
            }
            au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.uuo, Boolean.valueOf(false));
            label791:
            if (d.n(this.hHe) != null) {
              d.n(this.hHe).atm();
            }
            au.Hx().Gd().ctu();
            au.Hx().Ge().ctu();
            localObject1 = d.j(this.hHe).atn();
            if (d.h(this.hHe).size() <= d.e(this.hHe)) {
              break label1050;
            }
          }
        }
        label1050:
        for (int i = d.e(this.hHe);; i = d.h(this.hHe).size())
        {
          ((com.tencent.mm.plugin.backup.b.e)localObject1).B(27, i, d.e(this.hHe));
          this.hHe.nv(27);
          d.a(this.hHe, d.atK());
          d.o(this.hHe);
          d.j(this.hHe).atp();
          return;
          i = d.h(this.hHe).size();
          break;
          label940:
          l = d.d(this.hHe) * 100L / d.k(this.hHe);
          break label699;
          d.j(this.hHe).atn().hFv = d.e(this.hHe);
          d.j(this.hHe).atn().hFx = ((int)(d.d(this.hHe) * 100L / d.k(this.hHe)));
          break label706;
          label1019:
          if (d.m(this.hHe) != 2) {
            break label791;
          }
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uur, Boolean.valueOf(false));
          break label791;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label452;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d.1
 * JD-Core Version:    0.7.0.1
 */