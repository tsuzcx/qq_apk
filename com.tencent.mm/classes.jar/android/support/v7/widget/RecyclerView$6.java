package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class RecyclerView$6
  implements e.a
{
  RecyclerView$6(RecyclerView paramRecyclerView) {}
  
  private void f(e.b paramb)
  {
    switch (paramb.uC)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      this.agK.afG.N(paramb.Zl, paramb.Zn);
      return;
    case 2: 
      this.agK.afG.O(paramb.Zl, paramb.Zn);
      return;
    case 4: 
      this.agK.afG.P(paramb.Zl, paramb.Zn);
      return;
    }
    this.agK.afG.Q(paramb.Zl, paramb.Zn);
  }
  
  public final void H(int paramInt1, int paramInt2)
  {
    this.agK.d(paramInt1, paramInt2, true);
    this.agK.agx = true;
    RecyclerView.s locals = this.agK.agu;
    locals.ahM += paramInt2;
  }
  
  public final void I(int paramInt1, int paramInt2)
  {
    this.agK.d(paramInt1, paramInt2, false);
    this.agK.agx = true;
  }
  
  public final void J(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.agK;
    int j = localRecyclerView.afB.gx();
    int i = 0;
    while (i < j)
    {
      localObject = RecyclerView.bf(localRecyclerView.afB.bt(i));
      if ((localObject != null) && (!((RecyclerView.v)localObject).ib()) && (((RecyclerView.v)localObject).mPosition >= paramInt1))
      {
        ((RecyclerView.v)localObject).p(paramInt2, false);
        localRecyclerView.agu.ahP = true;
      }
      i += 1;
    }
    Object localObject = localRecyclerView.afy;
    j = ((RecyclerView.o)localObject).aht.size();
    i = 0;
    while (i < j)
    {
      RecyclerView.v localv = (RecyclerView.v)((RecyclerView.o)localObject).aht.get(i);
      if ((localv != null) && (localv.mPosition >= paramInt1)) {
        localv.p(paramInt2, true);
      }
      i += 1;
    }
    localRecyclerView.requestLayout();
    this.agK.agx = true;
  }
  
  public final void K(int paramInt1, int paramInt2)
  {
    int n = -1;
    RecyclerView localRecyclerView = this.agK;
    int i1 = localRecyclerView.afB.gx();
    int i;
    int j;
    int k;
    int m;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
      k = paramInt1;
      m = 0;
      label35:
      if (m >= i1) {
        break label139;
      }
      localObject = RecyclerView.bf(localRecyclerView.afB.bt(m));
      if ((localObject != null) && (((RecyclerView.v)localObject).mPosition >= k) && (((RecyclerView.v)localObject).mPosition <= j))
      {
        if (((RecyclerView.v)localObject).mPosition != paramInt1) {
          break label129;
        }
        ((RecyclerView.v)localObject).p(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      localRecyclerView.agu.ahP = true;
      m += 1;
      break label35;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label129:
      ((RecyclerView.v)localObject).p(i, false);
    }
    label139:
    Object localObject = localRecyclerView.afy;
    label173:
    RecyclerView.v localv;
    if (paramInt1 < paramInt2)
    {
      j = paramInt2;
      k = paramInt1;
      i = n;
      n = ((RecyclerView.o)localObject).aht.size();
      m = 0;
      if (m >= n) {
        break label268;
      }
      localv = (RecyclerView.v)((RecyclerView.o)localObject).aht.get(m);
      if ((localv != null) && (localv.mPosition >= k) && (localv.mPosition <= j))
      {
        if (localv.mPosition != paramInt1) {
          break label258;
        }
        localv.p(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      m += 1;
      break label173;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label258:
      localv.p(i, false);
    }
    label268:
    localRecyclerView.requestLayout();
    this.agK.agx = true;
  }
  
  public final void b(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this.agK;
    int j = ((RecyclerView)localObject).afB.gx();
    int i = 0;
    while (i < j)
    {
      View localView = ((RecyclerView)localObject).afB.bt(i);
      RecyclerView.v localv = RecyclerView.bf(localView);
      if ((localv != null) && (!localv.ib()) && (localv.mPosition >= paramInt1) && (localv.mPosition < paramInt1 + paramInt2))
      {
        localv.addFlags(2);
        localv.M(paramObject);
        ((RecyclerView.LayoutParams)localView.getLayoutParams()).ahj = true;
      }
      i += 1;
    }
    paramObject = ((RecyclerView)localObject).afy;
    i = paramObject.aht.size() - 1;
    while (i >= 0)
    {
      localObject = (RecyclerView.v)paramObject.aht.get(i);
      if (localObject != null)
      {
        j = ((RecyclerView.v)localObject).mPosition;
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          ((RecyclerView.v)localObject).addFlags(2);
          paramObject.bW(i);
        }
      }
      i -= 1;
    }
    this.agK.agy = true;
  }
  
  public final RecyclerView.v bo(int paramInt)
  {
    RecyclerView localRecyclerView = this.agK;
    int j = localRecyclerView.afB.gx();
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    if (i < j)
    {
      localObject2 = RecyclerView.bf(localRecyclerView.afB.bt(i));
      if ((localObject2 == null) || (((RecyclerView.v)localObject2).isRemoved()) || (((RecyclerView.v)localObject2).mPosition != paramInt)) {
        break label127;
      }
      localObject1 = localObject2;
      if (localRecyclerView.afB.aS(((RecyclerView.v)localObject2).aie)) {
        localObject1 = localObject2;
      }
    }
    label127:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null) {
        localObject2 = null;
      }
      do
      {
        return localObject2;
        localObject2 = localObject1;
      } while (!this.agK.afB.aS(localObject1.aie));
      return null;
    }
  }
  
  public final void d(e.b paramb)
  {
    f(paramb);
  }
  
  public final void e(e.b paramb)
  {
    f(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.6
 * JD-Core Version:    0.7.0.1
 */