package com.tencent.mm.au;

import android.database.Cursor;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  implements as.b
{
  boolean hMb;
  private long hMm;
  final int hYA;
  av hYB;
  final av hYC;
  f<String, Integer> hYu;
  Map<String, LinkedList<as.b.a>> hYv;
  Queue<azs> hYw;
  Queue<a> hYx;
  long hYy;
  final int hYz;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.hMb = false;
    this.hYu = new com.tencent.mm.memory.a.c(200);
    this.hYv = new HashMap();
    this.hYw = new LinkedList();
    this.hYx = new LinkedList();
    this.hYy = 0L;
    this.hYz = 500;
    this.hYA = 10000;
    this.hMm = 0L;
    this.hYB = new av(ba.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        ad.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.aHZ();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.hYC = new av(ba.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.hYx.isEmpty())
        {
          ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(20523);
          return false;
        }
        long l1 = bt.flT();
        int i;
        ArrayList localArrayList;
        int j;
        label67:
        c.a locala;
        final boolean bool;
        if (c.this.hMb)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1096;
          }
          locala = (c.a)c.this.hYx.peek();
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
            ba.aBQ();
            long l2 = com.tencent.mm.model.c.getDataDB().xO(Thread.currentThread().getId());
            Object localObject1 = d.aIb();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).Fa((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.hYL.GwV;
                localObject1 = locala.hYL.GtN;
                Object localObject3 = locala.hYL.GwX;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (czx)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().lX(((czx)localObject4).nDo, ((czx)localObject4).xbo);
                    }
                  }
                }
                k = locala.hYM;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  ad.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.hYx.poll();
                  if (c.this.hYx.isEmpty())
                  {
                    ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.hYy = 0L;
                    c.this.hYB.az(0L, 0L);
                    bool = false;
                    break label104;
                  }
                  ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (bzp)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = bt.bI(z.a(((bzp)localObject2).GbY), "");
                Object localObject4 = bt.bI(((bzp)localObject2).jdh, "");
                localObject1 = bt.bI(((bzp)localObject2).GUs, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                localArrayList.add(localObject1);
                switch (m)
                {
                default: 
                  ad.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(q.yM((String)localObject3)) });
                  e.ygI.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new ap(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      ad.i("MicroMsg.GetContactService", "callback user:%s alias:%s", new Object[] { bt.bI(this.cWF, ""), bt.bI(this.hYI, "") });
                      try
                      {
                        Object localObject2 = (LinkedList)c.this.hYv.remove(this.cWF);
                        if (bt.isNullOrNil(this.hYI)) {}
                        for (LinkedList localLinkedList = null;; localLinkedList = (LinkedList)c.this.hYv.remove(this.hYI))
                        {
                          if (localObject2 == null) {
                            break;
                          }
                          ad.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", new Object[] { bt.bI(this.cWF, ""), Integer.valueOf(((LinkedList)localObject2).size()) });
                          localObject2 = ((LinkedList)localObject2).iterator();
                          while (((Iterator)localObject2).hasNext()) {
                            ((as.b.a)((Iterator)localObject2).next()).p(this.cWF, bool);
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
                      ad.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", new Object[] { bt.bI(this.cWF, ""), Integer.valueOf(localObject1.size()) });
                      Iterator localIterator = localObject1.iterator();
                      while (localIterator.hasNext()) {
                        ((as.b.a)localIterator.next()).p(this.cWF, bool);
                      }
                      label269:
                      AppMethodBeat.o(20522);
                    }
                  });
                  locala.hYM += 1;
                  break;
                  if ((locala.hYL.GwW == null) || (locala.hYL.GwW.size() <= k) || (!((String)localObject3).equals(((dve)locala.hYL.GwW.get(k)).username))) {
                    if (locala.hYL.GwW == null)
                    {
                      localObject1 = "null";
                      label753:
                      ad.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = bt.bI(((dve)locala.hYL.GwW.get(k)).HHJ, ""))
                  {
                    ad.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s %s", new Object[] { localObject3, localObject4, localObject1, Integer.valueOf(locala.hYN) });
                    com.tencent.mm.plugin.subapp.b.iRH.a((bzp)localObject2, (String)localObject1, locala.hYN);
                    e.ygI.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.hYL.GwW.size());
                    break label753;
                  }
                  ad.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.aIb().Fa((String)localObject3)), Boolean.valueOf(d.aIb().Fa((String)localObject4)), Boolean.valueOf(q.yM((String)localObject3)) });
                  e.ygI.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            ba.aBQ();
            com.tencent.mm.model.c.getDataDB().sJ(l2);
          }
          ad.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.hMb + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (bt.flT() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1096:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private void aHY()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.aIb();
    long l = this.hYy;
    Cursor localCursor = ((b)localObject1).hHS.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
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
    SparseArray localSparseArray = new SparseArray();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject4;
    Object localObject3;
    if (localCursor.moveToNext())
    {
      Object localObject6 = new a();
      ((a)localObject6).username = localCursor.getString(0);
      ((a)localObject6).hYr = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).hYs = localCursor.getInt(3);
      ((a)localObject6).hHL = localCursor.getInt(4);
      ((a)localObject6).hYt = localCursor.getInt(5);
      ((a)localObject6).hHN = localCursor.getString(6);
      ((a)localObject6).hHO = localCursor.getString(7);
      localObject4 = ((a)localObject6).getUsername();
      localObject3 = bt.nullAsNil(((a)localObject6).aHX());
      i = bt.n(Integer.valueOf(((a)localObject6).hYt));
      Object localObject5 = bt.nullAsNil(((a)localObject6).aCq());
      this.hYy = ((a)localObject6).hYr;
      localObject6 = (String)localObject4 + "#" + (String)localObject3;
      int j = bt.a((Integer)this.hYu.aL(localObject6), 0);
      if (j < 3)
      {
        this.hYu.q(localObject6, Integer.valueOf(j + 1));
        if (w.zl((String)localObject4))
        {
          localObject5 = new azs();
          ((LinkedList)localObject2).add(new cwt().aPy((String)localObject4));
          ((LinkedList)localObject1).add(new cwt().aPy((String)localObject3));
          ((azs)localObject5).FuM = ((LinkedList)localObject2);
          ((azs)localObject5).GwR = ((LinkedList)localObject1);
          this.hYw.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ad.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.hYw.size()), Integer.valueOf(((azs)localObject5).FuM.size()), localObject4 });
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
          localObject5 = new azs();
          ((azs)localObject5).FuM = ((LinkedList)localObject2);
          ((azs)localObject5).GwN = ((LinkedList)localObject2).size();
          ((azs)localObject5).GwR = ((LinkedList)localObject1);
          ((azs)localObject5).GwQ = ((LinkedList)localObject1).size();
          this.hYw.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ad.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d getScene=%s", new Object[] { Integer.valueOf(this.hYw.size()), Integer.valueOf(((azs)localObject5).FuM.size()), Integer.valueOf(i) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (am.aSQ((String)localObject4))
        {
          localObject5 = new azs();
          ((LinkedList)localObject2).add(new cwt().aPy((String)localObject4));
          ((LinkedList)localObject1).add(new cwt().aPy((String)localObject3));
          ((azs)localObject5).FuM = ((LinkedList)localObject2);
          ((azs)localObject5).GwR = ((LinkedList)localObject1);
          this.hYw.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ad.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.hYw.size()), Integer.valueOf(((azs)localObject5).FuM.size()), localObject4 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new cwt().aPy((String)localObject4), new cwt().aPy((String)localObject5)));
          ad.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject4, Integer.valueOf(i), localObject5 });
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
          ((LinkedList)localObject2).add(new cwt().aPy((String)localObject4));
          ((LinkedList)localObject1).add(new cwt().aPy((String)localObject3));
          ad.i("MicroMsg.GetContactService", "getFromDb add user:%s getScene:%s room:%s", new Object[] { localObject4, Integer.valueOf(i), localObject3 });
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
      localObject3 = new azs();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((azs)localObject3).FuM = ((LinkedList)localObject4);
      ((azs)localObject3).GwN = ((LinkedList)localObject4).size();
      ((azs)localObject3).GwS = 1;
      ((azs)localObject3).GwT = ((cwt)((Pair)localObject2).second);
      this.hYw.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = w.vF((String)localObject1);
      ad.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.aIb().Fa((String)localObject1);
      }
      boolean bool2 = w.zr((String)localObject1);
      ad.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.aIb().Fa((String)localObject1);
        e.ygI.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(20531);
  }
  
  private static boolean bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = u.aAm();
    String str = u.aAn();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      ad.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).hHN = bt.nullAsNil(paramString2);
    ((a)localObject).hYr = bt.flT();
    boolean bool = d.aIb().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  private void c(SparseArray<List<String>> paramSparseArray)
  {
    AppMethodBeat.i(193119);
    int i = 0;
    while (i < paramSparseArray.size())
    {
      azs localazs = new azs();
      int j = paramSparseArray.keyAt(i);
      Object localObject = (List)paramSparseArray.valueAt(i);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localLinkedList.add(new cwt().aPy(str));
      }
      localazs.FuM.addAll(localLinkedList);
      localazs.GwN = localazs.FuM.size();
      localazs.GwS = j;
      this.hYw.add(localazs);
      ad.i("MicroMsg.GetContactService", "[buildSceneReqList] scene=%s count=%s req size=%s", new Object[] { Integer.valueOf(localazs.GwS), Integer.valueOf(localazs.GwN), Integer.valueOf(this.hYw.size()) });
      i += 1;
    }
    paramSparseArray.clear();
    AppMethodBeat.o(193119);
  }
  
  public final void AJ(String paramString)
  {
    AppMethodBeat.i(20525);
    try
    {
      this.hYv.remove(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(20525);
    }
  }
  
  public final void AK(final String paramString)
  {
    AppMethodBeat.i(20529);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.hYu.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            ad.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.hYu.remove(str);
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
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.hYv.containsKey(paramString)) {
          try
          {
            Object localObject1 = (LinkedList)c.this.hYv.get(paramString);
            c.this.hYv.remove(paramString);
            if (localObject1 != null)
            {
              localObject1 = ((LinkedList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((as.b.a)((Iterator)localObject1).next()).p(paramString, paramBoolean);
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
  
  public final void a(String paramString1, String paramString2, as.b.a parama)
  {
    AppMethodBeat.i(20528);
    ad.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bt.flS());
    if (bn(paramString1, paramString2))
    {
      if (parama != null) {
        break label100;
      }
      ad.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", new Object[] { bt.bI(paramString1, "") });
    }
    for (;;)
    {
      this.hYB.az(0L, 0L);
      AppMethodBeat.o(20528);
      return;
      try
      {
        label100:
        Object localObject = (LinkedList)this.hYv.get(paramString1);
        paramString2 = (String)localObject;
        if (localObject == null)
        {
          localObject = this.hYv;
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
  
  public final void aBs()
  {
    AppMethodBeat.i(193118);
    ad.i("MicroMsg.GetContactService", "[checkPendingGetContact] %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.subapp.b.iRH.MY()) });
    this.hYB.az(500L, 500L);
    AppMethodBeat.o(193118);
  }
  
  final void aHZ()
  {
    long l;
    try
    {
      AppMethodBeat.i(20533);
      if (com.tencent.mm.plugin.subapp.b.iRH.MY())
      {
        ad.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        AppMethodBeat.o(20533);
      }
      for (;;)
      {
        return;
        l = bt.flT();
        if ((this.hMb) && (l - this.hMm > 600000L))
        {
          ad.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.hMm) });
          this.hMb = false;
        }
        if (!this.hMb) {
          break;
        }
        ad.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.hMb + " ret");
        AppMethodBeat.o(20533);
      }
      localObject2 = (azs)this.hYw.poll();
    }
    finally {}
    Object localObject2;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      aHY();
      for (localObject2 = (azs)this.hYw.poll(); ((localObject2 == null) || (((azs)localObject2).FuM == null) || (((azs)localObject2).FuM.size() == 0)) && (this.hYw.size() > 0); localObject2 = (azs)this.hYw.poll()) {}
      if ((localObject2 != null) && (((azs)localObject2).FuM != null))
      {
        localObject3 = localObject2;
        if (((azs)localObject2).FuM.size() != 0) {}
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
      ad.e("MicroMsg.GetContactService", "tryStartNetscene Not any more contact. req is null? %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20533);
      break;
      this.hMm = l;
      this.hMb = true;
      localObject2 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((azs)localObject3).FuM.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = z.a((cwt)((Iterator)localObject5).next());
        if (w.zl((String)localObject6)) {
          ((LinkedList)localObject2).add(localObject6);
        }
        if (am.aSQ((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject2).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject2).get(0);
        if (w.zl((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.aPF((String)localObject2).uH((String)localObject2).d(new com.tencent.mm.roomsdk.a.b.b() {}).cyR();
        }
        AppMethodBeat.o(20533);
        break;
      }
      if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new bfc();
        ((bfc)localObject6).iHA = ((String)localObject5);
        localObject4 = "";
        localObject2 = localObject4;
        if (((azs)localObject3).GwR != null)
        {
          localObject2 = localObject4;
          if (((azs)localObject3).GwR.size() > 0) {
            localObject2 = z.a((cwt)((azs)localObject3).GwR.get(0));
          }
        }
        ((bfc)localObject6).dvs = ((String)localObject2);
        localObject3 = new b.a();
        ((b.a)localObject3).hNM = ((com.tencent.mm.bx.a)localObject6);
        ((b.a)localObject3).hNN = new bfd();
        ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((b.a)localObject3).funcId = 881;
        ad.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject2, localObject5 });
        x.a(((b.a)localObject3).aDC(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousn.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.hMb = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              ad.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.hYG });
              if (paramAnonymousInt1 == 4) {
                d.aIb().Fa(this.hYG);
              }
              c.this.hYB.az(10000L, 10000L);
              c.this.Q(this.hYG, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.hYw.isEmpty()) && (c.this.hYB.fkZ())) {
              c.this.hYB.az(500L, 500L);
            }
            s.a((bfd)paramAnonymousb.hNL.hNQ);
            ad.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.aIb().Fa(this.hYG)), this.hYG });
            c.this.Q(this.hYG, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
        break;
      }
      localObject2 = new b.a();
      ((b.a)localObject2).hNM = ((com.tencent.mm.bx.a)localObject3);
      ((b.a)localObject2).hNN = new azt();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/getcontact";
      ((b.a)localObject2).funcId = 182;
      final int i = ((azs)localObject3).GwS;
      x.a(((b.a)localObject2).aDC(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(20521);
          if (paramAnonymousn.getType() != 182)
          {
            AppMethodBeat.o(20521);
            return 0;
          }
          c.this.hMb = false;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " getScene:" + i + " will retry");
            c.this.hYB.az(10000L, 10000L);
            AppMethodBeat.o(20521);
            return 0;
          }
          if ((!c.this.hYw.isEmpty()) && (c.this.hYB.fkZ())) {
            c.this.hYB.az(500L, 500L);
          }
          if (paramAnonymousb != null)
          {
            paramAnonymousn = new c.a(c.this);
            paramAnonymousn.hYN = i;
            paramAnonymousn.errType = paramAnonymousInt1;
            paramAnonymousn.errCode = paramAnonymousInt2;
            paramAnonymousn.errMsg = paramAnonymousString;
            paramAnonymousn.hYL = ((azt)paramAnonymousb.hNL.hNQ);
            c.this.hYx.add(paramAnonymousn);
          }
          if ((!c.this.hYx.isEmpty()) && (c.this.hYC.fkZ())) {
            c.this.hYC.az(50L, 50L);
          }
          AppMethodBeat.o(20521);
          return 0;
        }
      }, true);
      AppMethodBeat.o(20533);
      break;
    }
  }
  
  public final void aI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    ad.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bt.flS());
    if (bn(paramString1, paramString2)) {
      this.hYB.az(500L, 500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void g(String paramString1, int paramInt, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(193117);
    if (bt.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.hYB.az(500L, 500L);
      }
      AppMethodBeat.o(193117);
      return;
      Object localObject = u.aAm();
      String str = u.aAn();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        ad.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).hHO = bt.nullAsNil(paramString2);
        ((a)localObject).hYt = bt.n(Integer.valueOf(paramInt));
        ((a)localObject).hYr = bt.flT();
        bool = d.aIb().a((a)localObject);
      }
    }
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    azt hYL;
    int hYM = 0;
    int hYN;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.au.c
 * JD-Core Version:    0.7.0.1
 */