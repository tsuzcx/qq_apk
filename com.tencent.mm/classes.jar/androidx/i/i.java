package androidx.i;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.h.c;
import androidx.recyclerview.widget.s;
import java.util.concurrent.Executor;

public abstract class i<T, VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private final a.a<T> acP = new a.a() {};
  private final a<T> ael;
  
  protected i(h.c<T> paramc)
  {
    this.ael = new a(this, paramc);
    this.ael.acP = this.acP;
  }
  
  public final void a(h<T> paramh)
  {
    a locala = this.ael;
    int i;
    if (paramh != null)
    {
      if ((locala.acR == null) && (locala.acS == null)) {
        locala.acQ = paramh.jy();
      }
    }
    else
    {
      i = locala.acT + 1;
      locala.acT = i;
      if (paramh != locala.acR)
      {
        if (paramh != null) {
          break label131;
        }
        i = locala.getItemCount();
        if (locala.acR == null) {
          break label116;
        }
        locala.acR.a(locala.acU);
        locala.acR = null;
      }
    }
    for (;;)
    {
      locala.acM.ac(0, i);
      return;
      if (paramh.jy() == locala.acQ) {
        break;
      }
      throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
      label116:
      if (locala.acS != null) {
        locala.acS = null;
      }
    }
    label131:
    if ((locala.acR == null) && (locala.acS == null))
    {
      locala.acR = paramh;
      paramh.a(null, locala.acU);
      locala.acM.W(0, paramh.size());
      return;
    }
    if (locala.acR != null)
    {
      locala.acR.a(locala.acU);
      locala.acS = ((h)locala.acR.jD());
      locala.acR = null;
    }
    if ((locala.acS == null) || (locala.acR != null)) {
      throw new IllegalStateException("must be in snapshot state to diff");
    }
    h localh1 = locala.acS;
    h localh2 = (h)paramh.jD();
    locala.acN.adS.execute(new a.2(locala, localh1, localh2, i, paramh));
  }
  
  public final int getItemCount()
  {
    return this.ael.getItemCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.i.i
 * JD-Core Version:    0.7.0.1
 */