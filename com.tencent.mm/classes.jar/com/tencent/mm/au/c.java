package com.tencent.mm.au;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

final class c
  implements ar.b
{
  boolean gTk;
  private long gTv;
  f<String, Integer> hfm;
  Map<String, ar.b.a> hfn;
  Queue<asq> hfo;
  Queue<a> hfp;
  long hfq;
  final int hfr;
  final int hfs;
  av hft;
  final av hfu;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.gTk = false;
    this.hfm = new com.tencent.mm.memory.a.c(200);
    this.hfn = new HashMap();
    this.hfo = new LinkedList();
    this.hfp = new LinkedList();
    this.hfq = 0L;
    this.hfr = 500;
    this.hfs = 10000;
    this.gTv = 0L;
    this.hft = new av(az.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        ad.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.ayc();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.hfu = new av(az.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.hfp.isEmpty())
        {
          ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(20523);
          return false;
        }
        long l1 = bt.eGO();
        int i;
        ArrayList localArrayList;
        int j;
        label67:
        c.a locala;
        final boolean bool;
        if (c.this.gTk)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1059;
          }
          locala = (c.a)c.this.hfp.peek();
          if (locala != null) {
            break label172;
          }
          ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
          bool = false;
        }
        for (;;)
        {
          label104:
          int k = localArrayList.size();
          if (k > 0)
          {
            az.arV();
            long l2 = com.tencent.mm.model.c.afg().rb(Thread.currentThread().getId());
            Object localObject1 = d.aye();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).xW((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.hfC.DsN;
                localObject1 = locala.hfC.DpH;
                Object localObject3 = locala.hfC.DsP;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (cpg)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().lc(((cpg)localObject4).mAQ, ((cpg)localObject4).Ddo);
                    }
                  }
                }
                k = locala.hfD;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  ad.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.hfp.poll();
                  if (c.this.hfp.isEmpty())
                  {
                    ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.hfq = 0L;
                    c.this.hft.av(0L, 0L);
                    bool = false;
                    break label104;
                  }
                  ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (bqj)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = bt.by(z.a(((bqj)localObject2).Dby), "");
                Object localObject4 = bt.by(((bqj)localObject2).ijR, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                switch (m)
                {
                default: 
                  ad.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(q.rS((String)localObject3)) });
                  e.vIY.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new ap(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      ar.b.a locala2 = (ar.b.a)c.this.hfn.remove(this.cNX);
                      if (bt.isNullOrNil(this.hfz)) {}
                      for (ar.b.a locala1 = null;; locala1 = (ar.b.a)c.this.hfn.remove(this.hfz))
                      {
                        if (locala2 != null) {
                          locala2.p(this.cNX, bool);
                        }
                        if ((locala1 != null) && (!bt.isNullOrNil(this.hfz))) {
                          locala1.p(this.hfz, bool);
                        }
                        AppMethodBeat.o(20522);
                        return;
                      }
                    }
                  });
                  locala.hfD += 1;
                  break;
                  if ((locala.hfC.DsO == null) || (locala.hfC.DsO.size() <= k) || (!((String)localObject3).equals(((djy)locala.hfC.DsO.get(k)).username))) {
                    if (locala.hfC.DsO == null)
                    {
                      localObject1 = "null";
                      label732:
                      ad.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = bt.by(((djy)locala.hfC.DsO.get(k)).EzP, ""))
                  {
                    ad.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[] { localObject3, localObject4, localObject1 });
                    com.tencent.mm.plugin.subapp.b.hYu.a((bqj)localObject2, (String)localObject1);
                    e.vIY.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.hfC.DsO.size());
                    break label732;
                  }
                  ad.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.aye().xW((String)localObject3)), Boolean.valueOf(d.aye().xW((String)localObject4)), Boolean.valueOf(q.rS((String)localObject3)) });
                  e.vIY.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            az.arV();
            com.tencent.mm.model.c.afg().mX(l2);
          }
          ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.gTk + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bt.eGO() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1059:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private void ayb()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.aye();
    long l = this.hfq;
    Cursor localCursor = ((b)localObject1).gPa.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(20531);
      return;
    }
    int i = localCursor.getCount();
    ad.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      localCursor.close();
      AppMethodBeat.o(20531);
      return;
    }
    Object localObject2 = new LinkedList();
    localObject1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject3;
    Object localObject4;
    if (localCursor.moveToNext())
    {
      Object localObject6 = new a();
      ((a)localObject6).username = localCursor.getString(0);
      ((a)localObject6).hfj = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).hfk = localCursor.getInt(3);
      ((a)localObject6).gOT = localCursor.getInt(4);
      ((a)localObject6).hfl = localCursor.getInt(5);
      ((a)localObject6).gOV = localCursor.getString(6);
      ((a)localObject6).gOW = localCursor.getString(7);
      localObject3 = ((a)localObject6).getUsername();
      localObject4 = bt.nullAsNil(((a)localObject6).aya());
      i = bt.l(Integer.valueOf(((a)localObject6).hfl));
      Object localObject5 = bt.nullAsNil(((a)localObject6).asv());
      this.hfq = ((a)localObject6).hfj;
      localObject6 = (String)localObject3 + "#" + (String)localObject4;
      int j = bt.a((Integer)this.hfm.aM(localObject6), 0);
      if (j < 3)
      {
        this.hfm.o(localObject6, Integer.valueOf(j + 1));
        if (w.sn((String)localObject3))
        {
          localObject5 = new asq();
          ((LinkedList)localObject2).add(new cmf().aEE((String)localObject3));
          ((LinkedList)localObject1).add(new cmf().aEE((String)localObject4));
          ((asq)localObject5).Cxc = ((LinkedList)localObject2);
          ((asq)localObject5).DsJ = ((LinkedList)localObject1);
          this.hfo.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ad.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.hfo.size()), Integer.valueOf(((asq)localObject5).Cxc.size()), localObject3 });
        }
      }
      for (;;)
      {
        if (((LinkedList)localObject2).size() < 20)
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (!localCursor.isLast()) {}
        }
        else
        {
          localObject5 = new asq();
          ((asq)localObject5).Cxc = ((LinkedList)localObject2);
          ((asq)localObject5).DsF = ((LinkedList)localObject2).size();
          ((asq)localObject5).DsJ = ((LinkedList)localObject1);
          ((asq)localObject5).DsI = ((LinkedList)localObject1).size();
          this.hfo.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ad.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[] { Integer.valueOf(this.hfo.size()), Integer.valueOf(((asq)localObject5).Cxc.size()) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (af.aHH((String)localObject3))
        {
          localObject5 = new asq();
          ((LinkedList)localObject2).add(new cmf().aEE((String)localObject3));
          ((LinkedList)localObject1).add(new cmf().aEE((String)localObject4));
          ((asq)localObject5).Cxc = ((LinkedList)localObject2);
          ((asq)localObject5).DsJ = ((LinkedList)localObject1);
          this.hfo.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ad.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.hfo.size()), Integer.valueOf(((asq)localObject5).Cxc.size()), localObject3 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new cmf().aEE((String)localObject3), new cmf().aEE((String)localObject5)));
          ad.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject3, Integer.valueOf(i), localObject5 });
        }
        else
        {
          ((LinkedList)localObject2).add(new cmf().aEE((String)localObject3));
          ((LinkedList)localObject1).add(new cmf().aEE((String)localObject4));
          ad.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[] { localObject3, localObject4 });
          continue;
          localLinkedList1.add(localObject3);
          P((String)localObject3, false);
        }
      }
    }
    localCursor.close();
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = new asq();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((asq)localObject3).Cxc = ((LinkedList)localObject4);
      ((asq)localObject3).DsF = ((LinkedList)localObject4).size();
      ((asq)localObject3).DsK = 1;
      ((asq)localObject3).DsL = ((cmf)((Pair)localObject2).second);
      this.hfo.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = w.pF((String)localObject1);
      ad.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.aye().xW((String)localObject1);
      }
      boolean bool2 = w.ss((String)localObject1);
      ad.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.aye().xW((String)localObject1);
        e.vIY.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(20531);
  }
  
  private static boolean be(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = u.aqG();
    String str = u.aqH();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      ad.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).gOV = bt.nullAsNil(paramString2);
    ((a)localObject).hfj = bt.eGO();
    boolean bool = d.aye().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  final void P(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20532);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.hfn.containsKey(paramString))
        {
          ar.b.a locala = (ar.b.a)c.this.hfn.get(paramString);
          if (locala != null) {
            locala.p(paramString, paramBoolean);
          }
          c.this.hfn.remove(paramString);
        }
        AppMethodBeat.o(20518);
      }
    });
    AppMethodBeat.o(20532);
  }
  
  public final void a(String paramString1, String paramString2, ar.b.a parama)
  {
    AppMethodBeat.i(20528);
    ad.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bt.eGN());
    if (be(paramString1, paramString2))
    {
      this.hfn.put(paramString1, parama);
      this.hft.av(0L, 0L);
    }
    AppMethodBeat.o(20528);
  }
  
  public final void aB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    ad.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bt.eGN());
    if (be(paramString1, paramString2)) {
      this.hft.av(500L, 500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void aC(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(20527);
    if (bt.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.hft.av(500L, 500L);
      }
      AppMethodBeat.o(20527);
      return;
      Object localObject = u.aqG();
      String str = u.aqH();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        ad.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).gOW = bt.nullAsNil(paramString2);
        ((a)localObject).hfl = bt.l(Integer.valueOf(1));
        ((a)localObject).hfj = bt.eGO();
        bool = d.aye().a((a)localObject);
      }
    }
  }
  
  final void ayc()
  {
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(20533);
        if (com.tencent.mm.plugin.subapp.b.hYu.Ls())
        {
          ad.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
          AppMethodBeat.o(20533);
          return;
        }
        l = bt.eGO();
        if ((this.gTk) && (l - this.gTv > 600000L))
        {
          ad.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.gTv) });
          this.gTk = false;
        }
        if (this.gTk)
        {
          ad.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.gTk + " ret");
          AppMethodBeat.o(20533);
          continue;
        }
        localObject3 = (asq)this.hfo.poll();
      }
      finally {}
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        ayb();
        localObject3 = (asq)this.hfo.poll();
        if ((localObject3 != null) && (((asq)localObject3).Cxc != null))
        {
          localObject2 = localObject3;
          if (((asq)localObject3).Cxc.size() != 0) {}
        }
        else
        {
          ad.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
          AppMethodBeat.o(20533);
          continue;
        }
      }
      this.gTv = l;
      this.gTk = true;
      Object localObject3 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((asq)localObject2).Cxc.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = z.a((cmf)((Iterator)localObject5).next());
        if (w.sn((String)localObject6)) {
          ((LinkedList)localObject3).add(localObject6);
        }
        if (af.aHH((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject3).get(0);
        if (w.sn((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.aEI((String)localObject2).oL((String)localObject2).d(new com.tencent.mm.roomsdk.a.b.b() {}).eDp();
        }
        AppMethodBeat.o(20533);
      }
      else if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new axg();
        ((axg)localObject6).hNH = ((String)localObject5);
        localObject4 = "";
        localObject3 = localObject4;
        if (((asq)localObject2).DsJ != null)
        {
          localObject3 = localObject4;
          if (((asq)localObject2).DsJ.size() > 0) {
            localObject3 = z.a((cmf)((asq)localObject2).DsJ.get(0));
          }
        }
        ((axg)localObject6).dlX = ((String)localObject3);
        localObject2 = new b.a();
        ((b.a)localObject2).gUU = ((com.tencent.mm.bx.a)localObject6);
        ((b.a)localObject2).gUV = new axh();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((b.a)localObject2).funcId = 881;
        ad.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject3, localObject5 });
        x.a(((b.a)localObject2).atI(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousn.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.gTk = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ad.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.hfy });
              if (paramAnonymousInt1 == 4) {
                d.aye().xW(this.hfy);
              }
              c.this.hft.av(10000L, 10000L);
              c.this.P(this.hfy, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.hfo.isEmpty()) && (c.this.hft.eFX())) {
              c.this.hft.av(500L, 500L);
            }
            s.a((axh)paramAnonymousb.gUT.gUX);
            ad.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.aye().xW(this.hfy)), this.hfy });
            c.this.P(this.hfy, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
      }
      else
      {
        localObject3 = new b.a();
        ((b.a)localObject3).gUU = ((com.tencent.mm.bx.a)localObject2);
        ((b.a)localObject3).gUV = new asr();
        ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getcontact";
        ((b.a)localObject3).funcId = 182;
        x.a(((b.a)localObject3).atI(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(20521);
            if (paramAnonymousn.getType() != 182)
            {
              AppMethodBeat.o(20521);
              return 0;
            }
            c.this.gTk = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ad.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " will retry");
              c.this.hft.av(10000L, 10000L);
              AppMethodBeat.o(20521);
              return 0;
            }
            if ((!c.this.hfo.isEmpty()) && (c.this.hft.eFX())) {
              c.this.hft.av(500L, 500L);
            }
            if (paramAnonymousb != null)
            {
              paramAnonymousn = new c.a(c.this);
              paramAnonymousn.errType = paramAnonymousInt1;
              paramAnonymousn.errCode = paramAnonymousInt2;
              paramAnonymousn.errMsg = paramAnonymousString;
              paramAnonymousn.hfC = ((asr)paramAnonymousb.gUT.gUX);
              c.this.hfp.add(paramAnonymousn);
            }
            if ((!c.this.hfp.isEmpty()) && (c.this.hfu.eFX())) {
              c.this.hfu.av(50L, 50L);
            }
            AppMethodBeat.o(20521);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
      }
    }
  }
  
  public final void tX(String paramString)
  {
    AppMethodBeat.i(20525);
    this.hfn.remove(paramString);
    AppMethodBeat.o(20525);
  }
  
  public final void tY(final String paramString)
  {
    AppMethodBeat.i(20529);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.hfm.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            ad.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.hfm.remove(str);
          }
          i += 1;
        }
        AppMethodBeat.o(20516);
      }
    });
    AppMethodBeat.o(20529);
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    asr hfC;
    int hfD = 0;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.au.c
 * JD-Core Version:    0.7.0.1
 */