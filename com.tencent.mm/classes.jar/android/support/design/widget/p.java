package android.support.design.widget;

import android.support.v4.view.q;
import android.view.View;

final class p
{
  private final View mView;
  int mg;
  private int mh;
  int mi;
  int mj;
  
  public p(View paramView)
  {
    this.mView = paramView;
  }
  
  public final void bh()
  {
    this.mg = this.mView.getTop();
    this.mh = this.mView.getLeft();
    bi();
  }
  
  final void bi()
  {
    q.p(this.mView, this.mi - (this.mView.getTop() - this.mg));
    q.q(this.mView, this.mj - (this.mView.getLeft() - this.mh));
  }
  
  public final boolean q(int paramInt)
  {
    if (this.mi != paramInt)
    {
      this.mi = paramInt;
      bi();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.p
 * JD-Core Version:    0.7.0.1
 */