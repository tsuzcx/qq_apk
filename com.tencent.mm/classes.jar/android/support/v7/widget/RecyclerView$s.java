package android.support.v7.widget;

import android.util.SparseArray;

public final class RecyclerView$s
{
  int ajQ = -1;
  private SparseArray<Object> aka;
  int akb = 0;
  int akc = 0;
  int akd = 1;
  int ake = 0;
  boolean akf = false;
  public boolean akg = false;
  boolean akh = false;
  boolean aki = false;
  boolean akj = false;
  boolean akk = false;
  int akl;
  long akm;
  int akn;
  int ako;
  int akp;
  
  final void ch(int paramInt)
  {
    if ((this.akd & paramInt) == 0) {
      throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.akd));
    }
  }
  
  public final int getItemCount()
  {
    if (this.akg) {
      return this.akb - this.akc;
    }
    return this.ake;
  }
  
  public final String toString()
  {
    return "State{mTargetPosition=" + this.ajQ + ", mData=" + this.aka + ", mItemCount=" + this.ake + ", mIsMeasuring=" + this.aki + ", mPreviousLayoutItemCount=" + this.akb + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.akc + ", mStructureChanged=" + this.akf + ", mInPreLayout=" + this.akg + ", mRunSimpleAnimations=" + this.akj + ", mRunPredictiveAnimations=" + this.akk + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.s
 * JD-Core Version:    0.7.0.1
 */