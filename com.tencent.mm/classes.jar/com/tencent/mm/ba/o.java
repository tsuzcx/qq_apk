package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g, i
{
  public HashMap<Integer, HashSet<WeakReference<i.a>>> bwc;
  f<Integer, Integer> hFP;
  private final int hFU;
  au hFW;
  private f<Integer, Integer> hPm;
  j hPn;
  boolean htJ;
  long htU;
  
  public o(j paramj)
  {
    AppMethodBeat.i(116849);
    this.htJ = false;
    this.hFP = new c(200);
    this.hPm = new c(200);
    this.bwc = new HashMap();
    this.htU = 0L;
    this.hFU = 500;
    this.hFW = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(116843);
        ac.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        o localo = o.this;
        long l = bs.eWj();
        if ((localo.htJ) && (l - localo.htU > 10000L)) {
          localo.htJ = false;
        }
        if (localo.htJ) {
          ac.w("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
        }
        for (;;)
        {
          AppMethodBeat.o(116843);
          return false;
          Object localObject1 = localo.hPn;
          ArrayList localArrayList = new ArrayList();
          localObject1 = ((j)localObject1).hpA.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" }, 0);
          if (localObject1 == null) {}
          Object localObject2;
          for (;;)
          {
            if (localArrayList.size() != 0) {
              break label306;
            }
            ac.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
            break;
            int j = ((Cursor)localObject1).getCount();
            if (j > 0)
            {
              int i = 0;
              while (i < j)
              {
                ((Cursor)localObject1).moveToPosition(i);
                localObject2 = new j.b(0);
                ((j.b)localObject2).id = ((Cursor)localObject1).getInt(0);
                ((j.b)localObject2).hFM = ((Cursor)localObject1).getLong(1);
                ((j.b)localObject2).cmdId = ((Cursor)localObject1).getInt(2);
                ((j.b)localObject2).buffer = ((Cursor)localObject1).getBlob(3);
                ((j.b)localObject2).uHf = ((Cursor)localObject1).getInt(4);
                ((j.b)localObject2).uHg = ((Cursor)localObject1).getLong(5);
                ((j.b)localObject2).uHh = ((Cursor)localObject1).getString(6);
                ((j.b)localObject2).uHi = ((Cursor)localObject1).getString(7);
                localArrayList.add(localObject2);
                i += 1;
              }
            }
            ((Cursor)localObject1).close();
          }
          label306:
          if ((!localo.htJ) && (localArrayList.size() > 0))
          {
            localo.htU = l;
            localo.htJ = true;
            localObject1 = new LinkedList();
            localObject2 = localArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              j.b localb = (j.b)((Iterator)localObject2).next();
              if ((localb.getCmdId() == 0) && (localb.uHf > 0)) {
                ((List)localObject1).add(localb);
              }
            }
            localArrayList.removeAll((Collection)localObject1);
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (j.b)((Iterator)localObject1).next();
              if ("@openim".equals(((j.b)localObject2).uHh))
              {
                com.tencent.mm.kernel.g.agS();
                com.tencent.mm.kernel.g.agQ().ghe.a(new l((j.b)localObject2), 0);
              }
              else
              {
                localo.hPn.b((j.b)localObject2);
              }
            }
            if (!localArrayList.isEmpty())
            {
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(new b(localArrayList), 0);
            }
          }
          ac.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", new Object[] { Long.valueOf(localo.htU), Boolean.valueOf(localo.htJ), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localArrayList.size()) });
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
    this.bwc = new HashMap();
    this.hPn = paramj;
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(681, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(806, this);
    AppMethodBeat.o(116849);
  }
  
  public final void a(int paramInt, i.a parama)
  {
    AppMethodBeat.i(116850);
    HashSet localHashSet = (HashSet)this.bwc.get(Integer.valueOf(paramInt));
    if (localHashSet == null) {
      localHashSet = new HashSet();
    }
    for (;;)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (((i.a)localWeakReference.get()).equals(parama)))
        {
          AppMethodBeat.o(116850);
          return;
        }
      }
      localHashSet.add(new WeakReference(parama));
      this.bwc.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(116850);
      return;
    }
  }
  
  final void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116852);
    Object localObject = (HashSet)this.bwc.get(Integer.valueOf(paramInt1));
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
      ((i.a)((Iterator)localObject).next()).D(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
    AppMethodBeat.o(116852);
  }
  
  public final void b(int paramInt, i.a parama)
  {
    AppMethodBeat.i(116851);
    HashSet localHashSet = (HashSet)this.bwc.get(Integer.valueOf(paramInt));
    if (localHashSet == null)
    {
      AppMethodBeat.o(116851);
      return;
    }
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((i.a)localWeakReference.get()).equals(parama)))
      {
        localHashSet.remove(localWeakReference);
        AppMethodBeat.o(116851);
        return;
      }
    }
    if (localHashSet.size() == 0)
    {
      this.bwc.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(116851);
      return;
    }
    this.bwc.put(Integer.valueOf(paramInt), localHashSet);
    AppMethodBeat.o(116851);
  }
  
  public final void c(j.b paramb)
  {
    AppMethodBeat.i(116853);
    int i;
    if (paramb != null)
    {
      int j = paramb.getCmdId();
      if (paramb.getBuffer() == null)
      {
        i = -1;
        ac.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bs.eWi() });
        paramb.hFM = bs.eWj();
        j localj = this.hPn;
        if (paramb != null)
        {
          paramb.drx = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.drx & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.hFM));
          }
          if ((paramb.drx & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.drx & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.drx & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.uHf));
          }
          if ((paramb.drx & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.uHg));
          }
          if ((paramb.drx & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.uHh);
          }
          if ((paramb.drx & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.uHi);
          }
          i = (int)localj.hpA.a("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.hFW.au(0L, 0L);
      AppMethodBeat.o(116853);
      return;
      i = paramb.getBuffer().length;
      break;
      ac.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  public final void d(j.b paramb)
  {
    AppMethodBeat.i(116854);
    com.tencent.mm.kernel.g.agS();
    long l = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
    this.hPn.b(paramb);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().ghG.qL(l);
    AppMethodBeat.o(116854);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(116855);
    ac.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramn.getType() == 806)
    {
      localObject2 = (cat)((com.tencent.mm.ak.b)paramn.getReqResp()).hvs.hvw;
      localObject1 = ((l)paramn).ioi;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramn instanceof l))
        {
          AppMethodBeat.o(116855);
          return;
        }
        if (((cat)localObject2).getBaseResponse() == null) {
          break label990;
        }
      }
    }
    label949:
    label964:
    label990:
    for (paramInt1 = ((cat)localObject2).getBaseResponse().Ret;; paramInt1 = 0)
    {
      paramString = new oc();
      paramString.dqA.ret = paramInt1;
      a.GpY.l(paramString);
      b(((j.b)localObject1).getCmdId(), paramInt1, "", "");
      ac.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((j.b)localObject1).uHf), Integer.valueOf(((j.b)localObject1).getCmdId()) });
      this.hPn.b((j.b)localObject1);
      this.htJ = false;
      paramString = this.hFW;
      if (this.hFP.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.au(l, l);
        AppMethodBeat.o(116855);
        return;
      }
      if ((localObject2 != null) && (((cat)localObject2).getBaseResponse() != null)) {}
      for (paramn = z.a(((cat)localObject2).getBaseResponse().ErrMsg);; paramn = "")
      {
        if (bs.isNullOrNil(paramn)) {}
        for (;;)
        {
          paramInt1 = ((j.b)localObject1).getCmdId();
          b(((j.b)localObject1).getCmdId(), -1, "", paramString);
          this.htJ = false;
          paramString = (Integer)this.hPm.aJ(Integer.valueOf(paramInt1));
          ac.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((j.b)localObject1).hFM), paramString });
          if (paramString == null)
          {
            this.hPm.o(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(116855);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.hPm.o(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(116855);
            return;
          }
          ac.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((j.b)localObject1).hFM) });
          this.hPn.b((j.b)localObject1);
          AppMethodBeat.o(116855);
          return;
          if (paramn.getType() != 681)
          {
            AppMethodBeat.o(116855);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramn).hOV == null))
          {
            ac.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramn).hOV.toString() });
            this.htJ = false;
            AppMethodBeat.o(116855);
            return;
          }
          localObject1 = ((b.c)((b)paramn).hOV.getRespObj()).hPa;
          if ((((cbv)localObject1).Ret != 0) || (((cbv)localObject1).FpR == null) || (((cbv)localObject1).FpR.EKK == null))
          {
            ac.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((cbv)localObject1).Ret) });
            this.htJ = false;
            AppMethodBeat.o(116855);
            return;
          }
          if ((((cbv)localObject1).FpR == null) || (((cbv)localObject1).FpR.EKK.size() == 0)) {}
          for (;;)
          {
            new a(this, ((b)paramn).hOW, ((cbv)localObject1).FpR.EKK, ((cbv)localObject1).FpR.FpS).au(50L, 50L);
            AppMethodBeat.o(116855);
            return;
            localObject2 = new oc();
            ((oc)localObject2).dqA.ret = ((Integer)((cbv)localObject1).FpR.EKK.getLast()).intValue();
            LinkedList localLinkedList = ((cbv)localObject1).FpR.FpS;
            oc.a locala = ((oc)localObject2).dqA;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.dqB = paramString;
              locala = ((oc)localObject2).dqA;
              if (!localLinkedList.isEmpty()) {
                break label949;
              }
            }
            for (paramString = "";; paramString = ((cbt)localLinkedList.getLast()).hkR)
            {
              locala.dqC = paramString;
              if ((!bs.isNullOrNil(((oc)localObject2).dqA.dqB)) || (!bs.isNullOrNil(((oc)localObject2).dqA.dqC))) {
                break label964;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((oc)localObject2).dqA.dqB = ((cbt)localLinkedList.get(paramInt1)).Title;
                ((oc)localObject2).dqA.dqC = ((cbt)localLinkedList.get(paramInt1)).hkR;
                if ((!bs.isNullOrNil(((oc)localObject2).dqA.dqB)) || (!bs.isNullOrNil(((oc)localObject2).dqA.dqC))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((cbt)localLinkedList.getLast()).Title;
              break;
            }
            a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          paramString = paramn;
        }
      }
    }
  }
  
  final class a
    extends au
  {
    public a(final List<j.b> paramList, final LinkedList<Integer> paramLinkedList, final LinkedList<cbt> paramLinkedList1)
    {
      super(new au.a()
      {
        private int hMa = 0;
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
              ac.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.hMa) });
            }
            localArrayList = new ArrayList();
            if (this.hMa < i) {
              break label172;
            }
            o.a.this.htJ = false;
            if (this.successCount > 0)
            {
              localObject = o.a.this.hFW;
              if (o.a.this.hFP.size() <= 0) {
                break label166;
              }
            }
          }
          label166:
          for (long l = 500L;; l = 0L)
          {
            ((au)localObject).au(l, l);
            AppMethodBeat.o(116846);
            return false;
            i = m;
            break;
          }
          label172:
          k = this.hMa + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.hMa < i)
            {
              k = ((Integer)paramLinkedList1.get(this.hMa)).intValue();
              final j.b localb = (j.b)paramLinkedList.get(this.hMa);
              if (this.hMa < localLinkedList.size())
              {
                localObject = (cbt)localLinkedList.get(this.hMa);
                label259:
                m = localb.id;
                ac.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(116845);
                    o localo = o.a.1.this.hPt;
                    int i = localb.getCmdId();
                    int j = k;
                    String str1;
                    if (this.hPw == null)
                    {
                      str1 = "";
                      if (this.hPw != null) {
                        break label75;
                      }
                    }
                    label75:
                    for (String str2 = "";; str2 = this.hPw.hkR)
                    {
                      localo.b(i, j, str1, str2);
                      AppMethodBeat.o(116845);
                      return;
                      str1 = this.hPw.Title;
                      break;
                    }
                  }
                });
                if ((k != 0) && (k != -3400)) {
                  break label387;
                }
                this.successCount += 1;
                localArrayList.add(localb);
                o.a.this.hFP.remove(Integer.valueOf(m));
              }
              for (;;)
              {
                this.hMa += 1;
                break;
                localObject = null;
                break label259;
                label387:
                if (k == -433)
                {
                  ac.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()) });
                }
                else
                {
                  localObject = (Integer)o.a.this.hFP.aJ(Integer.valueOf(m));
                  ac.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.hFM), localObject });
                  if (localObject == null)
                  {
                    o.a.this.hFP.o(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (((Integer)localObject).intValue() < 2)
                  {
                    o.a.this.hFP.o(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
                  }
                  else
                  {
                    ac.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.hFM) });
                    localArrayList.add(localb);
                  }
                }
              }
            }
            k = localArrayList.size();
            if (k > 0)
            {
              com.tencent.mm.kernel.g.agS();
              l = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                o.a.this.hPn.b((j.b)localArrayList.get(i));
                i += 1;
              }
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agR().ghG.qL(l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.o
 * JD-Core Version:    0.7.0.1
 */