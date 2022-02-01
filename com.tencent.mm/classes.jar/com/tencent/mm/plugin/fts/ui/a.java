package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.b.k;
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
  implements com.tencent.mm.plugin.fts.a.l
{
  HashSet<String> HtA = new HashSet();
  private c HtE;
  private long Hux;
  public List<e.a> HwJ = Collections.synchronizedList(new LinkedList());
  private String query;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public int Wi(int paramInt)
  {
    int k = this.HwJ.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.HwJ.get(i);
      locala.Huj = paramInt;
      int j = paramInt;
      if (locala.Huk) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.tbH.size() + locala.Hun);
      locala.Hul = paramInt;
      if (!locala.ABD) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    int j = this.HwJ.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.HwJ.get(i);
      if ((locala.Huj == paramInt) && (locala.Huk)) {
        localObject = c(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.Hul) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).syO = fxF();
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).FWt = locala.FWt;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).xVf = locala.businessType;
        return localObject;
        if ((locala.Hul == paramInt) && (locala.ABD))
        {
          localObject = d(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.Hul) {
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
  
  protected abstract c a(MMHandler paramMMHandler, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, o paramo, e.a parama)
  {
    return null;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  protected abstract void a(m paramm, HashSet<String> paramHashSet);
  
  public final void a(String paramString, MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    fxG();
    clearData();
    this.query = paramString;
    this.HtE = a(paramMMHandler, paramHashSet);
  }
  
  protected e b(int paramInt, e.a parama)
  {
    return null;
  }
  
  public final void b(m paramm)
  {
    switch (paramm.resultCode)
    {
    default: 
      return;
    case 0: 
      Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramm.HtF.size()) });
      if ((this.query == null) || (!this.query.equals(paramm.HpM.query)))
      {
        Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramm.HpM.query, this.query });
        return;
      }
      this.Hux = System.currentTimeMillis();
      this.HtA = paramm.HpM.HtA;
      a(paramm, this.HtA);
      fxE().a(this, paramm.HpM.query, true);
      return;
    }
    Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramm.resultCode), paramm.HpM.query });
    if (!paramm.HpM.query.equals(this.query))
    {
      Log.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
      return;
    }
    fxE().a(this, paramm.HpM.query, false);
  }
  
  protected k c(int paramInt, e.a parama)
  {
    return new k(paramInt);
  }
  
  public final void clearData()
  {
    this.query = null;
    this.HtA.clear();
    this.HwJ.clear();
  }
  
  protected com.tencent.mm.plugin.fts.ui.b.n d(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.b.n localn = new com.tencent.mm.plugin.fts.ui.b.n(paramInt);
    localn.Hur = (parama.Hul - parama.Huj);
    localn.Huy = true;
    return localn;
  }
  
  public final void fxG()
  {
    if (this.HtE != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.HtE);
      this.HtE = null;
    }
  }
  
  public final LinkedList<Integer> fxH()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.HwJ.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.HwJ.get(i);
      if (locala.Huj != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.Huj));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int fxI()
  {
    return fyc();
  }
  
  public final long fxJ()
  {
    return this.Hux;
  }
  
  public final int fyc()
  {
    int m = this.HwJ.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.HwJ.get(j)).tbH.iterator();
      if (localIterator.hasNext())
      {
        String str = Util.nullAs(((o)localIterator.next()).Hsz, "");
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
  
  public final List<e> rs(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.Hux > 0L)
    {
      int i = 0;
      if (i < this.HwJ.size())
      {
        e.a locala = (e.a)this.HwJ.get(i);
        int k = locala.tbH.size();
        int m = locala.Hun;
        int j = 0;
        e locale;
        while (j < m + k)
        {
          locale = b(j, locala);
          if (locale != null)
          {
            locale.HsB = (this.Hux - paramLong);
            locale.position = (locala.Huj + j + 1);
            localArrayList.add(locale);
          }
          j += 1;
        }
        if (locala.ABD)
        {
          locale = new e();
          locale.hTs = String.valueOf(locala.hashCode());
          j = locala.businessType;
          if (j != -3) {
            break label233;
          }
          locale.itemType = 4;
        }
        for (;;)
        {
          if (locale != null)
          {
            locale.HsB = (this.Hux - paramLong);
            locale.position = locala.Hul;
            localArrayList.add(locale);
          }
          i += 1;
          break;
          label233:
          if (j == -4) {
            locale.itemType = 3;
          } else if (j == -1) {
            locale.itemType = 12;
          } else if (j == -2) {
            locale.itemType = 11;
          } else if (j == -6) {
            locale.itemType = 10;
          } else if (j == -13) {
            locale.itemType = 19;
          } else if (j == -7) {
            locale.itemType = 5;
          } else if (j == -23) {
            locale.itemType = 31;
          } else {
            locale = null;
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */