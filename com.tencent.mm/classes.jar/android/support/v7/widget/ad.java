package android.support.v7.widget;

import android.view.View;

final class ad
{
  boolean apX = true;
  int apY;
  int apZ;
  int aqa;
  int aqb = 0;
  int aqc = 0;
  boolean aqd;
  boolean aqe;
  int mLayoutDirection;
  
  final View a(RecyclerView.n paramn)
  {
    paramn = paramn.cq(this.apZ);
    this.apZ += this.aqa;
    return paramn;
  }
  
  final boolean a(RecyclerView.s params)
  {
    return (this.apZ >= 0) && (this.apZ < params.getItemCount());
  }
  
  public final String toString()
  {
    return "LayoutState{mAvailable=" + this.apY + ", mCurrentPosition=" + this.apZ + ", mItemDirection=" + this.aqa + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.aqb + ", mEndLine=" + this.aqc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.ad
 * JD-Core Version:    0.7.0.1
 */