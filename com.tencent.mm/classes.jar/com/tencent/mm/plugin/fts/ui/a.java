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
  HashSet<String> tvh = new HashSet();
  private com.tencent.mm.plugin.fts.a.a.a tvk;
  private long twc;
  public List<e.a> txY = Collections.synchronizedList(new LinkedList());
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public int GQ(int paramInt)
  {
    int k = this.txY.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.txY.get(i);
      locala.tvN = paramInt;
      int j = paramInt;
      if (locala.tvO) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.lKC.size() + locala.tvS);
      locala.tvP = paramInt;
      if (!locala.rKf) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    int j = this.txY.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.txY.get(i);
      if ((locala.tvN == paramInt) && (locala.tvO)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.tvP) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tvU = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).ljZ = this.ljZ;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tun = locala.tun;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).pLM = locala.businessType;
        return localObject;
        if ((locala.tvP == paramInt) && (locala.rKf))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.tvP) {
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
    cSS();
    clearData();
    this.query = paramString;
    this.tvk = a(paramap, paramHashSet);
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
      ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.tvl.size()) });
      if ((this.query == null) || (!this.query.equals(paramk.trv.query)))
      {
        ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.trv.query, this.query });
        return;
      }
      this.twc = System.currentTimeMillis();
      this.tvh = paramk.trv.tvh;
      a(paramk, this.tvh);
    }
    do
    {
      this.tvM.a(this, paramk.trv.query);
      return;
      ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.bZU), paramk.trv.query });
    } while (paramk.trv.query.equals(this.query));
    ad.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    return new com.tencent.mm.plugin.fts.ui.a.k(paramInt);
  }
  
  public final void cSS()
  {
    if (this.tvk != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tvk);
      this.tvk = null;
    }
  }
  
  public final LinkedList<Integer> cST()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.txY.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.txY.get(i);
      if (locala.tvN != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.tvN));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int cSU()
  {
    return cTm();
  }
  
  public final long cSV()
  {
    return this.twc;
  }
  
  public final int cTm()
  {
    int m = this.txY.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.txY.get(j)).lKC.iterator();
      if (localIterator.hasNext())
      {
        String str = bt.bI(((m)localIterator.next()).tuh, "");
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
    this.tvh.clear();
    this.txY.clear();
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.tvW = (parama.tvP - parama.tvN);
    localn.twd = true;
    return localn;
  }
  
  public final List<c> xA(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.twc > 0L)
    {
      int i = 0;
      if (i < this.txY.size())
      {
        e.a locala = (e.a)this.txY.get(i);
        int k = locala.lKC.size();
        int m = locala.tvS;
        int j = 0;
        c localc;
        while (j < m + k)
        {
          localc = b(j, locala);
          if (localc != null)
          {
            localc.tuj = (this.twc - paramLong);
            localc.position = (locala.tvN + j + 1);
            localArrayList.add(localc);
          }
          j += 1;
        }
        if (locala.rKf)
        {
          localc = new c();
          localc.dBg = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          localc.dBr = 4;
        }
        for (;;)
        {
          if (localc != null)
          {
            localc.tuj = (this.twc - paramLong);
            localc.position = locala.tvP;
            localArrayList.add(localc);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            localc.dBr = 3;
          } else if (j == -1) {
            localc.dBr = 12;
          } else if (j == -2) {
            localc.dBr = 11;
          } else if (j == -6) {
            localc.dBr = 10;
          } else if (j == -13) {
            localc.dBr = 19;
          } else if (j == -7) {
            localc.dBr = 5;
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