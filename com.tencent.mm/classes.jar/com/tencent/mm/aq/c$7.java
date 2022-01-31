package com.tencent.mm.aq;

import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.cdf;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

final class c$7
  implements am.a
{
  c$7(c paramc) {}
  
  public final boolean tC()
  {
    if (this.emx.emr.isEmpty())
    {
      y.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
      return false;
    }
    long l1 = bk.UY();
    int i;
    ArrayList localArrayList;
    int j;
    label55:
    c.a locala;
    boolean bool;
    if (this.emx.ebb)
    {
      i = 5;
      localArrayList = new ArrayList(i * 2);
      j = 0;
      if (j >= i) {
        break label895;
      }
      locala = (c.a)this.emx.emr.peek();
      if (locala != null) {
        break label160;
      }
      y.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
      bool = false;
    }
    for (;;)
    {
      label92:
      int k = localArrayList.size();
      if (k > 0)
      {
        au.Hx();
        long l2 = com.tencent.mm.model.c.Dv().eV(Thread.currentThread().getId());
        Object localObject1 = d.Oo();
        j = 0;
        for (;;)
        {
          if (j < k)
          {
            ((b)localObject1).lU((String)localArrayList.get(j));
            j += 1;
            continue;
            i = 15;
            break;
            label160:
            Object localObject2 = locala.emE.tcB;
            localObject1 = locala.emE.tcC;
            k = locala.emF;
            int m = ((LinkedList)localObject2).size();
            if (m <= k)
            {
              this.emx.emr.poll();
              if (this.emx.emr.isEmpty())
              {
                y.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                this.emx.ems = 0L;
                this.emx.emv.S(0L, 0L);
                bool = false;
                break label92;
              }
              y.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              j += 1;
              break label55;
            }
            localObject2 = (axd)((LinkedList)localObject2).get(k);
            m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
            String str1 = bk.aM(aa.a(((axd)localObject2).sQs), "");
            String str2 = bk.aM(((axd)localObject2).ffm, "");
            localArrayList.add(str1);
            localArrayList.add(str2);
            switch (m)
            {
            default: 
              y.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), str1, str2, Boolean.valueOf(m.gG(str1)) });
              f.nEG.a(832L, 2L, 1L, false);
              bool = false;
            }
            for (;;)
            {
              new ah(Looper.getMainLooper()).post(new c.7.1(this, str1, str2, bool));
              locala.emF += 1;
              break;
              if ((locala.emE.tcD == null) || (locala.emE.tcD.size() <= k) || (!str1.equals(((cdf)locala.emE.tcD.get(k)).username))) {
                if (locala.emE.tcD == null)
                {
                  localObject1 = "null";
                  label575:
                  y.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), str1 });
                }
              }
              for (localObject1 = "";; localObject1 = bk.aM(((cdf)locala.emE.tcD.get(k)).tSe, ""))
              {
                y.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[] { str1, str2, localObject1 });
                com.tencent.mm.plugin.subapp.b.eUS.a((axd)localObject2, (String)localObject1);
                f.nEG.a(832L, 0L, 1L, false);
                bool = true;
                break;
                localObject1 = Integer.valueOf(locala.emE.tcD.size());
                break label575;
              }
              y.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), str1, str2, Boolean.valueOf(d.Oo().lU(str1)), Boolean.valueOf(d.Oo().lU(str2)), Boolean.valueOf(m.gG(str1)) });
              f.nEG.a(832L, 1L, 1L, false);
              bool = false;
            }
          }
        }
        au.Hx();
        com.tencent.mm.model.c.Dv().hI(l2);
      }
      y.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.emx.ebb + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bk.UY() - l1) + "ms");
      return bool;
      label895:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.c.7
 * JD-Core Version:    0.7.0.1
 */