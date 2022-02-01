package com.tencent.mm.at;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.b.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  implements ay.b
{
  boolean iKb;
  private long iKm;
  f<String, Integer> iWk;
  Map<String, LinkedList<ay.b.a>> iWl;
  Queue<blt> iWm;
  Queue<a> iWn;
  long iWo;
  final int iWp;
  final int iWq;
  MTimerHandler iWr;
  final MTimerHandler iWs;
  
  c()
  {
    AppMethodBeat.i(20524);
    this.iKb = false;
    this.iWk = new com.tencent.mm.memory.a.c(200);
    this.iWl = new HashMap();
    this.iWm = new LinkedList();
    this.iWn = new LinkedList();
    this.iWo = 0L;
    this.iWp = 500;
    this.iWq = 10000;
    this.iKm = 0L;
    this.iWr = new MTimerHandler(bg.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20517);
        Log.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
        c.this.bck();
        AppMethodBeat.o(20517);
        return false;
      }
    }, false);
    this.iWs = new MTimerHandler(bg.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(20523);
        if (c.this.iWn.isEmpty())
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
        if (c.this.iKb)
        {
          i = 5;
          localArrayList = new ArrayList(i * 2);
          j = 0;
          if (j >= i) {
            break label1096;
          }
          locala = (c.a)c.this.iWn.peek();
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
            bg.aVF();
            long l2 = com.tencent.mm.model.c.getDataDB().beginTransaction(Thread.currentThread().getId());
            Object localObject1 = d.bcm();
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                ((b)localObject1).On((String)localArrayList.get(j));
                j += 1;
                continue;
                i = 15;
                break;
                label172:
                Object localObject2 = locala.iWB.LUC;
                localObject1 = locala.iWB.LRr;
                Object localObject3 = locala.iWB.LUE;
                if ((localObject3 != null) && (((LinkedList)localObject3).size() > 0))
                {
                  localObject3 = ((LinkedList)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject4 = (dtv)((Iterator)localObject3).next();
                    if (localObject4 != null) {
                      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().mS(((dtv)localObject4).UserName, ((dtv)localObject4).Bri);
                    }
                  }
                }
                k = locala.iWC;
                if (((LinkedList)localObject1).size() != ((LinkedList)localObject2).size()) {
                  Log.w("MicroMsg.GetContactService", "find warn %s %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((LinkedList)localObject2).size()) });
                }
                int m = Math.min(((LinkedList)localObject1).size(), ((LinkedList)localObject2).size());
                if (m <= k)
                {
                  c.this.iWn.poll();
                  if (c.this.iWn.isEmpty())
                  {
                    Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                    c.this.iWo = 0L;
                    c.this.iWr.startTimer(0L);
                    bool = false;
                    break label104;
                  }
                  Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
                  j += 1;
                  break label67;
                }
                localObject2 = (cpl)((LinkedList)localObject2).get(k);
                m = ((Integer)((LinkedList)localObject1).get(k)).intValue();
                localObject3 = Util.nullAs(com.tencent.mm.platformtools.z.a(((cpl)localObject2).Lqk), "");
                Object localObject4 = Util.nullAs(((cpl)localObject2).ked, "");
                localObject1 = Util.nullAs(((cpl)localObject2).Mvn, "");
                localArrayList.add(localObject3);
                localArrayList.add(localObject4);
                localArrayList.add(localObject1);
                switch (m)
                {
                default: 
                  Log.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(v.HY((String)localObject3)) });
                  e.Cxv.idkeyStat(832L, 2L, 1L, false);
                  bool = false;
                }
                for (;;)
                {
                  new MMHandler(Looper.getMainLooper()).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(20522);
                      Log.i("MicroMsg.GetContactService", "callback user:%s alias:%s", new Object[] { Util.nullAs(this.dod, ""), Util.nullAs(this.iWy, "") });
                      try
                      {
                        Object localObject2 = (LinkedList)c.this.iWl.remove(this.dod);
                        if (Util.isNullOrNil(this.iWy)) {}
                        for (LinkedList localLinkedList = null;; localLinkedList = (LinkedList)c.this.iWl.remove(this.iWy))
                        {
                          if (localObject2 == null) {
                            break;
                          }
                          Log.i("MicroMsg.GetContactService", "callback userCallbackContainer user:%s size:%s", new Object[] { Util.nullAs(this.dod, ""), Integer.valueOf(((LinkedList)localObject2).size()) });
                          localObject2 = ((LinkedList)localObject2).iterator();
                          while (((Iterator)localObject2).hasNext()) {
                            ((ay.b.a)((Iterator)localObject2).next()).p(this.dod, bool);
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
                      Log.i("MicroMsg.GetContactService", "callback aliasCallbackContainer user:%s size:%s", new Object[] { Util.nullAs(this.dod, ""), Integer.valueOf(localObject1.size()) });
                      Iterator localIterator = localObject1.iterator();
                      while (localIterator.hasNext()) {
                        ((ay.b.a)localIterator.next()).p(this.dod, bool);
                      }
                      label269:
                      AppMethodBeat.o(20522);
                    }
                  });
                  locala.iWC += 1;
                  break;
                  if ((locala.iWB.LUD == null) || (locala.iWB.LUD.size() <= k) || (!((String)localObject3).equals(((eqf)locala.iWB.LUD.get(k)).username))) {
                    if (locala.iWB.LUD == null)
                    {
                      localObject1 = "null";
                      label753:
                      Log.w("MicroMsg.GetContactService", "get antispamticket from resp failed: list:%s idx:%d  user:%s", new Object[] { localObject1, Integer.valueOf(k), localObject3 });
                    }
                  }
                  for (localObject1 = "";; localObject1 = Util.nullAs(((eqf)locala.iWB.LUD.get(k)).NnM, ""))
                  {
                    Log.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s %s", new Object[] { localObject3, localObject4, localObject1, Integer.valueOf(locala.iWD) });
                    com.tencent.mm.plugin.subapp.b.jRu.a((cpl)localObject2, (String)localObject1, locala.iWD);
                    e.Cxv.idkeyStat(832L, 0L, 1L, false);
                    bool = true;
                    break;
                    localObject1 = Integer.valueOf(locala.iWB.LUD.size());
                    break label753;
                  }
                  Log.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[] { Integer.valueOf(m), localObject3, localObject4, Boolean.valueOf(d.bcm().On((String)localObject3)), Boolean.valueOf(d.bcm().On((String)localObject4)), Boolean.valueOf(v.HY((String)localObject3)) });
                  e.Cxv.idkeyStat(832L, 1L, 1L, false);
                  bool = false;
                }
              }
            }
            bg.aVF();
            com.tencent.mm.model.c.getDataDB().endTransaction(l2);
          }
          Log.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + c.this.iKb + " ret: " + bool + " maxCnt: " + i + " deleteCount: " + k + " take: " + (Util.nowMilliSecond() - l1) + "ms");
          AppMethodBeat.o(20523);
          return bool;
          label1096:
          bool = true;
        }
      }
    }, true);
    AppMethodBeat.o(20524);
  }
  
  private void bcj()
  {
    AppMethodBeat.i(20531);
    Object localObject1 = d.bcm();
    long l = this.iWo;
    Cursor localCursor = ((b)localObject1).iFy.rawQuery("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" });
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
      ((a)localObject6).iWh = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).iWi = localCursor.getInt(3);
      ((a)localObject6).iFr = localCursor.getInt(4);
      ((a)localObject6).iWj = localCursor.getInt(5);
      ((a)localObject6).iFt = localCursor.getString(6);
      ((a)localObject6).iFu = localCursor.getString(7);
      localObject4 = ((a)localObject6).getUsername();
      localObject3 = Util.nullAsNil(((a)localObject6).bci());
      i = Util.nullAsNil(Integer.valueOf(((a)localObject6).iWj));
      Object localObject5 = Util.nullAsNil(((a)localObject6).aWe());
      this.iWo = ((a)localObject6).iWh;
      localObject6 = (String)localObject4 + "#" + (String)localObject3;
      int j = Util.nullAs((Integer)this.iWk.aT(localObject6), 0);
      if (j < 3)
      {
        this.iWk.x(localObject6, Integer.valueOf(j + 1));
        if (ab.Iy((String)localObject4))
        {
          localObject5 = new blt();
          ((LinkedList)localObject2).add(new dqi().bhy((String)localObject4));
          ((LinkedList)localObject1).add(new dqi().bhy((String)localObject3));
          ((blt)localObject5).KGP = ((LinkedList)localObject2);
          ((blt)localObject5).LUy = ((LinkedList)localObject1);
          this.iWm.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.iWm.size()), Integer.valueOf(((blt)localObject5).KGP.size()), localObject4 });
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
          localObject5 = new blt();
          ((blt)localObject5).KGP = ((LinkedList)localObject2);
          ((blt)localObject5).LUu = ((LinkedList)localObject2).size();
          ((blt)localObject5).LUy = ((LinkedList)localObject1);
          ((blt)localObject5).LUx = ((LinkedList)localObject1).size();
          this.iWm.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d getScene=%s", new Object[] { Integer.valueOf(this.iWm.size()), Integer.valueOf(((blt)localObject5).KGP.size()), Integer.valueOf(i) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (as.bjp((String)localObject4))
        {
          localObject5 = new blt();
          ((LinkedList)localObject2).add(new dqi().bhy((String)localObject4));
          ((LinkedList)localObject1).add(new dqi().bhy((String)localObject3));
          ((blt)localObject5).KGP = ((LinkedList)localObject2);
          ((blt)localObject5).LUy = ((LinkedList)localObject1);
          this.iWm.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          Log.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.iWm.size()), Integer.valueOf(((blt)localObject5).KGP.size()), localObject4 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new dqi().bhy((String)localObject4), new dqi().bhy((String)localObject5)));
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
          ((LinkedList)localObject2).add(new dqi().bhy((String)localObject4));
          ((LinkedList)localObject1).add(new dqi().bhy((String)localObject3));
          Log.i("MicroMsg.GetContactService", "getFromDb add user:%s getScene:%s room:%s", new Object[] { localObject4, Integer.valueOf(i), localObject3 });
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
      localObject3 = new blt();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((blt)localObject3).KGP = ((LinkedList)localObject4);
      ((blt)localObject3).LUu = ((LinkedList)localObject4).size();
      ((blt)localObject3).LUz = 1;
      ((blt)localObject3).LUA = ((dqi)((Pair)localObject2).second);
      this.iWm.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = ab.Eq((String)localObject1);
      Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.bcm().On((String)localObject1);
      }
      boolean bool2 = ab.IF((String)localObject1);
      Log.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.bcm().On((String)localObject1);
        e.Cxv.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(20531);
  }
  
  private static boolean bp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20530);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20530);
      return false;
    }
    Object localObject = com.tencent.mm.model.z.aTY();
    String str = com.tencent.mm.model.z.aTZ();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      Log.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(20530);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).iFt = Util.nullAsNil(paramString2);
    ((a)localObject).iWh = Util.nowMilliSecond();
    boolean bool = d.bcm().a((a)localObject);
    AppMethodBeat.o(20530);
    return bool;
  }
  
  private void c(SparseArray<List<String>> paramSparseArray)
  {
    AppMethodBeat.i(231547);
    int i = 0;
    while (i < paramSparseArray.size())
    {
      blt localblt = new blt();
      int j = paramSparseArray.keyAt(i);
      Object localObject = (List)paramSparseArray.valueAt(i);
      LinkedList localLinkedList = new LinkedList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localLinkedList.add(new dqi().bhy(str));
      }
      localblt.KGP.addAll(localLinkedList);
      localblt.LUu = localblt.KGP.size();
      localblt.LUz = j;
      this.iWm.add(localblt);
      Log.i("MicroMsg.GetContactService", "[buildSceneReqList] scene=%s count=%s req size=%s", new Object[] { Integer.valueOf(localblt.LUz), Integer.valueOf(localblt.LUu), Integer.valueOf(this.iWm.size()) });
      i += 1;
    }
    paramSparseArray.clear();
    AppMethodBeat.o(231547);
  }
  
  public final void JZ(String paramString)
  {
    AppMethodBeat.i(20525);
    try
    {
      this.iWl.remove(paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(20525);
    }
  }
  
  public final void Ka(final String paramString)
  {
    AppMethodBeat.i(20529);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20516);
        Object[] arrayOfObject = c.this.iWk.keySet().toArray();
        int i = 0;
        while (i < arrayOfObject.length)
        {
          String str = (String)arrayOfObject[i];
          if (str.startsWith(paramString))
          {
            Log.d("MicroMsg.GetContactService", "clearMapRecentDown(): key = %s", new Object[] { str });
            c.this.iWk.remove(str);
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
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20518);
        if (c.this.iWl.containsKey(paramString)) {
          try
          {
            Object localObject1 = (LinkedList)c.this.iWl.get(paramString);
            c.this.iWl.remove(paramString);
            if (localObject1 != null)
            {
              localObject1 = ((LinkedList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                ((ay.b.a)((Iterator)localObject1).next()).p(paramString, paramBoolean);
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
  
  public final void a(String paramString1, String paramString2, ay.b.a parama)
  {
    AppMethodBeat.i(20528);
    Log.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + Util.getStack());
    if (bp(paramString1, paramString2))
    {
      if (parama != null) {
        break label99;
      }
      Log.i("MicroMsg.GetContactService", "addGetContactCallBack %s, addGetContactCallBack is null", new Object[] { Util.nullAs(paramString1, "") });
    }
    for (;;)
    {
      this.iWr.startTimer(0L);
      AppMethodBeat.o(20528);
      return;
      try
      {
        label99:
        Object localObject = (LinkedList)this.iWl.get(paramString1);
        paramString2 = (String)localObject;
        if (localObject == null)
        {
          localObject = this.iWl;
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
  
  public final void aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20526);
    Log.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + Util.getStack());
    if (bp(paramString1, paramString2)) {
      this.iWr.startTimer(500L);
    }
    AppMethodBeat.o(20526);
  }
  
  public final void aVg()
  {
    AppMethodBeat.i(231546);
    Log.i("MicroMsg.GetContactService", "[checkPendingGetContact] %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.subapp.b.jRu.Xf()) });
    this.iWr.startTimer(500L);
    AppMethodBeat.o(231546);
  }
  
  final void bck()
  {
    long l;
    try
    {
      AppMethodBeat.i(20533);
      if (com.tencent.mm.plugin.subapp.b.jRu.Xf())
      {
        Log.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
        AppMethodBeat.o(20533);
      }
      for (;;)
      {
        return;
        l = Util.nowMilliSecond();
        if ((this.iKb) && (l - this.iKm > 600000L))
        {
          Log.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.iKm) });
          this.iKb = false;
        }
        if (!this.iKb) {
          break;
        }
        Log.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.iKb + " ret");
        AppMethodBeat.o(20533);
      }
      localObject2 = (blt)this.iWm.poll();
    }
    finally {}
    Object localObject2;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      bcj();
      for (localObject2 = (blt)this.iWm.poll(); ((localObject2 == null) || (((blt)localObject2).KGP == null) || (((blt)localObject2).KGP.size() == 0)) && (this.iWm.size() > 0); localObject2 = (blt)this.iWm.poll()) {}
      if ((localObject2 != null) && (((blt)localObject2).KGP != null))
      {
        localObject3 = localObject2;
        if (((blt)localObject2).KGP.size() != 0) {}
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
      this.iKm = l;
      this.iKb = true;
      localObject2 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((blt)localObject3).KGP.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = com.tencent.mm.platformtools.z.a((dqi)((Iterator)localObject5).next());
        if (ab.Iy((String)localObject6)) {
          ((LinkedList)localObject2).add(localObject6);
        }
        if (as.bjp((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject2).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject2).get(0);
        if (ab.Iy((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.bhF((String)localObject2).Dt((String)localObject2).d(new com.tencent.mm.roomsdk.a.b.b() {}).aJu();
        }
        AppMethodBeat.o(20533);
        break;
      }
      if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new bro();
        ((bro)localObject6).jGZ = ((String)localObject5);
        localObject4 = "";
        localObject2 = localObject4;
        if (((blt)localObject3).LUy != null)
        {
          localObject2 = localObject4;
          if (((blt)localObject3).LUy.size() > 0) {
            localObject2 = com.tencent.mm.platformtools.z.a((dqi)((blt)localObject3).LUy.get(0));
          }
        }
        ((bro)localObject6).dOe = ((String)localObject2);
        localObject3 = new d.a();
        ((d.a)localObject3).iLN = ((com.tencent.mm.bw.a)localObject6);
        ((d.a)localObject3).iLO = new brp();
        ((d.a)localObject3).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((d.a)localObject3).funcId = 881;
        Log.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject2, localObject5 });
        aa.a(((d.a)localObject3).aXF(), new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
          {
            AppMethodBeat.i(20520);
            if (paramAnonymousq.getType() != 881)
            {
              AppMethodBeat.o(20520);
              return 0;
            }
            c.this.iKb = false;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd openImUser errType: %s  errCode: %s username %s will retry/del ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), this.iWw });
              if (paramAnonymousInt1 == 4) {
                d.bcm().On(this.iWw);
              }
              c.this.iWr.startTimer(10000L);
              c.this.Q(this.iWw, false);
              AppMethodBeat.o(20520);
              return 0;
            }
            if ((!c.this.iWm.isEmpty()) && (c.this.iWr.stopped())) {
              c.this.iWr.startTimer(500L);
            }
            s.a((brp)paramAnonymousd.iLL.iLR);
            Log.i("MicroMsg.GetContactService", "getopenimcontact onResult %s %s", new Object[] { Boolean.valueOf(d.bcm().On(this.iWw)), this.iWw });
            c.this.Q(this.iWw, true);
            AppMethodBeat.o(20520);
            return 0;
          }
        }, true);
        AppMethodBeat.o(20533);
        break;
      }
      localObject2 = new d.a();
      ((d.a)localObject2).iLN = ((com.tencent.mm.bw.a)localObject3);
      ((d.a)localObject2).iLO = new blu();
      ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/getcontact";
      ((d.a)localObject2).funcId = 182;
      final int i = ((blt)localObject3).LUz;
      aa.a(((d.a)localObject2).aXF(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(20521);
          if (paramAnonymousq.getType() != 182)
          {
            AppMethodBeat.o(20521);
            return 0;
          }
          c.this.iKb = false;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " getScene:" + i + " will retry");
            c.this.iWr.startTimer(10000L);
            AppMethodBeat.o(20521);
            return 0;
          }
          if ((!c.this.iWm.isEmpty()) && (c.this.iWr.stopped())) {
            c.this.iWr.startTimer(500L);
          }
          if (paramAnonymousd != null)
          {
            paramAnonymousq = new c.a(c.this);
            paramAnonymousq.iWD = i;
            paramAnonymousq.errType = paramAnonymousInt1;
            paramAnonymousq.errCode = paramAnonymousInt2;
            paramAnonymousq.errMsg = paramAnonymousString;
            paramAnonymousq.iWB = ((blu)paramAnonymousd.iLL.iLR);
            c.this.iWn.add(paramAnonymousq);
          }
          if ((!c.this.iWn.isEmpty()) && (c.this.iWs.stopped())) {
            c.this.iWs.startTimer(50L);
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
    AppMethodBeat.i(231545);
    if (Util.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.iWr.startTimer(500L);
      }
      AppMethodBeat.o(231545);
      return;
      Object localObject = com.tencent.mm.model.z.aTY();
      String str = com.tencent.mm.model.z.aTZ();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        Log.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).iFu = Util.nullAsNil(paramString2);
        ((a)localObject).iWj = Util.nullAsNil(Integer.valueOf(paramInt));
        ((a)localObject).iWh = Util.nowMilliSecond();
        bool = d.bcm().a((a)localObject);
      }
    }
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    blu iWB;
    int iWC = 0;
    int iWD;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.c
 * JD-Core Version:    0.7.0.1
 */