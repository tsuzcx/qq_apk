package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements Cloneable, Iterable<f>
{
  protected ArrayList<f> mItemList;
  private HashMap<String, ax> oYg;
  protected HashMap<String, ax> oYh;
  public boolean oYi;
  
  public c()
  {
    AppMethodBeat.i(108356);
    this.oYg = new HashMap();
    this.oYh = new HashMap();
    this.oYi = u.axK();
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
  
  public final f Bp(int paramInt)
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
  
  public final f XB(String paramString)
  {
    AppMethodBeat.i(108360);
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        EmotionSummary localEmotionSummary = localf.oYl;
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
  
  public final void XC(String paramString)
  {
    AppMethodBeat.i(108363);
    f localf = XB(paramString);
    if (localf == null)
    {
      AppMethodBeat.o(108363);
      return;
    }
    localf.setStatus(-1);
    localf.a(this.oYi, XF(paramString), XD(paramString));
    AppMethodBeat.o(108363);
  }
  
  public final boolean XD(String paramString)
  {
    AppMethodBeat.i(108364);
    if (this.oYh == null)
    {
      AppMethodBeat.o(108364);
      return false;
    }
    boolean bool = this.oYh.containsKey(paramString);
    AppMethodBeat.o(108364);
    return bool;
  }
  
  public final ax XE(String paramString)
  {
    AppMethodBeat.i(108365);
    ax localax2 = XF(paramString);
    ax localax1 = localax2;
    if (localax2 == null)
    {
      localax1 = new ax(paramString);
      this.oYg.put(paramString, localax1);
    }
    AppMethodBeat.o(108365);
    return localax1;
  }
  
  public final ax XF(String paramString)
  {
    AppMethodBeat.i(108366);
    paramString = (ax)this.oYg.get(paramString);
    AppMethodBeat.o(108366);
    return paramString;
  }
  
  public final void cR(String paramString, int paramInt)
  {
    AppMethodBeat.i(108368);
    paramString = (ax)this.oYg.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(108368);
      return;
    }
    paramString.YK(paramInt);
    AppMethodBeat.o(108368);
  }
  
  public final c cbJ()
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
  
  public void cbK()
  {
    AppMethodBeat.i(108369);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    if (k.ccr().pax == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject2 = localf.oYl;
      if (localObject2 != null)
      {
        Object localObject1 = k.ccr();
        localObject2 = ((EmotionSummary)localObject2).ProductID;
        localObject1 = (Integer)((e)localObject1).pax.get(localObject2);
        if (localObject1 == null) {}
        for (int i = -1;; i = ((Integer)localObject1).intValue())
        {
          if (i >= 0)
          {
            localf.setStatus(6);
            localf.FG = i;
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
  
  public void clear()
  {
    AppMethodBeat.i(108354);
    if (this.mItemList != null)
    {
      this.mItemList.clear();
      this.mItemList = null;
    }
    if (this.oYg != null)
    {
      this.oYg.clear();
      this.oYg = null;
    }
    if (this.oYh != null)
    {
      this.oYh.clear();
      this.oYh = null;
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
    this.oYh = k.getEmojiStorageMgr().GYa.fcO();
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject = localf.oYl;
      if (localObject != null)
      {
        if (a.g((EmotionSummary)localObject))
        {
          if (a.cdF()) {}
          for (int i = 7;; i = 3)
          {
            localf.setStatus(i);
            break;
          }
        }
        localObject = ((EmotionSummary)localObject).ProductID;
        localf.a(this.oYi, XF((String)localObject), XD((String)localObject));
      }
    }
    cbK();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */