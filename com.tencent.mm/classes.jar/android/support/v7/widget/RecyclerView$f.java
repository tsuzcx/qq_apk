package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$f
{
  RecyclerView.f.b ajd = null;
  private ArrayList<RecyclerView.f.a> aje = new ArrayList();
  public long ajf = 120L;
  public long ajg = 120L;
  public long ajh = 250L;
  public long aji = 250L;
  
  static int l(RecyclerView.v paramv)
  {
    int j = RecyclerView.v.A(paramv) & 0xE;
    int i;
    if (paramv.jU()) {
      i = 4;
    }
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = j;
          } while ((j & 0x4) != 0);
          k = paramv.akw;
          m = paramv.jN();
          i = j;
        } while (k == -1);
        i = j;
      } while (m == -1);
      i = j;
    } while (k == m);
    return j | 0x800;
  }
  
  public RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    return new RecyclerView.f.c().c(paramv, 0);
  }
  
  public final boolean a(RecyclerView.f.a parama)
  {
    boolean bool = isRunning();
    if (parama != null)
    {
      if (!bool) {
        parama.jx();
      }
    }
    else {
      return bool;
    }
    this.aje.add(parama);
    return bool;
  }
  
  public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return o(paramv);
  }
  
  public abstract void d(RecyclerView.v paramv);
  
  public abstract boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public abstract boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public abstract boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public abstract void hA();
  
  public abstract void hC();
  
  public abstract boolean isRunning();
  
  public final void jw()
  {
    int j = this.aje.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.f.a)this.aje.get(i)).jx();
      i += 1;
    }
    this.aje.clear();
  }
  
  public final void m(RecyclerView.v paramv)
  {
    n(paramv);
    if (this.ajd != null) {
      this.ajd.n(paramv);
    }
  }
  
  public void n(RecyclerView.v paramv) {}
  
  public boolean o(RecyclerView.v paramv)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.f
 * JD-Core Version:    0.7.0.1
 */