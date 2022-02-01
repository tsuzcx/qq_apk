package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements Cloneable, Iterable<f>
{
  protected ArrayList<f> mItemList;
  private HashMap<String, au> ouG;
  protected HashMap<String, au> ouH;
  public boolean ouI;
  
  public c()
  {
    AppMethodBeat.i(108356);
    this.ouG = new HashMap();
    this.ouH = new HashMap();
    this.ouI = u.aqU();
    AppMethodBeat.o(108356);
  }
  
  public c(com.tencent.mm.plugin.emoji.model.f paramf) {}
  
  public c(List<f> paramList)
  {
    this();
    AppMethodBeat.i(108357);
    if (paramList == null)
    {
      AppMethodBeat.o(108357);
      return;
    }
    this.mItemList = new ArrayList();
    this.mItemList.addAll(paramList);
    AppMethodBeat.o(108357);
  }
  
  public final f Ax(int paramInt)
  {
    AppMethodBeat.i(108359);
    if ((this.mItemList == null) || (this.mItemList.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(108359);
      return null;
    }
    if (this.mItemList == null)
    {
      AppMethodBeat.o(108359);
      return null;
    }
    f localf = (f)this.mItemList.get(paramInt);
    AppMethodBeat.o(108359);
    return localf;
  }
  
  public final f Tp(String paramString)
  {
    AppMethodBeat.i(108360);
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        EmotionSummary localEmotionSummary = localf.ouL;
        if ((localEmotionSummary != null) && (localEmotionSummary.ProductID != null) && (localEmotionSummary.ProductID.equals(paramString)))
        {
          AppMethodBeat.o(108360);
          return localf;
        }
      }
    }
    AppMethodBeat.o(108360);
    return null;
  }
  
  public final void Tq(String paramString)
  {
    AppMethodBeat.i(108363);
    f localf = Tp(paramString);
    if (localf == null)
    {
      AppMethodBeat.o(108363);
      return;
    }
    localf.setStatus(-1);
    localf.a(this.ouI, Tt(paramString), Tr(paramString));
    AppMethodBeat.o(108363);
  }
  
  public final boolean Tr(String paramString)
  {
    AppMethodBeat.i(108364);
    if (this.ouH == null)
    {
      AppMethodBeat.o(108364);
      return false;
    }
    boolean bool = this.ouH.containsKey(paramString);
    AppMethodBeat.o(108364);
    return bool;
  }
  
  public final au Ts(String paramString)
  {
    AppMethodBeat.i(108365);
    au localau2 = Tt(paramString);
    au localau1 = localau2;
    if (localau2 == null)
    {
      localau1 = new au(paramString);
      this.ouG.put(paramString, localau1);
    }
    AppMethodBeat.o(108365);
    return localau1;
  }
  
  public final au Tt(String paramString)
  {
    AppMethodBeat.i(108366);
    paramString = (au)this.ouG.get(paramString);
    AppMethodBeat.o(108366);
    return paramString;
  }
  
  public final c bUw()
  {
    AppMethodBeat.i(108361);
    try
    {
      localc3 = (c)super.clone();
      localc1 = localc3;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      for (;;)
      {
        c localc1;
        label38:
        Object localObject = null;
      }
    }
    try
    {
      if (this.mItemList != null)
      {
        localc3.mItemList = ((ArrayList)this.mItemList.clone());
        localc1 = localc3;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      c localc2 = localc3;
      break label38;
    }
    AppMethodBeat.o(108361);
    return localc1;
  }
  
  public void bUx()
  {
    AppMethodBeat.i(108369);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    if (k.bVe().owX == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject2 = localf.ouL;
      if (localObject2 != null)
      {
        Object localObject1 = k.bVe();
        localObject2 = ((EmotionSummary)localObject2).ProductID;
        localObject1 = (Integer)((e)localObject1).owX.get(localObject2);
        if (localObject1 == null) {}
        for (int i = -1;; i = ((Integer)localObject1).intValue())
        {
          if (i >= 0)
          {
            localf.setStatus(6);
            localf.EI = i;
          }
          if ((i >= 0) || (localf.mStatus != 6)) {
            break;
          }
          localf.setStatus(3);
          break;
        }
      }
    }
    AppMethodBeat.o(108369);
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(108368);
    paramString = (au)this.ouG.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(108368);
      return;
    }
    paramString.WA(paramInt);
    AppMethodBeat.o(108368);
  }
  
  public void clear()
  {
    AppMethodBeat.i(108354);
    if (this.mItemList != null)
    {
      this.mItemList.clear();
      this.mItemList = null;
    }
    if (this.ouG != null)
    {
      this.ouG.clear();
      this.ouG = null;
    }
    if (this.ouH != null)
    {
      this.ouH.clear();
      this.ouH = null;
    }
    AppMethodBeat.o(108354);
  }
  
  public Iterator<f> iterator()
  {
    AppMethodBeat.i(108367);
    a locala = new a((byte)0);
    AppMethodBeat.o(108367);
    return locala;
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(108362);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(108362);
      return;
    }
    this.ouH = k.getEmojiStorageMgr().FyZ.eNk();
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject = localf.ouL;
      if (localObject != null)
      {
        if (a.g((EmotionSummary)localObject))
        {
          if (a.bWs()) {}
          for (int i = 7;; i = 3)
          {
            localf.setStatus(i);
            break;
          }
        }
        localObject = ((EmotionSummary)localObject).ProductID;
        localf.a(this.ouI, Tt((String)localObject), Tr((String)localObject));
      }
    }
    bUx();
    AppMethodBeat.o(108362);
  }
  
  public final int size()
  {
    AppMethodBeat.i(108358);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(108358);
      return 0;
    }
    int i = this.mItemList.size();
    AppMethodBeat.o(108358);
    return i;
  }
  
  final class a
    implements Iterator<f>
  {
    private int mIndex = 0;
    
    private a() {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(108352);
      if (this.mIndex < c.this.size())
      {
        AppMethodBeat.o(108352);
        return true;
      }
      AppMethodBeat.o(108352);
      return false;
    }
    
    public final void remove() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */