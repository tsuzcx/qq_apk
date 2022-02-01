package com.tencent.mm.at;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

final class c
  implements au.b
{
  boolean hOU;
  private long hPf;
  f<String, Integer> ibm;
  Map<String, LinkedList<au.b.a>> ibn;
  Queue<bai> ibo;
  Queue<a> ibp;
  long ibq;
  final int ibr;
  final int ibs;
  aw ibt;
  final aw ibu;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.hOU = false;
    this.ibm = new com.tencent.mm.memory.a.c(200);
    this.ibn = new HashMap();
    this.ibo = new LinkedList();
    this.ibp = new LinkedList();
    this.ibq = 0L;
    this.ibr = 500;
    this.ibs = 10000;
    this.hPf = 0L;
    this.ibt = new aw(bc.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        ae.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.aIq();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.ibu = new aw(bc.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.ibp.isEmpty())
        {
          ae.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(20523);
          return false;
        }
        long l1 = bu.fpO();
        int i;
        ArrayList localArrayList;
        int j;
        label67:
        c.a locala;
        final boolean bool;
        if (c.this.hOU)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1096;
          }
          locala = (c.a)c.this.ibp.peek();
          if (locala != null) {
            break label172;
          }
          ae.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
          bool = false;
        }
        for (;;)
        {
          label104:
          int k = localArrayList.size();
          if (k > 0)
          {
            bc.aCg();
            long l2 = com.tencent.mm.model.c.getDataDB().yi(Thread.currentThread().getId());
            Object localObject1 = d.aIs();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).FC((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.ibD.GQv;
                localObject1 = locala.ibD.GNm;
                Object localObject3 = locala.ibD.GQx;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (dar)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().me(((dar)localObject4).nIJ, ((dar)localObject4).xrf);
                    }
                  }
                }
                k = locala.ibE;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  ae.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.ibp.poll();
                  if (c.this.ibp.isEmpty())
                  {
                    ae.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.ibq = 0L;
                    c.this.ibt.ay(0L, 0L);
                    bool = false;
                    break label104;
                  }
                  ae.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (caj)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = bu.bI(z.a(((caj)localObject2).GuF), "");
                Object localObject4 = bu.bI(((caj)localObject2).jga, "");
                localObject1 = bu.bI(((caj)localObject2).HnT, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                localArrayList.add(localObject1);
                switch (m)
                {
                default: 
                  ae.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(r.zw((String)localObject3)) });
                  e.ywz.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new aq(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      ae.i("MicroMsg.GetContactService", "callback user:%s alias:%s", new Object[] { bu.bI(this.cXC, ""), bu.bI(this.ibA, "") });
                      try
                      {
                        Object localObject2 = (LinkedList)c.this.ibn.remove(this.cXC);
                        if (bu.isNullOrNil(this.ibA)) {}
                        for (LinkedList localLinkedList = null;; localLinkedList = (LinkedList)c.this.ibn.remove(this.ibA))
                        {
                          if (localObject2 == null) {
                            break;
                          }
                          ae.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", new Object[] { bu.bI(this.cXC, ""), Integer.valueOf(((LinkedList)localObject2).size()) });
                          localObject2 = ((LinkedList)localObject2).iterator();
                          while (((Iterator)localObject2).hasNext()) {
                            ((au.b.a)((Iterator)localObject2).next()).p(this.cXC, bool);
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
                      ae.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", new Object[] { bu.bI(this.cXC, ""), Integer.valueOf(localObject1.size()) });
                      Iterator localIterator = localObject1.iterator();
                      while (localIterator.hasNext()) {
                        ((au.b.a)localIterator.next()).p(this.cXC, bool);
                      }
                      label269:
                      AppMethodBeat.o(20522);
                    }
                  });
                  locala.ibE += 1;
                  break;
                  if ((locala.ibD.GQw == null) || (locala.ibD.GQw.size() <= k) || (!((String)localObject3).equals(((dwb)locala.ibD.GQw.get(k)).username))) {
                    if (locala.ibD.GQw == null)
                    {
                      localObject1 = "null";
                      label753:
                      ae.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = bu.bI(((dwb)locala.ibD.GQw.get(k)).Ibw, ""))
                  {
                    ae.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s %s", new Object[] { localObject3, localObject4, localObject1, Integer.valueOf(locala.ibF) });
                    com.tencent.mm.plugin.subapp.b.iUA.a((caj)localObject2, (String)localObject1, locala.ibF);
                    e.ywz.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.ibD.GQw.size());
                    break label753;
                  }
                  ae.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.aIs().FC((String)localObject3)), Boolean.valueOf(d.aIs().FC((String)localObject4)), Boolean.valueOf(r.zw((String)localObject3)) });
                  e.ywz.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            bc.aCg();
            com.tencent.mm.model.c.getDataDB().sW(l2);
          }
          ae.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.hOU + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bu.fpO() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1096:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private void aIp()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.aIs();
    long l = this.ibq;
    Cursor localCursor = ((b)localObject1).hKK.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(20531);
      return;
    }
    int i = localCursor.getCount();
    ae.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      localCursor.close();
      AppMethodBeat.o(20531);
      return;
    }
    Object localObject2 = new LinkedList();
    localObject1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    SparseArray localSparseArray = new SparseArray();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject4;
    Object localObject3;
    if (localCursor.moveToNext())
    {
      Object localObject6 = new a();
      ((a)localObject6).username = localCursor.getString(0);
      ((a)localObject6).ibj = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).ibk = localCursor.getInt(3);
      ((a)localObject6).hKD = localCursor.getInt(4);
      ((a)localObject6).ibl = localCursor.getInt(5);
      ((a)localObject6).hKF = localCursor.getString(6);
      ((a)localObject6).hKG = localCursor.getString(7);
      localObject4 = ((a)localObject6).getUsername();
      localObject3 = bu.nullAsNil(((a)localObject6).aIo());
      i = bu.o(Integer.valueOf(((a)localObject6).ibl));
      Object localObject5 = bu.nullAsNil(((a)localObject6).aCG());
      this.ibq = ((a)localObject6).ibj;
      localObject6 = (String)localObject4 + "#" + (String)localObject3;
      int j = bu.a((Integer)this.ibm.aL(localObject6), 0);
      if (j < 3)
      {
        this.ibm.q(localObject6, Integer.valueOf(j + 1));
        if (com.tencent.mm.model.x.zV((String)localObject4))
        {
          localObject5 = new bai();
          ((LinkedList)localObject2).add(new cxn().aQV((String)localObject4));
          ((LinkedList)localObject1).add(new cxn().aQV((String)localObject3));
          ((bai)localObject5).FNk = ((LinkedList)localObject2);
          ((bai)localObject5).GQr = ((LinkedList)localObject1);
          this.ibo.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ae.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.ibo.size()), Integer.valueOf(((bai)localObject5).FNk.size()), localObject4 });
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
          localObject5 = new bai();
          ((bai)localObject5).FNk = ((LinkedList)localObject2);
          ((bai)localObject5).GQn = ((LinkedList)localObject2).size();
          ((bai)localObject5).GQr = ((LinkedList)localObject1);
          ((bai)localObject5).GQq = ((LinkedList)localObject1).size();
          this.ibo.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ae.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d getScene=%s", new Object[] { Integer.valueOf(this.ibo.size()), Integer.valueOf(((bai)localObject5).FNk.size()), Integer.valueOf(i) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (an.aUq((String)localObject4))
        {
          localObject5 = new bai();
          ((LinkedList)localObject2).add(new cxn().aQV((String)localObject4));
          ((LinkedList)localObject1).add(new cxn().aQV((String)localObject3));
          ((bai)localObject5).FNk = ((LinkedList)localObject2);
          ((bai)localObject5).GQr = ((LinkedList)localObject1);
          this.ibo.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ae.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.ibo.size()), Integer.valueOf(((bai)localObject5).FNk.size()), localObject4 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new cxn().aQV((String)localObject4), new cxn().aQV((String)localObject5)));
          ae.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject4, Integer.valueOf(i), localObject5 });
        }
        else
        {
          if (i != 0)
          {
            if (localSparseArray.indexOfKey(i) < 0)
            {
              localObject3 = new LinkedList();
              localSparseArray.put(i, localObject3);
            }
            for (;;)
            {
              ((List)localObject3).add(localObject4);
              break;
              localObject3 = (List)localSparseArray.get(i);
            }
          }
          ((LinkedList)localObject2).add(new cxn().aQV((String)localObject4));
          ((LinkedList)localObject1).add(new cxn().aQV((String)localObject3));
          ae.i("MicroMsg.GetContactService", "getFromDb add user:%s getScene:%s room:%s", new Object[] { localObject4, Integer.valueOf(i), localObject3 });
          continue;
          localLinkedList1.add(localObject4);
          Q((String)localObject4, false);
        }
      }
    }
    localCursor.close();
    c(localSparseArray);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = new bai();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((bai)localObject3).FNk = ((LinkedList)localObject4);
      ((bai)localObject3).GQn = ((LinkedList)localObject4).size();
      ((bai)localObject3).GQs = 1;
      ((bai)localObject3).GQt = ((cxn)((Pair)localObject2).second);
      this.ibo.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = com.tencent.mm.model.x.wb((String)localObject1);
      ae.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.aIs().FC((String)localObject1);
      }
      boolean bool2 = com.tencent.mm.model.x.Ab((String)localObject1);
      ae.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.aIs().FC((String)localObject1);
        e.ywz.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(20531);
  }
  
  private static boolean bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = v.aAC();
    String str = v.aAD();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      ae.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).hKF = bu.nullAsNil(paramString2);
    ((a)localObject).ibj = bu.fpO();
    boolean bool = d.aIs().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  private void c(SparseArray<List<String>> paramSparseArray)
  {
    AppMethodBeat.i(186364);
    int i = 0;
    while (i < paramSparseArray.size())
    {
      bai localbai = new bai();
      int j = paramSparseArray.keyAt(i);
      Object localObject = (List)paramSparseArray.valueAt(i);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localLinkedList.add(new cxn().aQV(str));
      }
      localbai.FNk.addAll(localLinkedList);
      localbai.GQn = localbai.FNk.size();
      localbai.GQs = j;
      this.ibo.add(localbai);
      ae.i("MicroMsg.GetContactService", "[buildSceneReqList] scene=%s count=%s req size=%s", new Object[] { Integer.valueOf(localbai.GQs), Integer.valueOf(localbai.GQn), Integer.valueOf(this.ibo.size()) });
      i += 1;
    }
    paramSparseArray.clear();
    AppMethodBeat.o(186364);
  }
  
  public final void Bt(String paramString)
  {
    AppMethodBeat.i(20525);
    try
    {
      this.ibn.remove(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(20525);
    }
  }
  
  public final void Bu(final String paramString)
  {
    AppMethodBeat.i(20529);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.ibm.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            ae.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.ibm.remove(str);
          }
          i += 1;
        }
        AppMethodBeat.o(20516);
      }
    });
    AppMethodBeat.o(20529);
  }
  
  final void Q(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20532);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.ibn.containsKey(paramString)) {
          try
          {
            Object localObject1 = (LinkedList)c.this.ibn.get(paramString);
            c.this.ibn.remove(paramString);
            if (localObject1 != null)
            {
              localObject1 = ((LinkedList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((au.b.a)((Iterator)localObject1).next()).p(paramString, paramBoolean);
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
  
  public final void a(String paramString1, String paramString2, au.b.a parama)
  {
    AppMethodBeat.i(20528);
    ae.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bu.fpN());
    if (bn(paramString1, paramString2))
    {
      if (parama != null) {
        break label100;
      }
      ae.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", new Object[] { bu.bI(paramString1, "") });
    }
    for (;;)
    {
      this.ibt.ay(0L, 0L);
      AppMethodBeat.o(20528);
      return;
      try
      {
        label100:
        Object localObject = (LinkedList)this.ibn.get(paramString1);
        paramString2 = (String)localObject;
        if (localObject == null)
        {
          localObject = this.ibn;
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
  
  public final void aBI()
  {
    AppMethodBeat.i(186363);
    ae.i("MicroMsg.GetContactService", "[checkPendingGetContact] %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.subapp.b.iUA.MT()) });
    this.ibt.ay(500L, 500L);
    AppMethodBeat.o(186363);
  }
  
  final void aIq()
  {
    long l;
    try
    {
      AppMethodBeat.i(20533);
      if (com.tencent.mm.plugin.subapp.b.iUA.MT())
      {
        ae.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        AppMethodBeat.o(20533);
      }
      for (;;)
      {
        return;
        l = bu.fpO();
        if ((this.hOU) && (l - this.hPf > 600000L))
        {
          ae.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.hPf) });
          this.hOU = false;
        }
        if (!this.hOU) {
          break;
        }
        ae.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.hOU + " ret");
        AppMethodBeat.o(20533);
      }
      localObject2 = (bai)this.ibo.poll();
    }
    finally {}
    Object localObject2;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      aIp();
      for (localObject2 = (bai)this.ibo.poll(); ((localObject2 == null) || (((bai)localObject2).FNk == null) || (((bai)localObject2).FNk.size() == 0)) && (this.ibo.size() > 0); localObject2 = (bai)this.ibo.poll()) {}
      if ((localObject2 != null) && (((bai)localObject2).FNk != null))
      {
        localObject3 = localObject2;
        if (((bai)localObject2).FNk.size() != 0) {}
      }
      else
      {
        if (localObject2 != null) {
          break label728;
        }
      }
    }
    label728:
    for (boolean bool = true;; bool = false)
    {
      ae.e("MicroMsg.GetContactService", "tryStartNetscene Not any more contact. req is null? %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20533);
      break;
      this.hPf = l;
      this.hOU = true;
      localObject2 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((bai)localObject3).FNk.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = z.a((cxn)((Iterator)localObject5).next());
        if (com.tencent.mm.model.x.zV((String)localObject6)) {
          ((LinkedList)localObject2).add(localObject6);
        }
        if (an.aUq((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject2).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject2).get(0);
        if (com.tencent.mm.model.x.zV((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.aRc((String)localObject2).vc((String)localObject2).d(new com.tencent.mm.roomsdk.a.b.b() {}).cAs();
        }
        AppMethodBeat.o(20533);
        break;
      }
      if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new bfs();
        ((bfs)localObject6).iKt = ((String)localObject5);
        localObject4 = "";
        localObject2 = localObject4;
        if (((bai)localObject3).GQr != null)
        {
          localObject2 = localObject4;
          if (((bai)localObject3).GQr.size() > 0) {
            localObject2 = z.a((cxn)((bai)localObject3).GQr.get(0));
          }
        }
        ((bfs)localObject6).dwx = ((String)localObject2);
        localObject3 = new b.a();
        ((b.a)localObject3).hQF = ((com.tencent.mm.bw.a)localObject6);
        ((b.a)localObject3).hQG = new bft();
        ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((b.a)localObject3).funcId = 881;
        ae.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject2, localObject5 });
        com.tencent.mm.ak.x.a(((b.a)localObject3).aDS(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousn.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.hOU = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ae.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.iby });
              if (paramAnonymousInt1 == 4) {
                d.aIs().FC(this.iby);
              }
              c.this.ibt.ay(10000L, 10000L);
              c.this.Q(this.iby, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.ibo.isEmpty()) && (c.this.ibt.foU())) {
              c.this.ibt.ay(500L, 500L);
            }
            s.a((bft)paramAnonymousb.hQE.hQJ);
            ae.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.aIs().FC(this.iby)), this.iby });
            c.this.Q(this.iby, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
        break;
      }
      localObject2 = new b.a();
      ((b.a)localObject2).hQF = ((com.tencent.mm.bw.a)localObject3);
      ((b.a)localObject2).hQG = new baj();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/getcontact";
      ((b.a)localObject2).funcId = 182;
      final int i = ((bai)localObject3).GQs;
      com.tencent.mm.ak.x.a(((b.a)localObject2).aDS(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(20521);
          if (paramAnonymousn.getType() != 182)
          {
            AppMethodBeat.o(20521);
            return 0;
          }
          c.this.hOU = false;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " getScene:" + i + " will retry");
            c.this.ibt.ay(10000L, 10000L);
            AppMethodBeat.o(20521);
            return 0;
          }
          if ((!c.this.ibo.isEmpty()) && (c.this.ibt.foU())) {
            c.this.ibt.ay(500L, 500L);
          }
          if (paramAnonymousb != null)
          {
            paramAnonymousn = new c.a(c.this);
            paramAnonymousn.ibF = i;
            paramAnonymousn.errType = paramAnonymousInt1;
            paramAnonymousn.errCode = paramAnonymousInt2;
            paramAnonymousn.errMsg = paramAnonymousString;
            paramAnonymousn.ibD = ((baj)paramAnonymousb.hQE.hQJ);
            c.this.ibp.add(paramAnonymousn);
          }
          if ((!c.this.ibp.isEmpty()) && (c.this.ibu.foU())) {
            c.this.ibu.ay(50L, 50L);
          }
          AppMethodBeat.o(20521);
          return 0;
        }
      }, true);
      AppMethodBeat.o(20533);
      break;
    }
  }
  
  public final void aJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    ae.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bu.fpN());
    if (bn(paramString1, paramString2)) {
      this.ibt.ay(500L, 500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void g(String paramString1, int paramInt, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(186362);
    if (bu.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.ibt.ay(500L, 500L);
      }
      AppMethodBeat.o(186362);
      return;
      Object localObject = v.aAC();
      String str = v.aAD();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        ae.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).hKG = bu.nullAsNil(paramString2);
        ((a)localObject).ibl = bu.o(Integer.valueOf(paramInt));
        ((a)localObject).ibj = bu.fpO();
        bool = d.aIs().a((a)localObject);
      }
    }
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    baj ibD;
    int ibE = 0;
    int ibF;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.c
 * JD-Core Version:    0.7.0.1
 */