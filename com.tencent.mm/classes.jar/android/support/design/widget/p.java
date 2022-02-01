package android.support.design.widget;

import android.support.v4.view.t;
import android.view.View;

final class p
{
  private final View view;
  int wA;
  int wx;
  private int wy;
  int wz;
  
  public p(View paramView)
  {
    this.view = paramView;
  }
  
  public final boolean G(int paramInt)
  {
    if (this.wz != paramInt)
    {
      this.wz = paramInt;
      dv();
      return true;
    }
    return false;
  }
  
  public final void du()
  {
    this.wx = this.view.getTop();
    this.wy = this.view.getLeft();
    dv();
  }
  
  final void dv()
  {
    t.s(this.view, this.wz - (this.view.getTop() - this.wx));
    t.u(this.view, this.wA - (this.view.getLeft() - this.wy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.p
 * JD-Core Version:    0.7.0.1
 */