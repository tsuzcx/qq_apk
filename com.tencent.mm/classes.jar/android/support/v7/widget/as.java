package android.support.v7.widget;

import android.view.View;

public abstract class as
  extends RecyclerView.f
{
  public boolean amy = true;
  
  public final void B(RecyclerView.v paramv)
  {
    E(paramv);
    m(paramv);
  }
  
  public final void C(RecyclerView.v paramv)
  {
    G(paramv);
    m(paramv);
  }
  
  public void D(RecyclerView.v paramv) {}
  
  public void E(RecyclerView.v paramv) {}
  
  public void F(RecyclerView.v paramv) {}
  
  public void G(RecyclerView.v paramv) {}
  
  public abstract boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    int k = paramc1.left;
    int m = paramc1.top;
    int i;
    if (paramv2.jL()) {
      i = paramc1.left;
    }
    for (int j = paramc1.top;; j = paramc2.top)
    {
      return a(paramv1, paramv2, k, m, i, j);
      i = paramc2.left;
    }
  }
  
  public abstract boolean b(RecyclerView.v paramv);
  
  public abstract boolean c(RecyclerView.v paramv);
  
  public boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    int k = paramc1.left;
    int m = paramc1.top;
    paramc1 = paramv.aku;
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
      if ((paramv.isRemoved()) || ((k == i) && (m == j))) {
        break label112;
      }
      paramc1.layout(i, j, paramc1.getWidth() + i, paramc1.getHeight() + j);
      return a(paramv, k, m, i, j);
      i = paramc2.left;
      break;
    }
    label112:
    return b(paramv);
  }
  
  public boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top))) {
      return a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    }
    return c(paramv);
  }
  
  public boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)) {
      return a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    }
    C(paramv);
    return false;
  }
  
  public final void ks()
  {
    this.amy = false;
  }
  
  public final boolean o(RecyclerView.v paramv)
  {
    return (!this.amy) || (paramv.jU());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.as
 * JD-Core Version:    0.7.0.1
 */