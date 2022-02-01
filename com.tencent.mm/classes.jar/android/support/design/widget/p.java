package android.support.design.widget;

import android.support.v4.view.u;
import android.view.View;

final class p
{
  private final View view;
  int wE;
  private int wF;
  int wG;
  int wH;
  
  public p(View paramView)
  {
    this.view = paramView;
  }
  
  public final boolean G(int paramInt)
  {
    if (this.wG != paramInt)
    {
      this.wG = paramInt;
      dy();
      return true;
    }
    return false;
  }
  
  public final void dx()
  {
    this.wE = this.view.getTop();
    this.wF = this.view.getLeft();
    dy();
  }
  
  final void dy()
  {
    u.s(this.view, this.wG - (this.view.getTop() - this.wE));
    u.u(this.view, this.wH - (this.view.getLeft() - this.wF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.p
 * JD-Core Version:    0.7.0.1
 */