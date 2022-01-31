package com.tencent.mm.az;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mh.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.messenger.foundation.a.a.i
{
  public HashMap<Integer, HashSet<WeakReference<i.a>>> bat;
  com.tencent.mm.a.f<Integer, Integer> fCL;
  private final int fCQ;
  ap fCS;
  private com.tencent.mm.a.f<Integer, Integer> fLX;
  i fLY;
  long frA;
  boolean frp;
  
  public n(i parami)
  {
    AppMethodBeat.i(997);
    this.frp = false;
    this.fCL = new c(200);
    this.fLX = new c(200);
    this.bat = new HashMap();
    this.frA = 0L;
    this.fCQ = 500;
    this.fCS = new ap(g.RO().oNc.getLooper(), new n.1(this), false);
    this.bat = new HashMap();
    this.fLY = parami;
    g.RM();
    g.RK().eHt.a(681, this);
    g.RM();
    g.RK().eHt.a(806, this);
    AppMethodBeat.o(997);
  }
  
  public final void a(int paramInt, i.a parama)
  {
    AppMethodBeat.i(998);
    HashSet localHashSet = (HashSet)this.bat.get(Integer.valueOf(paramInt));
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
          AppMethodBeat.o(998);
          return;
        }
      }
      localHashSet.add(new WeakReference(parama));
      this.bat.put(Integer.valueOf(paramInt), localHashSet);
      AppMethodBeat.o(998);
      return;
    }
  }
  
  public final void b(int paramInt, i.a parama)
  {
    AppMethodBeat.i(999);
    HashSet localHashSet = (HashSet)this.bat.get(Integer.valueOf(paramInt));
    if (localHashSet == null)
    {
      AppMethodBeat.o(999);
      return;
    }
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((i.a)localWeakReference.get()).equals(parama)))
      {
        localHashSet.remove(localWeakReference);
        AppMethodBeat.o(999);
        return;
      }
    }
    if (localHashSet.size() == 0)
    {
      this.bat.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(999);
      return;
    }
    this.bat.put(Integer.valueOf(paramInt), localHashSet);
    AppMethodBeat.o(999);
  }
  
  final void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(1000);
    Object localObject = (HashSet)this.bat.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      AppMethodBeat.o(1000);
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
      ((i.a)((Iterator)localObject).next()).x(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
    AppMethodBeat.o(1000);
  }
  
  public final void c(j.b paramb)
  {
    AppMethodBeat.i(1001);
    int i;
    if (paramb != null)
    {
      int j = paramb.getCmdId();
      if (paramb.getBuffer() == null)
      {
        i = -1;
        ab.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bo.dtY() });
        paramb.fCI = bo.aoy();
        i locali = this.fLY;
        if (paramb != null)
        {
          paramb.bsY = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.bsY & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.fCI));
          }
          if ((paramb.bsY & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.bsY & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.bsY & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.oDV));
          }
          if ((paramb.bsY & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.oDW));
          }
          if ((paramb.bsY & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.oDX);
          }
          if ((paramb.bsY & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.oDY);
          }
          i = (int)locali.fnw.a("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.fCS.ag(0L, 0L);
      AppMethodBeat.o(1001);
      return;
      i = paramb.getBuffer().length;
      break;
      ab.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  public final void d(j.b paramb)
  {
    AppMethodBeat.i(1002);
    g.RM();
    long l = g.RL().eHS.kr(Thread.currentThread().getId());
    this.fLY.b(paramb);
    g.RM();
    g.RL().eHS.nY(l);
    AppMethodBeat.o(1002);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1003);
    ab.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramm.getType() == 806)
    {
      localObject2 = (bis)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta;
      localObject1 = ((l)paramm).gfQ;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramm instanceof l))
        {
          AppMethodBeat.o(1003);
          return;
        }
        if (((bis)localObject2).getBaseResponse() == null) {
          break label990;
        }
      }
    }
    label949:
    label964:
    label990:
    for (paramInt1 = ((bis)localObject2).getBaseResponse().Ret;; paramInt1 = 0)
    {
      paramString = new mh();
      paramString.cCr.ret = paramInt1;
      a.ymk.l(paramString);
      c(((j.b)localObject1).getCmdId(), paramInt1, "", "");
      ab.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((j.b)localObject1).oDV), Integer.valueOf(((j.b)localObject1).getCmdId()) });
      this.fLY.b((j.b)localObject1);
      this.frp = false;
      paramString = this.fCS;
      if (this.fCL.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.ag(l, l);
        AppMethodBeat.o(1003);
        return;
      }
      if ((localObject2 != null) && (((bis)localObject2).getBaseResponse() != null)) {}
      for (paramm = aa.a(((bis)localObject2).getBaseResponse().ErrMsg);; paramm = "")
      {
        if (bo.isNullOrNil(paramm)) {}
        for (;;)
        {
          paramInt1 = ((j.b)localObject1).getCmdId();
          c(((j.b)localObject1).getCmdId(), -1, "", paramString);
          this.frp = false;
          paramString = (Integer)this.fLX.Y(Integer.valueOf(paramInt1));
          ab.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((j.b)localObject1).fCI), paramString });
          if (paramString == null)
          {
            this.fLX.f(Integer.valueOf(paramInt1), Integer.valueOf(1));
            AppMethodBeat.o(1003);
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.fLX.f(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            AppMethodBeat.o(1003);
            return;
          }
          ab.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((j.b)localObject1).fCI) });
          this.fLY.b((j.b)localObject1);
          AppMethodBeat.o(1003);
          return;
          if (paramm.getType() != 681)
          {
            AppMethodBeat.o(1003);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((b)paramm).fLG == null))
          {
            ab.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((b)paramm).fLG.toString() });
            this.frp = false;
            AppMethodBeat.o(1003);
            return;
          }
          localObject1 = ((b.c)((b)paramm).fLG.getRespObj()).fLL;
          if ((((bjp)localObject1).Ret != 0) || (((bjp)localObject1).xxX == null) || (((bjp)localObject1).xxX.xaU == null))
          {
            ab.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((bjp)localObject1).Ret) });
            this.frp = false;
            AppMethodBeat.o(1003);
            return;
          }
          if ((((bjp)localObject1).xxX == null) || (((bjp)localObject1).xxX.xaU.size() == 0)) {}
          for (;;)
          {
            new n.a(this, this, ((b)paramm).fLH, ((bjp)localObject1).xxX.xaU, ((bjp)localObject1).xxX.xxY).ag(50L, 50L);
            AppMethodBeat.o(1003);
            return;
            localObject2 = new mh();
            ((mh)localObject2).cCr.ret = ((Integer)((bjp)localObject1).xxX.xaU.getLast()).intValue();
            LinkedList localLinkedList = ((bjp)localObject1).xxX.xxY;
            mh.a locala = ((mh)localObject2).cCr;
            if (localLinkedList.isEmpty())
            {
              paramString = "";
              locala.cCs = paramString;
              locala = ((mh)localObject2).cCr;
              if (!localLinkedList.isEmpty()) {
                break label949;
              }
            }
            for (paramString = "";; paramString = ((bjn)localLinkedList.getLast()).ntu)
            {
              locala.cCt = paramString;
              if ((!bo.isNullOrNil(((mh)localObject2).cCr.cCs)) || (!bo.isNullOrNil(((mh)localObject2).cCr.cCt))) {
                break label964;
              }
              paramInt1 = localLinkedList.size() - 1;
              while (paramInt1 >= 0)
              {
                ((mh)localObject2).cCr.cCs = ((bjn)localLinkedList.get(paramInt1)).Title;
                ((mh)localObject2).cCr.cCt = ((bjn)localLinkedList.get(paramInt1)).ntu;
                if ((!bo.isNullOrNil(((mh)localObject2).cCr.cCs)) || (!bo.isNullOrNil(((mh)localObject2).cCr.cCt))) {
                  break;
                }
                paramInt1 -= 1;
              }
              paramString = ((bjn)localLinkedList.getLast()).Title;
              break;
            }
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          }
          paramString = paramm;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.az.n
 * JD-Core Version:    0.7.0.1
 */