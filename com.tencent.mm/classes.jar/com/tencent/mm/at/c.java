package com.tencent.mm.at;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
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
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  f<String, Integer> hFP;
  Queue<avu> hFR;
  Queue<a> hFS;
  long hFT;
  final int hFU;
  final int hFV;
  au hFW;
  final au hFX;
  boolean htJ;
  private long htU;
  Map<String, LinkedList<ar.b.a>> jsb;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.htJ = false;
    this.hFP = new com.tencent.mm.memory.a.c(200);
    this.jsb = new HashMap();
    this.hFR = new LinkedList();
    this.hFS = new LinkedList();
    this.hFT = 0L;
    this.hFU = 500;
    this.hFV = 10000;
    this.htU = 0L;
    this.hFW = new au(az.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        ac.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.aEU();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.hFX = new au(az.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.hFS.isEmpty())
        {
          ac.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(20523);
          return false;
        }
        long l1 = bs.eWj();
        int i;
        ArrayList localArrayList;
        int j;
        label67:
        c.a locala;
        final boolean bool;
        if (c.this.htJ)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1059;
          }
          locala = (c.a)c.this.hFS.peek();
          if (locala != null) {
            break label172;
          }
          ac.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
          bool = false;
        }
        for (;;)
        {
          label104:
          int k = localArrayList.size();
          if (k > 0)
          {
            az.ayM();
            long l2 = com.tencent.mm.model.c.agw().vE(Thread.currentThread().getId());
            Object localObject1 = d.aEW();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).Cb((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.hGf.ENR;
                localObject1 = locala.hGf.EKK;
                Object localObject3 = locala.hGf.ENT;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (cun)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().lz(((cun)localObject4).ncR, ((cun)localObject4).Ewu);
                    }
                  }
                }
                k = locala.hGg;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  ac.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.hFS.poll();
                  if (c.this.hFS.isEmpty())
                  {
                    ac.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.hFT = 0L;
                    c.this.hFW.au(0L, 0L);
                    bool = false;
                    break label104;
                  }
                  ac.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (bva)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = bs.bG(z.a(((bva)localObject2).EuE), "");
                Object localObject4 = bs.bG(((bva)localObject2).iJY, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                switch (m)
                {
                default: 
                  ac.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(q.vV((String)localObject3)) });
                  e.wTc.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new ao(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      ac.i("MicroMsg.GetContactService", "callback user:%s alias:%s", new Object[] { bs.bG(this.cLs, ""), bs.bG(this.hGc, "") });
                      try
                      {
                        Object localObject2 = (LinkedList)c.this.jsb.remove(this.cLs);
                        if (bs.isNullOrNil(this.hGc)) {}
                        for (LinkedList localLinkedList = null;; localLinkedList = (LinkedList)c.this.jsb.remove(this.hGc))
                        {
                          if (localObject2 == null) {
                            break;
                          }
                          ac.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", new Object[] { bs.bG(this.cLs, ""), Integer.valueOf(((LinkedList)localObject2).size()) });
                          localObject2 = ((LinkedList)localObject2).iterator();
                          while (((Iterator)localObject2).hasNext()) {
                            ((ar.b.a)((Iterator)localObject2).next()).p(this.cLs, bool);
                          }
                        }
                        if (localObject1 == null) {
                          break label269;
                        }
                      }
                      finally
                      {
                        AppMethodBeat.o(20522);
                      }
                      ac.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", new Object[] { bs.bG(this.cLs, ""), Integer.valueOf(localObject1.size()) });
                      Iterator localIterator = localObject1.iterator();
                      while (localIterator.hasNext()) {
                        ((ar.b.a)localIterator.next()).p(this.cLs, bool);
                      }
                      label269:
                      AppMethodBeat.o(20522);
                    }
                  });
                  locala.hGg += 1;
                  break;
                  if ((locala.hGf.ENS == null) || (locala.hGf.ENS.size() <= k) || (!((String)localObject3).equals(((dpn)locala.hGf.ENS.get(k)).username))) {
                    if (locala.hGf.ENS == null)
                    {
                      localObject1 = "null";
                      label732:
                      ac.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = bs.bG(((dpn)locala.hGf.ENS.get(k)).FWT, ""))
                  {
                    ac.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[] { localObject3, localObject4, localObject1 });
                    com.tencent.mm.plugin.subapp.b.iyy.a((bva)localObject2, (String)localObject1);
                    e.wTc.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.hGf.ENS.size());
                    break label732;
                  }
                  ac.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.aEW().Cb((String)localObject3)), Boolean.valueOf(d.aEW().Cb((String)localObject4)), Boolean.valueOf(q.vV((String)localObject3)) });
                  e.wTc.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            az.ayM();
            com.tencent.mm.model.c.agw().qL(l2);
          }
          ac.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.htJ + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bs.eWj() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1059:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private void aET()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.aEW();
    long l = this.hFT;
    Cursor localCursor = ((b)localObject1).hpA.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(20531);
      return;
    }
    int i = localCursor.getCount();
    ac.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
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
      ((a)localObject6).hFM = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).hFN = localCursor.getInt(3);
      ((a)localObject6).hpt = localCursor.getInt(4);
      ((a)localObject6).hFO = localCursor.getInt(5);
      ((a)localObject6).hpv = localCursor.getString(6);
      ((a)localObject6).hpw = localCursor.getString(7);
      localObject3 = ((a)localObject6).getUsername();
      localObject4 = bs.nullAsNil(((a)localObject6).aES());
      i = bs.m(Integer.valueOf(((a)localObject6).hFO));
      Object localObject5 = bs.nullAsNil(((a)localObject6).azm());
      this.hFT = ((a)localObject6).hFM;
      localObject6 = (String)localObject3 + "#" + (String)localObject4;
      int j = bs.a((Integer)this.hFP.aJ(localObject6), 0);
      if (j < 3)
      {
        this.hFP.o(localObject6, Integer.valueOf(j + 1));
        if (w.wq((String)localObject3))
        {
          localObject5 = new avu();
          ((LinkedList)localObject2).add(new crm().aJV((String)localObject3));
          ((LinkedList)localObject1).add(new crm().aJV((String)localObject4));
          ((avu)localObject5).DPy = ((LinkedList)localObject2);
          ((avu)localObject5).ENN = ((LinkedList)localObject1);
          this.hFR.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ac.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.hFR.size()), Integer.valueOf(((avu)localObject5).DPy.size()), localObject3 });
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
          localObject5 = new avu();
          ((avu)localObject5).DPy = ((LinkedList)localObject2);
          ((avu)localObject5).ENJ = ((LinkedList)localObject2).size();
          ((avu)localObject5).ENN = ((LinkedList)localObject1);
          ((avu)localObject5).ENM = ((LinkedList)localObject1).size();
          this.hFR.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ac.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[] { Integer.valueOf(this.hFR.size()), Integer.valueOf(((avu)localObject5).DPy.size()) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (ai.aNc((String)localObject3))
        {
          localObject5 = new avu();
          ((LinkedList)localObject2).add(new crm().aJV((String)localObject3));
          ((LinkedList)localObject1).add(new crm().aJV((String)localObject4));
          ((avu)localObject5).DPy = ((LinkedList)localObject2);
          ((avu)localObject5).ENN = ((LinkedList)localObject1);
          this.hFR.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ac.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.hFR.size()), Integer.valueOf(((avu)localObject5).DPy.size()), localObject3 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new crm().aJV((String)localObject3), new crm().aJV((String)localObject5)));
          ac.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject3, Integer.valueOf(i), localObject5 });
        }
        else
        {
          ((LinkedList)localObject2).add(new crm().aJV((String)localObject3));
          ((LinkedList)localObject1).add(new crm().aJV((String)localObject4));
          ac.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[] { localObject3, localObject4 });
          continue;
          localLinkedList1.add(localObject3);
          Q((String)localObject3, false);
        }
      }
    }
    localCursor.close();
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = new avu();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((avu)localObject3).DPy = ((LinkedList)localObject4);
      ((avu)localObject3).ENJ = ((LinkedList)localObject4).size();
      ((avu)localObject3).ENO = 1;
      ((avu)localObject3).ENP = ((crm)((Pair)localObject2).second);
      this.hFR.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = w.sQ((String)localObject1);
      ac.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.aEW().Cb((String)localObject1);
      }
      boolean bool2 = w.wv((String)localObject1);
      ac.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.aEW().Cb((String)localObject1);
        e.wTc.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(20531);
  }
  
  private static boolean bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = u.axw();
    String str = u.axx();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      ac.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).hpv = bs.nullAsNil(paramString2);
    ((a)localObject).hFM = bs.eWj();
    boolean bool = d.aEW().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  final void Q(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20532);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.jsb.containsKey(paramString)) {
          try
          {
            Object localObject1 = (LinkedList)c.this.jsb.get(paramString);
            c.this.jsb.remove(paramString);
            if (localObject1 != null)
            {
              localObject1 = ((LinkedList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((ar.b.a)((Iterator)localObject1).next()).p(paramString, paramBoolean);
              }
            }
            AppMethodBeat.o(20518);
          }
          finally
          {
            AppMethodBeat.o(20518);
          }
        }
      }
    });
    AppMethodBeat.o(20532);
  }
  
  public final void a(String paramString1, String paramString2, ar.b.a parama)
  {
    AppMethodBeat.i(20528);
    ac.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bs.eWi());
    if (bm(paramString1, paramString2))
    {
      if (parama != null) {
        break label100;
      }
      ac.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", new Object[] { bs.bG(paramString1, "") });
    }
    for (;;)
    {
      this.hFW.au(0L, 0L);
      AppMethodBeat.o(20528);
      return;
      try
      {
        label100:
        Object localObject = (LinkedList)this.jsb.get(paramString1);
        paramString2 = (String)localObject;
        if (localObject == null)
        {
          localObject = this.jsb;
          paramString2 = new LinkedList();
          ((Map)localObject).put(paramString1, paramString2);
        }
        if (paramString2.contains(parama)) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(20528);
      }
      paramString2.add(parama);
    }
  }
  
  final void aEU()
  {
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(20533);
        if (com.tencent.mm.plugin.subapp.b.iyy.Lq())
        {
          ac.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
          AppMethodBeat.o(20533);
          return;
        }
        l = bs.eWj();
        if ((this.htJ) && (l - this.htU > 600000L))
        {
          ac.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.htU) });
          this.htJ = false;
        }
        if (this.htJ)
        {
          ac.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.htJ + " ret");
          AppMethodBeat.o(20533);
          continue;
        }
        localObject3 = (avu)this.hFR.poll();
      }
      finally {}
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        aET();
        localObject3 = (avu)this.hFR.poll();
        if ((localObject3 != null) && (((avu)localObject3).DPy != null))
        {
          localObject2 = localObject3;
          if (((avu)localObject3).DPy.size() != 0) {}
        }
        else
        {
          ac.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
          AppMethodBeat.o(20533);
          continue;
        }
      }
      this.htU = l;
      this.htJ = true;
      Object localObject3 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((avu)localObject2).DPy.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = z.a((crm)((Iterator)localObject5).next());
        if (w.wq((String)localObject6)) {
          ((LinkedList)localObject3).add(localObject6);
        }
        if (ai.aNc((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject3).get(0);
        if (w.wq((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.aJZ((String)localObject2).rU((String)localObject2).d(new com.tencent.mm.roomsdk.a.b.b() {}).csU();
        }
        AppMethodBeat.o(20533);
      }
      else if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new bay();
        ((bay)localObject6).iod = ((String)localObject5);
        localObject4 = "";
        localObject3 = localObject4;
        if (((avu)localObject2).ENN != null)
        {
          localObject3 = localObject4;
          if (((avu)localObject2).ENN.size() > 0) {
            localObject3 = z.a((crm)((avu)localObject2).ENN.get(0));
          }
        }
        ((bay)localObject6).djF = ((String)localObject3);
        localObject2 = new b.a();
        ((b.a)localObject2).hvt = ((com.tencent.mm.bw.a)localObject6);
        ((b.a)localObject2).hvu = new baz();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((b.a)localObject2).funcId = 881;
        ac.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject3, localObject5 });
        x.a(((b.a)localObject2).aAz(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousn.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.htJ = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ac.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.hGb });
              if (paramAnonymousInt1 == 4) {
                d.aEW().Cb(this.hGb);
              }
              c.this.hFW.au(10000L, 10000L);
              c.this.Q(this.hGb, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.hFR.isEmpty()) && (c.this.hFW.eVs())) {
              c.this.hFW.au(500L, 500L);
            }
            s.a((baz)paramAnonymousb.hvs.hvw);
            ac.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.aEW().Cb(this.hGb)), this.hGb });
            c.this.Q(this.hGb, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
      }
      else
      {
        localObject3 = new b.a();
        ((b.a)localObject3).hvt = ((com.tencent.mm.bw.a)localObject2);
        ((b.a)localObject3).hvu = new avv();
        ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getcontact";
        ((b.a)localObject3).funcId = 182;
        x.a(((b.a)localObject3).aAz(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(20521);
            if (paramAnonymousn.getType() != 182)
            {
              AppMethodBeat.o(20521);
              return 0;
            }
            c.this.htJ = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ac.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " will retry");
              c.this.hFW.au(10000L, 10000L);
              AppMethodBeat.o(20521);
              return 0;
            }
            if ((!c.this.hFR.isEmpty()) && (c.this.hFW.eVs())) {
              c.this.hFW.au(500L, 500L);
            }
            if (paramAnonymousb != null)
            {
              paramAnonymousn = new c.a(c.this);
              paramAnonymousn.errType = paramAnonymousInt1;
              paramAnonymousn.errCode = paramAnonymousInt2;
              paramAnonymousn.errMsg = paramAnonymousString;
              paramAnonymousn.hGf = ((avv)paramAnonymousb.hvs.hvw);
              c.this.hFS.add(paramAnonymousn);
            }
            if ((!c.this.hFS.isEmpty()) && (c.this.hFX.eVs())) {
              c.this.hFX.au(50L, 50L);
            }
            AppMethodBeat.o(20521);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
      }
    }
  }
  
  public final void aJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    ac.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bs.eWi());
    if (bm(paramString1, paramString2)) {
      this.hFW.au(500L, 500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void aK(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(20527);
    if (bs.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.hFW.au(500L, 500L);
      }
      AppMethodBeat.o(20527);
      return;
      Object localObject = u.axw();
      String str = u.axx();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        ac.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).hpw = bs.nullAsNil(paramString2);
        ((a)localObject).hFO = bs.m(Integer.valueOf(1));
        ((a)localObject).hFM = bs.eWj();
        bool = d.aEW().a((a)localObject);
      }
    }
  }
  
  public final void yd(String paramString)
  {
    AppMethodBeat.i(20525);
    try
    {
      this.jsb.remove(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(20525);
    }
  }
  
  public final void ye(final String paramString)
  {
    AppMethodBeat.i(20529);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.hFP.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            ac.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.hFP.remove(str);
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
    avv hGf;
    int hGg = 0;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.c
 * JD-Core Version:    0.7.0.1
 */