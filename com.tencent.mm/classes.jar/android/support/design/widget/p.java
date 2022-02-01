package android.support.design.widget;

import android.support.v4.view.t;
import android.view.View;

final class p
{
  int tD;
  private int tE;
  int tF;
  int tG;
  private final View view;
  
  public p(View paramView)
  {
    this.view = paramView;
  }
  
  public final boolean G(int paramInt)
  {
    if (this.tF != paramInt)
    {
      this.tF = paramInt;
      cZ();
      return true;
    }
    return false;
  }
  
  public final void cY()
  {
    this.tD = this.view.getTop();
    this.tE = this.view.getLeft();
    cZ();
  }
  
  final void cZ()
  {
    t.s(this.view, this.tF - (this.view.getTop() - this.tD));
    t.u(this.view, this.tG - (this.view.getLeft() - this.tE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.p
 * JD-Core Version:    0.7.0.1
 */