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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
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
  HashSet<String> wWX = new HashSet();
  private long wXS;
  private com.tencent.mm.plugin.fts.a.a.a wXa;
  public List<e.a> wZO = Collections.synchronizedList(new LinkedList());
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final List<c> GE(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.wXS > 0L)
    {
      int i = 0;
      if (i < this.wZO.size())
      {
        e.a locala = (e.a)this.wZO.get(i);
        int k = locala.mWl.size();
        int m = locala.wXI;
        int j = 0;
        c localc;
        while (j < m + k)
        {
          localc = b(j, locala);
          if (localc != null)
          {
            localc.wVZ = (this.wXS - paramLong);
            localc.position = (locala.wXD + j + 1);
            localArrayList.add(localc);
          }
          j += 1;
        }
        if (locala.tuG)
        {
          localc = new c();
          localc.dUb = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          localc.dUm = 4;
        }
        for (;;)
        {
          if (localc != null)
          {
            localc.wVZ = (this.wXS - paramLong);
            localc.position = locala.wXF;
            localArrayList.add(localc);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            localc.dUm = 3;
          } else if (j == -1) {
            localc.dUm = 12;
          } else if (j == -2) {
            localc.dUm = 11;
          } else if (j == -6) {
            localc.dUm = 10;
          } else if (j == -13) {
            localc.dUm = 19;
          } else if (j == -7) {
            localc.dUm = 5;
          } else {
            localc = null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public int Nn(int paramInt)
  {
    int k = this.wZO.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.wZO.get(i);
      locala.wXD = paramInt;
      int j = paramInt;
      if (locala.wXE) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.mWl.size() + locala.wXI);
      locala.wXF = paramInt;
      if (!locala.tuG) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    int j = this.wZO.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.wZO.get(i);
      if ((locala.wXD == paramInt) && (locala.wXE)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.wXF) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXK = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mve = this.mve;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wWd = locala.wWd;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rjr = locala.businessType;
        return localObject;
        if ((locala.wXF == paramInt) && (locala.tuG))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.wXF) {
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
  
  protected abstract com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    return null;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  protected abstract void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet);
  
  public final void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet, long paramLong)
  {
    dOG();
    clearData();
    this.query = paramString;
    this.wXa = a(paramMMHandler, paramHashSet);
  }
  
  protected c b(int paramInt, e.a parama)
  {
    return null;
  }
  
  public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
  {
    switch (paramk.resultCode)
    {
    default: 
      return;
    case 0: 
      Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.wXb.size()) });
      if ((this.query == null) || (!this.query.equals(paramk.wTn.query)))
      {
        Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.wTn.query, this.query });
        return;
      }
      this.wXS = System.currentTimeMillis();
      this.wWX = paramk.wTn.wWX;
      a(paramk, this.wWX);
    }
    do
    {
      this.wXC.a(this, paramk.wTn.query);
      return;
      Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.resultCode), paramk.wTn.query });
    } while (paramk.wTn.query.equals(this.query));
    Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    return new com.tencent.mm.plugin.fts.ui.a.k(paramInt);
  }
  
  public final void clearData()
  {
    this.query = null;
    this.wWX.clear();
    this.wZO.clear();
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.wXM = (parama.wXF - parama.wXD);
    localn.wXT = true;
    return localn;
  }
  
  public final void dOG()
  {
    if (this.wXa != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.wXa);
      this.wXa = null;
    }
  }
  
  public final LinkedList<Integer> dOH()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.wZO.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.wZO.get(i);
      if (locala.wXD != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.wXD));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int dOI()
  {
    return dPa();
  }
  
  public final long dOJ()
  {
    return this.wXS;
  }
  
  public final int dPa()
  {
    int m = this.wZO.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.wZO.get(j)).mWl.iterator();
      if (localIterator.hasNext())
      {
        String str = Util.nullAs(((m)localIterator.next()).wVX, "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */