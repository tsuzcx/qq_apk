package android.support.v7.widget;

import android.view.View;

final class ad
{
  boolean anT = true;
  int anU;
  int anV;
  int anW;
  int anX = 0;
  int anY = 0;
  boolean anZ;
  boolean aoa;
  int mLayoutDirection;
  
  final View a(RecyclerView.o paramo)
  {
    paramo = paramo.cv(this.anV);
    this.anV += this.anW;
    return paramo;
  }
  
  final boolean b(RecyclerView.t paramt)
  {
    return (this.anV >= 0) && (this.anV < paramt.getItemCount());
  }
  
  public final String toString()
  {
    return "LayoutState{mAvailable=" + this.anU + ", mCurrentPosition=" + this.anV + ", mItemDirection=" + this.anW + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.anX + ", mEndLine=" + this.anY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.ad
 * JD-Core Version:    0.7.0.1
 */