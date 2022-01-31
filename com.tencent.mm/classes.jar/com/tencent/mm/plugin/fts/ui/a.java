package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  extends b
  implements com.tencent.mm.plugin.fts.a.l
{
  public String bVk;
  HashSet<String> kxd = new HashSet();
  private com.tencent.mm.plugin.fts.a.a.a kxg;
  public List<e.a> kzW = Collections.synchronizedList(new LinkedList());
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public abstract com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, com.tencent.mm.plugin.fts.a.a.l paraml, e.a parama)
  {
    return null;
  }
  
  public abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  public abstract void a(j paramj, HashSet<String> paramHashSet);
  
  public final void a(String paramString, ah paramah, HashSet<String> paramHashSet)
  {
    aVC();
    adg();
    this.bVk = paramString;
    this.kxg = a(paramah, paramHashSet);
  }
  
  public final void aVC()
  {
    if (this.kxg != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.kxg);
      this.kxg = null;
    }
  }
  
  public final LinkedList<Integer> aVD()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.kzW.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.kzW.get(i);
      if (locala.kxK != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.kxK));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int aVE()
  {
    return aVU();
  }
  
  public final int aVU()
  {
    int m = this.kzW.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.kzW.get(j)).kxO.iterator();
      if (localIterator.hasNext())
      {
        String str = bk.aM(((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).kwg, "");
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
  
  public final void adg()
  {
    this.bVk = null;
    this.kxd.clear();
    this.kzW.clear();
  }
  
  public k b(int paramInt, e.a parama)
  {
    return new k(paramInt);
  }
  
  public final void b(j paramj)
  {
    switch (paramj.aYY)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramj.kxh.size()) });
      if ((this.bVk == null) || (!this.bVk.equals(paramj.ktu.bVk)))
      {
        y.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramj.ktu.bVk, this.bVk });
        return;
      }
      this.kxd = paramj.ktu.kxd;
      a(paramj, this.kxd);
    }
    do
    {
      this.kxI.a(this, paramj.ktu.bVk);
      return;
      y.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramj.aYY), paramj.ktu.bVk });
    } while (paramj.ktu.bVk.equals(this.bVk));
    y.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  public com.tencent.mm.plugin.fts.ui.a.n c(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.kxW = (parama.kxM - parama.kxK);
    localn.kyc = true;
    return localn;
  }
  
  public int rx(int paramInt)
  {
    int k = this.kzW.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.kzW.get(i);
      locala.kxK = paramInt;
      int j = paramInt;
      if (locala.kxL) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.kxO.size() + locala.kxR);
      locala.kxM = paramInt;
      if (!locala.kxN) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    int j = this.kzW.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.kzW.get(i);
      if ((locala.kxK == paramInt) && (locala.kxL)) {
        localObject = b(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.kxM) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxT = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxJ = this.kxJ;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kwi = locala.kwi;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxU = locala.businessType;
        return localObject;
        if ((locala.kxM == paramInt) && (locala.kxN))
        {
          localObject = c(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.kxM) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */