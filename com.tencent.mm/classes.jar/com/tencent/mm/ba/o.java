package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.pd.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  implements i, com.tencent.mm.plugin.messenger.foundation.a.a.j
{
  public HashMap<Integer, HashSet<WeakReference<j.a>>> bGH;
  boolean iKb;
  long iKm;
  f<Integer, Integer> iWk;
  private final int iWp;
  MTimerHandler iWr;
  private f<Integer, Integer> jgs;
  j jgt;
  
  public o(j paramj)
  {
    AppMethodBeat.i(116849);
    this.iKb = false;
    this.iWk = new c(200);
    this.jgs = new c(200);
    this.bGH = new HashMap();
    this.iKm = 0L;
    this.iWp = 500;
    this.iWr = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(116843);
        Log.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        o localo = o.this;
        long l = Util.nowMilliSecond();
        if ((localo.iKb) && (l - localo.iKm > 10000L)) {
          localo.iKb = false;
        }
        if (localo.iKb) {
          Log.w("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
        }
        for (;;)
        {
          AppMethodBeat.o(116843);
          return false;
          Object localObject1 = localo.jgt;
          ArrayList localArrayList = new ArrayList();
          localObject1 = ((j)localObject1).iFy.rawQuery("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" });
          if (localObject1 == null) {}
          Object localObject2;
          for (;;)
          {
            if (localArrayList.size() != 0) {
              break label305;
            }
            Log.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
            break;
            int j = ((Cursor)localObject1).getCount();
            if (j > 0)
            {
              int i = 0;
              while (i < j)
              {
                ((Cursor)localObject1).moveToPosition(i);
                localObject2 = new k.b(0);
                ((k.b)localObject2).id = ((Cursor)localObject1).getInt(0);
                ((k.b)localObject2).iWh = ((Cursor)localObject1).getLong(1);
                ((k.b)localObject2).cmdId = ((Cursor)localObject1).getInt(2);
                ((k.b)localObject2).buffer = ((Cursor)localObject1).getBlob(3);
                ((k.b)localObject2).zqr = ((Cursor)localObject1).getInt(4);
                ((k.b)localObject2).zqs = ((Cursor)localObject1).getLong(5);
                ((k.b)localObject2).zqt = ((Cursor)localObject1).getString(6);
                ((k.b)localObject2).zqu = ((Cursor)localObject1).getString(7);
                localArrayList.add(localObject2);
                i += 1;
              }
            }
            ((Cursor)localObject1).close();
          }
          label305:
          if ((!localo.iKb) && (localArrayList.size() > 0))
          {
            localo.iKm = l;
            localo.iKb = true;
            localObject1 = new LinkedList();
            localObject2 = localArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              k.b localb = (k.b)((Iterator)localObject2).next();
              if ((localb.getCmdId() == 0) && (localb.zqr > 0)) {
                ((List)localObject1).add(localb);
              }
            }
            localArrayList.removeAll((Collection)localObject1);
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (k.b)((Iterator)localObject1).next();
              if ("@openim".equals(((k.b)localObject2).zqt))
              {
                g.aAi();
                g.aAg().hqi.a(new l((k.b)localObject2), 0);
              }
              else
              {
                localo.jgt.c((k.b)localObject2);
              }
            }
            if (!localArrayList.isEmpty())
            {
              g.aAi();
              g.aAg().hqi.a(new b(localArrayList), 0);
            }
          }
          Log.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", new Object[] { Long.valueOf(localo.iKm), Boolean.valueOf(localo.iKb), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localArrayList.size()) });
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(116844);
        String str = super.toString() + "|pusherTry";
        AppMethodBeat.o(116844);
        return str;
      }
    }, false);
    this.bGH = new HashMap();
    this.jgt = paramj;
    g.aAi();
    g.aAg().hqi.a(681, this);
    g.aAi();
    g.aAg().hqi.a(806, this);
    AppMethodBeat.o(116849);
  }
  
  public final void a(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116850);
    HashSet localHashSet = (HashSet)this.bGH.get(Integer.valueOf(paramInt));
    if (localHashSet == null) {
      localHashSet = new HashSet();
    }
    for (;;)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (((j.a)localWeakReference.get()).equals(parama)))
        {
          AppMethodBeat.o(116850);
          return;
        }
      }
      localHashSet.add(new WeakReference(parama));
      this.bGH.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(116850);
      return;
    }
  }
  
  final void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116852);
    Object localObject = (HashSet)this.bGH.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      AppMethodBeat.o(116852);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        localLinkedList.add(localWeakReference.get());
      }
    }
    localObject = localLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((j.a)((Iterator)localObject).next()).F(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
    AppMethodBeat.o(116852);
  }
  
  public final void b(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116851);
    HashSet localHashSet = (HashSet)this.bGH.get(Integer.valueOf(paramInt));
    if (localHashSet == null)
    {
      AppMethodBeat.o(116851);
      return;
    }
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((j.a)localWeakReference.get()).equals(parama)))
      {
        localHashSet.remove(localWeakReference);
        AppMethodBeat.o(116851);
        return;
      }
    }
    if (localHashSet.size() == 0)
    {
      this.bGH.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(116851);
      return;
    }
    this.bGH.put(Integer.valueOf(paramInt), localHashSet);
    AppMethodBeat.o(116851);
  }
  
  public final void d(k.b paramb)
  {
    AppMethodBeat.i(116853);
    int i;
    if (paramb != null)
    {
      int j = paramb.getCmdId();
      if (paramb.getBuffer() == null)
      {
        i = -1;
        Log.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Util.getStack() });
        paramb.iWh = Util.nowMilliSecond();
        j localj = this.jgt;
        if (paramb != null)
        {
          paramb.cSx = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.cSx & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.iWh));
          }
          if ((paramb.cSx & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.cSx & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.cSx & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.zqr));
          }
          if ((paramb.cSx & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.zqs));
          }
          if ((paramb.cSx & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.zqt);
          }
          if ((paramb.cSx & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.zqu);
          }
          i = (int)localj.iFy.insert("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.iWr.startTimer(0L);
      AppMethodBeat.o(116853);
      return;
      i = paramb.getBuffer().length;
      break;
      Log.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  public final void e(k.b paramb)
  {
    AppMethodBeat.i(116854);
    g.aAi();
    long l = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
    this.jgt.c(paramb);
    g.aAi();
    g.aAh().hqK.endTransaction(l);
    AppMethodBeat.o(116854);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(116855);
    Log.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramq.getType() == 806)
    {
      localObject2 = (cwl)((d)paramq.getReqResp()).iLL.iLR;
      localObject1 = ((l)paramq).jHe;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramq instanceof l))
        {
          AppMethodBeat.o(116855);
          return;
        }
        if (((cwl)localObject2).getBaseResponse() == null) {
          break label985;
        }
      }
    }
    label944:
    label959:
    label985:
    for (paramInt1 = ((cwl)localObject2).getBaseResponse().Ret;; paramInt1 = 0)
    {
      paramString = new pd();
      paramString.dVh.ret = paramInt1;
      EventCenter.instance.publish(paramString);
      b(((k.b)localObject1).getCmdId(), paramInt1, "", "");
      Log.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((k.b)localObject1).zqr), Integer.valueOf(((k.b)localObject1).getCmdId()) });
      this.jgt.c((k.b)localObject1);
      this.iKb = false;
      paramString = this.iWr;
      if (this.iWk.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.startTimer(l);
        AppMethodBeat.o(116855);
        return;
      }
      if ((localObject2 != null) && (((cwl)localObject2).getBaseResponse() != null)) {}
      for (paramq = z.a(((cwl)localObject2).getBaseResponse().ErrMsg);; paramq = "")
      {
        if (Util.isNullOrNil(paramq)) {}
        for (;;)
        {
          paramInt1 = ((k.b)localObject1).getCmdId();
          b(((k.b)localObject1).getCmdId(), -1, "", paramString);
          this.iKb = false;
          paramString = (Integer)this.jgs.aT(Integer.valueOf(paramInt1));
          Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).iWh), paramString });
          if (paramString == null)
          {
            this.jgs.x(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(116855);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.jgs.x(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(116855);
            return;
          }
          Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).iWh) });
          this.jgt.c((k.b)localObject1);
          AppMethodBeat.o(116855);
          return;
          if (paramq.getType() != 681)
          {
            AppMethodBeat.o(116855);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramq).jgb == null))
          {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramq).jgb.toString() });
            this.iKb = false;
            AppMethodBeat.o(116855);
            return;
          }
          localObject1 = ((b.c)((b)paramq).jgb.getRespObj()).jgg;
          if ((((cxn)localObject1).Ret != 0) || (((cxn)localObject1).MBY == null) || (((cxn)localObject1).MBY.LRr == null))
          {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((cxn)localObject1).Ret) });
            this.iKb = false;
            AppMethodBeat.o(116855);
            return;
          }
          if ((((cxn)localObject1).MBY == null) || (((cxn)localObject1).MBY.LRr.size() == 0)) {}
          for (;;)
          {
            new a(this, ((b)paramq).jgc, ((cxn)localObject1).MBY.LRr, ((cxn)localObject1).MBY.MBZ).startTimer(50L);
            AppMethodBeat.o(116855);
            return;
            localObject2 = new pd();
            ((pd)localObject2).dVh.ret = ((Integer)((cxn)localObject1).MBY.LRr.getLast()).intValue();
            LinkedList localLinkedList = ((cxn)localObject1).MBY.MBZ;
            pd.a locala = ((pd)localObject2).dVh;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.dVi = paramString;
              locala = ((pd)localObject2).dVh;
              if (!localLinkedList.isEmpty()) {
                break label944;
              }
            }
            for (paramString = "";; paramString = ((cxl)localLinkedList.getLast()).iAc)
            {
              locala.dVj = paramString;
              if ((!Util.isNullOrNil(((pd)localObject2).dVh.dVi)) || (!Util.isNullOrNil(((pd)localObject2).dVh.dVj))) {
                break label959;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((pd)localObject2).dVh.dVi = ((cxl)localLinkedList.get(paramInt1)).Title;
                ((pd)localObject2).dVh.dVj = ((cxl)localLinkedList.get(paramInt1)).iAc;
                if ((!Util.isNullOrNil(((pd)localObject2).dVh.dVi)) || (!Util.isNullOrNil(((pd)localObject2).dVh.dVj))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((cxl)localLinkedList.getLast()).Title;
              break;
            }
            EventCenter.instance.publish((IEvent)localObject2);
          }
          paramString = paramq;
        }
      }
    }
  }
  
  final class a
    extends MTimerHandler
  {
    public a(final List<k.b> paramList, final LinkedList<Integer> paramLinkedList, final LinkedList<cxl> paramLinkedList1)
    {
      super(new MTimerHandler.CallBack()
      {
        private int jcH = 0;
        private int successCount = 0;
        
        public final boolean onTimerExpired()
        {
          int j = 0;
          AppMethodBeat.i(116846);
          final int k = paramLinkedList.size();
          int m = paramLinkedList1.size();
          int i;
          ArrayList localArrayList;
          Object localObject;
          if (k < m)
          {
            i = k;
            if (k != m) {
              Log.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.jcH) });
            }
            localArrayList = new ArrayList();
            if (this.jcH < i) {
              break label170;
            }
            o.a.this.iKb = false;
            if (this.successCount > 0)
            {
              localObject = o.a.this.iWr;
              if (o.a.this.iWk.size() <= 0) {
                break label164;
              }
            }
          }
          label164:
          for (long l = 500L;; l = 0L)
          {
            ((MTimerHandler)localObject).startTimer(l);
            AppMethodBeat.o(116846);
            return false;
            i = m;
            break;
          }
          label170:
          k = this.jcH + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.jcH < i)
            {
              k = ((Integer)paramLinkedList1.get(this.jcH)).intValue();
              final k.b localb = (k.b)paramLinkedList.get(this.jcH);
              if (this.jcH < localLinkedList.size())
              {
                localObject = (cxl)localLinkedList.get(this.jcH);
                label257:
                m = localb.id;
                Log.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(116845);
                    o localo = o.a.1.this.jgz;
                    int i = localb.getCmdId();
                    int j = k;
                    String str1;
                    if (this.jgC == null)
                    {
                      str1 = "";
                      if (this.jgC != null) {
                        break label75;
                      }
                    }
                    label75:
                    for (String str2 = "";; str2 = this.jgC.iAc)
                    {
                      localo.b(i, j, str1, str2);
                      AppMethodBeat.o(116845);
                      return;
                      str1 = this.jgC.Title;
                      break;
                    }
                  }
                });
                if ((k != 0) && (k != -3400)) {
                  break label385;
                }
                this.successCount += 1;
                localArrayList.add(localb);
                o.a.this.iWk.remove(Integer.valueOf(m));
              }
              for (;;)
              {
                this.jcH += 1;
                break;
                localObject = null;
                break label257;
                label385:
                if (k == -433)
                {
                  Log.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()) });
                }
                else
                {
                  localObject = (Integer)o.a.this.iWk.aT(Integer.valueOf(m));
                  Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.iWh), localObject });
                  if (localObject == null)
                  {
                    o.a.this.iWk.x(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (((Integer)localObject).intValue() < 2)
                  {
                    o.a.this.iWk.x(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
                  }
                  else
                  {
                    Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.iWh) });
                    localArrayList.add(localb);
                  }
                }
              }
            }
            k = localArrayList.size();
            if (k > 0)
            {
              g.aAi();
              l = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                o.a.this.jgt.c((k.b)localArrayList.get(i));
                i += 1;
              }
              g.aAi();
              g.aAh().hqK.endTransaction(l);
            }
            AppMethodBeat.o(116846);
            return true;
            i = k;
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(116847);
          String str = super.toString() + "|RespHandler";
          AppMethodBeat.o(116847);
          return str;
        }
      }, true);
      AppMethodBeat.i(116848);
      AppMethodBeat.o(116848);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.o
 * JD-Core Version:    0.7.0.1
 */