package android.arch.b;

import android.support.v7.h.c.c;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import java.util.concurrent.Executor;

public abstract class i<T, VH extends RecyclerView.w>
  extends RecyclerView.a<VH>
{
  private final a.a<T> dD = new a.a() {};
  private final a<T> eY;
  
  protected i(c.c<T> paramc)
  {
    this.eY = new a(this, paramc);
    this.eY.dD = this.dD;
  }
  
  public final void a(h<T> paramh)
  {
    a locala = this.eY;
    int i;
    if (paramh != null)
    {
      if ((locala.dF == null) && (locala.dG == null)) {
        locala.dE = paramh.am();
      }
    }
    else if (paramh != locala.dF)
    {
      i = locala.dH + 1;
      locala.dH = i;
      if (paramh != null) {
        break label131;
      }
      i = locala.getItemCount();
      if (locala.dF == null) {
        break label116;
      }
      locala.dF.a(locala.dI);
      locala.dF = null;
    }
    for (;;)
    {
      locala.dA.k(0, i);
      return;
      if (paramh.am() == locala.dE) {
        break;
      }
      throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
      label116:
      if (locala.dG != null) {
        locala.dG = null;
      }
    }
    label131:
    if ((locala.dF == null) && (locala.dG == null))
    {
      locala.dF = paramh;
      paramh.a(null, locala.dI);
      locala.dA.f(0, paramh.size());
      return;
    }
    if (locala.dF != null)
    {
      locala.dF.a(locala.dI);
      locala.dG = ((h)locala.dF.ar());
      locala.dF = null;
    }
    if ((locala.dG == null) || (locala.dF != null)) {
      throw new IllegalStateException("must be in snapshot state to diff");
    }
    h localh1 = locala.dG;
    h localh2 = (h)paramh.ar();
    locala.dB.eF.execute(new a.2(locala, localh1, localh2, i, paramh));
  }
  
  public final int getItemCount()
  {
    return this.eY.getItemCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.i
 * JD-Core Version:    0.7.0.1
 */