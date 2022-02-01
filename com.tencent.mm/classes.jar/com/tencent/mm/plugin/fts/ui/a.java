package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  extends b
  implements l
{
  protected String query;
  HashSet<String> rpM = new HashSet();
  private com.tencent.mm.plugin.fts.a.a.a rpP;
  private long rqH;
  public List<e.a> rsD = Collections.synchronizedList(new LinkedList());
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public int DF(int paramInt)
  {
    int k = this.rsD.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.rsD.get(i);
      locala.rqs = paramInt;
      int j = paramInt;
      if (locala.rqt) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.kLN.size() + locala.rqx);
      locala.rqu = paramInt;
      if (!locala.qpI) {
        break label100;
      }
      paramInt += 1;
    }
    label100:
    for (;;)
    {
      i += 1;
      break;
      return paramInt;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    int j = this.rsD.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.rsD.get(i);
      if ((locala.rqs == paramInt) && (locala.rqt)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.rqu) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqz = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kme = this.kme;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).roS = locala.roS;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).oEL = locala.businessType;
        return localObject;
        if ((locala.rqu == paramInt) && (locala.qpI))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.rqu) {
          localObject = a(paramInt, locala);
        }
      }
      else
      {
        i += 1;
        break;
        return null;
      }
      localObject = null;
    }
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    return null;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  protected abstract void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet);
  
  public final void a(String paramString, ap paramap, HashSet<String> paramHashSet, long paramLong)
  {
    cxr();
    clearData();
    this.query = paramString;
    this.rpP = a(paramap, paramHashSet);
  }
  
  protected c b(int paramInt, e.a parama)
  {
    return null;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    switch (paramk.bRZ)
    {
    default: 
      return;
    case 0: 
      ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.rpQ.size()) });
      if ((this.query == null) || (!this.query.equals(paramk.rma.query)))
      {
        ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.rma.query, this.query });
        return;
      }
      this.rqH = System.currentTimeMillis();
      this.rpM = paramk.rma.rpM;
      a(paramk, this.rpM);
    }
    do
    {
      this.rqr.a(this, paramk.rma.query);
      return;
      ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.bRZ), paramk.rma.query });
    } while (paramk.rma.query.equals(this.query));
    ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    return new com.tencent.mm.plugin.fts.ui.a.k(paramInt);
  }
  
  public final void clearData()
  {
    this.query = null;
    this.rpM.clear();
    this.rsD.clear();
  }
  
  public final int cxL()
  {
    int m = this.rsD.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.rsD.get(j)).kLN.iterator();
      if (localIterator.hasNext())
      {
        String str = bt.by(((m)localIterator.next()).roN, "");
        int i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          }
          k += 1;
          break;
          if (str.equals("create_chatroom​"))
          {
            i = 0;
            continue;
            if (str.equals("create_talker_message​"))
            {
              i = 1;
              continue;
              if (str.equals("no_result​")) {
                i = 2;
              }
            }
          }
        }
      }
      j += 1;
    }
    return k;
  }
  
  public final void cxr()
  {
    if (this.rpP != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.rpP);
      this.rpP = null;
    }
  }
  
  public final LinkedList<Integer> cxs()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.rsD.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.rsD.get(i);
      if (locala.rqs != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.rqs));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int cxt()
  {
    return cxL();
  }
  
  public final long cxu()
  {
    return this.rqH;
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.rqB = (parama.rqu - parama.rqs);
    localn.rqI = true;
    return localn;
  }
  
  public final List<c> qR(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.rqH > 0L)
    {
      int i = 0;
      if (i < this.rsD.size())
      {
        e.a locala = (e.a)this.rsD.get(i);
        int k = locala.kLN.size();
        int m = locala.rqx;
        int j = 0;
        c localc;
        while (j < m + k)
        {
          localc = b(j, locala);
          if (localc != null)
          {
            localc.roO = (this.rqH - paramLong);
            localc.position = (locala.rqs + j + 1);
            localArrayList.add(localc);
          }
          j += 1;
        }
        if (locala.qpI)
        {
          localc = new c();
          localc.drI = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          localc.drT = 4;
        }
        for (;;)
        {
          if (localc != null)
          {
            localc.roO = (this.rqH - paramLong);
            localc.position = locala.rqu;
            localArrayList.add(localc);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            localc.drT = 3;
          } else if (j == -1) {
            localc.drT = 12;
          } else if (j == -2) {
            localc.drT = 11;
          } else if (j == -6) {
            localc.drT = 10;
          } else if (j == -13) {
            localc.drT = 19;
          } else if (j == -7) {
            localc.drT = 5;
          } else {
            localc = null;
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */