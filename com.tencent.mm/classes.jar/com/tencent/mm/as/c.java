package com.tencent.mm.as;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.exo;
import com.tencent.mm.protocal.protobuf.fwx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
  com.tencent.mm.b.f<String, Integer> oFm;
  Map<String, LinkedList<az.b.a>> oFn;
  Queue<chv> oFo;
  Queue<a> oFp;
  long oFq;
  final int oFr;
  final int oFs;
  MTimerHandler oFt;
  final MTimerHandler oFu;
  boolean orH;
  private long orS;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.orH = false;
    this.oFm = new com.tencent.mm.memory.a.c(200);
    this.oFn = new HashMap();
    this.oFo = new LinkedList();
    this.oFp = new LinkedList();
    this.oFq = 0L;
    this.oFr = 500;
    this.oFs = 10000;
    this.orS = 0L;
    this.oFt = new MTimerHandler(bh.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        Log.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.bJu();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.oFu = new MTimerHandler(bh.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.oFp.isEmpty())
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
        if (c.this.orH)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1096;
          }
          locala = (c.a)c.this.oFp.peek();
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
            bh.bCz();
            long l2 = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
            Object localObject1 = d.bJw();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).NK((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.oFD.aaqz;
                localObject1 = locala.oFD.aamU;
                Object localObject3 = locala.oFD.aaqB;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (exo)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().pI(((exo)localObject4).UserName, ((exo)localObject4).Njp);
                    }
                  }
                }
                k = locala.oFE;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  Log.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.oFp.poll();
                  if (c.this.oFp.isEmpty())
                  {
                    Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.oFq = 0L;
                    c.this.oFt.startTimer(0L);
                    bool = false;
                    break label104;
                  }
                  Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (dph)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = Util.nullAs(w.a(((dph)localObject2).ZqL), "");
                Object localObject4 = Util.nullAs(((dph)localObject2).pSk, "");
                localObject1 = Util.nullAs(((dph)localObject2).aaVR, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                localArrayList.add(localObject1);
                switch (m)
                {
                default: 
                  Log.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(com.tencent.mm.model.v.Ih((String)localObject3)) });
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new MMHandler(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      Log.i("MicroMsg.GetContactService", "callback user:%s alias:%s", new Object[] { Util.nullAs(this.hkS, ""), Util.nullAs(this.oFA, "") });
                      try
                      {
                        Object localObject2 = (LinkedList)c.this.oFn.remove(this.hkS);
                        if (Util.isNullOrNil(this.oFA)) {}
                        for (LinkedList localLinkedList = null;; localLinkedList = (LinkedList)c.this.oFn.remove(this.oFA))
                        {
                          if (localObject2 == null) {
                            break;
                          }
                          Log.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", new Object[] { Util.nullAs(this.hkS, ""), Integer.valueOf(((LinkedList)localObject2).size()) });
                          localObject2 = ((LinkedList)localObject2).iterator();
                          while (((Iterator)localObject2).hasNext()) {
                            ((az.b.a)((Iterator)localObject2).next()).getContactCallBack(this.hkS, bool);
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
                      Log.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", new Object[] { Util.nullAs(this.hkS, ""), Integer.valueOf(localObject1.size()) });
                      Iterator localIterator = localObject1.iterator();
                      while (localIterator.hasNext()) {
                        ((az.b.a)localIterator.next()).getContactCallBack(this.hkS, bool);
                      }
                      label269:
                      AppMethodBeat.o(20522);
                    }
                  });
                  locala.oFE += 1;
                  break;
                  if ((locala.oFD.aaqA == null) || (locala.oFD.aaqA.size() <= k) || (!((String)localObject3).equals(((fwx)locala.oFD.aaqA.get(k)).username))) {
                    if (locala.oFD.aaqA == null)
                    {
                      localObject1 = "null";
                      label753:
                      Log.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = Util.nullAs(((fwx)locala.oFD.aaqA.get(k)).abUM, ""))
                  {
                    Log.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s %s", new Object[] { localObject3, localObject4, localObject1, Integer.valueOf(locala.oFF) });
                    com.tencent.mm.plugin.subapp.a.pFo.a((dph)localObject2, (String)localObject1, locala.oFF);
                    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.oFD.aaqA.size());
                    break label753;
                  }
                  Log.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.bJw().NK((String)localObject3)), Boolean.valueOf(d.bJw().NK((String)localObject4)), Boolean.valueOf(com.tencent.mm.model.v.Ih((String)localObject3)) });
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            bh.bCz();
            com.tencent.mm.model.c.getDataDB().endTransaction(l2);
          }
          Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.orH + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (Util.nowMilliSecond() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1096:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private static boolean bE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = com.tencent.mm.model.z.bAM();
    String str = com.tencent.mm.model.z.bAN();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      Log.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).omQ = Util.nullAsNil(paramString2);
    ((a)localObject).oFj = Util.nowMilliSecond();
    boolean bool = d.bJw().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  private void bJt()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.bJw();
    long l = this.oFq;
    Cursor localCursor = ((b)localObject1).omV.rawQuery("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" });
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
      ((a)localObject6).oFj = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).oFk = localCursor.getInt(3);
      ((a)localObject6).omO = localCursor.getInt(4);
      ((a)localObject6).oFl = localCursor.getInt(5);
      ((a)localObject6).omQ = localCursor.getString(6);
      ((a)localObject6).omR = localCursor.getString(7);
      localObject4 = ((a)localObject6).getUsername();
      localObject3 = Util.nullAsNil(((a)localObject6).bJs());
      i = Util.nullAsNil(Integer.valueOf(((a)localObject6).oFl));
      Object localObject5 = Util.nullAsNil(((a)localObject6).bCY());
      this.oFq = ((a)localObject6).oFj;
      localObject6 = (String)localObject4 + "#" + (String)localObject3;
      int j = Util.nullAs((Integer)this.oFm.ct(localObject6), 0);
      if (j < 3)
      {
        this.oFm.B(localObject6, Integer.valueOf(j + 1));
        if (au.bwF((String)localObject4))
        {
          localObject5 = new chv();
          ((LinkedList)localObject2).add(new etl().btH((String)localObject4));
          ((LinkedList)localObject1).add(new etl().btH((String)localObject3));
          ((chv)localObject5).YFl = ((LinkedList)localObject2);
          ((chv)localObject5).aaqv = ((LinkedList)localObject1);
          this.oFo.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.oFo.size()), Integer.valueOf(((chv)localObject5).YFl.size()), localObject4 });
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
          localObject5 = new chv();
          ((chv)localObject5).YFl = ((LinkedList)localObject2);
          ((chv)localObject5).aaqr = ((LinkedList)localObject2).size();
          ((chv)localObject5).aaqv = ((LinkedList)localObject1);
          ((chv)localObject5).aaqu = ((LinkedList)localObject1).size();
          this.oFo.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d getScene=%s", new Object[] { Integer.valueOf(this.oFo.size()), Integer.valueOf(((chv)localObject5).YFl.size()), Integer.valueOf(i) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (au.bwO((String)localObject4))
        {
          localObject5 = new chv();
          ((LinkedList)localObject2).add(new etl().btH((String)localObject4));
          ((LinkedList)localObject1).add(new etl().btH((String)localObject3));
          ((chv)localObject5).YFl = ((LinkedList)localObject2);
          ((chv)localObject5).aaqv = ((LinkedList)localObject1);
          this.oFo.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.oFo.size()), Integer.valueOf(((chv)localObject5).YFl.size()), localObject4 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new etl().btH((String)localObject4), new etl().btH((String)localObject5)));
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
          ((LinkedList)localObject2).add(new etl().btH((String)localObject4));
          ((LinkedList)localObject1).add(new etl().btH((String)localObject3));
          Log.i("MicroMsg.GetContactService", "getFromDb add user:%s getScene:%s room:%s", new Object[] { localObject4, Integer.valueOf(i), localObject3 });
          continue;
          localLinkedList1.add(localObject4);
          W((String)localObject4, false);
        }
      }
    }
    localCursor.close();
    c(localSparseArray);
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = new chv();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((chv)localObject3).YFl = ((LinkedList)localObject4);
      ((chv)localObject3).aaqr = ((LinkedList)localObject4).size();
      ((chv)localObject3).aaqw = 1;
      ((chv)localObject3).aaqx = ((etl)((Pair)localObject2).second);
      this.oFo.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    if (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool2 = au.bwE((String)localObject1);
      Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool2) });
      if (bool2) {
        d.bJw().NK((String)localObject1);
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {}
      for (boolean bool1 = false;; bool1 = ((String)localObject1).endsWith("@qy_u"))
      {
        Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool2) });
        if (bool1)
        {
          d.bJw().NK((String)localObject1);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(832L, 3L, 1L, false);
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(20531);
  }
  
  private void c(SparseArray<List<String>> paramSparseArray)
  {
    AppMethodBeat.i(231913);
    int i = 0;
    while (i < paramSparseArray.size())
    {
      chv localchv = new chv();
      int j = paramSparseArray.keyAt(i);
      Object localObject = (List)paramSparseArray.valueAt(i);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localLinkedList.add(new etl().btH(str));
      }
      localchv.YFl.addAll(localLinkedList);
      localchv.aaqr = localchv.YFl.size();
      localchv.aaqw = j;
      this.oFo.add(localchv);
      Log.i("MicroMsg.GetContactService", "[buildSceneReqList] scene=%s count=%s req size=%s", new Object[] { Integer.valueOf(localchv.aaqw), Integer.valueOf(localchv.aaqr), Integer.valueOf(this.oFo.size()) });
      i += 1;
    }
    paramSparseArray.clear();
    AppMethodBeat.o(231913);
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(20525);
    try
    {
      this.oFn.remove(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(20525);
    }
  }
  
  public final void Jr(final String paramString)
  {
    AppMethodBeat.i(20529);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.oFm.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            Log.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.oFm.remove(str);
          }
          i += 1;
        }
        AppMethodBeat.o(20516);
      }
    });
    AppMethodBeat.o(20529);
  }
  
  final void W(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(20532);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.oFn.containsKey(paramString)) {}
        try
        {
          Object localObject1 = (LinkedList)c.this.oFn.get(paramString);
          c.this.oFn.remove(paramString);
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
    if (bE(paramString1, paramString2))
    {
      if (parama != null) {
        break label99;
      }
      Log.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", new Object[] { Util.nullAs(paramString1, "") });
    }
    for (;;)
    {
      this.oFt.startTimer(0L);
      AppMethodBeat.o(20528);
      return;
      try
      {
        label99:
        Object localObject = (LinkedList)this.oFn.get(paramString1);
        paramString2 = (String)localObject;
        if (localObject == null)
        {
          localObject = this.oFn;
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
  
  public final void aZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    Log.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + Util.getStack());
    if (bE(paramString1, paramString2)) {
      this.oFt.startTimer(500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void bCc()
  {
    AppMethodBeat.i(231936);
    Log.i("MicroMsg.GetContactService", "[checkPendingGetContact] %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.subapp.a.pFo.aDE()) });
    this.oFt.startTimer(500L);
    AppMethodBeat.o(231936);
  }
  
  final void bJu()
  {
    long l;
    try
    {
      AppMethodBeat.i(20533);
      if (com.tencent.mm.plugin.subapp.a.pFo.aDE())
      {
        Log.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        AppMethodBeat.o(20533);
      }
      for (;;)
      {
        return;
        l = Util.nowMilliSecond();
        if ((this.orH) && (l - this.orS > 600000L))
        {
          Log.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.orS) });
          this.orH = false;
        }
        if (!this.orH) {
          break;
        }
        Log.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.orH + " ret");
        AppMethodBeat.o(20533);
      }
      localObject2 = (chv)this.oFo.poll();
    }
    finally {}
    Object localObject2;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      bJt();
      for (localObject2 = (chv)this.oFo.poll(); ((localObject2 == null) || (((chv)localObject2).YFl == null) || (((chv)localObject2).YFl.size() == 0)) && (this.oFo.size() > 0); localObject2 = (chv)this.oFo.poll()) {}
      if ((localObject2 != null) && (((chv)localObject2).YFl != null))
      {
        localObject3 = localObject2;
        if (((chv)localObject2).YFl.size() != 0) {}
      }
      else
      {
        if (localObject2 != null) {
          break label727;
        }
      }
    }
    label727:
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicroMsg.GetContactService", "tryStartNetscene Not any more contact. req is null? %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(20533);
      break;
      this.orS = l;
      this.orH = true;
      localObject2 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((chv)localObject3).YFl.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = w.a((etl)((Iterator)localObject5).next());
        if (au.bwF((String)localObject6)) {
          ((LinkedList)localObject2).add(localObject6);
        }
        if (au.bwO((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject2).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject2).get(0);
        if (au.bwF((String)localObject2)) {
          com.tencent.mm.roomsdk.model.b.btW((String)localObject2).CP((String)localObject2).d(new com.tencent.mm.roomsdk.model.b.b()
          {
            public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
            {
              AppMethodBeat.i(231912);
              c.this.orH = false;
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                Log.e("MicroMsg.ActionCallbackFunc", "tryStartNetscene onSceneEnd openRoom errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " will retry");
                c.this.oFt.startTimer(10000L);
                c.this.W(this.lzC, false);
                AppMethodBeat.o(231912);
                return;
              }
              if ((!c.this.oFo.isEmpty()) && (c.this.oFt.stopped())) {
                c.this.oFt.startTimer(500L);
              }
              Log.i("MicroMsg.ActionCallbackFunc", "getChatRoomInfoDetail onResult %s %s", new Object[] { Boolean.valueOf(d.bJw().NK(this.lzC)), this.lzC });
              c.this.W(this.lzC, true);
              AppMethodBeat.o(231912);
            }
          }).blj();
        }
        AppMethodBeat.o(20533);
        break;
      }
      if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new cop();
        ((cop)localObject6).psp = ((String)localObject5);
        localObject4 = "";
        localObject2 = localObject4;
        if (((chv)localObject3).aaqv != null)
        {
          localObject2 = localObject4;
          if (((chv)localObject3).aaqv.size() > 0) {
            localObject2 = w.a((etl)((chv)localObject3).aaqv.get(0));
          }
        }
        ((cop)localObject6).hMM = ((String)localObject2);
        localObject3 = new com.tencent.mm.am.c.a();
        ((com.tencent.mm.am.c.a)localObject3).otE = ((com.tencent.mm.bx.a)localObject6);
        ((com.tencent.mm.am.c.a)localObject3).otF = new coq();
        ((com.tencent.mm.am.c.a)localObject3).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((com.tencent.mm.am.c.a)localObject3).funcId = 881;
        Log.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject2, localObject5 });
        com.tencent.mm.am.z.a(((com.tencent.mm.am.c.a)localObject3).bEF(), new z.a()
        {
          public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousp.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.orH = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.oFy });
              if (paramAnonymousInt1 == 4) {
                d.bJw().NK(this.oFy);
              }
              c.this.oFt.startTimer(10000L);
              c.this.W(this.oFy, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.oFo.isEmpty()) && (c.this.oFt.stopped())) {
              c.this.oFt.startTimer(500L);
            }
            com.tencent.mm.openim.model.v.a((coq)c.c.b(paramAnonymousc.otC));
            Log.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.bJw().NK(this.oFy)), this.oFy });
            c.this.W(this.oFy, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
        break;
      }
      localObject2 = new com.tencent.mm.am.c.a();
      ((com.tencent.mm.am.c.a)localObject2).otE = ((com.tencent.mm.bx.a)localObject3);
      ((com.tencent.mm.am.c.a)localObject2).otF = new chw();
      ((com.tencent.mm.am.c.a)localObject2).uri = "/cgi-bin/micromsg-bin/getcontact";
      ((com.tencent.mm.am.c.a)localObject2).funcId = 182;
      final int i = ((chv)localObject3).aaqw;
      com.tencent.mm.am.z.a(((com.tencent.mm.am.c.a)localObject2).bEF(), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(20521);
          if (paramAnonymousp.getType() != 182)
          {
            AppMethodBeat.o(20521);
            return 0;
          }
          c.this.orH = false;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " getScene:" + i + " will retry");
            c.this.oFt.startTimer(10000L);
            AppMethodBeat.o(20521);
            return 0;
          }
          if ((!c.this.oFo.isEmpty()) && (c.this.oFt.stopped())) {
            c.this.oFt.startTimer(500L);
          }
          if (paramAnonymousc != null)
          {
            paramAnonymousp = new c.a(c.this);
            paramAnonymousp.oFF = i;
            paramAnonymousp.errType = paramAnonymousInt1;
            paramAnonymousp.errCode = paramAnonymousInt2;
            paramAnonymousp.errMsg = paramAnonymousString;
            paramAnonymousp.oFD = ((chw)c.c.b(paramAnonymousc.otC));
            c.this.oFp.add(paramAnonymousp);
          }
          if ((!c.this.oFp.isEmpty()) && (c.this.oFu.stopped())) {
            c.this.oFu.startTimer(50L);
          }
          AppMethodBeat.o(20521);
          return 0;
        }
      }, true);
      AppMethodBeat.o(20533);
      break;
    }
  }
  
  public final void j(String paramString1, int paramInt, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(231921);
    if (Util.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.oFt.startTimer(500L);
      }
      AppMethodBeat.o(231921);
      return;
      Object localObject = com.tencent.mm.model.z.bAM();
      String str = com.tencent.mm.model.z.bAN();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        Log.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).omR = Util.nullAsNil(paramString2);
        ((a)localObject).oFl = Util.nullAsNil(Integer.valueOf(paramInt));
        ((a)localObject).oFj = Util.nowMilliSecond();
        bool = d.bJw().a((a)localObject);
      }
    }
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    chw oFD;
    int oFE = 0;
    int oFF;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.c
 * JD-Core Version:    0.7.0.1
 */