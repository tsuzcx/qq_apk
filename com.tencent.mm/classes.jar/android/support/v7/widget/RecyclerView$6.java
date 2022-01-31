package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class RecyclerView$6
  implements d.a
{
  RecyclerView$6(RecyclerView paramRecyclerView) {}
  
  private void f(d.b paramb)
  {
    switch (paramb.vA)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      this.aja.ahW.c(this.aja, paramb.ZW, paramb.ZY);
      return;
    case 2: 
      this.aja.ahW.d(this.aja, paramb.ZW, paramb.ZY);
      return;
    case 4: 
      this.aja.ahW.a(this.aja, paramb.ZW, paramb.ZY, paramb.ZX);
      return;
    }
    this.aja.ahW.a(this.aja, paramb.ZW, paramb.ZY, 1);
  }
  
  public final void K(int paramInt1, int paramInt2)
  {
    this.aja.e(paramInt1, paramInt2, true);
    this.aja.aiN = true;
    RecyclerView.s locals = this.aja.aiK;
    locals.akc += paramInt2;
  }
  
  public final void L(int paramInt1, int paramInt2)
  {
    this.aja.e(paramInt1, paramInt2, false);
    this.aja.aiN = true;
  }
  
  public final void M(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.aja;
    int j = localRecyclerView.ahR.hx();
    int i = 0;
    while (i < j)
    {
      localObject = RecyclerView.bp(localRecyclerView.ahR.bt(i));
      if ((localObject != null) && (!((RecyclerView.v)localObject).jL()) && (((RecyclerView.v)localObject).mPosition >= paramInt1))
      {
        ((RecyclerView.v)localObject).l(paramInt2, false);
        localRecyclerView.aiK.akf = true;
      }
      i += 1;
    }
    Object localObject = localRecyclerView.ahO;
    j = ((RecyclerView.o)localObject).ajJ.size();
    i = 0;
    while (i < j)
    {
      RecyclerView.v localv = (RecyclerView.v)((RecyclerView.o)localObject).ajJ.get(i);
      if ((localv != null) && (localv.mPosition >= paramInt1)) {
        localv.l(paramInt2, true);
      }
      i += 1;
    }
    localRecyclerView.requestLayout();
    this.aja.aiN = true;
  }
  
  public final void N(int paramInt1, int paramInt2)
  {
    int n = -1;
    RecyclerView localRecyclerView = this.aja;
    int i1 = localRecyclerView.ahR.hx();
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
      localObject = RecyclerView.bp(localRecyclerView.ahR.bt(m));
      if ((localObject != null) && (((RecyclerView.v)localObject).mPosition >= k) && (((RecyclerView.v)localObject).mPosition <= j))
      {
        if (((RecyclerView.v)localObject).mPosition != paramInt1) {
          break label129;
        }
        ((RecyclerView.v)localObject).l(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      localRecyclerView.aiK.akf = true;
      m += 1;
      break label35;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label129:
      ((RecyclerView.v)localObject).l(i, false);
    }
    label139:
    Object localObject = localRecyclerView.ahO;
    label173:
    RecyclerView.v localv;
    if (paramInt1 < paramInt2)
    {
      j = paramInt2;
      k = paramInt1;
      i = n;
      n = ((RecyclerView.o)localObject).ajJ.size();
      m = 0;
      if (m >= n) {
        break label268;
      }
      localv = (RecyclerView.v)((RecyclerView.o)localObject).ajJ.get(m);
      if ((localv != null) && (localv.mPosition >= k) && (localv.mPosition <= j))
      {
        if (localv.mPosition != paramInt1) {
          break label258;
        }
        localv.l(paramInt2 - paramInt1, false);
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
      localv.l(i, false);
    }
    label268:
    localRecyclerView.requestLayout();
    this.aja.aiN = true;
  }
  
  public final RecyclerView.v bn(int paramInt)
  {
    RecyclerView.v localv = this.aja.k(paramInt, true);
    if (localv == null) {}
    while (this.aja.ahR.ba(localv.aku)) {
      return null;
    }
    return localv;
  }
  
  public final void d(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this.aja;
    int j = ((RecyclerView)localObject).ahR.hx();
    int i = 0;
    while (i < j)
    {
      View localView = ((RecyclerView)localObject).ahR.bt(i);
      RecyclerView.v localv = RecyclerView.bp(localView);
      if ((localv != null) && (!localv.jL()) && (localv.mPosition >= paramInt1) && (localv.mPosition < paramInt1 + paramInt2))
      {
        localv.addFlags(2);
        localv.M(paramObject);
        ((RecyclerView.LayoutParams)localView.getLayoutParams()).ajz = true;
      }
      i += 1;
    }
    paramObject = ((RecyclerView)localObject).ahO;
    i = paramObject.ajJ.size() - 1;
    while (i >= 0)
    {
      localObject = (RecyclerView.v)paramObject.ajJ.get(i);
      if (localObject != null)
      {
        j = ((RecyclerView.v)localObject).mPosition;
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          ((RecyclerView.v)localObject).addFlags(2);
          paramObject.cd(i);
        }
      }
      i -= 1;
    }
    this.aja.aiO = true;
  }
  
  public final void d(d.b paramb)
  {
    f(paramb);
  }
  
  public final void e(d.b paramb)
  {
    f(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.6
 * JD-Core Version:    0.7.0.1
 */