package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c
  implements Cloneable, Iterable<f>
{
  protected HashMap<String, bj> xHA;
  public boolean xHB;
  protected ArrayList<f> xHy;
  private HashMap<String, bj> xHz;
  
  public c()
  {
    AppMethodBeat.i(108356);
    this.xHz = new HashMap();
    this.xHA = new HashMap();
    this.xHB = z.bBh();
    AppMethodBeat.o(108356);
  }
  
  public c(m paramm) {}
  
  public c(List<f> paramList)
  {
    this();
    AppMethodBeat.i(108357);
    if (paramList == null)
    {
      AppMethodBeat.o(108357);
      return;
    }
    this.xHy = new ArrayList();
    this.xHy.addAll(paramList);
    AppMethodBeat.o(108357);
  }
  
  public final f Ki(int paramInt)
  {
    AppMethodBeat.i(108359);
    if ((this.xHy == null) || (this.xHy.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(108359);
      return null;
    }
    if (this.xHy == null)
    {
      AppMethodBeat.o(108359);
      return null;
    }
    f localf = (f)this.xHy.get(paramInt);
    AppMethodBeat.o(108359);
    return localf;
  }
  
  public final f anN(String paramString)
  {
    AppMethodBeat.i(108360);
    if (this.xHy != null)
    {
      Iterator localIterator = this.xHy.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        cjb localcjb = localf.xHE;
        if ((localcjb != null) && (localcjb.ProductID != null) && (localcjb.ProductID.equals(paramString)))
        {
          AppMethodBeat.o(108360);
          return localf;
        }
      }
    }
    AppMethodBeat.o(108360);
    return null;
  }
  
  public final void anO(String paramString)
  {
    AppMethodBeat.i(108363);
    f localf = anN(paramString);
    if (localf == null)
    {
      AppMethodBeat.o(108363);
      return;
    }
    localf.setStatus(-1);
    localf.a(this.xHB, anR(paramString), anP(paramString));
    AppMethodBeat.o(108363);
  }
  
  public final boolean anP(String paramString)
  {
    AppMethodBeat.i(108364);
    if (this.xHA == null)
    {
      AppMethodBeat.o(108364);
      return false;
    }
    boolean bool = this.xHA.containsKey(paramString);
    AppMethodBeat.o(108364);
    return bool;
  }
  
  public final bj anQ(String paramString)
  {
    AppMethodBeat.i(108365);
    bj localbj2 = anR(paramString);
    bj localbj1 = localbj2;
    if (localbj2 == null)
    {
      localbj1 = new bj(paramString);
      this.xHz.put(paramString, localbj1);
    }
    AppMethodBeat.o(108365);
    return localbj1;
  }
  
  public final bj anR(String paramString)
  {
    AppMethodBeat.i(108366);
    paramString = (bj)this.xHz.get(paramString);
    AppMethodBeat.o(108366);
    return paramString;
  }
  
  public void clear()
  {
    AppMethodBeat.i(108354);
    if (this.xHy != null)
    {
      this.xHy.clear();
      this.xHy = null;
    }
    if (this.xHz != null)
    {
      this.xHz.clear();
      this.xHz = null;
    }
    if (this.xHA != null)
    {
      this.xHA.clear();
      this.xHA = null;
    }
    AppMethodBeat.o(108354);
  }
  
  public final void dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(108368);
    paramString = (bj)this.xHz.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(108368);
      return;
    }
    paramString.ayW(paramInt);
    AppMethodBeat.o(108368);
  }
  
  public final c dym()
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
      if (this.xHy != null)
      {
        localc3.xHy = ((ArrayList)this.xHy.clone());
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
  
  public void dyn()
  {
    AppMethodBeat.i(108369);
    if (this.xHy == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    if (s.dAq().xMS == null)
    {
      AppMethodBeat.o(108369);
      return;
    }
    Iterator localIterator = this.xHy.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      cjb localcjb = localf.xHE;
      if (localcjb != null)
      {
        int i = s.dAq().aoI(localcjb.ProductID);
        if (i >= 0)
        {
          localf.setStatus(6);
          localf.boE = i;
        }
        if ((i < 0) && (localf.mStatus == 6)) {
          localf.setStatus(3);
        }
      }
    }
    AppMethodBeat.o(108369);
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
    if (this.xHy == null)
    {
      AppMethodBeat.o(108362);
      return;
    }
    this.xHA = s.getEmojiStorageMgr().adjv.jcZ();
    Iterator localIterator = this.xHy.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      Object localObject = localf.xHE;
      if (localObject != null)
      {
        if (com.tencent.mm.plugin.emoji.g.c.i((cjb)localObject))
        {
          if (com.tencent.mm.plugin.emoji.g.c.dBJ()) {}
          for (int i = 7;; i = 3)
          {
            localf.setStatus(i);
            break;
          }
        }
        localObject = ((cjb)localObject).ProductID;
        localf.a(this.xHB, anR((String)localObject), anP((String)localObject));
      }
    }
    dyn();
    AppMethodBeat.o(108362);
  }
  
  public final int size()
  {
    AppMethodBeat.i(108358);
    if (this.xHy == null)
    {
      AppMethodBeat.o(108358);
      return 0;
    }
    int i = this.xHy.size();
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