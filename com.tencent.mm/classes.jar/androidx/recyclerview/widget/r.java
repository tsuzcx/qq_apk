package androidx.recyclerview.widget;

import java.util.List;

public abstract class r<T, VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  private final d<T> ajB;
  
  protected r(h.c<T> paramc)
  {
    this.ajB = new d(new b(this), new c.a(paramc).kh());
  }
  
  public int getItemCount()
  {
    return this.ajB.afN.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.r
 * JD-Core Version:    0.7.0.1
 */