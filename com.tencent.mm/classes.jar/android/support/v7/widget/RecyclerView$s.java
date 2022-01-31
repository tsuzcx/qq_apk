package android.support.v7.widget;

import android.util.SparseArray;

public final class RecyclerView$s
{
  int ahA = -1;
  private SparseArray<Object> ahK;
  int ahL = 0;
  int ahM = 0;
  int ahN = 1;
  int ahO = 0;
  boolean ahP = false;
  boolean ahQ = false;
  boolean ahR = false;
  boolean ahS = false;
  boolean ahT = false;
  boolean ahU = false;
  int ahV;
  long ahW;
  int ahX;
  int ahY;
  int ahZ;
  
  final void bZ(int paramInt)
  {
    if ((this.ahN & paramInt) == 0) {
      throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.ahN));
    }
  }
  
  public final int getItemCount()
  {
    if (this.ahQ) {
      return this.ahL - this.ahM;
    }
    return this.ahO;
  }
  
  public final String toString()
  {
    return "State{mTargetPosition=" + this.ahA + ", mData=" + this.ahK + ", mItemCount=" + this.ahO + ", mIsMeasuring=" + this.ahS + ", mPreviousLayoutItemCount=" + this.ahL + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.ahM + ", mStructureChanged=" + this.ahP + ", mInPreLayout=" + this.ahQ + ", mRunSimpleAnimations=" + this.ahT + ", mRunPredictiveAnimations=" + this.ahU + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.s
 * JD-Core Version:    0.7.0.1
 */