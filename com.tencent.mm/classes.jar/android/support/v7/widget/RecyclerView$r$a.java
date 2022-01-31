package android.support.v7.widget;

import android.view.animation.Interpolator;

public final class RecyclerView$r$a
{
  private int ahF = 0;
  private int ahG = 0;
  int ahH = -1;
  private boolean ahI = false;
  private int ahJ = 0;
  private int mDuration = -2147483648;
  private Interpolator mInterpolator = null;
  
  public RecyclerView$r$a()
  {
    this((byte)0);
  }
  
  private RecyclerView$r$a(byte paramByte) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.ahF = paramInt1;
    this.ahG = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
    this.ahI = true;
  }
  
  final void e(RecyclerView paramRecyclerView)
  {
    int i;
    if (this.ahH >= 0)
    {
      i = this.ahH;
      this.ahH = -1;
      paramRecyclerView.bJ(i);
      this.ahI = false;
      return;
    }
    if (this.ahI)
    {
      if ((this.mInterpolator != null) && (this.mDuration <= 0)) {
        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      }
      if (this.mDuration <= 0) {
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
      if (this.mInterpolator == null) {
        if (this.mDuration == -2147483648)
        {
          paramRecyclerView = paramRecyclerView.agr;
          i = this.ahF;
          int j = this.ahG;
          paramRecyclerView.m(i, j, paramRecyclerView.au(i, j));
        }
      }
      for (;;)
      {
        this.ahJ += 1;
        this.ahI = false;
        return;
        paramRecyclerView.agr.m(this.ahF, this.ahG, this.mDuration);
        continue;
        paramRecyclerView.agr.b(this.ahF, this.ahG, this.mDuration, this.mInterpolator);
      }
    }
    this.ahJ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.r.a
 * JD-Core Version:    0.7.0.1
 */