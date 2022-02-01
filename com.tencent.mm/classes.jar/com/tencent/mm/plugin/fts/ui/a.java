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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  HashSet<String> tFY = new HashSet();
  private long tGT;
  private com.tencent.mm.plugin.fts.a.a.a tGb;
  public List<e.a> tIP = Collections.synchronizedList(new LinkedList());
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public int Hn(int paramInt)
  {
    int k = this.tIP.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.tIP.get(i);
      locala.tGE = paramInt;
      int j = paramInt;
      if (locala.tGF) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.lPc.size() + locala.tGJ);
      locala.tGG = paramInt;
      if (!locala.rRg) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    int j = this.tIP.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.tIP.get(i);
      if ((locala.tGE == paramInt) && (locala.tGF)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.tGG) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).lox = this.lox;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tFe = locala.tFe;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).pSr = locala.businessType;
        return localObject;
        if ((locala.tGG == paramInt) && (locala.rRg))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.tGG) {
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
  
  protected abstract com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    return null;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  protected abstract void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet);
  
  public final void a(String paramString, aq paramaq, HashSet<String> paramHashSet, long paramLong)
  {
    cVx();
    clearData();
    this.query = paramString;
    this.tGb = a(paramaq, paramHashSet);
  }
  
  protected c b(int paramInt, e.a parama)
  {
    return null;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    switch (paramk.bZU)
    {
    default: 
      return;
    case 0: 
      ae.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.tGc.size()) });
      if ((this.query == null) || (!this.query.equals(paramk.tCm.query)))
      {
        ae.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.tCm.query, this.query });
        return;
      }
      this.tGT = System.currentTimeMillis();
      this.tFY = paramk.tCm.tFY;
      a(paramk, this.tFY);
    }
    do
    {
      this.tGD.a(this, paramk.tCm.query);
      return;
      ae.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.bZU), paramk.tCm.query });
    } while (paramk.tCm.query.equals(this.query));
    ae.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    return new com.tencent.mm.plugin.fts.ui.a.k(paramInt);
  }
  
  public final long cVA()
  {
    return this.tGT;
  }
  
  public final int cVR()
  {
    int m = this.tIP.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.tIP.get(j)).lPc.iterator();
      if (localIterator.hasNext())
      {
        String str = bu.bI(((m)localIterator.next()).tEY, "");
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
  
  public final void cVx()
  {
    if (this.tGb != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tGb);
      this.tGb = null;
    }
  }
  
  public final LinkedList<Integer> cVy()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.tIP.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.tIP.get(i);
      if (locala.tGE != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.tGE));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int cVz()
  {
    return cVR();
  }
  
  public final void clearData()
  {
    this.query = null;
    this.tFY.clear();
    this.tIP.clear();
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.tGN = (parama.tGG - parama.tGE);
    localn.tGU = true;
    return localn;
  }
  
  public final List<c> xU(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.tGT > 0L)
    {
      int i = 0;
      if (i < this.tIP.size())
      {
        e.a locala = (e.a)this.tIP.get(i);
        int k = locala.lPc.size();
        int m = locala.tGJ;
        int j = 0;
        c localc;
        while (j < m + k)
        {
          localc = b(j, locala);
          if (localc != null)
          {
            localc.tFa = (this.tGT - paramLong);
            localc.position = (locala.tGE + j + 1);
            localArrayList.add(localc);
          }
          j += 1;
        }
        if (locala.rRg)
        {
          localc = new c();
          localc.dCl = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          localc.dCw = 4;
        }
        for (;;)
        {
          if (localc != null)
          {
            localc.tFa = (this.tGT - paramLong);
            localc.position = locala.tGG;
            localArrayList.add(localc);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            localc.dCw = 3;
          } else if (j == -1) {
            localc.dCw = 12;
          } else if (j == -2) {
            localc.dCw = 11;
          } else if (j == -6) {
            localc.dCw = 10;
          } else if (j == -13) {
            localc.dCw = 19;
          } else if (j == -7) {
            localc.dCw = 5;
          } else {
            localc = null;
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */