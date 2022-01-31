package android.support.v7.widget;

final class at$1
  extends RecyclerView.m
{
  boolean amA = false;
  
  at$1(at paramat) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.amA = true;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.amA))
    {
      this.amA = false;
      this.amB.kt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.at.1
 * JD-Core Version:    0.7.0.1
 */