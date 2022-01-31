package android.support.v7.widget;

import android.view.View;

final class ad
{
  boolean afR;
  int afS;
  int afT;
  int afU;
  int afV;
  int afW;
  boolean afX;
  boolean afY;
  int mLayoutDirection;
  
  final View a(RecyclerView.o paramo)
  {
    paramo = paramo.cc(this.afT);
    this.afT += this.afU;
    return paramo;
  }
  
  final boolean b(RecyclerView.s params)
  {
    return (this.afT >= 0) && (this.afT < params.getItemCount());
  }
  
  public final String toString()
  {
    return "LayoutState{mAvailable=" + this.afS + ", mCurrentPosition=" + this.afT + ", mItemDirection=" + this.afU + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.afV + ", mEndLine=" + this.afW + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.ad
 * JD-Core Version:    0.7.0.1
 */