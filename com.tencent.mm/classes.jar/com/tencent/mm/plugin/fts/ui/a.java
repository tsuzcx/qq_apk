package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  extends b
  implements com.tencent.mm.plugin.fts.a.l
{
  HashSet<String> mSS = new HashSet();
  private com.tencent.mm.plugin.fts.a.a.a mSV;
  private long mVN;
  public List<e.a> mVO = Collections.synchronizedList(new LinkedList());
  protected String query;
  
  public a(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet);
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, com.tencent.mm.plugin.fts.a.a.l paraml, e.a parama)
  {
    return null;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama);
  
  protected abstract void a(j paramj, HashSet<String> paramHashSet);
  
  public final void a(String paramString, ak paramak, HashSet<String> paramHashSet, long paramLong)
  {
    bCd();
    clearData();
    this.query = paramString;
    this.mSV = a(paramak, paramHashSet);
  }
  
  protected k b(int paramInt, e.a parama)
  {
    return new k(paramInt);
  }
  
  public final void b(j paramj)
  {
    switch (paramj.bpE)
    {
    default: 
      return;
    case 0: 
      ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramj.mSW.size()) });
      if ((this.query == null) || (!this.query.equals(paramj.mPi.query)))
      {
        ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[] { paramj.mPi.query, this.query });
        return;
      }
      this.mVN = System.currentTimeMillis();
      this.mSS = paramj.mPi.mSS;
      a(paramj, this.mSS);
    }
    do
    {
      this.mTx.a(this, paramj.mPi.query);
      return;
      ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramj.bpE), paramj.mPi.query });
    } while (paramj.mPi.query.equals(this.query));
    ab.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
  }
  
  public final void bCd()
  {
    if (this.mSV != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.mSV);
      this.mSV = null;
    }
  }
  
  public final LinkedList<Integer> bCe()
  {
    LinkedList localLinkedList = new LinkedList();
    int j = this.mVO.size();
    int i = 0;
    while (i < j)
    {
      e.a locala = (e.a)this.mVO.get(i);
      if (locala.mTy != 2147483647) {
        localLinkedList.add(Integer.valueOf(locala.mTy));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int bCf()
  {
    return bCx();
  }
  
  public final long bCg()
  {
    return this.mVN;
  }
  
  public final int bCx()
  {
    int m = this.mVO.size();
    int j = 0;
    int k = 0;
    while (j < m)
    {
      Iterator localIterator = ((e.a)this.mVO.get(j)).mTC.iterator();
      if (localIterator.hasNext())
      {
        String str = bo.bf(((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).mRV, "");
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
  
  protected com.tencent.mm.plugin.fts.ui.a.n c(int paramInt, e.a parama)
  {
    com.tencent.mm.plugin.fts.ui.a.n localn = new com.tencent.mm.plugin.fts.ui.a.n(paramInt);
    localn.mTJ = (parama.mTA - parama.mTy);
    localn.mTP = true;
    return localn;
  }
  
  public final void clearData()
  {
    this.query = null;
    this.mSS.clear();
    this.mVO.clear();
  }
  
  public int wt(int paramInt)
  {
    int k = this.mVO.size();
    int i = 0;
    if (i < k)
    {
      e.a locala = (e.a)this.mVO.get(i);
      locala.mTy = paramInt;
      int j = paramInt;
      if (locala.mTz) {
        j = paramInt + 1;
      }
      paramInt = j + (locala.mTC.size() + locala.mTF);
      locala.mTA = paramInt;
      if (!locala.mTB) {
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
  
  public final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    int j = this.mVO.size();
    int i = 0;
    e.a locala;
    Object localObject;
    if (i < j)
    {
      locala = (e.a)this.mVO.get(i);
      if ((locala.mTy == paramInt) && (locala.mTz)) {
        localObject = b(paramInt, locala);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == locala.mTA) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
        }
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).ibk = this.ibk;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mRX = locala.mRX;
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).lox = locala.businessType;
        return localObject;
        if ((locala.mTA == paramInt) && (locala.mTB))
        {
          localObject = c(paramInt, locala);
          continue;
        }
        if (paramInt <= locala.mTA) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */