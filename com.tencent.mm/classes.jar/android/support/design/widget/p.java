package android.support.design.widget;

import android.support.v4.view.t;
import android.view.View;

final class p
{
  int uE;
  private int uF;
  int uG;
  int uH;
  private final View view;
  
  public p(View paramView)
  {
    this.view = paramView;
  }
  
  public final boolean G(int paramInt)
  {
    if (this.uG != paramInt)
    {
      this.uG = paramInt;
      dg();
      return true;
    }
    return false;
  }
  
  public final void df()
  {
    this.uE = this.view.getTop();
    this.uF = this.view.getLeft();
    dg();
  }
  
  final void dg()
  {
    t.s(this.view, this.uG - (this.view.getTop() - this.uE));
    t.u(this.view, this.uH - (this.view.getLeft() - this.uF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.p
 * JD-Core Version:    0.7.0.1
 */