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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  public List<e.a> sBx = Collections.synchronizedList(new LinkedList());
  HashSet<String> syG = new HashSet();
  private com.tencent.mm.plugin.fts.a.a.a syJ;
  private long szB;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public int FB(int paramInt)
  {
    int k = this.sBx.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.sBx.get(i);
      locala.szm = paramInt;
      int j = paramInt;
      if (locala.szn) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.lnk.size() + locala.szr);
      locala.szo = paramInt;
      if (!locala.qYO) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    int j = this.sBx.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.sBx.get(i);
      if ((locala.szm == paramInt) && (locala.szn)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.szo) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szt = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kNw = this.kNw;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).sxM = locala.sxM;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).pil = locala.businessType;
        return localObject;
        if ((locala.szo == paramInt) && (locala.qYO))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.szo) {
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
  
  protected abstract com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    return null;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  protected abstract void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet);
  
  public final void a(String paramString, ao paramao, HashSet<String> paramHashSet, long paramLong)
  {
    cKD();
    clearData();
    this.query = paramString;
    this.syJ = a(paramao, paramHashSet);
  }
  
  protected c b(int paramInt, e.a parama)
  {
    return null;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    switch (paramk.bPH)
    {
    default: 
      return;
    case 0: 
      ac.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.syK.size()) });
      if ((this.query == null) || (!this.query.equals(paramk.suU.query)))
      {
        ac.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.suU.query, this.query });
        return;
      }
      this.szB = System.currentTimeMillis();
      this.syG = paramk.suU.syG;
      a(paramk, this.syG);
    }
    do
    {
      this.szl.a(this, paramk.suU.query);
      return;
      ac.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.bPH), paramk.suU.query });
    } while (paramk.suU.query.equals(this.query));
    ac.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    return new com.tencent.mm.plugin.fts.ui.a.k(paramInt);
  }
  
  public final void cKD()
  {
    if (this.syJ != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.syJ);
      this.syJ = null;
    }
  }
  
  public final LinkedList<Integer> cKE()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.sBx.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.sBx.get(i);
      if (locala.szm != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.szm));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int cKF()
  {
    return cKX();
  }
  
  public final long cKG()
  {
    return this.szB;
  }
  
  public final int cKX()
  {
    int m = this.sBx.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.sBx.get(j)).lnk.iterator();
      if (localIterator.hasNext())
      {
        String str = bs.bG(((m)localIterator.next()).sxG, "");
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
  
  public final void clearData()
  {
    this.query = null;
    this.syG.clear();
    this.sBx.clear();
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.szv = (parama.szo - parama.szm);
    localn.szC = true;
    return localn;
  }
  
  public final List<c> vu(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.szB > 0L)
    {
      int i = 0;
      if (i < this.sBx.size())
      {
        e.a locala = (e.a)this.sBx.get(i);
        int k = locala.lnk.size();
        int m = locala.szr;
        int j = 0;
        c localc;
        while (j < m + k)
        {
          localc = b(j, locala);
          if (localc != null)
          {
            localc.sxI = (this.szB - paramLong);
            localc.position = (locala.szm + j + 1);
            localArrayList.add(localc);
          }
          j += 1;
        }
        if (locala.qYO)
        {
          localc = new c();
          localc.dpt = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          localc.dpE = 4;
        }
        for (;;)
        {
          if (localc != null)
          {
            localc.sxI = (this.szB - paramLong);
            localc.position = locala.szo;
            localArrayList.add(localc);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            localc.dpE = 3;
          } else if (j == -1) {
            localc.dpE = 12;
          } else if (j == -2) {
            localc.dpE = 11;
          } else if (j == -6) {
            localc.dpE = 10;
          } else if (j == -13) {
            localc.dpE = 19;
          } else if (j == -7) {
            localc.dpE = 5;
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