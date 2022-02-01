package com.tencent.mm.aw;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.protocal.protobuf.far;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

final class c
  implements az.b
{
  boolean lAg;
  private long lAr;
  com.tencent.mm.b.f<String, Integer> lMF;
  Map<String, LinkedList<az.b.a>> lMG;
  Queue<btc> lMH;
  Queue<a> lMI;
  long lMJ;
  final int lMK;
  final int lML;
  MTimerHandler lMM;
  final MTimerHandler lMN;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.lAg = false;
    this.lMF = new com.tencent.mm.memory.a.c(200);
    this.lMG = new HashMap();
    this.lMH = new LinkedList();
    this.lMI = new LinkedList();
    this.lMJ = 0L;
    this.lMK = 500;
    this.lML = 10000;
    this.lAr = 0L;
    this.lMM = new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        Log.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.blz();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.lMN = new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.lMI.isEmpty())
        {
          Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
          AppMethodBeat.o(20523);
          return false;
        }
        long l1 = Util.nowMilliSecond();
        int i;
        ArrayList localArrayList;
        int j;
        label67:
        c.a locala;
        final boolean bool;
        if (c.this.lAg)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1096;
          }
          locala = (c.a)c.this.lMI.peek();
          if (locala != null) {
            break label172;
          }
          Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
          bool = false;
        }
        for (;;)
        {
          label104:
          int k = localArrayList.size();
          if (k > 0)
          {
            bh.beI();
            long l2 = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
            Object localObject1 = d.blB();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).VK((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.lMW.Tdk;
                localObject1 = locala.lMW.SZW;
                Object localObject3 = locala.lMW.Tdm;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (edx)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().nJ(((edx)localObject4).UserName, ((edx)localObject4).HlB);
                    }
                  }
                }
                k = locala.lMX;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  Log.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.lMI.poll();
                  if (c.this.lMI.isEmpty())
                  {
                    Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.lMJ = 0L;
                    c.this.lMM.startTimer(0L);
                    bool = false;
                    break label104;
                  }
                  Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (cyb)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = Util.nullAs(com.tencent.mm.platformtools.z.a(((cyb)localObject2).SrH), "");
                Object localObject4 = Util.nullAs(((cyb)localObject2).mVD, "");
                localObject1 = Util.nullAs(((cyb)localObject2).TGl, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                localArrayList.add(localObject1);
                switch (m)
                {
                default: 
                  Log.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(v.Po((String)localObject3)) });
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new MMHandler(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      Log.i("MicroMsg.GetContactService", "callback user:%s alias:%s", new Object[] { Util.nullAs(this.fgI, ""), Util.nullAs(this.lMT, "") });
                      try
                      {
                        Object localObject2 = (LinkedList)c.this.lMG.remove(this.fgI);
                        if (Util.isNullOrNil(this.lMT)) {}
                        for (LinkedList localLinkedList = null;; localLinkedList = (LinkedList)c.this.lMG.remove(this.lMT))
                        {
                          if (localObject2 == null) {
                            break;
                          }
                          Log.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", new Object[] { Util.nullAs(this.fgI, ""), Integer.valueOf(((LinkedList)localObject2).size()) });
                          localObject2 = ((LinkedList)localObject2).iterator();
                          while (((Iterator)localObject2).hasNext()) {
                            ((az.b.a)((Iterator)localObject2).next()).s(this.fgI, bool);
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
                      Log.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", new Object[] { Util.nullAs(this.fgI, ""), Integer.valueOf(localObject1.size()) });
                      Iterator localIterator = localObject1.iterator();
                      while (localIterator.hasNext()) {
                        ((az.b.a)localIterator.next()).s(this.fgI, bool);
                      }
                      label269:
                      AppMethodBeat.o(20522);
                    }
                  });
                  locala.lMX += 1;
                  break;
                  if ((locala.lMW.Tdl == null) || (locala.lMW.Tdl.size() <= k) || (!((String)localObject3).equals(((far)locala.lMW.Tdl.get(k)).username))) {
                    if (locala.lMW.Tdl == null)
                    {
                      localObject1 = "null";
                      label753:
                      Log.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = Util.nullAs(((far)locala.lMW.Tdl.get(k)).UAJ, ""))
                  {
                    Log.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s %s", new Object[] { localObject3, localObject4, localObject1, Integer.valueOf(locala.lMY) });
                    com.tencent.mm.plugin.subapp.b.mIH.a((cyb)localObject2, (String)localObject1, locala.lMY);
                    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.lMW.Tdl.size());
                    break label753;
                  }
                  Log.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.blB().VK((String)localObject3)), Boolean.valueOf(d.blB().VK((String)localObject4)), Boolean.valueOf(v.Po((String)localObject3)) });
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            bh.beI();
            com.tencent.mm.model.c.getDataDB().endTransaction(l2);
          }
          Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.lAg + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (Util.nowMilliSecond() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1096:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private void bly()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.blB();
    long l = this.lMJ;
    Cursor localCursor = ((b)localObject1).lvy.rawQuery("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" });
    if (localCursor == null)
    {
      AppMethodBeat.o(20531);
      return;
    }
    int i = localCursor.getCount();
    Log.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
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
      ((a)localObject6).lMC = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).lMD = localCursor.getInt(3);
      ((a)localObject6).lvr = localCursor.getInt(4);
      ((a)localObject6).lME = localCursor.getInt(5);
      ((a)localObject6).lvt = localCursor.getString(6);
      ((a)localObject6).lvu = localCursor.getString(7);
      localObject4 = ((a)localObject6).getUsername();
      localObject3 = Util.nullAsNil(((a)localObject6).blx());
      i = Util.nullAsNil(Integer.valueOf(((a)localObject6).lME));
      Object localObject5 = Util.nullAsNil(((a)localObject6).bfh());
      this.lMJ = ((a)localObject6).lMC;
      localObject6 = (String)localObject4 + "#" + (String)localObject3;
      int j = Util.nullAs((Integer)this.lMF.aX(localObject6), 0);
      if (j < 3)
      {
        this.lMF.q(localObject6, Integer.valueOf(j + 1));
        if (ab.PQ((String)localObject4))
        {
          localObject5 = new btc();
          ((LinkedList)localObject2).add(new eaf().btQ((String)localObject4));
          ((LinkedList)localObject1).add(new eaf().btQ((String)localObject3));
          ((btc)localObject5).RIj = ((LinkedList)localObject2);
          ((btc)localObject5).Tdg = ((LinkedList)localObject1);
          this.lMH.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.lMH.size()), Integer.valueOf(((btc)localObject5).RIj.size()), localObject4 });
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
          localObject5 = new btc();
          ((btc)localObject5).RIj = ((LinkedList)localObject2);
          ((btc)localObject5).Tdc = ((LinkedList)localObject2).size();
          ((btc)localObject5).Tdg = ((LinkedList)localObject1);
          ((btc)localObject5).Tdf = ((LinkedList)localObject1).size();
          this.lMH.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d getScene=%s", new Object[] { Integer.valueOf(this.lMH.size()), Integer.valueOf(((btc)localObject5).RIj.size()), Integer.valueOf(i) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (as.bvK((String)localObject4))
        {
          localObject5 = new btc();
          ((LinkedList)localObject2).add(new eaf().btQ((String)localObject4));
          ((LinkedList)localObject1).add(new eaf().btQ((String)localObject3));
          ((btc)localObject5).RIj = ((LinkedList)localObject2);
          ((btc)localObject5).Tdg = ((LinkedList)localObject1);
          this.lMH.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.lMH.size()), Integer.valueOf(((btc)localObject5).RIj.size()), localObject4 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new eaf().btQ((String)localObject4), new eaf().btQ((String)localObject5)));
          Log.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject4, Integer.valueOf(i), localObject5 });
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
          ((LinkedList)localObject2).add(new eaf().btQ((String)localObject4));
          ((LinkedList)localObject1).add(new eaf().btQ((String)localObject3));
          Log.i("MicroMsg.GetContactService", "getFromDb add user:%s getScene:%s room:%s", new Object[] { localObject4, Integer.valueOf(i), localObject3 });
          continue;
          localLinkedList1.add(localObject4);
          S((String)localObject4, false);
        }
      }
    }
    localCursor.close();
    c(localSparseArray);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = new btc();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((btc)localObject3).RIj = ((LinkedList)localObject4);
      ((btc)localObject3).Tdc = ((LinkedList)localObject4).size();
      ((btc)localObject3).Tdh = 1;
      ((btc)localObject3).Tdi = ((eaf)((Pair)localObject2).second);
      this.lMH.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = ab.Lj((String)localObject1);
      Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.blB().VK((String)localObject1);
      }
      boolean bool2 = ab.PX((String)localObject1);
      Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.blB().VK((String)localObject1);
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(20531);
  }
  
  private static boolean bt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = com.tencent.mm.model.z.bcZ();
    String str = com.tencent.mm.model.z.bda();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      Log.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).lvt = Util.nullAsNil(paramString2);
    ((a)localObject).lMC = Util.nowMilliSecond();
    boolean bool = d.blB().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  private void c(SparseArray<List<String>> paramSparseArray)
  {
    AppMethodBeat.i(285415);
    int i = 0;
    while (i < paramSparseArray.size())
    {
      btc localbtc = new btc();
      int j = paramSparseArray.keyAt(i);
      Object localObject = (List)paramSparseArray.valueAt(i);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localLinkedList.add(new eaf().btQ(str));
      }
      localbtc.RIj.addAll(localLinkedList);
      localbtc.Tdc = localbtc.RIj.size();
      localbtc.Tdh = j;
      this.lMH.add(localbtc);
      Log.i("MicroMsg.GetContactService", "[buildSceneReqList] scene=%s count=%s req size=%s", new Object[] { Integer.valueOf(localbtc.Tdh), Integer.valueOf(localbtc.Tdc), Integer.valueOf(this.lMH.size()) });
      i += 1;
    }
    paramSparseArray.clear();
    AppMethodBeat.o(285415);
  }
  
  public final void Rr(String paramString)
  {
    AppMethodBeat.i(20525);
    try
    {
      this.lMG.remove(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(20525);
    }
  }
  
  public final void Rs(final String paramString)
  {
    AppMethodBeat.i(20529);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.lMF.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            Log.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.lMF.remove(str);
          }
          i += 1;
        }
        AppMethodBeat.o(20516);
      }
    });
    AppMethodBeat.o(20529);
  }
  
  final void S(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20532);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.lMG.containsKey(paramString)) {}
        try
        {
          Object localObject1 = (LinkedList)c.this.lMG.get(paramString);
          c.this.lMG.remove(paramString);
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {}
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(20518);
        }
      }
    });
    AppMethodBeat.o(20532);
  }
  
  public final void a(String paramString1, String paramString2, az.b.a parama)
  {
    AppMethodBeat.i(20528);
    Log.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + Util.getStack());
    if (bt(paramString1, paramString2))
    {
      if (parama != null) {
        break label99;
      }
      Log.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", new Object[] { Util.nullAs(paramString1, "") });
    }
    for (;;)
    {
      this.lMM.startTimer(0L);
      AppMethodBeat.o(20528);
      return;
      try
      {
        label99:
        Object localObject = (LinkedList)this.lMG.get(paramString1);
        paramString2 = (String)localObject;
        if (localObject == null)
        {
          localObject = this.lMG;
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
  
  public final void aP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    Log.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + Util.getStack());
    if (bt(paramString1, paramString2)) {
      this.lMM.startTimer(500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void bej()
  {
    AppMethodBeat.i(285413);
    Log.i("MicroMsg.GetContactService", "[checkPendingGetContact] %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.subapp.b.mIH.abI()) });
    this.lMM.startTimer(500L);
    AppMethodBeat.o(285413);
  }
  
  final void blz()
  {
    long l;
    try
    {
      AppMethodBeat.i(20533);
      if (com.tencent.mm.plugin.subapp.b.mIH.abI())
      {
        Log.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        AppMethodBeat.o(20533);
      }
      for (;;)
      {
        return;
        l = Util.nowMilliSecond();
        if ((this.lAg) && (l - this.lAr > 600000L))
        {
          Log.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.lAr) });
          this.lAg = false;
        }
        if (!this.lAg) {
          break;
        }
        Log.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.lAg + " ret");
        AppMethodBeat.o(20533);
      }
      localObject2 = (btc)this.lMH.poll();
    }
    finally {}
    Object localObject2;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      bly();
      for (localObject2 = (btc)this.lMH.poll(); ((localObject2 == null) || (((btc)localObject2).RIj == null) || (((btc)localObject2).RIj.size() == 0)) && (this.lMH.size() > 0); localObject2 = (btc)this.lMH.poll()) {}
      if ((localObject2 != null) && (((btc)localObject2).RIj != null))
      {
        localObject3 = localObject2;
        if (((btc)localObject2).RIj.size() != 0) {}
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
      Log.e("MicroMsg.GetContactService", "tryStartNetscene Not any more contact. req is null? %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20533);
      break;
      this.lAr = l;
      this.lAg = true;
      localObject2 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((btc)localObject3).RIj.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = com.tencent.mm.platformtools.z.a((eaf)((Iterator)localObject5).next());
        if (ab.PQ((String)localObject6)) {
          ((LinkedList)localObject2).add(localObject6);
        }
        if (as.bvK((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject2).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject2).get(0);
        if (ab.PQ((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.btX((String)localObject2).Kk((String)localObject2).d(new com.tencent.mm.roomsdk.a.b.b() {}).aRu();
        }
        AppMethodBeat.o(20533);
        break;
      }
      if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new bzk();
        ((bzk)localObject6).myd = ((String)localObject5);
        localObject4 = "";
        localObject2 = localObject4;
        if (((btc)localObject3).Tdg != null)
        {
          localObject2 = localObject4;
          if (((btc)localObject3).Tdg.size() > 0) {
            localObject2 = com.tencent.mm.platformtools.z.a((eaf)((btc)localObject3).Tdg.get(0));
          }
        }
        ((bzk)localObject6).fHp = ((String)localObject2);
        localObject3 = new d.a();
        ((d.a)localObject3).lBU = ((com.tencent.mm.cd.a)localObject6);
        ((d.a)localObject3).lBV = new bzl();
        ((d.a)localObject3).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((d.a)localObject3).funcId = 881;
        Log.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject2, localObject5 });
        aa.a(((d.a)localObject3).bgN(), new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousq.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.lAg = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.lMR });
              if (paramAnonymousInt1 == 4) {
                d.blB().VK(this.lMR);
              }
              c.this.lMM.startTimer(10000L);
              c.this.S(this.lMR, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.lMH.isEmpty()) && (c.this.lMM.stopped())) {
              c.this.lMM.startTimer(500L);
            }
            s.a((bzl)d.c.b(paramAnonymousd.lBS));
            Log.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.blB().VK(this.lMR)), this.lMR });
            c.this.S(this.lMR, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
        break;
      }
      localObject2 = new d.a();
      ((d.a)localObject2).lBU = ((com.tencent.mm.cd.a)localObject3);
      ((d.a)localObject2).lBV = new btd();
      ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/getcontact";
      ((d.a)localObject2).funcId = 182;
      final int i = ((btc)localObject3).Tdh;
      aa.a(((d.a)localObject2).bgN(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(20521);
          if (paramAnonymousq.getType() != 182)
          {
            AppMethodBeat.o(20521);
            return 0;
          }
          c.this.lAg = false;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " getScene:" + i + " will retry");
            c.this.lMM.startTimer(10000L);
            AppMethodBeat.o(20521);
            return 0;
          }
          if ((!c.this.lMH.isEmpty()) && (c.this.lMM.stopped())) {
            c.this.lMM.startTimer(500L);
          }
          if (paramAnonymousd != null)
          {
            paramAnonymousq = new c.a(c.this);
            paramAnonymousq.lMY = i;
            paramAnonymousq.errType = paramAnonymousInt1;
            paramAnonymousq.errCode = paramAnonymousInt2;
            paramAnonymousq.errMsg = paramAnonymousString;
            paramAnonymousq.lMW = ((btd)d.c.b(paramAnonymousd.lBS));
            c.this.lMI.add(paramAnonymousq);
          }
          if ((!c.this.lMI.isEmpty()) && (c.this.lMN.stopped())) {
            c.this.lMN.startTimer(50L);
          }
          AppMethodBeat.o(20521);
          return 0;
        }
      }, true);
      AppMethodBeat.o(20533);
      break;
    }
  }
  
  public final void h(String paramString1, int paramInt, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(285411);
    if (Util.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.lMM.startTimer(500L);
      }
      AppMethodBeat.o(285411);
      return;
      Object localObject = com.tencent.mm.model.z.bcZ();
      String str = com.tencent.mm.model.z.bda();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        Log.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).lvu = Util.nullAsNil(paramString2);
        ((a)localObject).lME = Util.nullAsNil(Integer.valueOf(paramInt));
        ((a)localObject).lMC = Util.nowMilliSecond();
        bool = d.blB().a((a)localObject);
      }
    }
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    btd lMW;
    int lMX = 0;
    int lMY;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.c
 * JD-Core Version:    0.7.0.1
 */