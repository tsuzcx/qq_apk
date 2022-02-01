package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.h;
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
  HashSet<String> BIS = new HashSet();
  private com.tencent.mm.plugin.fts.a.a.a BIV;
  private long BJO;
  public List<e.a> BLN = Collections.synchronizedList(new LinkedList());
  private String query;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final List<c> NG(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BJO > 0L)
    {
      int i = 0;
      if (i < this.BLN.size())
      {
        e.a locala = (e.a)this.BLN.get(i);
        int k = locala.pWR.size();
        int m = locala.BJE;
        int j = 0;
        c localc;
        while (j < m + k)
        {
          localc = b(j, locala);
          if (localc != null)
          {
            localc.BHU = (this.BJO - paramLong);
            localc.position = (locala.BJz + j + 1);
            localArrayList.add(localc);
          }
          j += 1;
        }
        if (locala.xcp)
        {
          localc = new c();
          localc.fND = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          localc.fNO = 4;
        }
        for (;;)
        {
          if (localc != null)
          {
            localc.BHU = (this.BJO - paramLong);
            localc.position = locala.BJB;
            localArrayList.add(localc);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            localc.fNO = 3;
          } else if (j == -1) {
            localc.fNO = 12;
          } else if (j == -2) {
            localc.fNO = 11;
          } else if (j == -6) {
            localc.fNO = 10;
          } else if (j == -13) {
            localc.fNO = 19;
          } else if (j == -7) {
            localc.fNO = 5;
          } else {
            localc = null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public int SB(int paramInt)
  {
    int k = this.BLN.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.BLN.get(i);
      locala.BJz = paramInt;
      int j = paramInt;
      if (locala.BJA) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.pWR.size() + locala.BJE);
      locala.BJB = paramInt;
      if (!locala.xcp) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    int j = this.BLN.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.BLN.get(i);
      if ((locala.BJz == paramInt) && (locala.BJA)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.BJB) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).ptD = eqY();
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BHY = locala.BHY;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).uMD = locala.businessType;
        return localObject;
        if ((locala.BJB == paramInt) && (locala.xcp))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.BJB) {
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
    eqZ();
    clearData();
    this.query = paramString;
    this.BIV = a(paramMMHandler, paramHashSet);
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
      Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.BIW.size()) });
      if ((this.query == null) || (!this.query.equals(paramk.BFk.query)))
      {
        Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramk.BFk.query, this.query });
        return;
      }
      this.BJO = System.currentTimeMillis();
      this.BIS = paramk.BFk.BIS;
      a(paramk, this.BIS);
    }
    do
    {
      eqX().a(this, paramk.BFk.query);
      return;
      Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramk.resultCode), paramk.BFk.query });
    } while (paramk.BFk.query.equals(this.query));
    Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    return new com.tencent.mm.plugin.fts.ui.a.k(paramInt);
  }
  
  public final void clearData()
  {
    this.query = null;
    this.BIS.clear();
    this.BLN.clear();
  }
  
  protected com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.BJI = (parama.BJB - parama.BJz);
    localn.BJP = true;
    return localn;
  }
  
  public final void eqZ()
  {
    if (this.BIV != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.BIV);
      this.BIV = null;
    }
  }
  
  public final LinkedList<Integer> era()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.BLN.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.BLN.get(i);
      if (locala.BJz != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.BJz));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int erb()
  {
    return eru();
  }
  
  public final long erc()
  {
    return this.BJO;
  }
  
  public final int eru()
  {
    int m = this.BLN.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.BLN.get(j)).pWR.iterator();
      if (localIterator.hasNext())
      {
        String str = Util.nullAs(((m)localIterator.next()).BHS, "");
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
  
  public final String getQuery()
  {
    return this.query;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */