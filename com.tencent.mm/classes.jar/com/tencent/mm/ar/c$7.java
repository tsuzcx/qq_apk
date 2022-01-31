package com.tencent.mm.ar;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

final class c$7
  implements ap.a
{
  c$7(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(16477);
    if (this.fCU.fCO.isEmpty())
    {
      ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
      AppMethodBeat.o(16477);
      return false;
    }
    long l1 = bo.aoy();
    int i;
    ArrayList localArrayList;
    int j;
    label67:
    c.a locala;
    boolean bool;
    if (this.fCU.frp)
    {
      i = 5;
      localArrayList = new ArrayList(i * 2);
      j = 0;
      if (j >= i) {
        break label971;
      }
      locala = (c.a)this.fCU.fCO.peek();
      if (locala != null) {
        break label172;
      }
      ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
      bool = false;
    }
    for (;;)
    {
      label104:
      int k = localArrayList.size();
      if (k > 0)
      {
        aw.aaz();
        long l2 = com.tencent.mm.model.c.Rq().kr(Thread.currentThread().getId());
        Object localObject1 = d.ahd();
        j = 0;
        for (;;)
        {
          if (j < k)
          {
            ((b)localObject1).sT((String)localArrayList.get(j));
            j += 1;
            continue;
            i = 15;
            break;
            label172:
            Object localObject2 = locala.fDb.xaT;
            localObject1 = locala.fDb.xaU;
            k = locala.fDc;
            if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
              ab.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
            }
            int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
            if (m <= k)
            {
              this.fCU.fCO.poll();
              if (this.fCU.fCO.isEmpty())
              {
                ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                this.fCU.fCP = 0L;
                this.fCU.fCS.ag(0L, 0L);
                bool = false;
                break label104;
              }
              ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              j += 1;
              break label67;
            }
            localObject2 = (bdt)((LinkedList)localObject2).get(k);
            m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
            String str1 = bo.bf(aa.a(((bdt)localObject2).wOT), "");
            String str2 = bo.bf(((bdt)localObject2).gwU, "");
            localArrayList.add(str1);
            localArrayList.add(str2);
            switch (m)
            {
            default: 
              ab.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), str1, str2, Boolean.valueOf(n.np(str1)) });
              e.qrI.idkeyStat(832L, 2L, 1L, false);
              bool = false;
            }
            for (;;)
            {
              new ak(Looper.getMainLooper()).post(new c.7.1(this, str1, str2, bool));
              locala.fDc += 1;
              break;
              if ((locala.fDb.xaV == null) || (locala.fDb.xaV.size() <= k) || (!str1.equals(((cqm)locala.fDb.xaV.get(k)).username))) {
                if (locala.fDb.xaV == null)
                {
                  localObject1 = "null";
                  label644:
                  ab.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), str1 });
                }
              }
              for (localObject1 = "";; localObject1 = bo.bf(((cqm)locala.fDb.xaV.get(k)).xZd, ""))
              {
                ab.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[] { str1, str2, localObject1 });
                com.tencent.mm.plugin.subapp.b.gmP.a((bdt)localObject2, (String)localObject1);
                e.qrI.idkeyStat(832L, 0L, 1L, false);
                bool = true;
                break;
                localObject1 = Integer.valueOf(locala.fDb.xaV.size());
                break label644;
              }
              ab.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), str1, str2, Boolean.valueOf(d.ahd().sT(str1)), Boolean.valueOf(d.ahd().sT(str2)), Boolean.valueOf(n.np(str1)) });
              e.qrI.idkeyStat(832L, 1L, 1L, false);
              bool = false;
            }
          }
        }
        aw.aaz();
        com.tencent.mm.model.c.Rq().nY(l2);
      }
      ab.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.fCU.frp + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bo.aoy() - l1) + "ms");
      AppMethodBeat.o(16477);
      return bool;
      label971:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ar.c.7
 * JD-Core Version:    0.7.0.1
 */