package android.support.v7.widget;

final class RecyclerView$1
  implements Runnable
{
  RecyclerView$1(RecyclerView paramRecyclerView) {}
  
  public final void run()
  {
    if ((!this.aja.aie) || (this.aja.isLayoutRequested())) {
      return;
    }
    if (!this.aja.aib)
    {
      this.aja.requestLayout();
      return;
    }
    if (this.aja.aih)
    {
      this.aja.aig = true;
      return;
    }
    this.aja.iO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.1
 * JD-Core Version:    0.7.0.1
 */