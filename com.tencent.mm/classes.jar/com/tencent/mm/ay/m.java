package com.tencent.mm.ay;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.lr;
import com.tencent.mm.h.a.lr.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.messenger.foundation.a.a.h
{
  boolean ebb = false;
  long ebl = 0L;
  public HashMap<Integer, HashSet<WeakReference<h.a>>> elp = new HashMap();
  com.tencent.mm.a.f<Integer, Integer> emo = new com.tencent.mm.a.f(200);
  private final int emt = 500;
  am emv = new am(g.DS().mnU.getLooper(), new m.1(this), false);
  private com.tencent.mm.a.f<Integer, Integer> ewh = new com.tencent.mm.a.f(200);
  h ewi;
  
  public m(h paramh)
  {
    this.ewi = paramh;
    g.DQ();
    g.DO().dJT.a(681, this);
    g.DQ();
    g.DO().dJT.a(806, this);
  }
  
  public final void a(int paramInt, h.a parama)
  {
    HashSet localHashSet = (HashSet)this.elp.get(Integer.valueOf(paramInt));
    if (localHashSet == null) {
      localHashSet = new HashSet();
    }
    for (;;)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (((h.a)localWeakReference.get()).equals(parama))) {
          return;
        }
      }
      localHashSet.add(new WeakReference(parama));
      this.elp.put(Integer.valueOf(paramInt), localHashSet);
      return;
    }
  }
  
  public final void b(int paramInt, h.a parama)
  {
    HashSet localHashSet = (HashSet)this.elp.get(Integer.valueOf(paramInt));
    if (localHashSet == null) {
      return;
    }
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((h.a)localWeakReference.get()).equals(parama)))
      {
        localHashSet.remove(localWeakReference);
        return;
      }
    }
    if (localHashSet.size() == 0)
    {
      this.elp.remove(Integer.valueOf(paramInt));
      return;
    }
    this.elp.put(Integer.valueOf(paramInt), localHashSet);
  }
  
  public final void b(i.b paramb)
  {
    int i;
    if (paramb != null)
    {
      int j = paramb.getCmdId();
      if (paramb.getBuffer() == null)
      {
        i = -1;
        y.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bk.csb() });
        paramb.eml = bk.UY();
        h localh = this.ewi;
        if (paramb != null)
        {
          paramb.bcw = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.bcw & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.eml));
          }
          if ((paramb.bcw & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.bcw & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.bcw & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.mdz));
          }
          if ((paramb.bcw & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.mdA));
          }
          if ((paramb.bcw & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.mdB);
          }
          if ((paramb.bcw & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.mdC);
          }
          i = (int)localh.dXo.insert("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.emv.S(0L, 0L);
      return;
      i = paramb.getBuffer().length;
      break;
      y.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  final void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = (HashSet)this.elp.get(Integer.valueOf(paramInt1));
    if (localObject == null) {
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
      ((h.a)((Iterator)localObject).next()).n(paramInt2, paramString1, paramString2);
    }
    localLinkedList.clear();
  }
  
  public final void c(i.b paramb)
  {
    g.DQ();
    long l = g.DP().dKu.eV(Thread.currentThread().getId());
    this.ewi.a(paramb);
    g.DQ();
    g.DP().dKu.hI(l);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    Object localObject2;
    Object localObject1;
    if (paramm.getType() == 806)
    {
      localObject2 = (bbs)((com.tencent.mm.ah.b)paramm.edi).ecF.ecN;
      localObject1 = ((l)paramm).ePV;
      if ((paramInt1 == 0) || (paramInt2 == 0))
      {
        if (!(paramm instanceof l)) {
          return;
        }
        if (((bly)localObject2).tFx == null) {
          break label896;
        }
      }
    }
    label896:
    for (paramInt1 = ((bly)localObject2).tFx.sze;; paramInt1 = 0)
    {
      paramString = new lr();
      paramString.bUK.ret = paramInt1;
      com.tencent.mm.sdk.b.a.udP.m(paramString);
      c(((i.b)localObject1).getCmdId(), paramInt1, "", "");
      y.i("MicroMsg.OplogService", "openim op success, type:%d id %d", new Object[] { Integer.valueOf(((i.b)localObject1).mdz), Integer.valueOf(((i.b)localObject1).getCmdId()) });
      this.ewi.a((i.b)localObject1);
      this.ebb = false;
      paramString = this.emv;
      if (this.emo.size() > 0) {}
      for (long l = 500L;; l = 0L)
      {
        paramString.S(l, l);
        return;
      }
      if ((localObject2 != null) && (((bly)localObject2).tFx != null)) {}
      for (paramm = aa.a(((bly)localObject2).tFx.sAn);; paramm = "")
      {
        if (bk.bl(paramm)) {}
        for (;;)
        {
          paramInt1 = ((i.b)localObject1).getCmdId();
          c(((i.b)localObject1).getCmdId(), -1, "", paramString);
          this.ebb = false;
          paramString = (Integer)this.ewh.get(Integer.valueOf(paramInt1));
          y.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((i.b)localObject1).eml), paramString });
          if (paramString == null)
          {
            this.ewh.f(Integer.valueOf(paramInt1), Integer.valueOf(1));
            return;
          }
          if (paramString.intValue() < 2)
          {
            this.ewh.f(Integer.valueOf(paramInt1), Integer.valueOf(paramString.intValue() + 1));
            return;
          }
          y.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(((i.b)localObject1).eml) });
          this.ewi.a((i.b)localObject1);
          return;
          if (paramm.getType() != 681) {
            break;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0) || (((a)paramm).evQ == null))
          {
            y.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((a)paramm).evQ.toString() });
            this.ebb = false;
            return;
          }
          localObject1 = ((a.c)((a)paramm).evQ.evT).evV;
          if ((((bcm)localObject1).sze != 0) || (((bcm)localObject1).txP == null) || (((bcm)localObject1).txP.tcC == null))
          {
            y.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((bcm)localObject1).sze) });
            this.ebb = false;
            return;
          }
          localObject2 = new lr();
          ((lr)localObject2).bUK.ret = ((Integer)((bcm)localObject1).txP.tcC.getLast()).intValue();
          LinkedList localLinkedList = ((bcm)localObject1).txP.txQ;
          lr.a locala = ((lr)localObject2).bUK;
          if (localLinkedList.isEmpty())
          {
            paramString = "";
            locala.bUL = paramString;
            locala = ((lr)localObject2).bUK;
            if (!localLinkedList.isEmpty()) {
              break label815;
            }
          }
          label815:
          for (paramString = "";; paramString = ((bck)localLinkedList.getLast()).kVs)
          {
            locala.bUM = paramString;
            if ((!bk.bl(((lr)localObject2).bUK.bUL)) || (!bk.bl(((lr)localObject2).bUK.bUM))) {
              break label830;
            }
            paramInt1 = localLinkedList.size() - 1;
            while (paramInt1 >= 0)
            {
              ((lr)localObject2).bUK.bUL = ((bck)localLinkedList.get(paramInt1)).bGw;
              ((lr)localObject2).bUK.bUM = ((bck)localLinkedList.get(paramInt1)).kVs;
              if ((!bk.bl(((lr)localObject2).bUK.bUL)) || (!bk.bl(((lr)localObject2).bUK.bUM))) {
                break;
              }
              paramInt1 -= 1;
            }
            paramString = ((bck)localLinkedList.getLast()).bGw;
            break;
          }
          label830:
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          new m.a(this, this, ((a)paramm).evR, ((bcm)localObject1).txP.tcC, ((bcm)localObject1).txP.txQ).S(50L, 50L);
          return;
          paramString = paramm;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ay.m
 * JD-Core Version:    0.7.0.1
 */