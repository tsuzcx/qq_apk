package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements Cloneable, Iterable<f>
{
  HashMap<String, ar> iVP = new HashMap();
  protected HashMap<String, ar> iVQ = new HashMap();
  public boolean iVR = q.Gv();
  protected ArrayList<f> mItemList;
  
  public c() {}
  
  public c(com.tencent.mm.plugin.emoji.model.f paramf) {}
  
  public c(List<f> paramList)
  {
    this();
    if (paramList == null) {
      return;
    }
    this.mItemList = new ArrayList();
    this.mItemList.addAll(paramList);
  }
  
  public final f Al(String paramString)
  {
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        vn localvn = localf.iVU;
        if ((localvn != null) && (localvn.syc != null) && (localvn.syc.equals(paramString))) {
          return localf;
        }
      }
    }
    return null;
  }
  
  public final void Am(String paramString)
  {
    f localf = Al(paramString);
    if (localf == null) {
      return;
    }
    localf.setStatus(-1);
    localf.a(this.iVR, Ap(paramString), An(paramString));
  }
  
  public final boolean An(String paramString)
  {
    if (this.iVQ == null) {
      return false;
    }
    return this.iVQ.containsKey(paramString);
  }
  
  public final ar Ao(String paramString)
  {
    ar localar2 = Ap(paramString);
    ar localar1 = localar2;
    if (localar2 == null)
    {
      localar1 = new ar(paramString);
      this.iVP.put(paramString, localar1);
    }
    return localar1;
  }
  
  public final ar Ap(String paramString)
  {
    return (ar)this.iVP.get(paramString);
  }
  
  public final c aGW()
  {
    try
    {
      c localc = (c)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        if (this.mItemList != null) {
          localc.mItemList = ((ArrayList)this.mItemList.clone());
        }
        return localc;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public void aGX()
  {
    if (this.mItemList == null) {}
    while (i.aHU().iYf == null) {
      return;
    }
    Iterator localIterator = this.mItemList.iterator();
    label25:
    f localf;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localf = (f)localIterator.next();
      Object localObject2 = localf.iVU;
      if (localObject2 != null)
      {
        localObject1 = i.aHU();
        localObject2 = ((vn)localObject2).syc;
        localObject1 = (Integer)((e)localObject1).iYf.get(localObject2);
        if (localObject1 != null) {
          break label127;
        }
      }
    }
    label127:
    for (int i = -1;; i = ((Integer)localObject1).intValue())
    {
      if (i >= 0)
      {
        localf.setStatus(6);
        localf.xL = i;
      }
      if ((i >= 0) || (localf.mStatus != 6)) {
        break label25;
      }
      localf.setStatus(3);
      break label25;
      break;
    }
  }
  
  public void clear()
  {
    if (this.mItemList != null)
    {
      this.mItemList.clear();
      this.mItemList = null;
    }
    if (this.iVP != null)
    {
      this.iVP.clear();
      this.iVP = null;
    }
    if (this.iVQ != null)
    {
      this.iVQ.clear();
      this.iVQ = null;
    }
  }
  
  public Iterator<f> iterator()
  {
    return new c.a(this, (byte)0);
  }
  
  public void notifyDataSetChanged()
  {
    if (this.mItemList == null) {
      return;
    }
    this.iVQ = i.getEmojiStorageMgr().uBc.cwn();
    Iterator localIterator = this.mItemList.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject = localf.iVU;
      if (localObject != null)
      {
        if (com.tencent.mm.plugin.emoji.h.a.d((vn)localObject))
        {
          if (com.tencent.mm.plugin.emoji.h.a.aJh()) {}
          for (int i = 7;; i = 3)
          {
            localf.setStatus(i);
            break;
          }
        }
        localObject = ((vn)localObject).syc;
        localf.a(this.iVR, Ap((String)localObject), An((String)localObject));
      }
    }
    aGX();
  }
  
  public final f pT(int paramInt)
  {
    if ((this.mItemList == null) || (this.mItemList.size() <= paramInt) || (paramInt < 0)) {}
    while (this.mItemList == null) {
      return null;
    }
    return (f)this.mItemList.get(paramInt);
  }
  
  public final int size()
  {
    if (this.mItemList == null) {
      return 0;
    }
    return this.mItemList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.c
 * JD-Core Version:    0.7.0.1
 */