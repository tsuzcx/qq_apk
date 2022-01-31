package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.protocal.c.kq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends c
{
  List<bjr> idY = null;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> idZ = new SparseArray();
  private int iea;
  
  public f(Context paramContext)
  {
    super(paramContext);
    setReporter(new f.1(this));
  }
  
  public final void a(kq paramkq, boolean paramBoolean)
  {
    super.a(paramkq, paramBoolean);
    if (this.iea == 0) {
      this.iea = super.getCount();
    }
  }
  
  public final void axz()
  {
    super.axz();
  }
  
  public final int getCount()
  {
    int i = super.getCount();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (this.idY != null)
      {
        Iterator localIterator = this.idY.iterator();
        if (localIterator.hasNext())
        {
          bjr localbjr = (bjr)localIterator.next();
          if ((localbjr == null) || (localbjr.tDw == null)) {
            break label81;
          }
          i += localbjr.tDw.size();
        }
      }
    }
    label81:
    for (;;)
    {
      break;
      j = i;
      return j;
    }
  }
  
  public final void h(String paramString, List<kq> paramList)
  {
    super.h(paramString, paramList);
    this.iea = super.getCount();
  }
  
  protected final Object[] ou(int paramInt)
  {
    Object localObject2 = or(paramInt);
    Object localObject1 = os(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).icJ;
      if (paramInt < this.iea)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label71;
        }
      }
      label71:
      for (localObject1 = ((kq)localObject1).sFF;; localObject1 = "")
      {
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    return super.ou(paramInt);
  }
  
  public final com.tencent.mm.ui.base.sortview.a ow(int paramInt)
  {
    int i = super.getCount();
    if (i != 0) {
      localObject1 = super.ow(paramInt);
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.idZ.get(paramInt);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = localObject2;
    } while (this.idY.size() <= 0);
    Object localObject1 = this.idY.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bjr)((Iterator)localObject1).next();
      if (i == paramInt) {
        if (((bjr)localObject2).tDu == null)
        {
          localObject1 = null;
          label98:
          boe localboe = (boe)((bjr)localObject2).tDw.get(0);
          localObject2 = localObject1;
          localObject1 = localboe;
        }
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).ox(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.idZ.put(paramInt, localObject1);
      return localObject1;
      localObject1 = ((bjr)localObject2).tDu.toString();
      break label98;
      if (paramInt < ((bjr)localObject2).tDw.size() + i)
      {
        localObject1 = (boe)((bjr)localObject2).tDw.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((bjr)localObject2).tDw.size() + i;
        break;
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f
 * JD-Core Version:    0.7.0.1
 */