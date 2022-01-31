package android.support.v7.widget;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$f
{
  RecyclerView.f.b agN = null;
  private ArrayList<RecyclerView.f.a> agO = new ArrayList();
  public long agP = 120L;
  public long agQ = 120L;
  public long agR = 250L;
  public long agS = 250L;
  
  static int k(RecyclerView.v paramv)
  {
    int j = RecyclerView.v.v(paramv) & 0xE;
    int i;
    if (paramv.ij()) {
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
          k = paramv.aig;
          m = paramv.id();
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
        parama.hQ();
      }
    }
    else {
      return bool;
    }
    this.agO.add(parama);
    return bool;
  }
  
  public abstract boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return n(paramv);
  }
  
  public abstract void d(RecyclerView.v paramv);
  
  public abstract boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public abstract boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public abstract boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
  
  public abstract void gA();
  
  public abstract void gC();
  
  public final void hP()
  {
    int j = this.agO.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.f.a)this.agO.get(i)).hQ();
      i += 1;
    }
    this.agO.clear();
  }
  
  public abstract boolean isRunning();
  
  public final void l(RecyclerView.v paramv)
  {
    m(paramv);
    if (this.agN != null) {
      this.agN.m(paramv);
    }
  }
  
  public void m(RecyclerView.v paramv) {}
  
  public boolean n(RecyclerView.v paramv)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.f
 * JD-Core Version:    0.7.0.1
 */