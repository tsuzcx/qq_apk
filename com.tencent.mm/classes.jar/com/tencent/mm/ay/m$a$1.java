package com.tencent.mm.ay;

import com.tencent.mm.a.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class m$a$1
  implements am.a
{
  private int esH = 0;
  private int ewk = 0;
  
  m$a$1(m paramm1, List paramList, LinkedList paramLinkedList1, LinkedList paramLinkedList2, m paramm2) {}
  
  public final boolean tC()
  {
    int j = 0;
    int k = this.ewm.size();
    int m = this.ewn.size();
    int i;
    ArrayList localArrayList;
    Object localObject;
    if (k < m)
    {
      i = k;
      if (k != m) {
        y.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.esH) });
      }
      localArrayList = new ArrayList();
      if (this.esH < i) {
        break label160;
      }
      this.ewl.ebb = false;
      if (this.ewk > 0)
      {
        localObject = this.ewl.emv;
        if (this.ewl.emo.size() <= 0) {
          break label154;
        }
      }
    }
    label154:
    for (long l = 500L;; l = 0L)
    {
      ((am)localObject).S(l, l);
      return false;
      i = m;
      break;
    }
    label160:
    k = this.esH + 20;
    if (k > i) {}
    for (;;)
    {
      if (this.esH < i)
      {
        k = ((Integer)this.ewn.get(this.esH)).intValue();
        i.b localb = (i.b)this.ewm.get(this.esH);
        if (this.esH < this.ewo.size())
        {
          localObject = (bck)this.ewo.get(this.esH);
          label247:
          m = localb.id;
          y.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
          ai.d(new m.a.1.1(this, localb, k, (bck)localObject));
          if (k != 0) {
            break label366;
          }
          this.ewk += 1;
          localArrayList.add(localb);
          this.ewl.emo.remove(Integer.valueOf(m));
        }
        for (;;)
        {
          this.esH += 1;
          break;
          localObject = null;
          break label247;
          label366:
          if (k == -433)
          {
            y.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()) });
          }
          else
          {
            localObject = (Integer)this.ewl.emo.get(Integer.valueOf(m));
            y.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.eml), localObject });
            if (localObject == null)
            {
              this.ewl.emo.f(Integer.valueOf(m), Integer.valueOf(1));
            }
            else if (((Integer)localObject).intValue() < 2)
            {
              this.ewl.emo.f(Integer.valueOf(m), Integer.valueOf(((Integer)localObject).intValue() + 1));
            }
            else
            {
              y.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.eml) });
              localArrayList.add(localb);
            }
          }
        }
      }
      k = localArrayList.size();
      if (k > 0)
      {
        g.DQ();
        l = g.DP().dKu.eV(Thread.currentThread().getId());
        i = j;
        while (i < k)
        {
          this.ewl.ewi.a((i.b)localArrayList.get(i));
          i += 1;
        }
        g.DQ();
        g.DP().dKu.hI(l);
      }
      return true;
      i = k;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|RespHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ay.m.a.1
 * JD-Core Version:    0.7.0.1
 */