package android.arch.b;

import android.support.v7.h.c.c;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import java.util.concurrent.Executor;

public abstract class i<T, VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private final a.a<T> dC = new a.a() {};
  private final a<T> eX;
  
  protected i(c.c<T> paramc)
  {
    this.eX = new a(this, paramc);
    this.eX.dC = this.dC;
  }
  
  public final void a(h<T> paramh)
  {
    a locala = this.eX;
    int i;
    if (paramh != null)
    {
      if ((locala.dE == null) && (locala.dF == null)) {
        locala.dD = paramh.ao();
      }
    }
    else if (paramh != locala.dE)
    {
      i = locala.dG + 1;
      locala.dG = i;
      if (paramh != null) {
        break label131;
      }
      i = locala.getItemCount();
      if (locala.dE == null) {
        break label116;
      }
      locala.dE.a(locala.dH);
      locala.dE = null;
    }
    for (;;)
    {
      locala.dz.k(0, i);
      return;
      if (paramh.ao() == locala.dD) {
        break;
      }
      throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
      label116:
      if (locala.dF != null) {
        locala.dF = null;
      }
    }
    label131:
    if ((locala.dE == null) && (locala.dF == null))
    {
      locala.dE = paramh;
      paramh.a(null, locala.dH);
      locala.dz.f(0, paramh.size());
      return;
    }
    if (locala.dE != null)
    {
      locala.dE.a(locala.dH);
      locala.dF = ((h)locala.dE.at());
      locala.dE = null;
    }
    if ((locala.dF == null) || (locala.dE != null)) {
      throw new IllegalStateException("must be in snapshot state to diff");
    }
    h localh1 = locala.dF;
    h localh2 = (h)paramh.at();
    locala.dA.eE.execute(new a.2(locala, localh1, localh2, i, paramh));
  }
  
  public final int getItemCount()
  {
    return this.eX.getItemCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.i
 * JD-Core Version:    0.7.0.1
 */