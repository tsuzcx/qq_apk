package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements Cloneable, Iterable<f>
{
  protected ArrayList<f> mItemList;
  private HashMap<String, bh> uAV;
  protected HashMap<String, bh> uAW;
  public boolean uAX;
  
  public c()
  {
    AppMethodBeat.i(108356);
    this.uAV = new HashMap();
    this.uAW = new HashMap();
    this.uAX = z.bdp();
    AppMethodBeat.o(108356);
  }
  
  public c(l paraml) {}
  
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
  
  public final f JA(int paramInt)
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
  
  public final f atV(String paramString)
  {
    AppMethodBeat.i(108360);
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        akh localakh = localf.uBa;
        if ((localakh != null) && (localakh.ProductID != null) && (localakh.ProductID.equals(paramString)))
        {
          AppMethodBeat.o(108360);
          return localf;
        }
      }
    }
    AppMethodBeat.o(108360);
    return null;
  }
  
  public final void atW(String paramString)
  {
    AppMethodBeat.i(108363);
    f localf = atV(paramString);
    if (localf == null)
    {
      AppMethodBeat.o(108363);
      return;
    }
    localf.setStatus(-1);
    localf.a(this.uAX, atZ(paramString), atX(paramString));
    AppMethodBeat.o(108363);
  }
  
  public final boolean atX(String paramString)
  {
    AppMethodBeat.i(108364);
    if (this.uAW == null)
    {
      AppMethodBeat.o(108364);
      return false;
    }
    boolean bool = this.uAW.containsKey(paramString);
    AppMethodBeat.o(108364);
    return bool;
  }
  
  public final bh atY(String paramString)
  {
    AppMethodBeat.i(108365);
    bh localbh2 = atZ(paramString);
    bh localbh1 = localbh2;
    if (localbh2 == null)
    {
      localbh1 = new bh(paramString);
      this.uAV.put(paramString, localbh1);
    }
    AppMethodBeat.o(108365);
    return localbh1;
  }
  
  public final bh atZ(String paramString)
  {
    AppMethodBeat.i(108366);
    paramString = (bh)this.uAV.get(paramString);
    AppMethodBeat.o(108366);
    return paramString;
  }
  
  public final c cTR()
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
  
  public void cTS()
  {
    AppMethodBeat.i(108369);
    if (this.mItemList == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    if (p.cUT().uEv == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject2 = localf.uBa;
      if (localObject2 != null)
      {
        Object localObject1 = p.cUT();
        localObject2 = ((akh)localObject2).ProductID;
        localObject1 = (Integer)((k)localObject1).uEv.get(localObject2);
        if (localObject1 == null) {}
        for (int i = -1;; i = ((Integer)localObject1).intValue())
        {
          if (i >= 0)
          {
            localf.setStatus(6);
            localf.IB = i;
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
    if (this.uAV != null)
    {
      this.uAV.clear();
      this.uAV = null;
    }
    if (this.uAW != null)
    {
      this.uAW.clear();
      this.uAW = null;
    }
    AppMethodBeat.o(108354);
  }
  
  public final void dy(String paramString, int paramInt)
  {
    AppMethodBeat.i(108368);
    paramString = (bh)this.uAV.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(108368);
      return;
    }
    paramString.asG(paramInt);
    AppMethodBeat.o(108368);
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
    this.uAW = p.getEmojiStorageMgr().VFI.hAY();
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject = localf.uBa;
      if (localObject != null)
      {
        if (a.g((akh)localObject))
        {
          if (a.cWg()) {}
          for (int i = 7;; i = 3)
          {
            localf.setStatus(i);
            break;
          }
        }
        localObject = ((akh)localObject).ProductID;
        localf.a(this.uAX, atZ((String)localObject), atX((String)localObject));
      }
    }
    cTS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */