package androidx.paging;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g.c;

public abstract class aq<T, VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private final e.a<T> bKO = new e.a() {};
  public final e<T> bPV;
  
  protected aq(g.c<T> paramc)
  {
    this.bPV = new e(this, paramc);
    this.bPV.bKO = this.bKO;
  }
  
  public final int getItemCount()
  {
    return this.bPV.getItemCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.aq
 * JD-Core Version:    0.7.0.1
 */