package android.support.design.widget;

import android.support.v4.view.t;
import android.view.View;

final class o
{
  private final View mView;
  int nd;
  private int ne;
  int nf;
  int ng;
  
  public o(View paramView)
  {
    this.mView = paramView;
  }
  
  public final void bS()
  {
    this.nd = this.mView.getTop();
    this.ne = this.mView.getLeft();
    bT();
  }
  
  final void bT()
  {
    t.q(this.mView, this.nf - (this.mView.getTop() - this.nd));
    t.s(this.mView, this.ng - (this.mView.getLeft() - this.ne));
  }
  
  public final boolean p(int paramInt)
  {
    if (this.nf != paramInt)
    {
      this.nf = paramInt;
      bT();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.o
 * JD-Core Version:    0.7.0.1
 */