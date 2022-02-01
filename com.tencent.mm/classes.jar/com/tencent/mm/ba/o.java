package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.ol.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.messenger.foundation.a.a.j
{
  public HashMap<Integer, HashSet<WeakReference<j.a>>> bGq;
  boolean hOU;
  long hPf;
  com.tencent.mm.b.f<Integer, Integer> ibm;
  private final int ibr;
  aw ibt;
  private com.tencent.mm.b.f<Integer, Integer> ilt;
  j ilu;
  
  public o(j paramj)
  {
    AppMethodBeat.i(116849);
    this.hOU = false;
    this.ibm = new c(200);
    this.ilt = new c(200);
    this.bGq = new HashMap();
    this.hPf = 0L;
    this.ibr = 500;
    this.ibt = new aw(g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(116843);
        ae.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        o localo = o.this;
        long l = bu.fpO();
        if ((localo.hOU) && (l - localo.hPf > 10000L)) {
          localo.hOU = false;
        }
        if (localo.hOU) {
          ae.w("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
        }
        for (;;)
        {
          AppMethodBeat.o(116843);
          return false;
          Object localObject1 = localo.ilu;
          ArrayList localArrayList = new ArrayList();
          localObject1 = ((j)localObject1).hKK.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" }, 0);
          if (localObject1 == null) {}
          Object localObject2;
          for (;;)
          {
            if (localArrayList.size() != 0) {
              break label306;
            }
            ae.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
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
                ((k.b)localObject2).ibj = ((Cursor)localObject1).getLong(1);
                ((k.b)localObject2).cmdId = ((Cursor)localObject1).getInt(2);
                ((k.b)localObject2).buffer = ((Cursor)localObject1).getBlob(3);
                ((k.b)localObject2).vWm = ((Cursor)localObject1).getInt(4);
                ((k.b)localObject2).vWn = ((Cursor)localObject1).getLong(5);
                ((k.b)localObject2).vWo = ((Cursor)localObject1).getString(6);
                ((k.b)localObject2).vWp = ((Cursor)localObject1).getString(7);
                localArrayList.add(localObject2);
                i += 1;
              }
            }
            ((Cursor)localObject1).close();
          }
          label306:
          if ((!localo.hOU) && (localArrayList.size() > 0))
          {
            localo.hPf = l;
            localo.hOU = true;
            localObject1 = new LinkedList();
            localObject2 = localArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              k.b localb = (k.b)((Iterator)localObject2).next();
              if ((localb.getCmdId() == 0) && (localb.vWm > 0)) {
                ((List)localObject1).add(localb);
              }
            }
            localArrayList.removeAll((Collection)localObject1);
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (k.b)((Iterator)localObject1).next();
              if ("@openim".equals(((k.b)localObject2).vWo))
              {
                g.ajS();
                g.ajQ().gDv.a(new l((k.b)localObject2), 0);
              }
              else
              {
                localo.ilu.c((k.b)localObject2);
              }
            }
            if (!localArrayList.isEmpty())
            {
              g.ajS();
              g.ajQ().gDv.a(new b(localArrayList), 0);
            }
          }
          ae.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", new Object[] { Long.valueOf(localo.hPf), Boolean.valueOf(localo.hOU), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localArrayList.size()) });
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
    this.bGq = new HashMap();
    this.ilu = paramj;
    g.ajS();
    g.ajQ().gDv.a(681, this);
    g.ajS();
    g.ajQ().gDv.a(806, this);
    AppMethodBeat.o(116849);
  }
  
  public final void a(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116850);
    HashSet localHashSet = (HashSet)this.bGq.get(Integer.valueOf(paramInt));
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
      this.bGq.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(116850);
      return;
    }
  }
  
  final void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116852);
    Object localObject = (HashSet)this.bGq.get(Integer.valueOf(paramInt1));
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
      ((j.a)((Iterator)localObject).next()).C(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
    AppMethodBeat.o(116852);
  }
  
  public final void b(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116851);
    HashSet localHashSet = (HashSet)this.bGq.get(Integer.valueOf(paramInt));
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
      this.bGq.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(116851);
      return;
    }
    this.bGq.put(Integer.valueOf(paramInt), localHashSet);
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
        ae.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bu.fpN() });
        paramb.ibj = bu.fpO();
        j localj = this.ilu;
        if (paramb != null)
        {
          paramb.dEu = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.dEu & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.ibj));
          }
          if ((paramb.dEu & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.dEu & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.dEu & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.vWm));
          }
          if ((paramb.dEu & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.vWn));
          }
          if ((paramb.dEu & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.vWo);
          }
          if ((paramb.dEu & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.vWp);
          }
          i = (int)localj.hKK.a("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.ibt.ay(0L, 0L);
      AppMethodBeat.o(116853);
      return;
      i = paramb.getBuffer().length;
      break;
      ae.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  public final void e(k.b paramb)
  {
    AppMethodBeat.i(116854);
    g.ajS();
    long l = g.ajR().gDX.yi(Thread.currentThread().getId());
    this.ilu.c(paramb);
    g.ajS();
    g.ajR().gDX.sW(l);
    AppMethodBeat.o(116854);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(116855);
    ae.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramn.getType() == 806)
    {
      localObject2 = (cge)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
      localObject1 = ((l)paramn).iKy;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramn instanceof l))
        {
          AppMethodBeat.o(116855);
          return;
        }
        if (((cge)localObject2).getBaseResponse() == null) {
          break label990;
        }
      }
    }
    label949:
    label964:
    label990:
    for (paramInt1 = ((cge)localObject2).getBaseResponse().Ret;; paramInt1 = 0)
    {
      paramString = new ol();
      paramString.dDs.ret = paramInt1;
      a.IvT.l(paramString);
      b(((k.b)localObject1).getCmdId(), paramInt1, "", "");
      ae.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((k.b)localObject1).vWm), Integer.valueOf(((k.b)localObject1).getCmdId()) });
      this.ilu.c((k.b)localObject1);
      this.hOU = false;
      paramString = this.ibt;
      if (this.ibm.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.ay(l, l);
        AppMethodBeat.o(116855);
        return;
      }
      if ((localObject2 != null) && (((cge)localObject2).getBaseResponse() != null)) {}
      for (paramn = z.a(((cge)localObject2).getBaseResponse().ErrMsg);; paramn = "")
      {
        if (bu.isNullOrNil(paramn)) {}
        for (;;)
        {
          paramInt1 = ((k.b)localObject1).getCmdId();
          b(((k.b)localObject1).getCmdId(), -1, "", paramString);
          this.hOU = false;
          paramString = (Integer)this.ilt.aL(Integer.valueOf(paramInt1));
          ae.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).ibj), paramString });
          if (paramString == null)
          {
            this.ilt.q(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(116855);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.ilt.q(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(116855);
            return;
          }
          ae.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).ibj) });
          this.ilu.c((k.b)localObject1);
          AppMethodBeat.o(116855);
          return;
          if (paramn.getType() != 681)
          {
            AppMethodBeat.o(116855);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramn).ilc == null))
          {
            ae.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramn).ilc.toString() });
            this.hOU = false;
            AppMethodBeat.o(116855);
            return;
          }
          localObject1 = ((b.c)((b)paramn).ilc.getRespObj()).ilh;
          if ((((chg)localObject1).Ret != 0) || (((chg)localObject1).Htc == null) || (((chg)localObject1).Htc.GNm == null))
          {
            ae.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((chg)localObject1).Ret) });
            this.hOU = false;
            AppMethodBeat.o(116855);
            return;
          }
          if ((((chg)localObject1).Htc == null) || (((chg)localObject1).Htc.GNm.size() == 0)) {}
          for (;;)
          {
            new a(this, ((b)paramn).ild, ((chg)localObject1).Htc.GNm, ((chg)localObject1).Htc.Htd).ay(50L, 50L);
            AppMethodBeat.o(116855);
            return;
            localObject2 = new ol();
            ((ol)localObject2).dDs.ret = ((Integer)((chg)localObject1).Htc.GNm.getLast()).intValue();
            LinkedList localLinkedList = ((chg)localObject1).Htc.Htd;
            ol.a locala = ((ol)localObject2).dDs;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.dDt = paramString;
              locala = ((ol)localObject2).dDs;
              if (!localLinkedList.isEmpty()) {
                break label949;
              }
            }
            for (paramString = "";; paramString = ((che)localLinkedList.getLast()).hFS)
            {
              locala.dDu = paramString;
              if ((!bu.isNullOrNil(((ol)localObject2).dDs.dDt)) || (!bu.isNullOrNil(((ol)localObject2).dDs.dDu))) {
                break label964;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((ol)localObject2).dDs.dDt = ((che)localLinkedList.get(paramInt1)).Title;
                ((ol)localObject2).dDs.dDu = ((che)localLinkedList.get(paramInt1)).hFS;
                if ((!bu.isNullOrNil(((ol)localObject2).dDs.dDt)) || (!bu.isNullOrNil(((ol)localObject2).dDs.dDu))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((che)localLinkedList.getLast()).Title;
              break;
            }
            a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          paramString = paramn;
        }
      }
    }
  }
  
  final class a
    extends aw
  {
    public a(final List<k.b> paramList, final LinkedList<Integer> paramLinkedList, final LinkedList<che> paramLinkedList1)
    {
      super(new aw.a()
      {
        private int ihM = 0;
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
              ae.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.ihM) });
            }
            localArrayList = new ArrayList();
            if (this.ihM < i) {
              break label172;
            }
            o.a.this.hOU = false;
            if (this.successCount > 0)
            {
              localObject = o.a.this.ibt;
              if (o.a.this.ibm.size() <= 0) {
                break label166;
              }
            }
          }
          label166:
          for (long l = 500L;; l = 0L)
          {
            ((aw)localObject).ay(l, l);
            AppMethodBeat.o(116846);
            return false;
            i = m;
            break;
          }
          label172:
          k = this.ihM + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.ihM < i)
            {
              k = ((Integer)paramLinkedList1.get(this.ihM)).intValue();
              final k.b localb = (k.b)paramLinkedList.get(this.ihM);
              if (this.ihM < localLinkedList.size())
              {
                localObject = (che)localLinkedList.get(this.ihM);
                label259:
                m = localb.id;
                ae.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(116845);
                    o localo = o.a.1.this.ilA;
                    int i = localb.getCmdId();
                    int j = k;
                    String str1;
                    if (this.ilD == null)
                    {
                      str1 = "";
                      if (this.ilD != null) {
                        break label75;
                      }
                    }
                    label75:
                    for (String str2 = "";; str2 = this.ilD.hFS)
                    {
                      localo.b(i, j, str1, str2);
                      AppMethodBeat.o(116845);
                      return;
                      str1 = this.ilD.Title;
                      break;
                    }
                  }
                });
                if ((k != 0) && (k != -3400)) {
                  break label387;
                }
                this.successCount += 1;
                localArrayList.add(localb);
                o.a.this.ibm.remove(Integer.valueOf(m));
              }
              for (;;)
              {
                this.ihM += 1;
                break;
                localObject = null;
                break label259;
                label387:
                if (k == -433)
                {
                  ae.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()) });
                }
                else
                {
                  localObject = (Integer)o.a.this.ibm.aL(Integer.valueOf(m));
                  ae.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.ibj), localObject });
                  if (localObject == null)
                  {
                    o.a.this.ibm.q(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (((Integer)localObject).intValue() < 2)
                  {
                    o.a.this.ibm.q(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
                  }
                  else
                  {
                    ae.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.ibj) });
                    localArrayList.add(localb);
                  }
                }
              }
            }
            k = localArrayList.size();
            if (k > 0)
            {
              g.ajS();
              l = g.ajR().gDX.yi(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                o.a.this.ilu.c((k.b)localArrayList.get(i));
                i += 1;
              }
              g.ajS();
              g.ajR().gDX.sW(l);
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