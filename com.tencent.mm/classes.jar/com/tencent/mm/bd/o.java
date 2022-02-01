package com.tencent.mm.bd;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.qa;
import com.tencent.mm.f.a.qa.a;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  implements i, com.tencent.mm.plugin.messenger.foundation.a.a.j
{
  public HashMap<Integer, HashSet<WeakReference<j.a>>> bqq;
  private boolean lAg;
  private long lAr;
  private com.tencent.mm.b.f<Integer, Integer> lMF;
  private final int lMK;
  private MTimerHandler lMM;
  private com.tencent.mm.b.f<Integer, Integer> lWV;
  private j lWW;
  
  public o(j paramj)
  {
    AppMethodBeat.i(116849);
    this.lAg = false;
    this.lMF = new com.tencent.mm.memory.a.c(200);
    this.lWV = new com.tencent.mm.memory.a.c(200);
    this.bqq = new HashMap();
    this.lAr = 0L;
    this.lMK = 500;
    this.lMM = new MTimerHandler(com.tencent.mm.kernel.h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(116843);
        Log.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        o.a(o.this);
        AppMethodBeat.o(116843);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(116844);
        String str = super.toString() + "|pusherTry";
        AppMethodBeat.o(116844);
        return str;
      }
    }, false);
    this.bqq = new HashMap();
    this.lWW = paramj;
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(681, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(806, this);
    AppMethodBeat.o(116849);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116852);
    Object localObject = (HashSet)this.bqq.get(Integer.valueOf(paramInt1));
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
      ((j.a)((Iterator)localObject).next()).I(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
    AppMethodBeat.o(116852);
  }
  
  public final void a(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116850);
    HashSet localHashSet = (HashSet)this.bqq.get(Integer.valueOf(paramInt));
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
      this.bqq.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(116850);
      return;
    }
  }
  
  public final void b(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116851);
    HashSet localHashSet = (HashSet)this.bqq.get(Integer.valueOf(paramInt));
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
      this.bqq.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(116851);
      return;
    }
    this.bqq.put(Integer.valueOf(paramInt), localHashSet);
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
        paramb.lMC = Util.nowMilliSecond();
        j localj = this.lWW;
        if (paramb != null)
        {
          paramb.cUP = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.cUP & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.lMC));
          }
          if ((paramb.cUP & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.cUP & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.cUP & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.EVQ));
          }
          if ((paramb.cUP & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.EVR));
          }
          if ((paramb.cUP & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.EVS);
          }
          if ((paramb.cUP & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.EVT);
          }
          i = (int)localj.lvy.insert("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.lMM.startTimer(0L);
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
    com.tencent.mm.kernel.h.aHH();
    long l = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
    this.lWW.c(paramb);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
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
      localObject2 = (dfv)d.c.b(((d)paramq.getReqResp()).lBS);
      localObject1 = ((l)paramq).myi;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramq instanceof l))
        {
          AppMethodBeat.o(116855);
          return;
        }
        if (((dfv)localObject2).getBaseResponse() == null) {
          break label985;
        }
      }
    }
    label944:
    label959:
    label985:
    for (paramInt1 = ((dfv)localObject2).getBaseResponse().CqV;; paramInt1 = 0)
    {
      paramString = new qa();
      paramString.fOJ.ret = paramInt1;
      EventCenter.instance.publish(paramString);
      b(((k.b)localObject1).getCmdId(), paramInt1, "", "");
      Log.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((k.b)localObject1).EVQ), Integer.valueOf(((k.b)localObject1).getCmdId()) });
      this.lWW.c((k.b)localObject1);
      this.lAg = false;
      paramString = this.lMM;
      if (this.lMF.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.startTimer(l);
        AppMethodBeat.o(116855);
        return;
      }
      if ((localObject2 != null) && (((dfv)localObject2).getBaseResponse() != null)) {}
      for (paramq = z.a(((dfv)localObject2).getBaseResponse().Tef);; paramq = "")
      {
        if (Util.isNullOrNil(paramq)) {}
        for (;;)
        {
          paramInt1 = ((k.b)localObject1).getCmdId();
          b(((k.b)localObject1).getCmdId(), -1, "", paramString);
          this.lAg = false;
          paramString = (Integer)this.lWV.aX(Integer.valueOf(paramInt1));
          Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).lMC), paramString });
          if (paramString == null)
          {
            this.lWV.q(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(116855);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.lWV.q(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(116855);
            return;
          }
          Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).lMC) });
          this.lWW.c((k.b)localObject1);
          AppMethodBeat.o(116855);
          return;
          if (paramq.getType() != 681)
          {
            AppMethodBeat.o(116855);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramq).lWE == null))
          {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramq).lWE.toString() });
            this.lAg = false;
            AppMethodBeat.o(116855);
            return;
          }
          localObject1 = ((b.c)((b)paramq).lWE.getRespObj()).lWJ;
          if ((((dgx)localObject1).CqV != 0) || (((dgx)localObject1).TNE == null) || (((dgx)localObject1).TNE.SZW == null))
          {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((dgx)localObject1).CqV) });
            this.lAg = false;
            AppMethodBeat.o(116855);
            return;
          }
          if ((((dgx)localObject1).TNE == null) || (((dgx)localObject1).TNE.SZW.size() == 0)) {}
          for (;;)
          {
            new a(this, ((b)paramq).lWF, ((dgx)localObject1).TNE.SZW, ((dgx)localObject1).TNE.TNF).startTimer(50L);
            AppMethodBeat.o(116855);
            return;
            localObject2 = new qa();
            ((qa)localObject2).fOJ.ret = ((Integer)((dgx)localObject1).TNE.SZW.getLast()).intValue();
            LinkedList localLinkedList = ((dgx)localObject1).TNE.TNF;
            qa.a locala = ((qa)localObject2).fOJ;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.fOK = paramString;
              locala = ((qa)localObject2).fOJ;
              if (!localLinkedList.isEmpty()) {
                break label944;
              }
            }
            for (paramString = "";; paramString = ((dgv)localLinkedList.getLast()).lpy)
            {
              locala.fOL = paramString;
              if ((!Util.isNullOrNil(((qa)localObject2).fOJ.fOK)) || (!Util.isNullOrNil(((qa)localObject2).fOJ.fOL))) {
                break label959;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((qa)localObject2).fOJ.fOK = ((dgv)localLinkedList.get(paramInt1)).fwr;
                ((qa)localObject2).fOJ.fOL = ((dgv)localLinkedList.get(paramInt1)).lpy;
                if ((!Util.isNullOrNil(((qa)localObject2).fOJ.fOK)) || (!Util.isNullOrNil(((qa)localObject2).fOJ.fOL))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((dgv)localLinkedList.getLast()).fwr;
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
    public a(final List<k.b> paramList, final LinkedList<Integer> paramLinkedList, final LinkedList<dgv> paramLinkedList1)
    {
      super(new MTimerHandler.CallBack()
      {
        private int lTg = 0;
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
              Log.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.lTg) });
            }
            localArrayList = new ArrayList();
            if (this.lTg < i) {
              break label170;
            }
            o.b(o.a.this);
            if (this.successCount > 0)
            {
              localObject = o.d(o.a.this);
              if (o.c(o.a.this).size() <= 0) {
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
          k = this.lTg + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.lTg < i)
            {
              k = ((Integer)paramLinkedList1.get(this.lTg)).intValue();
              final k.b localb = (k.b)paramLinkedList.get(this.lTg);
              if (this.lTg < localLinkedList.size())
              {
                localObject = (dgv)localLinkedList.get(this.lTg);
                label257:
                m = localb.id;
                Log.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(116845);
                    o localo = o.a.1.this.lXc;
                    int i = localb.getCmdId();
                    int j = k;
                    String str1;
                    if (this.lXf == null)
                    {
                      str1 = "";
                      if (this.lXf != null) {
                        break label75;
                      }
                    }
                    label75:
                    for (String str2 = "";; str2 = this.lXf.lpy)
                    {
                      o.a(localo, i, j, str1, str2);
                      AppMethodBeat.o(116845);
                      return;
                      str1 = this.lXf.fwr;
                      break;
                    }
                  }
                });
                if ((k != 0) && (k != -3400)) {
                  break label385;
                }
                this.successCount += 1;
                localArrayList.add(localb);
                o.c(o.a.this).remove(Integer.valueOf(m));
              }
              for (;;)
              {
                this.lTg += 1;
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
                  localObject = (Integer)o.c(o.a.this).aX(Integer.valueOf(m));
                  Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.lMC), localObject });
                  if (localObject == null)
                  {
                    o.c(o.a.this).q(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (((Integer)localObject).intValue() < 2)
                  {
                    o.c(o.a.this).q(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
                  }
                  else
                  {
                    Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.lMC) });
                    localArrayList.add(localb);
                  }
                }
              }
            }
            k = localArrayList.size();
            if (k > 0)
            {
              com.tencent.mm.kernel.h.aHH();
              l = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                o.e(o.a.this).c((k.b)localArrayList.get(i));
                i += 1;
              }
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
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
 * Qualified Name:     com.tencent.mm.bd.o
 * JD-Core Version:    0.7.0.1
 */