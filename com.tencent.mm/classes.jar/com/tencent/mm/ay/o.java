package com.tencent.mm.ay;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.rn;
import com.tencent.mm.autogen.a.rn.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.kd;
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
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.messenger.foundation.a.a.j
{
  public HashMap<Integer, HashSet<WeakReference<j.a>>> djU;
  private com.tencent.mm.b.f<Integer, Integer> oFm;
  private final int oFr;
  private MTimerHandler oFt;
  private com.tencent.mm.b.f<Integer, Integer> oPX;
  private j oPY;
  private boolean orH;
  private long orS;
  
  public o(j paramj)
  {
    AppMethodBeat.i(116849);
    this.orH = false;
    this.oFm = new com.tencent.mm.memory.a.c(200);
    this.oPX = new com.tencent.mm.memory.a.c(200);
    this.djU = new HashMap();
    this.orS = 0L;
    this.oFr = 500;
    this.oFt = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
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
    this.djU = new HashMap();
    this.oPY = paramj;
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(681, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(806, this);
    AppMethodBeat.o(116849);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(116852);
    Object localObject = (HashSet)this.djU.get(Integer.valueOf(paramInt1));
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
        localLinkedList.add((j.a)localWeakReference.get());
      }
    }
    localObject = localLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((j.a)((Iterator)localObject).next()).M(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
    AppMethodBeat.o(116852);
  }
  
  public final void a(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116850);
    HashSet localHashSet = (HashSet)this.djU.get(Integer.valueOf(paramInt));
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
      this.djU.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(116850);
      return;
    }
  }
  
  public final void b(int paramInt, j.a parama)
  {
    AppMethodBeat.i(116851);
    HashSet localHashSet = (HashSet)this.djU.get(Integer.valueOf(paramInt));
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
      this.djU.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(116851);
      return;
    }
    this.djU.put(Integer.valueOf(paramInt), localHashSet);
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
        paramb.oFj = Util.nowMilliSecond();
        j localj = this.oPY;
        if (paramb != null)
        {
          paramb.eQp = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.eQp & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.oFj));
          }
          if ((paramb.eQp & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.eQp & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.eQp & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.KRq));
          }
          if ((paramb.eQp & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.KRr));
          }
          if ((paramb.eQp & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.KRs);
          }
          if ((paramb.eQp & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.KRt);
          }
          i = (int)localj.omV.insert("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.oFt.startTimer(0L);
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
    com.tencent.mm.kernel.h.baF();
    long l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
    this.oPY.c(paramb);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
    AppMethodBeat.o(116854);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(116855);
    Log.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramp.getType() == 806)
    {
      localObject2 = (dyb)c.c.b(((com.tencent.mm.am.c)paramp.getReqResp()).otC);
      localObject1 = ((com.tencent.mm.openim.model.o)paramp).psA;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramp instanceof com.tencent.mm.openim.model.o))
        {
          AppMethodBeat.o(116855);
          return;
        }
        if (((dyb)localObject2).getBaseResponse() == null) {
          break label976;
        }
      }
    }
    label938:
    label953:
    label976:
    for (paramInt1 = ((dyb)localObject2).getBaseResponse().Idd;; paramInt1 = 0)
    {
      paramString = new rn();
      paramString.hUC.ret = paramInt1;
      paramString.publish();
      b(((k.b)localObject1).getCmdId(), paramInt1, "", "");
      Log.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((k.b)localObject1).KRq), Integer.valueOf(((k.b)localObject1).getCmdId()) });
      this.oPY.c((k.b)localObject1);
      this.orH = false;
      paramString = this.oFt;
      if (this.oFm.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.startTimer(l);
        AppMethodBeat.o(116855);
        return;
      }
      if ((localObject2 != null) && (((dyb)localObject2).getBaseResponse() != null)) {}
      for (paramp = w.a(((dyb)localObject2).getBaseResponse().akjO);; paramp = "")
      {
        if (Util.isNullOrNil(paramp)) {}
        for (;;)
        {
          paramInt1 = ((k.b)localObject1).getCmdId();
          b(((k.b)localObject1).getCmdId(), -1, "", paramString);
          this.orH = false;
          paramString = (Integer)this.oPX.ct(Integer.valueOf(paramInt1));
          Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).oFj), paramString });
          if (paramString == null)
          {
            this.oPX.B(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(116855);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.oPX.B(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(116855);
            return;
          }
          Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((k.b)localObject1).oFj) });
          this.oPY.c((k.b)localObject1);
          AppMethodBeat.o(116855);
          return;
          if (paramp.getType() != 681)
          {
            AppMethodBeat.o(116855);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramp).oPG == null))
          {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramp).oPG.toString() });
            this.orH = false;
            AppMethodBeat.o(116855);
            return;
          }
          localObject1 = ((b.c)((b)paramp).oPG.getRespObj()).oPL;
          if ((((dze)localObject1).Idd != 0) || (((dze)localObject1).abdX == null) || (((dze)localObject1).abdX.aamU == null))
          {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((dze)localObject1).Idd) });
            this.orH = false;
            AppMethodBeat.o(116855);
            return;
          }
          if ((((dze)localObject1).abdX == null) || (((dze)localObject1).abdX.aamU.size() == 0)) {}
          for (;;)
          {
            new a(this, ((b)paramp).oPH, ((dze)localObject1).abdX.aamU, ((dze)localObject1).abdX.abdY).startTimer(50L);
            AppMethodBeat.o(116855);
            return;
            localObject2 = new rn();
            ((rn)localObject2).hUC.ret = ((Integer)((dze)localObject1).abdX.aamU.getLast()).intValue();
            LinkedList localLinkedList = ((dze)localObject1).abdX.abdY;
            rn.a locala = ((rn)localObject2).hUC;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.hUD = paramString;
              locala = ((rn)localObject2).hUC;
              if (!localLinkedList.isEmpty()) {
                break label938;
              }
            }
            for (paramString = "";; paramString = ((dzc)localLinkedList.getLast()).nUB)
            {
              locala.hUE = paramString;
              if ((!Util.isNullOrNil(((rn)localObject2).hUC.hUD)) || (!Util.isNullOrNil(((rn)localObject2).hUC.hUE))) {
                break label953;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((rn)localObject2).hUC.hUD = ((dzc)localLinkedList.get(paramInt1)).hAP;
                ((rn)localObject2).hUC.hUE = ((dzc)localLinkedList.get(paramInt1)).nUB;
                if ((!Util.isNullOrNil(((rn)localObject2).hUC.hUD)) || (!Util.isNullOrNil(((rn)localObject2).hUC.hUE))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((dzc)localLinkedList.getLast()).hAP;
              break;
            }
            ((rn)localObject2).publish();
          }
          paramString = paramp;
        }
      }
    }
  }
  
  final class a
    extends MTimerHandler
  {
    public a(final List<k.b> paramList, final LinkedList<Integer> paramLinkedList, final LinkedList<dzc> paramLinkedList1)
    {
      super(new MTimerHandler.CallBack()
      {
        private int oLZ = 0;
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
              Log.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.oLZ) });
            }
            localArrayList = new ArrayList();
            if (this.oLZ < i) {
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
          k = this.oLZ + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.oLZ < i)
            {
              k = ((Integer)paramLinkedList1.get(this.oLZ)).intValue();
              final k.b localb = (k.b)paramLinkedList.get(this.oLZ);
              if (this.oLZ < localLinkedList.size())
              {
                localObject = (dzc)localLinkedList.get(this.oLZ);
                label257:
                m = localb.id;
                Log.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(116845);
                    o localo = o.a.1.this.oQe;
                    int i = localb.getCmdId();
                    int j = k;
                    String str1;
                    if (this.oQh == null)
                    {
                      str1 = "";
                      if (this.oQh != null) {
                        break label75;
                      }
                    }
                    label75:
                    for (String str2 = "";; str2 = this.oQh.nUB)
                    {
                      o.a(localo, i, j, str1, str2);
                      AppMethodBeat.o(116845);
                      return;
                      str1 = this.oQh.hAP;
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
                this.oLZ += 1;
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
                  localObject = (Integer)o.c(o.a.this).ct(Integer.valueOf(m));
                  Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.oFj), localObject });
                  if (localObject == null)
                  {
                    o.c(o.a.this).B(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (((Integer)localObject).intValue() < 2)
                  {
                    o.c(o.a.this).B(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
                  }
                  else
                  {
                    Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.oFj) });
                    localArrayList.add(localb);
                  }
                }
              }
            }
            k = localArrayList.size();
            if (k > 0)
            {
              com.tencent.mm.kernel.h.baF();
              l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                o.e(o.a.this).c((k.b)localArrayList.get(i));
                i += 1;
              }
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
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
 * Qualified Name:     com.tencent.mm.ay.o
 * JD-Core Version:    0.7.0.1
 */