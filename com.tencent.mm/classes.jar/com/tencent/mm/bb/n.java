package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.nt.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.messenger.foundation.a.a.i
{
  public HashMap<Integer, HashSet<WeakReference<i.a>>> byu;
  boolean gTk;
  long gTv;
  f<Integer, Integer> hfm;
  private final int hfr;
  av hft;
  private f<Integer, Integer> hoJ;
  i hoK;
  
  public n(i parami)
  {
    AppMethodBeat.i(116849);
    this.gTk = false;
    this.hfm = new c(200);
    this.hoJ = new c(200);
    this.byu = new HashMap();
    this.gTv = 0L;
    this.hfr = 500;
    this.hft = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(116843);
        ad.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        n localn = n.this;
        long l = bt.eGO();
        if ((localn.gTk) && (l - localn.gTv > 10000L)) {
          localn.gTk = false;
        }
        if (localn.gTk) {
          ad.w("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
        }
        for (;;)
        {
          AppMethodBeat.o(116843);
          return false;
          Object localObject1 = localn.hoK;
          ArrayList localArrayList = new ArrayList();
          localObject1 = ((i)localObject1).gPa.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" }, 0);
          if (localObject1 == null) {}
          Object localObject2;
          for (;;)
          {
            if (localArrayList.size() != 0) {
              break label306;
            }
            ad.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
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
                ((j.b)localObject2).hfj = ((Cursor)localObject1).getLong(1);
                ((j.b)localObject2).cmdId = ((Cursor)localObject1).getInt(2);
                ((j.b)localObject2).buffer = ((Cursor)localObject1).getBlob(3);
                ((j.b)localObject2).tyI = ((Cursor)localObject1).getInt(4);
                ((j.b)localObject2).tyJ = ((Cursor)localObject1).getLong(5);
                ((j.b)localObject2).tyK = ((Cursor)localObject1).getString(6);
                ((j.b)localObject2).tyL = ((Cursor)localObject1).getString(7);
                localArrayList.add(localObject2);
                i += 1;
              }
            }
            ((Cursor)localObject1).close();
          }
          label306:
          if ((!localn.gTk) && (localArrayList.size() > 0))
          {
            localn.gTv = l;
            localn.gTk = true;
            localObject1 = new LinkedList();
            localObject2 = localArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              j.b localb = (j.b)((Iterator)localObject2).next();
              if ((localb.getCmdId() == 0) && (localb.tyI > 0)) {
                ((List)localObject1).add(localb);
              }
            }
            localArrayList.removeAll((Collection)localObject1);
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (j.b)((Iterator)localObject1).next();
              if ("@openim".equals(((j.b)localObject2).tyK))
              {
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afA().gcy.a(new l((j.b)localObject2), 0);
              }
              else
              {
                localn.hoK.b((j.b)localObject2);
              }
            }
            if (!localArrayList.isEmpty())
            {
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a(new b(localArrayList), 0);
            }
          }
          ad.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", new Object[] { Long.valueOf(localn.gTv), Boolean.valueOf(localn.gTk), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localArrayList.size()) });
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
    this.byu = new HashMap();
    this.hoK = parami;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(681, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(806, this);
    AppMethodBeat.o(116849);
  }
  
  public final void a(int paramInt, i.a parama)
  {
    AppMethodBeat.i(116850);
    HashSet localHashSet = (HashSet)this.byu.get(Integer.valueOf(paramInt));
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
      this.byu.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(116850);
      return;
    }
  }
  
  final void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116852);
    Object localObject = (HashSet)this.byu.get(Integer.valueOf(paramInt1));
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
    HashSet localHashSet = (HashSet)this.byu.get(Integer.valueOf(paramInt));
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
      this.byu.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(116851);
      return;
    }
    this.byu.put(Integer.valueOf(paramInt), localHashSet);
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
        ad.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bt.eGN() });
        paramb.hfj = bt.eGO();
        i locali = this.hoK;
        if (paramb != null)
        {
          paramb.dtM = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.dtM & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.hfj));
          }
          if ((paramb.dtM & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.dtM & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.dtM & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.tyI));
          }
          if ((paramb.dtM & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.tyJ));
          }
          if ((paramb.dtM & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.tyK);
          }
          if ((paramb.dtM & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.tyL);
          }
          i = (int)locali.gPa.a("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.hft.av(0L, 0L);
      AppMethodBeat.o(116853);
      return;
      i = paramb.getBuffer().length;
      break;
      ad.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  public final void d(j.b paramb)
  {
    AppMethodBeat.i(116854);
    com.tencent.mm.kernel.g.afC();
    long l = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
    this.hoK.b(paramb);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().gda.mX(l);
    AppMethodBeat.o(116854);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(116855);
    ad.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramn.getType() == 806)
    {
      localObject2 = (bwb)((com.tencent.mm.al.b)paramn.getReqResp()).gUT.gUX;
      localObject1 = ((l)paramn).hNM;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramn instanceof l))
        {
          AppMethodBeat.o(116855);
          return;
        }
        if (((bwb)localObject2).getBaseResponse() == null) {
          break label990;
        }
      }
    }
    label949:
    label964:
    label990:
    for (paramInt1 = ((bwb)localObject2).getBaseResponse().Ret;; paramInt1 = 0)
    {
      paramString = new nt();
      paramString.dsQ.ret = paramInt1;
      a.ESL.l(paramString);
      b(((j.b)localObject1).getCmdId(), paramInt1, "", "");
      ad.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((j.b)localObject1).tyI), Integer.valueOf(((j.b)localObject1).getCmdId()) });
      this.hoK.b((j.b)localObject1);
      this.gTk = false;
      paramString = this.hft;
      if (this.hfm.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.av(l, l);
        AppMethodBeat.o(116855);
        return;
      }
      if ((localObject2 != null) && (((bwb)localObject2).getBaseResponse() != null)) {}
      for (paramn = z.a(((bwb)localObject2).getBaseResponse().ErrMsg);; paramn = "")
      {
        if (bt.isNullOrNil(paramn)) {}
        for (;;)
        {
          paramInt1 = ((j.b)localObject1).getCmdId();
          b(((j.b)localObject1).getCmdId(), -1, "", paramString);
          this.gTk = false;
          paramString = (Integer)this.hoJ.aM(Integer.valueOf(paramInt1));
          ad.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((j.b)localObject1).hfj), paramString });
          if (paramString == null)
          {
            this.hoJ.o(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(116855);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.hoJ.o(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(116855);
            return;
          }
          ad.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((j.b)localObject1).hfj) });
          this.hoK.b((j.b)localObject1);
          AppMethodBeat.o(116855);
          return;
          if (paramn.getType() != 681)
          {
            AppMethodBeat.o(116855);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramn).hos == null))
          {
            ad.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramn).hos.toString() });
            this.gTk = false;
            AppMethodBeat.o(116855);
            return;
          }
          localObject1 = ((b.c)((b)paramn).hos.getRespObj()).hox;
          if ((((bxb)localObject1).Ret != 0) || (((bxb)localObject1).DTv == null) || (((bxb)localObject1).DTv.DpH == null))
          {
            ad.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((bxb)localObject1).Ret) });
            this.gTk = false;
            AppMethodBeat.o(116855);
            return;
          }
          if ((((bxb)localObject1).DTv == null) || (((bxb)localObject1).DTv.DpH.size() == 0)) {}
          for (;;)
          {
            new a(this, ((b)paramn).hot, ((bxb)localObject1).DTv.DpH, ((bxb)localObject1).DTv.DTw).av(50L, 50L);
            AppMethodBeat.o(116855);
            return;
            localObject2 = new nt();
            ((nt)localObject2).dsQ.ret = ((Integer)((bxb)localObject1).DTv.DpH.getLast()).intValue();
            LinkedList localLinkedList = ((bxb)localObject1).DTv.DTw;
            nt.a locala = ((nt)localObject2).dsQ;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.dsR = paramString;
              locala = ((nt)localObject2).dsQ;
              if (!localLinkedList.isEmpty()) {
                break label949;
              }
            }
            for (paramString = "";; paramString = ((bwz)localLinkedList.getLast()).gKr)
            {
              locala.dsS = paramString;
              if ((!bt.isNullOrNil(((nt)localObject2).dsQ.dsR)) || (!bt.isNullOrNil(((nt)localObject2).dsQ.dsS))) {
                break label964;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((nt)localObject2).dsQ.dsR = ((bwz)localLinkedList.get(paramInt1)).Title;
                ((nt)localObject2).dsQ.dsS = ((bwz)localLinkedList.get(paramInt1)).gKr;
                if ((!bt.isNullOrNil(((nt)localObject2).dsQ.dsR)) || (!bt.isNullOrNil(((nt)localObject2).dsQ.dsS))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((bwz)localLinkedList.getLast()).Title;
              break;
            }
            a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          paramString = paramn;
        }
      }
    }
  }
  
  final class a
    extends av
  {
    public a(final List<j.b> paramList, final LinkedList<Integer> paramLinkedList, final LinkedList<bwz> paramLinkedList1)
    {
      super(new av.a()
      {
        private int hlx = 0;
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
              ad.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.hlx) });
            }
            localArrayList = new ArrayList();
            if (this.hlx < i) {
              break label172;
            }
            n.a.this.gTk = false;
            if (this.successCount > 0)
            {
              localObject = n.a.this.hft;
              if (n.a.this.hfm.size() <= 0) {
                break label166;
              }
            }
          }
          label166:
          for (long l = 500L;; l = 0L)
          {
            ((av)localObject).av(l, l);
            AppMethodBeat.o(116846);
            return false;
            i = m;
            break;
          }
          label172:
          k = this.hlx + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.hlx < i)
            {
              k = ((Integer)paramLinkedList1.get(this.hlx)).intValue();
              final j.b localb = (j.b)paramLinkedList.get(this.hlx);
              if (this.hlx < localLinkedList.size())
              {
                localObject = (bwz)localLinkedList.get(this.hlx);
                label259:
                m = localb.id;
                ad.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(116845);
                    n localn = n.a.1.this.hoR;
                    int i = localb.getCmdId();
                    int j = k;
                    String str1;
                    if (this.hoU == null)
                    {
                      str1 = "";
                      if (this.hoU != null) {
                        break label75;
                      }
                    }
                    label75:
                    for (String str2 = "";; str2 = this.hoU.gKr)
                    {
                      localn.b(i, j, str1, str2);
                      AppMethodBeat.o(116845);
                      return;
                      str1 = this.hoU.Title;
                      break;
                    }
                  }
                });
                if ((k != 0) && (k != -3400)) {
                  break label387;
                }
                this.successCount += 1;
                localArrayList.add(localb);
                n.a.this.hfm.remove(Integer.valueOf(m));
              }
              for (;;)
              {
                this.hlx += 1;
                break;
                localObject = null;
                break label259;
                label387:
                if (k == -433)
                {
                  ad.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()) });
                }
                else
                {
                  localObject = (Integer)n.a.this.hfm.aM(Integer.valueOf(m));
                  ad.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.hfj), localObject });
                  if (localObject == null)
                  {
                    n.a.this.hfm.o(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (((Integer)localObject).intValue() < 2)
                  {
                    n.a.this.hfm.o(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
                  }
                  else
                  {
                    ad.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.hfj) });
                    localArrayList.add(localb);
                  }
                }
              }
            }
            k = localArrayList.size();
            if (k > 0)
            {
              com.tencent.mm.kernel.g.afC();
              l = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                n.a.this.hoK.b((j.b)localArrayList.get(i));
                i += 1;
              }
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().gda.mX(l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.n
 * JD-Core Version:    0.7.0.1
 */