package android.support.v7.widget;

final class RecyclerView$1
  implements Runnable
{
  RecyclerView$1(RecyclerView paramRecyclerView) {}
  
  public final void run()
  {
    if ((!this.agK.afO) || (this.agK.isLayoutRequested())) {
      return;
    }
    if (!this.agK.afL)
    {
      this.agK.requestLayout();
      return;
    }
    if (this.agK.afR)
    {
      this.agK.afQ = true;
      return;
    }
    this.agK.hn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.1
 * JD-Core Version:    0.7.0.1
 */