package android.support.v7.widget;

import android.view.View;

public abstract class as
  extends RecyclerView.f
{
  public boolean awK = true;
  
  public void A(RecyclerView.w paramw) {}
  
  public void B(RecyclerView.w paramw) {}
  
  public void C(RecyclerView.w paramw) {}
  
  public void D(RecyclerView.w paramw) {}
  
  public abstract boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    int k = paramc1.left;
    int m = paramc1.top;
    int i;
    if (paramw2.lL()) {
      i = paramc1.left;
    }
    for (int j = paramc1.top;; j = paramc2.top)
    {
      return a(paramw1, paramw2, k, m, i, j);
      i = paramc2.left;
    }
  }
  
  public abstract boolean b(RecyclerView.w paramw);
  
  public abstract boolean c(RecyclerView.w paramw);
  
  public boolean d(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    int k = paramc1.left;
    int m = paramc1.top;
    paramc1 = paramw.auu;
    int i;
    if (paramc2 == null)
    {
      i = paramc1.getLeft();
      if (paramc2 != null) {
        break label103;
      }
    }
    label103:
    for (int j = paramc1.getTop();; j = paramc2.top)
    {
      if ((paramw.isRemoved()) || ((k == i) && (m == j))) {
        break label112;
      }
      paramc1.layout(i, j, paramc1.getWidth() + i, paramc1.getHeight() + j);
      return a(paramw, k, m, i, j);
      i = paramc2.left;
      break;
    }
    label112:
    return b(paramw);
  }
  
  public boolean e(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top))) {
      return a(paramw, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    }
    return c(paramw);
  }
  
  public boolean f(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)) {
      return a(paramw, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    }
    x(paramw);
    return false;
  }
  
  public final void mu()
  {
    this.awK = false;
  }
  
  public boolean p(RecyclerView.w paramw)
  {
    return (!this.awK) || (paramw.isInvalid());
  }
  
  public final void w(RecyclerView.w paramw)
  {
    B(paramw);
    n(paramw);
  }
  
  public final void x(RecyclerView.w paramw)
  {
    D(paramw);
    n(paramw);
  }
  
  public final void y(RecyclerView.w paramw)
  {
    n(paramw);
  }
  
  public final void z(RecyclerView.w paramw)
  {
    A(paramw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.as
 * JD-Core Version:    0.7.0.1
 */