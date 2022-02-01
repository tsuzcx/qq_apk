package android.support.v7.widget;

import android.view.View;

final class ad
{
  boolean apL = true;
  int apM;
  int apN;
  int apO;
  int apP = 0;
  int apQ = 0;
  boolean apR;
  boolean apS;
  int mLayoutDirection;
  
  final View a(RecyclerView.o paramo)
  {
    paramo = paramo.cv(this.apN);
    this.apN += this.apO;
    return paramo;
  }
  
  final boolean b(RecyclerView.t paramt)
  {
    return (this.apN >= 0) && (this.apN < paramt.getItemCount());
  }
  
  public final String toString()
  {
    return "LayoutState{mAvailable=" + this.apM + ", mCurrentPosition=" + this.apN + ", mItemDirection=" + this.apO + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.apP + ", mEndLine=" + this.apQ + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.ad
 * JD-Core Version:    0.7.0.1
 */